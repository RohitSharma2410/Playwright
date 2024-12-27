package testBase.testClasses;

import baseSrc.Base;

public class BaseTest {

	private Base base = null;

	public void setup() {
		System.out.println("in before parent");
		base = new Base();
	}

	public Base getBase() {
		return base;
	}

	public void teardown() {
		base.playwright().close();
	}

}
