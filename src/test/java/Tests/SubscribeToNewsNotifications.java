package Tests;

import Helpers.DriverManagers.ChromeWebDriver;
import Helpers.Pages.MainPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

@Epic("Allure.Проверки для Otus")
@Owner(value = "Шитов Сергей")
@DisplayName("Проверка подписки на новости с формы в подвале сайта")
public class SubscribeToNewsNotifications extends BaseTest {

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
    @Step ("Заполнение поля ввода email валидным значением и нажатие кнопки подписки")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется, что после отправки запроса на подписку, появляется сообщение об успешной отправке")
    @DisplayName("Подписка на новости")
    public void subscribeToNewsNotifications() {

        mainPage.fillTheSubscribeField("example@example.ru");
        mainPage.submitSubscribeForm();
        Assert.assertTrue(mainPage.successSubscribeMessageIsPresent());
    }
}