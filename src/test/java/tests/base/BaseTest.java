package tests.base;

import common.CommonAction;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import pages.listing.RealtListingPage;
import pages.realtHome.RealtHomePage;

import java.time.Duration;
import java.util.Set;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RealtHomePage realtHomePage = new RealtHomePage(driver);
    protected RealtListingPage realtListingPage = new RealtListingPage(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @AfterEach
    public void teartDown() {
        driver.quit();
    }

    protected void switchToAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
    }

    protected void switchWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String window1 = driver.getWindowHandle();

        js.executeScript("window.open()");

        Set<String> currentWindows = driver.getWindowHandles();

        String window2 = null;

        for (String window : currentWindows) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }

        driver.switchTo().window(window2);
    }
}
