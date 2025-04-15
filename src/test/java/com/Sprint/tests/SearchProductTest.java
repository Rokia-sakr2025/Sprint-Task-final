package com.Sprint.tests;
import com.SprintDemo.drivers.DriverManager;
import com.SprintDemo.pages.HomePage;
import com.SprintDemo.utilites.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static com.Sprint.tests.AddItemToTheCartTest.Allure_Result;

public class SearchProductTest
{
    private WebDriver driver;
    String SearchKey="Selene Yoga Hoodie";
    @BeforeSuite
    public  void beforesuit()
    {
        FileUtils.deleteFiles(Allure_Result);
    }
    // Tests
    @BeforeTest
    public void setUpdriver() {
        driver= DriverManager.createInstance("chrome");
        new HomePage(driver).navigateToLoginPage();


    }
    @Test
    public void SearchProduct()
    {
        HomePage homePage=new HomePage(driver);
        homePage.SearchForProduct(SearchKey).checkSuccessfulsearch(SearchKey);
    }


    @AfterClass(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}
