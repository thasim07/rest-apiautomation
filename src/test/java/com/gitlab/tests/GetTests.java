package com.gitlab.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTests extends BaseTest{

    @Test
    public void getSingleProject(){

        Response response =given()
                .baseUri(prop.getProperty("baseUri"))
                .header("Authorization","Bearer "+AuthenticationToken.accessToken)
                .pathParam("id",PostTests.projectId)
                .get(prop.getProperty("Get-path"));
        System.out.println("The single project :"+response.getBody().asPrettyString());
        assertThat(response.getStatusCode())
                .isEqualTo(200);
//        assertThat(response.jsonPath().getList("$").size())
//                .isGreaterThan(30);
    }

}
