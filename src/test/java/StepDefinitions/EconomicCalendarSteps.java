package StepDefinitions;

import EconomicCalendar.EconomicCalendar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class EconomicCalendarSteps {

    EconomicCalendar economicCalendar = new EconomicCalendar();

    @When("i verify Calendar is visible")
    public void EconomicCalendar() {
        economicCalendar.CalendarSearchIsDisplayed();
    }


    @And("set calendar to day")
    public void setCalendarToDay() {
        economicCalendar.calendarSliderManipulator();
    }

    @And("I click on here link in Disclaimer section")
    public void iClickOnHereLinkInDisclaimerSection() {
        economicCalendar.disclaimerHereClick();
    }
}
