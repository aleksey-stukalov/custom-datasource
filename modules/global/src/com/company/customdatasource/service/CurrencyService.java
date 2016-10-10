package com.company.customdatasource.service;


import com.company.customdatasource.entity.CurrencyEnum;
import com.company.customdatasource.entity.CurrencyRate;

import java.util.Set;

/**
 * Service calls external source to get data in JSON format
 * and parse it into a collection for CurrencyRate entities
 */

public interface CurrencyService {
    String NAME = "customdatasource_CurrencyService";

    Set<CurrencyRate> getRates(CurrencyEnum baseCurrency);
}