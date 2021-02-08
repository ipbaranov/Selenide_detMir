package com.example.tNG_Selenide_allure_register;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.startMaximized = true;
        open("https://www.detmir.ru/");

    }



    @Test(priority = 1, enabled = true)
    public void search() {
        /**
         *mouse move to search locat
         *enter word "Игрушки"
         * click button
         * checking  result search
         */
         mainPage.searchButton.click();
         $(By.className("l_5")).sendKeys("Игрушки");
        $(byClassName("Wq")).click();//кнопка поиска
        $(byClassName("bb")).shouldHave(exactText( "«Игрушки»"));
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
