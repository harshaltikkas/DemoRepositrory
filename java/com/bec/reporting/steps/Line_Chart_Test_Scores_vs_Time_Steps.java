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
 * FEB 11 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.PaginationUtility_for_Pages;
import com.bec.reporting.utils.UtilityMethods;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Line_Chart_Test_Scores_vs_Time_Steps {
	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);

	String tooltiptext, attr;

	/**
	 * This method used to verify the y-axis label as Test Scores , verify
	 * horizontal line sum as 11 and the lines lables
	 * 
	 * @throws Throwable
	 */
	@Then("^verify y-axis labeled with as Test Scores\\(%\\) and also verify (\\d+) horizontal lines, one for x axis line and rest label with (\\d+) throught (\\d+)$")
	public void verify_y_axis_labeled_with_as_Test_Scores_and_also_verify_horizontal_lines_one_for_x_axis_line_and_rest_label_with_throught(
			int arg1, int arg2, int arg3) throws Throwable {
		try {
			int range = 0;
			List<WebElement> list;
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			try {
			Assert.assertTrue(homePage.yaxistexton_linechart_tsot.getText().equals("Test Scores (%)"));
			Assert.assertTrue(homePage.horizontalline_onlinechart_tsot.size() == 11);
			list = homePage.yaxislabelsonhorizontalline_onlinechart;
			}
			catch(Exception e) {
				Assert.assertTrue(homePage.yaxistexton_linechart_tsot_withsmallo.getText().equals("Test Scores (%)"));
				Assert.assertTrue(homePage.horizontalline_onlinechart_tsot_withsmallo.size() == 11);
				list = homePage.yaxislabelsonhorizontalline_onlinechart_withsmallo;
			}
			for (int i = 0; i < list.size(); i++) {
				Assert.assertTrue(Integer.parseInt(list.get(i).getText()) == range);
				range += 10;
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 31 and/or Scenario39_1_standard performance line chart Completed");
	}

	/**
	 * This method used to verify x-axis label on line chart test score over time
	 * and the names of test list on graph with elipsis and tooltip text.
	 * 
	 * @throws Throwable
	 */
	@Then("^verify x-axis labeled with 'Test Names' and show tooltip if elipsis in test names and if more than '(\\d+)' tests are there then paginator should be display$")
	public void verify_x_axis_labeled_with_Test_Names_and_show_tooltip_if_elipsis_in_test_names_and_if_more_than_tests_are_there_then_paginator_should_be_display(
			int arg1) throws Throwable {
		try {
			
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);
			Assert.assertTrue(homePage.testnameslabel_onlinechart_tsot.getText().equals("Test Names"));
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsot()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsot.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot,i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						PaginationUtility_for_Pages.verifyTestNamesAndToolTipText(j);
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot()) {
						PaginationUtility_for_Pages.clicking_on_enabled_left_Arrow_of_paginator_on_tsot();
						PaginationUtility_for_Pages.clicking_on_first_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							PaginationUtility_for_Pages.verifyTestNamesAndToolTipText(j);
						}
					} 
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.verifyTestNamesAndToolTipText(i);
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 32 and/or Scenario39_2 standard performance line chart Completed");
	}

	/**
	 * This method is used to check on class context menu the test score circle
	 * value with specified range value with the associated colour
	 * 
	 * @throws Throwable
	 */
	@Then("^verify The points on the chart should be circles that are color-coordinated according to achievement level$")
	public void verify_The_points_on_the_chart_should_be_circles_that_are_color_coordinated_according_to_achievement_level()
			throws Throwable {
		try {			
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsot()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsot.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot,i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						UtilityMethods.verifyColorAndScoreOnLineChart(
								homePage.testScoreCircleClronPerPage_onlinechart.get(j),
								Integer.parseInt(homePage.testScoresonPerPage_onlinechart.get(j).getText()));
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot()) {
						PaginationUtility_for_Pages.clicking_on_enabled_left_Arrow_of_paginator_on_tsot();
						PaginationUtility_for_Pages.clicking_on_first_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							UtilityMethods.verifyColorAndScoreOnLineChart(
									homePage.testScoreCircleClronPerPage_onlinechart.get(j),
									Integer.parseInt(homePage.testScoresonPerPage_onlinechart.get(j).getText()));
						}
					} 
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			}
			else {
				// when paginator is not found
				for (int i = 0; i < homePage.testNamesonPerPage_onlinechart.size(); i++) {
					UtilityMethods.verifyColorAndScoreOnLineChart(
							homePage.testScoreCircleClronPerPage_onlinechart.get(i),
							Integer.parseInt(homePage.testScoresonPerPage_onlinechart.get(i).getText()));
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 33 & 34 Completed");
	}

	/**
	 * This method is used to verify the tooltip's avg score and circle's avg score
	 * and also verify while clicking on outside the tooltip ,it should disappear
	 * 
	 * @throws Throwable
	 */
	@Then("^Verify the overlay should be closed and other is open if click on other circle$")
	public void verify_the_overlay_should_be_closed_and_other_is_open_if_click_on_other_circle() throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsot()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsot.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot,i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						PaginationUtility_for_Pages.verifyTestScorePerAndPerOnToolTip(j);
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot()) {
						PaginationUtility_for_Pages.clicking_on_enabled_left_Arrow_of_paginator_on_tsot();
						PaginationUtility_for_Pages.clicking_on_first_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							PaginationUtility_for_Pages.verifyTestScorePerAndPerOnToolTip(j);
						}
					} 
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.verifyTestScorePerAndPerOnToolTip(i);
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 35 Completed");
	}
}
