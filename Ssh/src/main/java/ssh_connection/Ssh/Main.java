package ssh_connection.Ssh;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String host,userName,password,command;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter host name");
		host=scanner.next();
		System.out.println("enter user name");
		userName=scanner.next();
		System.out.println("enter password");
		password=scanner.next();
		System.out.println("enter command");
		command=scanner.next();
		SshConnection connection=new SshConnection(host, userName, password, command);
	}
	public static void getUserInformation(){

		

		
		
	}

}
