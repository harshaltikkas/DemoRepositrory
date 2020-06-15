@Feature
Feature: Validate Test Status Section - Sprint 30 to 33

  @TestStatus1 @BE-1958
  Scenario: Verify info icon text on summary
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the District Context
    Then Verify info icon text on summary

  @TestStatus2
  Scenario: Verify summary and detail on test status
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the District Context
    Then Verify summary and detail on test status

  @TestStatus3
  Scenario: Verify sorting order in summary
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the District Context
    Then Verify sorting order in summary

  @TestStatus4
  Scenario: Verify sorting order in detail
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the District Context
    Then Verify sorting order in detail

  @TestStatus5 @BE-1965
  Scenario: Verify pagination in summary in test status
    Given User is on portal's login screen with username as "teacher_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the Class Context
    Then Verify pagination in summary in test status

  @TestStatus6 @BE-1974,75,76
  Scenario: Verify Test Status default reports at Student Context when the Teacher logs in
    Given User is on portal's login screen with username as "teacher_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the Student Context
    Then Verify Test Status default reports at Student Context when the Teacher logs in

   @TestStatus7 @BE-2063
  Scenario: Verify CSV download of Test Status report in School context
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the School Context
    Then verify csv download functionality
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the District Context
    Then verify csv download functionality

  @TestStatus8 @BE-2118 @BE-2119 @BE-2126 @BE-2127 @BE-2218 @BE-2219
  Scenario: Verify the Print PDF of Test Status District
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the District Context
    Then verify the Print PDF of Test Status District
    Given User is on portal's login screen with username as "teacher_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the Student Context
    Then verify the Print PDF of Test Status District
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the School Context
    Then verify the Print PDF of Test Status District
    When User Click on Test Status tab within the Class Context
    Then verify the Print PDF of Test Status District

  @TestStatus9 @BE-2069
  Scenario: Verify that Tests are listed in Correct Order for Test Scores Comparision
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Comparison Tab in Test Scores tab within the District Context
    Then verify Tests are listed in Correct Order for Test Scores Comparision

  @TestStatus10 @BE-2167 @BE-2168
  Scenario: Verify the No Data Modal for Test Status
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    Then verify the No Data Modal for Test Status

  @TestStatus11 @BE-1989
  Scenario: Verify the data displayed in Detail section of Test Status Class View
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the School Context
    And User Click on Test Status tab within the Class Context
    Then Verify the data displayed in Detail section of Test Status Class View

  @TestStatus12 @BE-2026
  Scenario: Verify the data displayed in Detail section of Test Status School View
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the School Context
    Then Verify the data displayed in Detail section of Test Status School View
