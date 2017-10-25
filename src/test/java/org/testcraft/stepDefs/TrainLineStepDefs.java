package org.testcraft.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testcraft.TrainlinePages.TrainLineHomePage;
import org.testcraft.TrainlinePages.TrainLineJourneyInformationPage;

public class TrainLineStepDefs {
    public WebDriver driver;
    TrainLineHomePage homePage;
    TrainLineJourneyInformationPage informationPage;

    public TrainLineStepDefs() {
        driver = Hooks.driver;
        homePage = new TrainLineHomePage(driver);
        informationPage = new TrainLineJourneyInformationPage(driver);
    }

    // ** EXERCISE ONE & TWO**

    @Given("^I am on the Trainline homepage$")
    public void i_am_on() throws Throwable {
        homePage.navigateTo();
        homePage.closeCookiesBar();
    }


    @When("^I set the journey from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_set_journey_from_to(String arg1, String arg2) throws Throwable {
        homePage.setDestinationStation(arg1);
        homePage.setOriginStation(arg2);
    }

    @Then("^I click the button to get times and tickets$")
    public void i_click_the_button_to_get_times_and_tickets() throws Throwable {
        homePage.clickTimesAndTicketsButton();
    }

    @Then("^I see journey information for \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_see_journey_information_for_to(String arg1, String arg2) throws Throwable {
        informationPage.checkOriginAndDestination(arg1, arg2);
        informationPage.checkPriceTableIsDisplayed();
    }

    // ** EXERCISE THREE **

    @When("^I select the return button$")
    public void i_select_the_return_button() throws Throwable {
        homePage.clickReturnRadioButton();
    }

    @When("^I select Tomorrow for outward journey$")
    public void i_select_Tomorrow_for_outward_journey() throws Throwable {
        homePage.clickTomorrow();
    }

    @When("^I select Next day for return journey$")
    public void i_select_Next_day_for_return_journey() throws Throwable {
        homePage.clickNextDay();
    }

    // ** EXERCISE FIVE **

    @When("^I select the outward journey to be \"([^\"]*)\" days in the future$")
    public void i_select_the_outward_joruney_to_be_days_in_the_future(Integer arg1) throws Throwable {
        homePage.pickFutureOutDate(arg1);
    }

    @When("^I set the number of adults to \"([^\"]*)\" and the number of children to \"([^\"]*)\"$")
    public void i_set_the_number_of_adults_to_and_the_number_of_children_to(String arg1, String arg2) throws Throwable {
        homePage.addPeople(arg1 , arg2);
    }
}


