package telnet.TelnetConection;

public class Device {
	private String host;
	private String userName;
	private String  password;
	private String writeCommunty;
	private String readCommunty;
	private String snmpIp;

	public Device(String host, String userName, String password,String writeCommunty,String readCommunty) {
		super();
		this.host = host;
		this.userName = userName;
		this.password = password;
		this.readCommunty=readCommunty;
		this.writeCommunty=writeCommunty;
	}
	public Device(String host, String user, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.host = host;
		this.userName = user;
		this.password = password;

	}
	public String getSnmpIp() {
		return snmpIp;
	}
	public void setSnmpIp(String snmpIp) {
		this.snmpIp = snmpIp;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getWriteCommunty() {
		return writeCommunty;
	}
	public void setWriteCommunty(String writeCommunty) {
		this.writeCommunty = writeCommunty;
	}
	public String getReadCommunty() {
		return readCommunty;
	}
	public void setReadCommunty(String readCommunty) {
		this.readCommunty = readCommunty;
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
