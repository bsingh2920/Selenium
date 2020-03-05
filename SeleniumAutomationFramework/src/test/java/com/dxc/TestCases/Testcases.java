package com.dxc.TestCases;

import org.testng.annotations.Test;

import com.dxc.PageObjects.LanguageSelectionPage;
import com.dxc.SetUp.TestSetUp;

public class Testcases extends TestSetUp {

	@Test
	public void navigateToLandingPage()
	{
		LanguageSelectionPage ts = new LanguageSelectionPage();
		ts.open().clickLanguageButton();
		
		
	}
}
