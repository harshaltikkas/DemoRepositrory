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
 * Mar 01 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.API_Connection;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.PaginationUtility_for_Pages;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.collect.Ordering;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Standard_Overview_Table_Steps {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	public static boolean performanceMenuClicked = false, underClassContext = false, testScoreMenuClicked = false,
			underStudentContext = false, underSchoolContext = false, underDistrictContext = false,
			test_status_Menu_Clicked = false;
	static String headerOnToolTip, subHeaderOnToolTip;
	public static JavascriptExecutor jse = (JavascriptExecutor) Driver.webdriver;

	public static void resetStatus() {
		Standard_Overview_Table_Steps.performanceMenuClicked = false;
		Standard_Overview_Table_Steps.underClassContext = false;
		Standard_Overview_Table_Steps.underSchoolContext = false;
		Standard_Overview_Table_Steps.testScoreMenuClicked = false;
		Standard_Overview_Table_Steps.underStudentContext = false;
		Standard_Overview_Table_Steps.underDistrictContext = false;
		Standard_Overview_Table_Steps.test_status_Menu_Clicked = false;
	}

	/**
	 * This method is used to click on standard performance tab in district context
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Standard Performance tab within the District Context$")
	public static void user_Click_on_Standard_Performance_tab_within_the_District_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activedistrictmenu.getAttribute("district").contains("active"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.activestandardperformancebtn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			Thread.sleep(1000);
			jse.executeScript("arguments[0].click();", homePage.standardperformancebtn);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		Standard_Overview_Table_Steps.performanceMenuClicked = true;
		Standard_Overview_Table_Steps.underDistrictContext = true;
	}

	/**
	 * This method is used to click on standard performance tab in school context
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Standard Performance tab within the School Context$")
	public static void user_Click_on_Standard_Performance_tab_within_the_School_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activeschoolmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.activestandardperformancebtn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			Thread.sleep(1000);
			jse.executeScript("arguments[0].click();", homePage.standardperformancebtn);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		Standard_Overview_Table_Steps.performanceMenuClicked = true;
		Standard_Overview_Table_Steps.underSchoolContext = true;
	}

	/**
	 * This method is used to click on standard performance tab in class context
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Standard Performance tab within the Class Context$")
	public static void user_Click_on_Standard_Performance_tab_within_the_Class_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activeclassmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.classmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.activestandardperformancebtn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.standardperformancebtn);
			Thread.sleep(1500);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		Standard_Overview_Table_Steps.performanceMenuClicked = true;
		Standard_Overview_Table_Steps.underClassContext = true;
	}

	/**
	 * This method is used to verify the Y-Axis Label Text as given
	 * 
	 * @param yaxisText
	 * @throws Throwable
	 */
	@Then("^The Y-axis of the table should be labeled as \"([^\"]*)\"$")
	public void the_Y_axis_of_the_table_should_be_labeled_as(String yaxisText) throws Throwable {
		try {
			Assert.assertTrue(homePage.yaxislabelonstndrdperformanceinclass.getText().equals(yaxisText));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 36_1 completed");
	}

	/**
	 * This method is used to verify the achievement level grouping percentage with
	 * associated colour on standard performance
	 * 
	 * @throws Throwable
	 */
	@Then("^The Y-axis should have the groupings strip of colours with the respective ranges in %$")
	public void the_Y_axis_should_have_the_groupings_strip_of_colours_with_the_respective_ranges_in() throws Throwable {
		try {
			Assert.assertTrue(homePage.achlvl80ormorewithgreenclr.getText().equals("≥ 80%"));
			Assert.assertTrue(homePage.achlvl60_79withyellowclr.getText().equals("60-79%"));
			Assert.assertTrue(homePage.achlvl40_59withorangeclr.getText().equals("40-59%"));
			Assert.assertTrue(homePage.achlvlbelow40withredclr.getText().equals("< 40%"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 36_2 completed");
	}

	/**
	 * This Method is used to check the achievment level green_red arrow sorting and
	 * also check the flipping of data in table based on arrow clicked
	 * 
	 * @throws Throwable
	 */
	@Then("^user should able to see sort arrows with the red and green colours and when the user clicks on that arrow sorting should happen$")
	public void user_should_able_to_see_sort_arrows_with_the_red_and_green_colours_and_when_the_user_clicks_on_that_arrow_sorting_should_happen()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.greenuparrow.isDisplayed());
			Assert.assertTrue(homePage.reddownarrow.isDisplayed());

			WebElement rightArrowEnable = null;
			boolean enabledRightArrowFound = false;
			List<String> reverseStandardList = new ArrayList<>();
			List<String> originalStandardList = new ArrayList<>();
			List<WebElement> elList;
			do {
				if (enabledRightArrowFound) {
					new Actions(Driver.webdriver)
							.moveToElement(homePage.strandnameslist.get(homePage.strandnameslist.size() - 1)).click()
							.build().perform();
					Thread.sleep(3000);
					new Actions(Driver.webdriver).moveToElement(homePage.reddownarrow).click().build().perform();
					Thread.sleep(2000);
					elList = Driver.webdriver.findElements(By.xpath(
							"//div[@class='overview-table-body']//div[@class='overview-table-row']//div[@class='overview-table-col']["
									+ ((homePage.strandnameslist.size() - 1) + 2)
									+ "]//li[not(contains(@class,'StandardsNotAvailable'))]"));
					for (int j = 0; j < elList.size(); j++) {
						reverseStandardList.add(elList.get(j).getText());
					}
					Thread.sleep(1000);
					jse.executeScript("arguments[0].click();", homePage.reduparrow);
					Thread.sleep(2000);
					elList = Driver.webdriver.findElements(By.xpath(
							"//div[@class='overview-table-body']//div[@class='overview-table-row']//div[@class='overview-table-col']["
									+ ((homePage.strandnameslist.size() - 1) + 2)
									+ "]//li[not(contains(@class,'StandardsNotAvailable'))]"));
					for (int j = 0; j < elList.size(); j++) {
						originalStandardList.add(elList.get(j).getText());
					}
					Assert.assertTrue(UtilityMethods.isReverse(originalStandardList, reverseStandardList));
					originalStandardList.clear();
					reverseStandardList.clear();
				} else {
					for (int i = 0; i < homePage.strandnameslist.size(); i++) {
						new Actions(Driver.webdriver).moveToElement(homePage.strandnameslist.get(i)).click().build()
								.perform();
						Thread.sleep(3000);
						new Actions(Driver.webdriver).moveToElement(homePage.reddownarrow).click().build().perform();
						Thread.sleep(2000);
						elList = Driver.webdriver.findElements(By.xpath(
								"//div[@class='overview-table-body']//div[@class='overview-table-row']//div[@class='overview-table-col']["
										+ (i + 2) + "]//li[not(contains(@class,'StandardsNotAvailable'))]"));
						for (int j = 0; j < elList.size(); j++) {
							reverseStandardList.add(elList.get(j).getText());
						}
						Thread.sleep(1000);
						jse.executeScript("arguments[0].click();", homePage.reduparrow);
						Thread.sleep(2000);
						elList = Driver.webdriver.findElements(By.xpath(
								"//div[@class='overview-table-body']//div[@class='overview-table-row']//div[@class='overview-table-col']["
										+ (i + 2) + "]//li[not(contains(@class,'StandardsNotAvailable'))]"));
						for (int j = 0; j < elList.size(); j++) {
							originalStandardList.add(elList.get(j).getText());
						}
						Assert.assertTrue(UtilityMethods.isReverse(originalStandardList, reverseStandardList));
						originalStandardList.clear();
						reverseStandardList.clear();
					}
				}
				try {
					rightArrowEnable = homePage.enabledrightarrow;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(500);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}

			} while (enabledRightArrowFound);
			CBTConfiguration.score = "pass";

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 36_3 completed");
	}

	/**
	 * This method is used to verify by default first strand should be selected
	 * 
	 * @throws Throwable
	 */
	@Then("^By default the first strands should be selected$")
	public void by_default_the_first_strands_should_be_selected() throws Throwable {
		try {

			for (int i = 0; i < homePage.strandnameslist.size(); i++) {
				if (i == 0) {
					Assert.assertTrue(!homePage.strandnameslist.get(i).getAttribute("class").contains("undefined"));
				} else {
					Assert.assertTrue(homePage.strandnameslist.get(i).getAttribute("class").contains("undefined"));
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 37_1 completed");
	}

	/**
	 * This method is used to verify the x-axis Strands names in alphabetical order
	 * from left to right
	 * 
	 * @throws Throwable
	 */
	@Then("^The column headers should be populated as Strands as alphabetical order from left to right$")
	public void the_column_headers_should_be_populated_as_Strands_as_alphabetical_order_from_left_to_right()
			throws Throwable {
		try {
			List<String> list = new ArrayList<String>();
			WebElement rightArrowEnable = null;
			boolean enabledRightArrowFound = false;

			do {
				if (enabledRightArrowFound) {
					list.add(UtilityMethods.elipsisRemoval(
							homePage.strandnameslist.get(homePage.strandnameslist.size() - 1).getText()));
				} else {
					for (int i = 0; i < homePage.strandnameslist.size(); i++) {
						list.add(UtilityMethods.elipsisRemoval(homePage.strandnameslist.get(i).getText()));
					}
				}
				try {
					rightArrowEnable = homePage.enabledrightarrow;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(500);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}

			} while (enabledRightArrowFound);
			// Verifying the Header(Strands) List in Alphabetical Order
			Assert.assertTrue(Ordering.natural().isOrdered(list));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 37_2 completed");
	}

	/**
	 * This method is used to check the grouping strips of colours with respective
	 * average score in percentage
	 * 
	 * @throws Throwable
	 */
	@Then("^The X-axis should have the groupings strip of colours with the respective average scores in % range below their text as 'Avg\\.xx%'$")
	public void the_X_axis_should_have_the_groupings_strip_of_colours_with_the_respective_average_scores_in_range_below_their_text_as_Avg_xx()
			throws Throwable {
		try {
			List<Integer> averageList = new ArrayList<Integer>();
			List<String> groupingStripClrList = new ArrayList<String>();
			String avgPer = "", clr = "";
			WebElement rightArrowEnable = null;
			boolean enabledRightArrowFound = false;

			do {
				if (enabledRightArrowFound) {
					clr = homePage.groupingstripclrlist.get(homePage.groupingstripclrlist.size() - 1)
							.getAttribute("class");
					avgPer = homePage.averagelist.get(homePage.averagelist.size() - 1).getText();
					groupingStripClrList.add(clr.substring(clr.indexOf(" "), clr.length() - 2));
					averageList.add(Integer.parseInt(avgPer.substring(5, avgPer.length() - 1)));
				} else {
					for (int i = 0; i < homePage.groupingstripclrlist.size(); i++) {
						clr = homePage.groupingstripclrlist.get(i).getAttribute("class");
						avgPer = homePage.averagelist.get(i).getText();
						groupingStripClrList.add(clr.substring(clr.indexOf(" ") + 1, clr.length() - 2));
						averageList.add(Integer.parseInt(avgPer.substring(5, avgPer.length() - 1)));
					}
				}
				try {
					rightArrowEnable = homePage.enabledrightarrow;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(500);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}

			} while (enabledRightArrowFound);
			// Verifying average score with colour group
			for (int i = 0; i < averageList.size(); i++) {
				if (averageList.get(i) < 40) {
					Assert.assertTrue(groupingStripClrList.get(i).trim().equals("red"));
				} else if (averageList.get(i) >= 40 && averageList.get(i) <= 59) {
					Assert.assertTrue(groupingStripClrList.get(i).trim().equals("orange"));
				} else if (averageList.get(i) >= 60 && averageList.get(i) <= 79) {
					Assert.assertTrue(groupingStripClrList.get(i).trim().equals("yellow"));
				} else if (averageList.get(i) >= 80) {
					Assert.assertTrue(groupingStripClrList.get(i).trim().equals("green"));
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 37_3 completed");
	}

	/**
	 * This method is used to verify the tooltip text on strands who have elippsis
	 * 
	 * @throws Throwable
	 */
	@Then("^The User should be able to see the tool tip having full text of the strand\\.$")
	public void the_User_should_be_able_to_see_the_tool_tip_having_full_text_of_the_strand() throws Throwable {
		try {
			WebElement rightArrowEnable = null, toolTip;
			boolean enabledRightArrowFound = false;
			Actions action = new Actions(Driver.webdriver);
			do {
				if (enabledRightArrowFound) {
					if (homePage.strandnameslist.get(homePage.strandnameslist.size() - 1).getText().contains("...")) {
						toolTip = homePage.strandnamestooltip;
						Assert.assertTrue(toolTip.getText().contains(UtilityMethods.elipsisRemoval(
								homePage.strandnameslist.get(homePage.strandnameslist.size() - 1).getText())));
					}
				} else {
					for (int i = 0; i < homePage.strandnameslist.size(); i++) {
						action.moveToElement(homePage.strandnameslist.get(i)).build().perform();
						if (homePage.strandnameslist.get(i).getText().contains("...")) {
							toolTip = homePage.strandnamestooltip;
							Assert.assertTrue(toolTip.getText().contains(
									UtilityMethods.elipsisRemoval(homePage.strandnameslist.get(i).getText())));
						}
					}
				}
				try {
					rightArrowEnable = homePage.enabledrightarrow;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(500);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}

			} while (enabledRightArrowFound);

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 37_6 completed");
	}

	/**
	 * This method is used to verify the clicking on strand one by one and the
	 * background colour should be filled with achievement level colour
	 * 
	 * @throws Throwable
	 */
	@Then("^The User click on the strand in header then background of strand colour should be filled with achievement level colour$")
	public void the_User_click_on_the_strand_in_header_then_background_of_strand_colour_should_be_filled_with_achievement_level_colour()
			throws Throwable {
		try {
			String stripClr = "", bgColor = "";
			WebElement rightArrowEnable = null;
			boolean enabledRightArrowFound = false;
			do {
				if (enabledRightArrowFound) {
					stripClr = homePage.groupingstripclrlist.get(homePage.groupingstripclrlist.size() - 1)
							.getAttribute("class");
					stripClr = stripClr.substring(stripClr.indexOf(" ") + 1, stripClr.length() - 2).trim();
					new Actions(Driver.webdriver)
							.moveToElement(homePage.strandnameslist.get(homePage.strandnameslist.size() - 1)).click()
							.build().perform();
					Thread.sleep(3000);
					bgColor = homePage.strandnameslist.get(homePage.strandnameslist.size() - 1).getAttribute("class");
					bgColor = bgColor.substring(bgColor.indexOf(" ") + 1, bgColor.length() - 2).trim();
					Assert.assertTrue(stripClr.equals(bgColor));
				} else {
					for (int i = 0; i < homePage.groupingstripclrlist.size(); i++) {
						stripClr = homePage.groupingstripclrlist.get(i).getAttribute("class");
						stripClr = stripClr.substring(stripClr.indexOf(" ") + 1, stripClr.length() - 2).trim();
						new Actions(Driver.webdriver).moveToElement(homePage.strandnameslist.get(i)).click().build()
								.perform();
						Thread.sleep(3000);
						bgColor = homePage.strandnameslist.get(i).getAttribute("class");
						bgColor = bgColor.substring(bgColor.indexOf(" ") + 1, bgColor.length() - 2).trim();
						Assert.assertTrue(stripClr.equals(bgColor));
						new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
						Thread.sleep(1000);
					}
				}
				try {
					rightArrowEnable = homePage.enabledrightarrow;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(3000);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}
			} while (enabledRightArrowFound);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 37_5 completed");
	}

	/**
	 * Method to click on Performance Over time chart icon
	 * 
	 * @throws Throwable
	 */
	@When("^Click on the icon to maximize the Chart$")
	public void click_on_the_icon_to_maximize_the_Chart() throws Throwable {
		try {
			jse.executeScript("arguments[0].click();", homePage.performance_overtime_icon);
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to verify the first alpha last name student based on
	 * class and student selection
	 * 
	 * @throws Throwable
	 */
	@Then("^first alphabetical student is the one picked when the teacher hits the student button$")
	public void first_alphabetical_student_is_the_one_picked_when_the_teacher_hits_the_student_button()
			throws Throwable {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.studentnameoncontextheader).build().perform();
			String studentNameonUI = homePage.studentnameoncontextheadertooltiptext.getText();
			homePage.rostertab.click();
			Thread.sleep(500);
			Assert.assertTrue(studentNameonUI.contains(homePage.studentdropdownbtn.getText()));
			homePage.rostertab.click();
			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 37_4 completed");
	}

	/**
	 * This method is used to verify the performance over time minimize and maximize
	 * the icon and verify the tooltip text on info icon
	 * 
	 * @throws Throwable
	 */
	@Then("^The user should be able to see the Chart header and the icon next to it can be selected and click on same icon to minimize the Chart$")
	public void the_user_should_be_able_to_see_the_Chart_header_and_the_icon_next_to_it_can_be_selected_and_click_on_same_icon_to_minimize_the_Chart()
			throws Throwable {
		try {
			String tooltipText_on_pot_icon = "Note: The average score listed in the line graph below is calculated from all data available for each assessment based on the content selected. It does not assume the cohort of students remains the same across the assessments listed.";

			new Actions(Driver.webdriver).moveToElement(homePage.info_icon_on_performance_over_time).click().build()
					.perform();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.tooltip_of_info_icon.getText().length() == tooltipText_on_pot_icon.length());
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build()
			.perform();Thread.sleep(1000);
			// verifying for student context
			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(3000);
			Assert.assertTrue(homePage.performanceovrtimeheader.getText().equals("Performance Over Time"));
			new Actions(Driver.webdriver).moveToElement(homePage.info_icon_on_performance_over_time).click().build()
					.perform();
			Thread.sleep(500);
			Assert.assertTrue(homePage.tooltip_of_info_icon.getText().length() == tooltipText_on_pot_icon.length());
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build()
			.perform();Thread.sleep(1000);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 38_1 completed");
	}

	/**
	 * This method is used to verify that the first default selected Strand name is
	 * default header in performance over time chart
	 * 
	 * @throws Throwable
	 */
	@Then("^Verify that the chart header should be the first alphabetical strand by defaultly$")
	public void verify_that_the_chart_header_should_be_the_first_alphabetical_strand_by_defaultly() throws Throwable {
		try {
			click_on_the_icon_to_maximize_the_Chart();
			String firstStrandName;
			if (homePage.strandnameslist.get(0).getText().contains("...")) {
				firstStrandName = homePage.strandnamestooltip.getText();
			} else {
				firstStrandName = homePage.strandnameslist.get(0).getText();
			}
			Assert.assertTrue(homePage.strand_name_in_pot_line_chart.getText().contains(firstStrandName));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 38_2 completed");
	}

	/**
	 * This method is used to verify the clicking on strand names one by one and
	 * that name should become the header of performance over time chart here also
	 * checking the avg percentage of each strand in their column in SP table.
	 * 
	 * @throws Throwable
	 */
	@Then("^Select the Strand within the Strand header from the Standard table and selected strand becomes the header of the Line Chart$")
	public void select_the_Strand_within_the_Strand_header_from_the_Standard_table_and_selected_strand_becomes_the_header_of_the_Line_Chart()
			throws Throwable {
		try {
			String strandName = "";
			WebElement rightArrowEnable = null;
			boolean enabledRightArrowFound = false;

			do {
				if (enabledRightArrowFound) {
					new Actions(Driver.webdriver)
							.moveToElement(homePage.strandnameslist.get(homePage.strandnameslist.size() - 1)).click()
							.build().perform();
					Thread.sleep(3000);
					if (homePage.strandnameslist.get(homePage.strandnameslist.size() - 1).getText().contains("...")) {
						strandName = homePage.strandnamestooltip.getText();
					} else {
						strandName = homePage.strandnameslist.get(homePage.strandnameslist.size() - 1).getText();
					}
					click_on_the_icon_to_maximize_the_Chart();
					Assert.assertTrue(homePage.strand_name_in_pot_line_chart.getText().contains(strandName));
					new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
					Thread.sleep(1000);
				} else {
					for (int i = 0; i < homePage.groupingstripclrlist.size(); i++) {
						new Actions(Driver.webdriver).moveToElement(homePage.strandnameslist.get(i)).click().build()
								.perform();
						Thread.sleep(3000);
						if (homePage.strandnameslist.get(i).getText().contains("...")) {
							strandName = homePage.strandnamestooltip.getText();
						} else {
							strandName = homePage.strandnameslist.get(i).getText();
						}
						click_on_the_icon_to_maximize_the_Chart();
						Assert.assertTrue(homePage.strand_name_in_pot_line_chart.getText().contains(strandName));
						new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
						Thread.sleep(1000);
					}
				}
				try {
					rightArrowEnable = homePage.enabledrightarrow;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(3000);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}
			} while (enabledRightArrowFound);

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 38_3 completed");
	}

	/**
	 * This method is used to click on Test Score button in class context
	 * 
	 * @throws Throwable
	 */
	@When("^User click on Class Context and Test Score button$")
	public void user_click_on_Class_Context_and_Test_Score_button() throws Throwable {
		try {
			if (!API_Connection.getUserRole().equalsIgnoreCase("TEACHER")) {
				UtilityMethods.jump_to_class_context_from_school_or_district_context();
			}
			Assert.assertTrue(homePage.activeclassmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.classmenu);
			Thread.sleep(3000);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		try {
			Assert.assertTrue(homePage.activetestscoresbtn.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.testscoresbtn);
		}
		UtilityMethods.wait_For_Test_Score_Detail_Section();
		Standard_Overview_Table_Steps.testScoreMenuClicked = true;
		Standard_Overview_Table_Steps.underClassContext = true;

	}

	@When("^User click on Test Score button$")
	public void user_click_on_Test_Score_button() throws Throwable {
		try {
			Assert.assertTrue(homePage.activetestscoresbtn.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.testscoresbtn);
		}
		UtilityMethods.wait_For_Test_Score_Detail_Section();
		Standard_Overview_Table_Steps.testScoreMenuClicked = true;
	}

	/**
	 * This method is used to click on Test Score button in district context
	 * 
	 * @throws Throwable
	 */
	@When("^User click on District Context and Test Score button$")
	public void user_click_on_District_Context_and_Test_Score_button() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activedistrictmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.activetestscoresbtn.getAttribute("class").equals("active"));
		} catch (Exception e) {
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.testscoresbtn);
			Thread.sleep(3000);
		}
		Standard_Overview_Table_Steps.testScoreMenuClicked = true;
		Standard_Overview_Table_Steps.underDistrictContext = true;
		UtilityMethods.wait_For_Test_Score_Detail_Section();
	}

	@Then("^verify y-axis labeled with 'Test Scores\\(%\\)' and also verify (\\d+) horizontal lines, one for x axis line and rest label with '(\\d+)' throught '(\\d+)'$")
	public void verify_y_axis_labeled_with_Test_Scores_and_also_verify_horizontal_lines_one_for_x_axis_line_and_rest_label_with_throught(
			int arg1, int arg2, int arg3) throws Throwable {
		try {
			int range = 0;
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			Assert.assertTrue(homePage.yaxis_text_label_on_pot_line_chart.getText().equals("Test Scores (%)"));
			Assert.assertTrue(homePage.horizontal_line_on_pot_line_chart.size() == 11);
			List<WebElement> list = homePage.yaxis_labels_on_horizontal_line_on_pot_line_chart;
			for (int i = 0; i < list.size(); i++) {
				Assert.assertTrue(Integer.parseInt(list.get(i).getText()) == range);
				range += 10;
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 39_1 completed");
	}

	/**
	 * This method used to verify x-axis label on line chart test score over time
	 * and the names of test list on graph with elipsis and tooltip text.
	 * 
	 * @throws Throwable
	 */
	@Then("^verify x_axis labeled with 'Test Names' and show tooltip on test names and if more than '(\\d+)' tests are there then paginator should be display on performance over time$")
	public void verify_x_axis_labeled_with_Test_Names_and_show_tooltip_on_test_names_and_if_more_than_tests_are_there_then_paginator_should_be_display_on_performance_over_time(
			int arg1) throws Throwable {
		try {
			Standard_Overview_Table_Steps.paginationontesttab();
			click_on_the_icon_to_maximize_the_Chart();
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			Assert.assertTrue(homePage.testnameslabel_onlinechart_pot.getText().equals("Test Names"));
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_pot_under_standard_performance()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_pot_under_sp.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(
							homePage.circle_list_on_paginator_on_pot_under_sp, i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
						PaginationUtility_for_Pages.verifyTestNamesAndToolTipText(j);
						new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
						UtilityMethods.verifyColorAndScoreOnLineChart(homePage.testScoreCircleClronPerPage_pot.get(j),
								Integer.parseInt(homePage.testScoresonPerPage_on_pot.get(j).getText()));
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
							new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build()
									.perform();
							PaginationUtility_for_Pages.verifyTestNamesAndToolTipText(j);
							new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build()
									.perform();
							UtilityMethods.verifyColorAndScoreOnLineChart(
									homePage.testScoreCircleClronPerPage_pot.get(j),
									Integer.parseInt(homePage.testScoresonPerPage_on_pot.get(j).getText()));
						}
					}
				} while (PaginationUtility_for_Pages
						.check_Enabled_Left_Arrow_on_Paginator_under_standard_performance());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
					new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
					PaginationUtility_for_Pages.verifyTestNamesAndToolTipText(j);
					new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
					UtilityMethods.verifyColorAndScoreOnLineChart(homePage.testScoreCircleClronPerPage_pot.get(j),
							Integer.parseInt(homePage.testScoresonPerPage_on_pot.get(j).getText()));
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario39_2 performance over time line chart Completed");
	}

	@Then("^line chart of Test score over time should be displayed to the right of it Student list should display$")
	public void line_chart_of_Test_score_over_time_should_be_displayed_to_the_right_of_it_Student_list_should_display()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.testscoreovertimelinechart.isDisplayed());
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
						PaginationUtility_for_Pages.verifyToolTipDetailsonLineChart(j);
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
							PaginationUtility_for_Pages.verifyToolTipDetailsonLineChart(j);
						}
					}
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.verifyToolTipDetailsonLineChart(i);
				}
			}
			CBTConfiguration.score = "pass";
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 40_1 completed");
	}

	@Then("^line chart of Test score over time should be displayed of that student but Student list should not be displayed on test score overview$")
	public void line_chart_of_Test_score_over_time_should_be_displayed_of_that_student_but_Student_list_should_not_be_displayed_on_test_score_overview()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.testscoreoverviewtext.isDisplayed());
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
						PaginationUtility_for_Pages.verify_TestName_ToolTip_Details_on_Test_Score_Overview(j);
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
							PaginationUtility_for_Pages.verify_TestName_ToolTip_Details_on_Test_Score_Overview(j);
						}
					}
				} while (PaginationUtility_for_Pages
						.check_Enabled_Right_Arrow_on_Paginator_on_tso_under_ts_under_student());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.verify_TestName_ToolTip_Details_on_Test_Score_Overview(i);
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario completed");
	}

	/**
	 * This method is used to click on Test Score button in Student COntext
	 * 
	 * @throws Throwable
	 */
	@When("^User click on Student Context and Test Score button$")
	public void user_click_on_Student_Context_and_Test_Score_button() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activestudentmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.activetestscoresbtn.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.testscoresbtn);
			Thread.sleep(1500);
		}
		UtilityMethods.wait_For_Test_Score_Overview_Section_Load();
		Standard_Overview_Table_Steps.testScoreMenuClicked = true;
		Standard_Overview_Table_Steps.underStudentContext = true;
	}

	/**
	 * This method is used to verify the Student LIst is not present in Student
	 * Context- Test Score
	 * 
	 * @throws Throwable
	 */
	@Then("^line chart of Test score over time should be displayed of that student but Student list should not be displayed$")
	public void line_chart_of_Test_score_over_time_should_be_displayed_of_that_student_but_Student_list_should_not_be_displayed()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.testScoresPercentage.isDisplayed());
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsot()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsot.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages
							.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot, i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						PaginationUtility_for_Pages.verifyStudentListNotDisplayWithStudentContext(j);
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
							PaginationUtility_for_Pages.verifyStudentListNotDisplayWithStudentContext(j);
						}
					}
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.verifyStudentListNotDisplayWithStudentContext(i);
				}
			}
			try {
				Assert.assertTrue(homePage.noofstudentsinlist.get(0).isDisplayed());
				log.info("The Student List is display in Student Context Test Score");
				UtilityMethods.processException(new Exception());
			} catch (Exception e) {
				log.info("The Student List is not display in Student Context Test Score");
				CBTConfiguration.score = "pass";
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 40_2 completed");
	}

	/**
	 * This method is used to click on Standard Performance Button in Student
	 * Context
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Standard Performance tab within the Student Context$")
	public void user_Click_on_Standard_Performance_tab_within_the_Student_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activestudentmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.activestandardperformancebtn.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.standardperformancebtn);
		}
		UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
		Standard_Overview_Table_Steps.performanceMenuClicked = true;
		Standard_Overview_Table_Steps.underStudentContext = true;
	}

	@Then("^User click on the circle within the line chart and should able to see the overlay of Tool tip which have following items on performace over time$")
	public void user_click_on_the_circle_within_the_line_chart_and_should_able_to_see_the_overlay_of_Tool_tip_which_have_following_items_on_performace_over_time()
			throws Throwable {
		try {
			if(Standard_Overview_Table_Steps.performanceMenuClicked && Standard_Overview_Table_Steps.underClassContext) {
				homePage.performance_overtime_icon.click();Thread.sleep(500);
				UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
				UtilityMethods.scrollPageDown(Driver.webdriver, 4);
				Thread.sleep(500);
			}
			if(Standard_Overview_Table_Steps.performanceMenuClicked && Standard_Overview_Table_Steps.underClassContext) {
				UtilityMethods.scrollPageDown(Driver.webdriver, 4);
				Thread.sleep(500);
			}
			/*
			 * UtilityMethods.scrollPageDown(Driver.webdriver, 8); Thread.sleep(500);
			 */
			if (PaginationUtility_for_Pages.checkPaginator_on_pot_under_standard_performance()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_pot_under_sp.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(
							homePage.circle_list_on_paginator_on_pot_under_sp, i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
						PaginationUtility_for_Pages.verify_TestName_ToolTip_Details_on_Test_Score_Overview(j);

						UtilityMethods.verifyColorAndScoreOnLineChart(homePage.testScoreCircleClronPerPage_pot.get(j),
								Integer.parseInt(homePage.testScoresonPerPage_on_pot.get(j).getText()));
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
							new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build()
									.perform();
							PaginationUtility_for_Pages.verify_TestName_ToolTip_Details_on_Test_Score_Overview(j);

							UtilityMethods.verifyColorAndScoreOnLineChart(
									homePage.testScoreCircleClronPerPage_pot.get(j),
									Integer.parseInt(homePage.testScoresonPerPage_on_pot.get(j).getText()));
						}
					}
				} while (PaginationUtility_for_Pages
						.check_Enabled_Left_Arrow_on_Paginator_under_standard_performance());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
					new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
					PaginationUtility_for_Pages.verify_TestName_ToolTip_Details_on_Test_Score_Overview(j);

					UtilityMethods.verifyColorAndScoreOnLineChart(homePage.testScoreCircleClronPerPage_pot.get(j),
							Integer.parseInt(homePage.testScoresonPerPage_on_pot.get(j).getText()));
				}
			}
			UtilityMethods.scrollPageUp(Driver.webdriver);Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 41_1 completed");
	}

	/**
	 * This method is used to verify the colour strip with the % range
	 * 
	 * @throws Throwable
	 */
	@Then("^different coloured strips should be displayed$")
	public void different_coloured_strips_should_be_displayed() throws Throwable {
		try {
			Assert.assertTrue(homePage.textoutgraystripinstudentlist.getText().equals("All"));
			Assert.assertTrue(homePage.textoutredstripinstudentlist.getText().equals("< 40%"));
			Assert.assertTrue(homePage.textoutorangestripinstudentlist.getText().equals("40-59%"));
			Assert.assertTrue(homePage.textoutyellowstripinstudentlist.getText().equals("60-79%"));
			Assert.assertTrue(homePage.textoutgreenstripinstudentlist.getText().equals("≥ 80%"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 42_1 completed");
	}

	/**
	 * This method is used to vrify the blue strip highlighted when any coloured
	 * strip is clicked and the associated student list shuld be display with the
	 * colour
	 * 
	 * @throws Throwable
	 */
	@Then("^click on different coloured strips,blue strip should be display under the clicked strip and the no\\. of student records with that colour should be display$")
	public void click_on_different_coloured_strips_blue_strip_should_be_display_under_the_clicked_strip_and_the_no_of_student_records_with_that_colour_should_be_display()
			throws Throwable {
		try {

			int recordsOnClickedStrip = 0, totalCount = 0;
			for (int x = 0; x < homePage.avg_score_colouredStripOnStudentList.size(); x++) {
				if (!(homePage.TextInStripOnStudentList.get(x).getText().equals("0"))) {
					homePage.avg_score_colouredStripOnStudentList.get(x).click();
					Thread.sleep(1000);
					Assert.assertTrue(homePage.avg_score_colouredStripOnStudentList.get(x).getAttribute("class")
							.equals("active_progress"));

					recordsOnClickedStrip = Integer.parseInt(homePage.TextInStripOnStudentList.get(x).getText());

					// checking for paginator
					if (PaginationUtility_for_Pages.checkPaginator_on_list_under_standard_performance()) {
						// this lool will execute for the no. of circle available on paginator
						new Actions(Driver.webdriver)
								.moveToElement(homePage.circle_list_on_paginator_on_list_under_sp.get(0)).build()
								.perform();
						UtilityMethods.scrollPageDown(Driver.webdriver, 2);
						Thread.sleep(500);
						for (int i = 0; i <= homePage.circle_list_on_paginator_on_list_under_sp.size() - 1; i++) {
							PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(
									homePage.circle_list_on_paginator_on_list_under_sp, i);
							Assert.assertTrue(homePage.student_list_on_list.size() <= 10);
							totalCount += homePage.noofstudentsinlist.size();

						}
						// check for left arrow enabled and click on it and click on first circle and
						// validate
						do {
							if (PaginationUtility_for_Pages.check_Enabled_Right_Arrow_on_Paginator_on_list_under_sp()) {
								PaginationUtility_for_Pages
										.clicking_on_enabled_right_Arrow_of_paginator_on_list_under_sp();
								PaginationUtility_for_Pages.clicking_on_last_circle_of_paginator(
										homePage.circle_list_on_paginator_on_list_under_sp);
								Assert.assertTrue(homePage.student_list_on_list.size() <= 10);
								totalCount += homePage.noofstudentsinlist.size();

							}
						} while (PaginationUtility_for_Pages.check_Enabled_Right_Arrow_on_Paginator_on_list_under_sp());
					} else {
						// when paginator is not found
						Assert.assertTrue(homePage.student_list_on_list.size() <= 10);
						totalCount = homePage.noofstudentsinlist.size();
					}
					Thread.sleep(1000);
					Assert.assertTrue(recordsOnClickedStrip == totalCount);
					UtilityMethods.scrollPageUp(Driver.webdriver);
					Thread.sleep(500);
					totalCount = 0;
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 42_2 completed");
	}

	/**
	 * This method is used to verify the student list with minimize and maximize
	 * also with default data display in the student record
	 * 
	 * @throws Throwable
	 */
	@Then("^user should able to see Student List and the icon next to it can be selected to minimize or maximize the Student List window$")
	public void user_should_able_to_see_Student_List_and_the_icon_next_to_it_can_be_selected_to_minimize_or_maximize_the_Student_List_window()
			throws Throwable {
		try {
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			Assert.assertTrue(homePage.student_list_on_list.get(0).isDisplayed());
			// clicking on icon to minimize the student list
			homePage.studentlisticon.click();
			Thread.sleep(500);
			try {
				Assert.assertTrue(homePage.student_list_on_list.get(0).isDisplayed());
				CBTConfiguration.score = "fail";
				UtilityMethods.processException(new Exception());
			} catch (Exception e) {
				CBTConfiguration.score = "pass";
			}
			UtilityMethods.scrollPageDown(Driver.webdriver, 9);
			Thread.sleep(500);
			// clicking on icon to maximize the student list
			homePage.studentlisticon.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.student_list_on_list.get(0).isDisplayed());
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 43_1 completed");
	}

	/**
	 * This method is used to select random Standard in Strand Names list
	 * 
	 * @throws Throwable
	 */
	@When("^Click or select strand and standard from the standard table$")
	public void click_or_select_strand_and_standard_from_the_standard_table() throws Throwable {
		try {
			int randomNumber = 1;
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.standardnameslist.get(randomNumber)).build().perform();
			Thread.sleep(500);
			headerOnToolTip = homePage.stranddefinitionlist.get(randomNumber).getText();
			subHeaderOnToolTip = homePage.standarddescriptionlist.get(randomNumber).getText();
			subHeaderOnToolTip = subHeaderOnToolTip.substring(0, subHeaderOnToolTip.indexOf(":") - 1)
					+ subHeaderOnToolTip.substring(subHeaderOnToolTip.indexOf(":"));
			homePage.standardnameslist.get(randomNumber).click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			new Actions(Driver.webdriver).moveToElement(homePage.achievmentlevelslabel).build().perform();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to verify the selected Strand and Standard from left side
	 * with right side student list records on Test Score Menu with class context
	 * 
	 * @throws Throwable
	 */
	@Then("^The student list related to the selected standard within the perticular strand with the header and the subheader is displayed$")
	public void the_student_list_related_to_the_selected_standard_within_the_perticular_strand_with_the_header_and_the_subheader_is_displayed()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.pot_header.getText().equals(headerOnToolTip));
			Assert.assertTrue(homePage.pot_subheader.getText().equals(subHeaderOnToolTip));
			/**
			 * Note :student list related to the selected standard within the perticular
			 * strand with the header and the subheader is displayed & already covered in
			 * previously created method
			 */
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 43_6 completed");
	}

	/**
	 * This method is used to verify the left most column as student(X) , where X is
	 * the total number belong to the achievement level colour
	 * 
	 * @throws Throwable
	 */
	@Then("^Verify the left most column header should be 'Student \\(X\\)'$")
	public void verify_the_left_most_column_header_should_be_Student_X() throws Throwable {
		try {
			Assert.assertTrue(homePage.StudentRecordsSize.getText()
					.contains("Students (" + homePage.student_list_on_list.size() + ")"));
			Assert.assertTrue(homePage.list_header_in_list.get(0).getText()
					.contains("Students (" + homePage.student_list_on_list.size() + ")"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 43_2 completed");
	}

	/**
	 * This method is used to verify the studentlist, with click or select any
	 * student in list then the student context should be activate and the
	 * information of that student should be display
	 * 
	 * @throws Throwable
	 */
	@Then("^select the student within the student list and Student context with information for that individual student should be shown$")
	public void select_the_student_within_the_student_list_and_Student_context_with_information_for_that_individual_student_should_be_shown()
			throws Throwable {
		try {
			String className;
			HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
			new Actions(Driver.webdriver).moveToElement(homePage.classnameoncontextheader).build().perform();
			if (homePage.classnameoncontextheader.getText().contains("...")) {
				className = homePage.tooltipofclassnameoncontextheader.getText();
			} else {
				className = homePage.classnameoncontextheader.getText();
			}
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
			int studentListSize = homePage.noofstudentsinlist.size();
			int randomNumber = (int) (Math.random() * studentListSize);
			String StudentName = homePage.studentnameslistinstudentlist.get(randomNumber).getText();
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.studentnameslistinstudentlist.get(randomNumber))
					.click().build().perform();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			String studentNameonContext = UtilityMethods.getStudentNameonUI();
			Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
			Assert.assertTrue(studentNameonContext.contains(StudentName));
			String clsName = UtilityMethods.getClassNameonUI();
			Assert.assertTrue(clsName.equals(className));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 43_5 completed");
	}

	/**
	 * This method is used to verify the right most columns as score in student list
	 * 
	 * @throws Throwable
	 */
	@Then("^Verify the right most column header should be 'Score'$")
	public void verify_the_right_most_column_header_should_be_Score() throws Throwable {
		try {
			Assert.assertTrue(homePage.list_header_in_list.get(2).getText().equals("Score"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 43_3 completed");
	}

	@Then("^All the column headers should be sortable with ascending and descending order$")
	public void all_the_column_headers_should_be_sortable_with_ascending_and_descending_order() throws Throwable {
		try {
			String name = "";
			Actions actions = new Actions(Driver.webdriver);
			// clicking on name down arrow
			actions.moveToElement(homePage.studentListnamedownarrow).click().build().perform();
			Thread.sleep(500);
			List<String> listItem = new ArrayList<String>();
			List<Integer> numericlistItem = new ArrayList<Integer>();
			for (int i = 0; i < homePage.studentnameslistinstudentlist.size(); i++) {
				name = homePage.studentnameslistinstudentlist.get(i).getText();
				listItem.add(name.substring(name.indexOf(" ") + 1));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(listItem));
			listItem.clear();

			// clicking on name up arrow
			actions.moveToElement(homePage.studentListnameuparrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.studentnameslistinstudentlist.size(); i++) {
				name = homePage.studentnameslistinstudentlist.get(i).getText();
				listItem.add(name.substring(name.indexOf(" ") + 1));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(listItem));
			listItem.clear();

			// clicking on number of questions down arrow
			actions.moveToElement(homePage.studentListquestiondownarrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.noofquestionsorsubmitdatelistinstudentlist.size(); i++) {
				numericlistItem
						.add(Integer.parseInt(homePage.noofquestionsorsubmitdatelistinstudentlist.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(numericlistItem));
			numericlistItem.clear();

			// clicking on number of questions up arrow
			actions.moveToElement(homePage.studentListquestionuparrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.noofquestionsorsubmitdatelistinstudentlist.size(); i++) {
				numericlistItem
						.add(Integer.parseInt(homePage.noofquestionsorsubmitdatelistinstudentlist.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(numericlistItem));
			numericlistItem.clear();

			// clicking on score down arrow
			actions.moveToElement(homePage.studentListscoredownarrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.studentscorelistinstudentlist.size(); i++) {
				numericlistItem.add(Integer.parseInt(homePage.studentscorelistinstudentlist.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(numericlistItem));
			numericlistItem.clear();

			// clicking on score up arrow
			actions.moveToElement(homePage.studentListscoreuparrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.studentscorelistinstudentlist.size(); i++) {
				numericlistItem.add(Integer.parseInt(homePage.studentscorelistinstudentlist.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(numericlistItem));
			numericlistItem.clear();

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 43_4 completed");
	}

	public void verifying_method_TSD() {
		try {
			int score = 0;
			WebElement scoreElement = null;

			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsd()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsd.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages
							.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsd, i);
					Assert.assertTrue(homePage.student_list_on_list.size() <= 10);
					for (int j = 0; j <= homePage.student_list_on_list.size() - 1; j++) {
						score = Integer.parseInt(homePage.studentscorelistinstudentlist.get(j).getText());
						scoreElement = homePage.studentscorelistinstudentlist.get(j);
						UtilityMethods.verifyColorAndScoreOnStudentList(scoreElement, score);
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Right_Arrow_on_Paginator_on_tsd()) {
						PaginationUtility_for_Pages.clicking_on_enabled_right_Arrow_of_paginator_on_tsd();
						PaginationUtility_for_Pages
								.clicking_on_last_circle_of_paginator(homePage.circle_list_on_paginator_on_tsd);
						Assert.assertTrue(homePage.student_list_on_list.size() <= 10);
						for (int i = 0; i <= homePage.student_list_on_list.size() - 1; i++) {
							score = Integer.parseInt(homePage.studentscorelistinstudentlist.get(i).getText());
							scoreElement = homePage.studentscorelistinstudentlist.get(i);
							UtilityMethods.verifyColorAndScoreOnStudentList(scoreElement, score);
						}
					}
				} while (PaginationUtility_for_Pages.check_Enabled_Right_Arrow_on_Paginator_on_tsd());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.student_list_on_list.size() <= 10);
				for (int i = 0; i <= homePage.student_list_on_list.size() - 1; i++) {
					score = Integer.parseInt(homePage.studentscorelistinstudentlist.get(i).getText());
					scoreElement = homePage.studentscorelistinstudentlist.get(i);
					UtilityMethods.verifyColorAndScoreOnStudentList(scoreElement, score);
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@When("^paginationOntestTab$")
	public static void paginationontesttab() throws Throwable {
		try {
			homePage.datetab.click();
			Thread.sleep(500);
			homePage.districttermdropdownbtn.click();
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath(
					"//div[@class='menu-title' and contains(text(),'District Term')]/following-sibling::div//ul/li[contains(text(),'2018-2019')]"))
					.click();
			Thread.sleep(500);
			homePage.dateapplybtn.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentmenu);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

}
