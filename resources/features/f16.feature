@Feature
Feature: Subway Navigation Changes - Sprint35 Scenarios

  ## DA - Verify the Universal Selector filters and Subway navigation changes when user logged in as DA
  @BE-2257 @BE-2258 @BE-2259
  Scenario: Verify Universal Selector filters when user logged in as District Admin
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
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

  ##SA - Verify the Universal SeleVerify User is switched to Student and School and Class subway filters are enabledctor filters and Subway navigation changes when user logged in as SA
  @BE-2261 @BE-2262 @BE-2263
  Scenario: Verify Universal Selector filters when user logged in as School Admin
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User click on Roster tab and select one Teacher and one Class and click apply
    And Verify User is switched to Class and School and Student subway filters are enabled
    Then Navigate back to School and click on Roster tab and select multiple Teachers and Classes and click apply
    And Verify User is switched to School and Class subway is enabled and Student subway is disabled
    When User click on Roster tab and select a Class and single Student and click apply
    And Verify User is switched to Student and School and Class subway filters are enabled
    Then Navigate back to School and click on Roster tab and select a Class and multiple Students and click apply
    And Verify User is switched to Class and School and Student subway filters are enabled

  @BE-2277
  Scenario: Verify Test Scores Comparison Persistence on switching to all other levels
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify Test Scores Comparison Persistence on switching to all other levels

  @BE-2276 @BE-2274
  Scenario: Verify Single Test Analysis Persistence on switching to all other levels through subway nav filters
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify Single Test Analysis Persistence on switching to all other levels through subway nav filters
 
 @BE-2270 @BE-2269 
  Scenario: Verify the persistence by selecting data in Roster tab filters of STA
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    Then Verify the persistence by selecting data in Roster tab filters of STA
