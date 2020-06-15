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
 * JAN 06 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.reporting.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.bec.reporting.pageobjects.HomePage;
import com.bec.reporting.steps.Standard_Overview_Table_Steps;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilityMethods {
	static int ctr = 0, ch_ctr = 0;
	static HomePage homePage = PageFactory.initElements(Driver.webdriver, HomePage.class);

	/**
	 * This method is used to scroll to element using mousehover
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollToElement(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(element).build();
		mouseOver.perform();
	}

	/**
	 * This method used to page up to top
	 * 
	 * @param driver
	 */
	public static void scrollPageUp(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.PAGE_UP).build().perform();
	}

	/**
	 * This methd is used to scroll down till bottom
	 * 
	 * @param driver
	 */
	public static void scrollPageDown(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	/**
	 * This method is used to scroll page up till the count value
	 * 
	 * @param driver
	 * @param count
	 */
	public static void scrollPageUp(WebDriver driver, int count) {
		Actions builder = new Actions(driver);
		for (int i = 0; i < count; i++) {
			builder.sendKeys(Keys.ARROW_UP).build().perform();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * This method used to arrow down till the no. of count
	 * 
	 * @param driver
	 */
	public static void scrollPageDown(WebDriver driver, int count) {
		Actions builder = new Actions(driver);
		for (int i = 0; i < count; i++) {
			builder.sendKeys(Keys.ARROW_DOWN).build().perform();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * This method is called when any exception occur while executing scenrios.
	 * 
	 * @param e
	 */
	public static void processException(Exception e) {
		CBTConfiguration.score = "fail";
		Standard_Overview_Table_Steps.resetStatus();
		log.error(e.getMessage());
		Assert.fail();
	}

	/**
	 * This method is used to compare context header text with removing elipsis and
	 * universal seector options selection
	 * 
	 * @param text
	 * @return
	 */
	public static String elipsisRemoval(String text) {
		if (text.contains("...")) {
			text = text.substring(0, text.indexOf("."));
		}
		return text;
	}

	/**
	 * This method is used to generate random string based on the length of string u
	 * want.
	 * 
	 * @param strLength
	 * @return
	 */
	public static String generateRandomString(int strLength) {
		String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strLength; i++) {
			int randIndex = random.nextInt(aToZ.length());
			stringBuilder.append(aToZ.charAt(randIndex));
		}
		return stringBuilder.toString();
	}

	/**
	 * This method is used to generate randm number of the desire length
	 * 
	 * @param numberLength
	 * @return
	 */
	public static long generateRandomNumber(int numberLength) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		// first not 0 digit
		sb.append(random.nextInt(9) + 1);
		for (int i = 0; i < numberLength - 1; i++) {
			sb.append(random.nextInt(10));
		}
		return Long.valueOf(sb.toString()).longValue();
	}

	/**
	 * This method is used to compare the test score value with the range and return
	 * true if color match with the circle value
	 * 
	 * @param element
	 * @param scoreValue
	 * @return
	 */
	public static boolean verifyColorAndScoreOnLineChart(WebElement element, int scoreValue) {
		try {
			if (scoreValue < 40) {
				Assert.assertTrue(element.getAttribute("fill").equalsIgnoreCase("#FF5B5B"));
			} else if (scoreValue >= 40 && scoreValue <= 59) {
				Assert.assertTrue(element.getAttribute("fill").equalsIgnoreCase("#FF8E2D"));
			} else if (scoreValue >= 60 && scoreValue <= 79) {
				Assert.assertTrue(element.getAttribute("fill").equalsIgnoreCase("#FFC52D"));
			} else {
				Assert.assertTrue(element.getAttribute("fill").equalsIgnoreCase("#32AC41"));
			}
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
		return true;
	}

	/**
	 * This method is used to verify the class attribute of the webelement with the
	 * score belong to it on student list.
	 * 
	 * @param element
	 * @param scoreValue
	 * @return
	 */
	public static boolean verifyColorAndScoreOnStudentList(WebElement element, int scoreValue) {
		try {
			if (scoreValue < 40) {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("student-list-grade red"));
			} else if (scoreValue >= 40 && scoreValue <= 59) {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("student-list-grade orange"));
			} else if (scoreValue >= 60 && scoreValue <= 79) {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("student-list-grade yellow"));
			} else {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("student-list-grade green"));
			}
			return true;
		} catch (Exception e) {
			processException(e);
			return false;
		}
	}

	/**
	 * This method is used to verify the date format is MM/dd/YYYY using reguler
	 * expression
	 * 
	 * @param submissionDate
	 * @return
	 */
	public static void checkDateFormat(String submissionDate) {
		Matcher matcher = null;
		try {
			String regex = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
			Pattern pattern = Pattern.compile(regex);
			matcher = pattern.matcher(submissionDate);
			Assert.assertTrue(matcher.matches());
		} catch (Exception e) {
			log.error("Invalid Date format");
			UtilityMethods.processException(e);
		}
	}

	/*
	 * This method is used to validate the date format in date tab-custom date as mm
	 * can be optional zero if not in 2 digits.
	 */
	public static void checkDateFormatOnDateTab(String submissionDate) {
		Matcher matcher = null;
		try {
			String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
			Pattern pattern = Pattern.compile(regex);
			matcher = pattern.matcher(submissionDate);
			Assert.assertTrue(matcher.matches());
		} catch (Exception e) {
			log.error("Invalid Date format");
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to Veriy the Colour of the Standards records belong to
	 * that average percentage
	 * 
	 * @param element
	 * @param avgPer
	 * @return
	 */
	public static boolean verifyColorAndStandardAvgPercentage(WebElement element, int avgPer) {
		try {
			if (avgPer < 40) {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("redBg"));
			} else if (avgPer >= 40 && avgPer <= 59) {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("orangeBg"));
			} else if (avgPer >= 60 && avgPer <= 79) {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("yellowBg"));
			} else {
				Assert.assertTrue(element.getAttribute("class").equalsIgnoreCase("greenBg"));
			}
			return true;
		} catch (Exception e) {
			processException(e);
			return false;
		}
	}

	/**
	 * This method is to verify the two List are reverse to each other.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isReverse(List<String> a, List<String> b) {
		if (a.size() != b.size()) // If a and b are not of the same length how can they be reverse?
			return false;
		for (int i = 0; i < a.size(); i++)
			if (!(a.get(i).equals(b.get(a.size() - i - 1)))) {
				return false;
			}
		return true;
	}

	/**
	 * This method is used to skip the specific index position while generating
	 * random number
	 * 
	 * @param numberLength
	 * @return
	 */
	public static int generateRandomNumberBySkippingIndex(int numberLength, int skipIndex) {
		int number = (int) (Math.random() * numberLength);
		if (number == skipIndex) {
			number = generateRandomNumberBySkippingIndex(numberLength, skipIndex);
		}
		return number;
	}

	/**
	 * This method is used to scroll down the div(vertical scroll bar) in
	 * Student,class and student Dropdown
	 * 
	 * @param webelement
	 * @param scrollPoints
	 * @return
	 */
	public static boolean scroll_Div(WebElement webelement, int scrollPoints) {
		try {
			Actions dragger = new Actions(Driver.webdriver);
			if (ctr >= 1) {
				scrollPageDown(Driver.webdriver, 2);
			}
			ctr++;
			dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, scrollPoints).build().perform();
			Thread.sleep(500);
			if (webelement.getText().equals("")) {
				scroll_Div(webelement, scrollPoints);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		ctr = 0;
		return true;
	}

	/**
	 * This method is used to scroll up the div(vertical scroll bar) in
	 * Student,class and student Dropdown
	 * 
	 * @param webelement
	 * @param scrollPoints
	 * @return
	 */
	public static boolean scroll_Div_UP(WebElement webelement, int scrollPoints) {
		try {
			Actions dragger = new Actions(Driver.webdriver);
			dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, scrollPoints).build().perform();
			Thread.sleep(500);
			if (webelement.getAttribute("value").equals("")) {
				scroll_Div_UP(webelement, scrollPoints);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method is used to get student id based on student name on UI
	 * 
	 * @return
	 */
	public static Integer getStudentId() {
		Integer stuId = 0;
		try {
			String studentTextonCH;
			new Actions(Driver.webdriver).moveToElement(homePage.studentnameoncontextheader).build().perform();
			if (homePage.studentnameoncontextheader.getText().contains("...")) {
				studentTextonCH = homePage.studentnameoncontextheadertooltiptext.getText();
			} else {
				studentTextonCH = homePage.studentnameoncontextheader.getText();
			}
			stuId = Integer.parseInt(
					studentTextonCH.substring(studentTextonCH.indexOf("(") + 1, studentTextonCH.indexOf(" )")));
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).build().perform();
		} catch (Exception e) {
			processException(e);
		}
		return stuId;
	}

	/**
	 * This method is used to return schoolID and classID based on UI school name
	 * and class name
	 * 
	 * @return
	 */
	public static Map<Integer, Integer> getSchoolIdAndClassId() {
		Map<Integer, Integer> Ids = new HashMap<Integer, Integer>();
		try {
			String schoolName, className;

			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build().perform();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.classnameoncontextheader).build().perform();
			if (homePage.classnameoncontextheader.getText().contains("...")) {
				className = homePage.tooltipofclassnameoncontextheader.getText();
			} else {
				className = homePage.classnameoncontextheader.getText();
			}
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build().perform();
			Thread.sleep(500);
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.districtnameoncontextheader).build().perform();
				Thread.sleep(1000);
				if (homePage.districtnameoncontextheader.getText().contains("...")) {
					schoolName = homePage.tooltipofschoolnameontripledot.getText();
				} else {
					schoolName = homePage.districtnameoncontextheader.getText();
				}
			} catch (Exception e) {
				new Actions(Driver.webdriver).moveToElement(homePage.tripledotsoncontextheader).click().build()
						.perform();
				Thread.sleep(1000);
				new Actions(Driver.webdriver).moveToElement(homePage.schoolnameontripledot).build().perform();
				Thread.sleep(1000);
				if (homePage.schoolnameontripledot.getText().contains("...")) {
					schoolName = homePage.tooltipofschoolnameontripledot.getText();
				} else {
					schoolName = homePage.schoolnameontripledot.getText();
				}
			}

			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build().perform();
			Thread.sleep(500);
			Integer schoolId = API_Connection.getSchoolIDBySchoolName(schoolName);
			Integer classId = API_Connection.getClassIDBySchoolIdAndClassName(schoolId, className);
			Ids.put(schoolId, classId);
		} catch (Exception e) {
			processException(e);
		}
		return Ids;
	}

	/**
	 * This method is used to retrieve Student Name on UI
	 * 
	 * @return
	 */
	public static String getStudentNameonUI() {
		String studentTextonCH = "";
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.studentnameoncontextheader).build().perform();
			if (homePage.studentnameoncontextheader.getText().contains("...")) {
				studentTextonCH = homePage.studentnameoncontextheadertooltiptext.getText();
			} else {
				studentTextonCH = homePage.studentnameoncontextheader.getText();
			}
			if (studentTextonCH.contains("(")) {
				studentTextonCH = studentTextonCH.substring(0, studentTextonCH.indexOf("(") - 1);
			}
			new Actions(Driver.webdriver).moveByOffset(100, 100).build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return studentTextonCH;
	}

	/**
	 * This method is used to retrieve School Name on UI
	 * 
	 * @return
	 */
	public static String getSchoolNameonUI() {
		String schoolName = "";
		try {
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.schoolnameoncontextheader).build().perform();
				Thread.sleep(500);
				if (homePage.schoolnameoncontextheader.getText().contains("...")) {
					schoolName = homePage.tooltipofschoolnameoncontextheader.getText();
				} else {
					schoolName = homePage.schoolnameoncontextheader.getText();
				}
			} catch (Exception e) {
				new Actions(Driver.webdriver).moveToElement(homePage.tripledotsoncontextheader).click().build()
						.perform();
				Thread.sleep(1000);
				new Actions(Driver.webdriver).moveToElement(homePage.schoolnameontripledot).build().perform();
				Thread.sleep(1000);
				if (homePage.schoolnameontripledot.getText().contains("...")) {
					schoolName = homePage.tooltipofschoolnameontripledot.getText();
				} else {
					schoolName = homePage.schoolnameontripledot.getText();
				}
			}
			new Actions(Driver.webdriver).moveByOffset(100, 100).click().build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return schoolName;
	}

	/**
	 * This method is used to retrieve District Name on UI
	 * 
	 * @return
	 */
	public static String getDistrictNameonUI() {
		String districtName = "";
		try {
			try {
				new Actions(Driver.webdriver).moveToElement(homePage.districtnameoncontextheader).build().perform();
				Thread.sleep(500);
				if (homePage.districtnameoncontextheader.getText().contains("...")) {
					districtName = homePage.tooltipofdistrictnameoncontextheader.getText();
				} else {
					districtName = homePage.districtnameoncontextheader.getText();
				}
			} catch (Exception e) {
				new Actions(Driver.webdriver).moveToElement(homePage.tripledotsoncontextheader).click().build()
						.perform();
				Thread.sleep(1000);
				new Actions(Driver.webdriver).moveToElement(homePage.districtnameontripledot).build().perform();
				Thread.sleep(500);
				if (homePage.districtnameontripledot.getText().contains("...")) {
					districtName = homePage.tooltipofdistrictnameontripledot.getText();
				} else {
					districtName = homePage.districtnameontripledot.getText();
				}
			}
			new Actions(Driver.webdriver).moveByOffset(100, 100).click().build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return districtName;
	}

	/**
	 * This method is used to retrieve Grade value on UI
	 * 
	 * @return
	 */
	public static String getGradeNameonUI() {
		String grade = "";
		try {
			try {
				grade = homePage.gradenameoncontextheader.getText();
			} catch (Exception e) {
				new Actions(Driver.webdriver).moveToElement(homePage.tripledotsoncontextheader).click().build()
						.perform();
				Thread.sleep(1000);
				grade = homePage.gradenameontripledot.getText();
			}
			new Actions(Driver.webdriver).moveByOffset(100, 100).click().build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return grade;
	}

	/**
	 * This method is used to retrieve Test Name value on UI
	 * 
	 * @return
	 */
	public static String getTestsNameonUI() {
		String testsName = "";
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.testsNameoncontextheader).build().perform();
			Thread.sleep(500);
			if (homePage.testsNameoncontextheader.getText().contains("...")) {
				testsName = homePage.tooltipoftestnameoncontextheader.getText();
			} else {
				testsName = homePage.testsNameoncontextheader.getText();
			}
			new Actions(Driver.webdriver).moveByOffset(100, 100).build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return testsName;
	}

	/**
	 * This method is used to retrieve Teacher Name value on UI
	 * 
	 * @return
	 */
	public static String getTeacherNameonUI() {
		String teachersName = "";
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.contextheader_text_list.get(1)).build().perform();
			Thread.sleep(500);
			if (homePage.teacherNameoncontextheader.getText().contains("...")) {
				teachersName = homePage.tooltipofteachernameoncontextheader.getText();
			} else {
				teachersName = homePage.teacherNameoncontextheader.getText();
			}
			new Actions(Driver.webdriver).moveByOffset(100, 100).build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return teachersName;
	}

	/**
	 * This method is used to retrieve AssessedWith value on UI
	 * 
	 * @return
	 */
	public static String getAssessedWithonUI() {
		String assessedWithTxt = "";
		try {
			assessedWithTxt = homePage.questionDropDown.getText();
			new Actions(Driver.webdriver).moveToElement(homePage.overviewtext).click().build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return assessedWithTxt;
	}

	/**
	 * This method is used to retrieve Dates value on UI
	 * 
	 * @return
	 */
	public static String getDatesonContextHeaderUI() {
		String testsName = "";
		try {
			testsName = homePage.datesoncontextheader.getText();
			new Actions(Driver.webdriver).moveByOffset(200, 200).build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return testsName;
	}

	/**
	 * This method is used to retrieve Class Name on UI
	 * 
	 * @return
	 */
	public static String getClassNameonUI() {
		String className = "";
		try {
			new Actions(Driver.webdriver).moveToElement(homePage.classnameoncontextheader).build().perform();
			Thread.sleep(500);
			if (homePage.classnameoncontextheader.getText().contains("...")) {
				className = homePage.tooltipofclassnameoncontextheader.getText();
			} else {
				className = homePage.classnameoncontextheader.getText();
			}
			new Actions(Driver.webdriver).moveByOffset(200, 200).build().perform();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return className;
	}

	/**
	 * This method is used to wait till the loading of Student List section
	 */
	public static void wait_For_Student_List_AND_OR_Class_List_Section_Load() {
		boolean isSectionLoad = false;
		int list_on_sp_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.textingraystripinstudentlist.isDisplayed());
				log.info("List Section on Standard Performance is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for List Section on Standard Performance Loading");
				try {
					Thread.sleep(2000);
					list_on_sp_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && list_on_sp_ctr <= 15);

		if (isSectionLoad == false && list_on_sp_ctr > 15) {
			log.info("List Section on Standard Performance is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of Grouping Table Section
	 * 
	 * @throws InterruptedException
	 */
	public static void wait_For_Strands_Text_After_Apply_BtnOn_GroupingTab() throws InterruptedException {
		boolean isSectionLoad = false;
		int grouping_table_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.strandsTextAfterApplyBtnOnGroupingTab.isDisplayed());
				log.info("Strands_Text_After_Apply_BtnOn_GroupingTab is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("wait for strands Text on table header After Apply Btn On Grouping Tab ...");
				grouping_table_ctr++;
			}
		} while (isSectionLoad == false && grouping_table_ctr < 3);

		if (isSectionLoad == false && grouping_table_ctr == 3) {
			log.info("Strands_Text_After_Apply_BtnOn_GroupingTab is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of Single Test Analysis section
	 */
	public static void wait_For_STA_Section_Load() {
		boolean isSectionLoad = false;
		int sta_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.test_avg_score_text_on_sta_table.isDisplayed());
				log.info("Single Test Analysis Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Single Test Analysis Section");
				try {
					Thread.sleep(2000);
					sta_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && sta_ctr <= 15);

		if (isSectionLoad == false && sta_ctr > 15) {
			log.info("Single Test Analysis Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of detail section on test status
	 */
	public static void wait_For_Test_Status_Section_Load() {
		boolean isSectionLoad = false;
		int test_stts_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.table_body_in_detail_in_ts.isDisplayed());
				log.info("Test Status Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Test Status Section");
				try {
					Thread.sleep(2000);
					test_stts_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && test_stts_ctr <= 15);

		if (isSectionLoad == false && test_stts_ctr > 15) {
			log.info("Test Status Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of detail section on test status
	 * under student context
	 */
	public static void wait_For_Test_Status_Section_Load_under_student_context() {
		boolean isSectionLoad = false;
		int test_stts_ctr_sc = 0;
		do {
			try {
				Assert.assertTrue(homePage.table_body_in_ts_under_student_context.isDisplayed());
				log.info("Test Status Section under student context is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Test Status Section under student context");
				try {
					Thread.sleep(2000);
					test_stts_ctr_sc++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && test_stts_ctr_sc <= 15);

		if (isSectionLoad == false && test_stts_ctr_sc > 15) {
			log.info("Test Status Section under student context is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of Performance Over Time Line
	 * Chart section
	 * 
	 * @throws InterruptedException
	 */
	public static void wait_For_Performance_Over_Time_Line_Chart_Section_Load() throws InterruptedException {
		boolean isSectionLoad = false;
		int pot_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.info_icon_on_performance_over_time_header.isDisplayed());
				log.info("Perfomance Over Time Line Chart is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Performance Over Time Line Chart Loading");
				pot_ctr++;
			}
		} while (isSectionLoad == false && pot_ctr < 3);

		if (isSectionLoad == false && pot_ctr == 3) {
			log.info("Perfomance Over Time Line Chart is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of Test Score OverView section
	 */
	public static void wait_For_Test_Score_Overview_Section_Load() {
		boolean isSectionLoad = false;
		int tso_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.testscoreoverviewtext.isDisplayed());
				log.info("Test Score Overview Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Test Score Overview Section Loading");
				try {
					Thread.sleep(2000);
					tso_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && tso_ctr <= 15);

		if (isSectionLoad == false && tso_ctr > 15) {
			log.info("Test Score Overview Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the Summary section
	 */
	public static void wait_For_Summary_Tab_Section_Load() {
		boolean isSectionLoad = false;
		int smmry_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.summary_tab_standars_text.isDisplayed());
				log.info("Summary Tab Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Summary Tab Section Loading...");
				try {
					Thread.sleep(2000);
					smmry_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && smmry_ctr <= 15);

		if (isSectionLoad == false && smmry_ctr > 15) {
			log.info("Summary Tab Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of comparison section under test
	 * scores
	 */
	public static void wait_For_Comparison_Tab_Section_Load_under_test_score() {
		boolean isSectionLoad = false;
		int cmprson_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.comparison_tab_tests_text.isDisplayed());
				log.info("Comparison Tab Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Comparison Tab Section Loading");
				try {
					Thread.sleep(2000);
					cmprson_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && cmprson_ctr <= 15);

		if (isSectionLoad == false && cmprson_ctr > 15) {
			log.info("Comparison Tab Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of comparison section under
	 * standard performance
	 */
	public static void wait_For_Comparison_Tab_Section_Load_under_standard_performance() {
		boolean isSectionLoad = false;
		int cmprson_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.comparison_tab_sp_text.isDisplayed());
				log.info("Comparison Tab Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Comparison Tab Section Loading");
				try {
					Thread.sleep(2000);
					cmprson_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && cmprson_ctr <= 15);

		if (isSectionLoad == false && cmprson_ctr > 15) {
			log.info("Comparison Tab Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of comparison section
	 */
	public static void wait_For_Standards_Pop_up_Load() {
		boolean isSectionLoad = false;
		int cmprson_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.beneath_strands_on_standards_pop_up.isDisplayed());
				log.info("Edit Standard Tab Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Edit Standard Tab Section Loading");
				try {
					Thread.sleep(2000);
					cmprson_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && cmprson_ctr <= 15);

		if (isSectionLoad == false && cmprson_ctr > 15) {
			log.info("Edit Standard Tab Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of Test Score Detail section
	 */
	public static void wait_For_Test_Score_Detail_Section() {
		boolean isSectionLoad = false;
		int tsd_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.datesubmittedtext.isDisplayed());
				log.info("Test Score Detail Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Test Score Detail Section Loading");
				try {
					Thread.sleep(2000);
					tsd_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && tsd_ctr <= 15);

		if (isSectionLoad == false && tsd_ctr > 15) {
			log.info("Test Score Detail Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/**
	 * This method is used to wait till the loading of Standard Performance Table
	 * section
	 */
	public static void wait_For_Standard_Performance_Table_Section() {
		boolean isSectionLoad = false;
		int sp_table_ctr = 0;
		do {
			try {
				Assert.assertTrue(homePage.standardnameslist.get(0).isDisplayed());
				log.info("Standard Performance Table Section is now Displaying");
				isSectionLoad = true;
			} catch (Exception e1) {
				log.info("Waiting for Standard Performance Table Section Loading");
				try {
					Thread.sleep(2000);
					sp_table_ctr++;
				} catch (InterruptedException e) {
				}
			}
		} while (isSectionLoad == false && sp_table_ctr <= 15);

		if (isSectionLoad == false && sp_table_ctr > 15) {
			log.info("Standard Performance Table Section is not loaded in 30 seconds..");
			processException(new Exception());
		}
	}

	/*
	 * This method is used to call whenever user login with SA or DA and need to
	 * moved in class context
	 */
	public static void jump_to_class_context_from_school_or_district_context() throws Throwable {
		try {
			if (API_Connection.getUserRole().equalsIgnoreCase("SCHOOL_ADMIN")) {
				Standard_Overview_Table_Steps.user_Click_on_Standard_Performance_tab_within_the_School_Context();
				Standard_Overview_Table_Steps.user_Click_on_Standard_Performance_tab_within_the_Class_Context();
			} else if (API_Connection.getUserRole().equalsIgnoreCase("DISTRICT_ADMIN")) {
				Standard_Overview_Table_Steps.user_Click_on_Standard_Performance_tab_within_the_District_Context();
				Standard_Overview_Table_Steps.user_Click_on_Standard_Performance_tab_within_the_School_Context();
				Standard_Overview_Table_Steps.user_Click_on_Standard_Performance_tab_within_the_Class_Context();
			}
		} catch (Exception e) {
			log.error("Error in moving from school/district context to class context...");
			processException(e);
		}
	}

	public static void wait_For_CSV_File_Download(File file) throws InterruptedException {

		boolean isFileSaved = false;
		int wait_for_csv = 0;
		do {
			log.info("Waiting for CSV file to be saved...");
			Thread.sleep(2000);
			if (file.exists()) {
				Thread.sleep(1000);
				log.info(file.getAbsoluteFile().getName() + " is saved successfully..");
				isFileSaved = true;
				break;
			}
			wait_for_csv++;
		} while (wait_for_csv <= 15);

		if (isFileSaved == false && wait_for_csv > 15) {
			log.error("csv file not saved in 30 seconds...");
			processException(new Exception());
		}
	}

	/* This is method to select Golden oak school and grade 4 */
	public static void select_Grade_Four_From_Roster() {
		try {
			homePage.rostertab.click();
			Thread.sleep(500);
			homePage.schooldropdownbtn.click();
			Thread.sleep(500);
			new Actions(Driver.webdriver).moveToElement(homePage.studentTitleOnSliderMenu).build().perform();
			Driver.webdriver.findElement(By.xpath("//li[.='Golden Oak Community School']")).click();
			RosterTabUtilityMethods.wait_For_Refresh_Icon(homePage.schoolRefreshIcon, "School");
			homePage.gradedropdownbtn.click();
			Thread.sleep(500);
			Driver.webdriver.findElement(By.xpath("//li[.='Grade 4']")).click();
			Thread.sleep(500);
			homePage.rosterapplybtn.click();
			UtilityMethods.wait_For_Student_List_AND_OR_Class_List_Section_Load();
		} catch (Exception e) {
			UtilityMethods.processException(e);
		}
	}

	/*
	 * This method is used to verify the columns Header with the existing header
	 * list
	 */

	public static void Verify_Columns_Header_of_CSV(String[] details, File csv_File_Name) {
		CSVReader csvReader = null;
		try {
			log.info("Verifying csv file headers....");
			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader(csv_File_Name);
			// create csvReader object passing
			// file reader as a parameter
			csvReader = new CSVReader(filereader);
			String[] nextRecord;

			// we are going to read data line by line

			while ((nextRecord = csvReader.readNext()) != null) {
				for (int i = 1; i < nextRecord.length; i++) {
					Assert.assertTrue(details[i].equals(nextRecord[i].trim()));
				}
				log.info("Headers matched with the csv file...");
				break;
			}
			log.info("csv file headers matched successfully..");
		} catch (Exception e) {
			log.error("Headers not matched with the list...");
			processException(e);
		} finally {
			try {
				if (csvReader != null)
					csvReader.close();
			} catch (IOException e) {
				log.error("Error in reading csv file");
				processException(e);
			}
		}
	}

	/** This method is used to delete the csv file in download folder **/
	public static void Delete_CSV(String f) {
		// log.info("trying to delete csv files in folder");
		File path = new File(f);
		File[] files = path.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				file.delete();
			}
		}
		// log.info("csv file deleted successfully");
	}

	/** This method is used to delete the pdf file in download folder **/
	public static void Delete_PDF() {
		String user = System.getProperty("user.name");
		File folder = new File("C:\\Users\\" + user + "\\Downloads");
		File fileName = new File("Benchmark Universe - Assesment Reporting.pdf");
		File f = new File(folder + "\\" + fileName);
		if (f.exists()) {
			log.info("Deleting the file: " + folder + "\\" + fileName);
			f.delete();
		}
	}

	/**
	 * This method is used to Open the pdf and read the text from file in download
	 * folder
	 * 
	 * 
	 **/
	public static void Open_PDF_And_Read_Text_And_Verify_Details(List<String> details) {
		String user = System.getProperty("user.name");
		String pdf_file = "C:\\Users\\" + user + "\\Downloads\\Benchmark Universe - Assesment Reporting.pdf";
		PdfReader reader;
		try {
			Thread.sleep(2000);
			reader = new PdfReader(pdf_file);
			// pageNumber = 1
			String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
			for (int i = 0; i < details.size(); i++) {
				try {
					Assert.assertTrue(textFromPage.contains(details.get(i)));
				} catch (Exception e) {
					log.error(details.get(i) + " not available in pdf..");
					processException(e);
				}
			}
			reader.close();
		} catch (Exception e) {
			log.error("Error in reading pdf file");
			processException(e);
		}
	}

	static int pdf_ctr = 0;

	/** This method is used to save the pdf file in download folder **/
	public static void Save_PDF(Robot robot, String prnt_env) {
		try {
			// check and delete pdf file if previously created and not deleted
			Delete_PDF();
			Thread.sleep(20000);
			if (pdf_ctr == 0) {
				for (int i = 0; i < 5; i++) {
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(500);
				}
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(3000);
				for (int i = 0; i < 6; i++) {
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);
					Thread.sleep(500);
				}
			}
			pdf_ctr++;
			// press enter btn on print preview dialog and wait for 5 sec,enter for save the
			// file
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			log.info("Saving Benchmark Universe - Assesment Reporting.pdf ...");
		} catch (Exception e) {
			log.error("Error in saving pdf file..");
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to wait till the loading of context header section
	 */
	public static void wait_For_Context_Header_Section() {
		String firstData;
		boolean isSectionLoad = false;

		if (homePage.contextheader_text_list.get(0).getText().contains("...")) {
			new Actions(Driver.webdriver).moveToElement(homePage.contextheader_text_list.get(0)).build().perform();
			firstData = homePage.contextheadertooltiplist.get(0).getText();
		} else {
			firstData = homePage.contextheader_text_list.get(0).getText();
		}

		if (firstData.equals("")) {
			log.info("Waiting for Context Header Section loading...");
			IWait.implicit_wait(2);
			ch_ctr++;
			if (isSectionLoad == false && ch_ctr > 15) {
				log.info("Context Header Section is not loaded in 30 seconds..");
				processException(new Exception());
			}
			wait_For_Context_Header_Section();
		} else {
			log.info("Context Header Section is now clickable");
			isSectionLoad = true;
			new Actions(Driver.webdriver).moveByOffset(200, 200).build().perform();
		}
	}

	/**
	 * This method is used to wait for the loading of left and/or right section of
	 * content once you comes from visiting any page context and page menu
	 */
	public static void wait_For_Page_Section_Load() {

		log.info("Under Student Context:=>" + Standard_Overview_Table_Steps.underStudentContext);
		log.info("Under Class Context:=>" + Standard_Overview_Table_Steps.underClassContext);
		log.info("Performance Menu Clicked:=>" + Standard_Overview_Table_Steps.performanceMenuClicked);
		log.info("Test Score Menu Clicked:=>" + Standard_Overview_Table_Steps.testScoreMenuClicked);

		if (Standard_Overview_Table_Steps.underStudentContext) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

			}
			if (Standard_Overview_Table_Steps.performanceMenuClicked) {
				try {
					wait_For_Performance_Over_Time_Line_Chart_Section_Load();
				} catch (InterruptedException e) {
				}
			} else {
				wait_For_Test_Score_Overview_Section_Load();
			}
		} else if (Standard_Overview_Table_Steps.underClassContext) {
			if (Standard_Overview_Table_Steps.performanceMenuClicked) {
				wait_For_Student_List_AND_OR_Class_List_Section_Load();
			} else {
				wait_For_Test_Score_Detail_Section();
			}
		}
	}

	/**
	 * This method is used to verify the Date List is in Descending order
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isDatesSortedInDecendingOrder(List<Date> a) {
		if (a.size() == 1) {
			return true;
		} else {
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(i).getTime() >= a.get(i + 1).getTime()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method is used to verify the Date List is in Ascending order
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isDatesSortedInAscendingOrder(List<Date> a) {
		if (a.size() == 1) {
			return true;
		} else {
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(i).getTime() <= a.get(i + 1).getTime()) {
					return true;
				}
			}
		}
		return false;
	}

	/** This method is used to validate the tag contains attribute or not **/
	public static boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	public static String TestNamefromTestTab() {
		String name = "";
		try {
			// checking for paginator
			if (PaginationUtility_for_Universal_Tab.checkPaginator_on_test_tab()) {
				// this lool will execute for the no. of circle available on paginator
				for (int i = 0; i < homePage.testpaginationcirclelist.size(); i++) {
					PaginationUtility_for_Universal_Tab.click_On_Indexed_Circle_Of_Paginator(i);
					Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
					for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
						if (homePage.testscheckboxlistwithinput.get(j).getAttribute("value").equals("true")) {
							name = homePage.testnameslist_on_test_tab.get(j).getText();
						}
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
							if (homePage.testscheckboxlistwithinput.get(j).getAttribute("value").equals("true")) {
								name = homePage.testnameslist_on_test_tab.get(j).getText();
							}
						}
					}
				} while (PaginationUtility_for_Universal_Tab.check_Enabled_Right_Arrow_On_Paginator_On_Test_Tab());
			} else {
				// when paginator is not found
				Assert.assertTrue(homePage.testnameslist_on_test_tab.size() <= 10);
				for (int j = 0; j < homePage.testnameslist_on_test_tab.size(); j++) {
					if (homePage.testscheckboxlistwithinput.get(j).getAttribute("value").equals("true")) {
						name = homePage.testnameslist_on_test_tab.get(j).getText();
					}
				}
			}
		} catch (Exception e) {
			processException(e);
		}
		return name;
	}

	public static String getRandomTest_From_Test_Tab() {
		try {
			String name;
			homePage.testtab.click();
			Thread.sleep(500);
			UtilityMethods.scrollPageDown(Driver.webdriver, 5);
			Thread.sleep(500);
			homePage.allcheckbox_in_test_tab.click();
			Thread.sleep(500);
			int ran_no = generateRandomNumberBySkippingIndex(homePage.testnameslist_on_test_tab.size(), 0);
			// int ran_no = (int) (Math.random()*homePage.testnameslist_on_test_tab.size());
			new Actions(Driver.webdriver).moveToElement(homePage.testnameslist_on_test_tab.get(ran_no)).build()
					.perform();
			name = homePage.testnameslist_on_test_tab.get(ran_no).getText();
			homePage.testnameslist_on_test_tab.get(ran_no).click();
			Thread.sleep(500);
			homePage.testapplybtn.click();
			UtilityMethods.scrollPageUp(Driver.webdriver);
			return name;
		} catch (Exception e) {
			processException(e);
			return null;
		}
	}

	public static List<String> getViewNames_From_View_DropDown_on_SP() {
		List<String> viewList = new LinkedList<String>();
		try {
			String txt = "";
			homePage.viewDropDown.click();
			Thread.sleep(500);
			for (int i = 0; i < homePage.viewDropDownList.size(); i++) {
				new Actions(Driver.webdriver).moveToElement(homePage.viewDropDownList.get(i)).build().perform();
				Thread.sleep(500);
				txt = homePage.viewDropDownList.get(i).getText();
				if (txt.contains("...")) {
					new Actions(Driver.webdriver).moveToElement(homePage.viewDropDownTTTList.get(i)).build().perform();
					Thread.sleep(500);
					viewList.add(homePage.viewDropDownTTTList.get(i).getText());
				} else {
					viewList.add(txt);
				}
			}
			homePage.viewDropDown.click();
			Thread.sleep(500);
		} catch (Exception e) {
			processException(e);
		}
		return viewList;
	}

}
