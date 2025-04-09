package com.Sprint.tests;
import com.SprintDemo.drivers.DriverManager;
import com.SprintDemo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class SearchProductTest
{
    private WebDriver driver;
    String SearchKey="Selene Yoga Hoodie";
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


    @AfterClass(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
