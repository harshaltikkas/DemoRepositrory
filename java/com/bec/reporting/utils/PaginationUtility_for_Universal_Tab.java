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

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaginationUtility_for_Universal_Tab {

	public static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);

	/* Test Tab Pagination details */

	/* This method is used to check the paginator on test tab */
	public static boolean checkPaginator_on_test_tab() {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.testpaginator).build().perform();
			return true;
		} catch (Exception e) {
			log.info("Paginator Not Found in Test Tab");
			return false;
		}
	}

	/*
	 * This method is used to click on enabled right arrow of paginator in test tab
	 */
	public static boolean check_Enabled_Right_Arrow_On_Paginator_On_Test_Tab() {
		try {
			homePage.test_tab_enabled_right_arrow.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * This method is used to click on enabled right arrow of paginator in test tab
	 */
	public static void click_On_Enabled_Right_Arrow_Of_Paginator_On_Test_Tab() {
		try {
			homePage.test_tab_enabled_right_arrow.click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Erron in clicking on Right Arrow in test tab");
			UtilityMethods.processException(e);
		}
	}

	/* This method is used to click on last circle of paginator */
	public static void click_On_Last_Circle_Of_Paginator() {
		try {
			homePage.testpaginationcirclelist.get(homePage.testpaginationcirclelist.size() - 1).click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Error in clicking on last circle of paginator");
			UtilityMethods.processException(e);
		}
	}

	/* This method is used to click on Indexed circle of paginator */
	public static void click_On_Indexed_Circle_Of_Paginator(int index) {
		try {
			homePage.testpaginationcirclelist.get(index).click();
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Error in clicking of index circle of paginator");
			UtilityMethods.processException(e);
		}
	}
	
	/* Roster Tab Pagination details */

}
