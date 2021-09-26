package webTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.API;
import helpers.TestListener1;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webpages.CreateAccountPage;
import webpages.LoginPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

//@ExtendWith(TestListener.class)
public class BaseTest {

    public WebDriverWait wait;
    public Faker faker;
    public String token;
    int companyId = 3;
    API api;

    @BeforeAll
    public void setUp(){
        faker = new Faker();
        SelenideLogger.addListener("AllureListener",
                new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.baseUrl = "https://localhost:510";
        Configuration.timeout = 5000;
        Configuration.headless = false;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

//        WebDriverManager.chromedriver().setup();
//        wd = new ChromeDriver();
//        loginPage = new LoginPage(wd);
//        createAccountPage = new CreateAccountPage(wd);
//        wait = new WebDriverWait(wd,20);
    }

    @BeforeEach
    public void init(){
//        API api  = new API();
//        token = api.getToken().getAccess_token();
//        wd.get("https://localhost:510");
//        wd.manage().window().maximize();
//        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }


//    public createUser(){
//
//    }
//
//    public createSysAdmin(){
//
//    }
//
//    public Account createOrgAdmin(int orgId){
//        Map<String, String> params = Map.ofEntries(
//                entry("company_id", orgId),
//                entry("email", new Faker().internet().safeEmailAddress()),
//                entry("first_name", new Faker().name().firstName()),
//                entry("last_name",new Faker().name().lastName()),
//                entry("password", "1qazXSW@"),
//                entry("site_admin", true));
//        Account orgAdmin = api.createAccount2(token, params);
//       return orgAdmin;
//    }


}
