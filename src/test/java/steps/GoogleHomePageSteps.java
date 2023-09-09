package steps;

import java.awt.AWTException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GoogleHomePage;

public class GoogleHomePageSteps {
	@Given("A user navigates to Google HomePage")
	public void navigate_google_HomePage() throws AWTException, InterruptedException, IOException  {
		GoogleHomePage.NavigateToHomePage();
	}

	@Then("search bar is displayed")
	public void search_on_google_HomePage() throws InterruptedException {
		GoogleHomePage.SearchSomething();
	}
}
