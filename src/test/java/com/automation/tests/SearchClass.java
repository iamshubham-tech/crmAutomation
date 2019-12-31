package com.automation.tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchClass {

	public static void main(String[] args) throws InterruptedException {
		String item = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter keyword you want to search");
		item = s.nextLine();

		letsSearchIt(item);
	}

	public static void letsSearchIt(String searchItem) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SPimple\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");

		driver.findElement(By.xpath("//input[@name='q' and @title='Search']")).sendKeys(searchItem);
		driver.findElement(By.xpath("//input[@name='q' and @title='Search']")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		
		int numOfRecords = driver.findElements(By.xpath("//div[@class='srg']/div")).size();
		System.out.println("Number of search records are "+numOfRecords);
		driver.quit();
	}
}
