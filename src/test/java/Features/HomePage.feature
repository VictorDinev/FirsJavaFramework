Feature: Testing loin page

  Scenario: XM smoke test fullscreen
    Given i set resolution to maximize
    When I open Home page and accept Cookies
    And I Open Research and education dropdown
    And verify text RESEARCH & EDUCATION text is visible
    And i open economic calendar
    And i verify Calendar is visible
    And set calendar to day


#  Scenario: XM smoke test resolution 1024 x 768
#    Given i set resolution to width 1024 and height 768
#    Given I open Home page
#    When I check for Open account btn is visible
#    Then home page is displayed
#
#  Scenario: XM smoke test resolution 800 x 600
#    Given i set resolution to width 800 and height 600
#    Given I open Home page
#    When I check for Open account btn is visible
#    Then home page is displayed

