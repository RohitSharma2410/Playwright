package testBase.testClasses;

import pageObjects.LoginPage;

public class loginTests extends BaseTest {
	private LoginPage loginPage = null;

	public void setupclass() {
		System.out.println("in before");
		loginPage = new LoginPage(getBase());
	}

	public void login() {
		loginPage.enterUserName("standard_user").enterPassword("secret_sauce").clickLoginButton();
	}

}
