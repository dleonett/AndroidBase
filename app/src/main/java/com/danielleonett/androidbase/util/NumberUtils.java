package com.danielleonett.androidbase.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author daniel.leonett
 */

public class NumberUtils {

    public static double roundTwoDecimals(double number) {
        return roundDecimals(number, 2);
    }

    private static double roundDecimals(double number, int places) {
        return new BigDecimal(String.valueOf(number))
                .setScale(places, RoundingMode.HALF_UP).doubleValue();
    }

    public static double fromCurrencyFormat(String formatted) {
        String cleanString = formatted.replaceAll("[-$ .]", "")
                .replace(",", ".");
        return Double.parseDouble(cleanString);
    }

}
