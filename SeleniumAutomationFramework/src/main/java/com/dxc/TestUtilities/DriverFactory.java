package com.dxc.TestUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	
	public static String chromeExeFilepath;
	public static String ieExplorerExeFilePath;
	
	public static String getChromeExeFilepath() {
		return chromeExeFilepath;
	}

	public static void setChromeExeFilepath(String chromeExeFilepath) {
		DriverFactory.chromeExeFilepath = chromeExeFilepath;
	}

	public static String getIeExplorerExeFilePath() {
		return ieExplorerExeFilePath;
	}

	public static void setIeExplorerExeFilePath(String ieExplorerExeFilePath) {
		DriverFactory.ieExplorerExeFilePath = ieExplorerExeFilePath;
	}

	
	
	public static void createDriverInstance(String browserName)
	{
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeExeFilepath());
			driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.MaximizeBrowser();
			DriverManager.setImplictTWait();
			
		}
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DriverFactory.ieExplorerExeFilePath);
			driver= new InternetExplorerDriver();
			DriverManager.setDriver(driver);
			DriverManager.MaximizeBrowser();
			DriverManager.setImplictTWait();
		}
	}
	public static void destroyDriver()
	{
		DriverManager.getDriver().quit();
	
	}
	
}
