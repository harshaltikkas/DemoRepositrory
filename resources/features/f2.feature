@Feature
Feature: Validate Test Status Continues - Sprint 34 

  @TestStatus13 @BE-2217
  Scenario: Verify Row highlighting and Drill down in Student Context
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"
    When User Click on Test Status tab within the School Context
    And User Click on Test Status tab within the Class Context
    And User Click on Test Status tab within the Student Context
    Then Verify row highlighting and Drill down in Student Context

   @TestStatus14 @BE-1782 @BE-1785 @BE-1787
  Scenario: Verify users accessing the reports of the student on moving Student A from Class A to Class B within the same School
    Given User is on portal's login screen with username as "district_admin_test_tab_pagination" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify user accessing the reports of the student on moving Student A from Class A to Class B within the same School

   @TestStatus15 @BE-1784 @BE-1786 @BE-1788
  Scenario: Verify users accessing the reports of the student or class and switching to grading page on moving Student A from Class A to Class B within the same School
    Given User is on portal's login screen with username as "district_admin_test_tab_pagination" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify users accessing the reports of the student or class and switching to grading page on moving Student A from Class A to Class B within the same School

  @TestStatus16 @BE-1792 @BE-1827 @BE-1828
  Scenario: Verify users accessing the reports of the student on moving Student A from school A to school B within the same district
    Given User is on portal's login screen with username as "district_admin_test_tab_pagination" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify user accessing the reports of the student on moving Student A from school A to school B within the same district
  
  #This is failing as after clicking on student menu. showing no data  
  @TestStatus17 @BE-1789 @BE-1810
  Scenario: Verify Teacher A from class A leaves and Teacher B takes over class A, and accessing the reports within same school and in same district
    Given User is on portal's login screen with username as "multi_class_roster_district_admin" and password as "password" and usertype as "realm_fauquier"
    Then Verify Teacher A from class A leaves and Teacher B takes over class A, and accessing the reports within same school and in same district
   
  @TestStatus18 @BE-1811 @BE-1812 @BE-2223 @BE-2224 @BE-2225
  Scenario: Verify Student Data filter by class dropdown with info icon within the Roster tab
    Given User is on portal's login screen with username as "teacher_b" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify Student Data filter by class dropdown with info icon within the Roster tab    
 