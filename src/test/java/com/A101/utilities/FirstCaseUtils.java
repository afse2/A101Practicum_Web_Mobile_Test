package com.A101.utilities;

import com.A101.pages.FirstCasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FirstCaseUtils {

    static FirstCasePage page = new FirstCasePage();

    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    static Faker faker = new Faker();

    public static void selectDropdownFromAddress(String fullAddress) {
        String city = fullAddress.substring(fullAddress.lastIndexOf("/") + 1, fullAddress.lastIndexOf(","));
        String district = fullAddress.substring(0, fullAddress.indexOf(","));
        String township = fullAddress.substring(fullAddress.lastIndexOf(" ", fullAddress.lastIndexOf("/")), fullAddress.lastIndexOf("/"));

        Select cityDropdown = new Select(page.city);

        cityDropdown.selectByVisibleText(city.trim().toUpperCase());

        Select townshipDropdown = new Select(page.township);

        townshipDropdown.selectByVisibleText(township.trim().toUpperCase());


        Select districtDropdown = new Select(page.district);

        district = district.trim().toLowerCase();

        page.district.click();
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.className("js-district")));
        for (WebElement option : districtDropdown.getOptions()) {

            try {
                if (option.getText().contains("CUMHURİYET")) {
                    districtDropdown.selectByVisibleText(option.getText());
                    break;
                }

            } catch (Exception e) {

            }


        }

    }

    public static void selectPaymentWithName(int paymentNumber) {

      int index = paymentNumber -1;

                    if (index == 0 ) {
                        page.paymentTabs.get(index).click();
                        page.cardAgrement.click();

                    } else if (index== 1) {
                        page.paymentTabs.get(index).click();
                        page.garantiAgrement.click();
                        page.clickWithLinkText("Garanti Pay ile Öde");

                    } else if(index == 2){
                        page.paymentTabs.get(index).click();
                        page.bkbAgrement.click();
                        page.bkbPay.click();
                    }




    }

    public static String selectedOptionsToFullAddress() {

        Select cityDropdown = new Select(page.city);

        cityDropdown.selectByIndex(faker.number().numberBetween(1, cityDropdown.getOptions().size()));

        String city = cityDropdown.getFirstSelectedOption().getText();

        Select townshipDropdown = new Select(page.township);

        townshipDropdown.selectByIndex(faker.number().numberBetween(1, townshipDropdown.getOptions().size()));

        String township = townshipDropdown.getFirstSelectedOption().getText();

        Select districtDropdown = new Select(page.district);

        districtDropdown.selectByIndex(faker.number().numberBetween(1, townshipDropdown.getOptions().size()));

        String district = districtDropdown.getFirstSelectedOption().getText();

        return district + " " + faker.address().buildingNumber() + " " + township + "/" + city;


    }


}
