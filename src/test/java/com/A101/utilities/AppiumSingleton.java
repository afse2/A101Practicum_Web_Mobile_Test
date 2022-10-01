package com.A101.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class AppiumSingleton {


    private static AppiumDriver<MobileElement> driver;

    private static URL url;


    public static AppiumDriver<MobileElement> getDriver() {





        if (driver == null) {

            switch (ConfigurationReader.getProperty("mobileOS").toLowerCase()) {
                case "android":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S10");
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ferog\\IdeaProjects\\A101\\src\\test\\resources\\app\\A101.apk");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    driver = new AndroidDriver<MobileElement>(url,capabilities);
                    break;

                case "ios":

                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone 14");
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
                    caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\ferog\\IdeaProjects\\A101\\src\\test\\resources\\app\\A101.apk");
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

                    try {
                        url = new URL("http://localhost:4723/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    driver = new IOSDriver<MobileElement>(url,caps);
                    break;

            }

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver;

    }


    public static void close() {
        if (Objects.nonNull(driver)) {
            driver.closeApp();
            driver = null;
        }
    }





}
