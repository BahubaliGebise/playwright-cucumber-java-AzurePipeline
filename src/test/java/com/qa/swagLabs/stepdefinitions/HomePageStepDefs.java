package com.qa.swagLabs.stepdefinitions;

import com.qa.swagLabs.factory.PlaywrightFactory;
import com.qa.swagLabs.pages.HomePage;
import com.qa.swagLabs.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class HomePageStepDefs {
    HomePage homePage = new HomePage(PlaywrightFactory.getPage());
    @Given("^User able to launch application$")
    public void iLandOnHomePage() {
        homePage.navigateToURL();
        Assert.assertTrue("I am on wrong page", homePage.getHomePageTitle().equalsIgnoreCase("Swag Labs"));
    }

    @When("^User enter login details$")
    public void iEnterLoginDetails() {
        System.out.println("Username:  "+ConfigReader.getProperty("username"));
        System.out.println("Password:  "+ConfigReader.getProperty("password"));

        homePage.doLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

    }

    @Then("^Verify login successful at ProductPage$")
    public void iLandToProductPage() {
        homePage.navigateToProductPage();
    }
}
