package clinic.steps;
import clinic.main.*;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class patientAddAppSteps {
    static String username,date,time;
    int result=0;
    
	  public patientAddAppSteps()
	  {
	  }
      
	@Given("we have patient appointements table.")
	public void we_have_patient_appointements_table(io.cucumber.datatable.DataTable dataTable) {
		if(PatientMethods.getPatients().get(0).getAppointments().size()==0)
		{
			for(int i=0;i<3;i++)
			{
				Appointment a=new Appointment(dataTable.cell(i, 1),dataTable.cell(i, 2),0,AdminMethods.getServices().get(i));
				PatientMethods.getAppointments().add(a);
				int index=PatientMethods.search(dataTable.cell(i,0));
				PatientMethods.getPatients().get(index).addToPatientApp(a);
			}
		}
	}

	@Given("that the patient {string} is logged in")
	public void that_the_patient_is_logged_in(String string) {
		username = string;
	
	}

	@Given("the wanted date {string} and time {string} is available")
	public void the_wanted_date_and_time_is_available(String string, String string2) {
		date= string; 
		time= string2;
		result= PatientMethods.checkAvailability(date, time);
	}
	
	@Then("the date and time are available to be added")
	public void the_date_and_time_are_available_to_be_added() {
		assertEquals("Date and Time are not available",1,result);
		
	}

	
	@Then("the appointment is added to the patient's information")
	public void the_appointment_is_added_to_the_patient_s_information() {
	    // Write code here that turns the phrase above into concrete actions
		Appointment a=new Appointment(date,time,0);
		PatientMethods.addAppointment(username, a);
	}
	
	
	@Given("the wanted date {string} and time {string} is unavailable")
	public void the_wanted_date_and_time_is_unavailable(String string, String string2) {
		date= string; 
		time= string2;
		
		result= PatientMethods.checkAvailability(date, time);
	}

	@Then("the date is not added to the patient's appointements")
	public void the_date_is_not_added_to_the_patient_s_appointements() {
		assertEquals("Date and time are available",-1,result);		
	}


}
