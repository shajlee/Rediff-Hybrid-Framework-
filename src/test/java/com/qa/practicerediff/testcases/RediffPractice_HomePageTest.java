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
import com.qa.practicerediff.pages.HomeTestPage;

public class RediffPractice_HomePageTest extends PracticeRediff_TestBase {
	public RediffPractice_HomePageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowsewrAndOpenApplication(prop.getProperty("browser1"));
		HomeTestPage homeTestPage = new HomeTestPage(driver);
		homeTestPage.clickOnSignInLink();
		homeTestPage.enterUserName(prop.getProperty("validEmail"));
		homeTestPage.enterPassword(prop.getProperty("validPassword"));
		homeTestPage.clickOnSignInButton();
		//driver.findElement(By.linkText("Sign in")).click();
		//driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.className("signinbtn")).click();
	}
	@Test(priority = 1)
	public void logoutPageRediffLogo() {
		HomeTestPage homeTestPage = new HomeTestPage(driver);
		WebElement logoutLink = homeTestPage.logOutButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
		homeTestPage.clicOnRediffHome();
		//driver.findElement(By.cssSelector("div.header div a img")).click();
		
		//WebElement rediffLogo = driver.findElement(By.cssSelector("span.hmsprite.logo"));
		softassert.assertTrue(homeTestPage.rediffLogoIsDisplayed(), "rediffLogo is not displayed");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		

}
}
