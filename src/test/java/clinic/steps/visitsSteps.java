package clinic.steps;
import static org.junit.Assert.assertEquals;
import clinic.main.*;
import io.cucumber.java.en.*;
public class visitsSteps {
	String username;
	String date;
	String time;
	int result=0;
	@Given("that the patient {string} is logged in to the system")
	public void that_the_patient_is_logged_in_to_the_system(String string) {
	      username=string;
	}

	@Given("the date {string} and time {string} of the appointment have passed")
	public void the_date_and_time_of_the_appointment_have_passed(String string, String string2) {
	     date=string;
	     time=string2;
	     result=PatientMethods.checkIfAppointmentPassed(date,time);
	}

	@Then("the appointment is turned into a visit")
	public void the_appointment_is_turned_into_a_visit() {  
		assertEquals("The appointment has not passed yet",1,result);
		
	}

	@Then("it is stored in the patient's record")
	public void it_is_stored_in_the_patient_s_record() { 
		PatientMethods.changeAppointmentToVisit(username,date,time);
		PatientMethods.getPatients().get(PatientMethods.search(username)).addToVisitsRecord(new Appointment(date,time,0));
	}
}
