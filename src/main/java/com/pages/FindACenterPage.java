package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.util.WaitUtils;

public class FindACenterPage {

	private WebDriver driver;
	
	private By locationInputBox = By.xpath("//input[@id='addressInput']");
	private By resultNumber = By.xpath("//span[@class='resultsNumber']");
	private By resultList = By.xpath("//div[@id='center-results-container']/div[contains(@class,'centerResult')]");
	private By centerNameList = By.xpath("//div[@id='center-results-container']/div[contains(@class,'centerResult')]//h3");
	private By addressList = By.xpath("//div[@id='center-results-container']/div[contains(@class,'centerResult')]//span[@class='centerResult__address']");
	private By popupName = By.xpath("//span[@class='mapTooltip__headline']");
	private By popupAddress = By.xpath("//div[@class='mapTooltip__address']");
	
	public FindACenterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyURLContains(String partURL) {
		String currentURL = driver.getCurrentUrl();
		return currentURL.contains(partURL);
	}
	
	public void searchForLocation(String location) {
		driver.findElement(locationInputBox).sendKeys(location);
		
		WaitUtils waitUtils = new WaitUtils(driver);
		waitUtils.staticWait(2000);
		
//		waitUtils.waitForElementToBeVisible(locationInputBox);
//		waitUtils.waitForElementToBeClickable(locationInputBox);
		
		driver.findElement(locationInputBox).sendKeys(Keys.RETURN);
		
		 // Use JavaScript to simulate pressing Enter
//        JavascriptExecutor js = (JavascriptExecutor) driver;    
//        js.executeScript("arguments[0].click();", driver.findElement(locationInputBox));

//        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {'key': 'Enter'}));", 
//        		driver.findElement(locationInputBox));
	}
	
	public int getResultNumber() {
		WaitUtils waitUtils = new WaitUtils(driver);
		waitUtils.waitForElementToBeVisible(resultNumber);
		return Integer.valueOf(driver.findElement(resultNumber).getText());
	}
	
	public int getResultListCount() {
		WaitUtils waitUtils = new WaitUtils(driver);
		waitUtils.waitForAllElementToBeVisible(resultList);
		return driver.findElements(resultList).size();
	}
	
	public void clickOnResult(int index) {
		driver.findElements(resultList).get(index - 1).click();
	}
	
	public String getCenterName(int index) {
		return driver.findElements(centerNameList).get(index - 1).getText();
	}
	
	public String getAddress(int index) {
		return driver.findElements(addressList).get(index - 1).getText();
	}
	
	public String getPopupCenterName() {
		WaitUtils waitUtils = new WaitUtils(driver);
		waitUtils.waitForElementToBeVisible(popupName);
		return driver.findElement(popupName).getText();
	}
	
	public String getPopupAddress() {
		String address = driver.findElement(popupAddress).getText();
		return address.replaceAll("[\n\r]", " ");
	}
}
