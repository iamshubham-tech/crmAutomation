package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automation.utils.ConfigReader;
import com.automation.utils.Constants;

public class BaseClassSuite {

ConfigReader configReader = new ConfigReader();

public static WebDriver driver;
public String APPURL = configReader.getAppUrl();
public String USERNAME = configReader.getUsername();
public String PASSWORD = configReader.getPassword();
public String chromePath = configReader.getChromePath();
public String firefoxPath = configReader.getfirefoxPath();
	
	@Parameters({"browser"})
	@BeforeClass
	public void startSetup(String browser) throws InterruptedException
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
		} else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",firefoxPath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(APPURL);
		Thread.sleep(2000);
	}
	
	
	public void quickAddCOntact(String firstName, String lastName) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'New')]")).click();
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		driver.findElement(By.name("last_name")).sendKeys(lastName);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(Constants.MEDIUM_WAIT);
	}
	
	@AfterClass
	public void endSession()
	{
		driver.quit();
	}
	
	
	
}
