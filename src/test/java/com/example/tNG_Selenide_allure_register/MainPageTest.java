package com.example.tNG_Selenide_allure_register;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.ENTER;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

    @BeforeClass
    public   void setUp()  {

        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.baseUrl = "https://www.detmir.ru";
        ChromeOptions options = new ChromeOptions();

        //change browser settings
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2); //off geolocation!!!
        profile.put("managed_default_content_settings", contentSettings);

        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-plugins");
        options.addArguments("--start-maximized");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "88.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("resolution", "1280x1024");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        open("/");



    }


    @Test(priority = 1, enabled = true)
    public void search() {
        /**
         *mouse move to search locat
         *enter word "Игрушки"
         * click button
         * checking  result search
         */


         mainPage.searchButton.shouldBe(visible).click();
        $(By.xpath("//input[@type='search']")).sendKeys("Игрушки", ENTER);
        $(byClassName("bu")).shouldHave(exactText( "«Игрушки»"));
    }

    @Test(priority = 2, enabled = true)
    public void toolsMenu() {
        /**
         *mouse move to menu
         * checking  menu item shouldHave "Куклы и аксессуары"
         */
        mainPage.toolsMenu.shouldBe(visible).hover();
        $(By.linkText("Куклы и аксессуары")).shouldHave(visible);
    }

    @Test(priority = 3, enabled = true)
    public void navigationToAllTools() {
        /**
         *mouse move to menu
         * checking  menu item shouldHave "Круглый год"
         */
        mainPage.seeAllToolsButton.hover();

        $(byLinkText("Круглый год")).shouldBe(visible);


    }

}
