package Helpers.Pages;

import Helpers.DriverManagers.ChromeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitersPage {

    public void init() {
        PageFactory.initElements(ChromeWebDriver.getDriver(), this);
    }

    @FindBy(css = "[class=ri-header__title]")
    protected WebElement pageTitle;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public String pageTitleText(){
        return getPageTitle().getText();
    }
}