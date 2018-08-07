package telnet.TelnetConection;

import org.testng.annotations.Test;

public class AclTest {
	@Test
	public void aclTest() {
		Device device = new Device("10.63.10.213", "lab", "lab");
		// deleteAllAclList(device);
		String acl = "aaaa";
		// creatAcl(device, acl);
		findAllAclList(device);
		System.out.println("have acl list with '" + acl + "' name " + aclVerification(acl, device));

	}

	public void creatAcl(Device device, String name) {
		name = "ip access-list standard " + name;
		getOutputFromDevice(device, "configure terminal");
		getOutputFromDevice(device, name);
		getOutputFromDevice(device, "exit");
		getOutputFromDevice(device, "exit");
	}

	public void deleteAllAclList(Device device) {
		String[] lists = findAllAclList(device);
		getOutputFromDevice(device, "configure terminal");

		for (int i = 2; i < lists.length - 1; i++) {

			getOutputFromDevice(device, "configure terminal");
			getOutputFromDevice(device, "no ip access-list standard " + lists[i]);

		}
		getOutputFromDevice(device, "exit");
	}

	public String[] findAllAclList(Device device) {
		String output = getOutputFromDevice(device, "show access-lists | inc Stand");
		System.out.println("output from device:" + output);
		String[] stringWithSpace = output.split("\n");
		for (int i = 2; i < stringWithSpace.length - 1; i++) {
			stringWithSpace[i] = stringWithSpace[i].substring(stringWithSpace[i].lastIndexOf(" "));
		}
		return stringWithSpace;
	}

	public String getOutputFromDevice(Device device, String command) {
		TelnetConnection telnet = new TelnetConnection();
		telnet.connect(device);
		String result = telnet.sendCommand(command);
		telnet.disconnect();
		return result;
	}

	public boolean aclVerification(String name, Device device) {
		String[] aclLists = findAllAclList(device);
		for (int i = 0; i < aclLists.length; i++) {
			if (aclLists[i].contains(name)) {
				return true;
			}
		}
		return false;
	}
}
