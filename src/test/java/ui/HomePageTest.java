package ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("HomePage tests")
public class HomePageTest extends BaseTest{

    HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage(driver); // Инициализируем homePage с драйвером
    }

    @Test
    void OpenHomePageTest() {

        String actualTitle = homePage.getWebTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
