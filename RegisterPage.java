package com.demo.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    //1. Create your page object/object repository in the form of by locators.

    By register = By.xpath("//a[@class='ico-register']");
    By gender = By.xpath("//label[@for=\"gender\"]");
    By radioButtonFemale = By.cssSelector("input[id=\"gender-female\"]");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By dateOfBirthDay = By.xpath("//select[@name=\"DateOfBirthDay\"]");
    By dateOfMonth = By.xpath("//select[@name=\"DateOfBirthMonth\"]");
    By dateOfYear = By.xpath("//select[@name=\"DateOfBirthYear\"]");
    By email = By.cssSelector("input[id=\"Email\"]");
    By companyName = By.id("Company");
    By newsLetter = By.id("Newsletter");
    By password = By.cssSelector("input[id=\"Password\"]");
    By confirmPassword = By.cssSelector("input[id=\"ConfirmPassword\"]");
    By registerButton = By.id("register-button");

    //2. Create a constructor of page class.

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    //3. Page action/methods
    public String getPageTitle() {
        String rpTitle = driver.getTitle();
        System.out.println("Register page title is " + rpTitle);
        return rpTitle;
    }

    public void doRegisterPage(String FirstName, String LastName, String DateOfBirth, String DateOfMonth,
                                   String DateOfYear,String CompanyName,String Email,String Password, String ConfirmPassword) throws InterruptedException {

        driver.findElement(register).click();
        driver.findElement(gender).click();
        driver.findElement(radioButtonFemale).click();
        driver.findElement(firstName).sendKeys(FirstName);
        driver.findElement(lastName).sendKeys(LastName);
        driver.findElement(dateOfBirthDay).sendKeys(DateOfBirth);
        driver.findElement(dateOfMonth).sendKeys(DateOfMonth);
        driver.findElement(dateOfYear).sendKeys(DateOfYear);
        driver.findElement(email).sendKeys(Email);
        Thread.sleep(3000);
        driver.findElement(companyName).sendKeys(CompanyName);
        Thread.sleep(3000);
        driver.findElement(newsLetter).click();
        driver.findElement(password).sendKeys(Password);
        Thread.sleep(3000);
        driver.findElement(confirmPassword).sendKeys(ConfirmPassword);
        driver.findElement(registerButton).click();
        System.out.println("Credential are" + FirstName+" " + LastName +" "+ DateOfBirth + DateOfMonth + DateOfYear + Email + Password
        + CompanyName);




    }


}



