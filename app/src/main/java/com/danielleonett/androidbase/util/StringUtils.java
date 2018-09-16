package com.danielleonett.androidbase.util;

import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class StringUtils {

    public static String toString(Object object) {
        return new Gson().toJson(object);
    }

    public static String toCurrencyFormat(Double amount, boolean withCurrencySign) {
        if (amount == null) {
            amount = 0d;
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        String currencySign = withCurrencySign ? "$ " : "";

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

        if (amount < 0) {
            return "- " + currencySign + decimalFormat.format(amount * -1);
        }

        return currencySign + decimalFormat.format(amount);
    }

    public static String fromCurrencyFormat(String formatted) {
        return formatted.replaceAll("[-$ .]", "")
                .replace(",", ".");
    }

    public static String asPercentage(Double amount) {
        if (amount == null) {
            amount = 0d;
        }

        return String.format("%s %%", toCurrencyFormat(amount, false));
    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static String join(List<String> strings) {
        return join(strings, ", ", " y ");
    }

    public static String join(List<String> strings, String separator, String lastSeparator) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strings.size(); i++) {
            result.append(strings.get(i));
            if (i < strings.size() - 2) {
                result.append(separator);
            }
            if (i == strings.size() - 2) {
                result.append(lastSeparator);
            }
        }

        return result.toString();
    }
}
