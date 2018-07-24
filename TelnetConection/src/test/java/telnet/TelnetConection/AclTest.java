package telnet.TelnetConection;

import org.testng.annotations.Test;

public class AclTest {
	@Test
	public void aclTest() {
		Device device = new Device("10.63.10.213", "lab", "lab");
		findAclList("4", device);
		TelnetConnection telnet = new TelnetConnection();
		telnet.connect(device);
		String result = telnet.sendCommand("show  access-list");
		System.out.println(result);
		telnet.disconnect();
	}

	public void aclConfiguration(int numberOfruls, Device device) {

		TelnetConnection telnet = new TelnetConnection();
		telnet.connect(device);
		telnet.sendCommand("configure terminal");
		telnet.sendCommand("access-list template " + numberOfruls);
		telnet.sendCommand("exit");
		telnet.disconnect();

	}

	public void creatAcl(Device device, String ip) {
		TelnetConnection telnet = new TelnetConnection();
		telnet.connect(device);
		telnet.sendCommand("configure terminal");
		telnet.sendCommand("access-list " + ip + " permit any");
		telnet.sendCommand("exit");
		telnet.disconnect();

	}

	public void deletAclList(Device device, String aclListIP) {
		TelnetConnection telnet = new TelnetConnection();
		telnet.connect(device);
		telnet.sendCommand("configure terminal");

		telnet.sendCommand("no access-list " + aclListIP + " permit any");
		telnet.disconnect();

	}

	public void findAclList(String aclListIp, Device device) {
		TelnetConnection telnet = new TelnetConnection();
		telnet.connect(device);
		String string = telnet.sendCommand("show access-list");
		int exist = string.indexOf("Standard IP access list " + aclListIp);
		telnet.disconnect();
		if (exist == -1) {
			creatAcl(device, aclListIp);
		} else {
			deletAclList(device, aclListIp);

		}
	}

}
