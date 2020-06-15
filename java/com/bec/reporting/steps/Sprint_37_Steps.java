package com.bec.reporting.steps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.RosterTabUtilityMethods;
import com.bec.reporting.utils.UtilityMethods;
import com.google.common.collect.Ordering;

import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sprint_37_Steps {

	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	static JavascriptExecutor js = (JavascriptExecutor) Driver.webdriver;

	@Then("^Verify School dropdown is displayed in Roster tab$")
	public void verify_School_dropdown_is_displayed_in_Roster_tab() throws Throwable {
		try {
			String s = "All";
			int schoolcount = 0;
			List<String> schoolList = new ArrayList<String>();
			homePage.rostertab.click();
			Thread.sleep(500);
			Assert.assertTrue(homePage.schooldropdownbtn.isDisplayed());
			log.info("School dropdown is displayed");
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			String schoolname = homePage.schooldropdownbtn.getText();
			Assert.assertNotEquals(s, schoolname);
			schoolcount = homePage.schoollist.size();
			String scName;
			for (int i = 0; i < schoolcount; i++) {
				scName = homePage.schoollist.get(i).getText();
				if (scName.equals("")) {
					UtilityMethods.scroll_Div(homePage.schoollist.get(i), 5);
				}
				schoolList.add(homePage.schoollist.get(i).getText());
			}
			Assert.assertTrue(Ordering.natural().isOrdered(schoolList));
			schoolList.clear();
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			try {
				Assert.assertTrue(homePage.gradedropdownbtn.isDisplayed());
				log.info("Grade dropdown is displayed");
			} catch (Exception e) {
				log.info("Grade dropdown is not displayed");
			}
			IWait.check_Absence_of_Element(homePage.teachersdropdownbtn);
			log.info("Teacher dropdown is not displayed");
			Assert.assertTrue(homePage.classdropdownbtn.isDisplayed());
			log.info("Class dropdown is displayed");
			String classname = homePage.classdropdownbtn.getText();
			Assert.assertNotEquals(s, classname);
			Assert.assertTrue(homePage.studentdropdownbtn.isDisplayed());
			log.info("Student dropdown is displayed");
			String studentname = homePage.studentdropdownbtn.getText();
			Assert.assertEquals(s, studentname);
			log.info("All is selected in Student dropdown");
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Sprint 37_TC-2370 completed");
	}

	@Then("^Verify School dropdown is not displayed in Roster tab$")
	public void verify_School_dropdown_is_not_displayed_in_Roster_tab() throws Throwable {
		try {
			String s = "All";
			homePage.rostertab.click();
			Thread.sleep(500);
			IWait.check_Absence_of_Element(homePage.schooldropdownbtn);
			log.info("School dropdown is not displayed");

			try {
				Assert.assertTrue(homePage.gradedropdownbtn.isDisplayed());
				log.info("Grade dropdown is displayed");
			} catch (Exception e) {
				log.info("Grade dropdown is not displayed");
			}
			IWait.check_Absence_of_Element(homePage.teachersdropdownbtn);
			log.info("Teacher dropdown is not displayed");
			Assert.assertTrue(homePage.classdropdownbtn.isDisplayed());
			log.info("Class dropdown is displayed");
			String classname = homePage.classdropdownbtn.getText();
			Assert.assertNotEquals(s, classname);
			Assert.assertTrue(homePage.studentdropdownbtn.isDisplayed());
			log.info("Student dropdown is displayed");
			String studentname = homePage.studentdropdownbtn.getText();
			Assert.assertEquals(s, studentname);
			log.info("All is selected in Student dropdown");
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Sprint 37_TC-2371 completed");
	}

	@Then("^Verify Tool tip is displayed when user mouse hover over Class name in Student Data dropdown$")
	public void verify_Tool_tip_is_displayed_when_user_mouse_hover_over_Class_name_in_Student_Data_dropdown()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Judith Brooks");
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Student_In_Student_DropDown("Carla Gary");
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			homePage.rostertab.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 10);
			Thread.sleep(500);
			homePage.studentdatadropdownbtn.click();
			Thread.sleep(500);
			for (int i = 0; i < homePage.studentdatadropdownlist.size(); i++) {
				new Actions(Driver.webdriver).moveToElement(homePage.studentdatadropdownlist.get(i)).build().perform();
				Thread.sleep(500);
				log.info("Class Name:" + homePage.studentdatadropdownlist.get(i).getText());
				Assert.assertTrue(homePage.tt_on_studentdatadropdownlist.get(i).isDisplayed());
				log.info("ToolTip on class name:" + homePage.tt_on_studentdatadropdownlist.get(i).getText());
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Sprint 37_TC-2366 completed");
	}

	@Then("^Verify Tool tip is not displayed when user mouse hover over Class name in Student data dropdown$")
	public void verify_Tool_tip_is_not_displayed_when_user_mouse_hover_over_Class_name_in_Student_data_dropdown()
			throws Throwable {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.select_School_In_School_DropDown("107TH STREET ELEMENTARY");
			RosterTabUtilityMethods.select_Grade_In_Grades_DropDown("Grade 4");
			RosterTabUtilityMethods.select_Teacher_In_Teacher_DropDown("Judith Brooks");
			UtilityMethods.scrollPageDown(Driver.webdriver, 7);
			Thread.sleep(500);
			RosterTabUtilityMethods.select_Student_In_Student_DropDown("Robert Bench");
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			Thread.sleep(500);
			homePage.rostertab.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 10);
			Thread.sleep(500);
			homePage.studentdatadropdownbtn.click();
			Thread.sleep(500);
			log.info("Verifying tooltip is not present for the student data class names");
			for (int i = 0; i < homePage.studentdatadropdownlist.size(); i++) {
				new Actions(Driver.webdriver).moveToElement(homePage.studentdatadropdownlist.get(i)).build().perform();
				Thread.sleep(500);
				try {
					Assert.assertTrue(homePage.tt_on_studentdatadropdownlist.get(i).isDisplayed());
					UtilityMethods.processException(new Exception());
				} catch (Exception e) {
					log.info("Tool tip not present for class:" + homePage.studentdatadropdownlist.get(i).getText());
				}
			}
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Sprint 37_TC-2367 completed");
	}

	@Then("^Verify the Default Print Modal of SPOT in Student context$")
	public void verify_the_Default_Print_Modal_of_SPOT_in_Student_context() throws Throwable {
		try {
			homePage.schoolmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.classmenu.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
			homePage.studentmenu.click();
			UtilityMethods.wait_For_Performance_Over_Time_Line_Chart_Section_Load();
			String studentName = UtilityMethods.getStudentNameonUI();
			String strandName = homePage.strandnameslist.get(0).getText();
			List<String> view_Names_on_dd = new LinkedList<String>();
			view_Names_on_dd = UtilityMethods.getViewNames_From_View_DropDown_on_SP();

			homePage.printIcon.click();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.print_Report_Overlay_on_print_popup.isDisplayed());
			Assert.assertTrue(homePage.view_title_on_model.isDisplayed());
			Assert.assertTrue(homePage.batch_print_title.isDisplayed());
			Assert.assertTrue(homePage.show_title_on_model.isDisplayed());

			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(0).getText()
					.contains(strandName + " (Current Selection)"));
			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(1).getText().equals("Select Standards"));
			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(2).getText()
					.equalsIgnoreCase(view_Names_on_dd.get(0)));
			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(3).getText()
					.equalsIgnoreCase(view_Names_on_dd.get(1)));
			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(4).getText()
					.equalsIgnoreCase(view_Names_on_dd.get(2)));

			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(5).getText().equals("Overall Average"));
			Assert.assertTrue(
					homePage.texts_on_model_on_spot_print_popup.get(6).getText().equals("Standards Definition"));

			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(7).getText()
					.contains(studentName + " (Current Selection)"));

			Assert.assertTrue(homePage.texts_on_model_on_spot_print_popup.get(8).getText()
					.equals("Individual Student Reports in the Class"));

			Assert.assertTrue(homePage.print_button_on_popup.isDisplayed());
			Assert.assertTrue(homePage.cancel_button_on_popup.isDisplayed());
			homePage.cancel_button_on_popup.click();
			Thread.sleep(500);
			IWait.check_Absence_of_Element(homePage.print_Report_Overlay_on_print_popup);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Sprint 37_TC-2368,2369 completed");
	}
}
