package pageObjects;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @FindBy(xpath = "//a[@href = 'login-form.html']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@href = 'web-form.html']")
    private WebElement webFormButton;
    @FindBy(xpath = "//a[@href = 'navigation1.html']")
    private WebElement navigationButton;
    @FindBy(xpath = "//a[@href = 'dropdown-menu.html']")
    private WebElement dropdownMenuButton;
    @FindBy(xpath = "//a[@href = 'dialog-boxes.html']")
    private WebElement dialogBoxesButton;

    public HomePage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
        openHome();
    }

    @Step("Open homepage")
    private void openHome() {
        driver.get(BASE_URL);
    }

    @Step("Open Login page")
    public LoginPage openLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @Step("Open Web form page")
    public WebFormPage openWebFormPage() {
        webFormButton.click();
        return new WebFormPage(driver);
    }

    @Step("Open Navigation page")
    public NavigationPage openNavigationPage() {
        navigationButton.click();
        return new NavigationPage(driver);
    }

    @Step("Open DropDown menu page")
    public DropDownMenuPage openDropDownMenuPage() {
        dropdownMenuButton.click();
        return new DropDownMenuPage(driver);
    }

    @Step("Open DialogBoxes page")
    public DialogBoxesPage openDialogBoxesPage() {
        dialogBoxesButton.click();
        return new DialogBoxesPage(driver);
    }

    @Step("Get web title")
    public String getWebTitle() {
        return driver.getTitle();
    }

}
