/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * JAN 04 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.FileRead;
import com.bec.reporting.utils.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

	public static String reportBrowser;
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);

	/**
	 * This is pre scenario executing method to launch the browser
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Before
	public void openBrowser() throws InterruptedException, IOException {
		try {
			log.info(
					"***********************************************************************************************************");
			String browser;
			Properties p = FileRead.readProperties();
			if (System.getProperty("browser") == null) {
				browser = p.getProperty("default_browser_Name");
			} else {
				browser = System.getProperty("browser");
			}
			log.info(" Launch Browser: " + "\"" + browser + "\"" + " on Environment:" + p.getProperty("app_env"));
			Driver.webdriver = Driver.getCurrentDriver(p.getProperty("seleniumEnvironment"), browser);
			reportBrowser = browser;
			Reporter.assignAuthor("BenchMark Universal - Automation Tool");
		} catch (Exception e) {
			log.error("Error in initialization in Hook File...", e);
		}
	}

	/**
	 * This is post scenario executing method to capture screenshot and crossbrowser
	 * testing
	 * 
	 * @param scenario
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@After
	public void after(Scenario scenario) throws FileNotFoundException, IOException {
		if (Driver.crossbrwr) {
			Driver.crossBrowserSetting();
		}
		if (scenario.isFailed()) {
			Driver.embedScreenshot(scenario);
		}
	}	
}
