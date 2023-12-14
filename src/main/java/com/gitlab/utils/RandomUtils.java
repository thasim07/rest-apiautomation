package com.gitlab.utils;

public final class RandomUtils {

    //business layer --> all the business level changes

    private RandomUtils(){}

    public static String getName(){
        return FakerUtils.getUserName().toLowerCase();
    }
    public static String getDiscription(){
        return FakerUtils.getDisc().toLowerCase();
    }

    public static String getPaths(){
        return FakerUtils.getPath().toLowerCase();
    }
    public static Boolean getReadme(){
        return FakerUtils.getInitializeWithReadme();
    }

}
