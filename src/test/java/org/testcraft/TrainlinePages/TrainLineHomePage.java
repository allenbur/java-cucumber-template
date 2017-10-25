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

// Extends the BasePage to set up the Webdriver.
public class TrainLineHomePage extends BasePage {
    public TrainLineHomePage(WebDriver driver) {
        super(driver);
    }

    // Closes the cookies bar as it may inhibit some actions.
    public void closeCookiesBar() {
        driver.findElement(By.xpath("//*[@id=\"master\"]/div[1]/div/button")).click();
    }

    // Navigate to the Trainline homepage.
    public void navigateTo() {
        driver.navigate().to("https://www.thetrainline.com/");
    }

    // Sends keys to the departure station field.
    public void setOriginStation(String originStation) {
        WebElement originField = driver.findElement(By.cssSelector("#originStation"));
        originField.sendKeys(originStation);
    }

    // Sends keys to the destination station field.
    public void setDestinationStation(String destinationStation) {
        WebElement destinationField = driver.findElement(By.cssSelector("#destinationStation"));
        destinationField.sendKeys(destinationStation);
    }

    // Clicks the get times and tickets button.
    public void clickTimesAndTicketsButton() {
        driver.findElement(By.id("submitButton")).click();
    }

    // Checks the title of the Trainline homepage to ensure that it contains the phrase "Trainline"
    public void checkTrainLineTitle() {
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Validate text contains ‘Trainline’", homePageTitle.contains("Trainline"));
    }

    // Checks the return radio button and checks to see if it is selected.
    public void clickReturnRadioButton() {
        WebElement returnRadioButton = driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[2]/label[2]"));
        returnRadioButton.click();
        returnRadioButton.isSelected();
    }


    // Clicks tomorrow for outward journey.
    public void clickTomorrow() {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[2]")).click();
    }

    // Clicks next day for the return.
    public void clickNextDay() {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]")).click();
    }

    //  Picks out a date from the calender.
    public void pickFutureOutDate(int days) {
        // Opens the calendar.
        driver.findElement(By.xpath("//*[@id='outDate']")).click();
        // Calls a method which calculates the month and day selected for the outward journey.
        String[] splitDate = setUpFutureDate(days);

        // While loop compares the month section of the split date with the month title on the calender.
        while (!driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().contains(splitDate[0])) {
            // Clicks next month button each time the month title does not contain the selected month name.
            driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all")).click();
        }
        // Creates a list called "dayOfMonthDates" from all web elements with the tag name td that lie within the calender.
        List<WebElement> dayOfMonthDates = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).findElements(By.tagName("td"));
        // For loop compares each dayOfMonth with the day partition of the splitdates string.
        for (WebElement cell : dayOfMonthDates) {
            // When a cell from the dayOfMonthDates list equals the selected future day of the month the cell is clicked on.
            if (cell.getText().equals(splitDate[1])) {
                cell.click();
                // And the loop breaks
                break;
            }
        }

    }

    // Sets the amount of adults and children that will be travelling.
    public void addPeople(String adultAmount, String childAmount) {
        // Opens the initial dropdown list.
        WebElement passengersAndRailCardsButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-open"));
        passengersAndRailCardsButton.click();
        // Uses a select statement to select an option from the dropdown menu using visible text.
        Select adultDropdown = new Select(driver.findElement(By.cssSelector("#adults")));
        adultDropdown.selectByVisibleText(adultAmount);
        Select childDropdown = new Select(driver.findElement(By.cssSelector("#children")));
        childDropdown.selectByVisibleText(childAmount);
        // Closes the initial dropdown list.
        passengersAndRailCardsButton.click();


    }

    // Method called upon in the calender method to calculate the future date selected from the current date.
    public String[] setUpFutureDate(int days) {
        // Uses the LocalDate import to add days to the current date to get the future booking date.
        LocalDate futureBooking = LocalDate.now().plusDays(days);
        // Formats the date to be displayed as "Month Day"
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MMMM d");
        // Creates a string using the newly created date formatter on the previously calculated future booking date.
        String formattedDate = futureBooking.format(formatDate);
        // Partitions the formatted date string with a space being the separator between sections.
        String[] splitDate = formattedDate.split(" ");
        return splitDate;
    }

}