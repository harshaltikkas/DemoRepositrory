@Feature
Feature: Test Tab Design and Behaviour

  ##story 1f)
  @Scenario18 @TC31
  Scenario: Verify that the checkbox for ALL option
    Given User is on portal's login screen with username as "district_admin_test_tab_pagination" and password as "password" and usertype as "realm_test_tab_pagination"
    When User Click on Test tab within the Universal Selector Tab and click on 'All Checkbox'
    Then verify all the tests within that test list must be selected.

  @Scenario19 @TC39
  Scenario: Verifying the state of the checkbox when deselected the option/test
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then verify checkbox state as deselected while unchecked on checkbox.

  @Scenario20 @TC42
  Scenario Outline: Check the position and specification of the object/elements within the test tab test list.
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then verify the elements within test list one beside the other with following elements "<elements>" and tooltiptext "<tooltiptext>"

    Examples: 
      | elements          | tooltiptext                      |
      | Name              | Test Name                        |
      | Number of Results | Number of Test Results Available |
      | Earliest Date     | Earliest Submission date         |
      | Latest Date       | Latest Submission date           |

  ##story 2e)
  @Scenario21 @TC43
  Scenario: Verify the sorting with the arrows which are with heading elements
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then arrows with the elements within the test list should be sorted as follows

  #1)Name up arrow: A-Z
  #2)Name down arrow: Z-A
  #3)Results up arrow: 1-10
  #4)Results down arrow: 10-1
  #5)Date up arrows: oldest to newest
  #6)Date down arrows: newest to oldest
  
  @Scenario28 @TC39
  Scenario: Check whether the earliest date is displaying in descending by defaultly
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then verify earliest date is dispalying in descending order

  ##story 2d)
  @Scenario29 @TC_0051 @TC_0052 @TC_0053 @TC_0055 @TC_0057
  Scenario: Verify the search bar not scrollable and has the 'X' to cancel searched option and search icon to search the option within test tab
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then Searches anything what’s being typed in showing 'X' to cancel and displays them as options to select from below the search bar and filters the list.

  @Scenario30 @TC60
  Scenario: Verify the total count has impact upon searching
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then search anything and get the result, the result count will not impact on no. of total tests
