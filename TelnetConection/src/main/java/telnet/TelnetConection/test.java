package telnet.TelnetConection;

import java.util.Scanner;

public class test {

	 private static Scanner scanner;

	public static void main(String[] args) {
		 try {
	        	String host,userName,password,command = null;
	        	System.out.println("enter host :");
	        	scanner = new Scanner(System.in);
				host=scanner.nextLine();
	        	System.out.println("enter user name:");
	        	userName=scanner.nextLine();
	        	System.out.println("enter password:");
	        	password=scanner.nextLine();
	        			
	            TelnetConnection telnet = new TelnetConnection();
	        if(telnet.connect(host, userName, password)) {
	        	System.out.println("connected");
	        	System.out.println("*********************************");
	        	System.out.println("enter command:");
	        	command=scanner.nextLine();
	        }else{
	        	System.err.println("connection failed!!!!!!!!!!!!!!!!");
	        }
	         while(!command.equals("close")){
	        	System.out.println( telnet.sendCommand(command));
	        	 System.out.println("*********************************");
		        	System.out.println("enter command:");

	        	 command=scanner.nextLine();
	        	 
	         }
	         telnet.disconnect();
	         System.out.println("*********************************");

	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
}
