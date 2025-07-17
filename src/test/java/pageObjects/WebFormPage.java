package pageObjects;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebFormPage extends BasePage{
    private static final String WEB_FORM_URL = "web-form.html";
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    //locators
    @FindBy(id = "my-text-id")
    private WebElement textInput;
    @FindBy(xpath = "//label[normalize-space(.)='Text input']")
    private WebElement textInputLabel;
    @FindBy(name = "my-password")
    private WebElement password;
    @FindBy(xpath = "//label[normalize-space(.)='Password']")
    private WebElement passwordLabel;
    @FindBy(name = "my-textarea")
    private WebElement textArea;
    @FindBy(xpath = "//label[normalize-space(.)='Textarea']")
    private WebElement textAreaLabel;
    @FindBy(name = "my-disabled")
    private WebElement disabledInput;
    @FindBy(xpath = "//label[normalize-space(.)='Disabled input']")
    private WebElement disabledInputLabel;
    @FindBy(name = "my-readonly")
    private WebElement readonlyInput;
    @FindBy(xpath = "//label[normalize-space(.)='Readonly input']")
    private WebElement readonlyInputLabel;
    @FindBy(name = "my-select")
    private WebElement dropdownSelect;
    @FindBy(id = "my-check-1")
    private WebElement checkedCheckbox;
    @FindBy(xpath = "//label[normalize-space(.)='Checked checkbox']")
    private WebElement checkedCheckboxLabel;
    @FindBy(id = "my-check-2")
    private WebElement defaultCheckbox;
    @FindBy(xpath = "//label[normalize-space(.)='Default checkbox']")
    private WebElement defaultCheckboxLabel;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage Url")
    public String getWebFormUrl() {
        return WEB_FORM_URL;
    }

    @Step("Get textInput field")
    public WebElement getTextInput() {
        return textInput;
    }

    @Step("Get textInput label")
    public WebElement getTextInputLabel() {
        return textInputLabel;
    }

    @Step("Input text to TextInput")
    public void inputTextInput() {
        textInput.sendKeys(configProperties.getLogin());
    }

    @Step("Get entered text to TextInput")
    public String getEnteredTextTextInput() {
        String enteredText = configProperties.getLogin();
        return enteredText;
    }

    @Step("Get password field")
    public WebElement getPassword() {
        return password;
    }

    @Step("Get password label")
    public WebElement getPasswordLabel() {
        return passwordLabel;
    }

    @Step("Input text to Password")
    public void inputPassword() {
        password.sendKeys(configProperties.getPassword());
    }

    @Step("Get entered text to Password")
    public String getEnteredTextPassword() {
        String enteredText = configProperties.getPassword();
        return enteredText;
    }

    @Step("Get text area field")
    public WebElement getTextArea() {
        return textArea;
    }

    @Step("Get text area label")
    public WebElement getTextAreaLabel() {
        return textAreaLabel;
    }

    @Step("Get disabled input field")
    public WebElement getDisabledInput() {
        return disabledInput;
    }

    @Step("Get disabled input label")
    public WebElement getDisabledInputLabel() {
        return disabledInputLabel;
    }

    @Step("Get readonly input field")
    public WebElement getReadonlyInput() {
        return readonlyInput;
    }

    @Step("Get readonly input label")
    public WebElement getReadonlyInputLabel() {
        return readonlyInputLabel;
    }

    @Step("Get dropdown select field")
    public WebElement getdropdownSelect() {
        return dropdownSelect;
    }

    @Step("Get checked checkbox field")
    public WebElement getcheckedCheckbox() {
        return checkedCheckbox;
    }

    @Step("Get checked checkbox label")
    public WebElement getcheckedCheckboxLabel() {
        return checkedCheckboxLabel;
    }

    @Step("Get default checkbox field")
    public WebElement getdefaultCheckbox() {
        return defaultCheckbox;
    }

    @Step("Get default checkbox label")
    public WebElement getdefaultCheckboxLabel() {
        return defaultCheckboxLabel;
    }
}
