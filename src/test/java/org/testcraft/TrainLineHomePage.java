package org.testcraft;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainLineHomePage extends BasePage {
    public TrainLineHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.navigate().to("https://www.thetrainline.com/");
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

    public void checkTrainLineTitle () {
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Validate text contains ‘Trainline’", homePageTitle.contains("Trainline"));;
    }

    public void clickReturnRadioButton () {
       WebElement returnRadioButton = driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[2]/label[2]"));
       returnRadioButton.click();
       returnRadioButton.isSelected();
    }

    public void clickTomorrow () {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[2]")).click();
    }

    public void clickNextDay () {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]")).click();
    }


}
