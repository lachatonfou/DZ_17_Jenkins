package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DialogBoxesPage;
import pageObjects.HomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

@Story("Dialog boxes tests")
public class DialogBoxesTest extends BaseTest{
    HomePage homePage;
    DialogBoxesPage dialogBoxesPage;

    @BeforeEach
    void setupDialogBoxes() {
        homePage = new HomePage(driver);
        dialogBoxesPage = homePage.openDialogBoxesPage();
    }

    @Test
    void openDialogBoxesTest() {
        assertEquals(BASE_URL + dialogBoxesPage.getDialogBoxesUrl(), dialogBoxesPage.getCurrentUrl());
        assertEquals("Dialog boxes", dialogBoxesPage.getTitle());
    }

    @Test
    void proverkaLaunchAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        dialogBoxesPage.getLaunchAlertButton().click();
        Alert launchAlert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Hello world!", launchAlert.getText());
        launchAlert.accept();
    }

    @Test
    void proverkaLaunchConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        dialogBoxesPage.getLaunchConfirmButton().click();

        Alert launchConfirm = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Is this correct?", launchConfirm.getText());
        launchConfirm.accept();

        assertEquals("You chose: true", dialogBoxesPage.getLaunchConfirmFinal().getText());
    }

    @Test
    void proverkaLaunchPrompt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        dialogBoxesPage.getLaunchPromptButton().click();

        Alert launchPrompt = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Please enter your name", launchPrompt.getText());
        launchPrompt.sendKeys("Mariya");
        launchPrompt.accept();

        assertEquals("You typed: Mariya", dialogBoxesPage.getLaunchPromptFinal().getText());
    }

    @Test
    void proverkaLaunchModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dialogBoxesPage.getLaunchModal()));

        dialogBoxesPage.getLaunchModalButton().click();
        assertEquals("This is the modal body", dialogBoxesPage.getLaunchModal().getText() );

        dialogBoxesPage.getLaunchModalSaveButton().click();
        assertEquals("You chose: Save changes", dialogBoxesPage.getLaunchModalFinal().getText() );
    }
}
