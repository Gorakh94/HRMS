package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class WaitExamples {

	WebDriver driver;
	WebDriverWait wait;
	WebElement button;
	WebElement text;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		wait=new WebDriverWait(driver,Duration.ofSeconds(30)); // Modified
		
	}

	@Test(alwaysRun=true)
	public void wait_test() {
		String expected="Hello World!";
		button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text()='Start']"))); // updated line
		//button[normalize-space()='Start']
		
		button=driver.findElement(By.xpath("//div/button[text()='Start']"));
		button.click();
		
		text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));	//div[@id='finish']//h4
	
	//	text=driver.findElement(By.xpath("//div[@id='finish']//h4"));
		String actual=text.getText();
		
		assertEquals(actual, expected,"Page not landed successfully.");
	
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
