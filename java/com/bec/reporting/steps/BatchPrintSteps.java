package com.bec.reporting.steps;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.utils.API_Connection;
import com.bec.reporting.utils.CBTConfiguration;
import com.bec.reporting.utils.Driver;
import com.bec.reporting.utils.IWait;
import com.bec.reporting.utils.UtilityMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BatchPrintSteps {

	/**
	 * This is used to initialize webelement of the webpages
	 */
	HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	static JavascriptExecutor js = (JavascriptExecutor) Driver.webdriver;

	@When("^click the Class menu and verify student list$")
	public void click_the_Class_menu_and_verify_student_list() throws Throwable {
		try {
			Assert.assertTrue(homePage.activeclassmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.classmenu);
			Thread.sleep(1000);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
	}

	@When("^click the school menu and verify Class list$")
	public void click_the_school_menu_and_verify_Class_list() throws Throwable {
		try {
			Assert.assertTrue(homePage.activeschoolmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.schoolmenu);
			Thread.sleep(1000);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
	}

	@When("^User Click on Summary tab within the Student Context$")
	public void user_Click_on_Summary_tab_within_the_Student_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			if (!API_Connection.getUserRole().equalsIgnoreCase("TEACHER")) {
				UtilityMethods.jump_to_class_context_from_school_or_district_context();
			}
			Assert.assertTrue(homePage.activestudentmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.active_summary_tab.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.summarytab);
		}
		UtilityMethods.wait_For_Summary_Tab_Section_Load();
	}

	@Then("^verify Standards Summary and Single Test Analysis Print Modal for Student Level$")
	public void verify_Standards_Summary_and_Single_Test_Analysis_Print_Modal_for_Student_Level() throws Throwable {
		try {
			String studentName = UtilityMethods.getStudentNameonUI();
			new Actions(Driver.webdriver).moveToElement(homePage.print_pdf_batch_button).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.print_Report_Overlay_on_print_popup.isDisplayed());
			Assert.assertTrue(homePage.batch_print_title.isDisplayed());
			Assert.assertTrue(homePage.radio_buttons_under_batch_print.get(0).getAttribute("class")
					.contains("selectedBatchOption"));
			if (is_STA_Clicekd) {
				Assert.assertTrue(homePage.show_title_on_model.isDisplayed());
				Assert.assertTrue(homePage.selection_texts_on_model.get(0).getText().contains("Standards Definition"));
				Assert.assertTrue(homePage.selection_texts_on_model.get(1).getText()
						.contains(studentName + " (Current Selection)"));
				Assert.assertTrue(homePage.selection_texts_on_model.get(2).getText()
						.equals("Individual Reports for All Students in the Class"));
				is_STA_Clicekd = false;
			} else {

				Assert.assertTrue(homePage.selection_texts_on_model.get(0).getText()
						.contains(studentName + " (Current Selection)"));
				Assert.assertTrue(homePage.selection_texts_on_model.get(1).getText()
						.equals("Individual Reports for All Students in the Class"));
			}
			Assert.assertTrue(homePage.print_button_on_popup.isDisplayed());
			Assert.assertTrue(homePage.cancel_button_on_popup.isDisplayed());
			// verify cancel clicking button
			homePage.cancel_button_on_popup.click();
			Thread.sleep(1000);
			IWait.check_Absence_of_Element(homePage.print_Report_Overlay_on_print_popup);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-1912,1917,1919,1920,1927,1928,1929 completed");
	}

	static boolean is_STA_Clicekd = false;

	@When("^User Click on Single Test Analysis tab within the Student Context$")
	public void user_Click_on_Single_Test_Analysis_tab_within_the_Student_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activestudentmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.studentmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.active_sta_tab.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.statab);
		}
		UtilityMethods.wait_For_STA_Section_Load();
		is_STA_Clicekd = true;
	}

	@When("^User Click on Summary tab within the Class Context$")
	public void user_Click_on_Summary_tab_within_the_Class_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			if (!API_Connection.getUserRole().equalsIgnoreCase("TEACHER")) {
				UtilityMethods.jump_to_class_context_from_school_or_district_context();
			}
			Assert.assertTrue(homePage.activeclassmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.classmenu);
			Thread.sleep(3000);
		}
		UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		try {
			Assert.assertTrue(homePage.active_summary_tab.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.summarytab);
		}
		UtilityMethods.wait_For_Summary_Tab_Section_Load();
	}

	@Then("^verify Standards Summary and Single Test Analysis Print Modal for Class Level$")
	public void verify_Standards_Summary_and_Single_Test_Analysis_Print_Modal_for_Class_Level() throws Throwable {
		try {
			String className = UtilityMethods.getClassNameonUI();
			new Actions(Driver.webdriver).moveToElement(homePage.print_pdf_batch_button).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(homePage.print_Report_Overlay_on_print_popup.isDisplayed());
			Assert.assertTrue(homePage.batch_print_title.isDisplayed());
			Assert.assertTrue(homePage.radio_buttons_under_batch_print.get(0).getAttribute("class")
					.contains("selectedBatchOption"));
			if (is_STA_Clicekd) {
				Assert.assertTrue(homePage.show_title_on_model.isDisplayed());
				Assert.assertTrue(homePage.selection_texts_on_model.get(0).getText().contains("Standards Definition"));
				Assert.assertTrue(homePage.selection_texts_on_model.get(1).getText()
						.contains(className + " (Current Selection)"));
				Assert.assertTrue(homePage.selection_texts_on_model.get(2).getText()
						.equals("Individual Reports for All Students in the Class"));
				is_STA_Clicekd = false;
			} else {
				Assert.assertTrue(homePage.selection_texts_on_model.get(0).getText()
						.contains(className + " (Current Selection)"));
				Assert.assertTrue(homePage.selection_texts_on_model.get(1).getText()
						.equals("Individual Reports for All Students in the Class"));
			}
			Assert.assertTrue(homePage.print_button_on_popup.isDisplayed());
			Assert.assertTrue(homePage.cancel_button_on_popup.isDisplayed());
			// verify cancel clicking button
			homePage.cancel_button_on_popup.click();
			Thread.sleep(1000);
			IWait.check_Absence_of_Element(homePage.print_Report_Overlay_on_print_popup);
			CBTConfiguration.score = "pass";
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		log.info("Scenario BE-1913,1914,1915,1916,1924,1925,1926 completed");
	}

	@When("^User Click on Single Test Analysis tab within the Class Context$")
	public void user_Click_on_Single_Test_Analysis_tab_within_the_Class_Context() throws Throwable {
		try {
			UtilityMethods.wait_For_Context_Header_Section();
			Assert.assertTrue(homePage.activeclassmenu.getAttribute("class").contains("active"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.classmenu);
			Thread.sleep(3000);
		}
		try {
			Assert.assertTrue(homePage.active_sta_tab.getAttribute("class").equals("active_tab"));
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", homePage.statab);
		}
		UtilityMethods.wait_For_STA_Section_Load();
		is_STA_Clicekd = true;
	}

	@When("^click and select view from dropdown$")
	public void click_and_select_view_from_dropdown() throws Throwable {
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.viewDropDown_on_summary).click().build().perform();
			Thread.sleep(1000);
			int x = UtilityMethods.generateRandomNumberBySkippingIndex(homePage.viewDropDownList_on_summary.size(), 0);
			new Actions(Driver.webdriver).moveToElement(homePage.viewDropDownList_on_summary.get(x)).click().build()
					.perform();
			Thread.sleep(1000);

		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}
}