package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[type=submit]")
    public WebElement submitBtn;

    public void inputUsername(String email){username.sendKeys(email);}
    public void inputPassword(String psw){password.sendKeys(psw);}
    public void submit(){submitBtn.click();}

    public void login(String email, String psw){
        inputUsername(email);
        inputPassword(psw);
        submit();
    }


}
