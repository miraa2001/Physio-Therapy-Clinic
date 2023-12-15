package clinic.main;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User{
	private Boolean logState=false;
	private List<Appointment> appointments=new ArrayList<>();
	private List<Appointment> appointmentRecords=new ArrayList<>();
	private List<Appointment> visitsRecords=new ArrayList<>();
	public Patient(String s1,String s2,String s3)
	{
		super(s1,s2,s3);
	}
	@Override
	public String toString()
	{
		return super.getName()+ " ";
	}
	public Boolean getLogState() {
		return logState;
	}
	public void setLogState(Boolean logStatee) {
		this.logState = logStatee;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void addToPatientApp(Appointment a)
	{
		appointments.add(a);
	}
	public void removeAppointment(int i)
	{
		this.appointments.remove(i);
	}
	public void addToVisitsRecord(Appointment a)
	{
		this.visitsRecords.add(a);
	}
	public void resortAppointmentRecords()
	{
		this.appointmentRecords.removeAll(appointmentRecords);
		this.visitsRecords.removeAll(visitsRecords);
		for(int i=0;i<this.appointments.size();i++)
		{
			if(this.appointments.get(i).getStatus()==0)
			{
				this.appointmentRecords.add(this.appointments.get(i));
			}
			else
				this.visitsRecords.add(this.appointments.get(i));
		}
	}
	public List<Appointment> getVisitsRecords() {
		return visitsRecords;
	}
}
