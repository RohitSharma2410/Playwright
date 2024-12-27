package testBase.testClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

import pageObjects.Dashboard;
import pageObjects.LoginPage;

public class DashboardTests extends BaseTest {
	private Dashboard dashboard = null;

	public void setupDashboard() {
		System.out.println("in dashboard beofre");
		dashboard = new LoginPage(getBase()).enterUserName("standard_user").enterPassword("secret_sauce")
				.clickLoginButton();

	}

	public void checkLoggedInUser() {

		assert (dashboard.userName().innerText().equalsIgnoreCase("Swag Labs"));
	}

	public void addItemToCart() {
		for (Locator e : dashboard.inventoryItems()) {
			String inventoryItemName = e
					.locator(getBase().getPageObjects().getprop().getProperty("inventoryItemslabel")).innerText();
			System.out.println("Inventory Name is " + inventoryItemName);
			String price = e.locator(getBase().getPageObjects().getprop().getProperty("invetoryitemsprice"))
					.innerText();

			Matcher match = Pattern.compile("[-]?[0-9]*\\.?[0-9]+").matcher(
					e.locator(getBase().getPageObjects().getprop().getProperty("invetoryitemsprice")).innerText());

			if (match.find()) {
				price = match.group();
			}

			System.out.println("price is " + price + " adding same to cart");
			e.locator("//button").click();

			getBase().getLandingPage().waitForLoadState(LoadState.NETWORKIDLE);

		}
		dashboard.clickCartButton();

	}

}
