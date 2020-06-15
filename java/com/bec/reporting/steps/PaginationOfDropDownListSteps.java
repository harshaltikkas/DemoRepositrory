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
 * JAN 21 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.PaginationUtility_for_Universal_Tab;
import com.bec.reporting.utils.RosterTabUtilityMethods;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.base.Verify;

import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaginationOfDropDownListSteps {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	static int listCount = 0, AllPagetotalListItem = 0;
	int countPerPage = 0, pageCount = 0, totalCount = 0;

	/**
	 * This method used to verify display paginator in test tab with LHS and RHS
	 * arrows and circles
	 * 
	 * @param listItemPerPage
	 * @param itemLimitForPagination
	 * @throws Throwable
	 */
	@Then("^Paginator will be displayed,test list items per page should be (\\d+) and totalitemlist more than (\\d+) items, arrows will appear in both side of circle in paginator$")
	public void paginator_will_be_displayed_test_list_items_per_page_should_be_and_totalitemlist_more_than_items_arrows_will_appear_in_both_side_of_circle_in_paginator(
			int listItemPerPage, int itemLimitForPagination) throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			Thread.sleep(500);
			int pageCount = 0;
			// checking for paginator
			if (PaginationUtility_for_Universal_Tab.checkPaginator_on_test_tab()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = 0; i < homePage.testpaginationcirclelist.size(); i++) {
					PaginationUtility_for_Universal_Tab.click_On_Indexed_Circle_Of_Paginator(i);
					Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
					for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
						pageCount++;
						countPerPage = homePage.testscheckboxlist.size();
						totalCount += countPerPage;
						log.info(" list size on page:" + pageCount + " is " + countPerPage);
						Assert.assertTrue(countPerPage <= listItemPerPage);
					}
				}
				// check for right arrow enabled and click on it and click on last circle from
				// left and validate
				do {
					if (PaginationUtility_for_Universal_Tab.check_Enabled_Right_Arrow_On_Paginator_On_Test_Tab()) {
						PaginationUtility_for_Universal_Tab.click_On_Enabled_Right_Arrow_Of_Paginator_On_Test_Tab();
						PaginationUtility_for_Universal_Tab.click_On_Last_Circle_Of_Paginator();
						Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
						for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
							pageCount++;
							countPerPage = homePage.testscheckboxlist.size();
							totalCount += countPerPage;
							log.info(" list size on page:" + pageCount + " is " + countPerPage);
							Assert.assertTrue(countPerPage <= listItemPerPage);
						}
					}
				} while (PaginationUtility_for_Universal_Tab.check_Enabled_Right_Arrow_On_Paginator_On_Test_Tab());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
				for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
					pageCount++;
					countPerPage = homePage.testscheckboxlist.size();
					totalCount += countPerPage;
					log.info(" list size on page:" + pageCount + " is " + countPerPage);
					Assert.assertTrue(countPerPage <= listItemPerPage);
				}
			}

			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 15 Completed");
	}

	@Then("^user clicks on Roster tab and check dropdown list size and paginator features of Roster tab for school as \"([^\"]*)\"$")
	public void user_clicks_on_Roster_tab_and_check_dropdown_list_size_and_paginator_features_of_Roster_tab_for_school_as(
			String sc) throws Throwable {
		try {
			IWait.explicit_wait(Driver.webdriver, homePage.rostertab);
			homePage.rostertab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
			Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			check_paginator_on_Roster("School", 20);
			RosterTabUtilityMethods.uncheck_check_All("School");
			log.info("Selected School:" + sc);

			homePage.searchbaronschooldropdown.sendKeys(sc);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='" + sc + "']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonschooldropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();

			RosterTabUtilityMethods.wait_For_Refresh_Icon(homePage.schoolRefreshIcon, "School");
			UtilityMethods.scrollPageDown(Driver.webdriver, 6);
			Thread.sleep(500);

			homePage.gradedropdownbtn.click();
			Thread.sleep(500);
			check_paginator_on_Roster("Grade", 20);
			homePage.gradelist.get(4).click();
			Thread.sleep(500);

			homePage.teachersdropdownbtn.click();
			Thread.sleep(500);
			check_paginator_on_Roster("Teacher", 20);
			/*
			 * UtilityMethods.uncheck_check_All("Teacher");
			 * homePage.teacherslist.get(1).click();
			 */
			Thread.sleep(500);
			homePage.teachersdropdownbtn.click();
			Thread.sleep(500);

			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			check_paginator_on_Roster("Class", 20);
			/*
			 * UtilityMethods.uncheck_check_All("Class"); homePage.classlist.get(1).click();
			 */
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);

			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			check_paginator_on_Roster("Student", 20);
			/*
			 * UtilityMethods.uncheck_check_All("Student");
			 * homePage.studentlistondropdown.get(1).click();
			 */
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 14 & 16 Completed");
	}

	public void check_paginator_on_Roster(String dropDownHeader, int listSize) {
		try {
			try {
				List<WebElement> list = Driver.webdriver
						.findElements(By.xpath("//div[@class='menu-title' and contains(text(),'" + dropDownHeader
								+ "')]/following-sibling::div//div[@class='menu-dropdown-list-inr']//ul//div/li"));
				log.info("List Size for " + dropDownHeader + " is " + list.size());
				Assert.assertTrue(list.size() <= listSize);
			} catch (Exception e) {
				log.error("List Size is more than 20 for " + dropDownHeader);
				UtilityMethods.processException(e);
			}
			WebElement el = Driver.webdriver.findElement(By.xpath(
					"//div[@class='selector-pagination']/ancestor::div[@class='menu-selector active-selector']/preceding-sibling::div[@class='menu-title' and contains(text(),'"
							+ dropDownHeader + "')]"));
			Assert.assertTrue(el.isDisplayed());
			log.info("Paginator available for " + dropDownHeader);
		} catch (Exception e) {
			log.info("Paginator Not available for " + dropDownHeader);
		}
	}

}
