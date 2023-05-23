package RiskWarningPage;

import TestDrivers.TestDriver;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class RiskWarningPage {

    WebDriver driver = TestDriver.getDriver();

    public void CheckForWarningPageDisplayed(String warningNotification) {
        WebElement notification = driver.findElement(By.xpath("//div[@class=\"container mt-350\"]/h2"));

        notification.isDisplayed();
        notification.getText().equals(warningNotification);
    }

    public void clickHereLinkRiskWarningPage() {
        WebElement hereLink = driver.findElement(By.xpath("//div[@class=\"container mt-350\"]//a[@href=\"https://cloud.xm-cdn.com/static/pdf/System-PDFs/XM-Risk-Disclosures-for-Financial-Instruments.pdf?v=fa753a4995a2e1315d80850da95c2537\"]"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hereLink);
    }

    public void checkWarningPDFIsOpen(String pdfContainment) throws IOException {

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindowID = iterator.next();
        String childWindowID = iterator.next();

        driver.switchTo().window(childWindowID);
        String currentUrl = driver.getCurrentUrl();

        System.out.println("URL is ======== " + currentUrl);


        URL pdfURL = new URL(currentUrl);

        URLConnection urlConnection = pdfURL.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Chrome");

        InputStream inputStream = urlConnection.getInputStream();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        // create PDF object

        PDDocument pdDocument = PDDocument.load(bufferedInputStream);

        int pageCount = pdDocument.getNumberOfPages();
        System.out.println("Number of pages =========> " + pageCount);
        Assert.assertEquals(pageCount, 10);

        PDFTextStripper textStripper = new PDFTextStripper();
        textStripper.setStartPage(10);
        String endPage = textStripper.getText(pdDocument);

        assertTrue(endPage.contains(pdfContainment));
    }

}
