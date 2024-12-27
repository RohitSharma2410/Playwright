package pageObjects;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

import baseSrc.Base;

public class Cart {

	private Base base;
	public Cart(Base base) {
		this.base=base;
	}
	
	
	public List<Locator> cartItems() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().
			get("cartItems").toString()).all();
		
	}
	
	
	 
}
