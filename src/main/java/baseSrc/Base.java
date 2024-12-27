package baseSrc;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import utils.PropertiesHelper;

public class Base {

	public PropertiesHelper getConfig() {
		return config;
	}

	public PropertiesHelper getPageObjects() {
		return pageObjects;
	}

	private PropertiesHelper config = null;
	private PropertiesHelper pageObjects = null;
	private BrowserContext landingPage = null;
	private Browser browser;
	private Page page = null;
	private Playwright playwright = null;

	public Base() {
		config = new PropertiesHelper("/src/main/resources/config.properties");
		pageObjects = new PropertiesHelper("/src/main/resources/pageobject.properties");
		playwright = Playwright.create();
		switch (config.getprop().get("browser").toString()) {
		case "chrome":
		case "Chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
			landingPage = browser.newContext(new com.microsoft.playwright.Browser.NewContextOptions());
			landingPage = browser.newContext();
			page = landingPage.newPage();

			page.navigate(config.getprop().get("appUrl").toString());
			page.waitForLoadState(LoadState.DOMCONTENTLOADED);

		}

	}

	public Page getLandingPage() {
		return page;
	}

	public Playwright playwright() {
		return playwright;
	}

}
