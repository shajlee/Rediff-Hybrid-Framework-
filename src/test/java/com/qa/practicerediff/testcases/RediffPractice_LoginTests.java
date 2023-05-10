package com.qa.practicerediff.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.practicerediff.base.PracticeRediff_TestBase;
import com.qa.practicerediff.pages.LoginTestsPage;
import com.qa.practicerediff.testdata.SupplyTestData;
import com.qa.practicerediff.utilities.PracticeRediff_Utilities;

public class RediffPractice_LoginTests extends PracticeRediff_TestBase {
	public RediffPractice_LoginTests() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowsewrAndOpenApplication(prop.getProperty("browser1"));
		LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
		loginTestsPage.clickOnsignInLink();
		//driver.findElement(By.linkText("Sign in")).click();
	}
	@Test(priority=1, dataProvider = "rediffExcellDataWithDataProvider", dataProviderClass = SupplyTestData.class )
	public void logInWithValidCredentials(String username, String password) {
		LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
		loginTestsPage.Enterusername(username);
		loginTestsPage.EnterPassword(password);
		loginTestsPage.clockOnSignInButton();
		//driver.findElement(By.id("login1")).sendKeys(username);
		//driver.findElement(By.id("password")).sendKeys(password);
		//driver.findElement(By.className("signinbtn")).click();
		//WebElement settingsButton = driver.findElement(By.cssSelector("a.rd_setting_panel"));
		softassert.assertTrue(loginTestsPage.settingsButtonIsDisplayedAndEnabled(), "settingsButton is not displayed or enabled");
		softassert.assertAll();
	}
	@Test(priority=2)
	public void loginWithInvalidCredentials() {
		LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
		loginTestsPage.Enterusername(PracticeRediff_Utilities.generateEmailWithTimeStamp());
		loginTestsPage.EnterPassword(PracticeRediff_Utilities.generatePasswordWithTimeStamp());
		loginTestsPage.clockOnSignInButton();
		//driver.findElement(By.id("login1")).sendKeys(PracticeRediff_Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("password")).sendKeys(PracticeRediff_Utilities.generatePasswordWithTimeStamp());
		//driver.findElement(By.className("signinbtn")).click();
		//WebElement InvalidCredErrorMessage = driver.findElement(By.cssSelector("div#div_login_error"));
		softassert.assertTrue(loginTestsPage.invalidCredentialsErrorMessageIsDisplayed(), "InvalidCredErrorMessage is not displayed");
		softassert.assertAll();
	}
	@Test(priority=3)
	public void loginWithValidUsernameInvalidPassword() {
		LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
		loginTestsPage.Enterusername(prop.getProperty("validEmail"));
		loginTestsPage.EnterPassword(PracticeRediff_Utilities.generatePasswordWithTimeStamp());
		loginTestsPage.clockOnSignInButton();
		//driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("password")).sendKeys(PracticeRediff_Utilities.generatePasswordWithTimeStamp());
		//driver.findElement(By.className("signinbtn")).click();
		//WebElement InvalidPasswordErrorMessage = driver.findElement(By.cssSelector("div#div_login_error"));
		softassert.assertTrue(loginTestsPage.invalidPasswordErrorMessageIsDisplayed(), "InvalidPasswordErrorMessage is not displayed");
		softassert.assertAll();
	}
	@Test(priority=4)
	public void loginWithInvalidUsernameValidPassword() {
		LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
		loginTestsPage.Enterusername(PracticeRediff_Utilities.generateEmailWithTimeStamp());
		loginTestsPage.EnterPassword(prop.getProperty("validPassword"));
		loginTestsPage.clockOnSignInButton();
		//driver.findElement(By.id("login1")).sendKeys(PracticeRediff_Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.className("signinbtn")).click();
		//WebElement InvalidUsernameErrorMessage = driver.findElement(By.cssSelector("div#div_login_error"));
		softassert.assertTrue( loginTestsPage.invalidUsernameErrorMessageIsDisplayed(), "InvalidUsernameErrorMessage is not displayed");
		softassert.assertAll();
	}
	@Test(priority = 5)
	public void loginWithUsernameAndNoPassword() {
		LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
		loginTestsPage.Enterusername(prop.getProperty("validEmail"));
		loginTestsPage.clockOnSignInButton();
		//driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.className("signinbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertTextPassword = prop.getProperty("actualAlertTextPassword");
		String expectedAlertTextPassword = alert.getText();
		
		softassert.assertEquals(actualAlertTextPassword, expectedAlertTextPassword);
		if(actualAlertTextPassword.equals(expectedAlertTextPassword)) {
			alert.accept();
		}else {
			alert.dismiss();
		}
		softassert.assertAll();
	}
    @Test(priority = 6)
    public void loginWithNoUsernameandPassword() {
    	LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
    	loginTestsPage.EnterPassword(prop.getProperty("validPassword"));
    	loginTestsPage.clockOnSignInButton();
    	//driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.className("signinbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertTextUsername = prop.getProperty("actualAlertTextUsername");
		String expectedAlertTextUsername = alert.getText();
		
		softassert.assertEquals(actualAlertTextUsername, expectedAlertTextUsername);
		if(actualAlertTextUsername.equals(expectedAlertTextUsername)) {
			alert.accept();
		}else {
			alert.dismiss();
		}
		softassert.assertAll();
	}
    @Test(priority = 7)
	public void loginWithNoCredentials() {
    	LoginTestsPage loginTestsPage = new LoginTestsPage(driver);
    	loginTestsPage.clockOnSignInButton();
		//driver.findElement(By.className("signinbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertTextNoCredentials = prop.getProperty("actualAlertTextNoCredentials");
		String expectedAlertTextNoCredentials = alert.getText();
		
		softassert.assertEquals(actualAlertTextNoCredentials, expectedAlertTextNoCredentials);
		if(actualAlertTextNoCredentials.equals(expectedAlertTextNoCredentials)) {
			alert.accept();
		}else {
			alert.dismiss();
		}
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}

}
