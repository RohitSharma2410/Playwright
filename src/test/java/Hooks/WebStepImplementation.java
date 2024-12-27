package Hooks;

import com.microsoft.playwright.options.LoadState;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebStepImplementation {

	@Given("I am on Login page")
	public void i_am_on_login_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("login with {string} and {string}")
	public void login_with_and(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions

		Hooks.page.get().locator(Hooks.pageObjects.getProperty("username")).fill(string);
		Hooks.page.get().locator(Hooks.pageObjects.getProperty("password")).fill(string2);
		Hooks.page.get().locator(Hooks.pageObjects.getProperty("login-button")).click();
		Hooks.page.get().waitForLoadState(LoadState.DOMCONTENTLOADED);
	}

	@Then("login should be succesfull")
	public void login_should_be_succesfull() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		assert (Hooks.page.get().locator(Hooks.pageObjects.getProperty("inventoryItems")).all().size() >= 0);
	}

	@Then("login should fail")
	public void login_should_fail() throws InterruptedException {
		// Write code here that turns the phrase above into concrete a99ctions0
		assert (Hooks.page.get().locator(Hooks.pageObjects.getProperty("loginerror")).isVisible());
	}

}
