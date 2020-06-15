@Feature
Feature: Line Chart Test Scores vs Time

  ##LINE CHART TEST SCORE OVER TIME
  @Scenario31 @TC_0019
  Scenario: Verify the Y-axis label
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User click on Class Context and Test Score button
    Then verify y-axis labeled with as Test Scores(%) and also verify 12 horizontal lines, one for x axis line and rest label with 0 throught 100

   @Scenario32 @TC_0020
  Scenario: Verify the X-axis label
    Given User is on portal's login screen with username as "district_admin_one" and password as "password" and usertype as "realm_one"
    When User click on Class Context and Test Score button
    Then verify x-axis labeled with 'Test Names' and show tooltip if elipsis in test names and if more than '10' tests are there then paginator should be display

  @Scenario33 @Scenario34 @TC_0021
  Scenario: Verify the colours inside the circle within the line chart
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Class Context
    Then User click on the circle within the line chart and should able to see the overlay of Tool tip which have following items on performace over time
    When User Click on Standard Performance tab within the Student Context
    Then User click on the circle within the line chart and should able to see the overlay of Tool tip which have following items on performace over time

  @Scenario35 @TC_0028
  Scenario: Verify that how the overlay shown on the line chart can be closed
    Given User is on portal's login screen with username as "teacher_one" and password as "password" and usertype as "realm_one"
    When User Click on Standard Performance tab within the Student Context
    Then Verify the overlay should be closed and other is open if click on other circle
