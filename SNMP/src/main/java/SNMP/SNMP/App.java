package SNMP.SNMP;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class App {

	public static final String READ_COMMUNITY = "public";

	public static final String WRITE_COMMUNITY = "public";

	private String oid;
	private String ip;

	public App(String ip, String oid) {
		super();
		this.oid = oid;
		this.ip = ip;
		 snmpGet();
	}

//	public static final int mSNMPVersion = 0; // 0 represents SNMP version=1

	public String snmpGet()

	{

		String str = "";

		try

		{

			OctetString community1 = new OctetString(READ_COMMUNITY);

			ip = ip + "/" + 161;

			Address targetaddress = new UdpAddress(ip);

			TransportMapping transport = new DefaultUdpTransportMapping();

			transport.listen();

			CommunityTarget comtarget = new CommunityTarget();

			comtarget.setCommunity(community1);

			comtarget.setVersion(SnmpConstants.version1);

			comtarget.setAddress(targetaddress);

			comtarget.setRetries(2);

			comtarget.setTimeout(5000);

			PDU pdu = new PDU();

			ResponseEvent response;

			Snmp snmp;

			pdu.add(new VariableBinding(new OID(oid)));

			pdu.setType(PDU.GET);

			snmp = new Snmp(transport);

			response = snmp.get(pdu, comtarget);

			if (response != null)

			{

				if (response.getResponse().getErrorStatusText().equalsIgnoreCase("Success"))

				{

					PDU pduresponse = response.getResponse();

					str = pduresponse.getVariableBindings().firstElement().toString();

					if (str.contains("="))

					{

						int len = str.indexOf("=");

						str = str.substring(len + 1, str.length());

					}

				}

			}

			else

			{

				System.out.println("Feeling like a TimeOut occured ");

			}

			snmp.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
 
		System.out.println(str);
		return str;

	}

}