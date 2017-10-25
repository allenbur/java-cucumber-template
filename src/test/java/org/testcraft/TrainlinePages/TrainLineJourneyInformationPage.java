package org.testcraft.TrainlinePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testcraft.BasePage;

public class TrainLineJourneyInformationPage extends BasePage {
    public TrainLineJourneyInformationPage(WebDriver driver) {
        super(driver);
    }

    // Checks the origin and destination on the journey information page.
    public void checkOriginAndDestination(String Origin, String Destination) {
        // Gets the title which contains the station names and stores it as a string.
        WebElement journeyStations = driver.findElement(By.xpath("//*[@id=\"timetable\"]/h1"));
        String journeyOriginAndDestination = journeyStations.getText();
        // Asserts that the argument 1 & 2 are contained within the title.
        Assert.assertTrue("Validate text contains ‘" + Origin + "’", journeyOriginAndDestination.contains(Origin));
        Assert.assertTrue("Validate text contains ‘" + Destination + "’", journeyOriginAndDestination.contains(Destination));
        // Could investigate into asserting they are in the correct order.
    }

    public void checkPriceTableIsDisplayed() {
        // Check price table is displayed
        driver.findElement(By.cssSelector(".matrix-table.matrix-out")).isDisplayed();
    }

}
