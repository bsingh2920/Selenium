package com.dxc.TestUtilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentManager {

	private static ExtentReports extent;
	//private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "./extentreport.html";


	public static ExtentReports GetExtent() {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			extent.setSystemInfo("Host Name", "Bhupinder@Java");
			
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	public static ExtentHtmlReporter getHtmlReporter() {

		htmlReporter = new ExtentHtmlReporter(filePath);
		/*htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("IdentHQ Automation Report");
		htmlReporter.config().setReportName("Automation");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		*/
		htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extentConfig\\ReportsConfig.xml");
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\extentConfig\\ReportsConfig.xml");
		return htmlReporter;
	}


}
