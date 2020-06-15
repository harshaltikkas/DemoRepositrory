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
 * JAN 14 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.RosterTabUtilityMethods;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.base.Verify;
import com.google.common.collect.Ordering;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RosterTabDropDownBehaviour {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	public static String selectedSchoolName, selectedclassText, selectedStudentText;
	int schoolcount = 0, selectedschoolIndex = 0, classcount = 0, selectedclassIndex = 0, studentcount = 0,
			selectedstudent = 0;	

	/**
	 * This method is used to click on roster and verify the school and class name
	 * should be in alphabatical order and the student list shuld be in alphabatical
	 * order based on last name
	 * 
	 * @throws Throwable
	 */
	@Then("^User Click on Roster tab within the Universal Selector Tab and the School and Class and students last names should be displayed in alphabetical ascending order with selection of \"([^\"]*)\" school and \"([^\"]*)\" class and \"([^\"]*)\" as student$")
	public void user_Click_on_Roster_tab_within_the_Universal_Selector_Tab_and_the_School_and_Class_and_students_last_names_should_be_displayed_in_alphabetical_ascending_order_with_selection_of_school_and_class_and_as_student(
			String sc, String cl, String st) throws Throwable {
		try {
			List<String> schoolList = new ArrayList<String>();
			List<String> classList = new ArrayList<String>();
			List<String> studentList = new ArrayList<String>();
			homePage.rostertab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
			Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			Thread.sleep(500);

			// **checking school dropdown in ascending order*//
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("School");
			schoolcount = homePage.schoollist.size();
			String scName;
			for (int i = 0; i < schoolcount; i++) {
				scName = homePage.schoollist.get(i).getText();
				if (scName.equals("")) {
					UtilityMethods.scroll_Div(homePage.schoollist.get(i), 10);
				}
				schoolList.add(homePage.schoollist.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(schoolList));

			selectedSchoolName = sc;
			log.info("Selected School:" + sc);

			homePage.searchbaronschooldropdown.sendKeys(selectedSchoolName);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='" + selectedSchoolName + "']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonschooldropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();

			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();

			RosterTabUtilityMethods.wait_For_Refresh_Icon(homePage.schoolRefreshIcon, "School");
			UtilityMethods.scrollPageDown(Driver.webdriver, 9);
			Thread.sleep(500);

			// **checking class dropdown in ascending order*//
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Class");
			classcount = homePage.classlist.size();
			String clName;
			for (int i = 0; i < classcount; i++) {
				clName = homePage.classlist.get(i).getText();
				if (clName.equals("")) {
					UtilityMethods.scroll_Div(homePage.classlist.get(i), 10);
				}
				classList.add(homePage.classlist.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(classList));

			selectedclassText = cl;
			log.info("Selected Class:" + selectedclassText);
			Thread.sleep(500);
			homePage.searchbaronclassdropdown.sendKeys(selectedclassText);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='" + selectedclassText + "']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonclassdropdown).click().build().perform();
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();

			RosterTabUtilityMethods.wait_For_Refresh_Icon(homePage.studentRefreshIcon, "Student");

			// **checking student dropdown in ascending order*//
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			studentcount = homePage.studentlistondropdown.size();
			String tempString;
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			List<String> list = new ArrayList<>();
			for (int i = 0; i < studentcount; i++) {
				tempString = homePage.studentlistondropdown.get(i).getText();
				if (tempString.equals("")) {
					UtilityMethods.scroll_Div(homePage.studentlistondropdown.get(i), 10);
					tempString = homePage.studentlistondropdown.get(i).getText();
				}
				list.add(tempString);
				studentList.add(tempString.substring(tempString.indexOf(" ") + 1) + " "
						+ tempString.substring(0, tempString.indexOf(" ")));
			}

			Assert.assertTrue(Ordering.natural().isOrdered(studentList));
			RosterTabUtilityMethods.uncheck_check_All("Student");

			selectedStudentText = st;
			log.info("Selected Student:" + selectedStudentText);
			homePage.searchbaronstudentdropdown.sendKeys(selectedStudentText);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='" + selectedStudentText + "']")).click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();

			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 10_2 and Scenario 12 are Completed");
	}

	/**
	 * This method verify that selected option from the dropdown in school,class and
	 * student should be on top while comes back to dropdown
	 * 
	 * @throws Throwable
	 */
	@Then("^Verify selected option should appear in respected dropdowns$")
	public void verify_selected_option_should_appear_in_respected_dropdowns() throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			Thread.sleep(500);
			homePage.rostertab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
			Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			Thread.sleep(500);
			String recentlySelectedSchool, renctlySelectedClass, recentlySelectedStudent;
			if (homePage.schooldropdownbtn.getText().contains("...")) {
				new Actions(Driver.webdriver).moveToElement(homePage.schooldropdownbtn).build().perform();
				recentlySelectedSchool = homePage.schooldropdownbtntooltip.getText();
				Thread.sleep(500);
			} else {
				recentlySelectedSchool = homePage.schooldropdownbtn.getText();
			}
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();

			Assert.assertTrue(recentlySelectedSchool.equals(selectedSchoolName));
			if (homePage.classdropdownbtn.getText().contains("...")) {
				new Actions(Driver.webdriver).moveToElement(homePage.classdropdownbtn).build().perform();
				renctlySelectedClass = homePage.classdropdownbtntooltip.getText();
				Thread.sleep(500);
			} else {
				renctlySelectedClass = homePage.classdropdownbtn.getText();
			}
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();

			Assert.assertTrue(renctlySelectedClass.equals(selectedclassText));

			recentlySelectedStudent = homePage.studentdropdownbtn.getText();
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();
			Assert.assertTrue(recentlySelectedStudent.equals(selectedStudentText));

			Thread.sleep(500);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 10_3 Completed");
	}

	/**
	 * This method is used to verify All option should be in top in student dropdown
	 * and once selected it show All as selected text in dropdown
	 * 
	 * @throws Throwable
	 */
	@Then("^select school as \"([^\"]*)\" and 'All' option should be display at first position in student list and can not be scrollable$")
	public void select_school_as_and_All_option_should_be_display_at_first_position_in_student_list_and_can_not_be_scrollable(
			String sc) throws Throwable {
		try {
			UtilityMethods.scrollPageDown(Driver.webdriver, 2);
			RosterTabUtilityMethods.select_School_In_School_DropDown(sc);
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.studentdropdownallcheckbox.getText().equals("All"));
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario 13 Completed");
	}

	/**
	 * This method is used to select /deselect multiple student from student
	 * dropdown in roster tab and also check once selection done and revisit the
	 * student dropdown, then the selected options should be in top
	 * 
	 * @throws Throwable
	 */
	@Then("^select school as \"([^\"]*)\" and Veriy the previously selected students should be on top in student dropdown$")
	public void select_school_as_and_Veriy_the_previously_selected_students_should_be_on_top_in_student_dropdown(
			String sc) throws Throwable {
		try {
			String selectedClass, selectedStudent;
			// selecting school from dropdown
			RosterTabUtilityMethods.select_School_In_School_DropDown(sc);
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			Thread.sleep(500);
			// selecting class from dropdown
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Class");
			selectedClass = homePage.classlist.get(0).getText();
			homePage.classlist.get(0).click();
			log.info("Selected Class is:" + selectedClass);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);

			// selecting student from dropdown
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			int customSize = 0;
			// This is to unselect all student from dropdown,as default is all selected
			RosterTabUtilityMethods.uncheck_check_All("Student");

			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);

			for (int i = 1; i < homePage.studentlistondropdown.size(); i = i + 2) {
				if (homePage.studentlistondropdown.get(i).getText().equals("")) {
					UtilityMethods.scroll_Div(homePage.studentlistondropdown.get(i), 20);
				}
				homePage.studentlistondropdown.get(i).click();
				Thread.sleep(500);
				customSize++;
			}

			selectedStudent = homePage.studentdropdownbtn.getText();
			log.info("Selected Student is:" + selectedStudent);

			homePage.rosterapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(3000);

			IWait.explicit_wait(Driver.webdriver, homePage.rostertab);
			homePage.rostertab.click();
			IWait.explicit_wait(Driver.webdriver, homePage.studentTitleOnSliderMenu);
			Verify.verify(homePage.studentTitleOnSliderMenu.isDisplayed());
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 8);
			// verifying after applying result,selected student names are on top
			UtilityMethods.scroll_Div_UP(homePage.studentlistondropdownwithinput.get(0), -20);

			for (int i = 0; i < customSize; i++) {
				if (homePage.studentlistondropdown.get(i).getText().equals("")) {
					UtilityMethods.scroll_Div(homePage.studentlistondropdown.get(i), 20);
				}
				Assert.assertTrue(homePage.studentlistondropdownwithinput.get(i).isSelected());
				Thread.sleep(500);
			}
			Thread.sleep(500);
			// now,delselecting the selected student and verify with content select student
			// on dropdown
			for (int i = 0; i < customSize; i++) {
				if (homePage.studentlistondropdown.get(i).getText().equals("")) {
					UtilityMethods.scroll_Div(homePage.studentlistondropdown.get(i), 20);
				}
				Thread.sleep(200);
				homePage.studentlistondropdown.get(i).click();
				Thread.sleep(500);
			}

			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-630,659,660 Completed");
	}
}
