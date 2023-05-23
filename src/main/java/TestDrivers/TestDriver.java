package TestDrivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestDriver {

    private static final String baseUrl = "https://www.xm.com/";
    private static final String projectPath = System.getProperty("user.dir");
    static WebDriver driver = null;

    private static Actions actions;

    public static Actions getActions() {
        actions = new Actions(driver);
        return actions;
    }

    public static WebDriver getDriver(){

        return driver;
    }

    private static WebDriver initializeChromeDriver() {

        if (driver == null) {
            System.setProperty("Webdriver.chrome.driver", projectPath + "/src/test/java/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }
        return driver;
    }

    public static void initialize(){
        initializeChromeDriver();
    }

    public static void setResolutionMaximize() {
        driver.manage().window().maximize();
    }

    public static void setResolution(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public static void terminateDriver() {
        driver.close();
        driver.quit();
    }

}
