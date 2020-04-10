package Tests;

import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.MainPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

@Epic("Allure.Проверки для Otus")
@Owner(value = "Шитов Сергей")
@DisplayName("Проверка перехода на страницу Terms of use")
public class OpenTermsOfUsePage extends BaseTest{

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
    @Step("Открыть страницу 'Terms of use'")
    @Severity(value = SeverityLevel.TRIVIAL)
    @Description("Сравнивается url страницы с ожидаемым https://otus.ru/legal/terms/")
    @DisplayName("Переход на страницу Terms of use")
    public void openTermsOfUsePage() {

        mainPage.navigateToTermsOfUsePage();
        Assert.assertEquals("https://otus.ru/legal/terms/", currentUrl());
    }
}