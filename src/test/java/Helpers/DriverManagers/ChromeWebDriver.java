package Helpers.DriverManagers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeWebDriver {

    public static final Logger logger = LogManager.getLogger(ChromeWebDriver.class.getName());

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void driverLoad(){
        WebDriverManager.chromedriver().setup();
        logger.debug("driver is load");
    }

    public void create() {
        ChromeOptions options = new ChromeOptions().setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.debug("driver is created");
    }

    public static void quit(){
        if (driver != null) {
            driver.quit();
        }
        logger.debug("driver is closed");
    }
}