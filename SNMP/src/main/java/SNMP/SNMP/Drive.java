package SNMP.SNMP;

public class Drive {
	public static void main(String[] args)

	{

		try

		{

			String ip = "10.63.10.213";
			String oid=".1.3.6.1.4.1.9.3.6.3.0";

			App objSNMP = new App(ip, oid);


		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

}
