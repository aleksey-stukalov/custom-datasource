package com.company.customdatasource.web.screens;

import com.company.customdatasource.entity.CurrencyEnum;
import com.company.customdatasource.web.screens.customdatasources.CurrencyRateDatasource;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.LookupField;

import javax.inject.Inject;
import java.util.Map;

public class CurrencyScreen extends AbstractWindow {


    @Inject
    private LookupField currencyLookup;

    @Inject
    private CurrencyRateDatasource currencyRatesDs;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        currencyLookup.setOptionsEnum(CurrencyEnum.class);
        currencyLookup.addValueChangeListener(e -> currencyRatesDs.refresh(ParamsMap.of("currency-from", currencyLookup.getValue())));
    }
}