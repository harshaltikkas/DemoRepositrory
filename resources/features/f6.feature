@Feature
Feature: Sprint 6 and Sprint 7 Stories

  ##Note: BE-630,659,660,661 all are already covered previously
  ## BE-649,662
  Scenario: Verify comparison band in class context in test score page selector
    Given User is on portal's login screen with username as "school_admin_one" and password as "password" and usertype as "realm_one"
    When User click on Class Context and Test Score button
    Then Verify the comparison band for school and district

   ##BE-653,BE-681,654
  Scenario: Verify tooltip icon and text of tooltip icon beside avg info
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Class Context
    Then Verify the tooltipicon in performance over time line chart and student list
    When User Click on Standard Performance tab within the Student Context
    Then Verify the tooltipicon in performance over time line chart
    When User click on Class Context and Test Score button
    Then Verify the tooltipicon is not present
   
  ##BE-650,682
  Scenario: Verify The diamond shape stroke on the x-axis and Color changes within the Line Charts
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Class Context
    Then verify the diamond shape stroke on the x-axis and Color changes within the Line Charts
    When User Click on Standard Performance tab within the Student Context
    Then verify the diamond shape stroke on the x-axis and Color changes within the Line Charts

  ##BE-683,684
  Scenario: Verify The diamond shape stroke on the x-axis and Color changes within the Line Charts within test score menu
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User click on Class Context and Test Score button
    Then verify the diamond shape stroke on the x-axis and Color changes within the Line Charts within test score menu
    When User click on Student Context and Test Score button
    Then verify the diamond shape stroke on the x-axis and Color changes within the Line Charts within test score menu for student

  ## BE-666,685,677,686  
  Scenario: Verify Selection and Deselection of the Comparison options within the Line Charts for Particular Strand and standard
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Student Context
    Then verify the dotted line and triangle line on line chart based on selection of school and district and class checkbox
    When User Click on Standard Performance tab within the Class Context
    Then verify the dotted line and triangle line on line chart based on selection of school and district and class checkbox
