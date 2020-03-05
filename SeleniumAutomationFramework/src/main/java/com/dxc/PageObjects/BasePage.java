package com.dxc.PageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dxc.SetUp.TestSetUp;
import com.dxc.TestUtilities.DriverManager;


public abstract class BasePage<T> extends TestSetUp {
public int driverTimeOut=10;
public int Ajax_Time_Out=20;
	
	public T openPage(Class<T> clazz)
	{
		T page= null;
		AjaxElementLocatorFactory ajaxf = new AjaxElementLocatorFactory(DriverManager.getDriver(),driverTimeOut);
		page= PageFactory.initElements(DriverManager.getDriver(), clazz);
		PageFactory.initElements(ajaxf, page);
			
		ExpectedCondition pageLoadCondition=((BasePage) page).getPageLoadCondition();
				
		waitForPageLoad(pageLoadCondition);
		
		return page;
	}
	
	public abstract ExpectedCondition getPageLoadCondition();
	
	public void waitForPageLoad(ExpectedCondition pageLoadCondition)
	{
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),driverTimeOut);
		wait.until(pageLoadCondition);
	}
	
}
