package clinic.steps;

import static org.junit.Assert.assertTrue;

import clinic.main.*;
import io.cucumber.java.en.*;
public class patientAddServiceSteps {
	String username,date,time;
	Service s;
	Boolean appB=false;
	Boolean serviceB=false;
	int index=-1;
	int appIndex=-1;
	@Given("that the  patient {string} is logged in")
	public void that_the_patient_is_logged_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	     username=string;
	}
	@Given("has booked an appointment with date {string} and time {string}")
	public void has_booked_an_appointment_with_date_and_time(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    date=string;
	    time=string2;
	    index=PatientMethods.search(username);
	    appB=false;
	    for(int i=0;i<PatientMethods.getPatients().get(index).getAppointments().size();i++)
	    {
	    	if( date.equals(PatientMethods.getPatients().get(index).getAppointments().get(i).getDate()) && 
	    			time.equals(PatientMethods.getPatients().get(index).getAppointments().get(i).getTime()) 
	    	  )
    		{
    			appIndex=i;
	    		appB=true;
    			break;
    		}
				
	    }
	}

	@Given("the service name is {string} with price {double}")
	public void the_service_name_is_with_price(String string, Double double1) {
	    // Write code here that turns the phrase above into concrete actions
	    s=new Service(string,double1);
	    serviceB=false;
	    for(int i=0;i<AdminMethods.getServices().size();i++)
	    {
	    	if(string.equalsIgnoreCase(AdminMethods.getServices().get(i).getName())&&
	    	   (double1==AdminMethods.getServices().get(i).getPrice()) 
	    	   )
    		{
    			serviceB=true;
    			break;
    		}
	    		
	    }
	}

	@When("patient tries to add the service to his appointment")
	public void patient_tries_to_add_the_service_to_his_appointment() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("the service can be chosen")
	public void the_service_can_be_chosen() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue("The appointment or the service does not exist,therefore the service cannot be added",(serviceB&&appB));	     
	}

	@Then("the service is added to the patient's appointment")
	public void the_service_is_added_to_the_patient_s_appointment() {
	    // Write code here that turns the phrase above into concrete actions
		PatientMethods.getPatients().get(index).getAppointments().get(appIndex).setService(s);
	}

}
