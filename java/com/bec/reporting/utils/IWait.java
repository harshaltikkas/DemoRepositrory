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
package com.bec.reporting.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class IWait {

	/**
	 * This method is used to wait for the webpage specific time
	 * 
	 * @param time
	 * @return
	 */
	public static void implicit_wait(long time) {
		try {
			Driver.webdriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("failed_in_implicit_wait");
			UtilityMethods.processException(e);
		}
	}

	/**
	 * This method is used to wait for the element for in webpage
	 * 
	 * @param driver
	 * @param el
	 * @return
	 */
	public static void explicit_wait(WebDriver driver, WebElement el) {
		try {
			new WebDriverWait(driver, 90).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOf(el));
		} catch (Exception e) {
			log.info("failed to page load ...");
			UtilityMethods.processException(e);
		}
	}

	// return ByType of WebElement
	public static By toByVal(WebElement we) {
		String str = we.toString().substring(0, we.toString().length() - 1);
		String[] data = str.split(" -> ")[1].split(": ");
		String locator = data[0];
		String term = data[1];

		switch (locator) {
		case "xpath":
			return By.xpath(term);
		case "css selector":
			return By.cssSelector(term);
		case "id":
			return By.id(term);
		case "tag name":
			return By.tagName(term);
		case "name":
			return By.name(term);
		case "link text":
			return By.linkText(term);
		case "class name":
			return By.className(term);
		}
		return (By) we;
	}

	/**
	 * This method is used to check the absence of element, if element is absent
	 * will return true else exception will occur.
	 * 
	 * @param time
	 * @return
	 */
	public static boolean check_Absence_of_Element(WebElement el) {
		try {
			Assert.assertTrue(el.isDisplayed());
			log.error(el.getText() + " is present");
			UtilityMethods.processException(new Exception());
		} catch (Exception e) {

		}
		return true;
	}

}
