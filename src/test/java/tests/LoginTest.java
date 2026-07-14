package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;


public class LoginTest extends BaseClass {

	 @DataProvider(name="loginData")
	    public Object[][] loginData()
	    {
	        return new Object[][]
	        {
	            {"student","Password123","success"},
	            {"student","WrongPassword","invalid password"},
	            {"wronguser","Password123","invalid username"}
	        };
	    }
	
	
	
    @Test(dataProvider="loginData")
    public void loginTest(String username, String password, String expectedResult) {
    	
    	LoginPage lp = new LoginPage(driver);

        lp.enterUsername(username);

        lp.enterPassword(password);
       

        lp.clickLogin();
        
    	
    	if(expectedResult.equals("success"))
    	{
    	    Assert.assertTrue(driver.getPageSource()
    	            .contains("Logged In Successfully"));
    	}
    	else if(expectedResult.equals("invalid password"))
    	{
    	    Assert.assertTrue(driver.getPageSource()
    	            .contains("Your password is invalid!"));
    	}
    	else if(expectedResult.equals("invalid username"))
    	{
    	    Assert.assertTrue(driver.getPageSource()
    	            .contains("Your username is invalid!"));
    	}

    	
        
        
    }

        
      
        
      /*  @Test
        public void invalidPasswordTest() {

            LoginPage lp = new LoginPage(driver);

            lp.enterUsername("student");
            lp.enterPassword("WrongPassword");
            lp.clickLogin();

            Assert.assertTrue(driver.getPageSource().contains("Your password is invalid!"));
        }

        @Test
        public void invalidUsernameTest() {

            LoginPage lp = new LoginPage(driver);

            lp.enterUsername("wronguser");
            lp.enterPassword("Password123");
            lp.clickLogin();
            Assert.assertTrue(driver.getPageSource().contains("Your username is invalid!"));
        }
      

       */
}	