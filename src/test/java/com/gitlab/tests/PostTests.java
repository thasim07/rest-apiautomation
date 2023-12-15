package com.gitlab.tests;

import com.gitlab.constants.FrameworkContsants;
import com.gitlab.pojo.Project;
import com.gitlab.utils.ApiUtils;
import com.gitlab.utils.RandomUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostTests extends BaseTest{

    public static String projectId;

    @Test

    public void createProject(){

        Project postData = Project.builder()
                .setName(RandomUtils.getName())
                .setDescription(RandomUtils.getDiscription())
                .setPath(RandomUtils.getPaths())
                .setInitialize_with_readme(RandomUtils.getReadme()).build();

        Response response = given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Accept","*/*")
                .header("Authorization","Bearer "+AuthenticationToken.accessToken)
                .header("Content-Type","application/json")
                .body(postData)
                .when()
                .post(prop.getProperty("post-path"));

        projectId = response.jsonPath().getString("id");
        System.out.println("The project id is:"+projectId);
        System.out.println(response.asPrettyString());
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
        Assert.assertEquals(response.getStatusCode(),201,"Status Code is:");
        ApiUtils.storeValueAsJsonFile(FrameworkContsants.RESPONSE_JSON_FOLDER_PATH,response);

    }
}
