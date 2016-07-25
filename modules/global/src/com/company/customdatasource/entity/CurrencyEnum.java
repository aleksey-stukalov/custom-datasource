package com.company.customdatasource.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CurrencyEnum implements EnumClass<String> {

    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    RUB("RUB"),
    RON("RON"),
    AUD("AUD"),
    BGN("BGN"),
    BRL("BRL");

    private String id;

    CurrencyEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CurrencyEnum fromId(String id) {
        for (CurrencyEnum at : CurrencyEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}