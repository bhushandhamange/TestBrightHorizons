package stepdefinitions;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    loginPage.navigateToLoginPage();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
	    System.out.println("Login page title is : "+ title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {    
	    Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("register now link should be displayed")
	public void register_now_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginPage.enterPassword(password);
	}

	@When("user clicks on Login To Qkart button")
	public void user_clicks_on_login_to_qkart_button() {
	    loginPage.clickOnLoginButton();
	}

}
