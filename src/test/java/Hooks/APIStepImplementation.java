package Hooks;

import java.io.IOException;

import com.microsoft.playwright.APIResponse;

import APIClasses.APIClass;
import APIClasses.APIS;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIStepImplementation {

	@Given("API is {string}")
	public void api_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		Hooks.apirequest.set(Hooks.playwright.get().request().newContext());
		new APIClass(Hooks.apirequest.get(), APIS.valueOf(string), Hooks.apiconfig);
Hooks.apiClasses.set(new APIClass(Hooks.apirequest.get(), APIS.valueOf(string), Hooks.apiconfig));
	}

	@When("Set query parameter {string} with {string}")
	public void set_query_parameter_with(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		Hooks.apiClasses.get().updatequeryParam(string, string2);
	}

	@When("Set path parameter {string}")
	public void set_path_parameter(String string) {
		// Write code here that turns the phrase above into concrete actions
		Hooks.apiClasses.get().updateAPIenpoint(string);
	}

	@When("Set request body json data {string}")
	public void set_request_body_json_data(String string) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Hooks.apiClasses.get().setBodyForAPI(string);

	}

	@Then("API response state code should be \\{{int}}")
	public void api_response_state_code_should_be(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assert (Hooks.apiClasses.get().callAPI().status() == int1);
	}

	@Then("API response body should contain parameter {string} with {string}")
	public void api_response_body_should_contain_parameter_with_value(String string, String string2) {
		APIResponse res = Hooks.apiClasses.get().callAPI();
		System.out.println(res.text());

		JsonObject js = Json.parse(res.text()).asObject();
		System.out.println(js.get(string).asString());
		System.out.println(string2);
		assert (js.get(string).asString().equalsIgnoreCase(string2));

	}

}
