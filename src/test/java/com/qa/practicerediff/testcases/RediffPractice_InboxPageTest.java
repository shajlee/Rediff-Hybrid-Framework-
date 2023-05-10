package com.qa.practicerediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.practicerediff.base.PracticeRediff_TestBase;
import com.qa.practicerediff.pages.InboxTestPage;

public class RediffPractice_InboxPageTest extends PracticeRediff_TestBase {
	public RediffPractice_InboxPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowsewrAndOpenApplication(prop.getProperty("browser1"));
		InboxTestPage inboxTestPage = new InboxTestPage(driver);
		inboxTestPage.clickOnSignInLink();
		inboxTestPage.enterUserName(prop.getProperty("validEmail"));
		inboxTestPage.enterPassword(prop.getProperty("validPassword"));
		inboxTestPage.clickOnSignInButton();
		//driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.className("signinbtn")).click();
	}
	@Test(priority=1)
	public void inboxButtonPresence() {
		InboxTestPage inboxTestPage = new InboxTestPage(driver);
		//WebElement inboxButton = driver.findElement(By.className("rd_active"));
		softassert.assertTrue(inboxTestPage.inboxButtonIsDisplayedAndEnable(), "inboxButton is not displayed or enabled");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}

}
