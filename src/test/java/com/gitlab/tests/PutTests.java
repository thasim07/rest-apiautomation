package com.gitlab.tests;

import com.gitlab.pojo.Project;
import com.gitlab.utils.FakerUtils;
import com.gitlab.utils.RandomUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.gitlab.pojo.Project.*;
import static io.restassured.RestAssured.given;

public class PutTests extends BaseTest{

    @Test
    public void updateProject(){

        Project updatedata = builder().setName(RandomUtils.getName()).build();

        Response response = given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Accept","*/*")
                .header("Authorization","Bearer "+AuthenticationToken.accessToken)
                .header("Content-Type","application/json")
                .pathParam("id",PostTests.projectId)
                .body(updatedata)
                .when()
                .put(prop.getProperty("update-path"));

        System.out.println("Name has been updated:"+response.jsonPath().getString("name"));
        System.out.println("The updated data is: "+response.getBody().asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200,"Status code is:");

    }
}
