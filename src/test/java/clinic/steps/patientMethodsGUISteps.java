package clinic.steps;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import clinic.main.PatientMethods;
import io.cucumber.java.en.*;

public class patientMethodsGUISteps {
	PatientMethods pm;
	String username;
	String msg;
	String expMsg;
	int index;
	Boolean flag;
	@Given("that user is logged in ->Patient GUI")
	public void that_user_is_logged_in_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Given("the username is {string} ->Patient GUI")
	public void the_username_is_patient_gui(String string) {
	    // Write code here that turns the phrase above into concrete actions
		username=string;
	    index = PatientMethods.search(username);
	    pm=new PatientMethods(PatientMethods.getPatients().get(index).getName(),index);
	    pm.setVisible(true);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 25);
		Date d=cal.getTime();
		pm.getCalendar().setDate(d);
		pm.getServicesChoice().setSelectedIndex(1);
		pm.getTimes().setSelectedIndex(1);
		pm.getShowAllAppointments().doClick(200);
    }

	@Given("Book Appointment is clicked ->Patient GUI")
	public void book_appointment_is_clicked_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
		pm.getBookAppointment().doClick(200);
	}

	@Given("Message Label says {string} ->Patient GUI")
	public void message_label_says_patient_gui(String string) {
	    // Write code here that turns the phrase above into concrete actions
		expMsg=string;
		msg=pm.getErrorLabel().getText();
	}

	@Then("button is operating correctly ->Patient GUI")
	public void button_is_operating_correctly_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(msg,expMsg); 
	}

	@Then("button is not operating correctly ->Patient GUI")
	public void button_is_not_operating_correctly_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(msg,expMsg);
		pm.dispose();
	}

	@Given("Show Appointment is clicked ->Patient GUI")
	public void show_appointment_is_clicked_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
	    pm.getShowAllAppointments().doClick(200);
	    
	}

	@Given("textarea is not empty->Patient GUI")
	public void textarea_is_not_empty_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
	    flag = pm.getText().getText().isEmpty();
	}

	@Then("textarea is operating correctly ->Patient GUI")
	public void textarea_is_operating_correctly_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(false,flag);
	}

	@Given("Get a bill is clicked ->Patient GUI")
	public void get_a_bill_is_clicked_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
		pm.getText().setText("s11926792@stu.najah.edu");
	    pm.getGetInvoice().doClick(200); 
	}
	@Given("at least one appointment exists->Patient GUI")
	public void at_least_one_appointment_exists_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
		flag=pm.getAppointments().isEmpty();
	}

	@Then("bill button is operating correctly ->Patient GUI")
	public void bill_button_is_operating_correctly_patient_gui() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(false,flag);
	}
}
