package com.example.config;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import lombok.Data;

import java.util.Map;


@Data
@EachProperty(value = "my-configuration")
public class MyConfiguration {
    String name;
    Map<String, String> foo;

    public MyConfiguration(@Parameter String name) {
        this.name = name;
    }
}
