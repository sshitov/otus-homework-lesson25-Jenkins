package Tests;

import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.MainPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

@Epic("Allure.Проверки для Otus")
@Owner("Шитов Сергей")
@DisplayName("Проверка перехода на страницу блога с главной страницы")
public class OpenBlogPage extends BaseTest{

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
    @Severity(SeverityLevel.MINOR)
    @Step("Переход на страницу блога и проверка url")
    @Description("Сравнивается текущий url с ожидаемым https://otus.ru/nest/posts/")
    @DisplayName("Переход на страницу блога")
    @Link(name = "Блог", url = "https://otus.ru/nest/posts/")
    public void openBlogPage() {

        mainPage.navigateToBlogPage();
        Assert.assertEquals("https://otus.ru/nest/posts/", currentUrl());
    }

}