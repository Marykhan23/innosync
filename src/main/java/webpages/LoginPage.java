package webpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//    public LoginPage(WebDriver wd) {
//        super(wd);
//    }

    @FindBy(id = "username")
    public SelenideElement username;

    @FindBy(id = "password")
    public SelenideElement password;

    @FindBy(css = "button[type=submit]")
    public SelenideElement submitBtn;

    public void login(String email, String psw){
        username.sendKeys(email);
        password.sendKeys(psw);
        submitBtn.click();
    }


}
