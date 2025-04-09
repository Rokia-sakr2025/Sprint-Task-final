package com.Sprint.tests;
import com.SprintDemo.Data.ExcelReader;
import com.SprintDemo.drivers.DriverManager;
import com.SprintDemo.pages.AddItemPage;
import com.SprintDemo.pages.HomePage;
import com.SprintDemo.utilites.FileUtils;
import com.SprintDemo.utilites.LogsUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class AddItemToTheCartTest
{

    private WebDriver driver;
    String SucessfulMessage="You added Marco Lightweight Active Hoodie to your";
    String ThankYouMessage="Thank you for your purchase!";
    File Allure_Result=new File("allure-results");
    String RequiredSizefeild="This is a required field.";

    @BeforeSuite
    public  void beforesuit()
    {
        FileUtils.deleteFiles(Allure_Result);
    }
    @BeforeMethod
    public void setUpdriver() {
        driver= DriverManager.createInstance("chrome");
        LogsUtil.info("driver is intialised now ");
        new HomePage(driver).navigateToLoginPage();

    }
    @Test
    private void AddItemToCard()
    {
        new  AddItemPage(driver)
        .AddItemToCard().ChecksuccessfulAdding(SucessfulMessage);
        LogsUtil.info("item should be added to card now ");
    }

    @Test
    private void AssertOnSizeIsRequired()
    {
        new AddItemPage(driver).AdditemToCardWithoutSize().AssertOnSizeRequiredField(RequiredSizefeild);
    }

    @DataProvider(name="ExcelData")
    public Object[][] userRegisterationData() throws IOException {
        //get data from excel reader
        ExcelReader er=new ExcelReader();
        return er.getExcelData();
    }
    @Test(priority = 1,dataProvider = "ExcelData")
    public void fullPurchaseprocess(String emailaddress,String firstname,String lastName,String company,String address1,String address2,String address3,String city,String State,String postalcode,String country,String phone_number) throws InterruptedException {
        new  AddItemPage(driver).CompletingPurchase
        (emailaddress,firstname,lastName,company,address1,address2,address3,city,State,postalcode,country,phone_number);
        new  AddItemPage(driver).AssertOnSucessfullCompletPurchase(ThankYouMessage);
    }
    @AfterMethod(enabled = true)
    public void tearDown() {

        driver.quit();
        LogsUtil.info("the driver is closed successfully ");
    }
}
