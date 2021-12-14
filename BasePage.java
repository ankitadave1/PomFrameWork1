package com.demo.nopcommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;
    FileInputStream file;

    /*** This method is used to initialise the driver on the basis of browsername.
     *
     * @param browserName
     * @return
     */

    public WebDriver initialiseDriver(String browserName) {

        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\hetal\\IdeaProjects\\JavaLearning\\Software\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\hetal\\IdeaProjects\\JavaLearning\\" +
                    "PomFramework1\\src\\test\\resources\\BrowserDriver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equals("opera")) {
            System.setProperty("webdriver.opera.driver", "C:\\Users\\hetal\\IdeaProjects\\JavaLearning\\" +
                    "PomFramework1\\src\\test\\resources\\BrowserDriver\\operadriver.exe");
            driver = new OperaDriver();
        } else {
            System.out.println(browserName + "Browser is invalid , Please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }


    public Properties initialiseProperties() throws IOException {
        prop = new Properties();

        try {//Location of file
              file= new FileInputStream("C:\\Users\\hetal\\IdeaProjects\\JavaLearning\\" +
                     "PomFramework1\\src\\test\\resources\\TestData\\config.properties");
            prop.load(file); //Loading the file
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found, please check...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }







}

