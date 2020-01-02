package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LoginPage;
import com.automation.utils.Constants;

import reusables.Logout;

public class TC1 extends BaseClassSuite {

	@Test
	public void execute() throws InterruptedException
	{
	
		LoginPage lp = new LoginPage();
		HomePage hp = new HomePage();
		Thread.sleep(5000);
		lp.login(USERNAME, PASSWORD);
		Thread.sleep(Constants.LONG_WAIT);
	    hp.navigateToContacts();
	    Thread.sleep(Constants.LONG_WAIT);
	    tagFromList("Barry Allen","Name");
		Thread.sleep(Constants.SHORT_WAIT);
		Logout.execute(this);
	}
}
