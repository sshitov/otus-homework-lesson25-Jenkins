package Tests;

import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.CoursesPage;
import Helpers.Pages.MainPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

@Epic("Allure.Проверки для Otus")
@Owner(value = "Шитов Сергей")
@DisplayName("Проверка перехода с главной страницы к курсам отфильтрованным по значению - тестирование")
public class OpenCoursesPageFilteredByTesting extends BaseTest {

    protected ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    protected MainPage mainPage = new MainPage();
    protected CoursesPage coursesPage = new CoursesPage();

    @BeforeClass
    public static void loadDriver(){
        ChromeWebDriver.driverLoad();
    }

    @Before
    @Step ("Открыть браузер и перейти на главную страницу")
    public void setUp() {
        chromeWebDriver.create();
        mainPage.init();
        coursesPage.init();
        mainPage.openMainPage();
    }

    @After
    @Step ("Закрыть браузер")
    public void tearDown() {
        ChromeWebDriver.quit();
    }

    @Test
    @Step("Переход к курсам в категории 'тестирование'")
    @Description("Проверяется наименование открытого раздела курсов")
    @DisplayName("Переход к курсам в категории 'тестирование'")
    @Severity(SeverityLevel.BLOCKER)
    public void openCoursesPageFilteredByTesting() {
        mainPage.navigateToCoursesPageFilteredByTesting();
        Assert.assertEquals("Тестирование", coursesPage.courseCategoryName());
    }
}