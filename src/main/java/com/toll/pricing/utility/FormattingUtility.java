package com.toll.pricing.utility;

import java.text.DecimalFormat;

public final class FormattingUtility {

    private FormattingUtility(){}

    public static double roundOffTwoDecimalPoints(double value){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }

    public static Double toDouble(Object value) {
        return ((Number) value).doubleValue();
    }

}
