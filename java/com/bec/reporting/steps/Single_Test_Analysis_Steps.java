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
 * DEC 15 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.PaginationUtility_for_Pages;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.base.Verify;
import com.google.common.collect.Ordering;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Single_Test_Analysis_Steps {
	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	static JavascriptExecutor js = (JavascriptExecutor) Driver.webdriver;

	@Then("^Verify the key toggle when user click on single test analysis tab and the other tab$")
	public void verify_the_key_toggle_when_user_click_on_single_test_analysis_tab_and_the_other_tab() throws Throwable {
		try {
			js.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();
			String testNameOnCH = UtilityMethods.getTestsNameonUI();

			homePage.testtab.click();
			Thread.sleep(1000);
			Assert.assertTrue(testNameOnCH.equals(homePage.testnameslist_on_test_tab.get(0).getText()));
			Thread.sleep(500);
			WebElement el = Driver.webdriver.findElements(By.xpath(
					"//div[@class='test-results-row-set']//div[@class='test-results-col-full']/preceding-sibling::div/div/input"))
					.get(0);
			Assert.assertTrue(el.getAttribute("value").equals("true"));
			Thread.sleep(500);
			homePage.testtab.click();
			Thread.sleep(1000);
			// BE-1552 performing here
			js.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();
			homePage.reportingkey.click();
			Thread.sleep(1500);
			Assert.assertTrue(homePage.correct_questions_on_reportingkey.isDisplayed());
			Assert.assertTrue(homePage.incorrect_questions_on_reportingkey.isDisplayed());
			Assert.assertTrue(homePage.partial_questions_on_reportingkey.isDisplayed());
			Assert.assertTrue(homePage.not_answered_questions_on_reportingkey.isDisplayed());

			js.executeScript("arguments[0].click();", homePage.testscoresbtn);
			Thread.sleep(4000);
			IWait.check_Absence_of_Element(homePage.correct_questions_on_reportingkey);
			IWait.check_Absence_of_Element(homePage.incorrect_questions_on_reportingkey);
			IWait.check_Absence_of_Element(homePage.partial_questions_on_reportingkey);
			IWait.check_Absence_of_Element(homePage.not_answered_questions_on_reportingkey);

			js.executeScript("arguments[0].click();", homePage.standardperformancebtn);
			Thread.sleep(5000);
			IWait.check_Absence_of_Element(homePage.correct_questions_on_reportingkey);
			IWait.check_Absence_of_Element(homePage.incorrect_questions_on_reportingkey);
			IWait.check_Absence_of_Element(homePage.partial_questions_on_reportingkey);
			IWait.check_Absence_of_Element(homePage.not_answered_questions_on_reportingkey);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 1552,1553 completed");
	}

	@Then("^The Default View Behaviour of the Single Test Analysis when the user clicks on the single test analysis tab$")
	public void the_Default_View_Behaviour_of_the_Single_Test_Analysis_when_the_user_clicks_on_the_single_test_analysis_tab()
			throws Throwable {
		try {
			List<Integer> list = new ArrayList<Integer>();
			
			js.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();
			String testNameOnCH = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(homePage.selectedQuestionRB.isDisplayed());
			Assert.assertTrue(homePage.selectedAllViewCB.isDisplayed());
			Assert.assertTrue(homePage.selectedPercentageRB.isDisplayed());

			log.info("Valiating Question List are in ascending order");
			for (int i = 0; i < homePage.question_list_on_sta.size(); i++) {
				list.add(Integer.parseInt(homePage.question_list_on_sta.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(list));
			log.info("Question List are in ascending order");
			list.clear();

			homePage.testtab.click();
			Thread.sleep(1000);
			Assert.assertTrue(testNameOnCH.equals(homePage.testnameslist_on_test_tab.get(0).getText()));
			Thread.sleep(500);
			Assert.assertTrue(homePage.testscheckboxlistwithinput.get(0).getAttribute("value").equals("true"));
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			Thread.sleep(1000);
			int testCount = homePage.testnameslist_on_test_tab.size();
			int index=UtilityMethods.generateRandomNumberBySkippingIndex(testCount, 0);
			log.info("new selected test is:"+homePage.testnameslist_on_test_tab.get(index).getText());
			homePage.testnameslist_on_test_tab.get(index).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.testscheckboxlistwithinput.get(0).getAttribute("value").equals("false"));
			Thread.sleep(500);

			homePage.testapplybtn.click();		
			UtilityMethods.scrollPageUp(Driver.webdriver);
			UtilityMethods.wait_For_STA_Section_Load();
			testNameOnCH = UtilityMethods.getTestsNameonUI();

			homePage.district_expand_less_in_sta.click();
			Thread.sleep(500);
			String per="";
			for (int i = 0; i < homePage.district_avg_list_for_question_on_sta.size(); i++) {
				per=homePage.district_avg_list_for_question_on_sta.get(i).getText();
				list.add(Integer.parseInt(per.substring(0,per.length()-1)));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(list));
			log.info("Average List in District Column are in ascending order");
			list.clear();

			homePage.district_expand_more_in_sta.click();
			Thread.sleep(500);

			for (int i = 0; i < homePage.district_avg_list_for_question_on_sta.size(); i++) {
				per=homePage.district_avg_list_for_question_on_sta.get(i).getText();
				list.add(Integer.parseInt(per.substring(0,per.length()-1)));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(list));
			log.info("Average List in District Column are in Descending order");
			list.clear();
			/* This logic is to validate the table data in view with db */
			Thread.sleep(2000);
			homePage.filter_in_sta_for_district.click();
			Thread.sleep(1000);
			log.info("Verifying Sort By, View and Avg Score on Filter");
			Assert.assertTrue(homePage.filter_title_on_sta.get(0).getText().equals("Sort by:"));
			Assert.assertTrue(homePage.filter_title_on_sta.get(1).getText().equals("View:"));
			Assert.assertTrue(homePage.filter_title_on_sta.get(2).getText().equals("Average Score:"));

			homePage.view_rb_on_filter_in_sta.click();
			Thread.sleep(500);
			homePage.apply_button_on_filter_in_sta.click();
			Thread.sleep(2000);

			Assert.assertTrue(homePage.view_columns_list_on_table_on_sta.get(0).getText().equals("View"));
			Assert.assertTrue(homePage.view_columns_list_on_table_on_sta.get(1).getText().equals("Question"));

			List<String> ui_short_value_list = new ArrayList<String>();
			List<String> ui_question_list = new ArrayList<String>();
			List<String> ui_test_score_avg_list = new ArrayList<String>();
			UtilityMethods.scrollPageDown(Driver.webdriver, 33);
			Thread.sleep(500);
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_sta()) {
				// this loop will execute for the no. of circle available on paginator
				for (int i = 0; i < homePage.circle_list_on_paginator_on_sta.size(); i++) {
					new Actions(Driver.webdriver).moveToElement(homePage.circle_list_on_paginator_on_sta.get(i)).build().perform();
					Thread.sleep(500);
					
					PaginationUtility_for_Pages
							.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_sta, i);
					
					for (int j = 0; j < homePage.records_on_sta.size(); j++) {
						ui_short_value_list.add(homePage.short_values_on_sta.get(j).getText());
						ui_question_list.add(homePage.questions_values_on_sta.get(j).getText());
						ui_test_score_avg_list.add(homePage.test_score_values_on_sta.get(j).getText());
					}
				}
				
				// check for right arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Right_Arrow_on_Paginator_on_sta()) {
						PaginationUtility_for_Pages.clicking_on_enabled_right_Arrow_of_paginator_on__sta();
						PaginationUtility_for_Pages
								.clicking_on_last_circle_of_paginator(homePage.circle_list_on_paginator_on_sta);
						
						for (int j = 0; j < homePage.records_on_sta.size(); j++) {
							ui_short_value_list.add(homePage.short_values_on_sta.get(j).getText());
							ui_question_list.add(homePage.questions_values_on_sta.get(j).getText());
							ui_test_score_avg_list.add(homePage.test_score_values_on_sta.get(j).getText());
						}
					}
				} while (PaginationUtility_for_Pages.check_Enabled_Right_Arrow_on_Paginator_on_sta());
			} else {
				// when paginator is not found
				
				for (int i = 0; i < homePage.records_on_sta.size(); i++) {
					ui_short_value_list.add(homePage.short_values_on_sta.get(i).getText());
					ui_question_list.add(homePage.questions_values_on_sta.get(i).getText());
					ui_test_score_avg_list.add(homePage.test_score_values_on_sta.get(i).getText());
				}
			}
		
			Assert.assertTrue(ui_short_value_list.size() >= 1);
			Assert.assertTrue(ui_test_score_avg_list.size() >= 1);
			Assert.assertTrue(ui_question_list.size() >= 1);

			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			homePage.filter_in_sta_for_district.click();
			Thread.sleep(1000);
			homePage.raw_rb_on_filter_in_sta.click();
			Thread.sleep(500);
			homePage.apply_button_on_filter_in_sta.click();
			Thread.sleep(2000);

			for (int i = 0; i < homePage.district_wise_avg_list_on_sta.size(); i++) {

				Assert.assertTrue(homePage.district_wise_avg_list_on_sta.get(i).getText().contains("/"));
			}

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 1554,1559,1560,1561,1562,1563,1569,1570,1571,1572 completed");
	}

	@Then("^veryfy Teacher label to Context Header for the School Admins for teacher \"([^\"]*)\"$")
	public void veryfy_Teacher_label_to_Context_Header_for_the_School_Admins_for_teacher(String teacherName)
			throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.contextheader_title_list.get(0).getText().contains("Teacher"));

			homePage.rostertab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
			Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			Thread.sleep(500);

			Assert.assertTrue(homePage.teachersdropdownbtn.isDisplayed());

			if (homePage.teachersdropdownbtn.getText().equals("All")) {
				Assert.assertTrue(homePage.contextheader_text_list.get(0).getText().equals("All"));
			}

			homePage.teachersdropdownbtn.click();
			Thread.sleep(1000);
			UtilityMethods.scrollPageDown(Driver.webdriver, 6);
			Thread.sleep(500);
			homePage.teacherslist.get(0).click();
			Thread.sleep(500);

			Driver.webdriver.findElement(By.xpath(
					"//div[@class='menu-title' and contains(text(),'Teacher')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//li[.='"
							+ teacherName + "']"))
					.click();
			Thread.sleep(1000);
			homePage.teachersdropdownbtn.click();
			Thread.sleep(1000);
			
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			Assert.assertTrue(homePage.contextheader_text_list.get(1).getText().equals(teacherName));

			js.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();

			homePage.studentmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(2).getText().equals("District"));
			
			for (int i = 0; i < homePage.compare_cb_list_on_sta.size(); i++) {
				new Actions(Driver.webdriver).moveToElement(homePage.compare_cb_list_on_sta.get(i)).click().build().perform();
				Thread.sleep(1000);
			}

			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("Student"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("Class"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(2).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(3).getText().equals("District"));

			log.info("Comparison checkbox in Student menu with columns order validation successfull...");

			homePage.classmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(1).getText().equals("District"));
			

			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(2).getText().equals("District"));

			log.info("Comparison checkbox in Class menu with columns order validation successfull...");

			homePage.schoolmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("District"));			
			
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("District"));

			log.info("Comparison checkbox in School menu with columns order validation successfull...");

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 1555,1556 completed");
	}

	@Then("^verify On clicking the individual question should switch to Question Filter report - Single Test Analysis$")
	public void verify_On_clicking_the_individual_question_should_switch_to_Question_Filter_report_Single_Test_Analysis()
			throws Throwable {
		try {
			Thread.sleep(5000);
			js.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();
			homePage.filter_in_sta_for_district.click();
			Thread.sleep(1000);
			homePage.view_rb_on_filter_in_sta.click();
			Thread.sleep(500);
			homePage.apply_button_on_filter_in_sta.click();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.view_columns_list_on_table_on_sta.get(0).getText().equals("View"));
			Assert.assertTrue(homePage.view_columns_list_on_table_on_sta.get(1).getText().equals("Question"));
			int x = (int) (homePage.single_question_in_question_column_on_table_on_sta.size() * Math.random());
			Actions act = new Actions(Driver.webdriver);
			act.moveToElement(homePage.single_question_in_question_column_on_table_on_sta.get(x)).build().perform();
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			homePage.single_question_in_question_column_on_table_on_sta.get(x).click();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.view_columns_list_on_table_on_sta.get(0).getText().equals("Question"));
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			homePage.filter_in_sta_for_district.click();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.question_rb_on_filter_in_sta.getAttribute("class")
					.contains("bec_singleTest_selected_radio_btn"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 1568 completed");
	}

}
