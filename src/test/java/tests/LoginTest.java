package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest() {

        LoginPage lp = new LoginPage(driver);

        lp.enterUsername("student");
        lp.enterPassword("Password123");
        lp.clickLogin();

        Assert.assertTrue(driver.getPageSource().contains("Logged In Successfully"));

    }

}