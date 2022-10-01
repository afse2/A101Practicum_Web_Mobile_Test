package com.A101.pages;

import com.A101.utilities.AppiumSingleton;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstCasePageMobile {

    public FirstCasePageMobile(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumSingleton.getDriver()),this);
    }

    WebDriverWait wait = new WebDriverWait(AppiumSingleton.getDriver(),200);



    @AndroidFindBy(className = "android.widget.TextView")
    public MobileElement categories;

    @AndroidFindBy(xpath = "(//*[@text=\"Renk: \"]/following-sibling::android.widget.TextView)[1]")
    public MobileElement selectedColor;

    @AndroidFindBy(xpath = "//*[@text='E-posta Adresiniz']")
    public MobileElement mailBox;

    @AndroidFindBy(xpath = "(//*[@text=\"E-posta Adresiniz\"]/following-sibling::android.view.ViewGroup)[1]")
    public MobileElement agrementCheckBox;

    @AndroidFindBy(xpath = "//*[@text='GÖNDER']")
    public MobileElement sendButton;

    @AndroidFindBy(xpath = "//*[@text='Kabul Et']")
    public MobileElement cookiesAcceptButton;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<MobileElement> addressTextBoxs;

    @AndroidFindBy(xpath = "//*[@text=\"Seçiniz\"]")
    public MobileElement addressDropdown;

    @AndroidFindBy(xpath = "//*[@text='KAYDET']")
    public MobileElement saveButton;

    @AndroidFindBy(className = "android.widget.RadioButton")
    public List<MobileElement> cargoRadioButtons;

    @AndroidFindBy(xpath = "//*[@text='Kaydet ve Devam Et']")
    public MobileElement saveAndContinueButton;

    @AndroidFindBy(xpath = "(//android.view.View[4])[1]//android.view.View")
    public List<MobileElement> paymentTabs;

    @AndroidFindBy(className = "android.widget.CheckBox")
    public MobileElement garantiAgreement;

    @AndroidFindBy(className = "android.widget.Image")
    public MobileElement garantiPayImage;

    public  MobileElement viewElementWithName(String elementText){
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.className("android.view.View")));

        List<MobileElement> elements = AppiumSingleton.getDriver().findElements(MobileBy.className(("android.view.View")));

        MobileElement element = null;

        for (MobileElement each : elements) {
            if(each.getText().contains(elementText)){
                element = each;

            }
        }
        return element;
    }

    public MobileElement selectFromDropdown(String name){


        MobileElement element = null;
        TouchAction action = new TouchAction(AppiumSingleton.getDriver());

       outer: while(true){
           List<MobileElement> elements = AppiumSingleton.getDriver().findElements(MobileBy.className("android.widget.CheckedTextView"));
           wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.className("android.widget.CheckedTextView")));
            for (MobileElement each : elements) {
                if(each.getAttribute("text").contains(name)){
                element = each;
                break outer;
            }

        }

            action.press(PointOption.point(800, 2720))
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
                    .moveTo(PointOption.point(800, 1720))
                    .release()
                    .perform();
        }

        return element;

    }

    public  MobileElement textViewElementWithName(String elementText){
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.className("android.widget.TextView")));

        List<MobileElement> elements = AppiumSingleton.getDriver().findElements(MobileBy.className(("android.widget.TextView")));

        MobileElement element = null;

        for (MobileElement each : elements) {
            if(each.getText().contains(elementText)){
                element = each;

            }
        }
        return element;
    }
}
