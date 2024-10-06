package stepdefinitions;

import org.testng.Assert;

import com.pages.FindACenterPage;
import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindACenterSteps {
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private FindACenterPage findACenterPage;
	
	@When("user click on Find a Center button")
	public void user_click_on_find_a_center_button() {
	    findACenterPage = homePage.clickOnFindCenter();
	}

	@Then("newly opened page contains locator {string} as a part of URL")
	public void newly_opened_page_contains_locator_as_a_part_of_url(String partURL) {
	    findACenterPage.verifyURLContains(partURL);
	}

	@Then("user type {string} into search box and press enter")
	public void user_type_into_search_box_and_press_enter(String location) {
	    findACenterPage.searchForLocation(location);
	}

	@Then("verify number of found centers is the same as a number of centers displayed on the below list")
	public void verify_number_of_found_centers_is_the_same_as_a_number_of_centers_displayed_on_the_below_list() {
	    int resultNumber = findACenterPage.getResultNumber();
	    int resultCount = findACenterPage.getResultListCount();
	    Assert.assertTrue(resultNumber == resultCount);
	}

	@Then("user click on first center of the list")
	public void user_click_on_first_center_of_the_list() {
	    findACenterPage.clickOnResult(1);
	}

	@Then("verify center name and address are the same on the list and on the popup")
	public void verify_center_name_and_address_are_the_same_on_the_list_and_on_the_popup() {
	    String firsCenterName = findACenterPage.getCenterName(1);
	    String firstCenterAddress = findACenterPage.getAddress(1);
	    String popupCenterName = findACenterPage.getPopupCenterName();
	    String popupAddress = findACenterPage.getPopupAddress();
	    
//	    System.out.println("firsCenterName : "+ firsCenterName);
//	    System.out.println("firstCenterAddress : "+ firstCenterAddress);
//	    System.out.println("popupCenterName : "+ popupCenterName);
//	    System.out.println("popupAddress : "+ popupAddress);
	    
	    Assert.assertTrue(firsCenterName.equals(popupCenterName));
	    Assert.assertTrue(firstCenterAddress.equals(popupAddress));
	}

}
