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
 * APR 28 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.PaginationUtility_for_Pages;
import com.bec.reporting.utils.UtilityMethods;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SprintSixAndSevenSteps {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	static String tooltipText_of_avg_score_heading = "Note: Average Score for all standards reports equals (earned points/total points)*100";
	JavascriptExecutor js = (JavascriptExecutor) Driver.webdriver;

	/**
	 * Verifying the comparison band for school and district in class context in
	 * test score page selector
	 * 
	 * @throws Throwable
	 */
	@Then("^Verify the comparison band for school and district$")
	public void verify_the_comparison_band_for_school_and_district() throws Throwable {
		try {
			homePage.compareschoollabel.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.schoolAvgScrInClassInTS.isDisplayed());
			homePage.comparedistrictlabel.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.districtAvgScrInClassInTS.isDisplayed());
			// now, unchecked both the checkbox one by one and verify that result should not
			// display
			homePage.selectedcompareschoollabel.click();
			Thread.sleep(1000);
			Assert.assertTrue(IWait.check_Absence_of_Element(homePage.schoolAvgScrInClassInTS));
			homePage.selectedcomparedistrictlabel.click();
			Thread.sleep(1000);
			Assert.assertTrue(IWait.check_Absence_of_Element(homePage.districtAvgScrInClassInTS));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-649,662 completed");
	}

	@Then("^Verify the tooltipicon in performance over time line chart and student list$")
	public void verify_the_tooltipicon_in_performance_over_time_line_chart_and_student_list() throws Throwable {
		try {
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", homePage.performance_overtime_icon);
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			Thread.sleep(500);
			Assert.assertTrue(homePage.info_icon_on_performance_over_time_header.isDisplayed());
			js.executeScript("arguments[0].click();", homePage.info_icon_on_performance_over_time_header);
			Thread.sleep(1000);
			Assert.assertTrue(homePage.tooltip_of_info_icon.getText().equals(tooltipText_of_avg_score_heading));
			homePage.yaxis_text_label_on_pot_line_chart.click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.performance_overtime_icon).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.info_icon_on_performance_over_time_header.isDisplayed());
			js.executeScript("arguments[0].click();", homePage.info_icon_on_performance_over_time_header);
			Thread.sleep(1000);
			Assert.assertTrue(homePage.tooltip_of_info_icon.getText().equals(tooltipText_of_avg_score_heading));
			homePage.overviewtext.click();
			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-653,BE-681,654 completed");
	}

	@Then("^Verify the tooltipicon in performance over time line chart$")
	public void verify_the_tooltipicon_in_performance_over_time_line_chart() throws Throwable {
		try {
			Thread.sleep(2000);
			Assert.assertTrue(homePage.info_icon_on_performance_over_time_header.isDisplayed());
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", homePage.info_icon_on_performance_over_time_header);
			Thread.sleep(1000);
			Assert.assertTrue(homePage.tooltip_of_info_icon.getText().equals(tooltipText_of_avg_score_heading));
			homePage.overviewtext.click();
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify the tooltipicon is not present$")
	public void verify_the_tooltipicon_is_not_present() throws Throwable {
		Thread.sleep(500);
		IWait.check_Absence_of_Element(homePage.info_icon_on_performance_over_time_header);
		CBTConfiguration.score = "pass";
		log.info("Scenario BE-653 completed");
	}

	/**
	 * This method is used to verify the diamond icon on testname over x-axis on
	 * performance over time line chart
	 * 
	 * @throws Throwable
	 */
	@Then("^verify the diamond shape stroke on the x-axis and Color changes within the Line Charts$")
	public void verify_the_diamond_shape_stroke_on_the_x_axis_and_Color_changes_within_the_Line_Charts()
			throws Throwable {
		try {
			if ((Standard_Overview_Table_Steps.underClassContext)
					&& Standard_Overview_Table_Steps.performanceMenuClicked) {
				// UtilityMethods.wait_For_Page_Section_Load();
				homePage.performance_overtime_icon.click();
				UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();

			}
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_pot_under_standard_performance()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_pot_under_sp.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(
							homePage.circle_list_on_paginator_on_pot_under_sp, i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(j).isDisplayed());
						Thread.sleep(500);
						new Actions(Driver.webdriver)
								.moveToElement(homePage.testScoreValueInCircle_onlinechart_pot.get(j)).click().build()
								.perform();
						Thread.sleep(1000);

						Assert.assertTrue(homePage.highlightedtestName_onlinechart_on_pot.isDisplayed());

						new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click().build()
								.perform();
						Thread.sleep(500);
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages
							.check_Enabled_Left_Arrow_on_Paginator_under_standard_performance()) {
						PaginationUtility_for_Pages
								.clicking_on_enabled_left_Arrow_of_paginator_under_standard_performance();
						PaginationUtility_for_Pages.clicking_on_first_circle_of_paginator(
								homePage.circle_list_on_paginator_on_pot_under_sp);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(j).isDisplayed());
							Thread.sleep(500);
							new Actions(Driver.webdriver)
									.moveToElement(homePage.testScoreValueInCircle_onlinechart_pot.get(j)).click()
									.build().perform();
							Thread.sleep(1000);
							Assert.assertTrue(homePage.highlightedtestName_onlinechart_on_pot.isDisplayed());
							new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click()
									.build().perform();
							Thread.sleep(500);
						}
					}
				} while (PaginationUtility_for_Pages
						.check_Enabled_Left_Arrow_on_Paginator_under_standard_performance());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(i).isDisplayed());
					Thread.sleep(500);
					new Actions(Driver.webdriver).moveToElement(homePage.testScoreValueInCircle_onlinechart_pot.get(i))
							.click().build().perform();
					Thread.sleep(1000);
					Assert.assertTrue(homePage.highlightedtestName_onlinechart_on_pot.isDisplayed());
					new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click().build()
							.perform();
					Thread.sleep(500);
				}
			}
			Standard_Overview_Table_Steps.resetStatus();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-650 and 682 completed");
	}

	@Then("^verify the dotted line and triangle line on line chart based on selection of school and district and class checkbox$")
	public void verify_the_dotted_line_and_triangle_line_on_line_chart_based_on_selection_of_school_and_district_and_class_checkbox()
			throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			boolean isClassComparePresence = false;
			Thread.sleep(3000);
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
			UtilityMethods.wait_For_Page_Section_Load();
			int no = 0;
			homePage.strandnameslist.get(no).click();
			Thread.sleep(3000);

			WebElement el = Driver.webdriver.findElements(By.xpath(
					"//div[@class='overview-table-body']//div[@class='overview-table-row']//div[@class='overview-table-col']["
							+ (no + 2) + "]//li[not(contains(@class,'StandardsNotAvailable'))]"))
					.get(0);
			js.executeScript("arguments[0].click();", el);
			Thread.sleep(5000);
			try {
				// This will execute in case of SP in class context
				new Actions(Driver.webdriver).moveToElement(homePage.performance_overtime_icon).click().build()
						.perform();
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			// selecting school,district,class checkbox
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			try {
				homePage.compareclasslabel.click();
				Thread.sleep(1000);
				Assert.assertTrue(homePage.classpath.getAttribute("stroke").equals("#00539b"));
				isClassComparePresence = true;
			} catch (Exception e) {
				log.info("Compare Class Checkbox is not on SP in Class Context");
			}
			Thread.sleep(1000);

			homePage.compareschoollabel.click();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.schoolpath.getAttribute("stroke").equals("#00539b"));
			homePage.comparedistrictlabel.click();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.districtpath.getAttribute("stroke").equals("#00539b"));
			// De-selecting school and district and class if there.
			homePage.selectedcompareschoollabel.click();
			Thread.sleep(1000);
			try {
				Assert.assertTrue(homePage.schoolpath.isDisplayed());
				log.error("School path is still displaying while de-selecting school checkbox ");
				UtilityMethods.processException(new Exception());
			} catch (Exception e) {
				log.info("School Path is not displaying while de-selecting School checkbox ");
			}

			homePage.selectedcomparedistrictlabel.click();
			Thread.sleep(1000);
			try {
				Assert.assertTrue(homePage.districtpath.isDisplayed());
				log.error("District path is still displaying while de-selecting District checkbox ");
				UtilityMethods.processException(new Exception());
			} catch (Exception e) {
				log.info("District Path is not displaying while de-selecting District checkbox ");
			}

			if (isClassComparePresence) {
				homePage.selectedcompareclasslabel.click();
				Thread.sleep(1000);
				try {
					Assert.assertTrue(homePage.classpath.isDisplayed());
					log.error("classpath is still displaying while de-selecting class checkbox ");
					UtilityMethods.processException(new Exception());
				} catch (Exception e) {
					log.info("classpath is not displaying while de-selecting class checkbox ");
				}
			}
			Standard_Overview_Table_Steps.resetStatus();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-666,685,677,686 completed");
	}

	@Then("^verify the diamond shape stroke on the x-axis and Color changes within the Line Charts within test score menu$")
	public void verify_the_diamond_shape_stroke_on_the_x_axis_and_Color_changes_within_the_Line_Charts_within_test_score_menu()
			throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);

			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsot()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsot.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages
							.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot, i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(j).isDisplayed());
						Thread.sleep(500);
						new Actions(Driver.webdriver)
								.moveToElement(homePage.testScoreValueInCircle_onlinechart_tsot.get(j)).click().build()
								.perform();
						Thread.sleep(1000);

						Assert.assertTrue(homePage.highlightedtestName_onlinechart_on_tsot.isDisplayed());

						new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click().build()
								.perform();

					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot()) {
						PaginationUtility_for_Pages.clicking_on_enabled_left_Arrow_of_paginator_on_tsot();
						PaginationUtility_for_Pages
								.clicking_on_first_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(j).isDisplayed());
							Thread.sleep(500);
							new Actions(Driver.webdriver)
									.moveToElement(homePage.testScoreValueInCircle_onlinechart_tsot.get(j)).click()
									.build().perform();
							Thread.sleep(1000);

							Assert.assertTrue(homePage.highlightedtestName_onlinechart_on_tsot.isDisplayed());

							new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click()
									.build().perform();
						}
					}
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(i).isDisplayed());
					Thread.sleep(500);
					new Actions(Driver.webdriver).moveToElement(homePage.testScoreValueInCircle_onlinechart_tsot.get(i))
							.click().build().perform();
					Thread.sleep(1000);

					Assert.assertTrue(homePage.highlightedtestName_onlinechart_on_tsot.isDisplayed());

					new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click().build()
							.perform();
				}
			}
			Standard_Overview_Table_Steps.resetStatus();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario  BE-678,689,683,684 completed");
	}

	@Then("^verify the diamond shape stroke on the x-axis and Color changes within the Line Charts within test score menu for student$")
	public void verify_the_diamond_shape_stroke_on_the_x_axis_and_Color_changes_within_the_Line_Charts_within_test_score_menu_for_student()
			throws Throwable {
		try {
			UtilityMethods.wait_For_Test_Score_Overview_Section_Load();
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);

			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tso_under_ts_under_student()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tso_under_ts_under_student.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(
							homePage.circle_list_on_paginator_on_tso_under_ts_under_student, i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(j).isDisplayed());
						Thread.sleep(500);
						new Actions(Driver.webdriver)
								.moveToElement(homePage.testScoreValueInCircle_onlinechart_tso.get(j)).click().build()
								.perform();
						Thread.sleep(1000);

						Assert.assertTrue(homePage.highlightedtestName_onlinechart.isDisplayed());
						new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentageon_tso).click().build()
								.perform();
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages
							.check_Enabled_Right_Arrow_on_Paginator_on_tso_under_ts_under_student()) {
						PaginationUtility_for_Pages
								.clicking_on_enabled_right_Arrow_of_paginator_on_tso_under_ts_under_student();
						PaginationUtility_for_Pages.clicking_on_last_circle_of_paginator(
								homePage.circle_list_on_paginator_on_tso_under_ts_under_student);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(j).isDisplayed());
							Thread.sleep(500);
							new Actions(Driver.webdriver)
									.moveToElement(homePage.testScoreValueInCircle_onlinechart_tso.get(j)).click()
									.build().perform();
							Thread.sleep(1000);

							Assert.assertTrue(homePage.highlightedtestName_onlinechart.isDisplayed());
							new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentageon_tso).click()
									.build().perform();
						}
					}
				} while (PaginationUtility_for_Pages
						.check_Enabled_Right_Arrow_on_Paginator_on_tso_under_ts_under_student());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					Assert.assertTrue(homePage.diamondshapesymblonPerPage_onlinechart.get(i).isDisplayed());
					Thread.sleep(500);
					new Actions(Driver.webdriver).moveToElement(homePage.testScoreValueInCircle_onlinechart_tso.get(i))
							.click().build().perform();
					Thread.sleep(500);

					Assert.assertTrue(homePage.highlightedtestName_onlinechart.isDisplayed());
					new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentageon_tso).click().build()
							.perform();
				}
			}
			Standard_Overview_Table_Steps.resetStatus();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario  684_b completed");
	}

}
