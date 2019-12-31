package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.tests.BaseClassSuite;

public class LoginPage extends BaseClassSuite{

	

	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	WebElement loginButton;
	
	public LoginPage() {

	
	PageFactory.initElements(driver, this);
		
	}
	
	public void login(String un, String pwd)
	{
	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
	}
}
