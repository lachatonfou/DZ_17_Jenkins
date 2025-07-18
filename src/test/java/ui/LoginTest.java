package ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Login tests")
public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeEach
    void setupLogin() {
        homePage = new HomePage(driver);
        loginPage = homePage.openLoginPage();
    }

    @Test
    void loginTest() throws InterruptedException {

        loginPage.login();

        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
