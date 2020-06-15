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
 * JUN 10 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.awt.Robot;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.API_Connection;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.FileRead;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.UtilityMethods;

import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sprint_Nine_Steps {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	JavascriptExecutor js = (JavascriptExecutor) Driver.webdriver;

	@Then("^To check the grading page in new browser tab should open by clicking on the question number within the test overlay$")
	public void to_check_the_grading_page_in_new_browser_tab_should_open_by_clicking_on_the_question_number_within_the_test_overlay()
			throws Throwable {
		try {
			if (Standard_Overview_Table_Steps.underClassContext
					&& Standard_Overview_Table_Steps.performanceMenuClicked) {
				UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.performance_overtime_icon).click().build()
						.perform();
				UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			} else {
				log.info("This will execute with student context");
			}

			String percentage = homePage.performanceovertimeheader.getText();
			percentage = percentage.substring(percentage.indexOf(":") + 2, percentage.indexOf("%"));
			String no_of_questions = homePage.performanceovertimeheader.getText();
			no_of_questions = no_of_questions.substring(no_of_questions.indexOf("on") + 2,
					no_of_questions.lastIndexOf(" "));
			UtilityMethods.scrollPageDown(Driver.webdriver, 6);
			Thread.sleep(500);
			int randomTestScoreIndex = (int) (Math.random() * homePage.testScoreValueInCircle_onlinechart_pot.size());
			new Actions(Driver.webdriver)
					.moveToElement(homePage.testScoreValueInCircle_onlinechart_pot.get(randomTestScoreIndex)).click()
					.build().perform();
			Thread.sleep(500);
			log.info("verifying the total no. of questions on tooltip");
			Assert.assertTrue(no_of_questions.trim().equals(String.valueOf(homePage.questionlistontooltip.size())));
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = "pass";
		log.info("Scenario BE-832,833,834 completed");
		Standard_Overview_Table_Steps.resetStatus();
	}

	/**
	 * This method is used to verify the Grade Taxonomy on UI from DB as well
	 * 
	 * @throws Throwable
	 */
	@Then("^verify the appearance within the standard performance overview$")
	public void verify_the_appearance_within_the_standard_performance_overview() throws Throwable {
		String output = "fail";
		try {
			if (Standard_Overview_Table_Steps.performanceMenuClicked
					&& Standard_Overview_Table_Steps.underDistrictContext) {
				Assert.assertTrue(homePage.gradeDropDown.isDisplayed());
				output = "pass";
			} else {
				try {
					Assert.assertTrue(homePage.gradeDropDown.isDisplayed());
					UtilityMethods.processException(new Exception());
				} catch (Exception e) {
					output = "pass";
				}
			}

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = output;
		log.info("Scenario BE-835,836 completed");
		Standard_Overview_Table_Steps.resetStatus();
	}

	@Then("^verify Standards Question Filter dropdown label and position within Standard Performance Overview$")
	public void verify_Standards_Question_Filter_dropdown_label_and_position_within_Standard_Performance_Overview()
			throws Throwable {
		String output = "fail";
		try {

			if (Standard_Overview_Table_Steps.performanceMenuClicked) {
				Assert.assertTrue(homePage.questionDropDown.isDisplayed());
				output = "pass";
			} else if (Standard_Overview_Table_Steps.testScoreMenuClicked) {
				try {
					Assert.assertTrue(homePage.questionDropDown.isDisplayed());
					UtilityMethods.processException(new Exception());
				} catch (Exception e) {
					output = "pass";
				}
			}
			CBTConfiguration.score = output;
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		Standard_Overview_Table_Steps.resetStatus();
		log.info("Scenario BE-837 completed");
	}

	@Then("^verify Context header content for the Standards Overview context selected shown in all PDF's$")
	public void verify_Context_header_content_for_the_Standards_Overview_context_selected_shown_in_all_PDF_s()
			throws Throwable {
		String output = "";
		try {
			IWait.check_Absence_of_Element(homePage.takemeback);
			Robot robot = new Robot();
			Properties p = FileRead.readProperties();
			String print_env = p.getProperty("print_env");
			List<String> details = new ArrayList<String>();
			String school, classN, district, tests, dates, assessedWith, teacherN, studentName, grade;
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build().perform();
			Thread.sleep(500);
		
			school = UtilityMethods.getSchoolNameonUI();
			district = UtilityMethods.getDistrictNameonUI();
			grade = UtilityMethods.getGradeNameonUI();
			teacherN = UtilityMethods.getTeacherNameonUI();
			classN = UtilityMethods.getClassNameonUI();
			tests = UtilityMethods.getTestsNameonUI();
			dates = UtilityMethods.getDatesonContextHeaderUI();

			if (Standard_Overview_Table_Steps.performanceMenuClicked
					&& Standard_Overview_Table_Steps.underClassContext) {

				assessedWith = UtilityMethods.getAssessedWithonUI();
				details.add(classN);
				details.add(school);
				details.add(district);
				details.add(dates);
				details.add(tests);
				details.add(assessedWith);
				details.add(grade);
				Assert.assertTrue(homePage.printIcon.isDisplayed());
				homePage.printIcon.click();
				Thread.sleep(500);
				UtilityMethods.Save_PDF(robot, print_env);
				UtilityMethods.Open_PDF_And_Read_Text_And_Verify_Details(details);
				UtilityMethods.Delete_PDF();

				Thread.sleep(500);
				homePage.activePerformanceOverTimePage.click();
				UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();

				teacherN = UtilityMethods.getTeacherNameonUI();
				details.add(teacherN);
				Assert.assertTrue(homePage.printIcon.isDisplayed());
				homePage.printIcon.click();
				Thread.sleep(500);
				UtilityMethods.Save_PDF(robot, print_env);
				UtilityMethods.Open_PDF_And_Read_Text_And_Verify_Details(details);
				UtilityMethods.Delete_PDF();
				details.clear();
				output = "pass";
			} else if (Standard_Overview_Table_Steps.performanceMenuClicked
					&& Standard_Overview_Table_Steps.underStudentContext) {
				studentName = UtilityMethods.getStudentNameonUI();
				assessedWith = UtilityMethods.getAssessedWithonUI();
				details.add(studentName);
				details.add(classN);
				details.add(teacherN);
				details.add(school);
				details.add(district);
				details.add(tests);
				details.add(dates);
				details.add(assessedWith);
				details.add(grade);
				Assert.assertTrue(homePage.printIcon.isDisplayed());
				homePage.printIcon.click();
				Thread.sleep(500);
				UtilityMethods.Save_PDF(robot, print_env);
				UtilityMethods.Open_PDF_And_Read_Text_And_Verify_Details(details);
				UtilityMethods.Delete_PDF();
				details.clear();
				output = "pass";
			} else if (Standard_Overview_Table_Steps.testScoreMenuClicked
					&& Standard_Overview_Table_Steps.underStudentContext) {

				studentName = UtilityMethods.getStudentNameonUI();
				details.add(studentName);
				details.add(classN);
				details.add(teacherN);
				details.add(school);
				details.add(district);
				details.add(tests);
				details.add(dates);
				details.add(grade);
				Assert.assertTrue(homePage.printIcon.isDisplayed());
				homePage.printIcon.click();
				Thread.sleep(500);
				UtilityMethods.Save_PDF(robot, print_env);
				UtilityMethods.Open_PDF_And_Read_Text_And_Verify_Details(details);
				UtilityMethods.Delete_PDF();
				details.clear();
				output = "pass";
			}

			else if (Standard_Overview_Table_Steps.testScoreMenuClicked
					&& Standard_Overview_Table_Steps.underClassContext) {

				details.add(teacherN);
				details.add(classN);
				details.add(school);
				details.add(district);
				details.add(tests);
				details.add(dates);
				details.add(grade);
				// this is clicking for test score over time print btn
				Assert.assertTrue(homePage.printIcon.isDisplayed());
				Assert.assertTrue(homePage.Test_score_detail_printIcon.isDisplayed());
				homePage.printIcon.click();
				Thread.sleep(500);
				UtilityMethods.Save_PDF(robot, print_env);
				UtilityMethods.Open_PDF_And_Read_Text_And_Verify_Details(details);
				UtilityMethods.Delete_PDF();

				homePage.Test_score_detail_printIcon.click();
				Thread.sleep(500);
				UtilityMethods.Save_PDF(robot, print_env);
				UtilityMethods.Open_PDF_And_Read_Text_And_Verify_Details(details);
				UtilityMethods.Delete_PDF();
				details.clear();
				output = "pass";
			}
			CBTConfiguration.score = output;
			Standard_Overview_Table_Steps.resetStatus();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-845 completed");
	}

	/**
	 * This method is used to verify the View Taxonomy on UI
	 * 
	 * @throws Throwable
	 */
	@Then("^verify View Texonomy on Standard Performance$")
	public void verify_View_Texonomy_on_Standard_Performance() throws Throwable {
		String output = "fail", viewDDText = "";
		try {
			if (Standard_Overview_Table_Steps.performanceMenuClicked) {
				Assert.assertTrue(homePage.viewDropDown.isDisplayed());
				if (homePage.viewDropDown.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.viewDropDown).build().perform();
					Thread.sleep(1000);
					viewDDText = homePage.viewDropDownToolTipText.getText();
				} else {
					viewDDText = homePage.viewDropDown.getText();
				}
				Assert.assertTrue(API_Connection.getViewDetails().containsValue(viewDDText));
				output = "pass";
			} else if (Standard_Overview_Table_Steps.testScoreMenuClicked) {
				try {
					Assert.assertTrue(homePage.viewDropDown.isDisplayed());
					UtilityMethods.processException(new Exception());
				} catch (Exception e) {
					output = "pass";
				}
			}

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = output;
		log.info("Scenario View Texonomy display and validation completed");
		Standard_Overview_Table_Steps.resetStatus();
	}

	@Then("^verify csv download functionality$")
	public void verify_csv_download_functionality() throws Throwable {
		File file = null;
		try {
			String user = System.getProperty("user.name");
			String folder = "C:\\Users\\" + user + "\\Downloads";
			String fileName = null;
			//to delete if previous files are not deleted
			UtilityMethods.Delete_CSV(folder);
			/*
			 * String sp_ts_list[] = new String[] { "District Name", "School Name","Grade",
			 * "Teacher Name", "Class Name", "Student Name", "Student ID(SIS)", "Test Type",
			 * "Test Name", "Test Submitted", "Test Graded", "Question Numbers",
			 * "Points Earned", "Total Points", "TestScore %", "Standard", "DOK",
			 * "ELD Domain", "ELD Task", "ELD Standard" };
			 * 
			 * String test_status[] = new String[] { "District Name", "School Name",
			 * "Grade", "Teacher Name", "Class Name", "Student Name", "Student ID(SIS)",
			 * "Test Type", "Test Name", "Assignment Name", "Test Status", "Start Date",
			 * "Due Date", "Submit Date" };
			 */

			IWait.explicit_wait(Driver.webdriver, homePage.csvDownloadIcon);
			homePage.csvDownloadIcon.click();
			Thread.sleep(1000);
			/*
			 * if (API_Connection.getUserRole().equalsIgnoreCase("DISTRICT_ADMIN")) {
			 * test_status = new String[] { "School Name", "Grade", "Teacher Name",
			 * "Class Name", "Test Type", "Test Name", "Assignment Name", "Total Students",
			 * "Not Started", "In Progress", "Needs to Be Graded", "Complete" }; }
			 */
			if (API_Connection.getUserRole().equalsIgnoreCase("SCHOOL_ADMIN")) {
				IWait.explicit_wait(Driver.webdriver, homePage.csv_download_text_on_model);
				Assert.assertTrue(homePage.csv_download_btn_on_model.isDisplayed());
				Assert.assertTrue(homePage.csv_download_cancel_btn_on_model.isDisplayed());
				homePage.csv_download_btn_on_model.click();
				Thread.sleep(1000);
			}

			if (Standard_Overview_Table_Steps.performanceMenuClicked) {
				fileName = "ar_report_csv.csv";
				file = new File(folder + "\\" + fileName);
				UtilityMethods.wait_For_CSV_File_Download(file);
				//UtilityMethods.Verify_Columns_Header_of_CSV(sp_ts_list, file);
			} else if (Standard_Overview_Table_Steps.testScoreMenuClicked) {
				fileName = "ar_report_csv.csv";
				file = new File(folder + "\\" + fileName);
				UtilityMethods.wait_For_CSV_File_Download(file);
				//UtilityMethods.Verify_Columns_Header_of_CSV(sp_ts_list, file);
			} else if (Standard_Overview_Table_Steps.test_status_Menu_Clicked) {
				fileName = "test_status.csv";
				file = new File(folder + "\\" + fileName);
				UtilityMethods.wait_For_CSV_File_Download(file);
				//UtilityMethods.Verify_Columns_Header_of_CSV(test_status, file);
			}
			log.info("After Downloading, deleting the file :" + file.getAbsoluteFile().getName());
			UtilityMethods.Delete_CSV(folder);

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = "pass";
		log.info("Scenario verify csv download functionality for " + file.getAbsoluteFile().getName() + " completed");
		Standard_Overview_Table_Steps.resetStatus();
	}

}
