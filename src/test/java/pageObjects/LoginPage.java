package pageObjects;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(configProperties.getBaseUrl() + "login-form.html");
    }

    @Step("Login with valid user and password")
    public void login() {
        usernameInput.sendKeys(configProperties.getLogin());
        passwordInput.sendKeys(configProperties.getPasswordLogin());
        loginButton.click();
    }
}