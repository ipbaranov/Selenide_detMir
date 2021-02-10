package com.example.tNG_Selenide_allure_register;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainPage {
    //defining locators

    public SelenideElement seeAllToolsButton = $(By.linkText("Спорт и отдых"));
    public SelenideElement toolsMenu = $(By.linkText("Игрушки и игры"));
    public SelenideElement searchButton = $(By.className("PG"));
    public MainPage open(){
        Selenide.open("/");
        return this;}
}
