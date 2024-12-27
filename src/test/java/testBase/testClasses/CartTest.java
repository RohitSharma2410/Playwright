package testBase.testClasses;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

import pageObjects.Cart;
import pageObjects.Dashboard;
import pageObjects.LoginPage;

public class CartTest extends BaseTest {
	private Dashboard dashboard = null;
	private Cart cart = null;

	public void setupDashboard() {
		System.out.println("in dashboard beofre");
		dashboard = new LoginPage(getBase()).enterUserName("standard_user").enterPassword("secret_sauce")
				.clickLoginButton();

	}

	public void validateCartItems() {
		String itemTobeAdded = "Sauce Labs Backpack";
		for (Locator e : dashboard.inventoryItems()) {
			if (e.locator(getBase().getPageObjects().getprop().getProperty("inventoryItemslabel")).innerText()
					.equalsIgnoreCase(itemTobeAdded)) {
				e.locator("//button").click();
				break;
			}

		}
		getBase().getLandingPage().waitForLoadState(LoadState.NETWORKIDLE);

		cart = dashboard.clickCartButton();
		System.out.println("total items in cart " + cart.cartItems().size());
		getBase().getLandingPage().waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println(cart.cartItems().get(0).innerText());
		assert (cart.cartItems().get(0).innerText().contains(itemTobeAdded));

	}

}
