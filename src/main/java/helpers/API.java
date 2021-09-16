package helpers;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import objectsAPI.Group;
import objectsAPI.Token;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

public class API {
    private static final String basePath = "api/2";
    private static final String url = "https://localhost:510";
    private RequestSpecification reqSpec;

    public final class EndPoints{
        private static final String token = "/oauth/token";
        private static final String getGroup = "/api/2/group/{groupId}";
        private static final String createGroup = "/api/2/group/create";
    }

    public API(){
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri(url)
                .log(LogDetail.ALL)
//                .addFilter(new AllureRestAssured())
                .build();
    }

//    public void init() {
//        TrustManager[] trustAllCerts = new TrustManager[] {
//                new X509TrustManager() {
//                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                        return new X509Certificate[0];
//                    }
//                    public void checkClientTrusted(
//                            java.security.cert.X509Certificate[] certs, String authType) {
//                    }
//                    public void checkServerTrusted(
//                            java.security.cert.X509Certificate[] certs, String authType) {
//                    }
//                }
//        };
//        try {
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, trustAllCerts, new java.security.SecureRandom());
//            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//        } catch (GeneralSecurityException e) {
//        }
//        // Now you can access an https URL without having the certificate in the truststore
//        try {
//            URL url = new URL("https://localhost:510");
//        } catch (MalformedURLException e) {
//        }
//    }

//    @Step("getToken")
    public Token getToken(){
        Token response = RestAssured
                .given()
                .baseUri(url)
                .basePath(EndPoints.token)
                .params("grant_type", "password", "client_id", "anchor"
                        , "username", "admin@admin.com", "password", "1q2w3e4r5t!")
//                .post().getBody().jsonPath().getString("access_token");
//                .log().all()
                .post().as(Token.class);
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
        System.out.println(response);
        return response;
    }

//    @Step("CREATE")
    public Group createGroup(String token, int companyId, String groupName) {
        Group response = RestAssured
                .given()
                .baseUri(url)
                .basePath(EndPoints.createGroup)
                .params("company_id", companyId, "name", groupName)
                .auth().oauth2(token)
                .log().all()
                .post().as(Group.class);
        System.out.println(response);
        return response;
    }

}
