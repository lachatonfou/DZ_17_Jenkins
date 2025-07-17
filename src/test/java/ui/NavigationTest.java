package ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.NavigationPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.HomePage.BASE_URL;

@Story("Navigation tests")
public class NavigationTest extends BaseTest {

    HomePage homePage;
    NavigationPage navigationPage;

    @BeforeEach
    void setupWebForm() {
        homePage = new HomePage(driver);
        navigationPage = homePage.openNavigationPage();
    }

    @Test
    void proverkaStranici(){
        String navFormUrl = navigationPage.getUrl();
        String currentUrl = navigationPage.getCurrentUrl();
        assertEquals(BASE_URL + navFormUrl, currentUrl);

        assertEquals("Navigation example", navigationPage.getTitle());
    }

    @Test
    void proverkaKnopok() {

        navigationPage.getSecondButton().click();
        assertThat(driver.getCurrentUrl()).contains(navigationPage.linkSecondPage);
        assertTrue(navigationPage.getSecondPageText().getText().contains(navigationPage.secondPageTextContains));

        navigationPage.getNextButton().click();
        assertThat(driver.getCurrentUrl()).contains(navigationPage.linkThirdPage);
        assertTrue(navigationPage.getThirdPageText().getText().contains(navigationPage.thirdPageTextContains));

        navigationPage.getPreviousButton().click();
        assertThat(driver.getCurrentUrl()).contains(navigationPage.linkSecondPage);
        assertTrue(navigationPage.getPreviousPageText().getText().contains(navigationPage.secondPageTextContains));
    }
}
