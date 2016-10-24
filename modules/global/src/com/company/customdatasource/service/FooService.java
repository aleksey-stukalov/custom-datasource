package com.company.customdatasource.service;


import com.company.customdatasource.entity.Foo;

import java.util.List;

public interface FooService {
    String NAME = "customdatasource_FooService";

    List<Foo> getFooList(int maxResults, int firstResult);

    int getFooCount();
}