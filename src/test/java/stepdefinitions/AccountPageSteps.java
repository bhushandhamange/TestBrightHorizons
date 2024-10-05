package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		
		List<Map<String, String>> credList = credTable.asMaps();
		
		String userName = credList.get(0).get("Username");
		String password = credList.get(0).get("Password");
		
		loginPage.navigateToLoginPage();
		accountPage = loginPage.loginToQkart(userName, password);
	}

	@Given("User in on Account Page")
	public void user_in_on_account_page() {
	    String title = accountPage.getAccountPageTitle();
	    System.out.println("Account page title is : "+ title);
	}

	@Then("Logout button should be displayed")
	public void logout_button_should_be_displayed() {
	    Assert.assertTrue(accountPage.isLogoutButtonExist());
	}

	@Then("User is able to see following products")
	public void user_is_able_to_see_following_products(DataTable productTable) {
	    List<String> expectedProductList = productTable.asList();
	    System.out.println("Expected Product List : "+ expectedProductList);
	    
	    List<String> actualProuductList = accountPage.getProductsList();
	    System.out.println("Actual Prouct List : "+ actualProuductList);
	    
	    Assert.assertTrue(expectedProductList.containsAll(actualProuductList));
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer expectedProductCount) {
	    Assert.assertTrue(accountPage.getProductCount() == expectedProductCount);
	}
	
}
