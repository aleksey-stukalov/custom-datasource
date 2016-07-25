package com.company.customdatasource.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import java.math.BigDecimal;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

@MetaClass(name = "customdatasource$CurrencyRate")
public class CurrencyRate extends AbstractNotPersistentEntity {
    private static final long serialVersionUID = 5841089201111192140L;

    @MetaProperty(mandatory = true)
    protected String currencyFrom;

    @MetaProperty(mandatory = true)
    protected String currencyTo;

    @MetaProperty
    protected BigDecimal conversionRate;

    public void setCurrencyTo(CurrencyEnum currencyTo) {
        this.currencyTo = currencyTo == null ? null : currencyTo.getId();
    }

    public CurrencyEnum getCurrencyTo() {
        return currencyTo == null ? null : CurrencyEnum.fromId(currencyTo);
    }


    public void setCurrencyFrom(CurrencyEnum currencyFrom) {
        this.currencyFrom = currencyFrom == null ? null : currencyFrom.getId();
    }

    public CurrencyEnum getCurrencyFrom() {
        return currencyFrom == null ? null : CurrencyEnum.fromId(currencyFrom);
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }


}