package HomePage;

import TestDrivers.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResearchAndEducationMenu {
    WebDriver driver = TestDriver.getDriver();

    WebElement economicCalendar = driver.findElement(By.xpath("//li[@class=\"menu-research\"]/a[contains(text(),\"Economic Calendar \")]"));

    public void economicCalendarClick() {
        economicCalendar.click();
    }

}
