package clinic.steps;
import clinic.main.*;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;

public class loginSteps {
	AcceptanceTest a=new AcceptanceTest();
	Login l;
	String u,p;
	int result;
	int index=-1;
	int c0a1=-1;
	int resultAdmin;
	public loginSteps()
	{
	}
	@Given("these are the users")
	public void these_are_the_users(io.cucumber.datatable.DataTable dataTable) {
		Login.init();
	}
	@Given("that the patient {string} is not logged in")
	public void that_the_customer_is_not_logged_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("patient tries to login")
	public void customer_tries_to_login() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("username is {string} and password is {string}")
	public void username_is_and_password_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		u=string;
		p=string2;
		result=l.checkLoginStatus(u, p);
		resultAdmin=AdminMethods.search(u);
		if(result!=0)
		{
			for(int i=0;i<PatientMethods.getPatients().size();i++)
			{
				if(u.equals(PatientMethods.getPatients().get(i).getUsername()))
				{
					index=i;
					c0a1=0;
					break;
				}			
			}
			for(int i=0;i<AdminMethods.getAdmins().size();i++)
			{
				if(u.equals(AdminMethods.getAdmins().get(i).getUsername()))
				{
					index=i;
					c0a1=1;
					break;
				}			
			}
		}
						
	}
	@Then("the patient login succeeds")
	public void the_customer_login_succeeds() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(2,result);
	}

	@Then("the patient is logged in")
	public void the_customer_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions

		PatientMethods.getPatients().get(index).setLogState(true);
	}

	@When("patient tries to log in")
	public void customer_tries_to_log_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("the patient login fails")
	public void the_customer_login_fails() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(1,result);
	}

	@Then("the patient is not logged in")
	public void the_customer_is_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("that the admin {string} is not logged in")
	public void that_the_admin_is_not_logged_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("admin tries to log in")
	public void admin_tries_to_log_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("the admin login succeeds")
	public void the_admin_login_succeeds() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(result,-2);
	}

	@Then("the admin is logged in")
	public void the_admin_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		AdminMethods.getAdmins().get(index).setLogState(true);
	}

	@Then("the admin login fails")
	public void the_admin_login_fails() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(-1,result);
	}
	@Then("the admin is not logged in")
	public void the_admin_is_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("that no one is not logged in")
	public void that_no_one_is_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("user tries to log in")
	public void user_tries_to_log_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("login fails")
	public void login_fails() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(0,result);
	}

	@Then("the user is redirected to sign up page")
	public void the_user_is_redirected_to_sign_up_page() {
	    // Write code here that turns the phrase above into concrete actions
	}

}
