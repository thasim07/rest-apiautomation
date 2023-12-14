package com.gitlab.utils;
import com.github.javafaker.Faker;

public class FakerUtils {

    private FakerUtils(){}

    private static final Faker faker = new Faker();

    static String getUserName(){
        return faker.superhero().name();
    }

    static String getDisc(){
        return faker.funnyName().toString();
    }

    static String getPath(){
        return faker.crypto().toString();
    }

    static Boolean getInitializeWithReadme(){
        return faker.bool().bool();
    }
}

