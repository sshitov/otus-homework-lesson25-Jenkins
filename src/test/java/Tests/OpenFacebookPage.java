package Tests;

import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.MainPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

@Epic("Allure.Проверки для Otus")
@Owner(value = "Шитов Сергей")
@DisplayName("Проверка ссылки facebook в футере сайта")
public class OpenFacebookPage extends BaseTest{

    protected ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    protected MainPage mainPage = new MainPage();

    @BeforeClass
    public static void loadDriver(){
        ChromeWebDriver.driverLoad();
    }

    @Before
    @Step ("Открыть браузер и перейти на главную страницу")
    public void setUp() {
        chromeWebDriver.create();
        mainPage.init();
        mainPage.openMainPage();
    }

    @After
    @Step ("Закрыть браузер")
    public void tearDown() {
        ChromeWebDriver.quit();
    }

    @Test
    @Step ("Перейти на страницу facebook")
    @Severity(value = SeverityLevel.CRITICAL)
    @Description("Проверка того, что ссылка корректная и открывается в новом окне браузера")
    @DisplayName("Переход на страницу facebook из футера")
    public void openFacebookPage() {

        mainPage.navigateToFacebookPage();
        selectBrowserTab(1);
        Assert.assertEquals("https://www.facebook.com/otusru/", currentUrl());
    }
}