package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.Constants;
import com.qa.util.WaitUtils;

public class HomePage {
	
	private WebDriver driver;
	
	private By searchLoopIcon = By.xpath("(//a[@role='button']/span[contains(@class,'icon-search')])[2]");
	private By searchField = By.xpath("//nav[@id='subnav-search-desktop-top']//input[@id='search-field']");
	private By searchButton = By.xpath("(//button[@type='submit'])[2]");
	private By searchResult = By.xpath("//a[@class='search-result']//h3");
	private By findCenterButton = By.xpath("(//a[contains(text(), 'Find a Center')])[4]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnSearchLoopIcon() {
		driver.findElement(searchLoopIcon).click();
	}
	
	public boolean isSearchFieldDisplayed() {
		// Create an instance of the WaitUtils class
        WaitUtils waitUtils = new WaitUtils(driver);
        
        WebElement searchFieldEle = waitUtils.waitForElementToBeVisible(searchField);
        //System.out.println("element is : "+ searchFieldEle.isDisplayed());
		return searchFieldEle.isDisplayed();
	}
	
	public void enterTextInSearchField(String text) {
		driver.findElement(searchField).sendKeys(text);
	}
	
	public void clickOnSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void navigateToHomePage() {
		// Create an instance of the WaitUtils class
        WaitUtils waitUtils = new WaitUtils(driver);
        
		driver.get(Constants.APP_URL);
		
		// Use WaitUtils to wait for an element to be clickable
        WebElement acceptButton = waitUtils.waitForElementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"));
        acceptButton.click();
	}
	
	public String getFirstResultText() {
		WaitUtils waitUtils = new WaitUtils(driver);
		waitUtils.waitForAllElementToBeVisible(searchResult);
		
		List<WebElement> results = driver.findElements(searchResult);
		String firstResultText = results.get(0).getText();
		return firstResultText;
	}

	public FindACenterPage clickOnFindCenter() {
		driver.findElement(findCenterButton).click();
		return new FindACenterPage(driver);
	}
}
