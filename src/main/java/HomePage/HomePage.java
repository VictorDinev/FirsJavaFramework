package HomePage;

import TestDrivers.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver = TestDriver.getDriver();
    WebElement cookiesAcceptBtn = driver.findElement(By.xpath("//button[@aria-label=\"Close\"][contains(text(),\"ACCEPT ALL\")]"));
    WebElement OpenAccountBtn = driver.findElement(By.xpath("//li[@class=\"hidden-sm\"]/a[contains(text(),\" OPEN AN ACCOUNT \")]"));
    WebElement researchEducationBnt = driver.findElement(By.xpath("//li[@class=\"main_nav_research\"]"));

    WebElement researchEducationlable = driver.findElement(By.xpath("//div[@class=\"box hidden-xs hidden-sm\"]/span[contains(text(),\"RESEARCH & EDUCATION\")]"));

    public void researchEducationBntClick(){
        researchEducationBnt.click();
    }
    public void AcceptCookies(){
        cookiesAcceptBtn.click();
    }

    public void setResearchEducationlableVerification(){
        researchEducationlable.isDisplayed();
    }
}
