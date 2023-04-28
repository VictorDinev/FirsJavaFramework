package AccountPage;

import TestDrivers.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileAccountPage {

    WebDriver driver = TestDriver.getDriver();

    WebElement ReturnHomeBtn = driver.findElement(By.xpath("//a[contains(text(),\"XM Homepage\")]"));

    public void clickReturnHome(){
        ReturnHomeBtn.click();
    }

}
