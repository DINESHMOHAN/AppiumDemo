package com.aptus.test.appium;

import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumIOSTest {

    private IOSDriver driver;
    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("Appium-version", "3.4.1");

        capabilities.setCapability("platformName", "iOS");

        capabilities.setCapability("platformVersion", "9.3");

        capabilities.setCapability("deviceName", "iPhone 5");

        capabilities.setCapability("app",
                                   "/Users/administrator/Documents/dev/ionicapps/AppiumTestApp/platforms/ios/build/emulator/AppiumTestApp.app");

        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    public void testiOS() throws InterruptedException {

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIAButton[1]"))
                .click();

        driver.findElement(By.xpath(
                "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIALink[2]/UIAStaticText[1]")).click();

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIATextField[1]"))
                .sendKeys("jACk");

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIATextField[2]"))
                .sendKeys("sMith");

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAToolbar[1]/UIAButton[3]")).click();

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIAButton[2]"))
                .click();

        String text = driver.findElement(By.xpath(
                "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIAStaticText[5]")).getText();

        Assert.assertEquals(text, "Jack Smith", text);
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
