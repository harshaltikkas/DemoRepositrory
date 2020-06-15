package com.bec.reporting.steps;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.FileRead;
import com.bec.reporting.utils.RosterTabUtilityMethods;
import com.bec.reporting.utils.UtilityMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Validate_Persistence_on_different_switching_steps {
	/**
	 * This is used to initialize webelement of the webpages
	 */
	static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	public static JavascriptExecutor jse = (JavascriptExecutor) Driver.webdriver;

	@Then("^Verify Test Scores Comparison Persistence on switching to all other levels$")
	public void verify_Test_Scores_Comparison_Persistence_on_switching_to_all_other_levels() throws Throwable {
		try {
			String grade_no_on_ch, test_name_on_ch;
			homePage.rostertab.click();
			Thread.sleep(500);
			String grade = homePage.gradedropdownbtn.getText();
			grade = grade.substring(grade.indexOf(" ") + 1);
			homePage.rostertab.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			String testname = UtilityMethods.getRandomTest_From_Test_Tab();
			log.info("Selected Test in Test Tab :" + testname);
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			Assert.assertTrue(homePage.activestandardperformancebtn.isDisplayed());
			grade_no_on_ch = UtilityMethods.getGradeNameonUI();
			Assert.assertTrue(grade.equals(grade_no_on_ch));
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));

			jse.executeScript("arguments[0].click();", homePage.testscoresbtn);
			UtilityMethods.wait_For_Test_Score_Detail_Section();

			jse.executeScript("arguments[0].click();", homePage.comparisontab);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("District"));
			homePage.compare_cb_list_on_comparison_tab.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));

			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(1).getText().equals("District"));

			homePage.compare_cb_list_on_comparison_tab.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(2).getText().equals("District"));

			homePage.compare_cb_list_on_comparison_tab.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(2).getText().equals("District"));
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(2).getText().equals("District"));
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(1).getText().equals("District"));
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));

			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_test_score();
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_comparison_tab.get(0).getText().equals("District"));
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-2277 completed");
	}

	@Then("^Verify Single Test Analysis Persistence on switching to all other levels through subway nav filters$")
	public void verify_Single_Test_Analysis_Persistence_on_switching_to_all_other_levels_through_subway_nav_filters()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			Assert.assertTrue(homePage.activestandardperformancebtn.isDisplayed());
			String test_name_on_ch;
			jse.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			String testname = UtilityMethods.getRandomTest_From_Test_Tab();
			UtilityMethods.wait_For_STA_Section_Load();
			log.info("Selected Test in Test Tab :" + testname);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			Assert.assertTrue(testname.equals(test_name_on_ch));

			// BE-2274
			homePage.filter_in_sta_for_district.click();
			Thread.sleep(1000);
			homePage.all_chkbox_on_filter_in_sta.click();
			Thread.sleep(500);
			String selectedViewName = homePage.chkbox_list_text_under_view_on_sta_filter.get(1).getText();
			homePage.chkbox_list_text_under_view_on_sta_filter.get(1).click();
			Thread.sleep(500);
			log.info("selected View Name: " + selectedViewName);
			if (homePage.chkbox_list_text_under_view_on_sta_filter.size() == 2) {
				homePage.cancel_button_on_filter_in_sta.click();
			} else {
				homePage.apply_button_on_filter_in_sta.click();
			}
			Thread.sleep(2000);
			log.info("view name on sta table header :"+homePage.view_text_in_sta_table_header.getText());
			log.info("verifying view selected on filter matched with STA table column header on District menu");
			Assert.assertTrue(homePage.view_text_in_sta_table_header.getText().equals(selectedViewName));

			homePage.schoolmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Thread.sleep(1000);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			log.info("Test Name on CH on school menu:" + test_name_on_ch);
			Assert.assertTrue(testname.equals(test_name_on_ch));
			log.info("verifying view selected on filter matched with STA table column header on school menu");
			Assert.assertTrue(homePage.view_text_in_sta_table_header.getText().equals(selectedViewName));
			homePage.filter_in_sta_for_district.click();
			Thread.sleep(1000);
			// BE-2274 end here
			Assert.assertTrue(
					homePage.chkbox_list_under_view_on_sta_filter.get(1).getAttribute("class").contains("Selected"));
			homePage.cancel_button_on_filter_in_sta.click();
			Thread.sleep(1000);

			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("District"));
			homePage.compare_cb_list_on_sta.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("District"));

			homePage.classmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Thread.sleep(1000);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			log.info("Test Name on CH on class menu:" + test_name_on_ch);
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(1).getText().equals("District"));
			homePage.compare_cb_list_on_sta.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(2).getText().equals("District"));

			homePage.studentmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Thread.sleep(1000);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			log.info("Test Name on CH on student menu:" + test_name_on_ch);
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(2).getText().equals("District"));
			homePage.compare_cb_list_on_sta.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("Student"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("Class"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(2).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(3).getText().equals("District"));

			homePage.classmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Thread.sleep(1000);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			log.info("Test Name on CH on class menu:" + test_name_on_ch);
			Assert.assertTrue(testname.equals(test_name_on_ch));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(1).getText().equals("District"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("Class"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(2).getText().equals("District"));

			homePage.schoolmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Thread.sleep(1000);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			log.info("Test Name on CH on school menu:" + test_name_on_ch);
			Assert.assertTrue(testname.equals(test_name_on_ch));

			Assert.assertTrue(homePage.compare_cb_list_on_sta.get(0).getText().equals("District"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(0).getText().equals("School"));
			Assert.assertTrue(homePage.compared_columns_list_on_table_on_sta.get(1).getText().equals("District"));

			homePage.districtmenu.click();
			UtilityMethods.wait_For_STA_Section_Load();
			Thread.sleep(1000);
			test_name_on_ch = UtilityMethods.getTestsNameonUI();
			log.info("Test Name on CH on district menu:" + test_name_on_ch);
			Assert.assertTrue(testname.equals(test_name_on_ch));

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-2276 completed");
	}

	@When("^User click on Roster tab and select single School and click apply$")
	public void user_click_on_Roster_tab_and_select_single_School_and_click_apply() throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_School_In_School_DropDown("Golden Oak Community School");
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify User is switched to School and Class subway is enabled and Student subway is disabled$")
	public void verify_User_is_switched_to_School_and_Class_subway_is_enabled_and_Student_subway_is_disabled()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.activeschoolmenu.isDisplayed());
			Assert.assertTrue(homePage.classmenu.isDisplayed());
			try {
				homePage.studentmenu.click();
				Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
				UtilityMethods.processException(new Exception());
			} catch (Exception e) {
				log.info("Student Subway filter is disabled");
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Navigate back to District and click on Roster tab and select multiple Schools and click apply$")
	public void navigate_back_to_District_and_click_on_Roster_tab_and_select_multiple_Schools_and_click_apply()
			throws Throwable {
		try {
			homePage.districtmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			Thread.sleep(500);
			homePage.rostertab.click();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("School");
			homePage.searchbaronschooldropdown.sendKeys("Golden Oak Community School");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Golden Oak Community School']").click();
			homePage.searchcancelonschooldropdown.click();
			Thread.sleep(500);
			homePage.searchbaronschooldropdown.sendKeys("Fair Oaks Ranch Community School");
			Driver.webdriver.findElementByXPath("//li[.='Fair Oaks Ranch Community School']").click();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify User is in District context and School subway is enabled and Class and Student subway are disabled$")
	public void verify_User_is_in_District_context_and_School_subway_is_enabled_and_Class_and_Student_subway_are_disabled()
			throws Throwable {
		try {
			Assert.assertTrue(homePage.schoolmenu.isDisplayed());
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			try {
				homePage.classmenu.click();
				Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
				homePage.studentmenu.click();
				Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
				UtilityMethods.processException(new Exception());
			} catch (Exception e) {
				log.info("Class Subway filter is disabled");
				log.info("Student Subway filter is disabled");
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@When("^User click on Roster tab and select a School and one Teacher and one Class and click apply$")
	public void user_click_on_Roster_tab_and_select_a_School_and_one_Teacher_and_one_Class_and_click_apply()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("School");
			RosterTabUtilityMethods.uncheck_check_All("School");
			homePage.searchbaronschooldropdown.sendKeys("Golden Oak Community School");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Golden Oak Community School']").click();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.rostertab).build().perform();
			RosterTabUtilityMethods.wait_For_Refresh_Icon(homePage.schoolRefreshIcon, "School");
			Assert.assertTrue(homePage.teachersdropdownbtn.isDisplayed());
			Properties prop = FileRead.readProperties();
			if (prop.getProperty("app_env").equalsIgnoreCase("staging")
					|| prop.getProperty("app_env").equalsIgnoreCase("prod")) {
				RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Amanda Jones");
			} else {
				RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("John Stephenson");
			}
			Assert.assertTrue(homePage.classdropdownbtn.isDisplayed());
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 6 - Jones - 0");
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver, 4);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Navigate back to District and click on Roster tab and select a School and multiple Teachers and Classes and click apply$")
	public void navigate_back_to_District_and_click_on_Roster_tab_and_select_a_School_and_multiple_Teachers_and_Classes_and_click_apply()
			throws Throwable {
		try {
			homePage.districtmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_School_In_School_DropDown("Golden Oak Community School");
			homePage.teachersdropdownbtn.click();
			RosterTabUtilityMethods.uncheck_check_All("Teacher");
			Properties prop = FileRead.readProperties();
			if (prop.getProperty("app_env").equalsIgnoreCase("staging")
					|| prop.getProperty("app_env").equalsIgnoreCase("prod")) {
				homePage.searchbaronteacherdropdown.sendKeys("Paula Torgeson");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Paula Torgeson']").click();
				Thread.sleep(500);
				homePage.searchcancelonteacherdropdown.click();
				Thread.sleep(500);
				homePage.searchbaronteacherdropdown.sendKeys("Amanda Jones");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Amanda Jones']").click();
				Thread.sleep(500);
			} else {
				homePage.searchbaronteacherdropdown.sendKeys("Michael Segura");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Michael Segura']").click();
				Thread.sleep(500);
				homePage.searchcancelonteacherdropdown.click();
				Thread.sleep(500);
				homePage.searchbaronteacherdropdown.sendKeys("John Stephenson");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='John Stephenson']").click();
				Thread.sleep(500);
			}
			homePage.teachersdropdownbtn.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver, 4);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Navigate back to District and click on Roster tab and select a School and Class and single Student and click apply$")
	public void navigate_back_to_District_and_click_on_Roster_tab_and_select_a_School_and_Class_and_single_Student_and_click_apply()
			throws Throwable {
		try {
			homePage.districtmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_School_In_School_DropDown("Golden Oak Community School");
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 6 - Jones - 0");
			Properties prop = FileRead.readProperties();
			if (prop.getProperty("app_env").equalsIgnoreCase("staging")
					|| prop.getProperty("app_env").equalsIgnoreCase("prod")) {
				RosterTabUtilityMethods.select_Student_In_Student_DropDown("Samantha Cortez");
			} else {
				RosterTabUtilityMethods.select_Student_In_Student_DropDown("Terri Alexander");
			}
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver, 4);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify User is switched to Student and School and Class subway filters are enabled$")
	public void verify_User_is_switched_to_Student_and_School_and_Class_subway_filters_are_enabled() throws Throwable {
		try {
			Assert.assertTrue(homePage.schoolmenu.isDisplayed());
			Assert.assertTrue(homePage.classmenu.isDisplayed());
			Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Navigate back to District and click on Roster tab and select a School and a Class and multiple Students and click apply$")
	public void navigate_back_to_District_and_click_on_Roster_tab_and_select_a_School_and_a_Class_and_multiple_Students_and_click_apply()
			throws Throwable {
		try {
			homePage.districtmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_School_In_School_DropDown("Golden Oak Community School");
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 6 - Jones - 0");
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			Thread.sleep(500);
			Properties prop = FileRead.readProperties();
			if (prop.getProperty("app_env").equalsIgnoreCase("staging")
					|| prop.getProperty("app_env").equalsIgnoreCase("prod")) {
				homePage.searchbaronstudentdropdown.sendKeys("Samantha Cortez");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Samantha Cortez']").click();
				Thread.sleep(500);
				homePage.searchcancelonstudentdropdown.click();
				Thread.sleep(500);
				homePage.searchbaronstudentdropdown.sendKeys("Ricardo Aguiar");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Ricardo Aguiar']").click();
				Thread.sleep(500);
				homePage.searchcancelonstudentdropdown.click();
				Thread.sleep(500);
				homePage.searchbaronstudentdropdown.sendKeys("Jacen Fadri");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Jacen Fadri']").click();
			} else {
				homePage.searchbaronstudentdropdown.sendKeys("Terri Alexander");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Terri Alexander']").click();
				Thread.sleep(500);
				homePage.searchcancelonstudentdropdown.click();
				Thread.sleep(500);
				homePage.searchbaronstudentdropdown.sendKeys("Melissa Gagner");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Melissa Gagner']").click();
				Thread.sleep(500);
				homePage.searchcancelonstudentdropdown.click();
				Thread.sleep(500);
				homePage.searchbaronstudentdropdown.sendKeys("Ann Galyean");
				Thread.sleep(500);
				Driver.webdriver.findElementByXPath("//li[.='Ann Galyean']").click();
			}
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver, 4);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify User is switched to Class and School and Student subway filters are enabled$")
	public void verify_User_is_switched_to_Class_and_School_and_Student_subway_filters_are_enabled() throws Throwable {
		try {
			Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			Assert.assertTrue(homePage.schoolmenu.isDisplayed());
			Assert.assertTrue(homePage.studentmenu.isDisplayed());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-2257,2258,2259,2261,2262,2263 completed");
	}

	@When("^User click on Roster tab and select one Teacher and one Class and click apply$")
	public void user_click_on_Roster_tab_and_select_one_Teacher_and_one_Class_and_click_apply() throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Travis Bruce");
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 6 - Hines - 0");
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Navigate back to School and click on Roster tab and select multiple Teachers and Classes and click apply$")
	public void navigate_back_to_School_and_click_on_Roster_tab_and_select_multiple_Teachers_and_Classes_and_click_apply()
			throws Throwable {
		try {
			homePage.schoolmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(500);
			homePage.teachersdropdownbtn.click();
			RosterTabUtilityMethods.uncheck_check_All("Teacher");
			Thread.sleep(500);
			homePage.searchbaronteacherdropdown.sendKeys("Travis Bruce");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Travis Bruce']").click();
			Thread.sleep(500);
			homePage.searchcancelonteacherdropdown.click();
			Thread.sleep(500);
			homePage.searchbaronteacherdropdown.sendKeys("Randy Grant");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Randy Grant']").click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver, 4);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@When("^User click on Roster tab and select a Class and single Student and click apply$")
	public void user_click_on_Roster_tab_and_select_a_Class_and_single_Student_and_click_apply() throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			homePage.teachersdropdownbtn.click();
			RosterTabUtilityMethods.uncheck_check_All("Teacher");
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 6 - Hines - 0");
			RosterTabUtilityMethods.select_Student_In_Student_DropDown("Paul Blair");
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Navigate back to School and click on Roster tab and select a Class and multiple Students and click apply$")
	public void navigate_back_to_School_and_click_on_Roster_tab_and_select_a_Class_and_multiple_Students_and_click_apply()
			throws Throwable {
		try {
			homePage.schoolmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 6 - Hines - 0");
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			Thread.sleep(500);
			homePage.searchbaronstudentdropdown.sendKeys("Patricia Balcom");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Patricia Balcom']").click();
			Thread.sleep(500);
			homePage.searchcancelonstudentdropdown.click();
			Thread.sleep(500);
			homePage.searchbaronstudentdropdown.sendKeys("Paul Blair");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Paul Blair']").click();
			Thread.sleep(500);
			homePage.searchcancelonstudentdropdown.click();
			Thread.sleep(500);
			homePage.searchbaronstudentdropdown.sendKeys("Daniel Castillo");
			Thread.sleep(500);
			Driver.webdriver.findElementByXPath("//li[.='Daniel Castillo']").click();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify the persistence by selecting data in Roster tab filters of STA$")
	public void verify_the_persistence_by_selecting_data_in_Roster_tab_filters_of_STA() throws Throwable {
		try {
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			Assert.assertTrue(homePage.activestandardperformancebtn.isDisplayed());
			jse.executeScript("arguments[0].click();", homePage.statab);
			UtilityMethods.wait_For_STA_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(1000);
			String scName, grade, teacherName, className, student_name;
			String scName_on_ch, grade_name_on_ch, teacher_name_on_ch, class_name_on_ch, student_name_on_ch;

			scName = RosterTabUtilityMethods.select_School_In_School_DropDown("Golden Oak Community School");
			grade = RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			teacherName = RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Anastasia Clarke");
			className = RosterTabUtilityMethods.select_Class_In_Class_DropDown("Grade 4 - McCarthy - 0");
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			student_name = RosterTabUtilityMethods.select_Student_In_Student_DropDown("Wendy Allen");
			homePage.rosterapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			UtilityMethods.wait_For_STA_Section_Load();
			grade = grade.substring(grade.indexOf(" ") + 1);
			scName_on_ch = UtilityMethods.getSchoolNameonUI();
			teacher_name_on_ch = UtilityMethods.getTeacherNameonUI();
			grade_name_on_ch = UtilityMethods.getGradeNameonUI();
			class_name_on_ch = UtilityMethods.getClassNameonUI();
			student_name_on_ch = UtilityMethods.getStudentNameonUI();

			Assert.assertTrue(student_name.equals(student_name_on_ch));
			Assert.assertTrue(scName_on_ch.equals(scName));
			Assert.assertTrue(grade.equals(grade_name_on_ch));
			Assert.assertTrue(teacherName.equals(teacher_name_on_ch));
			Assert.assertTrue(className.equals(class_name_on_ch));
			log.info("Roster Tab value matched with context header data on student context");
			homePage.classmenu.click();
			Thread.sleep(500);
			UtilityMethods.wait_For_STA_Section_Load();
			scName_on_ch = UtilityMethods.getSchoolNameonUI();
			teacher_name_on_ch = UtilityMethods.getTeacherNameonUI();
			grade_name_on_ch = UtilityMethods.getGradeNameonUI();
			class_name_on_ch = UtilityMethods.getClassNameonUI();
			Assert.assertTrue(scName_on_ch.equals(scName));
			Assert.assertTrue(grade.equals(grade_name_on_ch));
			Assert.assertTrue(teacherName.equals(teacher_name_on_ch));
			Assert.assertTrue(className.equals(class_name_on_ch));
			log.info("Roster Tab value matched with context header data on class context");
			
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = "pass";
		log.info("Scenario BE-2270 completed");
	}

	@Then("^Verify Standard Performance Summary Persistence on switching to all other levels$")
	public void verify_Standard_Performance_Summary_Persistence_on_switching_to_all_other_levels() throws Throwable {
		try {
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			Assert.assertTrue(homePage.activestandardperformancebtn.isDisplayed());
			jse.executeScript("arguments[0].click();", homePage.summarytab);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			new Actions(Driver.webdriver).moveToElement(homePage.viewDropDown_on_summary).click().build().perform();
			Thread.sleep(500);
			homePage.viewDropDownList_on_summary.get(1).click();
			Thread.sleep(500);
			String selected_view = homePage.viewDropDown_on_summary.getText();
			homePage.compare_cb_list_on_summary.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			Thread.sleep(1000);
			Assert.assertTrue(selected_view.equals(homePage.viewDropDown_on_summary.getText()));
			homePage.compare_cb_list_on_summary.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(1).getText().equals("School Average"));

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			Thread.sleep(1000);
			Assert.assertTrue(selected_view.equals(homePage.viewDropDown_on_summary.getText()));
			homePage.compare_cb_list_on_summary.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			Thread.sleep(1000);
			Assert.assertTrue(selected_view.equals(homePage.viewDropDown_on_summary.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			Thread.sleep(1000);
			Assert.assertTrue(selected_view.equals(homePage.viewDropDown_on_summary.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			Thread.sleep(1000);
			Assert.assertTrue(selected_view.equals(homePage.viewDropDown_on_summary.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(1).getText().equals("School Average"));

			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			UtilityMethods.wait_For_Summary_Tab_Section_Load();
			Thread.sleep(1000);
			Assert.assertTrue(selected_view.equals(homePage.viewDropDown_on_summary.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_summary_tab.get(0).getText().equals("District Average"));

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = "pass";
		log.info("Scenario BE-2319 completed");
	}

	@Then("^Verify Standard Performance Comparison Persistence on switching to all other levels$")
	public void verify_Standard_Performance_Comparison_Persistence_on_switching_to_all_other_levels() throws Throwable {
		try {
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			Assert.assertTrue(homePage.activestandardperformancebtn.isDisplayed());
			jse.executeScript("arguments[0].click();", homePage.comparisontab);
			UtilityMethods.wait_For_Standards_Pop_up_Load();
			new Actions(Driver.webdriver).moveToElement(homePage.dropDowns_on_edit_standards_on_pop_up.get(0)).click()
					.build().perform();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.viewDropDown_list_on_edit_standards_on_pop_up.get(2))
					.click().build().perform();
			Thread.sleep(1000);
			String view_name_on_pop_up = homePage.dropDowns_on_edit_standards_on_pop_up.get(0).getText();
			log.info("view name from popup on District menu:" + view_name_on_pop_up);
			new Actions(Driver.webdriver).moveToElement(homePage.applyBtnOnstandardTab).click().build().perform();
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			log.info("view on comparison table: " + homePage.comparison_tab_sp_text.getText());
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));
			log.info("selected view from popup on DA menu and view name on table are same on school context");
			homePage.compare_cb_list_on_comparison.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(
					homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));

			// clicking on school menu
			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			log.info("clicked on school menu");
			Thread.sleep(15000);
			log.info("previously selected view name from popup on district menu:" + view_name_on_pop_up);
			
			log.info("selected view name on popup on school menu:" + homePage.dropDowns_on_edit_standards_on_pop_up.get(0).getText());
			Assert.assertTrue(
					view_name_on_pop_up.equals(homePage.dropDowns_on_edit_standards_on_pop_up.get(0).getText()));

			new Actions(Driver.webdriver).moveToElement(homePage.applyBtnOnstandardTab).click().build().perform();
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			log.info("view on comparison table: " + homePage.comparison_tab_sp_text.getText());
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));
			homePage.compare_cb_list_on_comparison.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));

			// clicking on class menu
			jse.executeScript("arguments[0].click();", homePage.classmenu);
			log.info("clicked on class menu");
			Thread.sleep(15000);
			log.info("view name from popup on class menu:" + view_name_on_pop_up);
			Assert.assertTrue(
					view_name_on_pop_up.equals(homePage.dropDowns_on_edit_standards_on_pop_up.get(0).getText()));

			new Actions(Driver.webdriver).moveToElement(homePage.applyBtnOnstandardTab).click().build().perform();
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			log.info("view on comparison table: " + homePage.comparison_tab_sp_text.getText());
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));
			homePage.compare_cb_list_on_comparison.get(0).click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(2).getText().equals("Class Average"));

			// clicking on student menu
			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(15000);
			log.info("view name from popup on student menu:" + view_name_on_pop_up);
			Assert.assertTrue(
					view_name_on_pop_up.equals(homePage.dropDowns_on_edit_standards_on_pop_up.get(0).getText()));

			new Actions(Driver.webdriver).moveToElement(homePage.applyBtnOnstandardTab).click().build().perform();
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			log.info("view on comparison table: " + homePage.comparison_tab_sp_text.getText());
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));

			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(2).getText().equals("Class Average"));

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(1).getText().equals("School Average"));

			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			UtilityMethods.wait_For_Comparison_Tab_Section_Load_under_standard_performance();
			Assert.assertTrue(view_name_on_pop_up.equals(homePage.comparison_tab_sp_text.getText()));
			Assert.assertTrue(homePage.compare_list_of_avg_on_comparison_tab.get(0).getText().equals("District Average"));

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = "pass";
		log.info("Scenario BE-2320 completed");
	}

	@Then("^User Click on School subway navigation and verify reports for the first school from the list is displayed$")
	public void user_Click_on_School_subway_navigation_and_verify_reports_for_the_first_school_from_the_list_is_displayed()
			throws Throwable {
		try {
			String schoolname, schoolname_on_ch;
			homePage.rostertab.click();
			Thread.sleep(1000);
			String grade = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			schoolname = homePage.classORSchoolNamesListInClassListPageHeaders.get(0).getText();
			log.info("First School from the list is" + schoolname);
			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			Assert.assertTrue(homePage.activeschoolmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			schoolname_on_ch = UtilityMethods.getSchoolNameonUI();
			Assert.assertTrue(schoolname.equals(schoolname_on_ch));
			log.info(
					"First School from the list in District is matched with School name of context header in School context");
			homePage.rostertab.click();
			Thread.sleep(1000);
			String grade_on_roster = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			log.info(grade_on_roster);
			Assert.assertTrue(grade_on_roster.equals(grade));
			log.info("Roster Tab value in School matched with Roster Tab value in District");
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^User Click on Class subway navigation and verify reports for the fisrt class from the list is displayed$")
	public void user_Click_on_Class_subway_navigation_and_verify_reports_for_the_fisrt_class_from_the_list_is_displayed()
			throws Throwable {
		try {
			String classname, classname_on_ch, classname_on_roster, grade_on_roster, schoolname, schoolname_on_roster;
			classname = homePage.classORSchoolNamesListInClassListPageHeaders.get(0).getText();
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname = homePage.schooldropdownbtn.getText();
			String grade = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			log.info("First Class from the list is" + classname);
			jse.executeScript("arguments[0].click();", homePage.classmenu);
			Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			classname_on_ch = UtilityMethods.getClassNameonUI();
			Assert.assertTrue(classname_on_ch.equals(classname));
			log.info(
					"First Class from the list in School is matched with the Class name in context header of Class context");
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname_on_roster = homePage.schooldropdownbtn.getText();
			grade_on_roster = homePage.gradedropdownbtn.getText();
			classname_on_roster = homePage.classdropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(schoolname_on_roster.equals(schoolname));
			Assert.assertTrue(grade_on_roster.equals(grade));
			Assert.assertTrue(classname_on_roster.equals(classname));
			log.info("Roster Tab value in Class matched with Roster Tab value in School");
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^User Click on Student subway navigation and verify reports for the first student from the list is displayed$")
	public void user_Click_on_Student_subway_navigation_and_verify_reports_for_the_first_student_from_the_list_is_displayed()
			throws Throwable {
		try {
			String studentname, studentname_on_ch, studentname_on_roster, teachername, teachername_on_roster,
					schoolname, schoolname_on_roster, classname, classname_on_roster;
			studentname = homePage.classORSchoolNamesListInClassListPageHeaders.get(0).getText();
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname = homePage.schooldropdownbtn.getText();
			String grade = homePage.gradedropdownbtn.getText();
			teachername = homePage.teachersdropdownbtn.getText();
			classname = homePage.classdropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			log.info("First Class from the list is" + studentname);
			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			studentname_on_ch = UtilityMethods.getStudentNameonUI();
			Assert.assertTrue(studentname_on_ch.equals(studentname));
			log.info(
					"First Student from the list in Class is matched with the Student name in context header of Student context");
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname_on_roster = homePage.schooldropdownbtn.getText();
			String grade_on_roster = homePage.gradedropdownbtn.getText();
			teachername_on_roster = homePage.teachersdropdownbtn.getText();
			classname_on_roster = homePage.classdropdownbtn.getText();
			studentname_on_roster = homePage.studentdropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(schoolname_on_roster.equals(schoolname));
			Assert.assertTrue(grade_on_roster.equals(grade));
			Assert.assertTrue(teachername_on_roster.equals(teachername));
			Assert.assertTrue(classname_on_roster.equals(classname));
			Assert.assertTrue(studentname_on_roster.equals(studentname));
			log.info("Roster Tab value in Student matched with Roster Tab value in Class");
			Thread.sleep(2000);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^User Click on Class subway navigation and verify the Roster for Class name$")
	public void user_Click_on_Class_subway_navigation_and_verify_the_Roster_for_Class_name() throws Throwable {
		try {
			String classname_on_roster, classname, teachername, teachername_on_roster, schoolname, schoolname_on_roster;
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname = homePage.schooldropdownbtn.getText();
			String grade = homePage.gradedropdownbtn.getText();
			teachername = homePage.teachersdropdownbtn.getText();
			classname = homePage.classdropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			jse.executeScript("arguments[0].click();", homePage.classmenu);
			Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname_on_roster = homePage.schooldropdownbtn.getText();
			String grade_on_roster = homePage.gradedropdownbtn.getText();
			teachername_on_roster = homePage.teachersdropdownbtn.getText();
			classname_on_roster = homePage.classdropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(schoolname_on_roster.equals(schoolname));
			Assert.assertTrue(grade_on_roster.equals(grade));
			Assert.assertTrue(teachername_on_roster.equals(teachername));
			Assert.assertTrue(classname_on_roster.equals(classname));
			log.info("Roster Tab value in Class matched with Roster Tab value in Student");
			Thread.sleep(2000);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^User Click on School subway navigation and verify the Roster for School name$")
	public void user_Click_on_School_subway_navigation_and_verify_the_Roster_for_School_name() throws Throwable {
		try {
			String schoolname, schoolname_on_roster, grade_on_roster;
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname = homePage.schooldropdownbtn.getText();
			String grade = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			Assert.assertTrue(homePage.activeschoolmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname_on_roster = homePage.schooldropdownbtn.getText();
			grade_on_roster = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(schoolname_on_roster.equals(schoolname));
			Assert.assertTrue(grade_on_roster.equals(grade));
			log.info("Roster Tab value in School matched with Roster Tab value in School");
			Thread.sleep(2000);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^User Click on District subway navgation and verify the Roster tab$")
	public void user_Click_on_District_subway_navgation_and_verify_the_Roster_tab() throws Throwable {
		try {
			String schoolname, schoolname_on_roster, grade_on_roster;
			schoolname = "All";
			homePage.rostertab.click();
			Thread.sleep(1000);
			String grade = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.rostertab.click();
			Thread.sleep(1000);
			schoolname_on_roster = homePage.schooldropdownbtn.getText();
			grade_on_roster = homePage.gradedropdownbtn.getText();
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(schoolname_on_roster.equals(schoolname));
			Assert.assertTrue(grade_on_roster.equals(grade));
			log.info("Roster Tab value in District matched with Roster Tab value in School");
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	@Then("^Verify the Persistence of Date tab by switching to different levels using subway navigation$")
	public void verify_the_Persistence_of_Date_tab_by_switching_to_different_levels_using_subway_navigation()
			throws Throwable {
		try {
			homePage.datetab.click();
			Thread.sleep(500);
			homePage.districttermdropdownbtn.click();
			Thread.sleep(500);
			homePage.districttermlist.get(1).click();
			Thread.sleep(500);
			String districtterm = homePage.districttermdropdownbtn.getText();
			districtterm = districtterm.substring(0, districtterm.indexOf(" "));
			log.info("selected district term:" + districtterm);
			homePage.dateapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			String datesonCH = homePage.datesoncontextheader.getText().trim();
			datesonCH = datesonCH.substring(6, 10) + "-" + datesonCH.substring(17);
			log.info("datesonCH :" + datesonCH);
			Assert.assertEquals(districtterm, datesonCH);
			Thread.sleep(1000);

			/**
			 * Verifying Date tab Persistence in School context
			 */

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			Assert.assertTrue(homePage.activeschoolmenu.isDisplayed());
			homePage.datetab.click();
			Thread.sleep(1000);
			String schooldistrictterm = homePage.districttermdropdownbtn.getText();
			schooldistrictterm = schooldistrictterm.substring(0, schooldistrictterm.indexOf(" "));
			homePage.datecancelbtn.click();
			log.info("selected district term:" + schooldistrictterm);
			Assert.assertTrue(schooldistrictterm.equals(districtterm));
			Thread.sleep(1000);

			/**
			 * Verifying Date tab Persistence in Class context
			 */

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			homePage.datetab.click();
			Thread.sleep(1000);
			String classdistrictterm = homePage.districttermdropdownbtn.getText();
			classdistrictterm = classdistrictterm.substring(0, classdistrictterm.indexOf(" "));
			homePage.datecancelbtn.click();
			log.info("selected district term:" + classdistrictterm);
			Assert.assertTrue(classdistrictterm.equals(districtterm));
			Thread.sleep(1000);

			/**
			 * Verifying Date tab Persistence in Student context
			 */

			jse.executeScript("arguments[0].click();", homePage.studentmenu);
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
			homePage.datetab.click();
			Thread.sleep(1000);
			String studentdistrictterm = homePage.districttermdropdownbtn.getText();
			studentdistrictterm = studentdistrictterm.substring(0, studentdistrictterm.indexOf(" "));
			homePage.datecancelbtn.click();
			log.info("selected district term:" + studentdistrictterm);
			Assert.assertTrue(studentdistrictterm.equals(districtterm));
			Thread.sleep(1000);

			/**
			 * Verifying Persistence in reverse order
			 */

			jse.executeScript("arguments[0].click();", homePage.classmenu);
			Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.datetab.click();
			Thread.sleep(1000);
			classdistrictterm = homePage.districttermdropdownbtn.getText();
			classdistrictterm = classdistrictterm.substring(0, classdistrictterm.indexOf(" "));
			homePage.datecancelbtn.click();
			log.info("selected district term:" + classdistrictterm);
			Assert.assertTrue(classdistrictterm.equals(studentdistrictterm));
			Thread.sleep(1000);

			/**
			 * Verifying Date tab Persistence in School context
			 */

			jse.executeScript("arguments[0].click();", homePage.schoolmenu);
			Assert.assertTrue(homePage.activeschoolmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.datetab.click();
			Thread.sleep(1000);
			schooldistrictterm = homePage.districttermdropdownbtn.getText();
			schooldistrictterm = schooldistrictterm.substring(0, schooldistrictterm.indexOf(" "));
			homePage.datecancelbtn.click();
			log.info("selected district term:" + schooldistrictterm);
			Assert.assertTrue(schooldistrictterm.equals(studentdistrictterm));
			Thread.sleep(1000);

			/**
			 * Verifying Date tab Persistence in District context
			 */

			jse.executeScript("arguments[0].click();", homePage.districtmenu);
			Assert.assertTrue(homePage.activedistrictmenu.isDisplayed());
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.datetab.click();
			Thread.sleep(1000);
			districtterm = homePage.districttermdropdownbtn.getText();
			districtterm = districtterm.substring(0, districtterm.indexOf(" "));
			homePage.datecancelbtn.click();
			log.info("selected district term:" + districtterm);
			Assert.assertTrue(districtterm.equals(studentdistrictterm));
			Thread.sleep(1000);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}
	
	@Then("^Verify Standard Performance Grouping Persistence for teacher at class level$")
	public void verify_Standard_Performance_Grouping_Persistence_for_teacher_at_class_level() throws Throwable {
	    try {
	    	Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
			Assert.assertTrue(homePage.activestandardperformancebtn.isDisplayed());
			jse.executeScript("arguments[0].click();", homePage.groupingTab);
			Thread.sleep(5000);
			Assert.assertTrue(homePage.groupingTabText.getText().equals("Edit Groups"));
	    
	    } catch (Exception e) {
			UtilityMethods.processException(e);
		}
		CBTConfiguration.score = "pass";
		log.info("Scenario BE-2339 completed");
	}
}
