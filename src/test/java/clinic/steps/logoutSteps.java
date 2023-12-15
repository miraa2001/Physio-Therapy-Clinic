package clinic.steps;
import clinic.main.*;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;

public class logoutSteps {
String u;
Boolean status;
static int index=-1;
static int c0a1=-1;
Boolean b;
public static void search(String u)
{
	for(int i=0;i<PatientMethods.getPatients().size();i++)
	{
		if(u.equals(PatientMethods.getPatients().get(i).getUsername()))
		{
			c0a1=0;
			index=i;
			break;
		}			
	}
	
}
@Given("that the user {string} is logged in")
public void that_the_user_is_logged_in(String string) {
    // Write code here that turns the phrase above into concrete actions
	u=string;
	b=false;
	index=PatientMethods.search(string);
	/*if(index==-1)
	{
		index=AdminMethods.search(string);
		if(AdminMethods.getAdmins().get(index).getLogState()==true)
			b=true;
		else
			b=false;
	}
	else
	{*/
		if(PatientMethods.getPatients().get(index).getLogState()==true)
			b=true;
		
}

@Then("the user logs out")
public void the_user_logs_out() {
    // Write code here that turns the phrase above into concrete actions
	assertTrue("The user can't log out because they are not logged in",b);
}

@Then("user is redirected to the login portal")
public void user_is_redirected_to_the_login_portal() {
    // Write code here that turns the phrase above into concrete actions
	search(u);
	if(c0a1==0)
		PatientMethods.getPatients().get(index).setLogState(false);
}

@Given("that the user {string} is not logged in")
public void that_the_user_is_not_logged_in(String string) {
    // Write code here that turns the phrase above into concrete actions
	b=false;
	index=PatientMethods.search(string);
	/*if(index==-1)
	{
		index=AdminMethods.search(string);
		if(AdminMethods.getAdmins().get(index).getLogState()==true)
			b=true;
		else
			b=false;
	}
	else
	{*/
		if(PatientMethods.getPatients().get(index).getLogState()==false)
			b=false;
}

@When("user wants to log out")
public void user_wants_to_log_out() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("the user logout fails")
public void the_user_logout_fails() {
    // Write code here that turns the phrase above into concrete actions
	assertTrue("The user can log out",!b);
}
@Then("the user is not logged in")
public void the_user_is_not_logged_in() {
    // Write code here that turns the phrase above into concrete actions
}
}
