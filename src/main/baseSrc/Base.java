package baseSrc;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.PropertiesHelper;

public class Base {

	public PropertiesHelper getConfig() {
		return config;
	}


	public PropertiesHelper getPageObjects() {
		return pageObjects;
	}


	private PropertiesHelper config=null;
	private PropertiesHelper pageObjects=null;
	private Page landingPage=null;
	private Playwright playwright=null;
	public Base() {
		config=new PropertiesHelper("/src/main/resources/config.properties");
		pageObjects=new PropertiesHelper("/src/main/resources/pageobject.properties");
		 playwright=Playwright.create();
		switch(config.getprop().get("browser").toString()) {
		case "chrome" : case "Chrome":
		landingPage=playwright.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		landingPage.navigate(config.getprop().get("appUrl").toString());
		
		}
		
	}
	public Page getLandingPage() {
		return landingPage;
	}
	
	public Playwright playwright() {
		return playwright;
	}
	
	
}
