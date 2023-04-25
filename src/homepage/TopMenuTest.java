package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public  void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        String menu = "Show AllDesktops";
        selectMenu(menu);

        String expectedDesktop = "Desktops";
        WebElement actualDesktop = driver.findElement(By.xpath("//h2[normalize-space()='Desktops']"));
        String actualDesktop1 = actualDesktop.getText();
        verifyElementMethod(expectedDesktop,actualDesktop1);
    }
@Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        String menu = "Show AllLaptops & Notebooks";
        selectMenu(menu);

        String expectedLaptop = "Laptops & Notebooks";
        WebElement actualLaptop = driver.findElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        String actualLaptop1 = actualLaptop.getText();
        verifyElementMethod(expectedLaptop,actualLaptop1);
}
@Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Components']"));
        String menu ="Show AllComponents";
        selectMenu(menu);

    String expectedLaptop = "Components";
    WebElement actualLaptop = driver.findElement(By.xpath("//h2[normalize-space()='Components']"));
    String actualLaptop1 = actualLaptop.getText();
    verifyElementMethod(expectedLaptop,actualLaptop1);
}






    @After
    public void tearDown() {

        closeBrowser();
    }
}