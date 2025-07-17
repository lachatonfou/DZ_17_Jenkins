package ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Login tests")
public class LoginTest extends BaseTest {
    @Test
    void loginPomTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
