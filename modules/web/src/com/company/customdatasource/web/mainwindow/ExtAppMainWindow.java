package com.company.customdatasource.web.mainwindow;

import com.company.customdatasource.entity.CurrencyEnum;
import com.company.customdatasource.entity.CurrencyRate;
import com.company.customdatasource.service.CurrencyService;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.Set;

public class ExtAppMainWindow extends AppMainWindow {

    @Inject
    private Label label;

    @Inject
    private CurrencyService currencyService;

    private static final CurrencyEnum BASE_CURRENCY = CurrencyEnum.USD;

    private Integer currencyToShow = 0;


    @Override
    public void ready() {
        super.ready();
        showNextCurrencyRate(null);
    }


    public void showNextCurrencyRate(Timer source) {
        Set<CurrencyRate> currencyRates = currencyService.getRates(BASE_CURRENCY);
        CurrencyEnum currencyTo = getNextCurrencyToShow(BASE_CURRENCY);

        currencyRates.stream().filter(r -> r.getCurrencyTo().equals(currencyTo)).forEach(r -> {
            String html = "<p style=\"text-align: center; font-size: 60px;\"><span style=\"color: #339966;\"><strong>1 " + r.getCurrencyFrom().getId()
                    + "&nbsp;&rarr; " + r.getConversionRate().toString() + " "
                    + r.getCurrencyTo().getId() + "</strong></span></p>";
            label.setValue(html);
        });
    }

    private CurrencyEnum getNextCurrencyToShow(CurrencyEnum escapeCurrency) {
        CurrencyEnum result = CurrencyEnum.values()[currencyToShow];
        if (result.equals(escapeCurrency))
            result = CurrencyEnum.values()[++currencyToShow];
        currencyToShow = (currencyToShow + 1) % CurrencyEnum.values().length;

        return result;
    }

    public void openCurrencyExchangeScreen() {
        openWindow("currency-screen", WindowManager.OpenType.NEW_TAB);
    }
}
