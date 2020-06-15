@Feature
Feature: Roster Tab Dropdown Behaviour

  ##story Loading Icon
  @Scenario10 @Scenario12 @TC16 @TC18
  Scenario: Verify that the selected option should appear at the top of the list and the user should select one option from the dropdown list at a time and also Verify the search bar not scrollable and has the "X" to cancel searched option and search icon to search the option within School and class and student dropdown.
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    ##13a & b
    And User Click on Roster tab within the Universal Selector Tab and the School and Class and students last names should be displayed in alphabetical ascending order with selection of "Fair Oaks Ranch Community School" school and "Grade 6 - Spears - 0" class and "John Beam" as student
    ##TC-16
    And Verify selected option should appear in respected dropdowns

  @Scenario13 @TC19
  Scenario: Verify that the All option displayed in first position among the optins in studentlist untill the user select the single student name as option
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Roster tab within the Universal Selector Tab
    Then select school as "Fair Oaks Ranch Community School" and 'All' option should be display at first position in student list and can not be scrollable

  ##S6 & S7 , BE-630,660,659
  Scenario: Verify Selection/Deselection of Multiple Students from Student dropdown List within Roster tab
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Roster tab within the Universal Selector Tab
    Then select school as "Fair Oaks Ranch Community School" and Veriy the previously selected students should be on top in student dropdown
