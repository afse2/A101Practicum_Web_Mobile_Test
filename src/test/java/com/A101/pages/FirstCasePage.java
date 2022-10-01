package com.A101.pages;

import com.A101.utilities.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FirstCasePage extends BasePage {


    public void clickWithLinkText(String name){
        Driver.getDriver().findElement(By.partialLinkText(name)).click();

    }

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement acceptCookiesButton;


    @FindBy(xpath = "(//a[@title = \"GİYİM & AKSESUAR\"])[1]")
    public WebElement giyimTab;

    @FindBy(xpath = "//h3[@class = \"name\"]")
    public List<WebElement> socksList;

    @FindBy(xpath = "//div[@class=\"selected-variant-text\"]//span")
    public WebElement selectedColor;

    @FindBy(xpath ="//button[@class=\"add-to-basket button green block with-icon js-add-basket\"]")
    public WebElement addToCart;

    @FindBy(xpath = "//input[@name=\"user_email\"]  ")
    public WebElement emailBox;

    @FindBy(xpath = "(//a[@title = \"Yeni adres oluştur\"])[1]")
    public WebElement newAddress;

    @FindBy(xpath = "//span[@class=\"title\"]")
    public WebElement updateAddress;

    @FindBy(xpath = "//input[@name=\"title\"]")
    public WebElement addressTitle;

    @FindBy(xpath = "//input[@name=\"first_name\"]")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name=\"last_name\"]")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name=\"phone_number\"]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//select[@name=\"city\"]")
    public WebElement city;

    @FindBy(xpath = "//select[@name=\"township\"]")
    public WebElement township;

    @FindBy(className = "js-district")
    public WebElement district;

    @FindBy(xpath = "//textarea[@name=\"line\"]")
    public WebElement fullAddress;

    @FindBy(xpath = "//button[@class=\"button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class=\"button block green\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//label[@class=\"js-checkout-cargo-item\"]//div[@class=\"check\"]")
    public List<WebElement> shippingBoxs;

    @FindBy(xpath = "//button[@class=\"button block green js-proceed-button\"]")
    public WebElement saveAndContinue;

    @FindBy(xpath = "//div[@class=\"payment-tabs\"]//div")
    public List<WebElement> paymentTabs;

    @FindBy(xpath = "(//label[@class=\"checkout__contract\"]//div)[1]")
    public WebElement garantiAgrement;

    @FindBy(xpath = "//div[@class=\"agrement bkm-agreement\"]//div[@class=\"checkbox\"]")
    public WebElement bkbAgrement;

    @FindBy(xpath = "//button[@class=\"checkout__cargo__proceed bkm-button js-bkm-button-visible button green\"]//span")
    public WebElement bkbPay;


    @FindBy(xpath = "(//div[@class=\"agrement\"]//div[@class=\"checkbox\"])[2]")
    public WebElement cardAgrement;






}
