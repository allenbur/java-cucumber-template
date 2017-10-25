package org.testcraft.TrainlinePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testcraft.BasePage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TrainLineHomePage extends BasePage {
    public TrainLineHomePage(WebDriver driver) {
        super(driver);
    }

    public void closeCookiesBar() {
        driver.findElement(By.xpath("//*[@id=\"master\"]/div[1]/div/button")).click();
    }

    public void navigateTo() {
        driver.navigate().to("https://www.thetrainline.com/");
    }

    public void setOriginStation(String originStation) {
        WebElement originField = driver.findElement(By.cssSelector("#originStation"));
        originField.sendKeys(originStation);
    }

    public void setDestinationStation(String destinationStation) {
        WebElement destinationField = driver.findElement(By.cssSelector("#destinationStation"));
        destinationField.sendKeys(destinationStation);
    }

    public void clickTimesAndTicketsButton() {
        driver.findElement(By.id("submitButton")).click();
    }

    public void checkTrainLineTitle() {
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Validate text contains ‘Trainline’", homePageTitle.contains("Trainline"));
        ;
    }

    public void clickReturnRadioButton() {
        WebElement returnRadioButton = driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[2]/label[2]"));
        returnRadioButton.click();
        returnRadioButton.isSelected();
    }

    public void clickTomorrow() {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[2]")).click();
    }

    public void clickNextDay() {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]")).click();
    }


    public void pickFutureOutDate(int days) {

        driver.findElement(By.xpath("//*[@id='outDate']")).click();
        LocalDate futureBooking = LocalDate.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
        String formattedDate = futureBooking.format(formatter);
        String[] splitDate = formattedDate.split(" ");

        while (!driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().contains(splitDate[0])) {
            driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all")).click();
        }
        List<WebElement> columns = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            if (cell.getText().equals(splitDate[1])) {
                cell.click();
                break;
            }
        }

    }

    public void addPeople (String adultAmount, String childAmount) {
        WebElement passengersAndRailCardsButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-open"));
        passengersAndRailCardsButton.click();
        Select adultDropdown = new Select (driver.findElement(By.cssSelector("#adults")));
        adultDropdown.selectByVisibleText(adultAmount);
        Select childDropdown = new Select(driver.findElement(By.cssSelector("#children")));
        childDropdown.selectByVisibleText(childAmount);
        passengersAndRailCardsButton.click();



    }
}