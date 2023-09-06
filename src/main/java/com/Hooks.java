package com;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends UIUtilities {

	@Before
	public void createBrowser() throws Throwable {
		UIUtilities.initializeChromeDriver();
	}

	@After
	public void closeBrowser1() throws Throwable {
		UIUtilities.closeBrowser();
		UIUtilities.quitBrowser();
	}

//@AfterStep
//public void addScreenshot() throws IOException{
//	if(Scenario.isFailed()){
//		final byte[] screenshot = UIUtilities.getScreenshotAsNew();
//				Scenario.this.attach(screenshot, "images/png", "images ");
//	}else {
//		final byte[] screenshot = UIUtilities.getScreenshotAsNew();
//		Scenario.this.attach(screenshot, "images/png", "images ");
//	}
//}

}
