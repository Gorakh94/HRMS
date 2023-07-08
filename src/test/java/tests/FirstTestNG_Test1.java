package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class FirstTestNG_Test1 {

	WebDriver driver;

	@Test
	public void f() {
		//System.setProperty("webdriver.chrome.driver", "C:\\gorakhnath_workspace\\webdrivertraining\\browser_executables\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\gorakhnath_workspace\\webdrivertraining\\browser_executables\\msedgedriver.exe");
	//	driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.get("https://www.google.com");
		// Perform Selenium actions

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
