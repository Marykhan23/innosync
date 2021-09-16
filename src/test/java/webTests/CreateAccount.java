package webTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateAccount extends BaseTest{



    @Test
    public void createAccount(){
        loginPage.login("admin@admin.com", "1qazXSW@");
        int id = 3;
        wd.get(String.format("https://localhost:510/sites/%d/accounts/create", id));
        createAccountPage.inputFirstName(faker.name().firstName());
        createAccountPage.inputLastName(faker.name().lastName());
        createAccountPage.inputEmail(faker.internet().emailAddress());
        String password = faker.internet().password(8,10,true,true);
        createAccountPage.inputPassword(password);
        createAccountPage.confirmPassword(password);
        createAccountPage.inputMobile(faker.phoneNumber().cellPhone());
        createAccountPage.selectPasswordExpires("6");
        createAccountPage.selectLocale("Dutch");
        createAccountPage.clickSaveBtn();
        wait.until(ExpectedConditions.invisibilityOf(createAccountPage.flashCreateAccountSuccess));

    }

}
