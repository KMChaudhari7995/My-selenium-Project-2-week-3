package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully()throws InterruptedException{
        //1.1

        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2
       // Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //1.3
        WebElement dropDown =driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");

        //1.4
        Thread.sleep(2000);
        List<WebElement> beforeSelection = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> beforeSelection1 = new ArrayList<>();
        for (WebElement list: beforeSelection) {
            beforeSelection1.add(String.valueOf(list));
        }
        List<WebElement> afterSelection = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> afterSelection1 = new ArrayList<>();
        for (WebElement list1: afterSelection) {
            afterSelection1.add(String.valueOf(list1));
        }

        Collections.sort(beforeSelection1);
        Collections.reverse(beforeSelection1);
        verifyElementMethod(afterSelection1.toString(),beforeSelection1.toString());
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
            //2.1
            mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
            //2.2
            clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
            //2.3
           /* WebElement dropDown =driver.findElement(By.xpath("//select[@id='input-sort']"));
            Select select = new Select(dropDown);
            select.selectByVisibleText("Price (High > Low)");*/
            selectFromDropDownMenu(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

            //2.4
            clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
           //2.5
           String exceptedTextMacBook ="MacBook";
           WebElement actualTextMacBook = driver.findElement(By.xpath("//h1[normalize-space()='MacBook']"));
           String actualTextMacBook1 = actualTextMacBook.getText();
           verifyElementMethod(actualTextMacBook1,exceptedTextMacBook);

           //2.6
            clickOnElement(By.xpath("//button[@id='button-cart']"));

            //2.7
            String expectedAddMessage = "Success: You have added MacBook to your shopping cart!";
            WebElement actualAddMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            String actualAddMessage1 = actualAddMessage.getText();
            //verifyElementMethod(expectedAddMessage,actualAddMessage1);
            boolean message = actualAddMessage1.contains(expectedAddMessage.trim());
            Assert.assertTrue(message);

            //2.8
             clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

            //2.9
        Thread.sleep(2000);
        String expectedCart = "Shopping Cart  (0.00kg)";
        WebElement actualCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        String actualCart1 = actualCart.getText();
        verifyElementMethod(expectedCart,actualCart1);
        //boolean message4 = actualCart1.contains(expectedCart.trim());
       // Assert.assertTrue(message4);

    //2.10
        String expectedName = "MacBook";
        WebElement actualName = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        String actualName1 = actualName.getText();
        verifyElementMethod(expectedName,actualName1);
       // boolean message1 = actualName1.contains(expectedName.trim());
       // Assert.assertTrue(message1);

        //2.11
        WebElement element = driver.findElement(By.cssSelector("input[value='1']"));
        element.clear();
        sendTextToElement(By.cssSelector("input[value='1']"), "2");
        Thread.sleep(2000);
        //2.12
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13
        String expectedMessageVerify = "Success: You have modified your shopping cart!";
        WebElement actualMessageVerify = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actualMessageVerify1 = actualMessageVerify.getText();
        //verifyElementMethod(expectedMessageVerify,actualMessageVerify1);
        boolean message2 = actualMessageVerify1.contains(expectedMessageVerify.trim());
        Assert.assertTrue(message2);

        //2.14
        String expectedTotal = "$1,204.00";
        WebElement actualTotal = driver.findElement(By.xpath("//tbody//tr//td[6]"));
        String actualTotal1 = actualTotal.getText();
       // boolean message5 =actualTotal1.contains(expectedTotal.trim());
        //Assert.assertTrue(message5);

        //2.15
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16
        String expectedCheckout = "Checkout";
        WebElement actualCheckout = driver.findElement(By.xpath("//h1[normalize-space()='Checkout']"));
        String actualCheckout1 = actualCheckout.getText();
        verifyElementMethod(expectedCheckout,actualCheckout1);

        //2.17
        Thread.sleep(2000);
        String expectedCustomer = "New Customer";
        WebElement actualCustomer = driver.findElement(By.xpath("//h2[normalize-space()='New Customer']"));
        String actualCustomer1 = actualCustomer.getText();
        verifyElementMethod(expectedCustomer,actualCustomer1);

        //2.18
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='guest']"));

        //2.19
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20
        sendTextToElement(By.name("firstname"),"km");
        sendTextToElement(By.name("lastname"),"Chaudhari");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"harsh1@gmail.com");
        sendTextToElement(By.name("telephone"),"123456789");
        sendTextToElement(By.name("address_1"),"Centeral London");
        sendTextToElement(By.name("city"),"Watford");
        sendTextToElement(By.name("postcode"),"Abc dfg");
        Thread.sleep(1000);
        /*WebElement dropDown1 =driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select select1 = new Select(dropDown1);
        select1.selectByVisibleText("United Kingdom");*/
        selectFromDropDownMenu(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");

       /* WebElement dropDown2 =driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select select2 = new Select(dropDown2);
        select2.selectByVisibleText("Greater London");
*/
        selectFromDropDownMenu(By.xpath("//select[@id='input-payment-zone']"),"Greater London");

        // 2.21
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Hello Payment Done");

        //2.23
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25
        Thread.sleep(2000);
        WebElement elementMessage22 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String actual22 = elementMessage22.getText().substring(0,33);
        //System.out.println(actual22);
        String expected22 = "Warning: Payment method required!";
       // boolean message22 = actual22.contains(expected22.trim());
       // Assert.assertTrue(message22);
        verifyElementMethod(expected22,actual22);

    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
