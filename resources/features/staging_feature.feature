@smoketest
Feature: Staging/Prod Test Scanarios to check UI functionality

  Scenario: Verify CSV download of Test Status report in School context
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Test Status tab within the School Context
    Then verify csv download functionality
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Test Status tab within the District Context
    Then verify csv download functionality

  Scenario: Verify the Print PDF of Test Status District
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Test Status tab within the District Context
    Then verify the Print PDF of Test Status District
    Given User is on portal's login screen with username as "stg_teacher_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Test Status tab within the Student Context
    Then verify the Print PDF of Test Status District
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Test Status tab within the School Context
    Then verify the Print PDF of Test Status District
    When User Click on Test Status tab within the Class Context
    Then verify the Print PDF of Test Status District

  Scenario: Verify The Persistence across level and reports of Standard Performance Overview
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    Then verify The Persistence across level and reports of Standard Performance Overview

  Scenario: Verify Standards Summary and Single Test Analysis Print Modal for Student Level
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Summary tab within the Student Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level
    When User Click on Single Test Analysis tab within the Student Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level
    Given User is on portal's login screen with username as "stg_teacher_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Summary tab within the Student Context
    And click and select view from dropdown
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    And User Click on Summary tab within the Student Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level

  Scenario: Verify the sorting with the arrows which are with heading elements
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Test tab within the Universal Selector Tab
    Then arrows with the elements within the test list should be sorted as follows

  Scenario: Verify Key Toggle - Single Test Analysis
    Given User is on portal's login screen with username as "stg_da_one" and password as "password" and usertype as "realm_stg_lausd"
    Then Verify the key toggle when user click on single test analysis tab and the other tab

  Scenario: Verify Adding Teacher label to Context Header for the School Admins
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    Then veryfy Teacher label to Context Header for the School Admins for teacher "Vincent Ortiz"

  ## DA - Verify the Universal Selector filters and Subway navigation changes when user logged in as DA
  Scenario: Verify Universal Selector filters when user logged in as District Admin
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    When User click on Roster tab and select single School and click apply
    And Verify User is switched to School and Class subway is enabled and Student subway is disabled
    Then Navigate back to District and click on Roster tab and select multiple Schools and click apply
    And Verify User is in District context and School subway is enabled and Class and Student subway are disabled
    When User click on Roster tab and select a School and one Teacher and one Class and click apply
    And Verify User is switched to Class and School and Student subway filters are enabled
    Then Navigate back to District and click on Roster tab and select a School and multiple Teachers and Classes and click apply
    And Verify User is switched to School and Class subway is enabled and Student subway is disabled
    Then Navigate back to District and click on Roster tab and select a School and Class and single Student and click apply
    And Verify User is switched to Student and School and Class subway filters are enabled
    Then Navigate back to District and click on Roster tab and select a School and a Class and multiple Students and click apply
    And Verify User is switched to Class and School and Student subway filters are enabled

  Scenario: Verify Test Scores Comparison Persistence on switching to all other levels
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    Then Verify Test Scores Comparison Persistence on switching to all other levels

  Scenario: Verify Single Test Analysis Persistence on switching to all other levels through subway nav filters
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    Then Verify Single Test Analysis Persistence on switching to all other levels through subway nav filters

  Scenario: Verify CSV download for Standard Performance Report details and Test Scores Report details
    Given User is on portal's login screen with username as "stg_teacher_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Standard Performance tab within the Class Context
    Then verify csv download functionality
    When User click on Class Context and Test Score button
    Then verify csv download functionality
    When User click on Student Context and Test Score button
    Then verify csv download functionality
    When User Click on Standard Performance tab within the Student Context
    Then verify csv download functionality

  Scenario: Verify The appearance of the student list and the line chart, when viewing the class context for the Test Scores Overview
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User click on Class Context and Test Score button
    Then line chart of Test score over time should be displayed to the right of it Student list should display
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User click on Class Context and Test Score button
    And User click on Student Context and Test Score button
    Then line chart of Test score over time should be displayed of that student but Student list should not be displayed on test score overview

  Scenario: Verify Student List for Standard Overview tab when looking at a Class Context
    Given User is on portal's login screen with username as "stg_sa_one" and password as "password" and usertype as "realm_stg_sulphur"
    When User Click on Standard Performance tab within the Class Context
    Then user should able to see Student List and the icon next to it can be selected to minimize or maximize the Student List window
    And Verify the left most column header should be 'Student (X)'
    And Verify the right most column header should be 'Score'
    And All the column headers should be sortable with ascending and descending order
    And select the student within the student list and Student context with information for that individual student should be shown
    And Click or select strand and standard from the standard table
    And The student list related to the selected standard within the perticular strand with the header and the subheader is displayed

  Scenario: Verify Start date and End Date for the Custom date selector always appears beneath the Date Range dropdown
    Given User is on portal's login screen with username as "stg_da_two" and password as "password" and usertype as "realm_stg_sulphur"
    Then verify Start date and End Date for the Custom date selector always appears beneath the Date Range dropdown
