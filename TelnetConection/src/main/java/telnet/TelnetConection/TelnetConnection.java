package telnet.TelnetConection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

public class TelnetConnection {

	private TelnetClient telnet = new TelnetClient();

	private BufferedInputStream input;
	private PrintStream output; // output stream
	private final int waitTime = 500; // wait time response from reader, in ms
	private String command;
	private final String promptMessRev = "LLRPAccessSpecCount";
	private final String promptNumROS = "LLRPROSpecCount='";
	private final String promptStatusROS = "LLRPROSpec1='";

	// ===================================
	public TelnetConnection() {
		super();
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * Connect to reader
	 * 
	 * @param userName
	 *            : The user name for login
	 * @param password
	 *            : The password for login
	 * @param IPReader
	 *            : IP address of reader
	 * @return boolean. connect OK or Fail
	 * @throws IOException
	 *             Any problems during connect
	 * @author ThangLe
	 */
	
	boolean connect(Device device) {
		return connect(device.getHost(),device.getUserName(), device.getPassword());
	}
	
	boolean connect(String IPReader, String userName, String password) {
		try {

			if (telnet != null && telnet.isConnected()) {
				System.out.println("telnet !=null");
				telnet.disconnect();
			}
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.flush();
				output.close();
			}

			// Connect to the specified server
			telnet.setConnectTimeout(5000);// Timeout 5s
			telnet.connect(IPReader, 23);

			// Get input and output stream references
			input = new BufferedInputStream(telnet.getInputStream());
			output = new PrintStream(telnet.getOutputStream());

			Thread.sleep(waitTime); // wait for responding from reader
			// Log the user on
			if (readUntil("Username: ") == null) {
				System.out.println("username ==null");
				return false;
			}
			write(userName);
			Thread.sleep(waitTime); // wait for responding from reader
			if (readUntil("Password: ") == null) {
				System.out.println("password==null");
				return false;
			}
			write(password);
			Thread.sleep(waitTime); // wait for responding from reader
			// Advance to a prompt
			// readUntil(prompt + " ");
			return true; // connect OK
		} catch (Exception e) {
			
			return false; // connect fail
		}
	}

	// ================================
	/*
	 * 
	 */
	String readUntil(String pattern) {
		StringBuffer sb = new StringBuffer();

		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			int numRead = 0;

			if (input.available() <= 5) {// reader always returns more 5 chars
				return null;
			}
			char ch = (char) input.read();

			while (true) {
				// System.out.print(ch);
				numRead++;
				sb.append(ch);

				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}

				if (input.available() == 0) {
					break;
				}
				ch = (char) input.read();

				if (numRead > 2000) {
					break; // can not read the pattern
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(sb);

		return  sb.toString();
	}

	// =================================
	void write(String value) {
		try {
			output.println(value);
			output.flush();
			// System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ==================================
	void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String sendCommand(String command) {
		try {
			write(command);
			Thread.sleep(waitTime); // wait for responding from reader
			return readUntil(promptMessRev);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
