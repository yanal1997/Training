package ssh_connection.Ssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		String host, userName, password, command;
		System.out.println("hi");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter host name");
		host = in.readLine();
		System.out.println("enter user name");
		userName = in.readLine();
		System.out.println("enter password");
		password = in.readLine();
		SshConnection connection = new SshConnection(host, userName, password);
		connection.connected();
		System.out.println("enter command:");
		command = in.readLine();
		connection.setCommand(command);
		while(!command.equals("close")){
			connection.command();
			System.out.println("************************************************");
			System.out.println("");
			System.out.println("enter command");
			command = scanner.next();
			connection.setCommand(command);
			
		}
		connection.disconnect();
		scanner.close();
	}

	
}
