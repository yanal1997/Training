package telnet.TelnetConection;

public class b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelnetConnection t=new TelnetConnection();
		Device d=new Device("10.63.10.213", "lab", "lab");
		TelnetConnection t2=new TelnetConnection();

		while(true){
     System.out.println(t.connect(d));
		}
	}
	

}
