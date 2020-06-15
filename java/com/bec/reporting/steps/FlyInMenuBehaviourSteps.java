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
 * JAN 04 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.time.Duration;
import java.time.Instant;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.API_Connection;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.FileRead;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.RosterTabUtilityMethods;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.base.Verify;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyInMenuBehaviourSteps {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	public static Properties prop;
	public static String toolTipText = "", env;
	public static String classNameonCH, schoolNameonCH, teacherNameonCH, gradeNameonCH, studentTextonCH;
	public static String uname, passwd, realm;
	public static String token;

	/**
	 * method used to launch the browser with the url and provide the
	 * username,password and usertype
	 * 
	 * @throws Throwable
	 */
	@Given("^User is on portal's login screen with username as \"([^\"]*)\" and password as \"([^\"]*)\" and usertype as \"([^\"]*)\"$")
	public void user_is_on_portal_s_login_screen_with_username_as_and_password_as_and_usertype_as(String username,
			String password, String usertype) throws Throwable {
		try {
			homePage.sign_out_link.click();
			IWait.explicit_wait(Driver.webdriver, homePage.username);
		} catch (Exception e) {
		}
		log.info("User is on portal's login screen");
		try {
			prop = FileRead.readProperties();
			env = prop.getProperty("app_env");
			String url = null;
			uname = prop.getProperty(username);
			passwd = prop.getProperty(password);
			realm = prop.getProperty(usertype);
			if (env.equalsIgnoreCase("dev")) {
				url = prop.getProperty("dev_portalUrl");
				Driver.launch_browser(url);
			} else if (env.equalsIgnoreCase("uat")) {
				url = prop.getProperty("uat_portalUrl");
				Driver.launch_browser(url);
			} else if (env.equalsIgnoreCase("staging")) {
				url = prop.getProperty("staging_portalUrl");
				Driver.launch_browser(url, realm);
			} else if (env.equalsIgnoreCase("prod")) {
				url = prop.getProperty("prod_portalUrl");
				Driver.launch_browser(url, realm);
			}

			Thread.sleep(3000);
			homePage.username.clear();
			homePage.username.sendKeys(uname);
			homePage.password.clear();
			homePage.password.sendKeys(passwd);
			Thread.sleep(500);

			if (env.equalsIgnoreCase("dev") || env.equalsIgnoreCase("uat")) {
				Select select = new Select(homePage.usertypedropdown);
				Thread.sleep(500);
				select.selectByValue(realm);
				Thread.sleep(1000);
				homePage.loginbtn.click();
			} else if (env.equalsIgnoreCase("staging") || env.equalsIgnoreCase("prod")) {
				homePage.loginbtn_on_stg.click();
			}
			Instant start = Instant.now();
			log.info("Current Time after clicking on login button: " + java.time.LocalTime.now());
			if (env.equalsIgnoreCase("dev") || env.equalsIgnoreCase("uat")) {
				IWait.explicit_wait(Driver.webdriver, homePage.studentmenu);
			} else if (env.equalsIgnoreCase("staging") || env.equalsIgnoreCase("prod")) {
				IWait.explicit_wait(Driver.webdriver, homePage.resources_txt_on_dashboard);
				homePage.report_link_on_dashboard.click();
				IWait.explicit_wait(Driver.webdriver, homePage.studentmenu);
			}
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			log.info("Time taken for page load: " + timeElapsed.toMillis() / 1000 + " seconds");
			token = API_Connection.getToken();
		} catch (Exception e) {
			log.error("failed to login");
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to open and close the Universal Selector Tab one by one
	 * 
	 * @param tabName
	 * @throws Throwable
	 */
	@Then("^User is able to open and close the \"([^\"]*)\" tab within the Universal Selector Tab$")
	public void user_is_able_to_open_and_close_the_tab_within_the_Universal_Selector_Tab(String tabName)
			throws Throwable {
		try {
			Verify.verify(homePage.openarrow.isDisplayed());
			Driver.webdriver.findElement(By.xpath("//span[@class='menu-name' and contains(text(),'" + tabName + "')]"))
					.click();
			Thread.sleep(1000);
			if (tabName.equals("Roster")) {
				IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
				Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			} else if (tabName.equals("Test")) {
				IWait.explicit_wait(Driver.webdriver, homePage.searchbarontesttab);
				Verify.verify(homePage.searchbarontesttab.isDisplayed());
			} else {
				IWait.explicit_wait(Driver.webdriver, homePage.districtNameOnSliderMenu);
				Verify.verify(homePage.districtNameOnSliderMenu.isDisplayed());
			}
			Assert.assertTrue(homePage.closearrow.isDisplayed());
			homePage.closearrow.click();
			Thread.sleep(1000);
			Assert.assertTrue(homePage.openarrow.isDisplayed());
			CBTConfiguration.score = "pass";
			Standard_Overview_Table_Steps.resetStatus();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 1 for " + tabName + " Completed");
	}

	/**
	 * method used to click on roster tab and verify school text above school
	 * dropdown
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Roster tab within the Universal Selector Tab$")
	public void user_Click_on_Roster_tab_within_the_Universal_Selector_Tab() throws Throwable {
		try {
			IWait.explicit_wait(Driver.webdriver, homePage.rostertab);
			homePage.rostertab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
			Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to verify the different student type selection in Roster
	 * Tab and after applying button verify the content with context header info
	 * 
	 * @param studentType
	 * @throws Throwable
	 */
	@Then("^User should be able to select school as \"([^\"]*)\" and select grade as \"([^\"]*)\" and Class and student as \"([^\"]*)\" and apply and verify with context header information$")
	public void user_should_be_able_to_select_school_as_and_select_grade_as_and_Class_and_student_as_and_apply_and_verify_with_context_header_information(
			String sc, String grade, String selectiontype) throws Throwable {
		try {
			String selectedSchool = "", selectedClass = "", selectedStudent = "", selectedGrade = "",
					selectedTeacher = "";
			int customSize = 0, randomIndex = 0;
			// selecting school from dropdown
			selectedSchool = sc;
			selectedGrade = grade;
			RosterTabUtilityMethods.select_School_In_School_DropDown(sc);
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(500);

			// selecting Grade from dropdown
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown(grade);
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			Thread.sleep(500);

			homePage.teachersdropdownbtn.click();
			Thread.sleep(500);
			// de-selecting first time"all" teachers
			RosterTabUtilityMethods.uncheck_check_All("Teacher");
			switch (selectiontype) {
			case "single":
				// selecting Teacher from dropdown
				Thread.sleep(500);
				selectedTeacher = homePage.teacherslist.get(2).getText();
				homePage.teacherslist.get(2).click();
				log.info("Selected Teacher is:" + selectedTeacher);
				homePage.teachersdropdownbtn.click();
				Thread.sleep(500);
				// selecting class from dropdown
				UtilityMethods.scrollPageDown(Driver.webdriver, 2);
				Thread.sleep(500);
				homePage.classdropdownbtn.click();
				Thread.sleep(500);
				// de-selecting first time"all" classes
				RosterTabUtilityMethods.uncheck_check_All("Class");
				selectedClass = homePage.classlist.get(1).getText();
				homePage.classlist.get(1).click();
				log.info("Selected Class is:" + selectedClass);
				homePage.classdropdownbtn.click();
				// selecting student from dropdown
				Thread.sleep(500);
				homePage.studentdropdownbtn.click();
				Thread.sleep(500);
				// de-selecting first time"all" students
				// This is to unselect all student from dropdown,as default is all selected
				RosterTabUtilityMethods.uncheck_check_All("Student");
				randomIndex = UtilityMethods.generateRandomNumberBySkippingIndex(homePage.studentlistwithall.size(), 0);
				UtilityMethods.scroll_Div(homePage.studentlistwithall.get(randomIndex), 20);
				Thread.sleep(500);
				selectedStudent = homePage.studentlistwithall.get(randomIndex).getText();
				UtilityMethods.scrollPageDown(Driver.webdriver, 2);
				Thread.sleep(500);
				homePage.studentlistwithall.get(randomIndex).click();
				Thread.sleep(500);
				log.info("Selected Student is:" + selectedStudent);
				homePage.studentdropdownbtn.click();
				break;
			case "multiple":
				// selecting Teacher from dropdown
				Thread.sleep(1000);
				selectedTeacher = homePage.teacherslist.get(2).getText();
				homePage.teacherslist.get(2).click();
				log.info("Selected Teacher is:" + selectedTeacher);
				homePage.teachersdropdownbtn.click();
				// selecting class from dropdown
				Thread.sleep(500);
				UtilityMethods.scrollPageDown(Driver.webdriver, 1);
				Thread.sleep(500);
				homePage.classdropdownbtn.click();
				Thread.sleep(500);
				// de-selecting first time"all" classes
				RosterTabUtilityMethods.uncheck_check_All("Class");
				selectedClass = homePage.classlist.get(1).getText();
				homePage.classlist.get(1).click();
				Thread.sleep(500);
				log.info("Selected Class is:" + selectedClass);
				homePage.classdropdownbtn.click();
				Thread.sleep(500);
				// selecting student from dropdown
				homePage.studentdropdownbtn.click();
				Thread.sleep(500);
				// de-selecting first time"all" students
				// This is to unselect all student from dropdown,as default is all selected
				RosterTabUtilityMethods.uncheck_check_All("Student");
				// selecting custom Teacher from dropdown
				for (int i = 1; i < homePage.studentlistondropdown.size(); i = i + 2) {
					if (homePage.studentlistondropdown.get(i).getText().equals("")) {
						UtilityMethods.scroll_Div(homePage.studentlistondropdown.get(i), 20);
					}
					homePage.studentlistondropdown.get(i).click();
					Thread.sleep(500);
					customSize++;
				}
				homePage.studentdropdownbtn.click();
				Thread.sleep(500);
				break;
			default:
				// de-selecting first time"all" teachers
				homePage.teacherslist.get(0).click();
				Thread.sleep(500);
				homePage.teachersdropdownbtn.click();
				Thread.sleep(500);
				break;
			}
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			Thread.sleep(3000);
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			UtilityMethods.wait_For_Context_Header_Section();

			/**
			 * verifying class and school,teacher,grade and student on context menu by
			 * comparing dropdown text and context menu values
			 */

			switch (selectiontype) {
			case "single":
				Thread.sleep(3000);
				if (homePage.studentnameoncontextheader.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.studentnameoncontextheader).build().perform();
					studentTextonCH = homePage.studentnameoncontextheadertooltiptext.getText();
				} else {
					studentTextonCH = homePage.studentnameoncontextheader.getText();
				}
				log.info("Student name on CH:" + studentTextonCH);
				Assert.assertTrue(studentTextonCH.contains(selectedStudent));
				Assert.assertTrue(homePage.activestudentmenu.isDisplayed());
				verify_Single_Selection_context_header_content(selectedClass, selectedGrade, selectedSchool,
						selectedTeacher);
				break;

			case "multiple":
				Thread.sleep(3000);
				if (homePage.studentnameoncontextheader.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.studentnameoncontextheader).build().perform();
					studentTextonCH = homePage.studentnameoncontextheadertooltiptext.getText();
				} else {
					studentTextonCH = homePage.studentnameoncontextheader.getText();
				}
				log.info("Student name on CH:" + studentTextonCH);
				Assert.assertTrue(studentTextonCH.equals("Custom (" + customSize + ")"));
				Assert.assertTrue(homePage.activeclassmenu.isDisplayed());
				verify_Single_Selection_context_header_content(selectedClass, selectedGrade, selectedSchool,
						selectedTeacher);
				break;

			default:
				Thread.sleep(1000);
				// verifying Grade name context header
				if (homePage.gradenameoncontextheader.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.gradenameoncontextheader).build().perform();
					gradeNameonCH = homePage.tooltipofgradenameoncontextheader.getText();
					new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
				} else {
					gradeNameonCH = homePage.gradenameoncontextheader.getText();
				}
				log.info("Grade name on CH:" + gradeNameonCH);
				selectedGrade = selectedGrade.substring(selectedGrade.indexOf(" ") + 1);
				Assert.assertTrue(selectedGrade.equals(gradeNameonCH));
				new Actions(Driver.webdriver).moveByOffset(200, 200).build().perform();
				// verifying school name context header
				if (homePage.schoolnameoncontextheader.getText().contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.schoolnameoncontextheader).build().perform();
					schoolNameonCH = homePage.tooltipofschoolnameoncontextheader.getText();
					new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
				} else {
					schoolNameonCH = homePage.schoolnameoncontextheader.getText();
				}
				log.info("School name on CH:" + schoolNameonCH);
				Assert.assertTrue(selectedSchool.equals(schoolNameonCH));
				Assert.assertTrue(homePage.activeschoolmenu.isDisplayed());
				break;
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 2 for " + selectiontype + " Completed");
	}

	private void verify_Single_Selection_context_header_content(String selectedClass, String selectedGrade,
			String selectedSchool, String selectedTeacher) {
		try {
			// verifying class name on context header
			Actions actions = new Actions(Driver.webdriver);
			actions.moveByOffset(200, 200).build().perform();
			Thread.sleep(500);
			classNameonCH = UtilityMethods.getClassNameonUI();
			log.info("class name on CH:" + classNameonCH);
			Assert.assertTrue(selectedClass.equals(classNameonCH));
			actions.moveToElement(homePage.overviewtext).click().perform();
			// verifying teacher name on context header
			teacherNameonCH = UtilityMethods.getTeacherNameonUI();
			log.info("Teacher name on CH:" + teacherNameonCH);
			Assert.assertTrue(selectedTeacher.equals(teacherNameonCH));

			// verifying Grade name context header
			gradeNameonCH = UtilityMethods.getGradeNameonUI();
			log.info("Grade name on CH:" + gradeNameonCH);
			selectedGrade = selectedGrade.substring(selectedGrade.indexOf(" ") + 1);
			Assert.assertTrue(selectedGrade.equals(gradeNameonCH));
			// verifying school name context header
			schoolNameonCH = UtilityMethods.getSchoolNameonUI();
			log.info("School name on CH:" + schoolNameonCH);
			Assert.assertTrue(selectedSchool.equals(schoolNameonCH));
			actions.moveToElement(homePage.overviewtext).click().perform();
		} catch (Exception e) {
		}

	}

	/**
	 * method used to click on cancel button on roster tab
	 * 
	 * @throws Throwable
	 */
	@Then("^User should be able to click on cancel button to close the Roster Tab$")
	public void user_should_be_able_to_click_on_cancel_button_to_close_the_Roster_Tab() throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			Thread.sleep(500);
			homePage.rostercancelbtn.click();
			Thread.sleep(500);
			Assert.assertEquals(false, homePage.studentTitleOnSliderMenu.isDisplayed());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 3 Completed");
	}

	/**
	 * method used to click on test tab on universal selector
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Test tab within the Universal Selector Tab$")
	public void user_Click_on_Test_tab_within_the_Universal_Selector_Tab() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			homePage.testtab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.searchbarontesttab);
			Verify.verify(homePage.searchbarontesttab.isDisplayed());
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * method used to select test(s) and apply filter on test tab and verify with
	 * context header
	 * 
	 * @throws Throwable
	 */
	@Then("^User should be able to select \"([^\"]*)\" Test and click on apply filter button$")
	public void user_should_be_able_to_select_Test_and_click_on_apply_filter_button(String testType) throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 4);
			Thread.sleep(1000);
			homePage.allcheckbox_in_test_tab.click();
			Thread.sleep(500);
			String selectedTestName;
			int testCheckBoxListSize = 0, randomNumber = 0;
			testCheckBoxListSize = homePage.testscheckboxlist.size();
			randomNumber = (int) (Math.random() * testCheckBoxListSize);
			switch (testType) {
			case "single":
				selectedTestName = homePage.testnameslist_on_test_tab.get(randomNumber).getText();
				log.info("Selected Test :" + selectedTestName);
				homePage.searchbarontesttab.sendKeys(selectedTestName);
				Thread.sleep(500);
				homePage.testscheckboxlist.get(0).click();
				Thread.sleep(500);
				UtilityMethods.scrollPageDown(Driver.webdriver, 6);
				Thread.sleep(500);
				new Actions(Driver.webdriver).moveToElement(homePage.testapplybtn).click().build().perform();
				UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
				UtilityMethods.scrollPageUp(Driver.webdriver);
				Thread.sleep(500);
				new Actions(Driver.webdriver).moveToElement(homePage.testsNameoncontextheader).build().perform();
				Assert.assertTrue(selectedTestName.equals(homePage.tooltipoftestnameoncontextheader.getText()));
				break;
			case "multiple":
				int noOfSelectedTest = 0;
				for (int i = 0; i < testCheckBoxListSize; i = i + 2) {
					homePage.testscheckboxlist.get(i).click();
					Thread.sleep(500);
					UtilityMethods.scrollPageDown(Driver.webdriver, i);
					Thread.sleep(500);
					noOfSelectedTest++;
				}
				homePage.testapplybtn.click();
				UtilityMethods.scrollPageUp(Driver.webdriver);
				UtilityMethods.wait_For_Context_Header_Section();
				Assert.assertTrue(
						homePage.testsNameoncontextheader.getText().equals("Custom (" + noOfSelectedTest + ")"));
				break;
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 4 Completed");
	}

	/**
	 * method used to click on cancel button on test tab
	 * 
	 * @throws Throwable
	 */
	@Then("^User should be able to click on cancel button to close the Test Tab$")
	public void user_should_be_able_to_click_on_cancel_button_to_close_the_Test_Tab() throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 11);
			Thread.sleep(500);
			homePage.testcancelbtn.click();
			Thread.sleep(500);
			Assert.assertEquals(false, homePage.searchbarontesttab.isDisplayed());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 5 Completed");
	}

	/**
	 * method used to click on date tab within universal selector
	 * 
	 * @throws Throwable
	 */
	@When("^User Click on Date tab within the Universal Selector Tab$")
	public void user_Click_on_Date_tab_within_the_Universal_Selector_Tab() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			homePage.datetab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.districtNameOnSliderMenu);
			Verify.verify(homePage.districtNameOnSliderMenu.isDisplayed());
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * method used to select District Term on date tab and apply filter and verify
	 * with context header
	 * 
	 * @throws Throwable
	 */
	@Then("^User should be able to select district term and click on apply filter button$")
	public void user_should_be_able_to_select_district_term_and_click_on_apply_filter_button() throws Throwable {
		try {
			// selecting Random District Term from the list
			homePage.districttermdropdownbtn.click();
			Thread.sleep(500);
			homePage.districttermlist.get(1).click();
			Thread.sleep(500);
			String districtterm = homePage.districttermdropdownbtn.getText();
			districtterm = districtterm.substring(0, districtterm.indexOf(" "));
			log.info("selected district term:" + districtterm);
			homePage.dateapplybtn.click();

			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(30000);
			/**
			 * Verifying District Term on context header by comparing dropdown text and
			 * context header values
			 */
			String datesonCH = homePage.datesoncontextheader.getText().trim();
			datesonCH = datesonCH.substring(6, 10) + "-" + datesonCH.substring(17);
			log.info("datesonCH :" + datesonCH);
			Assert.assertEquals(districtterm, datesonCH);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 6 Completed");
	}

	/**
	 * method used to click on cancel button on Date tab
	 * 
	 * @throws Throwable
	 */
	@Then("^User should be able to click on cancel button to close the Date Tab$")
	public void user_should_be_able_to_click_on_cancel_button_to_close_the_Date_Tab() throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 3);
			Thread.sleep(1000);
			homePage.datecancelbtn.click();
			Thread.sleep(500);
			Assert.assertEquals(false, homePage.districtNameOnSliderMenu.isDisplayed());
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 7 Completed");
	}

	/**
	 * method used to mouse hover on tab in universal selector
	 * 
	 * @param tabName
	 * @throws Throwable
	 */
	@When("^User mousehover on \"([^\"]*)\" tab within the Universal Selector Tab$")
	public void user_mousehover_on_tab_within_the_Universal_Selector_Tab(String tabName) throws Throwable {
		try {
			Thread.sleep(1000);
			IWait.explicit_wait(Driver.webdriver, homePage.rostertab);
			WebElement el = Driver.webdriver.findElement(By.xpath("//span[@class='menu-name' and contains(text(),'"
					+ tabName + "')]/ancestor::div[@class='menu-item']"));
			new Actions(Driver.webdriver).moveToElement(el).build().perform();
			WebElement ttt = Driver.webdriver.findElement(By.xpath("//span[@class='menu-name' and contains(text(),'"
					+ tabName + "')]/ancestor::div[@class='menu-item']//div[@class='bec_tooltip_content']"));
			toolTipText = ttt.getText();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/**
	 * method used to verify tooltip text of Tab on universal selector
	 * 
	 * @param tabName
	 * @param toolTip
	 * @throws Throwable
	 */
	@Then("^\"([^\"]*)\" tab show tool tip \"([^\"]*)\"$")
	public void tab_show_tool_tip(String tabName, String toolTip) throws Throwable {
		try {
			// Verifying for tooltiptext
			Assert.assertTrue(toolTipText.equals(toolTip));
			log.info(tabName + " shows tooltip " + toolTip);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 8 Completed");
	}
}
