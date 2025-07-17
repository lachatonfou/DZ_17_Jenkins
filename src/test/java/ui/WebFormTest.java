package ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;
import pageObjects.WebFormPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

@Story("WebForm tests")
public class WebFormTest extends BaseTest{

    HomePage homePage;
    WebFormPage webFormPage;

    @BeforeEach
    void setupWebForm() {
        homePage = new HomePage(driver);
        webFormPage = homePage.openWebFormPage();
    }

    @Test
    void openWebFormTest() {
        String currentUrl = webFormPage.getCurrentUrl();
        System.out.println(currentUrl);
        String webFormUrl = webFormPage.getWebFormUrl();
        System.out.println(webFormUrl);
        assertEquals(BASE_URL + webFormUrl, currentUrl);

        assertEquals("Web form", webFormPage.getTitle());
    }

    @Test
    void proverkaTextInput() {
        webFormPage.inputTextInput();
        String enteredValue = webFormPage.getTextInput().getAttribute("value");
        assertEquals(webFormPage.getEnteredTextTextInput(), enteredValue);

        assertEquals("Text input", webFormPage.getTextInputLabel().getText());
    }

    @Test
    void proverkaPassword() {
        webFormPage.inputPassword();
        String enteredValue = webFormPage.getPassword().getAttribute("value");
        assertEquals(webFormPage.getEnteredTextPassword(), enteredValue);

        assertEquals("Password", webFormPage.getPasswordLabel().getText());
    }

    @Test
    void proverkaTextArea() {
        webFormPage.getTextArea().sendKeys("uwuwu");
        assertEquals("uwuwu", webFormPage.getTextArea().getAttribute("value"));
        assertEquals("Textarea", webFormPage.getTextAreaLabel().getText());
    }

    @Test
    void proverkaDisabledInput() {
        Assertions.assertFalse(webFormPage.getDisabledInput().isEnabled());
        Assertions.assertThrows(ElementNotInteractableException.class, () -> webFormPage.getDisabledInput().sendKeys("test"));
        assertEquals("Disabled input", webFormPage.getDisabledInput().getAttribute("placeholder"));
        assertEquals("Disabled input", webFormPage.getDisabledInputLabel().getText());
    }

    @Test
    void proverkaReadonlyInput() {
        Assertions.assertTrue(webFormPage.getReadonlyInput().isEnabled());
        assertEquals("Readonly input", webFormPage.getReadonlyInput().getAttribute("value"));
        assertEquals("Readonly input", webFormPage.getReadonlyInputLabel().getText());
    }

    @Test
    void proverkaDropdownSelect() {
        Select dropdown = new Select(webFormPage.getdropdownSelect());
        dropdown.selectByVisibleText("Two");
        assertEquals("Two", dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("3");
        assertEquals("Three", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    void proverkaCheckedCheckbox() {
        webFormPage.getcheckedCheckbox().click();
        assertEquals("Checked checkbox", webFormPage.getcheckedCheckboxLabel().getText());
        assertEquals(false, webFormPage.getcheckedCheckbox().isSelected());
    }

    @Test
    void proverkaDefaultCheckbox() {
        webFormPage.getdefaultCheckbox().click();
        assertEquals("Default checkbox", webFormPage.getdefaultCheckboxLabel().getText());
        assertEquals(true, webFormPage.getdefaultCheckbox().isSelected());
    }
}
