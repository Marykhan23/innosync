package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.API;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import objectsAPI.Account;
import objectsAPI.Organization;

public class Hooks {


    @Before
    public void init(){
        SelenideLogger.addListener("AllureListener",
                new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.baseUrl = "https://localhost:510";
        Configuration.timeout = 5000;
        Configuration.headless = false;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

//    @After
//    public void tearDown(){
//        api.deleteOrganization(token, org.id);
//    }
}
