package clinic.steps;

import static org.junit.Assert.assertEquals;

import clinic.main.Signup;
import io.cucumber.java.en.*;

public class signUpGUI {
	Signup su;
	String username,password,name;
	private Boolean res;
	@Given("that the user {string} is  not logged in ->gui")
	public void that_the_user_is_not_logged_in_gui(String string) {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Given("they do not have an account in the system ->gui")
	public void they_do_not_have_an_account_in_the_system_gui() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Given("they choose username {string} password {string} and name {string} ->gui")
	public void they_choose_username_password_and_name_gui(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    username=string;
	    password=string2;
	    name=string3;
	    su=new Signup();
	    su.getUsernameTF().setText(username);
	    su.getPasswordTF().setText(password);
	    su.getNameTF().setText(name);
	    su.getShowPassword().doClick(200);
	    su.getShowPassword().doClick(200);
	    su.getSignUp().doClick(200);
	    res=su.getRes();
	    su.dispose();
	}

	@Then("the sign up succeeds ->gui")
	public void the_sign_up_succeeds_gui() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(false,res);
	}

	@Then("the user is redirected to the login page ->gui")
	public void the_user_is_redirected_to_the_login_page_gui() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Given("they does have an account in the system ->gui")
	public void they_does_have_an_account_in_the_system_gui() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Then("the sign up fails ->gui")
	public void the_sign_up_fails_gui() {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(true,res);
	}

	@Then("the user is prompted to try again ->gui")
	public void the_user_is_prompted_to_try_again_gui() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}
}
