package org.testcraft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainLineHomePage extends Page {
    public TrainLineHomePage(WebDriver driver) {
        super(driver);
    }

    public void setOriginStation (String originStation) {
        WebElement originField = driver.findElement(By.cssSelector("#originStation"));
        originField.sendKeys(originStation);
    }

    public void setDestinationStation (String destinationStation) {
       WebElement destinationField = driver.findElement(By.cssSelector("#destinationStation"));
        destinationField.sendKeys(destinationStation);
    }

    public void clickTimesAndTicketsButton () {
        driver.findElement(By.id("submitButton")).click();
    }
}
