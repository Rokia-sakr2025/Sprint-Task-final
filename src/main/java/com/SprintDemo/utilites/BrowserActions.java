package com.SprintDemo.utilites;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions() {
    }

    public static void navigateToURL(WebDriver driver, String url)
    {
        driver.get(url);
        LogsUtil.info("URL now is ",url);
    }
    public static String getCurrentURL(WebDriver driver){
        LogsUtil.info("current Url IS ",driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public static String getPageTitle(WebDriver driver)
    {
        LogsUtil.info("page title is  ",driver.getTitle());
        return driver.getTitle();
    }
    public static void refresh(WebDriver driver)
    {
        LogsUtil.info(" page is refreshed now ");
        driver.navigate().refresh();
    }
}
