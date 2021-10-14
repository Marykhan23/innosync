package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import helpers.API;
import io.cucumber.java.en.Given;
import io.cucumber.java.eo.Se;
import io.cucumber.java.sl.In;
import objectsAPI.Account;
import objectsAPI.Organization;
import org.junit.jupiter.api.Assertions;
import webpages.CreateAccountPage;
import webpages.LoginPage;
import webpages.TeamSharePage;

import static org.junit.Assert.assertEquals;

public class ApiStepsDefs/* extends BaseTestCucumber*/{
    public Faker faker = new Faker();
    public String token;
    public Organization org;
    public API api = new API();
    public Account orgAdmin;
    public Account user;
    private CreateAccountPage createAccountPage;
    private static LoginPage loginPage;
    private static TeamSharePage teamSharePage;

    @Given("I get token for user with email {string} and password {string}")
    public void getToken(String email, String password){
        token = api.getToken(email, password).getAccess_token();
    }

    @Given("I create an organization")
    public void createOrg(){
        org = api.createOrganization(token, 4);
    }

    @Given("I create an orgAdmin user")
    public void createOrgAdmin(){
        orgAdmin = api.createAccount(token, org.id, "orgAdmin");
    }

    @Given("I create a user")
    public void createUser(){
        user = api.createAccount(token, org.id, "stdUser");
    }

    @Given("I login on Web by orgAdmin")
    public void login(){
        System.out.println("OrgAdmin = " + orgAdmin.email);
        System.out.println("OrgAdmin password = " + orgAdmin.password);
        loginPage = Selenide.open("/auth/login/", LoginPage.class);
        loginPage.login(orgAdmin.email, orgAdmin.password);
    }

    @Given("I create an account on Web and compare the results via API")
    public void createAccountOnWeb(){
        String email = faker.internet().safeEmailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        createAccountPage = Selenide.open(String.format("/sites/%d/accounts/create", org.id), CreateAccountPage.class);
        createAccountPage.firstName.sendKeys(firstName);
        createAccountPage.lastName.sendKeys(lastName);
        createAccountPage.email.sendKeys(email);
        String passwordWeb  = faker.internet().password(8,10,true,true);
        createAccountPage.password.sendKeys(passwordWeb);
        createAccountPage.confirm.sendKeys(passwordWeb);
        createAccountPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone());
        createAccountPage.selectPasswordExpires("6");
        createAccountPage.selectLocale("Dutch");
        createAccountPage.saveButton.click();
        createAccountPage.flashCreateAccountSuccess.shouldBe(Condition.visible);
        Account acc = api.getAccount(token, email);
        assertEquals(acc.first_name, firstName);
        assertEquals(acc.last_name, lastName);
    }

    @Given("I check password mismatch when creating an account")
    public void createAccountPasswordMismatch(){
        String email = faker.internet().safeEmailAddress();
        createAccountPage = Selenide.open(String.format("/sites/%d/accounts/create", org.id), CreateAccountPage.class);
        createAccountPage.firstName.sendKeys(faker.name().firstName());
        createAccountPage.lastName.sendKeys(faker.name().lastName());
        createAccountPage.email.sendKeys(email);
        String password = faker.internet().password(8,10,true,true);
        createAccountPage.password.sendKeys(password);
        createAccountPage.confirm.sendKeys(password+"1");
        createAccountPage.saveButton.click();
        createAccountPage.errPasswordMustMatch.shouldBe(Condition.visible);
        Account accDoesntExist = api.getAccount(token, email);
        assertEquals(accDoesntExist.id, 0);
    }

    @Given("I create a team share and check it exists on Web")
    public void createTeamShareOnWeb(){
        String teamShareName = faker.name().name();
        teamSharePage = Selenide.open(String.format("/roots/%d/dept/", org.id), TeamSharePage.class);
        teamSharePage.clickOnCreateTeamShareButton(org.id);
        teamSharePage.company_id.selectOptionByValue(String.valueOf(org.id));
        teamSharePage.name.sendKeys(teamShareName);
        teamSharePage.clickOnUserCheckBox(user.email);
        teamSharePage.saveButton.click();
        teamSharePage.confirmOkButton.click();
        Selenide.open(String.format("/roots/%d/dept/", org.id));
        teamSharePage.teamShareIsVisible(teamShareName);
        int teamShareId = Integer.parseInt(teamSharePage.getTeamShareId(teamShareName));
        Selenide.open(String.format("/files/%d/", teamShareId));
    }

    @Given("I can't create a team share on Web without name")
    public void cantCreateTeamShareOnWebWithoutName(){
        teamSharePage = Selenide.open(String.format("/roots/%d/dept/", org.id), TeamSharePage.class);
        teamSharePage.clickOnCreateTeamShareButton(org.id);
        teamSharePage.company_id.selectOptionByValue(String.valueOf(org.id));
        teamSharePage.saveButton.click();
        teamSharePage.errorMessageTeamShareIsRequired.shouldBe(Condition.visible);
    }

    @Given("I delete organization")
    public void deleteOrgAfterTest(){
        api.deleteOrganization(token, org.id);
    }
}
