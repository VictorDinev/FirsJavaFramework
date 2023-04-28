package Utilities;

public class Utilities {

import model.SliderInterval;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

    public class SliderComponent {
        private final By SLIDER_INDICATOR = By.xpath("//mat-slider[contains(@class, 'slider')]");
        private final By SLIDER_THUMB = By.cssSelector("mat-slider .mat-slider-thumb");

        private WebDriver webDriver;
        private Actions actions;

        public SliderComponent(WebDriver driver) {
            this.webDriver = driver;
            this.actions = new Actions(this.webDriver);
        }

        public void navigateToInterval(String interval) throws Exception {
            try (IFrameComponent iframe = new IFrameComponent(this.webDriver)) {
                iframe.switchToIframe();

                int sliderPosition = getSliderPosition();
                int desirePosition = SliderInterval.getSliderIntervalByPeriod(interval).getIdentifier();
                int difference = Math.abs(sliderPosition - desirePosition);

                if (sliderPosition <= desirePosition) {
                    goRight(difference);
                } else {
                    goLeft(difference);
                }
            }
        }

        private void goLeft(int times) {
            WebElement slider = this.webDriver.findElement(SLIDER_THUMB);

            for (int i = 1; i <= times; i++) {
                this.actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_LEFT).perform();
            }
        }

        private void goRight(int times) {
            WebElement slider = this.webDriver.findElement(SLIDER_THUMB);

            for (int i = 1; i <= times; i++) {
                this.actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
            }
        }

        private int getSliderPosition() {
            String position = this.webDriver.findElement(SLIDER_INDICATOR).getAttribute("aria-valuenow");
            return Integer.parseInt(position);
        }
    }

}
