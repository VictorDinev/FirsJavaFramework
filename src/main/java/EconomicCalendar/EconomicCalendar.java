package EconomicCalendar;

import TestDrivers.TestDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class EconomicCalendar {

 WebDriver driver = TestDriver.getDriver();
 Actions actions = TestDriver.getActions();

    public void CalendarSearchIsDisplayed() {
        driver.switchTo().frame("iFrameResizer0");
        WebElement calendarIframe = driver.findElement(By.xpath("//*[@id=\"economic-calendar-list\"]/div[3]/div[1]/span[1]"));
        System.out.println(calendarIframe.getText() + "================================================================================================================");
        driver.switchTo().defaultContent();
    }

    public void calendarSliderManipulator() {
        driver.switchTo().frame("iFrameResizer0");
        WebElement calendarSlider = driver.findElement(By.xpath("//div[@class=\"mat-slider-thumb\"]"));
        actions.moveToElement(calendarSlider).click(calendarSlider).sendKeys(Keys.ARROW_RIGHT).perform();


        WebElement actualCalendarPeriod = driver.findElement(By.xpath("//span[@class=\"tc-finalval-tmz\"]/div"));
        String calendarPeriodToday = "Today";

        System.out.println(actualCalendarPeriod.getText());
        Assert.assertEquals(calendarPeriodToday,actualCalendarPeriod.getText());

        driver.switchTo().defaultContent();
    }
}
