@Feature
Feature: Single Test Analysis - Sprint 22

  ## BE-1552,1553 (passed) 
  Scenario: Verify Key Toggle - Single Test Analysis
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify the key toggle when user click on single test analysis tab and the other tab

  ## BE-1554,1559,1560,1561,1562,1563,1569,1570,1571,1572 (passed) 
  Scenario: Verify The Default View Behaviour of the Single Test Analysis when the user clicks on the single test analysis tab
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then The Default View Behaviour of the Single Test Analysis when the user clicks on the single test analysis tab

  ## BE-1555,1556 (passed) 
  Scenario: Verify Adding Teacher label to Context Header for the School Admins
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    Then veryfy Teacher label to Context Header for the School Admins for teacher "Ryan Whitaker"

  ## BE-1568 (passed)
  Scenario: Verify On clicking the individual question should switch to Question Filter report - Single Test Analysis
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then verify On clicking the individual question should switch to Question Filter report - Single Test Analysis
