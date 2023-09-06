package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.UIUtilities;

public class GoogleHomePage extends UIUtilities {
	static WebDriver driver;
	static String URL = "https://www.google.com/";
	private static final By SEARCH_BAR = By.id("APjFqb");
	private static final By GOOGLE_LOGO = By.xpath("//img[@class='lnXdpd']");


	public static void NavigateToHomePage() {
		UIUtilities.driverGet(URL);
	}

	public static void SearchSomething() {
		UIUtilities.setText(SEARCH_BAR, "SELENIUM");
	}
}
