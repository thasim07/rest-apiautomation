package com.gitlab.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationToken extends BaseTest{

    public static String accessToken;

    @Test
    public void getAccessToken(){

        Response authorization = given()
                .baseUri(prop.getProperty("baseUri"))
                .queryParam("client_id", prop.getProperty("clientId"))
                .queryParam("client_secret",prop.getProperty("secretId"))
                .queryParam("grant_type","password")
                .formParam("username", prop.getProperty("username"))
                .formParam("password", prop.getProperty("password"))
                .contentType(ContentType.URLENC)
                .post("/oauth/token");

        System.out.println(authorization.asPrettyString());
        Assert.assertEquals(authorization.getStatusCode(),200,"Status Code is:");
        accessToken = authorization.jsonPath().get("access_token");
        System.out.println("the access token is:"+accessToken);
    }
}
