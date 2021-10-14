package helpers;

import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectsAPI.Account;
import objectsAPI.Group;
import objectsAPI.Organization;
import objectsAPI.Token;
import java.io.Serializable;
import java.util.Map;

public class API {
    private static final String basePath = "api/2";
    private static final String url = "https://localhost:510";
    private RequestSpecification reqSpec;

    public final class EndPoints{
        private static final String tokenUrl = "/oauth/token";
        private static final String getGroupUrl = "/api/2/group/{groupId}";
        private static final String createGroupUrl = "/api/2/group/create";
        private static final String createOrganizationUrl = "/api/2/organization/{parentId}/organizations/create";
        private static final String deleteOrganizationUrl = "/api/2/organization/{orgId}/delete";
        private static final String createAccountUrl = "/api/2/person/create";
        private static final String getAccountUrl = "/api/2/person/{accountId}";
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

    public Token getToken(String email, String password){
        Token response = RestAssured
                .given()
                .basePath(EndPoints.tokenUrl)
                .params("grant_type", "password", "client_id", "anchor"
                        , "username", email, "password", password)
//                .post().getBody().jsonPath().getString("access_token");
                .post().as(Token.class);
        System.out.println(response);
        return response;
    }

    public Group getGroup(String token) {
        Group response = RestAssured
                .given()
                .baseUri(url)
                .basePath("/api/2/group/1")
                .auth().oauth2(token)
                .get().as(Group.class);
        return response;
    }

    public Group createGroup(String token, int companyId, String groupName) {
        Group response = RestAssured
                .given()
                .basePath(EndPoints.createGroupUrl)
                .params("company_id", companyId, "name", groupName)
                .auth().oauth2(token)
                .post().as(Group.class);
        return response;
    }

    public Organization createOrganization(String token, int orgId) {
        Response response = RestAssured
                .given()
                .basePath(EndPoints.createOrganizationUrl)
                .pathParams("parentId", orgId)
                .params(
                        "name", new Faker().company().name(),
                        "email", new Faker().internet().safeEmailAddress(),
                        "hostname", new Faker().internet().domainName(),
                        "slug",new Faker().company().name()
                )
                .auth().oauth2(token)
                .post();
        System.out.println(response.asString());
        Organization org = response.as(Organization.class);
        System.out.println(org);
        return org;
    }

    public Organization deleteOrganization(String token, int orgId) {
        Organization response = RestAssured
                .given()
                .basePath(EndPoints.deleteOrganizationUrl)
                .pathParams("orgId", orgId)
                .auth().oauth2(token)
                .post().as(Organization.class);
        return response;
    }

    public Account createAccount(String token, int orgId, String userType) {
        String password = new Faker().internet().password(8,10,true,true);
        Account response = RestAssured
                .given()
                .basePath(EndPoints.createAccountUrl)
                .params(
                        "company_id", orgId,
                        "email", new Faker().internet().safeEmailAddress(),
                        "first_name", new Faker().name().firstName(),
                        "last_name",new Faker().name().lastName(),
                        "password", password,
                        "site_admin", userType == "orgAdmin",
                        "system_admin", userType == "sysAdmin"
                )
                .auth().oauth2(token)
                .post().as(Account.class);
        response.password = password;
        System.out.println(response);
        return response;
    }

    public Account createAccount2(String token,Map<String, ? extends Serializable> params) {
        Account response = RestAssured
                .given()
                .basePath(EndPoints.createAccountUrl)
                .params(params)
                .auth().oauth2(token)
                .post().as(Account.class);
        return response;
    }

    public Account getAccount(String token, String accountId) {
        Account acc = RestAssured
                .given()
                .basePath(EndPoints.getAccountUrl)
                .pathParams("accountId", accountId)
                .auth().oauth2(token)
                .get().as(Account.class);
        return acc;
    }

  }
