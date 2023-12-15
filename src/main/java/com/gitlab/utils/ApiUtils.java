package com.gitlab.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils(){}

    @SneakyThrows
    public static void storeValueAsJsonFile(String filepath, Response response){
        Files.write(Paths.get(filepath),response.asByteArray());
    }
}
