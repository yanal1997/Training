package telnet.TelnetConection;

public class Device {
	private String host;
	private String userName;
	private String  password;
	public Device(String host, String userName, String password) {
		super();
		this.host = host;
		this.userName = userName;
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
