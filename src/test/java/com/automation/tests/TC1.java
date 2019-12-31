package com.automation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LoginPage;

public class TC1 extends BaseClassSuite {

	@Test
	public void execute() throws InterruptedException
	{
	
		LoginPage lp = new LoginPage();
		HomePage hp = new HomePage();
		Thread.sleep(5000);
		lp.login(USERNAME, PASSWORD);
	    hp.navigateToContacts();
	    quickAddCOntact("Barry", "Allen");
		
		
	}
}
