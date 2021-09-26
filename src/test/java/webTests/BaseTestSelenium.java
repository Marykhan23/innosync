//package webTests;
//
//import com.github.javafaker.Faker;
//import helpers.API;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Ignore;
//import webpages.CreateAccountPage;
//import webpages.LoginPage;
//
//import java.util.concurrent.TimeUnit;
//
////@ExtendWith(TestListener.class)
//@Ignore
//public class BaseTestSelenium {
//    public WebDriver wd;
//    public static LoginPage loginPage;
//    public static CreateAccountPage createAccountPage;
//    public WebDriverWait wait;
//    public Faker faker;
//    public String token;
//    int companyId = 3;
//    API api;
//
//    @BeforeAll
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        wd = new ChromeDriver();
//        loginPage = new LoginPage(wd);
//        createAccountPage = new CreateAccountPage(wd);
//        wait = new WebDriverWait(wd,20);
//        faker = new Faker();
//
//    }
//
//    @BeforeEach
//    public void init(){
//        API api  = new API();
//        token = api.getToken().getAccess_token();
//        wd.get("https://localhost:510");
//        wd.manage().window().maximize();
//        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//    }
//
//
//    private void chooseBrowser(String browserName){
//        switch (browserName){
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                ChromeOptions opt = new ChromeOptions();
//                opt.setHeadless(true);
//                wd = new ChromeDriver();
//                break;
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//                wd = new FirefoxDriver();
//                break;
//            case "edge":
//                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
//                wd = new EdgeDriver();
//                break;
//        }
//    }
//
////    public createUser(){
////
////    }
////
////    public createSysAdmin(){
////
////    }
////
////    public Account createOrgAdmin(int orgId){
////        Map<String, String> params = Map.ofEntries(
////                entry("company_id", orgId),
////                entry("email", new Faker().internet().safeEmailAddress()),
////                entry("first_name", new Faker().name().firstName()),
////                entry("last_name",new Faker().name().lastName()),
////                entry("password", "1qazXSW@"),
////                entry("site_admin", true));
////        Account orgAdmin = api.createAccount2(token, params);
////       return orgAdmin;
////    }
//
//    @AfterEach
//    public void close(){
//        wd.quit();
//    }
//}
