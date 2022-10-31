package com.springbooot.springboot_exercise.domain.parser;

public interface Parser<T> {
    T parse(String str);
}