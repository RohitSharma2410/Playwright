package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.options.LoadState;

import baseSrc.Base;


public class LoginPage{
	
	private Base base;
	public LoginPage(Base base) {
		this.base=base;
	}
	
	public LoginPage enterUserName(String text) {
		 this.getUsername().fill(text);
		 return this;
	}
	
	public LoginPage enterPassword(String text) {
		this.getPassword().fill(text);
		return this;
	}
	
	public Dashboard clickLoginButton() {
		this.getLoginButton().click(new ClickOptions().setForce(true));
		base.getLandingPage().waitForLoadState(LoadState.NETWORKIDLE);
		return new Dashboard(base);
	}
	
	
	public Locator getUsername() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().
				get("username").toString());
	}
	
	
	public Locator getPassword() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().
			get("password").toString());
		
	}
	
	
	public Locator getLoginButton() {
		return base.getLandingPage().locator(base.getPageObjects().getprop().
				get("login-button").toString());
	}
	
	
	
}
