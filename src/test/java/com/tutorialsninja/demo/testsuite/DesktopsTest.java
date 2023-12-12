package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopsPage;
    ShoppingCartPage shoppingCartPage;


    @BeforeMethod (alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
        desktopsPage = new DesktopsPage();
    }

    @Test (groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        homePage.mouseHoverOnDesktop();
        //1.2 Click on “Show All Desktops”
        homePage.mouseHoverAndClickOnAllShowAllDesktop("Show AllDesktops");
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.sortByNameAToZ("Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(desktopsPage.getProductList(), desktopsPage.getProductList1());


    }

    @Test (groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total ) {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropDown();
        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverAndClickOnPoundSterling();
        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverOnDesktop();
        //2.4 Click on “Show All Desktops”
        homePage.mouseHoverAndClickOnAllShowAllDesktop("Show AllDesktops");
        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.sortByNameAToZ("Name (A - Z)");
        //2.6 Select product <product>
        desktopsPage.allProduct(product);
        //2.7 Enter Qty <qty> using Select class.
        desktopsPage.updateQuantity(qty);
        //2.8 Click on “Add to Cart” button
        desktopsPage.addToCart();
        //2.9 Verify the Message <successMessage>
        String expectedText1 = successMessage;
        String actualText1 = desktopsPage.getSuccessText();
        boolean message = actualText1.contains(expectedText1.trim());
        //2.10 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCart();
        //2.12 Verify the Product name <productName>
        String expectedMessage1 = productName;
        String actualMessage1 = desktopsPage.verifyProductName(productName);
        Assert.assertEquals(actualMessage1, expectedMessage1, "Incorrect Product");
        //2.13 Verify the Model
        String expectedMessage3 = model;
        String actualMessage3 = desktopsPage.verifyModel(model);
        Assert.assertEquals(actualMessage3, expectedMessage3, "Incorrect Model");
        //2.14 Verify the Total
        String expectedTotal = total;
        String actualTotal = desktopsPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Incorrect Total");
    }



    }



