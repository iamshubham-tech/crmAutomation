package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@Parameters({ "browser" })
	@BeforeClass
	public void startSetup(String browser) throws InterruptedException {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(APPURL);
		Thread.sleep(2000);
	}

	public void quickAddCOntact(String firstName, String lastName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'New')]")).click();
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		driver.findElement(By.name("last_name")).sendKeys(lastName);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(Constants.MEDIUM_WAIT);
	}

	public static void tagFromList(String recName, String columnName) {
		int cnt = 0;
		int colNum = driver.findElements(By.xpath("//table/thead/tr/th")).size();

		for (int i = 1; i <= colNum; i++) {
			
			if (driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText().equals(columnName)) {
				System.out.println("pass");
				cnt++;
				break;
			}
			cnt++;
			
		}
		int rowNum = driver.findElements(By.xpath("//table/tbody/tr")).size();

		for (int i = 1; i <= rowNum; i++) {

			if (driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + cnt + "]")).getText().equals(recName)) {
				
				WebElement checkBox = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + cnt + "]/../td["+i+"]/div/input"));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", checkBox);
				
				break;
			}
		}

	}

	@AfterClass
	public void endSession() {
		driver.quit();
	}

}
