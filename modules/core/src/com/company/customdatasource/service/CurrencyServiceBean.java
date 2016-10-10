package com.company.customdatasource.service;

import com.company.customdatasource.entity.CurrencyEnum;
import com.company.customdatasource.entity.CurrencyRate;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

@Service(CurrencyService.NAME)
public class CurrencyServiceBean implements CurrencyService {

    /**
     * Method calls fixer.io service to get up to date info on currency conversion rates
     * in JSON format and converts data into a set of CurrencyRate entities
     * @param baseCurrency shows what currency will the the base one;
     *                     all the conversion rates will be returned into the base currency
     * @return Set of CurrencyRate entities
     */
    @Override
    public Set<CurrencyRate> getRates(CurrencyEnum baseCurrency){

        Set<CurrencyRate> result = new HashSet<>();

        String req = "http://api.fixer.io/latest?base=" + baseCurrency.getId();
        StringBuilder json = new StringBuilder();

        try {
            URL url = new URL(req);
            URLConnection connection = url.openConnection();
            try (InputStream in = connection.getInputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }

        JSONObject response = new JSONObject(json.toString());
        JSONObject rates = response.getJSONObject("rates");

        for (CurrencyEnum cur : CurrencyEnum.values()) {
            Object rate;

            try {
                rate = rates.get(cur.getId());
            } catch (JSONException e) {
                rate = null;
            }

            if (rate != null) {
                CurrencyRate cr = new CurrencyRate();
                cr.setCurrencyFrom(CurrencyEnum.fromId(response.get("base").toString()));
                cr.setCurrencyTo(cur);
                cr.setConversionRate(new BigDecimal(rate.toString()));

                result.add(cr);
            }
        }

        return result;
    }
}