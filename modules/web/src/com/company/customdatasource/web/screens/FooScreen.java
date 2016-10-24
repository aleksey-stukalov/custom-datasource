package com.company.customdatasource.web.screens;

import com.company.customdatasource.web.screens.customdatasources.FooCollectionDatasource;
import com.haulmont.cuba.gui.components.AbstractWindow;

import javax.inject.Inject;
import java.util.Map;

public class FooScreen extends AbstractWindow {

    @Inject
    private FooCollectionDatasource foosDs;

    @Override
    public void init(Map<String, Object> params) {
        foosDs.setMaxResults(50);
    }
}