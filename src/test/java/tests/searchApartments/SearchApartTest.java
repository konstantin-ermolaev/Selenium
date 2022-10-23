package tests.searchApartments;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class SearchApartTest extends BaseTest {

    @Test
    public void checkIsRedirectToListing(){
        basePage.open("https://realt.by");

        realtHomePage
                .enterCountRooms()
                .clickToFind();

        realtListingPage
                .checkCountCards();

        switchWindow();

    }
}
