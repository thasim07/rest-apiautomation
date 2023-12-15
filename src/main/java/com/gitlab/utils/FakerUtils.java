package com.gitlab.utils;
import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

    private static final Faker faker = new Faker();

    static String getUserName(){
        return faker.superhero().name();
    }

    static String getDisc(){
        return faker.food().dish();
    }

    static String getPath(){
        return faker.name().toString();
    }

    static Boolean getInitializeWithReadme(){
        return faker.bool().bool();
    }
}

