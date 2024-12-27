package pageObjects;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

import baseSrc.Base;

public class Dashboard {

	private Base base;

	public Dashboard(Base base) {
		this.base = base;
	}

	public Locator userName() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().get("userNameHeader").toString());

	}

	public List<Locator> inventoryItems() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().getProperty("inventoryItems")).all();

	}

	public Locator cartLink() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().get("shoppingcartlink").toString());

	}

	public void addToCart(String itemName) {
		for (Locator e : this.inventoryItems()) {
			if (e.locator("inventoryItemslabel").innerText().contains(itemName)) {
				e.click();
			}
		}
	}

	public Cart clickCartButton() {
		cartLink().click();
		base.getLandingPage().waitForLoadState(LoadState.NETWORKIDLE);
		return new Cart(base);

	}

}
