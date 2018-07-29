package SNMP.SNMP;

import java.util.Scanner;

public class Drive {
	public static void main(String[] args)

	{

		try

		{
			String ip,oid="5";
			App smnp=new App();
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter IP for router:");
			ip=scanner.next();
			smnp.setIp(ip);
			while(!oid.equals("end")){
				System.out.println("enter oid:");
				oid=scanner.next();
				if(oid.equals("end")){
					System.out.println("good bye");
					continue;
				}
				smnp.setOid(oid);
				System.out.println("*********************************************************");
			}

			



		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

}
