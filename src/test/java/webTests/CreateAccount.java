package webTests;

import helpers.API;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import objectsAPI.Account;
import objectsAPI.Group;
import objectsAPI.Organization;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
@ExtendWith(TestListener.class)
@Epic("Web test epic")
@Story("Story")
@Feature("Feature")
//@Tag("Web tag")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateAccount extends BaseTest{
    Organization org;
    Account orgAdmin;
    Account orgAdmin2;


    @BeforeEach
    public void init(){
        api  = new API();
        token = api.getToken().getAccess_token();
        org = api.createOrganization(token, companyId);
        orgAdmin = api.createAccount(token, companyId, "orgAdmin");
//        orgAdmin2 = api.createAccount2(token, companyId, );
        wd.get("https://localhost:510");
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    @Step("Create Account")
    public void createAccount(){
        loginPage.login(orgAdmin.email, "1qazXSW@");
        wd.get(String.format("https://localhost:510/sites/%d/accounts/create", org.id));
        createAccountPage.firstName.sendKeys(faker.name().firstName());
        createAccountPage.lastName.sendKeys(faker.name().lastName());
        createAccountPage.email.sendKeys(faker.internet().safeEmailAddress());
        String password = faker.internet().password(8,10,true,true);
        createAccountPage.password.sendKeys(password);
        createAccountPage.confirm.sendKeys(password);
        createAccountPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone());
        createAccountPage.selectPasswordExpires("6");
        createAccountPage.selectLocale("Dutch");
        createAccountPage.saveButton.click();
        wait.until(ExpectedConditions.invisibilityOf(createAccountPage.flashCreateAccountSuccess));

    }

    @AfterEach
    public void deleteOrgAfterTest(){
        api.deleteOrganization(token, org.id);
    }
}
