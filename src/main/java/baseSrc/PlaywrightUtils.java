package baseSrc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.LoadState;

public class PlaywrightUtils {

	public static Locator returnLocator(String uiElement, Page page, Properties properties) {
		Locator locator = null;
		try {
			page.locator(properties.getProperty(uiElement));
		} catch (Exception e) {
			e.getClass().getSimpleName();
		}
		return locator;
	}

	public static void main(String[] args) {
		Page page = null;
		try {
			LaunchOptions launchOptions = new LaunchOptions();
			List<String> launchArguments = new ArrayList<>();
			launchArguments.add("--start-maximized");
			launchOptions.setArgs(launchArguments);
			launchOptions.setHeadless(false);
			NewContextOptions newC = new NewContextOptions();
			newC.setHttpCredentials("admin", "admin");
			BrowserContext context = Playwright.create().chromium().launch(launchOptions).newContext(newC);

			page = context.newPage();
			page.navigate("https://the-internet.herokuapp.com/");
			page.waitForLoadState(LoadState.NETWORKIDLE);
			List<Locator> locators = page
					.locator("//h2[normalize-space(contains(text()," + "\"Available Examples\"))]/following::ul//a")
					.all();
//			for(int i =0;i<locators.size();i++) {
//				locators.get(i).click();
//				page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//				page.goBack();
//				page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//
//			}

			locators.get(2).click();
			FrameLocator page2 = page.frameLocator("");
		} catch (TimeoutError e) {
			page.reload();
			Locator galleryLocator = page.locator("//*[contains(text(),'Gallery')]");
			galleryLocator.click();
		}
	}
}
