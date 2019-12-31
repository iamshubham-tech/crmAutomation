package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.tests.BaseClassSuite;

public class HomePage extends BaseClassSuite {

	@FindBy(xpath="//div[@id='main-nav']/a/span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	public HomePage() {
    
		PageFactory.initElements(driver, this);
		
	}
	
	public void navigateToContacts()
	{
		contacts.click();
		
	}
}
