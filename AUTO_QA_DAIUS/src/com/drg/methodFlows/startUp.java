package com.drg.methodFlows;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.cvas.qa.POM.commonPageObjects;
import com.cvas.qa.POM.multiLockerPageObjects;
import com.cvas.qa.POM.portalHomePageObjects;
import com.cvas.qa.portalinfo.browserDetails;
import com.cvas.qa.portalinfo.readProperties;


public class startUp {

	public static LinkedHashMap<String, String> in, inE;
	public static WebDriver driver = null;
	public static LinkedHashSet<String> ll = null;
	public static portalHomePageObjects pom = null;
	public static commonPageObjects cpo;
	public static multiLockerPageObjects mlpo;
	public static commonActions ca;
	
	@BeforeSuite
	public void setup() throws Exception {
		in = readProperties.driverDetails();
		inE = readProperties.inspectE();
		driver = browserDetails.browseEnable(in);
		pom = new portalHomePageObjects(driver);

		cpo = new commonPageObjects(driver);
		mlpo = new multiLockerPageObjects(driver);
		ca = new commonActions();
		
	}

	public static WebDriver driverInvok() throws InterruptedException, IOException {
		return driver;
	}

	@Test
	public void Launch() throws Throwable {
		String PageTitle = driver.getTitle();
		Assert.assertNotNull(PageTitle);
		
	}

	@AfterSuite
	public void closure() {
		//driver.quit();
	}

}