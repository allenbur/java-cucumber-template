package org.testcraft;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainLineJourneyInformationPage extends Page {
    public TrainLineJourneyInformationPage(WebDriver driver) {
        super(driver);
    }

    public void checkOriginAndDestination(String Origin, String Destination) {
        WebElement journeyStations = driver.findElement(By.xpath("//*[@id=\"timetable\"]/h1"));
        String journeyOriginAndDestination = journeyStations.getText();
        Assert.assertTrue("Validate text contains ‘" + Origin + "’", journeyOriginAndDestination.contains(Origin));
        Assert.assertTrue("Validate text contains ‘" + Destination + "’", journeyOriginAndDestination.contains(Destination));
    }

}
