package telnet.TelnetConection;

public class TimeUpInMinutes {
	int day;
	int minute;
	int hours;
	int totalTime;
	public TimeUpInMinutes() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	public String TimeFormSnmp(String time){
		if(time.contains("day")){
		day=Integer.parseInt(time.substring(1,time.indexOf(" day")));
		day=day*24*60;
		}
		hours=Integer.parseInt(time.substring(1,time.indexOf(":")));
		hours=hours*60;
		minute=Integer.parseInt(time.substring(time.indexOf(":")+1, time.lastIndexOf(":")));
	totalTime=hours+minute;
	return totalTime+"";
	}
	public String TimeFromTelnet(String time){
		if(time.contains("day")){
		day=Integer.parseInt(time.substring(time.indexOf(" is "),time.indexOf(" day")));
		day=day*24*60;
	
		hours=Integer.parseInt(time.substring(time.indexOf("day, ")+1,time.indexOf(" hours,")));
		hours=hours*60;
		minute=Integer.parseInt(time.substring(time.indexOf(" hours,  ")+1, time.indexOf("\n")));
		totalTime=hours+minute+day;
		return totalTime+"";}
		else{
			hours=Integer.parseInt(time.substring(time.indexOf("Omar uptime is")+15,time.indexOf(" hours,")));
			hours=hours*60;
			minute=Integer.parseInt(time.substring(time.indexOf("hours, ")+7, time.lastIndexOf(" ")));
			totalTime=hours+minute+day;
			return totalTime+"";
		}
	}
	
}
