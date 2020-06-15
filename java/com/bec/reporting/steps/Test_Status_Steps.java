package com.bec.reporting.steps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
import com.bec.reporting.utils.RosterTabUtilityMethods;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.collect.Ordering;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test_Status_Steps {
	/**
	 * This is used to initialize webelement of the webpages
	 */
	static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	public static JavascriptExecutor jse = (JavascriptExecutor) Driver.webdriver;

	@When("^User Click on Test Status tab within the District Context$")
	public void user_Click_on_Test_Status_tab_within_the_District_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activedistrictmenu.getAttribute("district").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.active_test_status_btn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.test_status_btn);
		}
		Standard_Overview_Table_Steps.test_status_Menu_Clicked = true;
		Standard_Overview_Table_Steps.underDistrictContext = true;
		UtilityMethods.wait_For_Test_Status_Section_Load();
	}

	@Then("^Verify info icon text on summary$")
	public void verify_info_icon_text_on_summary() throws Throwable {
		try {
			String info_text = "Note: Students who have taken a test more than once will be repeated in the test status results.";
			UtilityMethods.scrollPageDown(Driver.webdriver, 6);
			Thread.sleep(500);
			Assert.assertTrue(homePage.subsectionlist_on_test_status.get(0).getText().equals("Assessments"));
			Assert.assertTrue(homePage.subsectionlist_on_test_status.get(1).getText().equals("Test Status"));
			Assert.assertTrue(homePage.jump_to_top_in_ts.isDisplayed());
			new Actions(Driver.webdriver).moveToElement(homePage.jump_to_top_in_ts).click().build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.info_icon_in_ts.isDisplayed());
			homePage.info_icon_in_ts.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.tool_tip_on_info_icon_in_ts.getText().equals(info_text));
			new Actions(Driver.webdriver).moveByOffset(200, 200).click().build().perform();
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus1 completed");
	}

	@Then("^Verify summary and detail on test status$")
	public void verify_summary_and_detail_on_test_status() throws Throwable {
		try {
			// verifying the order of columns in summary in Test Status
			Assert.assertTrue(homePage.columns_header_in_summary_in_ts.get(0).getText().contains("Test Name"));
			Assert.assertTrue(homePage.columns_header_in_summary_in_ts.get(1).getText().contains("Not Started"));
			Assert.assertTrue(homePage.columns_header_in_summary_in_ts.get(2).getText().contains("In Progress"));
			Assert.assertTrue(
					homePage.columns_header_in_summary_in_ts.get(3).getText().contains("Needs to\n" + "Be Graded"));
			Assert.assertTrue(homePage.columns_header_in_summary_in_ts.get(4).getText().contains("Complete"));

			// Verifying by default the Test Names are in ascending order
			List<String> testNames = new ArrayList<String>();
			for (int i = 0; i < homePage.test_names_in_Test_Name_Column.size(); i++) {
				testNames.add(homePage.test_names_in_Test_Name_Column.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(testNames));
			testNames.clear();
			String testName_on_ch = UtilityMethods.getTestsNameonUI();
			String total_no_of_test = testName_on_ch.substring(testName_on_ch.indexOf("(") + 1,
					testName_on_ch.indexOf(")"));
			String count_on_header = homePage.columns_header_in_summary_in_ts.get(0).getText();
			count_on_header = count_on_header.substring(count_on_header.indexOf("(") + 1, count_on_header.indexOf(")"));
			Assert.assertTrue(total_no_of_test.equals(count_on_header));

			int rand_no = (int) (Math.random() * homePage.test_status_number_in_summary_in_ts.size());
			new Actions(Driver.webdriver).moveToElement(homePage.test_status_number_in_summary_in_ts.get(rand_no))
					.build().perform();
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			log.info("Test Status Number:" + homePage.test_status_number_in_summary_in_ts.get(rand_no).getText());
			homePage.test_status_number_in_summary_in_ts.get(rand_no).click();
			UtilityMethods.wait_For_Test_Status_Section_Load();

			String columnHeader = homePage.column_header_in_summary_in_ts.getText() + ":";
			String testName = homePage.selected_numbers_test_name_in_summary_in_ts.getText();
			log.info("Column Header =>" + columnHeader);
			log.info("Test Name =>" + testName);
			String detail_title = homePage.detail_title_status_in_ts.getText() + homePage.detail_title_in_ts.getText();
			log.info("Detail Title =>" + detail_title);
			Assert.assertTrue(columnHeader.concat(testName).equals(detail_title));

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus2 completed");
	}

	@Then("^Verify sorting order in summary$")
	public void verify_sorting_order_in_summary() throws Throwable {
		try {
			List<String> listItem = new ArrayList<String>();
			List<Integer> ts_numbers = new ArrayList<Integer>();
			// clicking on test name up arrow,checking alpha descending
			new Actions(Driver.webdriver).moveToElement(homePage.test_name_up_arrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.test_names_in_Test_Name_Column.size(); i++) {
				listItem.add(homePage.test_names_in_Test_Name_Column.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(listItem));
			listItem.clear();

			// clicking on test name down arrow,checking alpha ascending
			jse.executeScript("arguments[0].click();", homePage.test_name_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.test_names_in_Test_Name_Column.size(); i++) {
				listItem.add(homePage.test_names_in_Test_Name_Column.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(listItem));
			listItem.clear();

			// clicking on Not Started up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.not_started_up_arrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.not_started_numbers_in_not_started_column.size(); i++) {
				ts_numbers.add(Integer.parseInt(homePage.not_started_numbers_in_not_started_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on Not Started down arrow
			jse.executeScript("arguments[0].click();", homePage.not_started_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.not_started_numbers_in_not_started_column.size(); i++) {
				ts_numbers.add(Integer.parseInt(homePage.not_started_numbers_in_not_started_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on In Progress up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.in_progress_up_arrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.in_progress_numbers_in_in_progress_column.size(); i++) {
				ts_numbers.add(Integer.parseInt(homePage.in_progress_numbers_in_in_progress_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on In Progress down arrow
			jse.executeScript("arguments[0].click();", homePage.in_progress_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.in_progress_numbers_in_in_progress_column.size(); i++) {
				ts_numbers.add(Integer.parseInt(homePage.in_progress_numbers_in_in_progress_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on Needs To Be Graded up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.needs_tbg_up_arrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.needs_to_be_graded_numbers_in_needs_to_be_graded_column.size(); i++) {
				ts_numbers.add(Integer
						.parseInt(homePage.needs_to_be_graded_numbers_in_needs_to_be_graded_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on Needs To Be Graded down arrow
			jse.executeScript("arguments[0].click();", homePage.needs_tbg_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.needs_to_be_graded_numbers_in_needs_to_be_graded_column.size(); i++) {
				ts_numbers.add(Integer
						.parseInt(homePage.needs_to_be_graded_numbers_in_needs_to_be_graded_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on Complete up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.complete_up_arrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.complete_numbers_in_complete_column.size(); i++) {
				ts_numbers.add(Integer.parseInt(homePage.complete_numbers_in_complete_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(ts_numbers));
			ts_numbers.clear();

			// clicking on Complete down arrow
			jse.executeScript("arguments[0].click();", homePage.complete_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.complete_numbers_in_complete_column.size(); i++) {
				ts_numbers.add(Integer.parseInt(homePage.complete_numbers_in_complete_column.get(i).getText()));
			}
			Assert.assertTrue(Ordering.natural().isOrdered(ts_numbers));
			ts_numbers.clear();

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus3 completed");
	}

	@Then("^Verify sorting order in detail$")
	public void verify_sorting_order_in_detail() throws Throwable {
		try {
			int rand_no = (int) (Math.random() * homePage.test_status_number_in_summary_in_ts.size());
			new Actions(Driver.webdriver).moveToElement(homePage.test_status_number_in_summary_in_ts.get(rand_no))
					.build().perform();
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			homePage.test_status_number_in_summary_in_ts.get(rand_no).click();
			Thread.sleep(500);
			List<String> sc_name = new ArrayList<String>();
			List<Date> date_list = new ArrayList<Date>();
			// clicking on test name up arrow,checking alpha descending
			new Actions(Driver.webdriver).moveToElement(homePage.school_up_arrow).click().build().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.school_names_in_school_Column.size(); i++) {
				sc_name.add(homePage.school_names_in_school_Column.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(sc_name));
			sc_name.clear();

			// clicking on test name down arrow,checking alpha ascending
			jse.executeScript("arguments[0].click();", homePage.school_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.school_names_in_school_Column.size(); i++) {
				sc_name.add(homePage.school_names_in_school_Column.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(sc_name));
			sc_name.clear();

			// Create a SimpleDateFormat object for Date String converting.
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
			// clicking on Start Date up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.start_date_up_arrow).click().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.start_dates_in_start_date_Column.size(); i++) {
				date_list.add(sdf.parse(homePage.start_dates_in_start_date_Column.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInDecendingOrder(date_list));
			date_list.clear();

			// clicking on Start Date down arrow
			jse.executeScript("arguments[0].click();", homePage.start_date_down_arrow);
			Thread.sleep(500);
			for (int i = 0; i < homePage.start_dates_in_start_date_Column.size(); i++) {
				date_list.add(sdf.parse(homePage.start_dates_in_start_date_Column.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInAscendingOrder(date_list));
			date_list.clear();

			// clicking on Due Date up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.due_date_up_arrow).click().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.due_dates_in_due_date_Column.size(); i++) {
				date_list.add(sdf.parse(homePage.due_dates_in_due_date_Column.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInDecendingOrder(date_list));
			date_list.clear();

			// clicking on Due Date down arrow
			jse.executeScript("arguments[0].click();", homePage.due_date_down_arrow);
			Thread.sleep(500);

			for (int i = 0; i < homePage.due_dates_in_due_date_Column.size(); i++) {
				date_list.add(sdf.parse(homePage.due_dates_in_due_date_Column.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInAscendingOrder(date_list));
			date_list.clear();

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus4 completed");
	}

	@When("^User Click on Test Status tab within the Class Context$")
	public void user_Click_on_Test_Status_tab_within_the_Class_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activeclassmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.classmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.active_test_status_btn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.test_status_btn);
		}
		Standard_Overview_Table_Steps.test_status_Menu_Clicked = true;
		UtilityMethods.wait_For_Test_Status_Section_Load();
	}

	@Then("^Verify pagination in summary in test status$")
	public void verify_pagination_in_summary_in_test_status() throws Throwable {
		try {
			String testName_on_ch = UtilityMethods.getTestsNameonUI();
			String total_no_of_test = testName_on_ch.substring(testName_on_ch.indexOf("(") + 1,
					testName_on_ch.indexOf(")"));
			String count_on_header = homePage.columns_header_in_summary_in_ts.get(0).getText();
			count_on_header = count_on_header.substring(count_on_header.indexOf("(") + 1, count_on_header.indexOf(")"));
			Assert.assertTrue(total_no_of_test.equals(count_on_header));
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			Thread.sleep(500);
			int test_no_on_header = Integer.parseInt(count_on_header);
			int count_of_test_name = 0;
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_summary_in_Test_Status()) {
				// this loop will execute for the no. of circle available on paginator
				for (int i = 0; i < homePage.circle_list_on_paginator_on_summary_in_ts.size(); i++) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(
							homePage.circle_list_on_paginator_on_summary_in_ts, i);
					Assert.assertTrue(homePage.test_names_in_Test_Name_Column.size() <= 10);
					count_of_test_name += homePage.test_names_in_Test_Name_Column.size();
				}
				// check for right arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages
							.check_Enabled_Right_Arrow_on_Paginator_on_summary_in_Test_Status()) {

						new Actions(Driver.webdriver)
								.moveToElement(homePage.circle_list_on_paginator_on_summary_in_ts
										.get(homePage.circle_list_on_paginator_on_summary_in_ts.size() - 1))
								.build().perform();
						UtilityMethods.scrollPageDown(Driver.webdriver, 2);
						Thread.sleep(500);

						PaginationUtility_for_Pages
								.clicking_on_enabled_right_Arrow_of_paginator_on_summary_in_Test_Status();
						PaginationUtility_for_Pages.clicking_on_last_circle_of_paginator(
								homePage.circle_list_on_paginator_on_summary_in_ts);

						Assert.assertTrue(homePage.test_names_in_Test_Name_Column.size() <= 10);
						count_of_test_name += homePage.test_names_in_Test_Name_Column.size();

					}
				} while (PaginationUtility_for_Pages
						.check_Enabled_Right_Arrow_on_Paginator_on_summary_in_Test_Status());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.test_names_in_Test_Name_Column.size() <= 10);
				count_of_test_name = homePage.test_names_in_Test_Name_Column.size();
			}
			Assert.assertTrue(test_no_on_header == count_of_test_name);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus5 completed");
	}

	@When("^User Click on Test Status tab within the Student Context$")
	public void user_Click_on_Test_Status_tab_within_the_Student_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activestudentmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.active_test_status_btn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.test_status_btn);
		}
		Standard_Overview_Table_Steps.test_status_Menu_Clicked = true;
		Standard_Overview_Table_Steps.underStudentContext = true;
		UtilityMethods.wait_For_Test_Status_Section_Load_under_student_context();
	}

	@Then("^Verify Test Status default reports at Student Context when the Teacher logs in$")
	public void verify_Test_Status_default_reports_at_Student_Context_when_the_Teacher_logs_in() throws Throwable {
		try {
			log.info("Verifying context header info with Roster and Test Tab.");
			String studentName = UtilityMethods.getStudentNameonUI();
			String className = UtilityMethods.getClassNameonUI();
			String testName_on_ch = UtilityMethods.getTestsNameonUI();
			String total_no_of_test = testName_on_ch.substring(testName_on_ch.indexOf("(") + 1,
					testName_on_ch.indexOf(")"));
			homePage.rostertab.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.classdropdownbtn.getText().equals(className));
			Assert.assertTrue(homePage.studentdropdownbtn.getText().equals(studentName));
			homePage.rostercancelbtn.click();
			Thread.sleep(500);

			homePage.testtab.click();
			Thread.sleep(500);
			String testResultCount = homePage.totaltestcount.getText();
			String noOfTestSelected = testResultCount.substring(testResultCount.lastIndexOf(" ") + 1,
					testResultCount.indexOf("/"));
			Assert.assertTrue(noOfTestSelected.equals(total_no_of_test));
			homePage.testtab.click();
			Thread.sleep(500);

			log.info("Verifying filter sequence above table");
			Assert.assertTrue(homePage.test_status_filter_list_under_sc.get(0).getText().equals("All Status"));
			Assert.assertTrue(homePage.test_status_filter_list_under_sc.get(1).getText().equals("Not Started"));
			Assert.assertTrue(homePage.test_status_filter_list_under_sc.get(2).getText().equals("In Progress"));
			Assert.assertTrue(homePage.test_status_filter_list_under_sc.get(3).getText().equals("Needs to Be Graded"));
			Assert.assertTrue(homePage.test_status_filter_list_under_sc.get(4).getText().equals("Complete"));

			Thread.sleep(500);
			log.info("Verifying columns header in table");
			Assert.assertTrue(homePage.table_header_list_under_sc.get(0).getText().contains("Test Name"));
			Assert.assertTrue(homePage.table_header_list_under_sc.get(1).getText().equals("Test Status"));
			Assert.assertTrue(homePage.table_header_list_under_sc.get(2).getText().equals("Assignment"));
			Assert.assertTrue(homePage.table_header_list_under_sc.get(3).getText().equals("Start Date"));
			Assert.assertTrue(homePage.table_header_list_under_sc.get(4).getText().equals("Due Date"));
			Assert.assertTrue(homePage.table_header_list_under_sc.get(5).getText().equals("Submit Date"));
			Thread.sleep(500);
			int tn_count = 0;
			String test_name_count_on_header;

			log.info("Verifying specific filter count in table");
			homePage.test_status_filter_list_under_sc.get(1).click();
			Thread.sleep(500);
			test_name_count_on_header = homePage.table_header_list_under_sc.get(0).getText();
			tn_count = Integer.parseInt(test_name_count_on_header.substring(test_name_count_on_header.indexOf("(") + 1,
					test_name_count_on_header.indexOf(")")));
			verify_Test_Count_Filter_Table(tn_count, homePage.not_started_list_in_table_under_sc);

			homePage.test_status_filter_list_under_sc.get(2).click();
			Thread.sleep(500);
			test_name_count_on_header = homePage.table_header_list_under_sc.get(0).getText();
			tn_count = Integer.parseInt(test_name_count_on_header.substring(test_name_count_on_header.indexOf("(") + 1,
					test_name_count_on_header.indexOf(")")));
			verify_Test_Count_Filter_Table(tn_count, homePage.in_progress_list_in_table_under_sc);

			homePage.test_status_filter_list_under_sc.get(3).click();
			Thread.sleep(500);
			test_name_count_on_header = homePage.table_header_list_under_sc.get(0).getText();
			tn_count = Integer.parseInt(test_name_count_on_header.substring(test_name_count_on_header.indexOf("(") + 1,
					test_name_count_on_header.indexOf(")")));
			verify_Test_Count_Filter_Table(tn_count, homePage.ntb_graded_list_in_table_under_sc);

			homePage.test_status_filter_list_under_sc.get(4).click();
			Thread.sleep(500);
			test_name_count_on_header = homePage.table_header_list_under_sc.get(0).getText();
			tn_count = Integer.parseInt(test_name_count_on_header.substring(test_name_count_on_header.indexOf("(") + 1,
					test_name_count_on_header.indexOf(")")));
			verify_Test_Count_Filter_Table(tn_count, homePage.completed_list_in_table_under_sc);

			homePage.test_status_filter_list_under_sc.get(0).click();
			Thread.sleep(500);
			log.info("Verifying sorting in columns headers");
			List<String> test_names = new ArrayList<String>();
			List<Date> date_list = new ArrayList<Date>();

			// clicking on test name up arrow,checking alpha descending
			new Actions(Driver.webdriver).moveToElement(homePage.test_name_up_arrow_in_table_under_sc).click().build()
					.perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.test_names_in_table_under_sc.size(); i++) {
				test_names.add(homePage.test_names_in_table_under_sc.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().reverse().isOrdered(test_names));
			test_names.clear();

			// clicking on test name down arrow,checking alpha ascending
			jse.executeScript("arguments[0].click();", homePage.test_name_down_arrow_in_table_under_sc);
			Thread.sleep(500);

			for (int i = 0; i < homePage.test_names_in_table_under_sc.size(); i++) {
				test_names.add(homePage.test_names_in_table_under_sc.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(test_names));
			test_names.clear();

			// Create a SimpleDateFormat object for Date String converting.
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
			// clicking on Start Date up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.start_date_up_arrow_in_table_under_sc).click()
					.perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.start_dates_in_table_under_sc.size(); i++) {
				date_list.add(sdf.parse(homePage.start_dates_in_table_under_sc.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInDecendingOrder(date_list));
			date_list.clear();

			// clicking on Start Date down arrow
			jse.executeScript("arguments[0].click();", homePage.start_date_down_arrow_in_table_under_sc);
			Thread.sleep(500);
			for (int i = 0; i < homePage.start_dates_in_table_under_sc.size(); i++) {
				date_list.add(sdf.parse(homePage.start_dates_in_table_under_sc.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInAscendingOrder(date_list));
			date_list.clear();

			// clicking on Due Date up arrow
			new Actions(Driver.webdriver).moveToElement(homePage.due_date_up_arrow_in_table_under_sc).click().perform();
			Thread.sleep(500);
			for (int i = 0; i < homePage.due_dates_in_table_under_sc.size(); i++) {
				date_list.add(sdf.parse(homePage.due_dates_in_table_under_sc.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInDecendingOrder(date_list));
			date_list.clear();

			// clicking on Due Date down arrow
			jse.executeScript("arguments[0].click();", homePage.due_date_down_arrow_in_table_under_sc);
			Thread.sleep(500);

			for (int i = 0; i < homePage.due_dates_in_table_under_sc.size(); i++) {
				date_list.add(sdf.parse(homePage.due_dates_in_table_under_sc.get(i).getText()));
			}
			Assert.assertTrue(UtilityMethods.isDatesSortedInAscendingOrder(date_list));
			date_list.clear();

			// clicking on submit Date up arrow

			/*
			 * new Actions(Driver.webdriver).moveToElement(homePage.
			 * submit_date_up_arrow_in_table_under_sc).click() .perform();
			 * Thread.sleep(500); for (int i = 0; i <
			 * homePage.submit_dates_in_table_under_sc.size(); i++) {
			 * date_list.add(sdf.parse(homePage.submit_dates_in_table_under_sc.get(i).
			 * getText())); }
			 * Assert.assertTrue(UtilityMethods.isDatesSortedInDecendingOrder(date_list));
			 * date_list.clear();
			 */

			// clicking on submit Date down arrow

			/*
			 * jse.executeScript("arguments[0].click();",
			 * homePage.submit_date_down_arrow_in_table_under_sc); Thread.sleep(500);
			 * 
			 * for (int i = 0; i < homePage.submit_dates_in_table_under_sc.size(); i++) {
			 * date_list.add(sdf.parse(homePage.submit_dates_in_table_under_sc.get(i).
			 * getText())); }
			 * Assert.assertTrue(UtilityMethods.isDatesSortedInAscendingOrder(date_list));
			 * date_list.clear();
			 */

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus6 completed");
	}

	private void verify_Test_Count_Filter_Table(int tn_count, List<WebElement> not_started_list_in_table_under_sc) {
		try {
			if (tn_count <= 50) {
				log.info("Table have:" + not_started_list_in_table_under_sc.size() + " records");
				Assert.assertTrue(not_started_list_in_table_under_sc.size() == tn_count);
			} else {
				log.info("Table have more than 50 records");
				Assert.assertTrue(not_started_list_in_table_under_sc.size() == 50);
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@When("^User Click on Test Status tab within the School Context$")
	public void user_Click_on_Test_Status_tab_within_the_School_Context() throws Throwable {

		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activeschoolmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			Thread.sleep(3000);
		}
		try {
			if (FlyInMenuBehaviourSteps.env.equalsIgnoreCase("dev")
					|| FlyInMenuBehaviourSteps.env.equalsIgnoreCase("uat")) {
				UtilityMethods.select_Grade_Four_From_Roster();
			}
			Assert.assertTrue(homePage.active_test_status_btn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.test_status_btn);
		}
		Standard_Overview_Table_Steps.test_status_Menu_Clicked = true;
		UtilityMethods.wait_For_Test_Status_Section_Load();
	}

	@Then("^verify the Print PDF of Test Status District$")
	public void verify_the_Print_PDF_of_Test_Status_District() throws Throwable {
		try {
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.pdf_print_button_in_test_status).click().build()
						.perform();
			} catch (Exception e) {
				new Actions(Driver.webdriver).moveToElement(homePage.pdf_print_button_in_test_status_under_sc).click()
						.build().perform();
			}
			Thread.sleep(2000);
			Assert.assertTrue(homePage.print_Report_Overlay_on_print_popup.isDisplayed());

			Assert.assertTrue(homePage.test_status_title.isDisplayed());

			if (!Standard_Overview_Table_Steps.underStudentContext) {
				Assert.assertTrue(homePage.report_level_title.isDisplayed());
				Assert.assertTrue(
						!homePage.radio_buttons_under_report_level.get(0).getAttribute("class").contains("selected"));
				Assert.assertTrue(
						homePage.radio_buttons_under_report_level.get(1).getAttribute("class").contains("selected"));
			}

			homePage.checkbox_list_under_test_status.get(0).click();
			Thread.sleep(1000);

			for (int i = 0; i < homePage.checkbox_list_under_test_status.size(); i++) {
				Assert.assertTrue(
						!homePage.checkbox_list_under_test_status.get(i).getAttribute("class").contains("selected"));
			}
			homePage.checkbox_list_under_test_status.get(0).click();
			Thread.sleep(1000);
			for (int i = 0; i < homePage.checkbox_list_under_test_status.size(); i++) {
				Assert.assertTrue(
						homePage.checkbox_list_under_test_status.get(i).getAttribute("class").contains("selected"));
			}
			Assert.assertTrue(homePage.print_button_on_popup.isDisplayed());
			Assert.assertTrue(homePage.cancel_button_on_popup.isDisplayed());
			homePage.cancel_button_on_popup.click();
			Thread.sleep(500);
			IWait.check_Absence_of_Element(homePage.print_Report_Overlay_on_print_popup);

			CBTConfiguration.score = "pass";
			Standard_Overview_Table_Steps.resetStatus();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus8 completed");
	}

	@When("^User Click on Comparison Tab in Test Scores tab within the District Context$")
	public void user_Click_on_Comparison_Tab_in_Test_Scores_tab_within_the_District_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activedistrictmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			Thread.sleep(3000);
		}
		// calling method to view the pagination on test tab
		Standard_Overview_Table_Steps.paginationontesttab();
		try {
			Assert.assertTrue(homePage.active_test_scores_btn.getAttribute("class").contains("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.test_scores_btn);
			Thread.sleep(500);
			UtilityMethods.wait_For_Test_Score_Detail_Section();
		}
		try {
			Assert.assertTrue(homePage.active_comparison_tab.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			jse.executeScript("arguments[0].click();", homePage.comparisontab);
		}
		UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
	}

	@Then("^verify Tests are listed in Correct Order for Test Scores Comparision$")
	public void verify_Tests_are_listed_in_Correct_Order_for_Test_Scores_Comparision() throws Throwable {
		try {

			List<String> testNamesOnComparisonTab = new LinkedList<String>();
			WebElement rightArrowEnable = null;
			boolean enabledRightArrowFound = false;

			do {
				if (enabledRightArrowFound) {
					testNamesOnComparisonTab.add(homePage.testnames_on_comparison_tab
							.get(homePage.testnames_on_comparison_tab.size() - 1).getText());
				} else {
					for (int i = 0; i < homePage.testnames_on_comparison_tab.size(); i++) {
						testNamesOnComparisonTab.add(homePage.testnames_on_comparison_tab.get(i).getText());
					}
				}
				try {
					rightArrowEnable = homePage.enabled_right_arrow_on_comparison_tab;
					rightArrowEnable.isEnabled();
					enabledRightArrowFound = true;
					rightArrowEnable.click();
					Thread.sleep(500);
				} catch (Exception e) {
					enabledRightArrowFound = false;
				}

			} while (enabledRightArrowFound);

			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build().perform();
			UtilityMethods.wait_For_Test_Score_Detail_Section();
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);

			LinkedList<String> test_Names = RosterTabUtilityMethods.getAllTestNamesOf_TestScoreOverTime();

			// verifying test names should be same
			for (int i = 0; i < testNamesOnComparisonTab.size(); i++) {
				Assert.assertTrue(testNamesOnComparisonTab.get(i).trim().equals(test_Names.get(i).trim()));
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus9 completed");
	}

	@Then("^verify the No Data Modal for Test Status$")
	public void verify_the_No_Data_Modal_for_Test_Status() throws Throwable {
		try {
			jse.executeScript("arguments[0].click();", homePage.test_status_btn);
			Thread.sleep(3000);
			Assert.assertTrue(homePage.nodatavailableforyourselection.isDisplayed());
			Assert.assertTrue(homePage.returntopreviousreport.isDisplayed());
			homePage.returntopreviousreport.click();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.overviewtext.isDisplayed());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus10 completed");
	}

	@Then("^Verify the data displayed in Detail section of Test Status Class View$")
	public void verify_the_data_displayed_in_Detail_section_of_Test_Status_Class_View() throws Throwable {
		try {
			String currentHandle = Driver.webdriver.getWindowHandle();

			if (API_Connection.getUserRole().equalsIgnoreCase("TEACHER")) {
				// clicking on Not Started up arrow
				new Actions(Driver.webdriver).moveToElement(homePage.not_started_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.not_started_numbers_in_not_started_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(500);
				verify_new_window_url(currentHandle, "assignments");

				// clicking on In Progress up arrow
				new Actions(Driver.webdriver).moveToElement(homePage.in_progress_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.in_progress_numbers_in_in_progress_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(500);
				verify_new_window_url(currentHandle, "assignments");

				// clicking on Needs To Be Graded up arrow new
				new Actions(Driver.webdriver).moveToElement(homePage.needs_tbg_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.needs_to_be_graded_numbers_in_needs_to_be_graded_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(500);
				verify_new_window_url(currentHandle, "grading");

				// clicking on Complete up arrow new
				new Actions(Driver.webdriver).moveToElement(homePage.complete_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.complete_numbers_in_complete_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(1000);
				Assert.assertTrue(homePage.active_sta_tab.isDisplayed());
			} else if (API_Connection.getUserRole().equalsIgnoreCase("SCHOOL_ADMIN")
					|| API_Connection.getUserRole().equalsIgnoreCase("DISTRICT_ADMIN")) {
				// clicking on Not Started up arrow
				new Actions(Driver.webdriver).moveToElement(homePage.not_started_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.not_started_numbers_in_not_started_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(500);
				verify_no_new_window(currentHandle);

				// clicking on In Progress up arrow
				new Actions(Driver.webdriver).moveToElement(homePage.in_progress_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.in_progress_numbers_in_in_progress_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(500);
				verify_no_new_window(currentHandle);

				// clicking on Needs To Be Graded up arrow new
				new Actions(Driver.webdriver).moveToElement(homePage.needs_tbg_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.needs_to_be_graded_numbers_in_needs_to_be_graded_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(500);
				verify_new_window_url(currentHandle, "grading");

				// clicking on Complete up arrow new
				new Actions(Driver.webdriver).moveToElement(homePage.complete_up_arrow).click().build().perform();
				Thread.sleep(500);
				homePage.complete_numbers_in_complete_column.get(0).click();
				UtilityMethods.wait_For_Test_Status_Section_Load();
				new Actions(Driver.webdriver).moveToElement(homePage.assessment_names_in_detail_section.get(0)).click()
						.build().perform();
				Thread.sleep(1000);
				log.info("Is STA tab display:" + homePage.active_sta_tab.isDisplayed());
				// Assert.assertTrue(homePage.active_sta_tab.isDisplayed());
			}

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus11 completed");
	}

	@Then("^Verify the data displayed in Detail section of Test Status School View$")
	public void verify_the_data_displayed_in_Detail_section_of_Test_Status_School_View() throws Throwable {
		try {
			homePage.class_Names_under_details_in_Test_status.get(0).click();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus12 completed");
	}

	private void verify_no_new_window(String currentHandle) {
		try {
			// getting all the handles currently available
			Set<String> handles = Driver.webdriver.getWindowHandles();
			Assert.assertTrue(handles.size() == 1);
			for (String actual : handles) {
				Assert.assertTrue(actual.equalsIgnoreCase(currentHandle));
			}
		} catch (Exception e) {
			log.error("Multiple window opened...");
			UtilityMethods.processException(e);
		}
	}

	private void verify_new_window_url(String baseHandle, String url_text) {
		try {
			// getting all the handles currently available
			Set<String> handles = Driver.webdriver.getWindowHandles();
			Assert.assertTrue(handles.size() >= 2);
			ArrayList<String> tabs = new ArrayList<String>(Driver.webdriver.getWindowHandles());

			Driver.webdriver.switchTo().window(tabs.get(0));
			Thread.sleep(1000);

		} catch (Exception e) {
			log.error("Unable to get current windows url...");
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify row highlighting and Drill down in Student Context$")
	public void verify_row_highlighting_and_Drill_down_in_Student_Context() throws Throwable {
		String currentHandle = Driver.webdriver.getWindowHandle();
		try {

			new Actions(Driver.webdriver).moveToElement(homePage.test_status_filter_list_under_sc.get(1)).click()
					.build().perform();
			Thread.sleep(1000);
			UtilityMethods.wait_For_Test_Status_Section_Load_under_student_context();
			homePage.not_started_list_in_table_under_sc.get(0).click();
			Thread.sleep(500);
			verify_new_window_url(currentHandle, "assignments");

			new Actions(Driver.webdriver).moveToElement(homePage.test_status_filter_list_under_sc.get(2)).click()
					.build().perform();
			Thread.sleep(1000);
			UtilityMethods.wait_For_Test_Status_Section_Load_under_student_context();
			homePage.in_progress_list_in_table_under_sc.get(0).click();
			Thread.sleep(500);
			verify_new_window_url(currentHandle, "assignments");

			new Actions(Driver.webdriver).moveToElement(homePage.test_status_filter_list_under_sc.get(3)).click()
					.build().perform();
			Thread.sleep(1000);
			UtilityMethods.wait_For_Test_Status_Section_Load_under_student_context();
			homePage.ntb_graded_list_in_table_under_sc.get(0).click();
			Thread.sleep(500);
			verify_new_window_url(currentHandle, "grading");

			new Actions(Driver.webdriver).moveToElement(homePage.test_status_filter_list_under_sc.get(4)).click()
					.build().perform();
			Thread.sleep(1000);
			UtilityMethods.wait_For_Test_Status_Section_Load_under_student_context();
			homePage.completed_list_in_table_under_sc.get(0).click();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.active_sta_tab.isDisplayed());

			try {
				log.info("This will call if no data available with STA");
				Assert.assertTrue(homePage.nodatavailableforyourselection.isDisplayed());
				Assert.assertTrue(homePage.returntopreviousreport.isDisplayed());
				homePage.returntopreviousreport.click();
				Thread.sleep(2000);
			} catch (Exception e) {

			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus11 completed");
	}

	@Then("^Verify user accessing the reports of the student on moving Student A from Class A to Class B within the same School$")
	public void verify_user_accessing_the_reports_of_the_student_on_moving_Student_A_from_Class_A_to_Class_B_within_the_same_School()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher ,grade & class
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Judith Brooks");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("GRADE 4 - ALVARADO - 1");
			// verify no student available for that teacher/class
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys("Dawn Adams");
			Thread.sleep(500);
			Assert.assertTrue(homePage.norecordavailableonrostertab.isDisplayed());
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonstudentdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher ,grade & class
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Nicole Ryder");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("GRADE 4 - OTT - 1");
			// verify student available for that teacher/class
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys("Dawn Adams");
			Thread.sleep(500);
			Assert.assertTrue(Driver.webdriver.findElement(By.xpath("//li[.='Dawn Adams']")).isDisplayed());

			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonstudentdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus14 completed");
	}

	@Then("^Verify users accessing the reports of the student or class and switching to grading page on moving Student A from Class A to Class B within the same School$")
	public void verify_users_accessing_the_reports_of_the_student_or_class_and_switching_to_grading_page_on_moving_Student_A_from_Class_A_to_Class_B_within_the_same_School()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher ,grade & class
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Judith Brooks");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("GRADE 4 - ALVARADO - 1");
			// verify no student available for that teacher/class
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys("Dawn Adams");
			Thread.sleep(500);
			Assert.assertTrue(homePage.norecordavailableonrostertab.isDisplayed());
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonstudentdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher ,grade & class
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Nicole Ryder");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("GRADE 4 - OTT - 1");
			// verify student available for that teacher/class
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys("Dawn Adams");
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='Dawn Adams']")).click();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			// clicking on "Benchmark Advance G4 U2 W1 Assessment" associated circle value
			homePage.testScoresonPerPage_on_pot.get(0).click();
			Thread.sleep(1000);
			for (int i = 0; i < homePage.questionlistontooltip.size(); i++) {
				Assert.assertFalse(UtilityMethods.isAttribtuePresent(homePage.questionlistontooltip.get(i), "href"));
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus15 completed");
	}

	@Then("^Verify user accessing the reports of the student on moving Student A from school A to school B within the same district$")
	public void verify_user_accessing_the_reports_of_the_student_on_moving_Student_A_from_school_A_to_school_B_within_the_same_district()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("109TH STREET ELEMENTARY");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher ,grade & class
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Albert Juarez");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("GRADE 4 - GUEMBES - 1");
			// verify no student available for that teacher/class
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys("Russell Brewer");
			Thread.sleep(500);
			Assert.assertTrue(homePage.norecordavailableonrostertab.isDisplayed());
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonstudentdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher ,grade & class
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Judith Brooks");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("GRADE 4 - ALVARADO - 1");
			// verify student available for that teacher/class
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys("Russell Brewer");
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='Russell Brewer']")).click();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus16 completed");
	}

	@Then("^Verify Teacher A from class A leaves and Teacher B takes over class A, and accessing the reports within same school and in same district$")
	public void verify_Teacher_A_from_class_A_leaves_and_Teacher_B_takes_over_class_A_and_accessing_the_reports_within_same_school_and_in_same_district()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("HM PEARSON ELEMENTARY SCHOOL");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher & class
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Colleen Fairley");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Class");
			homePage.searchbaronclassdropdown.sendKeys("READING 5  (DASS MICHELE-4)");
			Thread.sleep(500);
			Assert.assertTrue(homePage.norecordavailableonrostertab.isDisplayed());
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonclassdropdown).click().build().perform();
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);

			homePage.rostertab.click();
			Thread.sleep(500);
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown("HM PEARSON ELEMENTARY SCHOOL");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			// selecting teacher & class
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Josephina Donnell");
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Class");
			homePage.searchbaronclassdropdown.sendKeys("READING 5  (DASS MICHELE-4)");
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='READING 5  (DASS MICHELE-4)']")).click();
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.studentmenu.click();Thread.sleep(2000);
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			// clicking on "Pretest" associated circle value
			homePage.testScoresonPerPage_on_pot.get(0).click();
			Thread.sleep(1000);
			for (int i = 0; i < homePage.questionlistontooltip.size(); i++) {
				Assert.assertFalse(UtilityMethods.isAttribtuePresent(homePage.questionlistontooltip.get(i), "href"));
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus17 completed");
	}

	@Then("^Verify Student Data filter by class dropdown with info icon within the Roster tab$")
	public void verify_Student_Data_filter_by_class_dropdown_with_info_icon_within_the_Roster_tab() throws Throwable {
		try {
			String roster_tooltip_text = "Select additional classes to include this data in the student's reports.";
			String tooltip_text_on_ch = "This report includes student data from another class or classes.";
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Student_In_Student_DropDown("Earl Blackman");
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.classdropdownbtn.getText().equals(homePage.studentdatadropdownbtn.getText()));
			Assert.assertTrue(homePage.studentdata_filter.isDisplayed());
			homePage.studentdata_filter.click();
			Assert.assertTrue(homePage.tooltip_text_on_roster.getText().equals(roster_tooltip_text));

			homePage.studentdatadropdownbtn.click();
			Thread.sleep(500);
			// this is for selecting 'all'
			// Driver.webdriver.findElement(By.xpath("//span[contains(text(),'Student
			// Data')]/ancestor::div[@class='menu-title']/following-sibling::div/button/following-sibling::div//li[text()='All']")).click();Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='GRADE 4 - ALVARADO - 1']")).click();
			Thread.sleep(500);
			homePage.studentdatadropdownbtn.click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			Assert.assertTrue(homePage.info_icon_on_ch.isDisplayed());
			homePage.info_icon_on_ch.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.tooltip_text_on_ch.getText().equals(tooltip_text_on_ch));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario TestStatus18 completed");
	}

}
