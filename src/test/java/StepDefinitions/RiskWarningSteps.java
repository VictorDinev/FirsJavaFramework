package StepDefinitions;

import RiskWarningPage.RiskWarningPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class RiskWarningSteps {

    RiskWarningPage riskWarningPage = new RiskWarningPage();

    @When("I click on here link in Risk warning section")
    public void iClickOnHereLinkInRiskWarningSection() {
        riskWarningPage.clickHereLinkRiskWarningPage();
    }

    @Then("Warning PDF document is Displayed and text {string} is visible")
    public void warningPDFDocumentIsDisplayedAndTextIsVisible(String pdfContainment) throws IOException {
        riskWarningPage.checkWarningPDFIsOpen(pdfContainment);
    }

    @Then("Notification risk page is displayed and text {string} is visible;")
    public void notificationRiskPageIsDisplayedAndTextIsVisible(String warningNotification) {
        riskWarningPage.CheckForWarningPageDisplayed(warningNotification);
    }
}
