@Feature
Feature: Batch Print in Summary and STA - Sprint29 Scenarios

    ##@BE-1919 School Admin - Standards Summary Report Continuous Printing for Student Level
    ##@BE-1917 Teacher - Standards Summary Report Continuous Printing for Student Level
   @BE-1912 @BE-1920 @BE-1927 @BE-1928 @BE-1929
  Scenario: Verify Standards Summary and Single Test Analysis Print Modal for Student Level
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Summary tab within the Student Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level
    When User Click on Single Test Analysis tab within the Student Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level
    Given User is on portal's login screen with username as "teacher_four" and password as "password" and usertype as "realm_fauquier"
    When User Click on Summary tab within the Student Context
    And click and select view from dropdown
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"   
    And User Click on Summary tab within the Student Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Student Level     

 		##@BE-1915 School Admin - Standards Summary Report Continuous Printing for Class Level
    ##@BE-1916 District Admin - School Admin - Standards Summary Report Continuous Printing for Class Level
   @BE-1913 @BE-1914 @BE-1924 @BE-1925 @BE-1926
  Scenario: Verify Standards Summary and Single Test Analysis Print Modal for Class Level
    Given User is on portal's login screen with username as "teacher_four" and password as "password" and usertype as "realm_fauquier"
    When User Click on Summary tab within the Class Context
    And click and select view from dropdown
    Then verify Standards Summary and Single Test Analysis Print Modal for Class Level
    When User Click on Single Test Analysis tab within the Class Context
    Then verify Standards Summary and Single Test Analysis Print Modal for Class Level
    Given User is on portal's login screen with username as "school_admin_two" and password as "password" and usertype as "realm_one"
    When User Click on Summary tab within the Class Context
    And click and select view from dropdown
    Then verify Standards Summary and Single Test Analysis Print Modal for Class Level  
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Summary tab within the Class Context
    And click and select view from dropdown
    Then verify Standards Summary and Single Test Analysis Print Modal for Class Level
