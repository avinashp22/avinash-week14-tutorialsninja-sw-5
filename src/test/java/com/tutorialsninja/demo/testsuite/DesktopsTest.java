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
public class DesktopsTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test (groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {




    }

    @Test (groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total ) {





    }

    @Test (groups = {"regression"})
    public void verifyProductAddedToShoppinCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total ) {





    }



}
