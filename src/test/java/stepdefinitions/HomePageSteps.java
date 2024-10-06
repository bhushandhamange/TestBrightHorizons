package stepdefinitions;

import org.testng.Assert;
import com.pages.HomePage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("user is on home page")
	public void user_is_on_home_page() {
		homePage.navigateToHomePage();
	    String title = homePage.getHomePageTitle();
	    //System.out.println("User is on Home Page : "+ title);
	}

	@When("user click on searchLoop icon")
	public void user_click_on_search_loop_icon() {
	    homePage.clickOnSearchLoopIcon();
	}

	@Then("search field is visible on the page")
	public void search_field_is_visible_on_the_page() {		
		boolean visible = homePage.isSearchFieldDisplayed();
		Assert.assertTrue(visible);
	}

	@Then("user type {string} into search field")
	public void user_type_into_search_field(String userInput) {
	    homePage.enterTextInSearchField(userInput);
	}
	
	@Then("user clicks on search button")
	public void user_clicks_on_search_button() {
	    homePage.clickOnSearchButton();
	}

	@Then("first result matches with {string}")
	public void first_result_matches_with(String expectedText) {
	    String firstResultText = homePage.getFirstResultText();
	    Assert.assertTrue(firstResultText.equals(expectedText));
	}
}
