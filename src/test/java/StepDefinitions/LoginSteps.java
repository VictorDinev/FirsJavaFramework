package StepDefinitions;

import HomePage.HomePage;
import TestDrivers.TestDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    HomePage homePage = new HomePage();


    @Given("i set resolution to maximize")
    public void iSetResolutionToMaximize() {
        TestDriver.setResolutionMaximize();
    }

    @Given("i set resolution to width {int} and height {int}")
    public void iSetResolutionToWithAndHeight(int width, int height) {
        TestDriver.setResolution(width, height);
    }

    @When("I open Home page and accept Cookies")
    public void openHomePage() {
        homePage.AcceptCookies();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        System.out.println("Enter credentials");
    }

    @When("click login")
    public void click_login() {
        System.out.println("Click log in");
    }

    @Then("home page is displayed")
    public void home_page_is_displayed() {
        System.out.println("Home Page");
    }

    @When("I Open Research and education dropdown")
    public void OpenResearchAndEducationDropdown() throws InterruptedException {
        homePage.researchEducationBntClick();
    }

    @And("verify text RESEARCH & EDUCATION text is visible")
    public void verifyTextRESEARCHEDUCATIONTextIsVisible() {
        homePage.setResearchEducationlableVerification();
    }
}
