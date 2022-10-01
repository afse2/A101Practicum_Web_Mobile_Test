package com.A101.step_definitions;

import com.A101.pages.FirstCasePage;
import com.A101.utilities.BrowserUtils;
import com.A101.utilities.ConfigurationReader;
import com.A101.utilities.Driver;
import com.A101.utilities.FirstCaseUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FirstCase {

    FirstCasePage page = new FirstCasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
    Faker faker = new Faker();

    @Given("user navigate base page")
    public void user_navigate_base_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        try {
            page.acceptCookiesButton.click();
        } catch (Exception e) {

        }

    }

    @When("user click {string}, {string} and {string} tab")
    public void user_click_and_tab(String giyimAndAksesuar, String kadinIcGiyim, String dizAltiCorap) {

        page.giyimTab.click();
        page.clickWithLinkText(kadinIcGiyim);
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.partialLinkText(dizAltiCorap))));
        page.clickWithLinkText(dizAltiCorap);
    }

    @When("user click {int} object display {string} one")
    public void user_click_object_display_one(Integer count, String color) {
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title=\"Penti Kadın 50 Denye Pantolon Çorabı Siyah\"]")));
        List<WebElement> socksList = page.socksList;
        wait.until(ExpectedConditions.elementToBeClickable(socksList.get(count - 1)));
        socksList.get(count - 1).click();
        Assert.assertTrue(page.selectedColor.getText().equalsIgnoreCase(color));
    }

    @When("user click Sepete Ekle button, {string} button , {string} button , {string} button")
    public void user_click_button(String sepetiGoruntule, String sepetiOnayla, String uyeOlmadanDevam) {
        page.addToCart.click();
        page.clickWithLinkText(sepetiGoruntule);
        page.clickWithLinkText(sepetiOnayla);
        page.clickWithLinkText(uyeOlmadanDevam);

    }


    @When("user displayed mail section on the page and enter a mail address")
    public void user_displayed_mail_section_on_the_page_and_enter_a_mail_address() {
        //page.emailBox.sendKeys(faker.regexify("[a-z1-9]{10}") + "@gmail.com");
        page.emailBox.sendKeys(faker.internet().emailAddress());
        page.continueButton.click();

    }

    @When("user click Yeni adres oluştur button and displayed {string} pop-up on the page")
    public void user_click_button_and_displayed_pop_up_on_the_page(String adresGuncelleme) {
        page.newAddress.click();
        Assert.assertTrue(adresGuncelleme.equalsIgnoreCase(page.updateAddress.getText()));

    }

    @When("user enter {string} as Adres Başlığı, {string} , {string} , {string}, {string} and select city, township and district and click KAYDET button")
    public void user_enter_and_select_city_district_and_quarter_and_click_button(String title, String firstName, String lastName, String phoneNumber, String fullAddress) {

        firstName = faker.elderScrolls().firstName();
        lastName = faker.elderScrolls().lastName();
        phoneNumber = faker.numerify("5#########");


        page.addressTitle.sendKeys(title);
        page.firstName.sendKeys(firstName);
        page.lastName.sendKeys(lastName);
        page.phoneNumber.click();
        page.phoneNumber.sendKeys(phoneNumber);
        // FirstCaseUtils.selectDropdownFromAddress(fullAddress);

        fullAddress = FirstCaseUtils.selectedOptionsToFullAddress();

        page.fullAddress.sendKeys(fullAddress);

        page.saveButton.click();


    }

    @And("user select {int} cargo firm and click Kaydet Ve Devam Et button")
    public void userSelectCargoFirmAndClickKaydetVeDevamEtButton(int numberOfShipFirm) {

        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class=\"js-checkout-cargo-item\"]//div[@class=\"check\"]")));


        page.shippingBoxs.get(numberOfShipFirm - 1).click();

        page.saveAndContinue.click();


    }


    @Then("user select {int} payment tab and complete order and display payment web page")
    public void userSelectPaymentTabAndClickButtonAndDisplayPaymentWebPage(int paymentNumber) {

        FirstCaseUtils.selectPaymentWithName(paymentNumber);


        wait.until(ExpectedConditions.titleContains("Güvenli Ortak Ödeme Sayfası"));

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Güvenli Ortak Ödeme Sayfası"));


    }
}
