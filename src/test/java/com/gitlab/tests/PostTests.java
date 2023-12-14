package com.gitlab.tests;

import com.github.javafaker.Faker;
import com.gitlab.pojo.Project;
import com.gitlab.utils.RandomUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostTests extends BaseTest{

    public static String projectId;

    @Test

    public void createProject(){

        Project postdata = Project.builder().setName(RandomUtils.getName())
                .setDescription(RandomUtils.getDiscription())
                .setPath(RandomUtils.getPaths())
                .setInitialize_with_readme(RandomUtils.getReadme()).build();

        Response response = given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Accept","*/*")
                .header("Authorization","Bearer "+AuthenticationToken.accessToken)
                .header("Content-Type","application/json")
                .body(postdata)
                .when()
                .post(prop.getProperty("post-path"));

        projectId = response.jsonPath().getString("id");
        System.out.println("The project id is:"+projectId);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),201,"Status Code is:");
    }
}
