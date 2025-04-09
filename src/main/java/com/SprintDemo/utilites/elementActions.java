package com.SprintDemo.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementActions {
    private elementActions() {
    }

    //sendkey method
    public static void sendData(WebDriver driver, By locator, String Data) {
        wait.WaitForElementVisible(driver, locator);
        Scrolling.scrolToElemenet(driver, locator);
        findElement(driver,locator).sendKeys(Data);
        LogsUtil.info("data is send to ",Data);

    }

    //click element
    public static void clickElement(WebDriver driver, By locator) {
        wait.WaitForElementVisible(driver, locator);
        Scrolling.scrolToElemenet(driver, locator);
        findElement(driver,locator).click();
        LogsUtil.info(locator.toString(),"button  should be clicked now");

    }

    public  static String getText(WebDriver driver,By locator)
    {
        wait.WaitForElementVisible(driver, locator);
        Scrolling.scrolToElemenet(driver, locator);
         return findElement(driver,locator).getText();
    }
    public static WebElement findElement(WebDriver driver, By locator)
    {
    return driver.findElement(locator);
    }
public static void ClickByJavaScript(WebDriver driver,By locator)
{
    WebElement element = driver.findElement(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);

}
}



