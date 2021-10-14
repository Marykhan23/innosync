package webpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class CreateAccountPage extends BasePage{
    @FindBy(id = "first_name")
    public SelenideElement firstName;

    @FindBy(id = "last_name")
    public SelenideElement lastName;

    @FindBy(id = "email")
    public SelenideElement email;

    @FindBy(id = "password")
    public SelenideElement password;

    @FindBy(id = "confirm")
    public SelenideElement confirm;

    @FindBy(id = "pw_expires")
    public SelenideElement pwExpires;

    @FindBy(id = "mobile_phone")
    public SelenideElement mobilePhone;

    @FindBy(id = "locale")
    public SelenideElement locale;

    @FindBy(css = "button#account_submit")
    public SelenideElement saveButton;

    @FindBy(css = ".card-footer a[href=\"/sites/2/accounts/\"]")
    public SelenideElement cancelButton;

    @FindBy(id = "shared_quota")
    public SelenideElement sharedQuota;

    @FindBy(id = "webdav")
    public SelenideElement webdav;

    @FindBy(id = "send_welcome_email")
    public SelenideElement sendWelcomeEmail;

    @FindBy(id = "site_admin")
    public SelenideElement siteAdmin;

    @FindBy(id = "system_admin")
    public SelenideElement systemAdmin;

    @FindBy(id = "group_ids_chosen")
    public SelenideElement addToGroups;

    @FindBy(id = "dept_shares_chosen")
    public SelenideElement addToTeamShare;

    @FindBy(xpath = "//*[contains(text(), \"You successfully created a new account and user will be notified.\")]")
    public SelenideElement flashCreateAccountSuccess;

    @FindBy(xpath = "//*[contains(text(), \"Share was created successfully.\")]")
    public SelenideElement flashCreateTeamShareSuccess;

    @FindBy(xpath = "//*[contains(text(), \"Passwords must match.\")]")
    public SelenideElement errPasswordMustMatch;

    public void selectPasswordExpires(String expireHours){
        pwExpires.selectOptionByValue(expireHours);
    }
    public void selectLocale(String lang){
        locale.selectOptionContainingText(lang);
    }
}
