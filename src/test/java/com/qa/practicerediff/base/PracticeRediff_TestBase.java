package com.qa.practicerediff.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.practicerediff.utilities.PracticeRediff_Utilities;

public class PracticeRediff_TestBase {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static Properties prop;
	
	public PracticeRediff_TestBase() throws Exception {
		prop = new Properties();
		FileInputStream Ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\practicerediff\\propertiesfiles\\configuration.Properties");
		prop.load(Ip);
		}
	public WebDriver initializeBrowsewrAndOpenApplication(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			optionsC.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(optionsC);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver(optionsF);
		}else if(browserName.equalsIgnoreCase("edge")) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			optionsE.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new EdgeDriver(optionsE);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PracticeRediff_Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PracticeRediff_Utilities.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(PracticeRediff_Utilities.SCRIPT_TIMEOUT));
		driver.manage().deleteAllCookies();
		
		return driver;
		
		
	}
	}


