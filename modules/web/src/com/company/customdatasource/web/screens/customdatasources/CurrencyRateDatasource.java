/*
 * TODO Copyright
 */

package com.company.customdatasource.web.screens.customdatasources;

import com.company.customdatasource.entity.CurrencyEnum;
import com.company.customdatasource.entity.CurrencyRate;
import com.company.customdatasource.service.CurrencyService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

/**
 * Created by stukalov on 25/07/2016.
 * Wraps CurrencyService into a collection datasource to be able to use
 * standard CUBA datasource mechanisms
 */
public class CurrencyRateDatasource extends CustomCollectionDatasource<CurrencyRate, UUID> {

    private CurrencyService currencyService = AppBeans.get(CurrencyService.NAME);

    @Override
    protected Collection<CurrencyRate> getEntities(Map params) {
        CurrencyEnum currencyFrom = (CurrencyEnum) params.get("currency-from");

        if (currencyFrom != null)
            return currencyService.getRates(currencyFrom);
        else
            return new HashSet<>();

    }
}
