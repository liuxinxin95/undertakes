package com.example.undertakes.service;


@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);

}