package com.SprintDemo.pages;
import com.SprintDemo.utilites.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class AddItemPage {
    private WebDriver driver;
    public AddItemPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By MArocoItem=By.cssSelector("img[alt='Marco Lightweight Active Hoodie']");
    private final  By selectMeduimSize=By.id("option-label-size-143-item-168");
    private final By SelectBlueColor=By.id("option-label-color-93-item-50");
    private  final By AddToCardBtn=By.id("product-addtocart-button");
    private  final By successsMessage=By.cssSelector(".message-success.success.message");
    private  final  By ShowCart=By.xpath("//a[@class='action showcart']");
    private final By Counter_number=By.xpath("//span[@class='counter-number']");
    private  final By ClickToproceed=By.xpath("//button[@id='top-cart-btn-checkout']");
    private  final  By EmailAddreess=By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']");
    private  final By FirstName=By.xpath("//div[@name='shippingAddress.firstname']//div[@class='control']//input");
    private  final By LastName=By.xpath("//input[@name='lastname']");
    private  final By CompanyName=By.xpath("//input[@name='company']");
    private final By Address1=By.xpath("//div[@name='shippingAddress.street.0']//div[@class='control']/input");
    private final By Address2=By.xpath("//div[@name='shippingAddress.street.1']//div[@class='control']//input");
    private final By Address3=By.xpath("//div[@name='shippingAddress.street.2']//div[@class='control']//input");
    private  final By City=By.xpath("//div[@name='shippingAddress.city']//div[@class='control']//input");
    private  final  By State_Province=By.xpath("//div[@name='shippingAddress.region_id']//div[@class='control']//select");
    private final  By Zip_Postal_Code=By.xpath("//input[@name='postcode']");
    private  final By Country=By.xpath("//select[@name='country_id']");
    private  final By Phone_Number=By.name("telephone");
    private  final By NextBtn=By.cssSelector(".button.action.continue.primary");
    private  final  By Please_order=By.cssSelector("button[title='Place Order']");
    private  final  By Continue_Shopping=By.xpath("//a[@class='action primary continue']");
    private  final By Page_Title=By.xpath("//*[contains(text(), 'Thank you for your purchase!')]");
    private  final By Size_Required_Message=By.xpath("//div[contains(@id,'super_attribute')]");


public AddItemPage AddItemToCard()
{
    elementActions.clickElement(driver,MArocoItem);
    elementActions.clickElement(driver,selectMeduimSize);
    elementActions.clickElement(driver,SelectBlueColor);
    elementActions.clickElement(driver,AddToCardBtn);
    LogsUtil.info("Item should be added now ");
    return this;
}
public AddItemPage AdditemToCardWithoutSize()
{
    elementActions.clickElement(driver,MArocoItem);
    elementActions.clickElement(driver,SelectBlueColor);
    elementActions.clickElement(driver,AddToCardBtn);
    return this;

}
public  AddItemPage AssertOnSizeRequiredField(String message){
    Assert.assertTrue(elementActions.getText(driver,Size_Required_Message).contains(message));
    return this;

}


public  AddItemPage ChecksuccessfulAdding(String message)
{
    Scrolling.ScrollUP(driver);
    driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    WebElement Sucmessage =driver.findElement(successsMessage);
    String Actualmessage=Sucmessage.getText();
    LogsUtil.info("actual displayed messaged is ",Actualmessage);
    Assert.assertTrue(Sucmessage.getText().contains(message));
    LogsUtil.info("item added sucessfully");
    return this;
}

public void  CompletingPurchase(String emailaddress,String firstname,String lastName,String company,String address1,String address2,String address3,String city,String State,String postalcode,String country,String phone_number) throws InterruptedException {

  //  driver.navigate().to("");
    AddItemToCard();
    Thread.sleep(3000);

    LogsUtil.info("now counter is displayed now ");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    elementActions.clickElement(driver,ShowCart);
    elementActions.clickElement(driver,ClickToproceed);
    elementActions.sendData(driver,EmailAddreess,emailaddress);
    elementActions.sendData(driver,FirstName,firstname);
    elementActions.sendData(driver,LastName,lastName);
    elementActions.sendData(driver,CompanyName,company);
    elementActions.sendData(driver,Address1,address1);
    elementActions.sendData(driver,Address2,address2);
    elementActions.sendData(driver,Address3,address3);
    elementActions.sendData(driver,City,city);
    elementActions.sendData(driver,State_Province,State);
    elementActions.sendData(driver,Zip_Postal_Code,postalcode);
    WebElement selectCountry=driver.findElement(Country);
    Select select=new Select(selectCountry);
    select.selectByVisibleText(country);
    elementActions.sendData(driver,Phone_Number, phone_number);
    LogsUtil.info("now all valide data is entered");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    elementActions.clickElement(driver,NextBtn);
    Thread.sleep(3000);
    elementActions.clickElement(driver,NextBtn);
wait.WaitForElementClickable(driver,Please_order);
  //  elementActions.clickElement(driver,Please_order);
    elementActions.ClickByJavaScript(driver,Please_order);
   // new HomePage(driver).navigateToLoginPage();

}

public void AssertOnSucessfullCompletPurchase(String message)
{
    LogsUtil.info("Expected  message is ",message);
    LogsUtil.info("Actual  message is "+elementActions.getText(driver,Page_Title) );
    wait.WaitForElementVisible(driver,Page_Title);
    Assert.assertTrue(elementActions.getText(driver,Page_Title).contains(message));
  //  WebElement element=driver.findElement(Continue_Shopping);
   // Assert.assertTrue(Continue_Shopping.displayed());
   // assertTrue("The element should be displayed", element.isDisplayed());

}




}
