package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitUtils {

	private WebDriver driver;

	// The default timeout in seconds
	private static final int DEFAULT_TIMEOUT = 10;

	// Constructor to initialize the driver
	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	// Method to wait for an element to be clickable
	public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Method to wait for all elements to load
	public WebElement waitForVisibilityOfAllElements(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method to wait for an element to be clickable with default timeout
	public WebElement waitForElementToBeClickable(By locator) {
		return waitForElementToBeClickable(locator, DEFAULT_TIMEOUT);
	}

	// Method to wait for an element to be clickable with default timeout
	public WebElement waitForAllElementToBeVisible(By locator) {
		return waitForVisibilityOfAllElements(locator, DEFAULT_TIMEOUT);
	}

	// Method to wait for an element to be visible
	public WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method to wait for an element to be visible with default timeout
	public WebElement waitForElementToBeVisible(By locator) {
		return waitForElementToBeVisible(locator, DEFAULT_TIMEOUT);
	}

	// Method to wait for an element to be present in the DOM
	public WebElement waitForElementToBePresent(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Method to wait for an element to be present in the DOM with default timeout
	public WebElement waitForElementToBePresent(By locator) {
		return waitForElementToBePresent(locator, DEFAULT_TIMEOUT);
	}

	// Method to wait until a specific condition is true using FluentWait
	public WebElement fluentWaitForElement(By locator, int timeoutInSeconds, int pollingTimeInSeconds) {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds)).ignoring(NoSuchElementException.class);

		return fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}

	public void staticWait(long milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
