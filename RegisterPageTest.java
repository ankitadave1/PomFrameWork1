package com.demo.nopcommerce.tests;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.security.pkcs11.wrapper.Constants;

import java.io.IOException;
import java.util.Properties;

public class RegisterPageTest {

    BasePage basePage;
    WebDriver driver;
    Properties prop;
    RegisterPage registerPage;

    // BM - T - AM
    // BM - T - AM
    //BT - T - T - T AT

    @BeforeTest
    public void openBrowser() throws IOException {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);

    }

    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() throws InterruptedException {
        Assert.assertEquals(registerPage.getPageTitle(),"nopCommerce demo store. Register" ,"Registerpage title mismatched");
    }

    @Test (priority = 2)
    public void RegisterTest() throws InterruptedException {
        registerPage.doRegisterPage(prop.getProperty("FirstName"), prop.getProperty("LastName"), prop.getProperty("DateOfBirth"),
                prop.getProperty("DateOfMonth"), prop.getProperty("DateOfYear"),prop.getProperty("CompanyName"), prop.getProperty("Email")
                        , prop.getProperty("Password"), prop.getProperty("ConfirmPassword"));
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
