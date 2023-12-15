package clinic.steps;

import static org.junit.Assert.assertEquals;

import clinic.main.PatientMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class patientRemoveAppSteps {
	
	String username,date,time;
	int result= 0;
  
	
	public patientRemoveAppSteps ()
	{
	}
	@Given("that the patient  {string} is logged in")
	public void that_the_patient_is_logged_in(String string) {
		username=string;
	}

	@Given("the entered date is {string} and time is {string}")
	public void the_entered_date_is_and_time_is(String string, String string2) {
	    date=string;
	    time=string2;
	}

	@Given("the date and time exist in the patient's appointment's")
	public void the_date_and_time_exist_in_the_patient_s_appointment_s() {
	   result = PatientMethods.checkRemoveAvailability(username,date,time);
	}

	@Then("the date and time can be removed")
	public void the_date_and_time_can_be_removed() {
	   assertEquals("Date and Time do not exist and cannot be removed",-1,result);
	}

	@Then("the date and time are removed")
	public void the_date_and_time_are_removed() {
		PatientMethods.removeAppointment(username,date,time);
	}

	@Given("the date and time do not exist in the patient's appointment's")
	public void the_date_and_time_do_not_exist_in_the_patient_s_appointment_s() {
		result = PatientMethods.checkRemoveAvailability(username,date,time);
	}

	@Then("the date and time can not be removed")
	public void the_date_and_time_can_not_be_removed() {
		assertEquals("Date and Time can be removed",1,result);
	}

	@Then("the date and time are not removed")
	public void the_date_and_time_are_not_removed() {
	    
	}

}
