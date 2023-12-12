package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.UUID;


@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    LaptopsAndNotebooksPage laptopAndBookPage;
    MacBookPage macBook;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;


    @BeforeMethod (alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        laptopAndBookPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
        macBook = new MacBookPage();
    }

    @Test (groups = {"sanity", "smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.mouseHoverOnShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        laptopAndBookPage.sortByFilter("Name (A - Z)");
        //1.4 Verify the Product price will arrange in High to Low order.
        String exceptedMessage = laptopAndBookPage.beforeSortPriceHighToLow().toString();
        String actualMessage = laptopAndBookPage.afterSortPriceHighToLow().toString();
        Assert.assertEquals(exceptedMessage, actualMessage);



    }

    @Test  (groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        homePage.mouseHoverOnCurrencyDropDown();
        homePage.mouseHoverAndClickOnPoundSterling();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.mouseHoverOnShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopAndBookPage.sortByFilter("Name (A - Z)");
        //2.4 Select Product “MacBook”
        laptopAndBookPage.clikOnMacBook();
        //2.5 Verify the text “MacBook”
        String expectedMessage = "MacBook";
        String actualMessage = macBook.getMacBookText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.6 Click on ‘Add To Cart’ button
        macBook.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        expectedMessage = "Success: You have added MacBook to your shopping cart!\n";
        actualMessage = macBook.getSuccessText();
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);
        //2.8 Click on link “shopping cart” display into success message
        macBook.clickOnShoppingCartLink();
        //2.9 Verify the text "Shopping Cart"
        expectedMessage = "Shopping Cart  (0.00kg)";
        actualMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.10 Verify the Product name "MacBook"
        expectedMessage = "MacBook";
        actualMessage = shoppingCartPage.getMacBookText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.11 Change Quantity "2"
        shoppingCartPage.updateQuantity("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateButton();
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();
        //2.16 Verify the text “Checkout”
        expectedMessage = "Checkout";
        actualMessage = checkOutPage.getCheckOutText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //2.18 Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckOut();

        //2.19 Click on “Continue” tab
        checkOutPage.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        checkOutPage.enterFirstName("AAvviinaasshh");
        checkOutPage.enterLastName("Paatteell");
        String name = UUID.randomUUID().toString();
        String email = name + "@gmail.com";
        checkOutPage.enterEmail(email);
        checkOutPage.enterPhoneNumber("07795462135");
        checkOutPage.enterAddress1("1 Prime Road");
        checkOutPage.enterCity("London");
        checkOutPage.enterPostCode("NW104ER");
        checkOutPage.selectCountry("United Kingdom");
        checkOutPage.selectRegion("Greater London");

        //2.21 Click on “Continue” Button
        checkOutPage.clickOnGuestContinue();

        //2.22 Add Comments About your order into text area
        checkOutPage.enterComments("Thank You");

        //2.23 Check the Terms & Conditions check box
        checkOutPage.clickOnAgree();

        //2.24 Click on “Continue” button
        checkOutPage.clickOnLastContinueCheckOutButton();

        //2.25 Verify the message “Warning: Payment method required!”
        expectedMessage = "Warning: No Payment options are available. Please contact us for assistance!";
        actualMessage = checkOutPage.getPaymentWarningText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    }






