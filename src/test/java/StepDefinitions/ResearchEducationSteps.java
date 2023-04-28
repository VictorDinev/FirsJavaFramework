package StepDefinitions;

import HomePage.ResearchAndEducationMenu;
import io.cucumber.java.en.When;

public class ResearchEducationSteps {

    ResearchAndEducationMenu researchAndEducationMenu = new ResearchAndEducationMenu();

    @When("i open economic calendar")
    public void i_open_economic_calendar() {
        researchAndEducationMenu.economicCalendarClick();
    }

}
