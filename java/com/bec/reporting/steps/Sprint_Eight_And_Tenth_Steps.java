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

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.collect.Ordering;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sprint_Eight_And_Tenth_Steps {
	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	static JavascriptExecutor js = (JavascriptExecutor) Driver.webdriver;
	@Then("^verify Loading icon within the date tab after filtering the Roster Tab$")
	public void verify_Loading_icon_within_the_date_tab_after_filtering_the_Roster_Tab() throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);
			homePage.datetab.click();
			Thread.sleep(500);
			// verifying default selection as "District Term to Date" BE-805
			Assert.assertTrue(homePage.daterangedropdownbtn.getText().equals("District Term To Date"));
			// verifying Menus in Date Range DropDown BE-806
			homePage.daterangedropdownbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.dateRangelist.get(0).getText().equals("Last 30 Days"));
			Assert.assertTrue(homePage.dateRangelist.get(1).getText().equals("Last 60 Days"));
			Assert.assertTrue(homePage.dateRangelist.get(2).getText().equals("Last 90 Days"));
			Assert.assertTrue(homePage.dateRangelist.get(3).getText().equals("District Term To Date"));
			Assert.assertTrue(homePage.dateRangelist.get(4).getText().equals("Custom Date Range"));
			homePage.daterangedropdownbtn.click();
			Thread.sleep(500);
			// validate district term format - can not validate as data can be anything in
			// term dd
			// Assert.assertTrue(validateDistrictTerm());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-791,792,793,805,806 completed");
	}

	@Then("^verify Start date and End Date for the Custom date selector always appears beneath the Date Range dropdown$")
	public void verify_Start_date_and_End_Date_for_the_Custom_date_selector_always_appears_beneath_the_Date_Range_dropdown()
			throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			homePage.datetab.click();
			Thread.sleep(1000);
			UtilityMethods.scrollPageDown(Driver.webdriver, 6);
			Thread.sleep(500);
			homePage.daterangedropdownbtn.click();
			Thread.sleep(500);
			homePage.dateRangelist.get(4).click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			Assert.assertTrue(homePage.activeDate.isDisplayed());
			Assert.assertTrue(homePage.edate.isDisplayed());
			String sDate = "", eDate = "";
			int num = (int) (homePage.activeDateRangelistoOnCalender.size() * Math.random());
			sDate = homePage.activeDateRangelistoOnCalender.get(num).getText();
			homePage.activeDateRangelistoOnCalender.get(num).click();
			Thread.sleep(500);
			String dateValue = homePage.activeDate.getText();
			UtilityMethods.checkDateFormatOnDateTab(dateValue);
			Date one = getDate(dateValue);
			Assert.assertTrue(
					dateValue.substring(dateValue.indexOf("/") + 1, dateValue.lastIndexOf("/")).equals(sDate));
			homePage.edate.click();
			Thread.sleep(500);
			num = (int) (homePage.activeDateRangelistoOnCalender.size() * Math.random());
			eDate = homePage.activeDateRangelistoOnCalender.get(num).getText();
			homePage.activeDateRangelistoOnCalender.get(num).click();
			Thread.sleep(500);
			dateValue = homePage.activeDate.getText();
			UtilityMethods.checkDateFormatOnDateTab(dateValue);
			Assert.assertTrue(
					dateValue.substring(dateValue.indexOf("/") + 1, dateValue.lastIndexOf("/")).equals(eDate));
			Date two = getDate(dateValue);
			long numberOfDays = daysBetween(one, two) + 1;
			String dayCount = homePage.dateRangeValueOnUI.getText();
			dayCount = dayCount.substring(dayCount.indexOf(":") + 2, dayCount.lastIndexOf(" "));
			Assert.assertTrue(dayCount.equals(String.valueOf(numberOfDays)));
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-808,809,810,811 Completed");
	}

	/*
	 * Java Method to calculate difference between two dates in Java without using
	 * any third party library.
	 */
	private static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}

	/*
	 * Simple way to parse String to date in Java
	 */
	private static Date getDate(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.parse(date);
	}

	/**
	 * This method is to verify the grouping tab, appearance under class,sp for
	 * teachers only.
	 * 
	 * @throws Throwable
	 */
	@Then("^verify Grouping, The appearance of the Grouping tab$")
	public void verify_Grouping_The_appearance_of_the_Grouping_tab() throws Throwable {
		String output = "fail";
		try {
			Thread.sleep(3000);
			if (Standard_Overview_Table_Steps.underClassContext
					&& Standard_Overview_Table_Steps.performanceMenuClicked) {
				Assert.assertTrue(homePage.groupingTab.isDisplayed());
				output = "pass";
			} else {
				try {
					Assert.assertTrue(homePage.groupingTab.isDisplayed());
					UtilityMethods.processException(new Exception());
				} catch (NoSuchElementException nse) {
					output = "pass";
				}
			}
			CBTConfiguration.score = output;
			Standard_Overview_Table_Steps.resetStatus();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^verify Grouping, The appearance of the Grouping tab for grade \"([^\"]*)\"$")
	public void verify_Grouping_The_appearance_of_the_Grouping_tab_for_grade(String grade) throws Throwable {

		String output = "fail";
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			homePage.rostertab.click();
			Thread.sleep(500);

			if (!(homePage.gradedropdownbtn.getText().equalsIgnoreCase(grade))) {
				homePage.gradedropdownbtn.click();
				Thread.sleep(500);
				Driver.webdriver.findElement(By.xpath("//li[.='" + grade + "']")).click();
				Thread.sleep(500);
				homePage.rosterapplybtn.click();
				Thread.sleep(3000);
			} else {
				homePage.rostercancelbtn.click();
				Thread.sleep(500);
			}

			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			Assert.assertTrue(homePage.groupingTab.isDisplayed());
			UtilityMethods.processException(new Exception());
		} catch (NoSuchElementException nse) {
			output = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = output;
	}

	@Then("^verify no appearance of the grouping tab for other than teacher$")
	public void verify_no_appearance_of_the_grouping_tab_for_other_than_teacher() throws Throwable {
		String output = "fail";
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.groupingTab.isDisplayed());
			UtilityMethods.processException(new Exception());
		} catch (NoSuchElementException nse) {
			output = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = output;
	}

	@Then("^verify Context header Updates - Test tab selections$")
	public void verify_Context_header_Updates_Test_tab_selections() throws Throwable {
		try {
			/**
			 * Performing multiple selection of test type selection
			 */
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);Thread.sleep(500);
			homePage.testtab.click();
			Thread.sleep(500);
			homePage.testtypedropdown.click();
			Thread.sleep(500);
			int testTypeListSize = homePage.testtypecheckboxlist.size();
			int num = UtilityMethods.generateRandomNumberBySkippingIndex(testTypeListSize, 0);
			new Actions(Driver.webdriver).moveToElement(homePage.testtypecheckboxlist.get(num)).click().build()
					.perform();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.doneBtn).click().build()
			.perform();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.testtypedropdown.getText().equals("Custom (" + (testTypeListSize - 2) + ")"));
			String testResultCount = homePage.totaltestcount.getText();
			String noOfTestSelected = testResultCount.substring(testResultCount.lastIndexOf(" ") + 1,
					testResultCount.indexOf("/"));
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);Thread.sleep(500);
			homePage.testapplybtn.click();
			Thread.sleep(3000);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			Assert.assertTrue(homePage.testsNameoncontextheader.getText().equals("Custom (" + noOfTestSelected + ")"));
			/**
			 * performing single selection of test type
			 */
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);Thread.sleep(500);
			homePage.testtab.click();
			Thread.sleep(500);
			homePage.testtypedropdown.click();
			Thread.sleep(500);
			// select all test type
			new Actions(Driver.webdriver).moveToElement(homePage.testtypecheckboxlist.get(0)).click().build().perform();
			Thread.sleep(500);
			// de-select all test type
			new Actions(Driver.webdriver).moveToElement(homePage.testtypecheckboxlist.get(0)).click().build().perform();
			Thread.sleep(500);
			// select random single test type
			num = UtilityMethods.generateRandomNumberBySkippingIndex(testTypeListSize, 0);
			String testTypeName = homePage.testtypenameslist.get(num).getText();
			new Actions(Driver.webdriver).moveToElement(homePage.testtypecheckboxlist.get(num)).click().build()
					.perform();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.doneBtn).click().build()
			.perform();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.testtypedropdown.getText().equals(testTypeName));
			testResultCount = homePage.totaltestcount.getText();
			noOfTestSelected = testResultCount.substring(testResultCount.lastIndexOf(" ") + 1,
					testResultCount.indexOf("/"));

			// called logic for single or multiple test
			String testName = "";
			if (Integer.parseInt(noOfTestSelected) == 1) {
				testName = UtilityMethods.TestNamefromTestTab();
			}
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);Thread.sleep(500);
			homePage.testapplybtn.click();
			Thread.sleep(3000);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			if (Integer.parseInt(noOfTestSelected) == 1) {
				if (homePage.testsNameoncontextheader.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.testsNameoncontextheader).build().perform();
					Assert.assertTrue(homePage.tooltipoftestnameoncontextheader.getText().equals(testName));
				} else {
					Assert.assertTrue(homePage.testsNameoncontextheader.getText().equals(testName));
				}
			} else {
				if (homePage.testsNameoncontextheader.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.testsNameoncontextheader).build().perform();
					Thread.sleep(500);
					Assert.assertTrue(homePage.tooltipoftestnameoncontextheader.getText()
							.contains(testTypeName + "(" + noOfTestSelected + ")"));
				} else {
					Assert.assertTrue(homePage.testsNameoncontextheader.getText()
							.contains(testTypeName + "(" + noOfTestSelected + ")"));
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^verify Test Data assessed for Grade dropdown within the Grouping tab selection window$")
	public void verify_Test_Data_assessed_for_Grade_dropdown_within_the_Grouping_tab_selection_window()
			throws Throwable {
		String noteOnGrpTab = "Note: Select multiple Strands to compare or select a single Strand to compare multiple Standards within that Strand";
		try {
			// checking Test(s) assessed for Dropdown
			new Actions(Driver.webdriver).moveToElement(homePage.groupingTab).click().build().perform();
			Thread.sleep(3000);
			Assert.assertTrue(homePage.testAssessedForGradeGroupingTab.isDisplayed());
			int index = 0;
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.testAssessedForGradeGroupingTab).click().build()
						.perform();
				Thread.sleep(500);
				index = (int) (Math.random() * homePage.testAssessedForGradeListGroupingTab.size());
				new Actions(Driver.webdriver).moveToElement(homePage.testAssessedForGradeListGroupingTab.get(index))
						.click().build().perform();
				Thread.sleep(500);
				wait_For_Assessed_With_on_grouping_tab();
			} catch (Exception nse) {
			}
			
			// checking Assessed With Dropdown
			Assert.assertTrue(homePage.assessedWithGroupingTab.isDisplayed());
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.assessedWithGroupingTab).click().build().perform();
				Thread.sleep(500);
				index = (int) (Math.random() * homePage.assessedWithListGroupingTab.size());
				new Actions(Driver.webdriver).moveToElement(homePage.assessedWithListGroupingTab.get(4)).click()
						.build().perform();
				Thread.sleep(2000);
				index = 0;
			} catch (Exception nse) {
			}
			// checking note on grouping tab
			Assert.assertTrue(homePage.noteOnGroupingTab.getText().equals(noteOnGrpTab));
			// checking select strand
			Assert.assertTrue(homePage.selectStrandsOnGroupingTab.isDisplayed());

			new Actions(Driver.webdriver).moveToElement(homePage.selectStrandsOnGroupingTab).click().build().perform();
			Thread.sleep(500);
			// check the list in ascending order
			List<String> strandsList = new ArrayList<String>();
			int length = homePage.selectStrandsListInDropdownGroupingTab.size();
			for (int i = 0; i < length; i++) {
				strandsList.add(homePage.selectStrandsListInDropdownGroupingTab.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(strandsList));
			Thread.sleep(500);
			if (length != 2) {
				index = UtilityMethods.generateRandomNumberBySkippingIndex(length, 0);
				new Actions(Driver.webdriver).moveToElement(homePage.selectStrandsListInDropdownGroupingTab.get(index))
						.click().build().perform();
				Thread.sleep(500);
			}
			Thread.sleep(500);
			Assert.assertTrue(homePage.cancelBtnOnSelectStrandOnGroupingTab.isDisplayed());
			homePage.doneBtnOnSelectStrandOnGroupingTab.click();
			Thread.sleep(500);
			index = 0;
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);
				//homePage.selectAllchkboxOnGroupingTab.click();Thread.sleep(500);-
				
			} catch (NoSuchElementException nse) {
			}
			// checking no. of groups
			Assert.assertTrue(homePage.noofgroupsLabelOnGroupingTab.isDisplayed());
			Assert.assertTrue(homePage.minusIconOfnoofgroupsLabelOnGroupingTab.isDisplayed());
			Assert.assertTrue(homePage.textOfnoofgroupsLabelOnGroupingTab.getAttribute("value").equals("3"));
			Assert.assertTrue(homePage.plusIconOfnoofgroupsLabelOnGroupingTab.isDisplayed());
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", homePage.minusIconOfnoofgroupsLabelOnGroupingTab);
			Thread.sleep(500);
			Assert.assertTrue(homePage.textOfnoofgroupsLabelOnGroupingTab.getAttribute("value").equals("2"));
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", homePage.minusIconOfnoofgroupsLabelOnGroupingTab);
			Thread.sleep(500);
			Assert.assertTrue(homePage.textOfnoofgroupsLabelOnGroupingTab.getAttribute("value").equals("1"));
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", homePage.minusIconOfnoofgroupsLabelOnGroupingTab);
			Thread.sleep(500);
			Assert.assertTrue(homePage.textOfnoofgroupsLabelOnGroupingTab.getAttribute("value").equals("1"));
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", homePage.plusIconOfnoofgroupsLabelOnGroupingTab);
			Thread.sleep(500);
			Assert.assertTrue(homePage.textOfnoofgroupsLabelOnGroupingTab.getAttribute("value").equals("2"));
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", homePage.plusIconOfnoofgroupsLabelOnGroupingTab);
			Thread.sleep(500);
			Assert.assertTrue(homePage.textOfnoofgroupsLabelOnGroupingTab.getAttribute("value").equals("3"));
			Thread.sleep(500);
			// verifying Group By UI elements
			Assert.assertTrue(homePage.GrpByTextOnGroupingTab.isDisplayed());
			Assert.assertTrue(homePage.tooltipIconOf_group_by_LabelOnGroupingTab.isDisplayed());
			Assert.assertTrue(homePage.groupByListOnGroupingTab.get(0).getText().equals("Cluster"));
			Assert.assertTrue(homePage.groupByListOnGroupingTab.get(1).getText().equals("Average"));
			Assert.assertTrue(homePage.groupByListOnGroupingTab.get(2).getText().equals("High-Low"));
			int no = (int) (homePage.groupByListOnGroupingTab.size() * Math.random());
			String selectedGrp = homePage.groupByListOnGroupingTab.get(no).getText();
			Thread.sleep(1000);
			WebElement el=Driver.webdriver.findElement(By.xpath("//span[.='"+selectedGrp+"']"));
			js.executeScript("arguments[0].click();", el);
			log.info("Selected Group: "+selectedGrp);
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", homePage.applyBtnOngroupingTab);
			
			UtilityMethods.wait_For_Strands_Text_After_Apply_BtnOn_GroupingTab();
			Thread.sleep(500);
			Assert.assertTrue(homePage.GrpByTextOnUI.isDisplayed());
			Assert.assertTrue(homePage.EditGrpTextOnUI.isDisplayed());
			Assert.assertTrue(homePage.printIconforGroupDataOnUI.isDisplayed());
			Assert.assertTrue(homePage.selectedGrpNameOnUI.getText().equals(selectedGrp));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}	
	
	private void wait_For_Assessed_With_on_grouping_tab() {
		try {
			Thread.sleep(1000);
			Assert.assertTrue(homePage.AssessedWithRefreshIconTab.isDisplayed());
			log.info("wait for AssessedWithRefreshIconTab ...");
			Thread.sleep(2000);
			wait_For_Assessed_With_on_grouping_tab();
		} catch (Exception e) {
		}
	}	

	@Then("^verify To check The Strand and or Standard element of the grouping table within the grouping page$")
	public void verify_To_check_The_Strand_and_or_Standard_element_of_the_grouping_table_within_the_grouping_page()
			throws Throwable {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.groupingTab).click().build().perform();
			Thread.sleep(5000);
			new Actions(Driver.webdriver).moveToElement(homePage.selectStrandsOnGroupingTab).click().build().perform();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.selectStrandsListInDropdownGroupingTab.get(0)).click()
					.build().perform();
			Thread.sleep(500);
			List<String> strandsList = new ArrayList<String>();
			int length = homePage.selectStrandsListInDropdownGroupingTab.size();
			for (int i = 1; i < length; i = i + 2) {
				new Actions(Driver.webdriver).moveToElement(homePage.selectStrandsListInDropdownGroupingTab.get(i))
						.click().build().perform();
				Thread.sleep(500);
				strandsList.add(homePage.selectStrandsListInDropdownGroupingTab.get(i).getText());
			}
			homePage.doneBtnOnSelectStrandOnGroupingTab.click();
			Thread.sleep(500);
			for (int i = 0; i < strandsList.size(); i++) {
				Assert.assertTrue(
						homePage.selectedStrandsListOnGroupingTab.get(i).getText().equals(strandsList.get(i)));
			}
			Thread.sleep(500);
			homePage.applyBtnOngroupingTab.click();
			UtilityMethods.wait_For_Strands_Text_After_Apply_BtnOn_GroupingTab();
			Thread.sleep(500);
			for (int i = 0; i < homePage.groupingTableHeaderList.size(); i++) {
				Assert.assertTrue(homePage.groupingTableHeaderList.get(i).getText().equals(strandsList.get(i)));
			}
			Assert.assertTrue(homePage.avgperScoreOnGroupingTable.isDisplayed());
			Assert.assertTrue(homePage.groupAndStudentInfoOnGroupingTabPage.getText().equalsIgnoreCase("Groups("+homePage.groupHeaderListonGroupingTabPage.size()+") / Students("+homePage.studentListonGroupingTabPage.size()+")"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}
}
