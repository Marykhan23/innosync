package webTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateAccountPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver wd;
    public static LoginPage loginPage;
    public static CreateAccountPage createAccountPage;
    public WebDriverWait wait;
    public Faker faker;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        loginPage = new LoginPage(wd);
        createAccountPage = new CreateAccountPage(wd);
        wait = new WebDriverWait(wd,20);
        faker = new Faker();
    }

    @BeforeEach
    public void init(){
        wd.get("https://localhost:510");
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    private void chooseBrowser(String browserName){
        switch (browserName){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions opt = new ChromeOptions();
                opt.setHeadless(true);
                wd = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                wd = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                wd = new EdgeDriver();
                break;
        }
    }

    @AfterEach
    public void close(){
        wd.quit();
    }
}
