package com.gitlab.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set")


public class Project {
    @Getter
    @Setter
    private String name;
    private String description;
    private String path;
    private Boolean initialize_with_readme;



}
