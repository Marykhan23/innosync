//package webTests;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Selenide;
//import com.github.javafaker.Faker;
//import helpers.API;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Step;
//import io.qameta.allure.Story;
//import objectsAPI.Account;
//import objectsAPI.Group;
//import objectsAPI.Organization;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import webpages.CreateAccountPage;
//import webpages.LoginPage;
//
//import java.util.concurrent.TimeUnit;
////@ExtendWith(TestListener.class)
//@Epic("Web test epic")
//@Story("Story")
//@Feature("Feature")
////@Tag("Web tag")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class CreateAccount extends BaseTest{
//    Organization org;
//    Account orgAdmin;
//    Account orgAdmin2;
//    private CreateAccountPage createAccountPage;
//    private static LoginPage loginPage;
//
//    @BeforeEach
//    public void initZ(){
//        api  = new API();
//        token = api.getToken("admin@admin.com", "1qazXSW@").getAccess_token();
//        org = api.createOrganization(token, parentId);
//        orgAdmin = api.createAccount(token, org.id, "orgAdmin");
//        loginPage = Selenide.open("/auth/login/", LoginPage.class);
//    }
//
//    @Test
//    public void createAccountZ(){
//        loginPage.login(orgAdmin.email, "1qazXSW@");
//        createAccountPage = Selenide.open(String.format("/sites/%d/accounts/create", org.id), CreateAccountPage.class);
//        createAccountPage.firstName.sendKeys(faker.name().firstName());
//        createAccountPage.lastName.sendKeys(faker.name().lastName());
//        createAccountPage.email.sendKeys(faker.internet().safeEmailAddress());
//        String password = faker.internet().password(8,10,true,true);
//        createAccountPage.password.sendKeys(password);
//        createAccountPage.confirm.sendKeys(password);
//        createAccountPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone());
//        createAccountPage.selectPasswordExpires("6");
//        createAccountPage.selectLocale("Dutch");
//        createAccountPage.saveButton.click();
//        createAccountPage.flashCreateAccountSuccess.shouldBe(Condition.visible);
//
//    }
//
//    @Test
//    public void createAccountPasswordMismatch(){
//        loginPage.login(orgAdmin.email, "1qazXSW@");
//        createAccountPage = Selenide.open(String.format("/sites/%d/accounts/create", org.id), CreateAccountPage.class);
//        createAccountPage.firstName.sendKeys(faker.name().firstName());
//        createAccountPage.lastName.sendKeys(faker.name().lastName());
//        createAccountPage.email.sendKeys(faker.internet().safeEmailAddress());
//        String password = faker.internet().password(8,10,true,true);
//        createAccountPage.password.sendKeys(password);
//        createAccountPage.confirm.sendKeys(password+"1");
//        createAccountPage.saveButton.click();
//        createAccountPage.errPasswordMustMatch.shouldBe(Condition.visible);
//
//    }
//
//    @AfterEach
//    public void deleteOrgAfterTest(){
//        api.deleteOrganization(token, org.id);
//    }
//}
