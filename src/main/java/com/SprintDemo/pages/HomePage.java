package com.SprintDemo.pages;
import com.SprintDemo.utilites.BrowserActions;
import com.SprintDemo.utilites.LogsUtil;
import com.SprintDemo.utilites.Validations;
import com.SprintDemo.utilites.elementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //locators
    private final By SearchTextBox=By.id("search");
    private  final By searchButton=By.cssSelector("button[title='Search']");
    private final By SearchResult=By.xpath("//img[@alt='Selene Yoga Hoodie']");

    public void navigateToLoginPage() {
//        driver.navigate().to("https://www.saucedemo.com/");
        BrowserActions.navigateToURL(driver, "https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
    }
    public  HomePage  SearchForProduct(String searchKey)
    {
        elementActions.sendData(driver,SearchTextBox , searchKey);
        elementActions.ClickByJavaScript(driver,searchButton);
     //   elementActions.clickElement(driver,searchButton);
        LogsUtil.info("search key ",searchKey, "should be displayed now ");
        return this;
    }
 public HomePage checkSuccessfulsearch(String searchresult)
  {
      WebElement result = driver.findElement(SearchResult);
      String resultvalue =result.getAttribute("alt");
      Assert.assertTrue(resultvalue.contains(searchresult));
      LogsUtil.info("hello ,successful search should be displayed now ");
      return this;
  }

}
