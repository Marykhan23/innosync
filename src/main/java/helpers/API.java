package helpers;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import objectsAPI.Account;
import objectsAPI.Group;
import objectsAPI.Organization;
import objectsAPI.Token;

import javax.net.ssl.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

public class API {
    private static final String basePath = "api/2";
    private static final String url = "https://localhost:510";
    private RequestSpecification reqSpec;

    public final class EndPoints{
        private static final String token = "/oauth/token";
        private static final String getGroup = "/api/2/group/{groupId}";
        private static final String createGroup = "/api/2/group/create";
        private static final String createOrganization = "/api/2/organization/{parentId}/organizations/create";
        private static final String deleteOrganization = "/api/2/organization/{orgId}/delete";
        private static final String createAccount = "/api/2/person/create";
    }

    public API(){
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri(url)
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured())
                .build();
        RestAssured.requestSpecification =reqSpec;
        RestAssured.useRelaxedHTTPSValidation();
    }

    //    @Step("getToken")
    public Token getToken(){
        Token response = RestAssured
                .given()
                .basePath(EndPoints.token)
                .params("grant_type", "password", "client_id", "anchor"
                        , "username", "admin@admin.com", "password", "1qazXSW@")
//                .post().getBody().jsonPath().getString("access_token");
                .log().all()
                .post().as(Token.class);
        System.out.println(response);
        return response;

    }

//    @Step("GET")
    public Group getGroup(String token) {
        Group response = RestAssured
                .given()
                .baseUri(url)
                .basePath("/api/2/group/1")
                .auth().oauth2(token)
                .get().as(Group.class);
        return response;
    }

//    @Step("CREATE")
    public Group createGroup(String token, int companyId, String groupName) {
        Group response = RestAssured
                .given()
                .basePath(EndPoints.createGroup)
                .params("company_id", companyId, "name", groupName)
                .auth().oauth2(token)
                .post().as(Group.class);
        return response;
    }

    public Organization createOrganization(String token, int orgId) {
        Organization response = RestAssured
                .given()
                .basePath(EndPoints.createOrganization)
                .pathParams("parentId", orgId)
                .params(
                        "name", new Faker().company().name(),
                        "email", new Faker().internet().safeEmailAddress(),
                        "hostname", new Faker().internet().domainName(),
                        "slug",new Faker().company().name()
                )
                .auth().oauth2(token)
                .post().as(Organization.class);
        return response;
    }

    public Organization deleteOrganization(String token, int orgId) {
        Organization response = RestAssured
                .given()
                .basePath(EndPoints.deleteOrganization)
                .pathParams("orgId", orgId)
                .auth().oauth2(token)
                .post().as(Organization.class);
        return response;
    }

    public Account createAccount(String token, int orgId, String userType) {
        Account response = RestAssured
                .given()
                .basePath(EndPoints.createAccount)
                .params(
                        "company_id", orgId,
                        "email", new Faker().internet().safeEmailAddress(),
                        "first_name", new Faker().name().firstName(),
                        "last_name",new Faker().name().lastName(),
                        "password", "1qazXSW@",/*new Faker().internet().password(8,10,true,true),*/
//                        "site_admin", true,
                        "site_admin", userType == "orgAdmin",
                        "system_admin", userType == "sysAdmin"
                )
                .auth().oauth2(token)
                .post().as(Account.class);
        return response;
    }

    public Account createAccount2(String token,Map<String, String> params) {
        Account response = RestAssured
                .given()
                .basePath(EndPoints.createAccount)
                .params(params)
                .auth().oauth2(token)
                .post().as(Account.class);
        return response;
    }
}
