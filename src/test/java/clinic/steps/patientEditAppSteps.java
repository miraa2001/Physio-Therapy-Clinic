package clinic.steps;
import static org.junit.Assert.assertEquals;


import clinic.main.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class patientEditAppSteps {
	static String username,oldDate,newDate,oldTime,newTime;
    int result=0;
	  
    
    @Given("that  the patient {string} is logged in")
    public void that_the_patient_is_logged_in(String string) {
        username= string;
    }

    
	@Given("we have date {string} and time {string} in our system")
	public void we_have_date_and_time_in_our_system(String string, String string2) {
		oldDate=string;
		oldTime=string2;
	}

	@Given("the new entered date {string} and time {string} are available")
	public void the_new_entered_date_and_time_are_available(String string, String string2) {
		newDate=string;
		newTime=string2;
		result=PatientMethods.checkAvailability(newDate,newTime);
	}

	@Then("the date and time can be edited")
	public void the_date_and_time_can_be_edited() {
		assertEquals("Date and Time cannot be edited",1,result);
	   
	}
	@Then("the date and time are edited")
	public void the_date_and_time_are_edited() {
		PatientMethods.editAppointment(username,oldDate,newDate,oldTime,newTime);
	    
	}

	@Given("the new entered date {string} and time {string} are unavailable")
	public void the_new_entered_date_and_time_are_unavailable(String string, String string2) {
		newDate=string;
		newTime=string2;
		result=PatientMethods.checkAvailability(newDate,newTime);
	}

	@Then("the date and time can not be edited")
	public void the_date_and_time_can_not_be_edited() {
		assertEquals("Date and Time can be edited",-1,result);
	  
	}
	@Then("the date and time are not edited")
	public void the_date_and_time_are_not_edited() {
	  
	}
	

}
