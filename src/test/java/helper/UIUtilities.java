package helper;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class UIUtilities {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
	static WebDriver driver = null;
	private static final String PREFS = "prefs";
//	private static final String CHROME = "chrome";


	public static void initializeChromeDriver() throws AWTException, InterruptedException, IOException {
					String path = new ClassPathResource("browserDrivers/chromedriver.exe").getFile().getAbsolutePath();
//					String path = "F:\\extent\\cucumber-java-selenium-webdriver-example-master\\src\\test\\resources\\browserDrivers\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver", path);
					HashMap<String, Object> chromePrefs = new HashMap<>();
//					chromePrefs.put(PROFILE_DEFAULT_CONTENT SETTINGS POPUPS, 0);
//					chromePrefs.put(DOWNLOAD_DEFAULT_DIRECTORY, "\\\\pfgpltrisqats@3.pilotpusa.pilotcorp.principal.com\\Am
//					chromePrefs.put (DOWNLOAD PROMPT FOR DOWNLOAD, false);
//					chromePrefs.put(DOWNLOAD DIRECTORY UPGRADE, true);
					ChromeOptions option = new ChromeOptions();
					option.setExperimentalOption(PREFS, chromePrefs);
					option.addArguments("--disable:infobars");
					option.addArguments("--test-type");
					option.addArguments("--incognito");
					option.addArguments("--disable-extensions");
					option.addArguments("--ignore-certificate-errors");
					option.addArguments("--enable-javascript");
//					option.addArguments("force-device-scale-factor=0.75");
//					option.addArguments("high-dpi-support=0.75");
//					option.addArguments ("--window-size-300, 200");
					option.setCapability(ChromeOptions.CAPABILITY, option);
					driver = new ChromeDriver(option);
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//					driver.manage().window().setSize(new Dimension (1920, 1200));
					driver.manage().window().maximize();
//					JavascriptExecutor js = (JavascriptExecutor) driver;
//					js.executeScript("document.body.style.zoom='.75'");
	}

	public static void driverGet(String URL) {
		driver.get(URL);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void clickElement(By xpath) {
		WebElement element = driver.findElement(xpath);
		element.click();
	}

	public static void setText(By xpath, String keysToSend) {
		WebElement element = driver.findElement(xpath);
		element.clear();
		element.sendKeys(keysToSend);
	}

	public static byte[] getScreenshotAsNew() throws IOException {
		byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return shot;
	}

	public static void getScreenshotAs(String fileName) throws IOException {
		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File(fileName));
	}

	public static void waitForWebElementToBeVisisble(final By by, int timeOutInSec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
			wait.until(webdriver -> webdriver.findElement(by).isDisplayed());
		} catch (Exception e) {
			LOGGER.error("Encountered NoSuchElement Exception ", e);
		}
	}
}