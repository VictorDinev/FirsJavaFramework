package EconomicCalendar;

import TestDrivers.TestDriver;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class EconomicCalendar {

    WebDriver driver = TestDriver.getDriver();
    Actions actions = TestDriver.getActions();

    List<String> expectedCalendarPeriod = Arrays.asList("Today", "Tomorrow", "This Week", "Next Week", "This Month", "Next Month");


    public void CalendarSearchIsDisplayed() {
        driver.switchTo().frame("iFrameResizer0");
        WebElement calendarIframe = driver.findElement(By.xpath("//*[@id=\"economic-calendar-list\"]/div[3]/div[1]/span[1]"));
        System.out.println(calendarIframe.getText() + "================================================================================================================");
        driver.switchTo().defaultContent();
    }

    public void calendarSliderManipulator() {

        driver.switchTo().frame("iFrameResizer0");
        WebElement calendarPeriod = driver.findElement(By.xpath("//span/div[@class=\"ng-star-inserted\"]"));
        WebElement calendarSlider = driver.findElement(By.xpath("//div[@class=\"mat-slider-thumb\"]"));

        String calendarPeriodText = calendarPeriod.getText();


        for (int i = 0; i < expectedCalendarPeriod.size(); i++) {

            calendarPeriod = driver.findElement(By.xpath("//span/div[@class=\"ng-star-inserted\"]"));
            calendarPeriodText = calendarPeriod.getText();

            if (!calendarPeriodText.equals(expectedCalendarPeriod.get(i))) {

                actions.moveToElement(calendarSlider).click(calendarSlider).sendKeys(Keys.ARROW_RIGHT).perform();

                calendarPeriod = driver.findElement(By.xpath("//span/div[@class=\"ng-star-inserted\"]"));
                calendarPeriodText = calendarPeriod.getText();

//                System.out.println(expectedCalendarPeriod.get(i));
//                System.out.println(calendarPeriodText);

                Assert.assertEquals(expectedCalendarPeriod.get(i), calendarPeriodText);
            }
        }

        WebElement loadMore = driver.findElement(By.xpath("//span[@class=\"tc-economic-calendar-load-more-button-text ng-star-inserted\"]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loadMore));

        driver.switchTo().defaultContent();
    }

    public void disclaimerHereClick() {
        WebElement hereLink = driver.findElement(By.xpath("//div[@class=\"container mt-400\"]/div[@class=\"p-200 bt-1 bb-1 bl-1 br-1\"]/p/a[@href=\"/research/risk_warning\"]"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hereLink);
    }
}
