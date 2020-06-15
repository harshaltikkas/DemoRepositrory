package com.bec.reporting.utils;

import java.util.LinkedList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bec.reporting.pageobjects.HomePage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RosterTabUtilityMethods {
	static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);
	
	/* This method is used to deselct all checkbox in universal selector dropdown */
	public static void uncheck_check_All(String roster_field) {
		try {
			Driver.webdriver.findElement(By.xpath("//div[@class='menu-title' and contains(text(),'" + roster_field
					+ "')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul/li")).click();
			Thread.sleep(500);
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/*This method is used to select specified school in school dropdown*/
	public static String select_School_In_School_DropDown(String school) {		
		try {
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("School");
			homePage.searchbaronschooldropdown.sendKeys(school);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='"+school+"']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonschooldropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);			
			log.info("Selected School:" +school);
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();
			RosterTabUtilityMethods.wait_For_Refresh_Icon(homePage.schoolRefreshIcon, "School");
		} catch (Exception e) {
			log.error("unable to select school from dropdown");
			UtilityMethods.processException(e);
		}
		return school;
	}
	
	/*This method is used to select specified grade in Grades dropdown*/
	public static String select_Grade_In_Grades_DropDown(String grade) {
		try {
			homePage.gradedropdownbtn.click();
			Thread.sleep(500);		
			Driver.webdriver.findElement(By.xpath("//li[.='"+grade+"']")).click();
			Thread.sleep(500);		
			log.info("Selected Grade:" + grade);			
		} catch (Exception e) {
			log.error("unable to select grade from dropdown");
			UtilityMethods.processException(e);
		}
		return grade;
	}	
	
	/*This method is used to select specified Teacher in Teacher dropdown*/
	public static String select_Teacher_In_Teacher_DropDown(String teacher) {
		try {
			homePage.teachersdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Teacher");
			homePage.searchbaronteacherdropdown.sendKeys(teacher);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='"+teacher+"']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonteacherdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.teachersdropdownbtn.click();
			Thread.sleep(500);
			log.info("Selected Teacher:" + teacher);			
		} catch (Exception e) {
			log.error("unable to select teacher from dropdown");
			UtilityMethods.processException(e);
		}
		return teacher;
	}
	
	/*This method is used to select specified class in Class dropdown*/
	public static String select_Class_In_Class_DropDown(String cls) {
		try {			
			homePage.classdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Class");
			homePage.searchbaronclassdropdown.sendKeys(cls);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='"+cls+"']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonclassdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.classdropdownbtn.click();
			Thread.sleep(500);			
			log.info("Selected Class:" + cls);			
		} catch (Exception e) {
			log.error("unable to select class from dropdown");
			UtilityMethods.processException(e);
		}
		return cls;
	}	
	
	/*This method is used to select specified student in Student dropdown*/
	public static String select_Student_In_Student_DropDown(String student) {
		try {
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			RosterTabUtilityMethods.uncheck_check_All("Student");
			homePage.searchbaronstudentdropdown.sendKeys(student);
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='"+student+"']")).click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.searchcancelonstudentdropdown).click().build()
					.perform();
			Thread.sleep(500);
			homePage.studentdropdownbtn.click();
			Thread.sleep(500);
			log.info("Selected Class:" + student);			
		} catch (Exception e) {
			log.error("unable to select Student from dropdown");
			UtilityMethods.processException(e);
		}
		return student;
	}	

	/* This method is used to get all the test names of test tab */
	public static LinkedList<String> getAllTestNamesOfTestTab() {
		LinkedList<String> testNames = new LinkedList<String>();
		try {
			// checking for paginator
			if (PaginationUtility_for_Universal_Tab.checkPaginator_on_test_tab()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = 0; i < homePage.testpaginationcirclelist.size(); i++) {
					PaginationUtility_for_Universal_Tab.click_On_Indexed_Circle_Of_Paginator(i);
					Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
					for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
						testNames.add(homePage.testnameslist_on_test_tab.get(j).getText());
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
							testNames.add(homePage.testnameslist_on_test_tab.get(j).getText());
						}
					}
				} while (PaginationUtility_for_Universal_Tab.check_Enabled_Right_Arrow_On_Paginator_On_Test_Tab());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
				for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
					testNames.add(homePage.testnameslist_on_test_tab.get(j).getText());
				}
			}
		} catch (Exception e) {
			log.error("Error in retreive Test Names on Test Tab");
			UtilityMethods.processException(e);
		}
		return testNames;
	}
	
	/* This method is used to get all the test names of test score over time */
	public static LinkedList<String> getAllTestNamesOf_TestScoreOverTime() {
		LinkedList<String> testNames = new LinkedList<String>();
		try {
			// checking for paginator
			if (PaginationUtility_for_Pages.checkPaginator_on_tsot()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = homePage.circle_list_on_paginator_on_tsot.size() - 1; i >= 0; i--) {
					PaginationUtility_for_Pages.clicking_on_indexed_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot,i);
					Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
					for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
						testNames.add(getTestNamesFromToolTip_On_TSOT(j));
					}
				}
				// check for left arrow enabled and click on it and click on first circle and
				// validate
				do {
					if (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot()) {
						PaginationUtility_for_Pages.clicking_on_enabled_left_Arrow_of_paginator_on_tsot();
						PaginationUtility_for_Pages.clicking_on_first_circle_of_paginator(homePage.circle_list_on_paginator_on_tsot);
						Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
						for (int j = homePage.testNamesonPerPage_onlinechart.size() - 1; j >= 0; j--) {
							testNames.add(getTestNamesFromToolTip_On_TSOT(j));
						}
					} 
				} while (PaginationUtility_for_Pages.check_Enabled_Left_Arrow_on_Paginator_on_tsot());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testNamesonPerPage_onlinechart.size() <= 10);
				for (int i = homePage.testNamesonPerPage_onlinechart.size() - 1; i >= 0; i--) {
					testNames.add(getTestNamesFromToolTip_On_TSOT(i));
				}
			}
		} catch (Exception e) {
			log.error("Error in retreive Test Names on Test Tab");
			UtilityMethods.processException(e);
		}
		return testNames;
	}
	
	public static String getTestNamesFromToolTip_On_TSOT(int index) {
		String testName="";
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.testNamesonPerPage_onlinechart.get(index)).build()
					.perform();
			testName = homePage.testNametooltip_onlinechart.getText();
			new Actions(Driver.webdriver).moveToElement(homePage.testScoresPercentage).build().perform();
			Thread.sleep(500);
			Thread.sleep(500);			
		} catch (InterruptedException e) {
			UtilityMethods.processException(e);
		}
		return testName;
	}
	
	/**
	 * This method is used to wait till refresh icon for the roster tab dropdown
	 **/
	public static void wait_For_Refresh_Icon(WebElement el, String str) {
		int count = 1;
		try {
			do {
				log.info("Thread sleep called for " + str + " Loading :" + count + " Times");
				Thread.sleep(2000);
				count++;
				if (count > 70) {
					log.error("Issue in " + str + " Data Loading");
					UtilityMethods.processException(new Exception());
				}
			} while (el.isDisplayed() && count <= 70);
		} catch (Exception e) {
			log.info(str + " Refresh Icon Display off");
		}
	}
}
