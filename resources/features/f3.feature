@Feature
Feature: Pagination of Dropdown List

  ##story 1d)
  @Scenario14 @Scenario16 @TC22 @TC24 @TC26 @TC38 @TC41
  Scenario: verifying list size and paginator features of Roster tab
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
		Then user clicks on Roster tab and check dropdown list size and paginator features of Roster tab for school as "Fair Oaks Ranch Community School"

  @Scenario15 @TC23 @TC25 @TC27
  Scenario: verifying list size and paginator features of Test tab
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User Click on Test tab within the Universal Selector Tab
    Then Paginator will be displayed,test list items per page should be 10 and totalitemlist more than 30 items, arrows will appear in both side of circle in paginator
