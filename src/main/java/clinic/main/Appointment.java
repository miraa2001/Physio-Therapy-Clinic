package clinic.main;

public class Appointment {
	private String date;
	private String time;	
	Service service;
	private int status;//0 booked, 1 visited
	public Appointment(String d,String t,int i)
	{
		this.setDate(d);
		this.setTime(t);
		this.setStatus(i);
		this.setService(AdminMethods.getServices().get(0));
	}
	public Appointment(String d,String t,int i,Service s)
	{
		this.setDate(d);
		this.setTime(t);
		this.setStatus(i);
		this.setService(s);
	}
	public void setService( Service s){
		service = s;
	}
	
	public Service getService(){
		return service;
		
	}
	public void setStatus(int i){
		this.status = i;
	}
	
	public int getStatus(){
		return this.status;
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString()
	{
		return "Date: "+date + "  Time: " + time + "  Status: "+(status==1?"Visited":"Pending")+"  Service: "+
				this.service.getName()+"  Price: "+this.service.getPrice()+"NIS";
	}
	

}
