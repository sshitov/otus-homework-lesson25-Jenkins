package Tests;

import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.MainPage;
import Helpers.Pages.RecruitersPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

@Epic("Allure.Проверки для Otus")
@Owner(value = "Шитов Сергей")
@DisplayName("Проверка перехода на страницу IT-Recruiter")
public class OpenRecruiterPage extends BaseTest {

    protected ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    protected MainPage mainPage = new MainPage();
    protected RecruitersPage recruitersPage = new RecruitersPage();

    @BeforeClass
    public static void loadDriver(){
        ChromeWebDriver.driverLoad();
    }

    @Before
    @Step ("Открыть браузер и перейти на главную страницу")
    public void setUp() {
        chromeWebDriver.create();
        mainPage.init();
        recruitersPage.init();
        mainPage.openMainPage();
    }

    @After
    @Step ("Закрыть браузер")
    public void tearDown() {
        ChromeWebDriver.quit();
    }

    @Test
    @Step("Перейти на страницу IT-Recruiter")
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Сравнение заголовка страницы с ожидаемым = 'IT-Recruiter'")
    @DisplayName("Переход на страницу IT-Recruiter")
    public void openRecruiterPage() {

        mainPage.navigateToRecruiterPage();
        Assert.assertEquals("IT-Recruiter", recruitersPage.pageTitleText());
    }
}