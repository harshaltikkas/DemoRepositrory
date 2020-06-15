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
 * June 01 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.utils;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaginationUtility_for_Pages {

	static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);

	/* Paginator under List Under Standard Performance */
	public static boolean checkPaginator_on_list_under_standard_performance() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_list_under_sp).build().perform();
			log.info("Paginator Found in List under Standard Performance");
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found in List under Standard Performance");
			return false;
		}
	}

	public static boolean check_Enabled_Right_Arrow_on_Paginator_on_list_under_sp() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_list_under_sp.isDisplayed();
			return true;
		} catch (Exception e) {
			log.info("Enabled Right Arrow on Paginator is not found");
			return false;
		}
	}

	public static void clicking_on_enabled_right_Arrow_of_paginator_on_list_under_sp() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_list_under_sp.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Right Arrow of Paginator");
			UtilityMethods.processException(e);
		}
	}

	// =======================================================================================================

	/* POT Paginator under class Under Standard Performance */
	public static boolean checkPaginator_on_pot_under_standard_performance() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_pot_under_sp).build().perform();
			log.info("Paginator Found in Performance Over Time under Standard Performance");
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found in POT under Standard Performance");
			return false;
		}
	}

	public static boolean check_Enabled_Left_Arrow_on_Paginator_under_standard_performance() {
		try {
			homePage.enabled_left_arrow_on_paginator_on_pot_under_sp.isDisplayed();
			return true;
		} catch (Exception e) {
			log.info("Enabled Left Arrow on Paginator is not found");
			return false;
		}
	}

	public static void clicking_on_enabled_left_Arrow_of_paginator_under_standard_performance() {
		try {
			homePage.enabled_left_arrow_on_paginator_on_pot_under_sp.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Left Arrow of Paginator");
			UtilityMethods.processException(e);
		}
	}

	// =======================================================================================================

	/* Paginator on Test Score Detail Under Test Score */
	public static boolean checkPaginator_on_tsd() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_list_under_sp).build().perform();
			log.info("Paginator Found in Test Score Detail");
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found in Test Score Detail");
			return false;
		}
	}

	public static boolean check_Enabled_Right_Arrow_on_Paginator_on_tsd() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_list_under_sp.isDisplayed();
			return true;
		} catch (Exception e) {
			log.info("Enabled Right Arrow on Paginator is not found in Test Score Detail");
			return false;
		}
	}

	public static void clicking_on_enabled_right_Arrow_of_paginator_on_tsd() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_list_under_sp.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Right Arrow of Paginator in Test Score Detail");
			UtilityMethods.processException(e);
		}
	}

	// =======================================================================================================
	/* TSOT Paginator under Test Score Under Class */
	public static boolean checkPaginator_on_tsot() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_tsot).build().perform();
			log.info("Paginator Found on Test Score Over Time");
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found on Test Score Over Time");
			return false;
		}
	}

	public static boolean check_Enabled_Left_Arrow_on_Paginator_on_tsot() {
		try {
			homePage.enabled_left_arrow_on_paginator_on_tsot.isDisplayed();
			return true;
		} catch (Exception e) {
			log.info("Enabled Left Arrow on Paginator is not found on Test Score Over Time");
			return false;
		}
	}

	public static void clicking_on_enabled_left_Arrow_of_paginator_on_tsot() {
		try {
			homePage.enabled_left_arrow_on_paginator_on_tsot.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Left Arrow of Paginator on Test Score Over Time");
			UtilityMethods.processException(e);
		}
	}

	// =======================================================================================================
	/* Paginator on Test Score Overview under_Test Score Tab_under_student */
	public static boolean checkPaginator_on_tso_under_ts_under_student() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_tso_under_ts_under_student).build()
					.perform();
			log.info("Paginator Found on Test Score Overview ");
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found on Test Score Overview ");
			return false;
		}
	}

	public static boolean check_Enabled_Right_Arrow_on_Paginator_on_tso_under_ts_under_student() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_tso_under_ts_under_student.isDisplayed();
			return true;
		} catch (Exception e) {
			log.info("Enabled Right Arrow on Paginator is not found in Test Score Overview ");
			return false;
		}
	}

	public static void clicking_on_enabled_right_Arrow_of_paginator_on_tso_under_ts_under_student() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_tso_under_ts_under_student.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Right Arrow of Paginator in Test Score Overview ");
			UtilityMethods.processException(e);
		}
	}

	// =======================================================================================================
	/* Paginator on Single Test Analysis */
	public static boolean checkPaginator_on_sta() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_sta).build().perform();
			log.info("Paginator Found on Single Test Analysis");
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found on Single Test Analysis");
			return false;
		}
	}

	public static boolean check_Enabled_Right_Arrow_on_Paginator_on_sta() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_sta.isDisplayed();
			return true;
		} catch (Exception e) {
			log.info("Enabled Right Arrow on Paginator is not found in Single Test Analysis");
			return false;
		}
	}

	public static void clicking_on_enabled_right_Arrow_of_paginator_on__sta() {
		try {
			homePage.enabled_right_arrow_on_paginator_on_sta.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Right Arrow of Paginator in Single Test Analysis");
			UtilityMethods.processException(e);
		}
	}

	// =======================================================================================================
		/** Paginator on Summary on Test Status**/
		public static boolean checkPaginator_on_summary_in_Test_Status() {
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.paginator_on_summary_in_ts).build().perform();
				log.info("Paginator Found on Summary in Test Status");
				return true;
			} catch (Exception e) {
				log.info("Paginator Not Found on Summary in Test Status");
				return false;
			}
		}

		public static boolean check_Enabled_Right_Arrow_on_Paginator_on_summary_in_Test_Status() {
			try {
				homePage.enabled_right_arrow_on_paginator_on_summary_in_ts.isDisplayed();
				return true;
			} catch (Exception e) {
				log.info("Enabled Right Arrow on Paginator is not found in Summary in Test Status");
				return false;
			}
		}

		public static void clicking_on_enabled_right_Arrow_of_paginator_on_summary_in_Test_Status() {
			try {
				homePage.enabled_right_arrow_on_paginator_on_summary_in_ts.click();
				Thread.sleep(500);
			} catch (Exception e) {
				log.error("Erron in clicking on Right Arrow of Paginator in Summary in Test Status");
				UtilityMethods.processException(e);
			}
		}

	
	// =======================================================================================================
	/** This method is used to click on first circle of paginator */
	public static void clicking_on_first_circle_of_paginator(List<WebElement> list_of_circles) {
		try {
			list_of_circles.get(0).click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Error in clicking on first circle of paginator");
			UtilityMethods.processException(e);
		}
	}

	/** This method is used to click on last circle of paginator */
	public static void clicking_on_last_circle_of_paginator(List<WebElement> list_of_circles) {
		try {
			list_of_circles.get(list_of_circles.size() - 1).click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Error in clicking on last circle of paginator");
			UtilityMethods.processException(e);
		}
	}

	/** This method is used to click on Indexed circle of paginator */
	public static void clicking_on_indexed_circle_of_paginator(List<WebElement> list_of_circles, int index) {
		try {
			list_of_circles.get(index).click();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error("Error in clicking of index circle of paginator");
			UtilityMethods.processException(e);
		}
	}
	
	/**
	 * This method is used to Verify the Test Name with the correct ToolTip Test
	 * Name Text
	 */
	public static void verifyTestNamesAndToolTipText(int index) {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
			String testName = UtilityMethods
					.elipsisRemoval(homePage.testNamesonPerPage_onlinechart.get(index).getText());
			new Actions(Driver.webdriver).moveToElement(homePage.testNamesonPerPage_onlinechart.get(index)).build()
					.perform();
			String tooltiptextOfTSOT = homePage.testNametooltip_onlinechart.getText();
			Assert.assertTrue(tooltiptextOfTSOT.contains(testName));
			Thread.sleep(500);			
		} catch (InterruptedException e) {
			UtilityMethods.processException(e);
		}
	}

	public static void verifyTestScorePerAndPerOnToolTip(int index) {

		try {
			new Actions(Driver.webdriver).moveToElement(homePage.testScoreCircleClronPerPage_onlinechart.get(index))
					.click().perform();
			Thread.sleep(500);
			Assert.assertTrue(homePage.tooltiprowpercent_onlinechart.getText()
					.contains(homePage.testScoresonPerPage_onlinechart.get(index).getText()));
			Thread.sleep(500);

			new Actions(Driver.webdriver).moveToElement(homePage.testNamesonPerPage_onlinechart.get(index)).click()
					.build().perform();
		} catch (Exception e) {
			try {
				UtilityMethods.scrollPageDown(Driver.webdriver, 2);
				Thread.sleep(500);
				new Actions(Driver.webdriver).moveToElement(homePage.testNamesLabelOnLineChart).click().build()
						.perform();
				UtilityMethods.scrollPageUp(Driver.webdriver, 2);
				Thread.sleep(500);
			} catch (Exception e1) {
				try {
					Thread.sleep(500);
					new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).click().build()
							.perform();
				} catch (InterruptedException e2) {
				}
			}
		}
	}

	/**
	 * This method is used to get tooltip of test name on TSOT with TSD Test Name
	 **/
	public static void verifyToolTipDetailsonLineChart(int index) {
		try {
			String tooltiptext_on_test_name_on_line_chart, tooltiptext_on_test_name_on_test_score_detail,
					submittedDateText;
			homePage.testScoreValueInCircle_onlinechart_tsot.get(index).click();
			UtilityMethods.wait_For_Test_Score_Detail_Section();

			new Actions(Driver.webdriver).moveToElement(homePage.testNamesonPerPage_onlinechart.get(index)).build()
					.perform();
			if (homePage.testNamesonPerPage_onlinechart.get(index).getText().contains("...")) {
				tooltiptext_on_test_name_on_line_chart = homePage.testNametooltip_onlinechart.getText();
			} else {
				tooltiptext_on_test_name_on_line_chart = homePage.testNamesonPerPage_onlinechart.get(index).getText();
			}
			new Actions(Driver.webdriver).moveToElement(homePage.testNameOnTestScoreDetail).build().perform();
			if (homePage.testNameOnTestScoreDetail.getText().contains("...")) {
				tooltiptext_on_test_name_on_test_score_detail = homePage.tooltip_text_of_test_name_on_tsd.getText();
			} else {
				tooltiptext_on_test_name_on_test_score_detail = homePage.testNameOnTestScoreDetail.getText();
			}
			Assert.assertTrue(
					tooltiptext_on_test_name_on_test_score_detail.equals(tooltiptext_on_test_name_on_line_chart));
			new Actions(Driver.webdriver).moveToElement(homePage.classAvgScrInClassInTS).build().perform();
			submittedDateText = homePage.submitteddateon_tsd.getText();
			UtilityMethods.checkDateFormat(submittedDateText.substring(11, 21));
			if (submittedDateText.length() > 25) {
				UtilityMethods.checkDateFormat(submittedDateText.substring(23));
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to Verify the test name with the circles testname and
	 * percentage values in circle
	 **/
	public static void verify_TestName_ToolTip_Details_on_Test_Score_Overview(int index) {
		try {
			String tooltiptext_on_test_name_on_line_chart, test_name_on_tooltip_model;
			String percentage_on_circle;
			new Actions(Driver.webdriver).moveToElement(homePage.testNamesonPerPage_onlinechart.get(index)).build()
					.perform();
			if (homePage.testNamesonPerPage_onlinechart.get(index).getText().contains("...")) {
				tooltiptext_on_test_name_on_line_chart = homePage.testNametooltip_onlinechart.getText();
			} else {
				tooltiptext_on_test_name_on_line_chart = homePage.testNamesonPerPage_onlinechart.get(index).getText();
			}
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentageon_tso).build().perform();
				percentage_on_circle = homePage.testScoreValueInCircle_onlinechart_tso.get(index).getText();
				homePage.testScoreValueInCircle_onlinechart_tso.get(index).click();
				Thread.sleep(500);
				test_name_on_tooltip_model = homePage.testnameontooltip.getText();
				Assert.assertTrue(test_name_on_tooltip_model.equals(tooltiptext_on_test_name_on_line_chart));
				String tool_Tip_percentage = homePage.tooltiprowpercent_onlinechart.getText();
				tool_Tip_percentage = tool_Tip_percentage.substring(0, tool_Tip_percentage.indexOf("%"));
				Assert.assertTrue(tool_Tip_percentage.equals(percentage_on_circle));
				new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentageon_tso).build().perform();
			} catch (Exception e) {
				new Actions(Driver.webdriver).moveToElement(homePage.testnameslabel_onlinechart_pot).build().perform();
				percentage_on_circle = homePage.testScoreValueInCircle_onlinechart_pot.get(index).getText();
				homePage.testScoreValueInCircle_onlinechart_pot.get(index).click();
				Thread.sleep(500);
				test_name_on_tooltip_model = homePage.testnameontooltip.getText();
				Assert.assertTrue(test_name_on_tooltip_model.equals(tooltiptext_on_test_name_on_line_chart));
				String tool_Tip_percentage = homePage.tooltiprowpercent_onlinechart.getText();
				tool_Tip_percentage = tool_Tip_percentage.substring(0, tool_Tip_percentage.indexOf("%"));
				Assert.assertTrue(tool_Tip_percentage.equals(percentage_on_circle));
				new Actions(Driver.webdriver).moveToElement(homePage.testnameslabel_onlinechart_pot).click().build()
						.perform();
			}

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used for clicking on test score circle value and verifying avg
	 * score value with Test Score Detail Heading
	 **/
	public static void verifyStudentListNotDisplayWithStudentContext(int index) {
		try {
			homePage.testScoreValueInCircle_onlinechart_tso.get(index).click();
			UtilityMethods.wait_For_Test_Score_Detail_Section();
			String test_Score = homePage.testScoreValueInCircle_onlinechart_tso.get(index).getText();
			String test_Score_value_on_heading = homePage.districtAvgScrInClassInTS.getText();
			test_Score_value_on_heading = test_Score_value_on_heading
					.substring(test_Score_value_on_heading.indexOf(":") + 2, test_Score_value_on_heading.indexOf("%"));
			Assert.assertTrue(test_Score.equals(test_Score_value_on_heading));
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}
}
