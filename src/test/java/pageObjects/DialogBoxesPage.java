package pageObjects;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialogBoxesPage extends BasePage{

    private static final String DIALOG_BOXES_URL = "dialog-boxes.html";
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    //locators
    @FindBy(id = "my-alert")
    private WebElement launchAlertButton;
    @FindBy(id = "my-confirm")
    private WebElement launchConfirmButton;
    @FindBy(id = "confirm-text")
    private WebElement launchConfirmFinal;
    @FindBy(id = "my-prompt")
    private WebElement launchPromptButton;
    @FindBy(id = "prompt-text")
    private WebElement launchPromptFinal;
    @FindBy(id = "my-modal")
    private WebElement launchModalButton;
    @FindBy(className = "modal-body")
    private WebElement launchModal;
    @FindBy(className = "btn-primary")
    private WebElement launchModalSaveButton;
    @FindBy(id = "modal-text")
    private WebElement launchModalFinal;

    public DialogBoxesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage Url")
    public String getDialogBoxesUrl() {
        return DIALOG_BOXES_URL;
    }

    @Step("Get launch alert button")
    public WebElement getLaunchAlertButton() {
        return launchAlertButton;
    }

    @Step("Get launch confirm button")
    public WebElement getLaunchConfirmButton() {
        return launchConfirmButton;
    }

    @Step("Get launch confirm final")
    public WebElement getLaunchConfirmFinal() {
        return launchConfirmFinal;
    }

    @Step("Get launch prompt button")
    public WebElement getLaunchPromptButton() {
        return launchPromptButton;
    }

    @Step("Get launch prompt final")
    public WebElement getLaunchPromptFinal() {
        return launchPromptFinal;
    }

    @Step("Get launch modal button")
    public WebElement getLaunchModalButton() {
        return launchModalButton;
    }

    @Step("Get launch modal")
    public WebElement getLaunchModal() {
        return launchModal;
    }

    @Step("Get launch modal save button")
    public WebElement getLaunchModalSaveButton() {
        return launchModalSaveButton;
    }

    @Step("Get launch modal final")
    public WebElement getLaunchModalFinal() {
        return launchModalFinal;
    }

}
