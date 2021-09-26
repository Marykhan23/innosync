import helpers.API;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import objectsAPI.Group;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


@Epic("Petstore")
@Story("Petstore user tests")
@Feature("User Tests")
public class Tests {
    API api  = new API();
//    String ssl = api.init();
    int companyId = 3;
    String token = api.getToken().getAccess_token();


    public Tests() throws NoSuchAlgorithmException, KeyManagementException {
    }
//
//    @BeforeEach
//    public void beforeEach(){
//
//        api.init();
//
//    }

    @Test
    public void test(){
        String groupName = RandomStringUtils.randomAlphanumeric(6);
        System.out.println("Initial" + groupName);
        Group group = api.createGroup(token, companyId, groupName);
        Assertions.assertEquals(groupName, group.name);
        Assertions.assertTrue(group.active);
        Assertions.assertEquals("group", group.type);

    }


}
