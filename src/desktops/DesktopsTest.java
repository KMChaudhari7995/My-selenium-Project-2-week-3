package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    String date ="30";
    String month = "11";
    String year = "2022";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //1.3
        selectFromDropDownMenu(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");


        //1.4 Verify the Product arrange in descending Order
        List<WebElement> beforeselectionlist = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> beforeSelectionList1 = new ArrayList<>();
        for (WebElement list : beforeselectionlist) {
            beforeSelectionList1.add(String.valueOf(list));
        }
        System.out.println(beforeSelectionList1);

        List<WebElement> afterselectionlist = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> afterSelectionList1 = new ArrayList<>();
        for (WebElement list1 : afterselectionlist) {
            afterSelectionList1.add(String.valueOf(list1));
        }

        System.out.println(afterSelectionList1);
        Collections.sort(beforeSelectionList1);
        Collections.reverse(beforeSelectionList1);
        verifyElementMethod(beforeSelectionList1.toString(), afterSelectionList1.toString());
        //   Assert.assertEquals(afterSelectionList1,beforeSelectionList1);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
        //2.1
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
    //2.2
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //2.3
        Thread.sleep(1000);
        selectFromDropDownMenu(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");

        //2.4
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        //2.5
        String actualText = "HP LP3065";
        WebElement expectedText = driver.findElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
        String expectedText1 = expectedText.getText();
        verifyElementMethod(actualText, expectedText1);

/*********************************************************************
                                         *datepicker //2.6
************************************************************************** */
        Thread.sleep(2000);
        /*clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        String monthYear = driver.findElement(By.xpath("//th[normalize-space()='April 2011']")).getText();
        String []a= monthYear.split(" ");
        String mon = a[0];
        String yer = a[1];
        while (true) {
            if(mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)){
                break;
            }else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        //select on date
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker-days']//table//td"));
        for (WebElement dt: allDates) {
            if(dt.getText().equalsIgnoreCase(date)){
                dt.click();
                break;
            }
        }
*/
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        while (true) {
            String monthYear = driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='picker-switch']")).getText();
            //System.out.println(monthYear);// Apr 2011
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));

            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//table//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

        //2.7
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "");

        //2.8
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actualMessage1 = actualMessage.getText().substring(0,56);
        verifyElementMethod(expectedMessage, actualMessage1);
        Thread.sleep(2000);


        //2.10
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.11
        String expectedShopping = "Shopping Cart";
        WebElement actualShopping = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        String actualShopping1 = actualShopping.getText().substring(0,13);
        verifyElementMethod(expectedShopping,actualShopping1);

        //2.12
        String expectedProductName = "HP LP3065";
        WebElement actualProductName = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        String actualProductName1 = actualProductName.getText();
        verifyElementMethod(expectedProductName, actualProductName1);

    //2.13
    String expectedDeliveryDate = "Delivery Date:2022-11-30";
    WebElement actualDeliveryDate = driver.findElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
    String actualDeliveryDate1 = actualDeliveryDate.getText();
    verifyElementMethod(expectedDeliveryDate,actualDeliveryDate1);


        //2.14
        String expectedModel = "Product 21";
        WebElement actualModel = driver.findElement(By.xpath("//td[normalize-space()='Product 21']"));
        String actualModel1 = actualModel.getText();
        verifyElementMethod(expectedModel, actualModel1);

        //2.15
        String expectedTotal = "$122.00";
        WebElement actualTotal = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        String actualTotal1 = actualTotal.getText();
        verifyElementMethod(expectedTotal, actualTotal1);


    }


    @After
    public void tearDown() {

        closeBrowser();
    }
}







