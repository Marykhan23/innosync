package webTests;

import org.junit.jupiter.api.*;
import webpages.LoginPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Login extends BaseTest{
    private LoginPage loginPage;

//    @Test
//    public void wd1(){
////        chooseBrowser("firefox");
//        WebDriverManager.chromedriver().setup();
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
//        wd.get("https://localhost:510");
//        wd.findElement(By.id("username")).sendKeys("admin@admin.com");
//        wd.findElement(By.id("password")).sendKeys("1q2w3e4r5t!");
//        wd.findElement(By.cssSelector("button[type=submit]")).click();
//        wd.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
//        wd.quit();
//    }

//    @Test
//    public void login(){
//        loginPage.inputUsername("tyson@gmail1.com");
//        loginPage.inputPassword("1qazXSW@");
//        loginPage.submit();
////        wd.close();
//    }

//    @Test
//    @DisplayName("Wrong username")
//    public void wrongUsername(){
//        loginPage.inputUsername("tyson@gmail1.com");
//        loginPage.inputPassword("1qazXSW@");
//        loginPage.submit();
////        //*[@class="flash-message"]/div[contains(text(), 'Your username, password, or domain is incorrect')]
////        //*[@id="flashes"]/div[contains(text(), 'Your username, password, or domain is incorrect')]
////        Your username or password is incorrect
////        wd.close();
////        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
////        Assert.assertTrue("Text not found!", list.size() > 0);
////
////        String bodyText = driver.findElement(By.tagName("body")).getText();
////        Assert.assertTrue("Text not found!", bodyText.contains(text));
//    }

//    @Test
//    @DisplayName("Wrong password")
//    public void wrongPassword(){
//        loginPage.inputUsername("tyson@gmail1.com");
//        loginPage.inputPassword("1qazXSW@");
//        loginPage.submit();
////        wd.close();
//    }


}
