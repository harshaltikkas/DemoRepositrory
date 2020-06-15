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
package com.bec.reporting.tests;

import java.io.File;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import lombok.extern.slf4j.Slf4j;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = { "com.bec.reporting.steps" }, plugin = { "pretty",
		"html:target/cucumber-reports",
		"com.bec.reporting.utils.ExtentCucumberFormatter:target/cucumber-reports/extent_report/report.html",
		"json:target/cucumber-reports/json_report/Cucumber.json",
		"junit:target/cucumber-reports/junit_xml_report/Cucumber.xml",
		"rerun:target/failed_scenarios.txt" },
		tags = { "@Feature" }, 
		monochrome = true)
@Slf4j
public class TestRunnerIT {

	public static Properties config;
	public static Scenario scenario;

	/**
	 * This method is used to copy the extent report at reports folder at desktop
	 */
	@AfterClass
	public static void copy_result_to_report_folder() {
		try {
			// Getting the current date value
			LocalDate currentdate = LocalDate.now();
			String user = System.getProperty("user.name");
			String project_path = System.getProperty("user.dir");

			File srcDir = new File(project_path + "/target/cucumber-reports/extent_report");
			File trgDir = new File("C:/Users/" + user + "/Desktop/Reports/" + currentdate.getMonth() + "-"
					+ currentdate.getYear() + "/extent_report_" + currentdate.getDayOfMonth() + "_"
					+ currentdate.getMonthValue() + "_" + currentdate.getYear());
			if (trgDir.exists()) {
				deleteFolder(trgDir);
				FileUtils.copyDirectory(srcDir, trgDir);
			} else {
				FileUtils.copyDirectory(srcDir, trgDir);
			}
			log.info("Files copied successfully...");
		} catch (Exception e) {
			log.error("Error in copying the extent report folder to report folder " + e.getMessage());
		}
	}

	static void deleteFolder(File file) {
		for (File subFile : file.listFiles()) {
			if (subFile.isDirectory()) {
				deleteFolder(subFile);
			} else {
				subFile.delete();
			}
		}
		file.delete();
	}

}