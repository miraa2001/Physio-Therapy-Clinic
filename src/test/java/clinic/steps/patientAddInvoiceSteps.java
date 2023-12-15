package clinic.steps;

import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;

import clinic.main.*;
import clinic.main.PatientMethods;
import io.cucumber.java.en.*;

public class patientAddInvoiceSteps {
	String username,date,time;
	int checkedStatus=-1;
	int index;
	Boolean appB=false;
	int appIndex=-1;
	Boolean result=false;
	@Given("that the patient {string} is logged  in")
	public void that_the_patient_is_logged_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    username=string;
	}

	@Given("they have an appointment with date {string} and time is {string}")
	public void they_have_an_appointment_with_date_and_time_is(String string, String string2) {
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

	@Given("its status is {int}")
	public void its_status_is(Integer int1) {
		if(appB)
		{
			if(PatientMethods.getPatients().get(index).getAppointments().get(appIndex).getStatus()==1)
		    	result=true;
		    else
		    	result=false;
		}
		else
			result=false;
	}
	@When("the patient tries to add the invoice")
	public void the_patient_tries_to_add_the_invoice() {
	    // Write code here that turns the phrase above into concrete actions 
	}

	@Then("the invoice can be generated")
	public void the_invoice_can_be_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue("The invoice cannot be generated",result);
	}

	@Then("the invoice is generated")
	public void the_invoice_is_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    Appointment a=new Appointment("1/11/2022","11:00",1,AdminMethods.getServices().get(2));
	    PatientMethods.getPatients().get(index).addToPatientApp(a);
	    PatientMethods.getPatients().get(index).resortAppointmentRecords();
		double p=PatientMethods.invoiceForAVisit(username, date, time);
	    double sum=0;
	    for(int i=0;i<PatientMethods.getPatients().get(index).getVisitsRecords().size();i++)
	    {
	    	sum=sum+PatientMethods.getPatients().get(index).getVisitsRecords().get(i).getService().getPrice();
	    }
	    System.out.println("For all the previous visits your total bill is "+sum+" NIS");
	}
	@Then("the invoice cannot be generated")
	public void the_invoice_cannot_be_generated() {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue("The invoice can be generated",!result);
	}

	@Then("the invoice is not generated")
	public void the_invoice_is_not_generated() {
	    // Write code here that turns the phrase above into concrete actions 
	}

	@Given("they do not have an appointment")
	public void they_do_not_have_an_appointment() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

}
