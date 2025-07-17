package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends BasePage{

    //locators
    @FindBy(xpath = "//li[normalize-space(.)='2']")
    private WebElement secondButton;
    @FindBy(xpath = "//li[normalize-space(.)='Previous']")
    private WebElement previousButton;
    @FindBy(xpath = "//li[normalize-space(.)='Next']")
    private WebElement nextButton;
    @FindBy(xpath = "//p[@class='lead']")
    private WebElement textSecondPage;
    @FindBy(xpath = "//p[@class='lead']")
    private WebElement textThirdPage;
    @FindBy(xpath = "//p[@class='lead']")
    private WebElement textPreviousPage;

    private static final String NAV_FORM_URL = "navigation1.html";
    public String linkSecondPage = "navigation2.html";
    public String linkThirdPage = "navigation3.html";
    public String secondPageTextContains = "Ut enim ad minim veniam";
    public String thirdPageTextContains = "Excepteur sint occaecat";

    public NavigationPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    @Step("Get second button")
    public WebElement getSecondButton() {
        return secondButton;
    }

    @Step("Get second page text")
    public WebElement getSecondPageText() {
        return textSecondPage;
    }

    @Step("Get third page text")
    public WebElement getThirdPageText() {
        return textThirdPage;
    }

    @Step("Get previous page text")
    public WebElement getPreviousPageText() {
        return textPreviousPage;
    }

    @Step("Get next button")
    public WebElement getNextButton() {
        return nextButton;
    }

    @Step("Get previous button")
    public WebElement getPreviousButton() {
        return previousButton;
    }

    @Step("Get subpage url")
    public String getUrl() {
        return NAV_FORM_URL;
    }
}
