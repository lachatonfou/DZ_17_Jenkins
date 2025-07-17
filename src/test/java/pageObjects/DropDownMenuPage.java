package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DropDownMenuPage extends BasePage{

    private static final String DROP_DOWN_URL = "dropdown-menu.html";

    //locators
    @FindBy(id = "my-dropdown-1")
    private WebElement leftclick;
    @FindBy(id = "my-dropdown-2")
    private WebElement rightclick;
    @FindBy(id = "my-dropdown-3")
    private WebElement doubleclick;

    public DropDownMenuPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    @Step("Get subpage Url")
    public String getUrl() {
        return DROP_DOWN_URL;
    }

    @Step("Get left click menu")
    public WebElement getLeftClickMenu() {
        return leftclick;
    }

    @Step("Get right click menu")
    public WebElement getRightClickMenu() {
        return rightclick;
    }

    @Step("Get double click menu")
    public WebElement getDoubleClickMenu() {
        return doubleclick;
    }

}
