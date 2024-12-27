package Hooks;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import APIClasses.APIClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.PropertiesHelper;

public class Hooks {
	public static Properties config = null;
	public static Properties pageObjects = null;
	public static Properties apiconfig = null;
	public static ThreadLocal<Playwright> playwright = null;
	public static ThreadLocal<Page> page = null;
	public static ThreadLocal<APIRequestContext> apirequest = null;
	public static ThreadLocal<APIClass> apiClasses = null;

	@BeforeAll
	public static void before_all() throws FileNotFoundException {
		if (config == null) {
			config = new PropertiesHelper("/src/main/resources/config.properties").getprop();
			pageObjects = new PropertiesHelper("/src/main/resources/pageobject.properties").getprop();
			apiconfig = new PropertiesHelper("/src/main/resources/apiconfig.properties").getprop();
		}

	}

	@Before("@Web")
	public  void setupTest() {
		BrowserContext bc = null;
		if (playwright == null) {
			playwright = new ThreadLocal<>();
		}
		if (page == null) {
			page = new ThreadLocal<>();
		}
		playwright.set(Playwright.create());
		switch (config.get("browser").toString()) {
		case "chrome":
		case "Chrome":
			List<String> launchOptions = new ArrayList<>();
			launchOptions.add("--start-maximized");
			bc = playwright.get().chromium().launch(new LaunchOptions().setHeadless(false).setArgs(launchOptions))
					.newContext();
			page.set(bc.newPage());
			page.get().navigate(config.getProperty("appUrl"));
		}
	}

	@Before("@Api")
	public void setupAPI() {
		if (playwright == null) {
			playwright = new ThreadLocal<>();
		}
		if (apirequest == null) {
			apirequest = new ThreadLocal<>();
		}

		if (apiClasses == null) {
			apiClasses = new ThreadLocal<>();
		}
playwright.set(Playwright.create());
	}

	@After("@Api")
	public void afterAPI(Scenario sc) {
		if(sc.isFailed()) {
			sc.attach(apirequest.get().toString(), " ", "failed");
		}
		playwright.get().close();
	}
	
	@After("@Web")
	public void afterWeb(Scenario sc) {
		if(sc.isFailed()) {
			sc.attach(page.get().screenshot(),"","");
		}
		playwright.get().close();
	}
	@AfterAll
	public static void after_all() {
		playwright=null;
	}

}
