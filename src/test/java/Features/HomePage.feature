Feature: Testing login page

  Scenario: XM smoke test fullscreen
    Given i set resolution to maximize
    When I open Home page and accept Cookies
    And I Open Research and education dropdown
    And verify text RESEARCH & EDUCATION text is visible
    And i open economic calendar
    And i verify Calendar is visible
    And set calendar to day
    And I click on here link in Disclaimer section
    Then Notification risk page is displayed and text "Notification on Non-Independent Investment Research and Risk Warning" is visible;
    When I click on here link in Risk warning section
    Then Warning PDF document is Displayed and text "Risk Warning:" is visible


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

