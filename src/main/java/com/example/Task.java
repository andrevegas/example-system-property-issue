package com.example;

import com.example.config.MyConfiguration;
import io.micronaut.context.annotation.Context;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;


@Slf4j
@Context
public class Task {

    public Task(List<MyConfiguration> configurations) {
        configurations.sort(Comparator.comparing(MyConfiguration::getName));
        configurations.forEach(myConfiguration -> {
            log.info(">>> {}", myConfiguration);
        });
    }
}
