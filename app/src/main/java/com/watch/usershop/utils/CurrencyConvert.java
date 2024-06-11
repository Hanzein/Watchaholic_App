package com.watch.usershop.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConvert {


    public static String currencyConverter(String countryId, String language, Double inputNumber)
    {
        Locale localeId = new Locale(language, countryId);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeId);

        return currencyFormat.format(inputNumber);
    }
}
