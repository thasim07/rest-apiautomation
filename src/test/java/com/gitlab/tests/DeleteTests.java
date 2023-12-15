package com.gitlab.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTests extends BaseTest{
    @Test

    public void deleteProject(){
        Response response = given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Accept","*/*")
                .header("Authorization","Bearer "+AuthenticationToken.accessToken)
                .header("Content-Type","application/json")
                .pathParam("id",PostTests.projectId)
                .when()
                .delete(prop.getProperty("delete-path"));
        System.out.println("the deleted project:"+response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(),202,"Status Code is:");
    }
}
