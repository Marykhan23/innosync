package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver wd) {
        super(wd);
    }
    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "confirm")
    public WebElement confirm;

    @FindBy(id = "pw_expires")
    public WebElement pwExpires;

    @FindBy(id = "mobile_phone")
    public WebElement mobilePhone;

    @FindBy(id = "locale")
    public WebElement locale;

    @FindBy(css = "button#account_submit")
    public WebElement saveButton;

    @FindBy(css = ".card-footer a[href=\"/sites/2/accounts/\"]")
    public WebElement cancelButton;

    @FindBy(id = "shared_quota")
    public WebElement sharedQuota;

    @FindBy(id = "webdav")
    public WebElement webdav;

    @FindBy(id = "send_welcome_email")
    public WebElement sendWelcomeEmail;

    @FindBy(id = "site_admin")
    public WebElement siteAdmin;

    @FindBy(id = "system_admin")
    public WebElement systemAdmin;

    @FindBy(id = "group_ids_chosen")
    public WebElement addToGroups;

    @FindBy(id = "dept_shares_chosen")
    public WebElement addToTeamShare;

    @FindBy(xpath = "//*[contains(text(), \"You successfully created a new account and user will be notified.\")]")
    public WebElement flashCreateAccountSuccess;

    @FindBy(xpath = "//*[contains(text(), \"Share was created successfully.\")]")
    public WebElement flashCreateTeamShareSuccess;

    public void selectPasswordExpires(String expireHours){
        Select expireList = new Select(pwExpires);
        expireList.selectByValue(expireHours);
    }
    public void selectLocale(String lang){
        Select expireList = new Select(locale);
        expireList.selectByVisibleText(lang);
    }
}
