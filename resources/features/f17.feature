@Feature
Feature: Sprint36 Scenarios

  @BE-2319
  Scenario: Verify Standard Performance Summary Persistence on switching to all other levels
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify Standard Performance Summary Persistence on switching to all other levels
  
  @BE-2320 
  Scenario: Verify Standard Performance Comparison Persistence on switching to all other levels
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify Standard Performance Comparison Persistence on switching to all other levels

 @BE-2266
  Scenario: Verify Roster tab persistence with DA login
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then User Click on School subway navigation and verify reports for the first school from the list is displayed
    Then User Click on Class subway navigation and verify reports for the fisrt class from the list is displayed
    Then User Click on Student subway navigation and verify reports for the first student from the list is displayed
    Then User Click on Class subway navigation and verify the Roster for Class name
    Then User Click on School subway navigation and verify the Roster for School name
    Then User Click on District subway navgation and verify the Roster tab

  @BE-2268
  Scenario: Verify Date tab persistence with DA login
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify the Persistence of Date tab by switching to different levels using subway navigation
    
   @BE-2339
  Scenario: Verify Standard Performance Grouping Persistence for teacher at class level 
    Given User is on portal's login screen with username as "teacher_two" and password as "password" and usertype as "realm_one"
    Then Verify Standard Performance Grouping Persistence for teacher at class level
