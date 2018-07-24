package telnet.TelnetConection;

public class Ms {
	public void main(String []args) throws InterruptedException{
		Device d=new Device("10.63.10.213", "lab", "lab");
		waitUntilDeviceUp(d, 600000);
		
	}
	private void waitUntilDeviceUp(Device device, int timeout) throws InterruptedException  {
		long time=10000;
	// TODO Auto-generated method stub
		TelnetConnection connect=new TelnetConnection();

	while(timeout>0){
		try {
			//Thread.sleep(4000);
		if(	connect.connect(device)){
			connect.disconnect();
        break;
       
			
		}
			
		} catch (Exception e) {
			// TODO: handle exception
	
				Thread.sleep(time);

			
			timeout-=time;
			

			
		}		  }

}
}
