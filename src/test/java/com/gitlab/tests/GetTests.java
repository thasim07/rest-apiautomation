package com.gitlab.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetTests extends BaseTest {

    @Test(priority = 1)
    public void getSingleProject() {
        Response response = given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Authorization", "Bearer " + AuthenticationToken.accessToken)
                .pathParam("id", PostTests.projectId)
                .get(prop.getProperty("Get-path"));

        System.out.println("The single project :" + response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void getProjects() {

        Response response = given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Authorization", "Bearer " + AuthenticationToken.accessToken)
                .get(prop.getProperty("Get-projects"));

        System.out.println("All projects :" + response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
