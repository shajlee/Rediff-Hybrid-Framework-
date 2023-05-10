package com.qa.practicerediff.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.practicerediff.base.PracticeRediff_TestBase;
import com.qa.practicerediff.pages.LogoutTestPage;

public class RediffPractice_LogoutTest extends PracticeRediff_TestBase {
	public RediffPractice_LogoutTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowsewrAndOpenApplication(prop.getProperty("browser1"));
		LogoutTestPage logoutTestPage = new LogoutTestPage(driver);
		logoutTestPage.clickOnSignInLink();
		logoutTestPage.enterUserName(prop.getProperty("validEmail"));
		logoutTestPage.enterPassword(prop.getProperty("validPassword"));
		Thread.sleep(2000);
		logoutTestPage.clickOnSignInButton();
		//driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.className("signinbtn")).click();
		
	}
	@Test(priority=1)
	public void signOutMessage() {
		LogoutTestPage logoutTestPage = new LogoutTestPage(driver);
		WebElement logoutLink = logoutTestPage.logOutButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
		
		//WebElement signoutMessage = driver.findElement(By.cssSelector("div.panel p"));
		softassert.assertTrue(logoutTestPage.signOutMessageIsDisplayed(), "signoutMessage is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
