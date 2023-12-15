package clinic.steps;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

import clinic.main.AdminMethods;
import clinic.main.Login;
import clinic.main.PatientMethods;
import io.cucumber.java.en.*;

public class loginGUISteps {
String username,password;
Login login;
int i;
@Given("that the patient {string} is not logged in -> gui")
public void that_the_patient_is_not_logged_in_gui(String string) {
    // Write code here that turns the phrase above into concrete actions
}

@When("patient tries to login -> gui")
public void patient_tries_to_login_gui() {
    // Write code here that turns the phrase above into concrete actions
}


@Then("the patient login succeeds -> gui")
public void the_patient_login_succeeds_gui() {
    // Write code here that turns the phrase above into concrete actions
	 
	assertEquals(2,i);
}

@Then("the patient is logged in -> gui")
public void the_patient_is_logged_in_gui() {
    // Write code here that turns the phrase above into concrete actions
	PatientMethods.getPatients().get(PatientMethods.search(username)).setLogState(true);
}

@When("patient tries to log in -> gui")
public void patient_tries_to_log_in_gui() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("the patient login fails -> gui")
public void the_patient_login_fails_gui() {
    // Write code here that turns the phrase above into concrete actions
	 
	assertEquals(1,i);
}

@Given("that the admin {string} is not logged in -> gui")
public void that_the_admin_is_not_logged_in_gui(String string) {
    // Write code here that turns the phrase above into concrete actions
}

@Then("the admin login succeeds -> gui")
public void the_admin_login_succeeds_gui() {
    // Write code here that turns the phrase above into concrete actions
	 
	assertEquals(-2,i);
}

@Then("the admin is logged in -> gui")
public void the_admin_is_logged_in_gui() {
    // Write code here that turns the phrase above into concrete actions
	AdminMethods.getAdmins().get(AdminMethods.search(username)).setLogState(true);
}

@When("admin tries to log in -> gui")
public void admin_tries_to_log_in_gui() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("the admin login fails -> gui")
public void the_admin_login_fails_gui() {
    // Write code here that turns the phrase above into concrete actions
	 
	assertEquals(-1,i);
}

@Then("the admin is not logged in -> gui")
public void the_admin_is_not_logged_in_gui() {
    // Write code here that turns the phrase above into concrete actions
}

@Given("that no one is not logged in -> gui")
public void that_no_one_is_not_logged_in_gui() {
    // Write code here that turns the phrase above into concrete actions
}

@When("user tries to log in -> gui")
public void user_tries_to_log_in_gui() {
    // Write code here that turns the phrase above into concrete actions
}

@SuppressWarnings("deprecation")
@When("username is {string} and password is {string}  -> gui")
public void username_is_and_password_is_gui(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
	try {
		username=string;
		password=string2;
		login = new Login();
		login.setVisible(true);
		login.setUsernameField(string);
		login.setPasswordField(string2);
		login.getSignIn().doClick(200);
		login.getShowPassword().doClick(200);
		login.getShowPassword().doClick(200);
		i=login.getResult();
		login.dispose();
}
	 catch(Exception ex)
	 {
		 ex.printStackTrace();
	 }
}

@Then("login fails -> gui")
public void login_fails_gui() {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(0,i);
}

@Then("the user is redirected to sign up page -> gui")
public void the_user_is_redirected_to_sign_up_page_gui() {
    // Write code here that turns the phrase above into concrete actions
}
}
