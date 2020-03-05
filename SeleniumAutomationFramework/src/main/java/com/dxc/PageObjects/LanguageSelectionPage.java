package com.dxc.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LanguageSelectionPage extends BasePage
{
	
	
	@FindBy(id="btnEnglish")
	public WebElement buttonEnglish;
	
	
	public LoginPage clickLanguageButton()
	{
		buttonEnglish.click();
		return (LoginPage) openPage(LoginPage.class);
	}
	
	public LanguageSelectionPage open()
	{
		return (LanguageSelectionPage) openPage(LanguageSelectionPage.class);
	}
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		 return ExpectedConditions.visibilityOf(buttonEnglish);
	}

}
