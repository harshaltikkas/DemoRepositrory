@Feature
Feature: Sprint 8 and 10 User Stories

  ######## Sprint 8 User Stories ################
  ##BE-791,792,793,805,806
  Scenario: Verify Loading icon within the date tab after filtering the Roster Tab
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then verify Loading icon within the date tab after filtering the Roster Tab

  ##BE-808,809,810,811
  Scenario: Verify Start date and End Date for the Custom date selector always appears beneath the Date Range dropdown
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then verify Start date and End Date for the Custom date selector always appears beneath the Date Range dropdown

  ######## Sprint 10 User Stories ################
  ##BE-870,871(a),871(b)    
  Scenario: Verify Grouping, The appearance of the Grouping tab
    Given User is on portal's login screen with username as "teacher_three" and password as "password" and usertype as "realm_two"
    When User Click on Standard Performance tab within the Class Context
    Then verify Grouping, The appearance of the Grouping tab
    When User click on Student Context and Test Score button
    Then verify Grouping, The appearance of the Grouping tab
    When User Click on Standard Performance tab within the Student Context
    Then verify Grouping, The appearance of the Grouping tab
    When User click on Class Context and Test Score button
    Then verify Grouping, The appearance of the Grouping tab

  ##BE-872
  Scenario: Verify no appearance of the grouping tab for other than teacher
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then verify no appearance of the grouping tab for other than teacher

  ##BE-881
  Scenario: Verify Context header Updates - Test tab selections
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then verify Context header Updates - Test tab selections

   ##BE-901,902,903,904,905,906,909 
  Scenario: Verify Test Data assessed for Grade dropdown within the Grouping tab selection window
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    Then verify Test Data assessed for Grade dropdown within the Grouping tab selection window

  ##BE-910,911,912,913 
  Scenario: Verify To check The Strand and or Standard element of the grouping table within the grouping page
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    Then verify To check The Strand and or Standard element of the grouping table within the grouping page
