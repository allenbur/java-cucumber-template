package org.testcraft.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testcraft.TrainLineHomePage;

public class TrainLineStepDefs {
    public WebDriver driver;
    TrainLineHomePage homePage;

    public TrainLineStepDefs() {
        driver = Hooks.driver;
        homePage = new TrainLineHomePage(driver);
    }


    @Given("^I am on \"([^\"]*)\"$")
    public void i_am_on(String arg1) throws Throwable {
        driver.get(arg1);
    }


    @When("^I set the journey from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_set_journey_from_to (String arg1, String arg2) throws Throwable {
        homePage.setDestinationStation(arg1);
        homePage.setOriginStation(arg2);
    }

    @Then("^I click the button to get times and tickets$")
    public void i_click_the_button_to_get_times_and_tickets() throws Throwable {
        homePage.clickTimesAndTicketsButton();
    }
}
