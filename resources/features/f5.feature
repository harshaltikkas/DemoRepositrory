@Feature
Feature: Page Selector and Class Student Filter

  ##STUDENT/CLASS FILTER , PAGE SELECTOR , CONTEXT HEADER, FLY-IN-KEY
  @Scenario22 @TC1 @TC3
  Scenario: Verify by default Standards Performance button should be selected with the Class context from the Student/Class Filter.
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When default Standards Performance button should be selected with the Class context
    Then user selects Test Scores button within the page selector then also the context will remain same

  @Scenario23 @TC9
  Scenario: Verify user can able to open & close reporting key which includes Achievement levels with colour coding in a single row centered on the page.
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Class Context
    And User click on fly in key to open reporing key
    Then verify the achievement leves with different colour codes and click on fly in key to close it.

  @Scenario24 @TC6 @TC7 @TC8
  Scenario: Verify left side footer text and right side footer text
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Class Context
    Then Verify left side footer text and right side footer text

  @Scenario25 @TC_0001 @Scenario26 @TC_0004 @Scenario27
  Scenario: Verify position of the Context Header tab position and the Verify the Labels within it and Verify the changes happened, when the user hover over the data If it has an ellipsis
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User click on Class Context and Test Score button
    Then Verify labels on context header based on selection of menus
    When User click on Student Context and Test Score button
    Then Verify labels on context header based on selection of menus
    When User Click on Standard Performance tab within the Class Context
    Then Verify labels on context header based on selection of menus
    When User Click on Standard Performance tab within the Student Context
    Then Verify labels on context header based on selection of menus
