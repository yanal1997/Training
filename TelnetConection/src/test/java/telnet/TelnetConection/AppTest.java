package telnet.TelnetConection;

import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */

public class AppTest {

	// Device device;


	@Test
	public void upgradeSoftwareImage() throws InterruptedException {// upgradeSoftwareImage
		int timeout=6000000;

		final Device device = new Device("10.63.10.213", "lab", "lab");
		String runningImageName = getRunningImage(device);
		System.out.println("runningImageName is:" + runningImageName);
		
		String newImage=getNewImage(runningImageName);
		System.out.println("the new image to distribute is: "+newImage);
		
		
		
		if (!isImageOnDevice(device, newImage)) {
			System.out.println("is the new image in device " + true);
			TelnetConnection telnetConnection=new TelnetConnection();
			telnetConnection.connect(device);
			telnetConnection.sendCommand("copy ftp://cisco:cisco@10.63.10.94/"+newImage+" flash:");
			telnetConnection.disconnect();
		
		}
		System.out.println(newImage+"***");
		runNewImage(newImage, device);
		waitUntilDeviceUp(device, timeout);
				   runningImageName = getRunningImage(device);
					System.out.println("(after update) running Image Name is:" + runningImageName);
			  

			
			
		
		
		
		
		
		
		}
		
		
		
		

		private void waitUntilDeviceUp(Device device, int timeout) throws InterruptedException  {
			long time=10000;
		// TODO Auto-generated method stub
			TelnetConnection connect=new TelnetConnection();
int i=0;
       Thread.sleep(10000);
		while(timeout>0){
			try {

			if(	connect.connect(device)){
				connect.disconnect();
            break;
           
				
			}
				
			} 
			
			catch (Exception e) {
				// TODO: handle exception
		
					Thread.sleep(time);

				
				timeout-=time;
				

				
			}		 i++; }

	}

		/*
		 * String subClass; int firstCotation,secondCotation,dot;
		 * telnetConnection.sendCommand("show version"); String
		 * className=telnetConnection.sendCommand(" ");
		 * 
		 * firstCotation=className.indexOf('"');
		 * secondCotation=className.lastIndexOf('"');
		 * 
		 * subClass=className.substring(firstCotation+1, secondCotation);
		 * dot=subClass.indexOf(':'); subClass=subClass.substring(dot+1);
		 * telnetConnection.sendCommand("^z");
		 */
		// if(getRunningImageOnDevice()){
		// System.out.println("hi");
		// telnetConnection.sendCommand("verify flash bootflash:"+newImage);
		// System.out.println(telnetConnection.sendCommand("configure
		// terminal"));
		// telnetConnection.sendCommand("no boot system");
		// telnetConnection.sendCommand("boot system flash:"+newImage);
		// telnetConnection.sendCommand("write memory");
		// telnetConnection.sendCommand("reload");

	

	// create method: getRunningImageOnDevice(device1)

	public boolean isImageOnDevice(Device device, String newImage) {
		TelnetConnection telnetConnection2 = new TelnetConnection();

		telnetConnection2.connect(device);

		telnetConnection2.sendCommand("dir flash:");
		String sizeOfFile;

		telnetConnection2.sendCommand(" ");
		String stringOfCmd = telnetConnection2.sendCommand(" ");
		if (stringOfCmd.indexOf(newImage) != -1) {
			sizeOfFile = stringOfCmd.substring(stringOfCmd.indexOf(newImage) - 60, stringOfCmd.indexOf(newImage) + 60)
					.substring(20, 28);
			telnetConnection2.disconnect();
			if (Integer.parseInt(sizeOfFile) != 0) {
				return true;
			} else {
				return false;
			}
		} else {
			telnetConnection2.disconnect();

			return false;
		}
	}

	public String getRunningImage(Device device) {
		TelnetConnection telnetConnection = new TelnetConnection();
		telnetConnection.connect(device);
		String subClass;
		int firstCotation, secondCotation, dot;
		telnetConnection.sendCommand("show version");
		String className = telnetConnection.sendCommand(" ");

		firstCotation = className.indexOf('"');
		secondCotation = className.lastIndexOf('"');

		subClass = className.substring(firstCotation + 1, secondCotation);
		dot = subClass.indexOf(':');
		subClass = subClass.substring(dot + 1);
		telnetConnection.disconnect();
		return subClass;
	}

	public void runNewImage(String newImage, Device device) {


		TelnetConnection telnetConnection3 = new TelnetConnection();
		telnetConnection3.connect(device);
		// telnetConnection3.sendCommand("verify flash:"+newImage);
		telnetConnection3.sendCommand("configure terminal");
		telnetConnection3.sendCommand("no boot system");
		telnetConnection3.sendCommand("boot system flash bootflash:" + newImage);
		telnetConnection3.sendCommand("end");
		System.out.println(telnetConnection3.sendCommand("write memory"));
		Scanner scanner = new Scanner(System.in);
		String  confirm=scanner.nextLine();
		telnetConnection3.sendCommand(confirm);
System.out.println("*****************************************************************************************");
	System.out.println(	telnetConnection3.sendCommand("reload"));
	confirm=scanner.nextLine();

		telnetConnection3.sendCommand(confirm);
		System.out.println("done");
		
		telnetConnection3.disconnect();
	}
	public String getNewImage(String runningImage){
		String image = "asr1000rp1-adventerprisek9.03.16.07b.S.155-3.S7b-ext";
		String image2="asr1000rp1-adventerprisek9.03.13.09.S.154-3.S9-ext";
		runningImage=runningImage.substring(0,runningImage.lastIndexOf("."));
		if(image.contains(runningImage)){
			return image2+".bin";
		}
		else{
			return image+".bin";
		}
	}

}
