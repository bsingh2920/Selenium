package com.dxc.TestUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}
	
	public static void MaximizeBrowser()
	{
		DriverManager.getDriver().manage().window().maximize();
	}
	
	public static void setImplictTWait()
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
}
