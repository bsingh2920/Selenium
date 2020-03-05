package com.dxc.SetUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.dxc.TestUtilities.DriverFactory;
import com.dxc.TestUtilities.DriverManager;
import com.dxc.TestUtilities.ExcelReader;
public class TestSetUp {

	public  static Properties configProperty;
	public Properties ORProperty;
	
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Submision.xlsx");
		
	@BeforeSuite
	public void BeforeSuite()
	{
		DriverFactory.setChromeExeFilepath(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		DriverFactory.setIeExplorerExeFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
		try {
			FileInputStream file = new FileInputStream(
					new File(System.getProperty("user.dir")+"\\src\\test\\resources\\propertyFiles\\config.properties"));
			configProperty = new Properties();
			try {
				configProperty.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		
	}
	@BeforeClass
	public void BeforeClass()
	{
		
	}
	@BeforeMethod
	public void BeforeMethod()
	{
		WebDriver driver=null;
		if(driver==null)
		{
			DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
			DriverManager.getDriver().navigate().to(configProperty.getProperty("url"));
		}
		
		
	}
	@AfterMethod
	public void AfterMethod()
	{
		DriverFactory.destroyDriver();
		
			}
	@AfterClass
	public void AfterClass()
	{
		
	}
	@AfterTest
	public void AfterTest()
	{
		
	}
	@AfterSuite
	public void AfterSuite()
	{
		
	}
}
