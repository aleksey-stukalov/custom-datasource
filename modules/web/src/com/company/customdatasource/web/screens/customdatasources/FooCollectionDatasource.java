package com.company.customdatasource.web.screens.customdatasources;

import com.company.customdatasource.entity.Foo;
import com.company.customdatasource.service.FooService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Wraps FooService into a datasource with paging support
 */


public class FooCollectionDatasource extends CustomCollectionDatasource<Foo, UUID> {

    private FooService fooService = AppBeans.get(FooService.class);

    /**
     * @param params
     * @return List of entities. List size is limited to maxResults, starting form firstResult position
     */
    @Override
    protected Collection<Foo> getEntities(Map<String, Object> params) {
        return fooService.getFooList(maxResults, firstResult);
    }

    /**
     * @return Count of all entities, stored in database
     */
    @Override
    public int getCount() {
        return fooService.getFooCount();
    }
}
