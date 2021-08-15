import helpers.API;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import objects.Group;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@Epic("Petstore")
@Story("Petstore user tests")
@Feature("User Tests")
public class Tests {
    API api  = new API();;
    int companyId = 3;
    String token = api.getToken().getAccess_token();

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
        Assertions.assertEquals(groupName, group.getName());
        Assertions.assertTrue(group.getActive());
        Assertions.assertEquals("group", group.getType());


    }
}
