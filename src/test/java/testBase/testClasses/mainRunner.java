package testBase.testClasses;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Geolocation;

public class mainRunner {

	public static void main(String[] args) {
		Playwright playInstance = Playwright.create();
		BrowserType browserType = playInstance.chromium();
		LaunchOptions lO = new LaunchOptions();
		lO.setHeadless(false);
		lO.setDownloadsPath(Paths.get(System.getProperty("user.dir")));
		lO.setChromiumSandbox(false);
		List<String> argsa = new ArrayList<>();
		argsa.add("--start-maximized");
		lO.setArgs(argsa);
		Browser browser = browserType.launch(lO);
		// Dimension size
		// = Toolkit.getDefaultToolkit().getScreenSize();
		NewContextOptions newC = new NewContextOptions();
		newC.setHttpCredentials("admin", "admin");
		newC.setAcceptDownloads(true);
		Geolocation geoLocation = new Geolocation(23.5, 26.4);
		newC.setGeolocation(geoLocation);
		List<String> permissions = new ArrayList<>();
		permissions.add("geolocation");
		newC.setPermissions(permissions);
		BrowserContext context = browser.newContext(newC);
		Page homePage = context.newPage();
		homePage.navigate("https://the-internet.herokuapp.com/");
//		homePage.locator("//a[contains(text(),'Geolocation')]").click();
//		homePage.locator("//button[contains(text(),'Where am I?')]").click();
		homePage.locator("//a[contains(text(),'Horizontal Slider')]").click();
		Locator rangeelement = homePage.locator("//input[@type=\"range\"]");

//homePage.locator("//a[contains(text(),'File Upload')]")
//.click();
//homePage.locator("//*[@id=\"file-upload\"]")
//.setInputFiles(Paths.get("How to Install.txt"));
//
//homePage.locator("//input[@value=\"Upload\"]").click();

		/*
		 * Framecode
		 * 
		 * // homePage.locator("//a[contains(text(),'Frames')]").first().click(); //
		 * homePage.locator("//a[contains(text(),'Nested Frames')]").click(); // //
		 * homePage.reload(); // List<Frame> frame=homePage.frames(); //
		 * System.out.println(frame.size()); // frame.forEach(s->{ //
		 * System.out.println(s.url()); // }); // frame.forEach(s->{ //
		 * s.childFrames().forEach(e->{System.out.println(e.url()+" parent"+s.url()); //
		 * });}); // // System.out.println(homePage.mainFrame().url()); // // Frame
		 * main=homePage.mainFrame(); // FrameLocator
		 * topFrame=main.frameLocator("//frame[@name='frame-top']").frameLocator(
		 * "//frame[@name='frame-left']"); //
		 * System.out.println(topFrame.locator("//body").textContent()); }
		 * 
		 */

//	homePage.onDialog(s->{s.accept();});

//		playInstance.close()

	}

	public static void addRemoteElementsCode() {
//		homePage.getByText("Add/Remove Elements").click();
//		homePage.getByText("Add Element").click();
//		}
//		homePage.reload();
//	homePage.getByText("Delete").all().forEach(s->{s.click();});
	}

	public static void settingAccess() {
//		homePage.getByText("Basic").click();
//
//		newC.setHttpCredentials("admin", "admin");
//
	}

	public static void brokenImagesCheck() {
//		homePage.getByText("Broken").click();

//		homePage.locator("//img").all().forEach(s->{
//			if(context.request().get("https://the-internet.herokuapp.com/".concat(s.getAttribute("src"))).status()==200){
//				System.out.println("valid link "+s.getAttribute("src"));
//			}
//			else {
//				System.out.println("invalid link "+s.getAttribute("src"));
//			}
//		});
	}

	public static void checkbox() {
//		homePage.getByText("Checkboxes").click();
//		List<Locator>allElements=homePage.locator("//input[@type='checkbox']").all();
//		System.out.println("Total checkboxes are "+allElements.size());
//		for(Locator e:allElements) {
//			if(e.isChecked()) {
//				System.out.println(e.textContent()+" is checked");
//				e.uncheck();
//				
//			}
//			else {
//				System.out.println(e.textContent()+" is not checked");
//
//				e.check();
//			}
//		}

	}

	public static void contextclick() {
//		homePage.getByText("Context Menu").click();
//		Locator l=homePage.locator("//*[@id='hot-spot']");
//		l.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
	}
}
