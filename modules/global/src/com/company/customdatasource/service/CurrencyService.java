package com.company.customdatasource.service;


import com.company.customdatasource.entity.CurrencyEnum;
import com.company.customdatasource.entity.CurrencyRate;

import java.util.Set;

public interface CurrencyService {
    String NAME = "customdatasource_CurrencyService";

    Set<CurrencyRate> getRates(CurrencyEnum baseCurrency);
}