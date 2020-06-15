@Feature
Feature: Sprint37 Scenarios

  @BE-2370
  Scenario: Verify School dropdown is displayed for Teacher with rostered to multiple Schools
    Given User is on portal's login screen with username as "teacher_five" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify School dropdown is displayed in Roster tab

  @BE-2371
  Scenario: Verify School dropdown is not displayed for Teacher with rostered to multiple Schools
    Given User is on portal's login screen with username as "teacher_two" and password as "password" and usertype as "realm_one"
    Then Verify School dropdown is not displayed in Roster tab

  @BE-2366
  Scenario: Verify Tool tip is displayed when user mouse hover over Class name in Student Data dropdown
    Given User is on portal's login screen with username as "district_admin_test_tab_pagination" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify Tool tip is displayed when user mouse hover over Class name in Student Data dropdown

  @BE-2367
  Scenario: Verify Tool tip is not displayed when user mouse hover over Class name in Student data dropdown
    Given User is on portal's login screen with username as "district_admin_test_tab_pagination" and password as "password" and usertype as "realm_test_tab_pagination"
    Then Verify Tool tip is not displayed when user mouse hover over Class name in Student data dropdown

  @BE-2368
  Scenario: Verify the Default Print Modal of SPOT in Student context
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify the Default Print Modal of SPOT in Student context
