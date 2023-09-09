package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.UIUtilities;

public class GoogleHomePage extends UIUtilities {
	static WebDriver driver;
	static String URL = "https://www.google.com/";
	private static final By SEARCH_BAR = By.id("APjFqb");
//	private static final By GOOGLE_LOGO = By.xpath("//img[@class='lnXdpd']");


	public static void NavigateToHomePage() throws AWTException, InterruptedException, IOException {
		UIUtilities.initializeChromeDriver();
		UIUtilities.driverGet(URL);
	}

	public static void SearchSomething() throws InterruptedException {
		UIUtilities.setText(SEARCH_BAR, "SELENIUM");
		Thread.sleep(5000);
		UIUtilities.closeBrowser();
		UIUtilities.quitBrowser();
	}
}
