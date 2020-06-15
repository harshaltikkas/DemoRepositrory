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
package com.bec.reporting.pageobjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	/**
	 * This saction contains page object/webelemet of Universal Selector
	 */
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement schoolRefreshIcon;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement classRefreshIcon;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Grade')]/span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement gradeRefreshIcon;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Teacher')]/span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement teachersRefreshIcon;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'District Term')]/span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement dateRefreshIcon;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement studentRefreshIcon;

	@FindBy(xpath = "//span[@class='csv_download_icon']//i[@class='material-icons' and text()='autorenew']")
	public WebElement csvDownloadRefreshIcon;

	@FindBy(xpath = "//div[@class='download_csv']/span[@class='csv_download_icon']/img")
	public WebElement csvDownloadIcon;
	
	@FindBy(xpath = "//button[@class='csv_popup_download_btn']")
	public WebElement csv_download_btn_on_model;
	
	@FindBy(xpath = "//div[@class='csv_popup_download_cancel']")
	public WebElement csv_download_cancel_btn_on_model;

	@FindBy(xpath = "//span[text()='CSV Download']")
	public WebElement csv_download_text_on_model;
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//select[@class='field selectBox']")
	public WebElement usertypedropdown;

	@FindBy(xpath = "//input[@id='login']")
	public WebElement loginbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	public WebElement loginbtn_on_stg;

	@FindBy(xpath = "//div[.='Class']//span[@class='data-refresh']//i[@class='material-icons' and contains(text(),'autorenew')]")
	public WebElement classdrpdwnrefreshicon;

	@FindBy(xpath = "//i[contains(text(),'chevron_right')]/ancestor::span[@class='float-right']")
	public WebElement openarrow;

	@FindBy(xpath = "//i[contains(text(),'chevron_left')]/ancestor::span[@class='float-right']")
	public WebElement closearrow;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]")
	public WebElement studentTitleOnSliderMenu;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'District Term')]")
	public WebElement districtNameOnSliderMenu;

	@FindBy(xpath = "//div[@class='universal-test-search']//span//div//input[@placeholder='Search']")
	public WebElement searchbarontesttab;

	@FindBy(xpath = "//span[text()='Student Data']/ancestor::div[@class='menu-title']//span[contains(@class,'infoIconForRoster')]")
	public WebElement studentdata_filter;
	
	@FindBy(xpath = "//span[@class='infoIconForRosterClass']/img")
	public WebElement info_icon_on_ch;
	
	@FindBy(xpath = "//span[@class='infoIconForRoster_tooltip_Description']")
	public WebElement tooltip_text_on_roster;
	
	@FindBy(xpath = "//span[@class='infoIconForRosterClass_tooltip_right']/span")
	public WebElement tooltip_text_on_ch;
	
	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Roster')]")
	public WebElement rostertab;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]")
	public WebElement testtab;

	@FindBy(xpath = "//button[@class='btn universal-selector-applyfilter']")
	public WebElement doneBtn;

	@FindBy(xpath = "//span[contains(text(),'Test Type')]/ancestor::div[@class='test-type-input-field']//button/span")
	public WebElement testtypedropdown;

	@FindBy(xpath = "//div[@class='menu-dropdown-list-inr']//li/div[@class='testTypesingleitem']//input")
	public List<WebElement> testtypecheckboxlist;

	@FindBy(xpath = "//span[contains(text(),'Test Type')]/ancestor::div[@class='menu-title']/following-sibling::div[@class='menu-selector active-selector']//li")
	public List<WebElement> testtypenameslist;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Date')]")
	public WebElement datetab;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div/button")
	public WebElement schooldropdownbtn;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Teacher')]/following-sibling::div/button")
	public WebElement teachersdropdownbtn;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div/button//div[@class='bec_tooltip_content']")
	public WebElement schooldropdownbtntooltip;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div/button")
	public WebElement classdropdownbtn;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div/button//div[@class='bec_tooltip_content']")
	public WebElement classdropdownbtntooltip;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div/button")
	public WebElement studentdropdownbtn;
	
	@FindBy(xpath = "//span[contains(text(),'Student Data')]/ancestor::div[@class='menu-title']/following-sibling::div/button")
	public WebElement studentdatadropdownbtn;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Grade')]/following-sibling::div/button")
	public WebElement gradedropdownbtn;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'District Term')]/following-sibling::div/button")
	public WebElement districttermdropdownbtn;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Date Range')]/following-sibling::div/button")
	public WebElement daterangedropdownbtn;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Roster')]/ancestor::div[@class='menu-item']/following-sibling::div//button[contains(text(),'Apply')]")
	public WebElement rosterapplybtn;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]/ancestor::div[@class='menu-item']/following-sibling::div//button[contains(text(),'Apply')]")
	public WebElement testapplybtn;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Date')]/ancestor::div[@class='menu-item']/following-sibling::div//button[contains(text(),'Apply')]")
	public WebElement dateapplybtn;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Roster')]/ancestor::div[@class='menu-item']/following-sibling::div//div[contains(text(),'Cancel')]")
	public WebElement rostercancelbtn;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]/ancestor::div[@class='menu-item']/following-sibling::div//div[contains(text(),'Cancel')]")
	public WebElement testcancelbtn;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Date')]/ancestor::div[@class='menu-item']/following-sibling::div//div[contains(text(),'Cancel')]")
	public WebElement datecancelbtn;

	@FindBy(xpath = "//label[@class='input-checkbox checkbox-lightBlue']")
	public WebElement allcheckbox_in_test_tab;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul/li")
	public WebElement studentdropdownallcheckbox;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]/ancestor::div[@class='menu-item']/following-sibling::div//div[@class='input-checkbox checkbox-lightBlue']")
	public List<WebElement> testscheckboxlist;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]/ancestor::div[@class='menu-item']/following-sibling::div//div[@class='input-checkbox checkbox-lightBlue']/input")
	public List<WebElement> testscheckboxlistwithinput;

	@FindBy(xpath = "//div[@class='test-results-row-set']//div[@class='test-results-col-full']")
	public List<WebElement> testnameslist_on_test_tab;

	@FindBy(xpath = "//div[@class='test-results-row-set']/div[2]/div[3]")
	public List<WebElement> testnoofresultlist;

	@FindBy(xpath = "//div[@class='test-results-row-set']/div[2]/div[4]")
	public List<WebElement> earliestdatelist;

	@FindBy(xpath = "//div[@class='test-results-row-set']/div[2]/div[5]")
	public List<WebElement> latestdatelist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'District Term')]/following-sibling::div//ul/li")
	public List<WebElement> districttermlist;

	@FindBy(xpath = "//span[@class='scroll-right scroll-active float-right']/i")
	public WebElement rightarrowofpaginationontesttab;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//li")
	public List<WebElement> schoollist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Grade')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//li")
	public List<WebElement> gradelist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//li")
	public List<WebElement> classlist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//li")
	public List<WebElement> studentlistwithall;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Teacher')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//li")
	public List<WebElement> teacherslist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul//div[contains(@style,'position: relative; display: block; width: 100%; cursor: pointer; border-radius: inherit; background-color: rgba(0, 0, 0, 0.2); height: 139px; transform: translateY(0px);')]")
	public WebElement classlistScroll;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div[@class='menu-dropdown-list-inr']//ul//div/li")
	public List<WebElement> studentlistondropdown;
	
	@FindBy(xpath = "//span[contains(text(),'Student Data')]/ancestor::div[@class='menu-title']/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul[@class='studentDataFillterBlock']/li/span/span")
	public List<WebElement> studentdatadropdownlist;
	
	@FindBy(xpath = "//span[contains(text(),'Student Data')]/ancestor::div[@class='menu-title']/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul[@class='studentDataFillterBlock']/li/span/div/div[@class='bec_tooltip_content']")
	public List<WebElement> tt_on_studentdatadropdownlist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div[@class='menu-dropdown-list-inr']//ul//div/li//input")
	public List<WebElement> studentlistondropdownwithinput;

	@FindBy(xpath = "//span[contains(text(),'Name')]/following-sibling::span/i[contains(text(),'expand_more')]")
	public WebElement namedownarrow;

	@FindBy(xpath = "//span[contains(text(),'Name')]/following-sibling::span/i[contains(text(),'expand_less')]")
	public WebElement nameuparrow;

	@FindBy(xpath = "//span[contains(text(),'Number of Results')]/following-sibling::span/i[contains(text(),'expand_more')]")
	public WebElement noofresultdownarrow;

	@FindBy(xpath = "//span[contains(text(),'Number of Results')]/following-sibling::span/i[contains(text(),'expand_less')]")
	public WebElement noofresultuparrow;

	@FindBy(xpath = "//span[contains(text(),'Earliest Date')]/following-sibling::span/i[contains(text(),'expand_more')]")
	public WebElement earliestdatedownarrow;

	@FindBy(xpath = "//span[contains(text(),'Earliest Date')]/following-sibling::span/i[contains(text(),'expand_less')]")
	public WebElement earliestdateuparrow;

	@FindBy(xpath = "//span[contains(text(),'Latest Date')]/following-sibling::span/i[contains(text(),'expand_more')]")
	public WebElement latestdatedownarrow;

	@FindBy(xpath = "//span[contains(text(),'Latest Date')]/following-sibling::span/i[contains(text(),'expand_less')]")
	public WebElement latestdateuparrow;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//input[@type='text' and @placeholder='Search']")
	public WebElement searchbaronschooldropdown;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//input[@type='text' and @placeholder='Search']")
	public WebElement searchbaronclassdropdown;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//input[@type='text' and @placeholder='Search']")
	public WebElement searchbaronstudentdropdown;
	
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Teacher')]/following-sibling::div//input[@type='text' and @placeholder='Search']")
	public WebElement searchbaronteacherdropdown;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//div//span[@class='menu-varient-search-cancel']")
	public WebElement searchcancelonschooldropdown;
	
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Teacher')]/following-sibling::div//div//span[@class='menu-varient-search-cancel']")
	public WebElement searchcancelonteacherdropdown;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]/ancestor::div[@class='menu-item']/following-sibling::div//span[@class='menu-varient-search-cancel']")
	public WebElement searchcancelontestsearchbar;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//div//span[@class='menu-varient-search-cancel']")
	public WebElement searchcancelonclassdropdown;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div//span[@class='menu-varient-search-cancel']")
	public WebElement searchcancelonstudentdropdown;

	/* Paginator of school,class , student and test */
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//div[@class='selector-pagination']")
	public WebElement schoolpaginator;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//div[@class='selector-pagination']")
	public WebElement classpaginator;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div[@class='selector-pagination']")
	public WebElement studentpaginator;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Teacher')]/following-sibling::div//div[@class='selector-pagination']")
	public WebElement teacherpaginator;

	@FindBy(xpath = "//div[@class='date-selector activeCalendar']/button")
	public WebElement activeDate;

	@FindBy(xpath = "//div[@class='dateBottomTitleText']")
	public WebElement dateRangeValueOnUI;

	@FindBy(xpath = "//div[@class='date-selector']/button")
	public WebElement edate;

	@FindBy(xpath = "//div[@class='TermYear_Selector']/button")
	public WebElement monthDropDown;

	@FindBy(xpath = "//div[@class='TermYearSelector']//li")
	public List<WebElement> monthDropDownList;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Date Range')]/following-sibling::div//li")
	public List<WebElement> dateRangelist;

	@FindBy(xpath = "//div[@class='weekMarkUpDates']//div//button[@class='Day']")
	public List<WebElement> activeDateRangelistoOnCalender;

	/* School pagination circle list,enable right arrow and disable right arrow */
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//div[@class='PaginationBubblesAndCount']//ul[@class='m-0 page-circle-list']//span")
	public List<WebElement> schoolpaginationcirclelist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//span[@class='scroll-right float-right scroll-disable']")
	public WebElement schooldisabledrightarrow;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//span[@class='scroll-right scroll-active float-right']")
	public WebElement schoolenabledrightarrow;

	/* Class pagination circle list,enable right arrow and disable right arrow */
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//div[@class='PaginationBubblesAndCount']//ul[@class='m-0 page-circle-list']//span")
	public List<WebElement> classpaginationcirclelist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//span[@class='scroll-right float-right scroll-disable']")
	public WebElement classdisabledrightarrow;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Class')]/following-sibling::div//span[@class='scroll-right scroll-active float-right']")
	public WebElement classenabledrightarrow;

	/* Test pagination circle list,enable right arrow and disable right arrow */
	@FindBy(xpath = "//div[@class='menu-item']/following-sibling::div//div[@class='selector-pagination']")
	public WebElement testpaginator;

	@FindBy(xpath = "//div[@class='PaginationBubblesAndCount']//ul/li")
	public List<WebElement> testpaginationcirclelist;

	@FindBy(xpath = "//span[@class='menu-name' and contains(text(),'Test')]/ancestor::div[@class='menu-item']/following-sibling::div//span[@class='scroll-right float-right scroll-disable']")
	public WebElement testdisabledrightarrow;

	@FindBy(xpath = "//span[@class='test-count']")
	public WebElement totaltestcount;

	@FindBy(xpath = "//span[@class='menu-name' and .='Test']/ancestor::div[@class='menu-item']/following-sibling::div//span[contains(@class,'scroll-right scroll-active')]/i[.='chevron_right']")
	public WebElement test_tab_enabled_right_arrow;

	@FindBy(xpath = "//span[@class='menu-name' and .='Test']/ancestor::div[@class='menu-item']/following-sibling::div//span[contains(@class,'scroll-left float-left scroll-active')]/i")
	public WebElement test_tab_enabled_left_arrow;

	/* Student pagination circle list,enable right arrow and disable right arrow */
	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//div[@class='PaginationBubblesAndCount']//ul[@class='m-0 page-circle-list']//span")
	public List<WebElement> studentpaginationcirclelist;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//span[@class='scroll-right float-right scroll-disable']")
	public WebElement studentdisabledrightarrow;

	@FindBy(xpath = "//div[@class='menu-title' and contains(text(),'Student')]/following-sibling::div//span[@class='scroll-right scroll-active float-right']")
	public WebElement studentenabledrightarrow;

	@FindBy(xpath = "//a[contains(text(),'try again')]")
	public WebElement try_again_link;

	/* Context Header Elements */
	@FindBy(xpath = "//div[@class='context-header-main']//li/span[@class='context-header-title']")
	public List<WebElement> contextheader_title_list;

	@FindBy(xpath = "//div[@class='context-header-main']//li/span[@class='context-header-text']")
	public List<WebElement> contextheader_text_list;

	@FindBy(xpath = "//span[@class='context-header-text']//div[@class='bec_tooltip_content']")
	public List<WebElement> contextheadertooltiplist;

	@FindBy(xpath = "//div[contains(text(),'School:')]/ancestor::div[@class='title_and_attribute']//span")
	public WebElement schoolnameontripledot;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'School:')]/following-sibling::span")
	public WebElement schoolnameoncontextheader;

	@FindBy(xpath = "//div[contains(text(),'Grade:')]/following-sibling::div")
	public WebElement gradenameontripledot;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Grade:')]/following-sibling::span")
	public WebElement gradenameoncontextheader;

	@FindBy(xpath = "//div[contains(text(),'District:')]/ancestor::div[@class='title_and_attribute']//span")
	public WebElement districtnameontripledot;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'District:')]/following-sibling::span")
	public WebElement districtnameoncontextheader;

	@FindBy(xpath = "//span[@class='context-header-title']//i[contains(text(),'more_vert')]")
	public WebElement tripledotsoncontextheader;

	@FindBy(xpath = "//div[contains(text(),'School:')]/ancestor::div[@class='title_and_attribute']//span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofschoolnameontripledot;

	@FindBy(xpath = "//div[contains(text(),'Grade:')]/ancestor::div[@class='title_and_attribute']//span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofgradenameontripledot;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Grade:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofgradenameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'School:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofschoolnameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'District:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofdistrictnameoncontextheader;

	@FindBy(xpath = "//div[contains(text(),'District:')]/ancestor::div[@class='title_and_attribute']//span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofdistrictnameontripledot;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Class:')]/following-sibling::span")
	public WebElement classnameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Teacher:')]/following-sibling::span")
	public WebElement teachernameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Class:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofclassnameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Student:')]/following-sibling::span")
	public WebElement studentnameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Student:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement studentnameoncontextheadertooltiptext;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Tests:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement tooltipoftestnameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Teacher:')]/following-sibling::span//div[@class='bec_tooltip_content']")
	public WebElement tooltipofteachernameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Tests:')]/following-sibling::span")
	public WebElement testsNameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Teacher:')]/following-sibling::span")
	public WebElement teacherNameoncontextheader;

	@FindBy(xpath = "//div[@class='context-header-main']//span[contains(text(),'Dates:')]/following-sibling::span")
	public WebElement datesoncontextheader;

	@FindBy(xpath = "//div[@class='test-results-body']//div[.='No Records Found']")
	public WebElement norecordontestsearch;
	
	@FindBy(xpath = "//li[text()='No Records Available']")
	public WebElement norecordavailableonrostertab;

	@FindBy(xpath = "//li[@class='active_tab' and contains(text(),'Standards Performance')]")
	public WebElement activestandardperformancebtn;

	@FindBy(xpath = "//li[@class='active_tab' and contains(text(),'Test Status')]")
	public WebElement active_test_status_btn;
	
	@FindBy(xpath = "//li[@class='active_tab' and contains(text(),'Test Scores')]")
	public WebElement active_test_scores_btn;

	@FindBy(xpath = "//li[@class='active' and contains(text(),'Assessments')]")
	public WebElement activeAssessementsbtn;

	@FindBy(xpath = "//li[@class='active_tab' and contains(text(),'Test Scores')]")
	public WebElement activetestscoresbtn;

	@FindBy(xpath = "//li[@class='active_tab']/span[contains(text(),'Summary')]")
	public WebElement active_summary_tab;
	
	@FindBy(xpath = "//li[@class='active_tab' and contains(text(),'Comparison')]")
	public WebElement active_comparison_tab;

	@FindBy(xpath = "//li[@class='active_tab' and contains(text(),'Single Test Analysis')]")
	public WebElement active_sta_tab;

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and contains(text(),'Class List')]")
	public WebElement activeClassListPage;

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and contains(text(),'School List')]")
	public WebElement activeSchoolListPage;

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and contains(text(),'Student List')]")
	public WebElement activeStudentListPage;

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and contains(text(),'Performance Over Time')]")
	public WebElement activePerformanceOverTimePage;

	@FindBy(xpath = "//li[.='Test Scores']")
	public WebElement testscoresbtn;

	@FindBy(xpath = "//span[contains(text(),'Class')]/ancestor::div[contains(@class,'single-filter text-center active-filter')]")
	public WebElement activeclassmenu;

	@FindBy(xpath = "//span[contains(text(),'School')]/ancestor::div[contains(@class,'single-filter text-center active-filter')]")
	public WebElement activeschoolmenu;

	@FindBy(xpath = "//span[contains(text(),'District')]/ancestor::div[contains(@class,'single-filter text-center active-filter')]")
	public WebElement activedistrictmenu;

	@FindBy(xpath = "//span[contains(text(),'Student')]/ancestor::div[contains(@class,'single-filter text-center active-filter')]")
	public WebElement activestudentmenu;

	@FindBy(xpath = "//div[@class='single-filter-text']//span[contains(text(),'Student')]")
	public WebElement studentmenu;
	
	@FindBy(xpath = "//span[contains(text(),'Resources')]")
	public WebElement resources_txt_on_dashboard;
	
	@FindBy(xpath = "//div[@class='tile']//a/p[contains(text(),'Reports')]")
	public WebElement report_link_on_dashboard;
	
	@FindBy(xpath = "//p[contains(text(),'Sign Out')]")
	public WebElement sign_out_link;
	
	@FindBy(xpath = "//li[contains(text(),'Sign Out')]")
	public WebElement sign_out_link_on_dashboard;

	@FindBy(xpath = "//div[@class='single-filter-text']//span[contains(text(),'Class')]")
	public WebElement classmenu;

	@FindBy(xpath = "//div[@class='single-filter-text']//span[contains(text(),'School')]")
	public WebElement schoolmenu;

	@FindBy(xpath = "//div[@class='single-filter-text']//span[contains(text(),'District')]")
	public WebElement districtmenu;

	@FindBy(xpath = "//li[.='Standards Performance']")
	public WebElement standardperformancebtn;

	@FindBy(xpath = "//li[.='Test Status']")
	public WebElement test_status_btn;
	
	@FindBy(xpath = "//li[.='Test Scores']")
	public WebElement test_scores_btn;

	@FindBy(xpath = "//li[.='Single Test Analysis']")
	public WebElement statab;

	@FindBy(xpath = "//div[@class='footer-indicate-title' and contains(text(),'Achievement Levels')]")
	public WebElement achievmentlevelslabel;

	@FindBy(xpath = "//div[@class='footer-key-bar grey']/ancestor::div[@class='footer-single-indicator']/following-sibling::div[@class='footer-single-indicator-title' and contains(text(),'No Data Available')]")
	public WebElement nodatawithgraycolor;

	@FindBy(xpath = "//div[@class='footer-key-bar red']/ancestor::div[@class='footer-single-indicator']/following-sibling::div[@class='footer-single-indicator-title' and contains(text(),'Below 40%')]")
	public WebElement albelow40withredcolor;

	@FindBy(xpath = "//div[@class='footer-key-bar orange']/ancestor::div[@class='footer-single-indicator']/following-sibling::div[@class='footer-single-indicator-title' and contains(text(),'40-59%')]")
	public WebElement al40_59withorangecolor;

	@FindBy(xpath = "//div[@class='footer-key-bar yellow']/ancestor::div[@class='footer-single-indicator']/following-sibling::div[@class='footer-single-indicator-title' and contains(text(),'60-79%')]")
	public WebElement al60_79withyellowcolor;

	@FindBy(xpath = "//div[@class='footer-key-bar green']/ancestor::div[@class='footer-single-indicator']/following-sibling::div[@class='footer-single-indicator-title' and contains(text(),'80%+')]")
	public WebElement al80pluswithgreencolor;

	@FindBy(xpath = "//li[contains(text(),'Overview')]")
	public WebElement overviewtext;

	@FindBy(xpath = "//p[contains(text(),'Reports')]")
	public WebElement reportstext;

	/* Footer Elements */
	@FindBy(xpath = "//div[@class='footer-bottom']")
	public WebElement footer;

	@FindBy(xpath = "//div[@class='footer-right']//a")
	public WebElement footerrightside;

	@FindBy(xpath = "//div[@class='footer-left']")
	public WebElement footerleftside;

	@FindBy(xpath = "//div[@class='footer-key-btn']/span/i")
	public WebElement reportingkey;

	@FindBy(xpath = "//div[@class='footer-indicate-title' and contains(text(),'Questions')]")
	public WebElement questions_on_reportingkey;

	@FindBy(xpath = "//li//div[@class='footer-st_analysis-single-indicator']//span[.='Correct']")
	public WebElement correct_questions_on_reportingkey;

	@FindBy(xpath = "//li//div[@class='footer-st_analysis-single-indicator']//span[.='Incorrect']")
	public WebElement incorrect_questions_on_reportingkey;

	@FindBy(xpath = "//li//div[@class='footer-st_analysis-single-indicator']//span[.='Partial']")
	public WebElement partial_questions_on_reportingkey;

	@FindBy(xpath = "//li//div[@class='footer-st_analysis-single-indicator']//span[.='Not Answered']")
	public WebElement not_answered_questions_on_reportingkey;

	/*
	 * Xpath list for Line_Chart_Test_Scores_vs_Time
	 */

	@FindBy(xpath = "//span[contains(text(),'Test Scores Over Time')]/ancestor::div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div//*[name()='tspan' and text()='Test Scores (%)']")
	public WebElement yaxistexton_linechart_tsot;

	@FindBy(xpath = "//span[text()='Test Scores Over Time']/ancestor::div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div/div//div[@class='line_chart_graph']//*[name()='line' and @class='vx-line' and @stroke-width='1']")
	public List<WebElement> horizontalline_onlinechart_tsot;
	
	@FindBy(xpath = "//span[text()='Test Scores Over Time']/ancestor::div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div/div//div[@class='line_chart_graph']//*[name()='line' and @class='vx-line']/following-sibling::*[name()='svg']//*[name()='tspan']")
	public List<WebElement> yaxislabelsonhorizontalline_onlinechart;
	
	@FindBy(xpath = "//span[contains(text(),'Test Scores over Time')]/ancestor::div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div//*[name()='tspan' and text()='Test Scores (%)']")
	public WebElement yaxistexton_linechart_tsot_withsmallo;
	
	@FindBy(xpath = "//span[text()='Test Scores over Time']/ancestor::div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div/div//div[@class='line_chart_graph']//*[name()='line' and @class='vx-line']/following-sibling::*[name()='svg']//*[name()='tspan']")
	public List<WebElement> yaxislabelsonhorizontalline_onlinechart_withsmallo;

	@FindBy(xpath = "//span[text()='Test Scores over Time']/ancestor::div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div/div//div[@class='line_chart_graph']//*[name()='line' and @class='vx-line' and @stroke-width='1']")
	public List<WebElement> horizontalline_onlinechart_tsot_withsmallo;
	
	@FindBy(xpath = "//span[@class='sidewidget-header-title' and .='Performance Over Time']/ancestor::div[@class='sidewidget-header']/following-sibling::div/div/div[3]//*[name()='text' and @class='vx-axis-label y---axis']/*[name()='tspan']")
	public WebElement yaxis_text_label_on_pot_line_chart;

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and .='Performance Over Time']/ancestor::div[@class='sidewidget-header']/following-sibling::div/div/div[3]//*[name()='line' and @class='vx-line' and @stroke-width='1']")
	public List<WebElement> horizontal_line_on_pot_line_chart;
	

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and .='Performance Over Time']/ancestor::div[@class='sidewidget-header']/following-sibling::div/div/div[3]//*[name()='line' and @class='vx-line']/following-sibling::*[name()='svg']//*[name()='tspan']")
	public List<WebElement> yaxis_labels_on_horizontal_line_on_pot_line_chart;

	@FindBy(xpath = "//div[@class='class_widget_title test_score_overtime']/following-sibling::div/div/div[@class='Test_names_label']")
	public WebElement testnameslabel_onlinechart_tsot;

	@FindBy(xpath = "//span[contains(text(),'Performance Over Time')]/ancestor::div[contains(@class,'sidewidget-header')]/following-sibling::div//div[contains(text(),'Test Names')]")
	public WebElement testnameslabel_onlinechart_pot;

	// TODO ==========(1)paginator_on_list_under_Standard Performance Tab==========
	@FindBy(xpath = "//div[@class='student-list-body']//div[@class='selector-pagination']")
	public WebElement paginator_on_list_under_sp;

	@FindBy(xpath = "//div[@class='student-list-body']//div[@class='selector-pagination']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_list_under_sp;

	@FindBy(xpath = "//div[@class='student-list-body']//div[@class='selector-pagination']//span[@class='scroll-right scroll-active float-right']/i")
	public WebElement enabled_right_arrow_on_paginator_on_list_under_sp;

	// ==========(2)paginator_on_pot_under_Standard Performance Tab==========
	@FindBy(xpath = "//span[contains(text(),'Performance Over Time')]/ancestor::div[contains(@class,'sidewidget-header')]/following-sibling::div//div[@class='selector-pagination']")
	public WebElement paginator_on_pot_under_sp;

	@FindBy(xpath = "//span[contains(text(),'Performance Over Time')]/ancestor::div[contains(@class,'sidewidget-header')]/following-sibling::div//div[@class='selector-pagination']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_pot_under_sp;

	@FindBy(xpath = "//span[contains(text(),'Performance Over Time')]/ancestor::div[contains(@class,'sidewidget-header')]/following-sibling::div//div[@class='selector-pagination']//span[contains(@class,'scroll-left float-left scroll-active')]/i")
	public WebElement enabled_left_arrow_on_paginator_on_pot_under_sp;

	// ==========(3)paginator_on_Test Score Detail_under_Test Score Tab==========
	@FindBy(xpath = "//span[contains(text(),'Test Score Detail')]/ancestor::div[@class='class_widget_title ']/following-sibling::div//div[@class='selector-pagination']")
	public WebElement paginator_on_tsd;

	@FindBy(xpath = "//span[contains(text(),'Test Score Detail')]/ancestor::div[@class='class_widget_title ']/following-sibling::div//div[@class='selector-pagination']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_tsd;

	@FindBy(xpath = "//span[contains(text(),'Test Score Detail')]/ancestor::div[@class='class_widget_title ']/following-sibling::div//div[@class='selector-pagination']//span[@class='scroll-right scroll-active float-right']/i")
	public WebElement enabled_right_arrow_on_paginator_on_tsd;

	// ==========(4)paginator_on_Test Score Over Time_under_Test Score Tab==========
	@FindBy(xpath = "//span[contains(text(),'Test Scores Over Time')]/ancestor::div[@class='class_widget_title test_score_overtime overrightinfostyle']/following-sibling::div//div[@class='selector-pagination']")
	public WebElement paginator_on_tsot;

	@FindBy(xpath = "//span[contains(text(),'Test Scores Over Time')]/ancestor::div[@class='class_widget_title test_score_overtime overrightinfostyle']/following-sibling::div//div[@class='selector-pagination']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_tsot;

	@FindBy(xpath = "//span[contains(text(),'Test Scores Over Time')]/ancestor::div[@class='class_widget_title test_score_overtime overrightinfostyle']/following-sibling::div//div[@class='selector-pagination']//span[@class='scroll-left float-left scroll-active ']/i")
	public WebElement enabled_left_arrow_on_paginator_on_tsot;

	// ==========(5)paginator_on_tso_under_Test Score Tab_under_student==========
	// Pagination not found till yet for any login
	@FindBy(xpath = "//span[contains(text(),'Test Score Overview')]/ancestor::div[contains(@class,'student_testscores_widget_title_main')]/following-sibling::div//div[@class='selector-pagination']")
	public WebElement paginator_on_tso_under_ts_under_student;

	@FindBy(xpath = "//span[contains(text(),'Test Score Overview')]/ancestor::div[contains(@class,'student_testscores_widget_title_main')]/following-sibling::div//div[@class='selector-pagination']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_tso_under_ts_under_student;

	@FindBy(xpath = "//span[contains(text(),'Test Score Overview')]/ancestor::div[contains(@class,'student_testscores_widget_title_main')]/following-sibling::div//div[@class='selector-pagination']//span[@class='scroll-right scroll-active float-right']/i")
	public WebElement enabled_right_arrow_on_paginator_on_tso_under_ts_under_student;

	// ==========(6)paginator_on_STA==========
	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list']//div[@class='PaginationBlock']")
	public WebElement paginator_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list']//div[@class='PaginationBlock']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list']//div[@class='PaginationBlock']//span[contains(@class,'scroll-right float-right scroll-active')]/i")
	public WebElement enabled_right_arrow_on_paginator_on_sta;

	// ==========(7)paginator_on_Summary_under_Test_Status==========		
	@FindBy(xpath = "//div[contains(@class,'testStatus_paginationBlock')]")
	public WebElement paginator_on_summary_in_ts;

	@FindBy(xpath = "//div[@class='testStatus_pagination']//div[@class='table-and-graph-pagination-inr']//ul[@class='page-circle-list']//span")
	public List<WebElement> circle_list_on_paginator_on_summary_in_ts;

	@FindBy(xpath = "//div[@class='testStatus_pagination']//span[@class='scroll-right scroll-active float-right']/i")
	public WebElement enabled_right_arrow_on_paginator_on_summary_in_ts;

	// =================================================================================

	@FindBy(xpath = "//*[name()='text' and @transform='rotate(-45)']")
	public List<WebElement> testNamesonPerPage_onlinechart;

	@FindBy(xpath = "//*[name()='text' and @transform]/preceding-sibling::*[name()='polygon']")
	public List<WebElement> diamondshapesymblonPerPage_onlinechart;

	@FindBy(xpath = "//*[name()='text' and @transform]/preceding-sibling::*[name()='polygon' and @fill='#606060']")
	public WebElement highlightedtestName_onlinechart;

	@FindBy(xpath = "//*[name()='text' and @transform]/preceding-sibling::*[name()='polygon' and @fill='#00539B']")
	public WebElement highlightedtestName_onlinechart_on_tsot;

	@FindBy(xpath = "//*[name()='text' and @transform]/preceding-sibling::*[name()='polygon' and @fill='#606060']")
	public WebElement highlightedtestName_onlinechart_on_pot;

	@FindBy(xpath = "//div[@class='graph_tooltip_content']")
	public WebElement testNametooltip_onlinechart;

	@FindBy(xpath = "//div[@class='class_test_overview_table_header_left']//div[@class='bec_tooltip_content']")
	public WebElement tooltip_text_of_test_name_on_tsd;

	@FindBy(xpath = "//div[@class='comparison-block text-center']/following-sibling::div//*[name()='circle' and @fill]/following-sibling::*[name()='text']")
	public List<WebElement> testScoresonPerPage_onlinechart;

	@FindBy(xpath = "//span[contains(text(),'Performance Over Time')]/ancestor::div[contains(@class,'sidewidget-header')]/following-sibling::div/div/div[@style]//*[name()='circle' and @fill]/following-sibling::*[name()='text']")
	public List<WebElement> testScoresonPerPage_on_pot;

	@FindBy(xpath = "//div[@class='comparison-block text-center']/following-sibling::div//*[name()='circle' and @fill]")
	public List<WebElement> testScoreCircleClronPerPage_onlinechart;

	@FindBy(xpath = "//span[contains(text(),'Performance Over Time')]/ancestor::div[contains(@class,'sidewidget-header')]/following-sibling::div/div/div[@style]//*[name()='circle' and @fill]")
	public List<WebElement> testScoreCircleClronPerPage_pot;

	@FindBy(xpath = "//div[@class='tooltip_row_cmp_percentage']")
	public WebElement tooltiprowpercent_onlinechart;

	@FindBy(xpath = "//div[@class='overview-table-left-inner text-rotate']")
	public WebElement yaxislabelonstndrdperformanceinclass;

	@FindBy(xpath = "//div[@class='performance-indicator']/ancestor::div[@class='overview-table-col greenBg']/preceding-sibling::div/span")
	public WebElement achlvl80ormorewithgreenclr;

	@FindBy(xpath = "//div[@class='performance-indicator']/ancestor::div[@class='overview-table-col yellowBg']/preceding-sibling::div/span")
	public WebElement achlvl60_79withyellowclr;

	@FindBy(xpath = "//div[@class='performance-indicator']/ancestor::div[@class='overview-table-col orangeBg']/preceding-sibling::div/span")
	public WebElement achlvl40_59withorangeclr;

	@FindBy(xpath = "//div[@class='performance-indicator']/ancestor::div[@class='overview-table-col redBg']/preceding-sibling::div/span")
	public WebElement achlvlbelow40withredclr;

	@FindBy(xpath = "//span[@class='greenColor']/i[@class='material-icons' and contains(text(),'arrow_drop_up')]")
	public WebElement greenuparrow;

	@FindBy(xpath = "//span[@class='redColor']/i[@class='material-icons' and contains(text(),'arrow_drop_up')]")
	public WebElement reduparrow;

	@FindBy(xpath = "//span[@class='redColor']/i[@class='material-icons' and contains(text(),'arrow_drop_down')]")
	public WebElement reddownarrow;

	@FindBy(xpath = "//div[@class='overview-table-col' and @style]//div[contains(@class,'overview-table-col-inr-grd')]")
	public List<WebElement> strandnameslist;
	
	@FindBy(xpath = "//div[@class='bec_compare_multi_list_header_strands_list']//div[@class='bec_compare_multi_list_header_strands_single']")
	public List<WebElement> testnames_on_comparison_tab;

	@FindBy(xpath = "//div[@class='overview-table-col' and @style and contains(text(),'Avg')]")
	public List<WebElement> strandavglist;

	@FindBy(xpath = "//div[@class='overview-table-col']/div[@class='overview-table-innr-grd-col-head-guard']//div[@class='bec_tooltip_content']")
	public WebElement strandnamestooltip;

	@FindBy(xpath = "//div[@class='overview-table-col']//li[not(contains(@class,'StandardsNotAvailable'))]")
	public List<WebElement> standardnameslist;

	@FindBy(xpath = "//div[@class='overview-table-col']/div[@class='overview-table-innr-grd-col-head-guard']/div[2]")
	public List<WebElement> groupingstripclrlist;

	@FindBy(xpath = "//div[@class='overview-table-bar avarage-bar']/div[@class='overview-table-col' and @style]")
	public List<WebElement> averagelist;

	@FindBy(xpath = "//div[@class='overview-table-col']/div[@class='overview-table-innr-grd-col-head-guard']//div[@class='bec_tooltip_content']")
	public List<WebElement> strandtooltiplist;

	@FindBy(xpath = "//span[@class='scroll-left scroll-active']/i[contains(text(),'chevron_right')]")
	public WebElement enabledrightarrow;
	
	@FindBy(xpath = "//div[contains(@class,'bec_compare_multi_list_header_arrow_enable')]//i[@class='material-icons' and contains(text(),'chevron_right')]")
	public WebElement enabled_right_arrow_on_comparison_tab;

	@FindBy(xpath = "//i[@class='material-icons' and contains(text(),'show_chart')]")
	public WebElement performance_overtime_icon;

	@FindBy(xpath = "//i[@class='material-icons' and contains(text(),'show_chart')]/ancestor::span/following-sibling::span[@class='sidewidget-header-title']")
	public WebElement performanceovrtimeheader;

	@FindBy(xpath = "//span//img[contains(@style,'margin-top: -4px')]")
	public WebElement info_icon_on_performance_over_time_header;

	@FindBy(xpath = "//span//img[contains(@style,'margin-top: 5px')]")
	public WebElement info_icon_on_performance_over_time;

	@FindBy(xpath = "//div[@class='infoIconTooltipBlockInr']")
	public WebElement tooltip_of_info_icon;

	@FindBy(xpath = "//div[@class='float-left widget-base-block-title text-center']/span[not(@class)]")
	public WebElement strand_name_in_pot_line_chart;

	@FindBy(xpath = "//*[contains(text(),'Test Scores Over Time')]")
	public WebElement testscoreovertimelinechart;

	@FindBy(xpath = "//*[contains(text(),'Test Scores over Time')]")
	public WebElement testscoreovertimetext_underschool_undertest;

	@FindBy(xpath = "//*[contains(text(),'Test Score Detail')]")
	public WebElement testscoredetail;

	@FindBy(xpath = "//div[@class='student-list-body']/div[@class='student-list-row']")
	public List<WebElement> noofstudentsinlist;

	@FindBy(xpath = "//*[name()='tspan' and @x='-145' and contains(text(),'Test Scores (%)')]")
	public WebElement testScoresPercentage;

	@FindBy(xpath = "//div[@class='class_widget_title test_score_overtime']/following-sibling::div//*[name()='tspan' and contains(text(),'Test Scores (%)')]")
	public WebElement testScoresPercentageon_tsot;

	@FindBy(xpath = "//div[@class='studentTestscoreOvertimeChart']//*[name()='tspan' and contains(text(),'Test Scores (%)')]")
	public WebElement testScoresPercentageon_tso;

	@FindBy(xpath = "//*[name()='tspan' and contains(text(),'100')]")
	public WebElement hundredtextontsot;

	@FindBy(xpath = "//div[@class='tooltip_main']//div[@class='tooltip_title']")
	public WebElement testnameontooltip;

	@FindBy(xpath = "//div[@class='class_test_overview_table_header_right']//span")
	public WebElement submitteddateon_tsd;

	@FindBy(xpath = "//div[@class='tooltip_questions']//span/a")
	public List<WebElement> questionlistontooltip;

	@FindBy(xpath = "//div[@class='tooltip_main']//div[@class='tooltip_questions_right']")
	public WebElement questionlistarea;

	@FindBy(xpath = "//div[@class='tooltip_row_lelft']//div")
	public WebElement studentscoreleftcontentontt;

	@FindBy(xpath = "//div[@class='tooltip_row_right']//div")
	public WebElement studentscorerightcontentontt;

	@FindBy(xpath = "//div[contains(@class,'class_widget_title test_score_overtime')]/following-sibling::div//*[name()='circle']/following-sibling::*[name()='text']")
	public List<WebElement> testScoreValueInCircle_onlinechart_tsot;

	@FindBy(xpath = "//span[contains(text(),'Test Score Overview')]/ancestor::div[@class='student_testscores_widget_title_main']/following-sibling::div//*[name()='circle']/following-sibling::*[name()='text']")
	public List<WebElement> testScoreValueInCircle_onlinechart_tso;

	@FindBy(xpath = "//div[@class='line_chart_graph' and not(@style)]//*[name()='g']//*[name()='circle']/following-sibling::*[name()='text']")
	public List<WebElement> testScoreValueInCircle_onlinechart_pot;

	@FindBy(xpath = "//span[@class='progress-text' and contains(text(),'All')]/preceding-sibling::span[@class='progress-number grey']")
	public WebElement textingraystripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-text' and contains(text(),'< 40%')]/preceding-sibling::span[@class='progress-number red']")
	public WebElement textinredstripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-text' and contains(text(),'40-59%')]/preceding-sibling::span[@class='progress-number orange']")
	public WebElement textinorangestripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-text' and contains(text(),'60-79%')]/preceding-sibling::span[@class='progress-number yellow']")
	public WebElement textinyellowstripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-text' and contains(text(),'80% ≥')]/preceding-sibling::span[@class='progress-number green']")
	public WebElement textingreenstripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-number grey']/following-sibling::span[@class='progress-text']")
	public WebElement textoutgraystripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-number red']/following-sibling::span[@class='progress-text']")
	public WebElement textoutredstripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-number orange']/following-sibling::span[@class='progress-text']")
	public WebElement textoutorangestripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-number yellow']/following-sibling::span[@class='progress-text']")
	public WebElement textoutyellowstripinstudentlist;

	@FindBy(xpath = "//span[@class='progress-number green']/following-sibling::span[@class='progress-text']")
	public WebElement textoutgreenstripinstudentlist;

	@FindBy(xpath = "//div[contains(text(),'School Average Scores: ')]/following-sibling::div[@class='class_test_overview_table_progress_bar_list']/ul/li/span")
	public List<WebElement> schoolcolouredStripOnStudentList;

	@FindBy(xpath = "//div[contains(text(),'District Average Scores: ')]/following-sibling::div[@class='class_test_overview_table_progress_bar_list']/ul/li/span")
	public List<WebElement> districtcolouredStripOnStudentList;

	@FindBy(xpath = "//div[contains(text(),'Class Average Scores: ')]/following-sibling::div[@class='class_test_overview_table_progress_bar_list']/ul/li/span[1]")
	public List<WebElement> classcolouredStripOnStudentList;

	@FindBy(xpath = "//span[contains(text(),'Average Score:')]/ancestor::div[@class='standard-widget active-widget']//div[@class='class_test_overview_table_progress_bar_list']/ul/li")
	public List<WebElement> avg_score_colouredStripOnStudentList;

	@FindBy(xpath = "//div[@class='class_test_overview_table_progress_bar_list']/ul/li/span[contains(@class,'progress-number')]")
	public List<WebElement> TextInStripOnStudentList;

	@FindBy(xpath = "//div[@class='selector-pagination']/div[@class='PaginationBubblesClassTestScoreDetailTable mx-auto']")
	public WebElement paginator_onstudentlist;

	@FindBy(xpath = "//div[@class='selector-pagination']/div[@class='PaginationBubblesClassTestScoreDetailTable mx-auto']//div//ul[@class='page-circle-list']//span")
	public List<WebElement> studentlistpaginationcirclelist;

	@FindBy(xpath = "//div[@class='selector-pagination']/div[@class='PaginationBubblesClassTestScoreDetailTable mx-auto']//div/following-sibling::span[@class='scroll-right scroll-active float-right']/i")
	public WebElement studentlistenabledrightarrow;

	@FindBy(xpath = "//div[@class='selector-pagination']/div[@class='PaginationBubblesClassTestScoreDetailTable mx-auto']//div/following-sibling::span[@class='scroll-right float-right scroll-disable']/i")
	public WebElement studentlistdisabledrightarrow;

	@FindBy(xpath = "//div[@class='selector-pagination']/div[@class='PaginationBubblesClassTestScoreDetailTable mx-auto']/span[@class='scroll-left float-left scroll-active ']/i")
	public WebElement studentlistenabledleftarrow;

	@FindBy(xpath = "//div[@class='student-list-body']/div[@class='student-list-row']")
	public List<WebElement> student_list_on_list;

	@FindBy(xpath = "//span[@class='sidewidget-header-title' and contains(text(),'Student List')]/preceding-sibling::span[@class='sidewidget-header-icon']")
	public WebElement studentlisticon;

	@FindBy(xpath = "//div[@class='standard_perfom_tooltip']//span[@class='strand_Definition']")
	public List<WebElement> stranddefinitionlist;

	@FindBy(xpath = "//div[@class='standard_perfom_tooltip']//span[@class='standard_sub_Definition']")
	public List<WebElement> standardsubdefinitionlist;

	@FindBy(xpath = "//div[@class='standard_perfom_tooltip']//span[@class='strand_Description']")
	public List<WebElement> standarddescriptionlist;

	@FindBy(xpath = "//div[@class='widget-base-sub-title text-center']/preceding-sibling::div[2]/span[not(@class)]")
	public WebElement studentlistheader;

	@FindBy(xpath = "//div[@class='widget-base-sub-title text-center']/preceding-sibling::div[2]/span[not(@style)]")
	public WebElement pot_header;

	@FindBy(xpath = "//div[@class='widget-base-sub-title text-center']")
	public WebElement performanceovertimeheader;

	@FindBy(xpath = "//div[@class='widget-base-sub-title text-center']/preceding-sibling::div[1]/span[contains(@style,'text-align')]")
	public WebElement studentlistsubheader;

	@FindBy(xpath = "//div[@class='widget-base-sub-title text-center']/preceding-sibling::div[1]/span[contains(@style,'text-align')]")
	public WebElement pot_subheader;

	@FindBy(xpath = "//div[@class='class_test_overview_table_header_left']")
	public WebElement testNameOnTestScoreDetail;

	@FindBy(xpath = "//div[@class='class_test_overview_table_header_right']/span")
	public WebElement selectedTestSubmittedDate;

	@FindBy(xpath = "//div[@class='class_test_overview_table_header_left']//div[@class='bec_tooltip_content']")
	public WebElement tooltipOftestNameOnTestScoreDetail;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'Students')]")
	public WebElement StudentRecordsSize;

	@FindBy(xpath = "//div[@class='student-list-header']//div[@class='student-list-col']/span[@class='student-list-col-head-name']")
	public List<WebElement> list_header_in_list;

	@FindBy(xpath = "//div[@class='student-list-body']/div[@class='student-list-row']/div[@class='student-list-col'][1]")
	public List<WebElement> studentnameslistinstudentlist;

	@FindBy(xpath = "//div[@class='student-list-body']/div[@class='student-list-row']/div[@class='student-list-col'][2]")
	public List<WebElement> noofquestionsorsubmitdatelistinstudentlist;

	@FindBy(xpath = "//div[@class='student-list-body']/div[@class='student-list-row']//span[contains(@class,'student-list')]")
	public List<WebElement> studentscorelistinstudentlist;

	@FindBy(xpath = "//span[@class='student-list-col-head-name active-student-list-col-head-name' and contains(text(),'Students')]/following-sibling::span/i[@class='material-icons' and contains(text(),'expand_less')]")
	public WebElement studentListnameuparrow;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'Students')]/following-sibling::span//i[contains(text(),'expand_more')]")
	public WebElement studentListnamedownarrow;

	@FindBy(xpath = "//span[@class='student-list-col-head-name active-student-list-col-head-name' and contains(text(),'No. of Qns')]/following-sibling::span/i[@class='material-icons' and contains(text(),'expand_less')]")
	public WebElement studentListquestionuparrow;

	@FindBy(xpath = "//div[@class='class_test_overview_table_progress_bar_title' and contains(text(),'School Average Scores:')]")
	public WebElement schoolAvgScrInClassInTS;

	@FindBy(xpath = "//div[@class='class_test_overview_table_progress_bar_title' and contains(text(),'Class')]")
	public WebElement classAvgScrInClassInTS;

	@FindBy(xpath = "//div[@class='class_test_overview_table_progress_bar_title' and contains(text(),'District Average Scores')]")
	public WebElement districtAvgScrInClassInTS;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'No. of Qns')]/following-sibling::span//i[contains(text(),'expand_more')]")
	public WebElement studentListquestiondownarrow;

	@FindBy(xpath = "//span[@class='student-list-col-head-name active-student-list-col-head-name' and contains(text(),'Score')]/following-sibling::span/i[@class='material-icons' and contains(text(),'expand_less')]")
	public WebElement studentListscoreuparrow;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'Score')]/following-sibling::span//i[contains(text(),'expand_more')]")
	public WebElement studentListscoredownarrow;

	@FindBy(xpath = "//div[contains(text(),'Test Names')]")
	public WebElement testNamesLabelOnLineChart;

	@FindBy(xpath = "//span[@class='comparisonSingleTitle' and contains(text(),'School')]")
	public WebElement compareschoollabel;

	@FindBy(xpath = "//span[@class='comparisonSingleTitle' and contains(text(),'District')]")
	public WebElement comparedistrictlabel;

	@FindBy(xpath = "//span[@class='comparisonSingleTitle' and contains(text(),'Class')]")
	public WebElement compareclasslabel;

	@FindBy(xpath = "//li[@class='compareCheckBoxesSingleUI school-compare']//input[@value='on']/ancestor::label")
	public WebElement selectedcompareschoollabel;

	@FindBy(xpath = "//span[contains(text(),'District')]/ancestor::li[@class='compareCheckBoxesSingleUI district-compare activeCompare']/label")
	public WebElement selectedcomparedistrictlabel;

	@FindBy(xpath = "//span[contains(text(),'Class')]/ancestor::li[@class='compareCheckBoxesSingleUI class-compare activeCompare']/label")
	public WebElement selectedcompareclasslabel;

	@FindBy(xpath = "//div[@class='comparison-block text-center']/following-sibling::div//*[name()='path' and @stroke-dasharray='2,2' and @class='vx-linepath LinePath_SchoolCompare']")
	public WebElement schoolpath;

	@FindBy(xpath = "//div[@class='comparison-block text-center']/following-sibling::div//*[name()='path' and @stroke-dasharray='2,2' and @class='vx-linepath LinePath_ClassCompare']")
	public WebElement classpath;

	@FindBy(xpath = "//div[@class='comparison-block text-center']/following-sibling::div//*[name()='path' and @stroke-dasharray='4,4' and @class='vx-linepath LinePath_DistrictCompare']")
	public WebElement districtpath;

	@FindBy(xpath = "//*[.='No. of Qns']")
	public WebElement noofquestionstext;

	@FindBy(xpath = "//*[.='Students']")
	public WebElement studentstextinstudentlist;

	@FindBy(xpath = "//span[contains(text(),'Date Submitted')]")
	public WebElement datesubmittedtext;

	@FindBy(xpath = "//span[contains(text(),'Test Score Overview')]")
	public WebElement testscoreoverviewtext;

	@FindBy(xpath = "//span[contains(text(),'Standards (')]")
	public WebElement summary_tab_standars_text;
	
	@FindBy(xpath = "//div[@class='bec_compare_multi_list']//div[@class='bec_compare_multi_list_header_label' and text()='Tests']")
	public WebElement comparison_tab_tests_text;
	
	@FindBy(xpath = "//div[@class='bec_compare_multi_list_header_label']/span")
	public WebElement comparison_tab_sp_text;

	@FindBy(xpath = "//div[@class='standard-grid-filter-view']/div[@class='standard-grid-filter-view-label' and contains(text(),'Test(s) assessed for:')]/following-sibling::div/button")
	public WebElement gradeDropDown;

	@FindBy(xpath = "//div[@class='standard-grid-filter-view']/div[contains(text(),'Assessed with:')]/following-sibling::div/button")
	public WebElement questionDropDown;

	@FindBy(xpath = "//div[@class='standard-grid-filter-view']/div[contains(text(),'View :')]/following-sibling::div/button")
	public WebElement viewDropDown;
	
	@FindBy(xpath = "//div[@class='standard-grid-filter-single-item']")
	public List<WebElement> viewDropDownList;
	
	@FindBy(xpath = "//div[@class='standard-grid-filter-single-item']//div[@class='bec_tooltip_content']")
	public List<WebElement> viewDropDownTTTList;

	@FindBy(xpath = "//div[@class='standard-grid-filter-view']/div[contains(text(),'View :')]/following-sibling::div/button//div[@class='bec_tooltip_content']")
	public WebElement viewDropDownToolTipText;

	@FindBy(xpath = "//span[@class='printIcon']//img")
	public WebElement printIcon;

	@FindBy(xpath = "//span[@class='testScorePrint']//img")
	public WebElement Test_score_detail_printIcon;

	@FindBy(xpath = "//div[@class='standard-grid-filter-view']/div[@class='standard-grid-filter-view-label' and contains(text(),'Test(s) assessed for:')]/following-sibling::div//div//ul/li/div")
	public List<WebElement> gradeList;

	@FindBy(xpath = "//div[contains(text(),'No data available!')]")
	public WebElement nodatavailable;

	@FindBy(xpath = "//div[contains(text(),'No data available for your selection.')]")
	public WebElement nodatavailableforyourselection;

	@FindBy(xpath = "//h1[.='Benchmark Universe']")
	public WebElement beclogo;

	@FindBy(xpath = "//div[contains(text(),'Take me back')]")
	public WebElement takemeback;

	@FindBy(xpath = "//div[contains(text(),'Return to previous report')]")
	public WebElement returntopreviousreport;

	/**
	 * Print PDF Sections Xpath
	 */
	@FindBy(xpath = "//div[@class='print_pdf_logo']/img")
	public WebElement pdfLogo;

	@FindBy(xpath = "//div[@class='print_pdf_context_header']//div[@class='print_pdf_header_row']/ul/li/span/b")
	public List<WebElement> headerRowList;

	@FindBy(xpath = "//div[@class='testScore_printPDF_context_header']//div[contains(@class,'testScore_printPDF_header_row')]/ul/li/span")
	public List<WebElement> test_score_detail_headerRowList;

	/**
	 * Grouping Tab
	 * 
	 */
	@FindBy(xpath = "//li[contains(text(),'Grouping')]")
	public WebElement groupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_header_text']")
	public WebElement groupingTabText;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_row_label' and contains(text(),'Select Strands:')]/ancestor::div[@class='bec_groups_popup_modal_row_left_txt']/following-sibling::span[@class='group-data-reload']//i[contains(text(),'cached')]")
	public WebElement strandSelectRefreshIconTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_row_label' and contains(text(),'Assessed with :')]/ancestor::div[@class='bec_groups_popup_modal_row_left_txt']/following-sibling::span[@class='group-data-reload']//i[contains(text(),'cached')]")
	public WebElement AssessedWithRefreshIconTab;

	@FindBy(xpath = "//div[@class='bec_group_multi_list_header_label']")
	public WebElement strandsTextAfterApplyBtnOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_submit_button']//button[contains(text(),'Apply')]")
	public WebElement applyBtnOngroupingTab;
	
	@FindBy(xpath = "//div[@class='bec_compares_popup_modal_submit_button']//button[contains(text(),'Apply')]")
	public WebElement applyBtnOnstandardTab;
	
	@FindBy(xpath = "//div[@class='Beneath_Strands']")
	public WebElement beneath_strands_on_standards_pop_up;

	@FindBy(xpath = "//div[contains(text(),' Test(s) assessed for : ')]/ancestor::div[@class='bec_groups_popup_modal_row']//div[@class='bec_groups_popup_dropdown_main']/button")
	public WebElement testAssessedForGradeGroupingTab;

	@FindBy(xpath = "//div[contains(text(),'Assessed with :')]/ancestor::div[@class='bec_groups_popup_modal_row']//div[@class='bec_groups_popup_dropdown_main']/button")
	public WebElement assessedWithGroupingTab;

	@FindBy(xpath = "//div[contains(text(),'Select Strands:')]/ancestor::div[@class='bec_groups_popup_modal_row']//div[@class='bec_groups_popup_dropdown_main']/button")
	public WebElement selectStrandsOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_row_full_length']")
	public WebElement noteOnGroupingTab;

	@FindBy(xpath = "//button[@class='btn universal-selector-applyfilter']")
	public WebElement doneBtnOnSelectStrandOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_dropdown_strands-cancel-btn float-left' and contains(text(),'Cancel')]")
	public WebElement cancelBtnOnSelectStrandOnGroupingTab;

	@FindBy(xpath = "//span[contains(text(),'Select All')]")
	public WebElement selectAllchkboxOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_row_label' and contains(text(),'Number of Groups')]")
	public WebElement noofgroupsLabelOnGroupingTab;

	@FindBy(xpath = "//i[@class='material-icons' and contains(text(),'remove_circle_outline')]")
	public WebElement minusIconOfnoofgroupsLabelOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_row_dropdown_fieldBox']//input[@type='text' and @value]")
	public WebElement textOfnoofgroupsLabelOnGroupingTab;

	@FindBy(xpath = "//i[@class='material-icons' and contains(text(),'add_circle_outline')]")
	public WebElement plusIconOfnoofgroupsLabelOnGroupingTab;

	@FindBy(xpath = "//span[@class='bec_groups_popup_modal_tooltip']//img")
	public WebElement tooltipIconOf_group_by_LabelOnGroupingTab;

	@FindBy(xpath = "//li[@class='activeGroupPopupRadio']//span[@class='bec_groups_popup_modal_radio_label']")
	public WebElement selectedGrpNameOnUI;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_row']//span[contains(text(),'Group by')]")
	public WebElement GrpByTextOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_group_tab_main']//span[contains(text(),'Group by')]")
	public WebElement GrpByTextOnUI;

	@FindBy(xpath = "//div[@class='bec_group_tab_header_block_edit_label']//span[contains(text(),'Edit Groups')]")
	public WebElement EditGrpTextOnUI;

	@FindBy(xpath = "//span[@class='printIcon']/img")
	public WebElement printIconforGroupDataOnUI;

	@FindBy(xpath = "//span[@class='bec_group_multi_list_sub_header_avg_score_label' and contains(text(),'Average % Score')]")
	public WebElement avgperScoreOnGroupingTable;

	@FindBy(xpath = "//div[@class='bec_group_multi_list_Single_group_header']")
	public List<WebElement> groupHeaderListonGroupingTabPage;

	@FindBy(xpath = "//span[@class='bec_group_multi_list_Single_group_body_row_student_name_Name']")
	public List<WebElement> studentListonGroupingTabPage;

	@FindBy(xpath = "//div[@class='bec_group_multi_list']//span[@class='bec_group_multi_list_sub_header_label_title']")
	public WebElement groupAndStudentInfoOnGroupingTabPage;

	@FindBy(xpath = "//div[@class='bec_groups_move_student_popup_title']")
	public WebElement movingTxtonModelOnGroupingTable;

	@FindBy(xpath = "//button[@class='bec_groups_move_student_popup_submit_actions_apply']")
	public WebElement moveBtnonModelOnGroupingTable;

	@FindBy(xpath = "//div[contains(text(),' Test(s) assessed for : ')]/ancestor::div[@class='bec_groups_popup_modal_row']//div[@class='bec_groups_popup_dropdown_main']//div[@class='groupingtab_single_dropdown_element']")
	public List<WebElement> testAssessedForGradeListGroupingTab;

	@FindBy(xpath = "//div[@class='bec_groups_move_student_popup_modal_main_inr_groups_single_row_group_name']")
	public List<WebElement> NoOfGrpsononModelOnGroupingTable;

	@FindBy(xpath = "//span[@class='bec_group_multi_list_Single_group_body_row_student_name_Name' and contains(text(),'Victor')]/ancestor::div[@class='bec_group_multi_list_Single_group_body_row_student_name']//div[@class='bec_groups_tab_tooltip_strand_score_single_line']")
	public List<WebElement> tooltipListOnGroupingTable;

	@FindBy(xpath = "//div[@class='bec_groups_popup_modal_main']//div[@class='bec_groups_popup_modal_row']//div[@class='bec_groups_popup_modal_row_radio_buttons']//span[@class='bec_groups_popup_modal_radio_label']")
	public List<WebElement> groupByListOnGroupingTab;

	@FindBy(xpath = "//div[contains(text(),'Assessed with :')]/ancestor::div[@class='bec_groups_popup_modal_row']//div[@class='bec_groups_popup_dropdown_main']//div[@class='groupingtab_single_dropdown_element']")
	public List<WebElement> assessedWithListGroupingTab;

	@FindBy(xpath = "//div[contains(@class,'bec_groups_popup_dropdown_label')]")
	public List<WebElement> selectStrandsListInDropdownGroupingTab;

	@FindBy(xpath = "//div[@class='Beneath_Strands']//div")
	public List<WebElement> selectedStrandsListOnGroupingTab;

	@FindBy(xpath = "//div[@class='bec_group_multi_list_header_strands_single']")
	public List<WebElement> groupingTableHeaderList;

	@FindBy(xpath = "//span[@class='bec_group_multi_list_Single_group_body_row_student_name_Name']")
	public List<WebElement> studentNamesOnGroupingTable;

	@FindBy(xpath = "//span[@class='bec_group_multi_list_Single_group_body_row_student_swap']//i[contains(text(),'swap_vert')]")
	public List<WebElement> visibleArrowListOnGroupingTable;

	@FindBy(xpath = "//span[@class='student-list-col-head-name']")
	public List<WebElement> classORSchoolListPageHeadersList;

	@FindBy(xpath = "//div[@class='student-list-row']//div[@class='student-list-col'][1]")
	public List<WebElement> classORSchoolNamesListInClassListPageHeaders;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'Class')]//span[@class='standard_perfomance_list_head_tooltip_Definition']")
	public WebElement classListPageTooltipForClass;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'School')]//span[@class='standard_perfomance_list_head_tooltip_Definition']")
	public WebElement schoolListPageTooltipForClass;

	@FindBy(xpath = "//span[@class='student-list-col-head-name' and contains(text(),'% Students Complete')]//span[@class='standard_perfomance_list_head_tooltip_Definition']")
	public WebElement classORSchoolListPageTooltipForStuCmplt;

	/** STA **/
	@FindBy(xpath = "//div[@class='bec_singleTest_Selected_Filter_data']//ul/li/span[.='question']/preceding-sibling::span/div[@class='bec_singleTest_filter_Selected_radio_inr']")
	public WebElement selectedQuestionRB;

	@FindBy(xpath = "//div[@class='bec_singleTest_Selected_Filter_data']//ul/li/span[.='All']/preceding-sibling::span/div[@class='bec_singleTest_filter_Selected_checkbox_inr']")
	public WebElement selectedAllViewCB;

	@FindBy(xpath = "//div[@class='bec_singleTest_Selected_Filter_data']//ul/li/span[.='percentage']/preceding-sibling::span/div[@class='bec_singleTest_filter_Selected_radio_inr']")
	public WebElement selectedPercentageRB;

	@FindBy(xpath = "//div[contains(text(),'Test Average Score:')]/ancestor::div[@class='bec_singleTest_multi_list_subheader bec_singleTest_multi_list_grid_block']//div[@class='bec_singleTest_multi_list_single_compareBox']")
	public WebElement test_avg_score_value_in_sta_for_district;

	@FindBy(xpath = "//div[contains(@class,'bec_singleTest_multi_list_single_label') and contains(text(),'Test Average Score:')]")
	public WebElement test_avg_score_text_on_sta_table;
	
	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_single_q_number']")
	public List<WebElement> question_list_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_single_compareBox']//div[contains(@class,'bec_singleTest_multi_list_single_score ')]")
	public List<WebElement> district_wise_avg_list_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_Data_row']//div[@class='bec_singleTest_multi_list_single_compareBox']/div[contains(@class,'bec_singleTest_multi_list_single_score')]")
	public List<WebElement> district_avg_list_for_question_on_sta;

	@FindBy(xpath = "//span[@class='bec_singleTest_multi_list_name' and contains(text(),'District')]/ancestor::div[@class='bec_singleTest_multi_list_single_compareBox']/span/i[.='expand_more']")
	public WebElement district_expand_more_in_sta;

	@FindBy(xpath = "//span[@class='bec_singleTest_multi_list_name' and contains(text(),'District')]/ancestor::div[@class='bec_singleTest_multi_list_single_compareBox']/span/i[.='expand_less']")
	public WebElement district_expand_less_in_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_filter_title_inr' and .='Filter']")
	public WebElement filter_in_sta_for_district;

	@FindBy(xpath = "//span[@class='bec_singleTest_filter_radio_label text-capitalize' and .='view']/preceding-sibling::span")
	public WebElement view_rb_on_filter_in_sta;
	
	@FindBy(xpath = "//span[@class='bec_singleTest_filter_checkbox_label' and contains(text(),'All')]")
	public WebElement all_chkbox_on_filter_in_sta;

	@FindBy(xpath = "//span[contains(@class,'bec_singleTest_filter_checkbox_label')]")
	public List<WebElement> chkbox_list_text_under_view_on_sta_filter;
	
	@FindBy(xpath = "//li/div[contains(text(),'View:')]/ancestor::li//li/span[not(contains(text(),'All')) and contains(@class,'bec_singleTest_filter_checkbox') and not(contains(@class,'text'))]")
	public List<WebElement> chkbox_list_under_view_on_sta_filter;
	
	@FindBy(xpath = "//span[@class='bec_singleTest_filter_radio_label text-capitalize' and .='question']/preceding-sibling::span")
	public WebElement question_rb_on_filter_in_sta;

	@FindBy(xpath = "//span[@class='bec_singleTest_filter_radio_label text-capitalize' and .='raw']")
	public WebElement raw_rb_on_filter_in_sta;

	@FindBy(xpath = "//button[@class='btn bec_singleTest_popup_apply_filter_apply' and .='Apply']")
	public WebElement apply_button_on_filter_in_sta;
	
	@FindBy(xpath = "//button[@class='btn bec_singleTest_popup_apply_filter_cancel' and .='Cancel']")
	public WebElement cancel_button_on_filter_in_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_row bec_singleTest_multi_list_grid_block']")
	public List<WebElement> records_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_filter_popup_title']")
	public List<WebElement> filter_title_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_row bec_singleTest_multi_list_grid_block']//div/span[@style='cursor: pointer;']")
	public List<WebElement> short_values_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_row bec_singleTest_multi_list_grid_block']//div[@class='bec_singleTest_multi_list_single_grid']//div[contains(@class,'bec_singleTest_multi_list_single_score ')]")
	public List<WebElement> test_score_values_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_single_question text-left']//div[@class='bec_singleTest_questionList']")
	public List<WebElement> questions_values_on_sta;
	
	@FindBy(xpath = "//label[contains(@class,'bec_summary_checkbox_check')]")
	public List<WebElement> compare_cb_list_on_summary;

	@FindBy(xpath = "//span[@class='bec_singleTest_checkbox_label']")
	public List<WebElement> compare_cb_list_on_sta;
	
	@FindBy(xpath = "//label[contains(@class,'bec_compare_checkbox_check')]")
	public List<WebElement> compare_cb_list_on_comparison;
	
	@FindBy(xpath = "//div[contains(@class,'bec_singleTest_multi_list_single_taxonomy')]")
	public WebElement view_text_in_sta_table_header;
	
	@FindBy(xpath = "//span[@class='bec_compare_checkbox_label']")
	public List<WebElement> compare_cb_list_on_comparison_tab;
	
	@FindBy(xpath = "//div[@class='bec_compare_multi_list_sub_block_compare_row']//div[@class='bec_compare_multi_list_sub_block_compare_label']")
	public List<WebElement> compare_list_of_avg_on_comparison_tab;
	
	@FindBy(xpath = "//div[@class='bec_summary_multi_list_sub_block_compare_row']//div[@class='bec_summary_multi_list_sub_block_compare_label']")
	public List<WebElement> compare_list_of_avg_on_summary_tab;

	@FindBy(xpath = "//span[@class='bec_singleTest_multi_list_name']")
	public List<WebElement> compared_columns_list_on_table_on_sta;

	@FindBy(xpath = "//div[contains(@class,'bec_singleTest_multi_list_header ')]/div")
	public List<WebElement> view_columns_list_on_table_on_sta;

	@FindBy(xpath = "//div[@class='bec_singleTest_multi_list_Data_row']//span[@class='bec_singleTest_singleQuestion_Number']")
	public List<WebElement> single_question_in_question_column_on_table_on_sta;

	/** TODO xpaths for Test Status **/
	@FindBy(xpath = "//div[@class='testStatus_detail_body']")
	public WebElement table_body_in_detail_in_ts;
	
	@FindBy(xpath = "//div[@class='testStatus_studentContextMain']")
	public WebElement table_body_in_ts_under_student_context;

	@FindBy(xpath = "//span[@class='infoIconBlock']")
	public WebElement info_icon_in_ts;

	@FindBy(xpath = "//div[@class='infoIconTooltipBlockInr_TestStatus']")
	public WebElement tool_tip_on_info_icon_in_ts;

	@FindBy(xpath = "//div[@class='ar_breadcrumb_inr']/ul/li")
	public List<WebElement> subsectionlist_on_test_status;
	
	@FindBy(xpath = "//span[@class='testStatus_filter_tag_name']")
	public List<WebElement> filter_option_list_on_test_status_under_sc;

	@FindBy(xpath = "//div[@class='scrollTopBlock']/img")
	public WebElement jump_to_top_in_ts;

	@FindBy(xpath = "//span[contains(@class,'testStatus_numberFontSize') and not(text()='0')]")
	public List<WebElement> test_status_number_in_summary_in_ts;

	@FindBy(xpath = "//span[contains(@class,'testStatus_summmaryBlock_table_header_col_name')]")
	public List<WebElement> columns_header_in_summary_in_ts;

	@FindBy(xpath = "//div[@class='testStatus_summmaryBlock_table_body_col']//div")
	public List<WebElement> test_names_in_Test_Name_Column;

	@FindBy(xpath = "//div[contains(@class,'testStatus_not_started')]//span")
	public List<WebElement> not_started_numbers_in_not_started_column;

	@FindBy(xpath = "//div[contains(@class,'testStatus_in_progress')]//span")
	public List<WebElement> in_progress_numbers_in_in_progress_column;

	@FindBy(xpath = "//div[contains(@class,'testStatus_need_graded')]//span")
	public List<WebElement> needs_to_be_graded_numbers_in_needs_to_be_graded_column;

	@FindBy(xpath = "//div[contains(@class,'testStatus_complete')]//span")
	public List<WebElement> complete_numbers_in_complete_column;
	
	@FindBy(xpath = "//div[contains(@class,'testStatus_detail_assign_name')]")
	public List<WebElement> assessment_names_in_detail_section;

	@FindBy(xpath = "//span[contains(@class,'testStatus_numberFontSize testStatus_summmaryBlock_table_body_col_inr_grd_inr_span selectedTestStatus')]/ancestor::div[@class='testStatus_summmaryBlock_table_body']/preceding-sibling::div[@class='testStatus_summmaryBlock_table_header']//div[@class='testStatus_summmaryBlock_table_header_col_inr_grd testStatusActive']/span")
	public WebElement column_header_in_summary_in_ts;

	@FindBy(xpath = "//span[contains(@class,'testStatus_numberFontSize testStatus_summmaryBlock_table_body_col_inr_grd_inr_span selectedTestStatus')]/ancestor::div[@class='testStatus_summmaryBlock_table_body_col_guard']/div[@class='testStatus_summmaryBlock_table_body_col']//div")
	public WebElement selected_numbers_test_name_in_summary_in_ts;

	@FindBy(xpath = "//span[@class='testStatus_detail_status_title']/span[not(@class)]")
	public WebElement detail_title_status_in_ts;

	@FindBy(xpath = "//span[@class='testStatus_detail_status_title']/span[@class]")
	public WebElement detail_title_in_ts;

	@FindBy(xpath = "//span[contains(text(),'Test Name')]/following-sibling::div/span[contains(@class,'top')]")
	public WebElement test_name_up_arrow;

	@FindBy(xpath = "//span[contains(text(),'Test Name')]/following-sibling::div/span[contains(@class,'bottom')]")
	public WebElement test_name_down_arrow;

	@FindBy(xpath = "//span[contains(text(),'Not Started')]/following-sibling::div/span[contains(@class,'top')]")
	public WebElement not_started_up_arrow;

	@FindBy(xpath = "//span[contains(text(),'Not Started')]/following-sibling::div/span[contains(@class,'bottom')]")
	public WebElement not_started_down_arrow;

	@FindBy(xpath = "//span[contains(text(),'In Progress')]/following-sibling::div/span[contains(@class,'top')]")
	public WebElement in_progress_up_arrow;

	@FindBy(xpath = "//span[contains(text(),'In Progress')]/following-sibling::div/span[contains(@class,'bottom')]")
	public WebElement in_progress_down_arrow;

	@FindBy(xpath = "//span[contains(text(),'Needs to')]/following-sibling::div/span[contains(@class,'top')]")
	public WebElement needs_tbg_up_arrow;

	@FindBy(xpath = "//span[contains(text(),'Needs to')]/following-sibling::div/span[contains(@class,'bottom')]")
	public WebElement needs_tbg_down_arrow;

	@FindBy(xpath = "//span[contains(text(),'Complete')]/following-sibling::div/span[contains(@class,'top')]")
	public WebElement complete_up_arrow;

	@FindBy(xpath = "//span[contains(text(),'Complete')]/following-sibling::div/span[contains(@class,'bottom')]")
	public WebElement complete_down_arrow;

	@FindBy(xpath = "//div[@class='testStatus_detail_body_content_col' and contains(@style,'cursor')]")
	public List<WebElement> school_names_in_school_Column;

	@FindBy(xpath = "//div[@class='testStatus_detail_body_content_col' and contains(@style,'text-align')]/following-sibling::div[1]")
	public List<WebElement> start_dates_in_start_date_Column;

	@FindBy(xpath = "//div[@class='testStatus_detail_body_content_col' and contains(@style,'text-align')]/following-sibling::div[2]")
	public List<WebElement> due_dates_in_due_date_Column;

	@FindBy(xpath = "//span[contains(@class,'testStatus_detail_head_col') and text()='School']/ancestor::span/following-sibling::span//span[contains(@class,'top')]")
	public WebElement school_up_arrow;

	@FindBy(xpath = "//span[contains(@class,'testStatus_detail_head_col') and text()='School']/ancestor::span/following-sibling::span//span[contains(@class,'bottom')]")
	public WebElement school_down_arrow;

	@FindBy(xpath = "//span[contains(@class,'testStatus_detail_head_col') and text()='Start Date']/ancestor::span/following-sibling::span//span[contains(@class,'top')]")
	public WebElement start_date_up_arrow;

	@FindBy(xpath = "//span[contains(@class,'testStatus_detail_head_col') and text()='Start Date']/ancestor::span/following-sibling::span//span[contains(@class,'bottom')]")
	public WebElement start_date_down_arrow;

	@FindBy(xpath = "//span[contains(@class,'testStatus_detail_head_col') and text()='Due Date']/ancestor::span/following-sibling::span//span[contains(@class,'top')]")
	public WebElement due_date_up_arrow;

	@FindBy(xpath = "//span[contains(@class,'testStatus_detail_head_col') and text()='Due Date']/ancestor::span/following-sibling::span//span[contains(@class,'bottom')]")
	public WebElement due_date_down_arrow;

	// TODO Xpaths for STA Batch-Print

	@FindBy(xpath = "//*[@class='print_pdf_batch']/span/img")
	public WebElement print_pdf_batch_button;
	
	@FindBy(xpath = "//*[@class='testStatus_detail_print']/img")
	public WebElement pdf_print_button_in_test_status;
	
	@FindBy(xpath = "//*[@class='testStatusDataPrint']/img")
	public WebElement pdf_print_button_in_test_status_under_sc;	
	
	@FindBy(xpath = "//*[contains(text(),'Print Report Options:')]")
	public WebElement print_Report_Overlay_on_print_popup;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancel_button_on_popup;

	@FindBy(xpath = "//span[contains(@class,'batchPrint_checkbox')]")
	public WebElement standards_checkbox;

	@FindBy(xpath = "//div[@class='batchPrintContainer_bodyList']/ul/li/span[contains(@class,'batchPrint_radio')]")
	public List<WebElement> radio_buttons_under_batch_print;
	
	@FindBy(xpath = "//div[@class='testStatusPopup_inr_title' and contains(text(),'Report Level')]/ancestor::div[@class='testStatusPopup_left_inr']/div/ul/li/span[contains(@class,'testStatusPopup_radioButton')]")
	public List<WebElement> radio_buttons_under_report_level;
	
	@FindBy(xpath = "//div[@class='testStatusPopup_inr_title' and contains(text(),'Test Status')]/ancestor::div[@class='testStatusPopup_rightInr']/div/ul/li/span[contains(@class,'testStatusPopup_checkbox')]")
	public List<WebElement> checkbox_list_under_test_status;

	@FindBy(xpath = "//span[@class='batchPrintTitle']")
	public List<WebElement> selection_texts_on_model;
	
	@FindBy(xpath = "//span[@class='SpotPrintTitle']")
	public List<WebElement> texts_on_model_on_spot_print_popup;

	@FindBy(xpath = "//li[@class='inactive_tab']/span[contains(text(), 'Summary')]")
	public WebElement summarytab;
	
	@FindBy(xpath = "//li[@class='inactive_tab' and contains(text(), 'Comparison')]")
	public WebElement comparisontab;

	@FindBy(xpath = "//div[contains(text(),'Batch Print')]")
	public WebElement batch_print_title;
	
	@FindBy(xpath = "//div[@class='testStatusPopup_inr_title' and contains(text(),'Report Level')]")
	public WebElement report_level_title;
	
	@FindBy(xpath = "//div[@class='testStatusPopup_inr_title' and contains(text(),'Test Status')]")
	public WebElement test_status_title;

	@FindBy(xpath = "//div[contains(text(),'Show')]")
	public WebElement show_title_on_model;
	
	@FindBy(xpath = "//div[text()='View']")
	public WebElement view_title_on_model;

	@FindBy(xpath = "//button[text()='Print']")
	public WebElement print_button_on_popup;

	@FindBy(xpath = "//div[@class='bec_summary_taxonomy_standard-grid-filter-view']/div[contains(text(),'View :')]/following-sibling::div/button")
	public WebElement viewDropDown_on_summary;
	
	@FindBy(xpath = "//button[@class='bec_compares_popup_dropdown_selector']")
	public List<WebElement> dropDowns_on_edit_standards_on_pop_up;
	
	@FindBy(xpath = "//div[@class='bec_summary_taxonomy_standard-grid-filter-view']/div[contains(text(),'View :')]/following-sibling::div/button//div[@class='bec_summary_taxonomy_bec_tooltip_content']")
	public WebElement viewDropDownToolTipText_on_summary;

	@FindBy(xpath = "//div[@class='bec_compares_popup_dropdown_selectorList']/ul/li")
	public List<WebElement> viewDropDown_list_on_edit_standards_on_pop_up;
	
	@FindBy(xpath = "//div[@class='bec_summary_taxonomy_standard-grid-filter-single-item']")
	public List<WebElement> viewDropDownList_on_summary;
	
	@FindBy(xpath = "//span[@class='testStatus_filter_tag_name']")
	public List<WebElement> test_status_filter_list_under_sc;
	
	@FindBy(xpath = "//div[@class='testStatus_student_header_col']//div[contains(@class,'testStatus_student_header_col_name')]")
	public List<WebElement> table_header_list_under_sc;
	
	@FindBy(xpath = "//div[contains(@class,'statusIcon_not_started')]")
	public List<WebElement> not_started_list_in_table_under_sc;
	
	@FindBy(xpath = "//div[contains(@class,'statusIcon_in_progress')]")
	public List<WebElement> in_progress_list_in_table_under_sc;
	
	@FindBy(xpath = "//div[contains(@class,'statusIcon_need_to_be_graded')]")
	public List<WebElement> ntb_graded_list_in_table_under_sc;
	
	@FindBy(xpath = "//div[contains(@class,'statusIcon_completed')]")
	public List<WebElement> completed_list_in_table_under_sc;	

	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Test Name ']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_top')]")
	public WebElement test_name_up_arrow_in_table_under_sc;

	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Test Name ']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_bottom')]")
	public WebElement test_name_down_arrow_in_table_under_sc;
	
	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Start Date']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_top')]")
	public WebElement start_date_up_arrow_in_table_under_sc;

	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Start Date']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_bottom')]")
	public WebElement start_date_down_arrow_in_table_under_sc;

	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Due Date']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_top')]")
	public WebElement due_date_up_arrow_in_table_under_sc;

	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Due Date']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_bottom')]")
	public WebElement due_date_down_arrow_in_table_under_sc;
	
	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Submit Date']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_top')]")
	public WebElement submit_date_up_arrow_in_table_under_sc;

	@FindBy(xpath = "//div[contains(@class,'testStatus_student_header_col_name') and text()='Submit Date']/following-sibling::div/span[contains(@class,'testStatus_summmaryBlock_table_body_head_col_sort_bottom')]")
	public WebElement submit_date_down_arrow_in_table_under_sc;
	
	@FindBy(xpath = "//div[@class='testStatus_student_body_col' and not(@style)]//div[@class='testStatus_student_body_col_name']")
	public List<WebElement> test_names_in_table_under_sc;	
	
	@FindBy(xpath = "//div[@class='testStatus_student_body_col' and contains(@style,'text-align')]/following-sibling::div[1]")
	public List<WebElement> start_dates_in_table_under_sc;

	@FindBy(xpath = "//div[@class='testStatus_student_body_col' and contains(@style,'text-align')]/following-sibling::div[2]")
	public List<WebElement> due_dates_in_table_under_sc;
	
	@FindBy(xpath = "//div[@class='testStatus_student_body_col' and contains(@style,'text-align')]/following-sibling::div[3]")
	public List<WebElement> submit_dates_in_table_under_sc;
	
	@FindBy(xpath = "//div[@class='testStatus_detail_body_content_col' and contains(@style,'cursor')]")
	public List<WebElement> class_Names_under_details_in_Test_status;
	
	@FindBy(xpath="//div[@class='menu-title' and contains(text(),'School')]/following-sibling::div//div[@class='menu-dropdown-list-inr']/ul/li'")
    public List<WebElement> schooldropdownallcheckbox;
}
