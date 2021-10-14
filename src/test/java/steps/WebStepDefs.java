//package steps;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Selenide;
//import io.cucumber.java.en.Given;
//import webpages.CreateAccountPage;
//import webpages.LoginPage;
//
//public class WebStepDefs extends BaseTestCucumber {
//    private CreateAccountPage createAccountPage;
//    private static LoginPage loginPage;
//
//    @Given("I login on Web by orgAdmin")
//    public void login(){
//        System.out.println("OrgAdmin = " + orgAdmin.email);
//        System.out.println("OrgAdmin password = " + orgAdmin.password);
//        loginPage = Selenide.open("/auth/login/", LoginPage.class);
//        loginPage.login(orgAdmin.email, orgAdmin.password);
////        loginPage.login("admin@admin.com", "1qazXSW@");
//    }
//
//    @Given("I create an account on Web and compare the results via API")
//    public void createAccountOnWeb(){
//        createAccountPage = Selenide.open(String.format("/sites/%d/accounts/create", org.id), CreateAccountPage.class);
//        createAccountPage.firstName.sendKeys(faker.name().firstName());
//        createAccountPage.lastName.sendKeys(faker.name().lastName());
//        createAccountPage.email.sendKeys(faker.internet().safeEmailAddress());
//        String passwordWeb  = faker.internet().password(8,10,true,true);
//        createAccountPage.password.sendKeys(passwordWeb);
//        createAccountPage.confirm.sendKeys(passwordWeb);
//        createAccountPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone());
//        createAccountPage.selectPasswordExpires("6");
//        createAccountPage.selectLocale("Dutch");
//        createAccountPage.saveButton.click();
//        createAccountPage.flashCreateAccountSuccess.shouldBe(Condition.visible);
//    }
//
//}
