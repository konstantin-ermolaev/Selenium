package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static common.Config.*;
import static org.junit.jupiter.api.Assertions.fail;


public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction() {
    }

    public static WebDriver createDriver() {
        if(driver == null){
            switch (PLATFORM_AND_BROWSER) {
                case "win_chrome":
                    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "win_firefox":
                    System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "win_ie" :
                    System.setProperty("webdriver.ie.driver","src/main/resources/IEDriverServer.exe");
                    driver = new ChromeDriver();
                    break;
                default:
                    System.out.println(fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER).toString());
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        }

        return driver;
    }
}
