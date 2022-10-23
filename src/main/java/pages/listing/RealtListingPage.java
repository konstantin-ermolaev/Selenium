package pages.listing;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.realtHome.RealtHomePage;

public class RealtListingPage extends BasePage {
    public RealtListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[@class='listing view-format']//div[@data-mode='3']");

    public RealtListingPage checkCountCards(){
        waitElementIsVisible(driver.findElement(card));
        int countCards = driver.findElements(card).size();
        Assertions.assertEquals(countCards, 20);
        return this;
    }
}
