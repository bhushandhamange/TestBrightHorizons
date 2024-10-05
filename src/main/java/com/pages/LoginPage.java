package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By userName = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.xpath("(//button)[2]");
	private By registerLink = By.linkText("Register now");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isRegisterLinkExist() {
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public AccountPage loginToQkart(String username, String password) {
		System.out.println("login to Qkart using "+ username + " password : "+ password);
		enterUserName(username);
		enterPassword(password);
		clickOnLoginButton();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new AccountPage(driver);
	}
	
	public void navigateToLoginPage() {
		driver.get("https://crio-qkart-frontend-qa.vercel.app/login");
	}
}
