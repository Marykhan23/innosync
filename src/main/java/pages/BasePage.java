package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver wd;

    public BasePage(WebDriver wd) {
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }
//    @FindBy(xpath = "//*[@class=\"flash-message\"]/div[contains(text(), 'You successfully created a new account and user will be notified.')]")
//    public WebElement username;
}
