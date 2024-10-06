package com.qa.factory;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	//This method is used to initialize the ThreadLocal driver on the basis of given browser
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is : " + browser);
		
		if (browser.equals("chrome")) {

			// Create a ChromeOptions instance
	        ChromeOptions options = new ChromeOptions();
	        
	        // Define a map to specify geolocation behavior
	        HashMap<String, Object> prefs = new HashMap<String, Object>();
	        HashMap<String, Object> profile = new HashMap<String, Object>();
	        HashMap<String, Object> contentSettings = new HashMap<String, Object>();
	        
	        // Automatically allow location access
	        contentSettings.put("geolocation", 1); // 1 = allow, 2 = block
	        profile.put("managed_default_content_settings", contentSettings);
	        prefs.put("profile", profile);
	        options.setExperimentalOption("prefs", prefs);
			
			tlDriver.set(new ChromeDriver(options));
		} else if (browser.equals("firefox")) {

			// Create a FirefoxOptions instance
	        FirefoxOptions options = new FirefoxOptions();
	        
	        // Set the preference to automatically allow geolocation
	        options.addPreference("geo.prompt.testing", true);
	        options.addPreference("geo.prompt.testing.allow", true);
			
			tlDriver.set(new FirefoxDriver(options));
		} else if (browser.equals("edge")) {
			
			// Create an EdgeOptions instance
	        EdgeOptions options = new EdgeOptions();

	        // Define a map to specify geolocation behavior
	        HashMap<String, Object> prefs = new HashMap<String, Object>();
	        HashMap<String, Object> profile = new HashMap<String, Object>();
	        HashMap<String, Object> contentSettings = new HashMap<String, Object>();

	        // Automatically allow location access
	        contentSettings.put("geolocation", 1); // 1 = allow, 2 = block
	        profile.put("managed_default_content_settings", contentSettings);
	        prefs.put("profile", profile);
	        options.setExperimentalOption("prefs", prefs);

			tlDriver.set(new EdgeDriver(options));
		} else {
			System.out.println("Please pass the correct browser value");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return getDriver();
	}
	
	
	//this is used to get the driver with ThreadLocal
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
