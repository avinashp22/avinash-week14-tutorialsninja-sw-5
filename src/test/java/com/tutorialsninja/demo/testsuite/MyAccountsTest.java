package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {




    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){





    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){





    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){





    }




}
