package tests;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class OrangeHRMLoginTest {

	WebDriver driver;
	WebElement userName;
	WebElement password;
	WebElement submit;
	WebDriverWait wait;
	

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.chromedriver",
				"C:\\gorakhnath_workspace\\webdrivertraining\\browser_executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@Test
	public void loginOrangeHRMTest() throws InterruptedException {

		userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		userName.sendKeys("Admin");

		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("admin123");

		submit = driver.findElement(By.xpath("//button[@type='submit']"));
		// submit.click();
		// OR
		submit.submit();
		String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		String actual = driver.getCurrentUrl();

		Thread.sleep(4000);

		// Take a screenshot and save it to a file with the current date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String screenshotName = "loginOrangeHRMTest_" + dateFormat.format(currentDate) + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = "C:\\gorakhnath_workspace\\webdrivertraining\\screenshots\\";
		try {
			Files.copy(screenshotFile, new File(screenshotpath + screenshotName));
			System.out.println("Screenshot saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected, "Login Failed");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
