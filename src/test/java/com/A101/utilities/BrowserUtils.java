package com.A101.utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.VideoFormatKeys.*;


public class BrowserUtils {

    /*
This method will accept int (in seconds) and execute Thread.sleep
for given duration
 */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }


    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }


    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void scroolDownMobileApp(){
        TouchAction action = new TouchAction(AppiumSingleton.getDriver());
        action.press(PointOption.point(800,2000))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
                .moveTo(PointOption.point(800, 1000))
                .release()
                .perform();
    }



    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //For video recording
    public static ScreenRecorder screenRecorder;

    public static void startRecording() throws Exception
    {
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        screenRecorder = new ScreenRecorder(gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,DepthKey, 24, FrameRateKey, Rational.valueOf(15),QualityKey, 1.0f,KeyFrameIntervalKey, 15 * 60),new Format(MediaTypeKey,MediaType.VIDEO, EncodingKey, "black",FrameRateKey, Rational.valueOf(30)),null);
        screenRecorder.start();
    }
    public static void stopRecording() throws Exception
    {

        screenRecorder.stop();
    }

}