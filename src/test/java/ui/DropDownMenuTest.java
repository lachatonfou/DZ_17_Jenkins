package ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.DropDownMenuPage;
import pageObjects.HomePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("DropDown menu tests")
public class DropDownMenuTest extends BaseTest{
    HomePage homePage;
    DropDownMenuPage dropDownMenuPage;

    @BeforeEach
    void setupWebForm() {
        homePage = new HomePage(driver);
        dropDownMenuPage = homePage.openDropDownMenuPage();
    }

    @Test
    void proverkaDropdownMenu(){
        Actions actions = new Actions(driver);
        actions.click(dropDownMenuPage.getLeftClickMenu()).perform();
        List<WebElement> menuItems1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu show']"));
        WebElement firstItem1 = menuItems1.get(0);
        String[] firstItemText1 = firstItem1.getText().split("\n");
        assertEquals("Action", firstItemText1[0]);
    }

    @Test
    void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(dropDownMenuPage.getRightClickMenu()).perform();
        List<WebElement> menuItems2 = driver.findElements(By.id("context-menu-2"));
        WebElement firstItem2 = menuItems2.get(0);
        String[] firstItemText2 = firstItem2.getText().split("\n");
        assertEquals("Action", firstItemText2[0]);
    }

    @Test
    void doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(dropDownMenuPage.getDoubleClickMenu()).perform();
        List<WebElement> menuItems3 = driver.findElements(By.id("context-menu-3"));
        WebElement firstItem3 = menuItems3.get(0);
        String[] firstItemText3 = firstItem3.getText().split("\n");
        assertEquals("Action", firstItemText3[0]);
    }
}
