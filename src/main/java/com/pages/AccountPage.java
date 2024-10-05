package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	private By logoutButton = By.xpath("//button[text()='Logout']");
	private By productLabels = By.xpath("//div[contains(@class,'MuiPaper-root')]//p[1]");
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogoutButtonExist() {
		return driver.findElement(logoutButton).isDisplayed();
	}
	
	public int getProductCount() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElements(productLabels).size();
	}
	
	public List<String> getProductsList() {
		
		List<String> productLabelsList  = new ArrayList<>();
		List<WebElement> productList = driver.findElements(productLabels);
		
		for (WebElement element : productList) {
			String text = element.getText();
			System.out.println(text);
			productLabelsList.add(text);
		}
		return productLabelsList;
	}
}
