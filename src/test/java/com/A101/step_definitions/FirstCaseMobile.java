package com.A101.step_definitions;

import com.A101.pages.FirstCasePageMobile;
import com.A101.utilities.AppiumSingleton;
import com.A101.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstCaseMobile {

    FirstCasePageMobile page = new FirstCasePageMobile();
    WebDriverWait wait = new WebDriverWait(AppiumSingleton.getDriver(),200);
    Faker faker = new Faker();

    @Given("user open mobile app")
    public void user_open_mobile_app() {
        AppiumSingleton.getDriver();

        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert =   AppiumSingleton.getDriver().switchTo().alert();

        alert.dismiss();


    }

    @When("user click {string}, {string} and {string} tab on mobile app")
    public void userClickAndTabOnMobileApp(String clothes, String womenUnd, String kneeSocks) {

        page.categories.click();
        page.textViewElementWithName(clothes).click();
        page.textViewElementWithName(womenUnd).click();
        page.textViewElementWithName(kneeSocks).click();



    }

    @And("user click object display {string} one on mobile app")
    public void userClickObjectDisplayOneOnMobileApp(String blackOne) {


        BrowserUtils.waitFor(15);

        page.textViewElementWithName(blackOne).click();


    }

    @And("user click {string} button, {string} button , {string} button , {string} button on mobile app")
    public void userClickSepeteEkleButtonButtonButtonButtonOnMobileApp(String addToCart, String goToCart, String confCart, String conWithoutSignIn) {
        BrowserUtils.waitFor(10);
        page.textViewElementWithName(addToCart).click();
        BrowserUtils.waitFor(10);
        page.textViewElementWithName(goToCart).click();
        BrowserUtils.waitFor(10);
        Assertions.assertEquals("SİYAH", page.selectedColor.getAttribute("text"));
        page.textViewElementWithName(confCart).click();
        BrowserUtils.waitFor(5);
        page.textViewElementWithName(conWithoutSignIn).click();


    }

    @And("user displayed mail section on the page and enter a mail address on mobile app")
    public void userDisplayedMailSectionOnThePageAndEnterAMailAddressOnMobileApp() {

        page.mailBox.sendKeys(faker.internet().emailAddress());
       // page.agrementCheckBox.click();
        List<MobileElement> checkBox = AppiumSingleton.getDriver().findElements(MobileBy.className("android.view.ViewGroup"));
        checkBox.get(3).click();
        //page.textViewElementWithName("GÖNDER");
        page.sendButton.click();
        BrowserUtils.waitFor(10);


    }

    @And("user click {string} button on mobile app")
    public void userClickYeniAdresOlusturButtonAndDisplayedPopUpOnThePageOnMobileApp(String newAddress) {
        page.cookiesAcceptButton.click();
        page.viewElementWithName(newAddress).click();



    }

    @And("user enter {string} as Adres Başlığı, {string} , {string} , {string}, {string} and select {string} city, {string} township and {string} district and click KAYDET button on mobile app")
    public void userEnterAsAdresBasligiAndSelectCityTownshipAndDistrictAndClickKAYDETButtonOnMobileApp(String addressTitle, String firstName, String lastName, String cellPhone, String fullAddress, String city, String township, String district) {

        page.addressTextBoxs.get(0).sendKeys(addressTitle);
        firstName = faker.name().firstName();
        page.addressTextBoxs.get(1).sendKeys(firstName);
        lastName = faker.name().lastName();
        page.addressTextBoxs.get(2).sendKeys(lastName);
        cellPhone=faker.numerify("5#########");
        page.addressTextBoxs.get(3).sendKeys(cellPhone);
        page.addressDropdown.click();
        page.selectFromDropdown(city).click();
        page.addressDropdown.click();
        page.selectFromDropdown(township).click();
        page.addressDropdown.click();
        page.selectFromDropdown(district).click();
        fullAddress = district + " " + faker.address().buildingNumber() + " " + township+"/"+city;
        page.addressTextBoxs.get(4).click();
        page.addressTextBoxs.get(4).sendKeys(fullAddress);

        BrowserUtils.scroolDownMobileApp();

        wait.until(ExpectedConditions.visibilityOf(page.saveButton)).click();

        BrowserUtils.waitFor(5);

    }

    @And("user select {int} cargo firm and click Kaydet Ve Devam Et button on mobile app")
    public void userSelectCargoFirmAndClickKaydetVeDevamEtButtonOnMobileApp(int cargoNumber) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.className("android.widget.RadioButton")));
        page.cargoRadioButtons.get(cargoNumber).click();

        page.saveAndContinueButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("user select {int} payment tab, click {string} and complete order and display payment web page on mobile app")
    public void userSelectPaymentTabAndCompleteOrderAndDisplayPaymentWebPageOnMobileApp(int paymentNumber, String paymentButton) {
        page.paymentTabs.get(paymentNumber -1).click();
        page.garantiAgreement.click();
        page.viewElementWithName(paymentButton).click();
        BrowserUtils.waitFor(5);

        Assert.assertTrue(page.garantiPayImage.isDisplayed());

    }
}
