package clinic.steps;

import static org.junit.Assert.assertTrue;

import clinic.main.*;
import io.cucumber.java.en.*;
public class adminAddServiceSteps {
	String name;
	Double price;
	Boolean b;
	Service s;
	@Given("these are the services")
	public void these_are_the_services(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	}

	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("the service does not pre-exist")
	public void the_service_does_not_pre_exist() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Given("the service is {string} and its price is {double}")
	public void the_service_is_and_its_price_is(String string,Double double1) {
	    // Write code here that turns the phrase above into concrete actions
	    name=string;
	    price=double1;
	    s=new Service(name, price);
		b=AdminMethods.checkIfServiceCanBeAdded(s);
	}

	@When("admin tries to add the service to the clinic")
	public void admin_tries_to_add_the_service_to_the_clinic() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Then("the service can be added")
	public void the_service_can_be_added() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue("The service exists and cannot be added",!b);
	     
	}

	@Then("the service is added")
	public void the_service_is_added() {
	    // Write code here that turns the phrase above into concrete actions
		AdminMethods.addService(s);
	     
	}

	@Given("the service does pre-exist")
	public void the_service_does_pre_exist() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Then("the service cannot be added")
	public void the_service_cannot_be_added() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue("The servicec can be added",b);
	     
	}

	@Then("the service is not added")
	public void the_service_is_not_added() {
	    // Write code here that turns the phrase above into concrete actions
	     
	}
}
