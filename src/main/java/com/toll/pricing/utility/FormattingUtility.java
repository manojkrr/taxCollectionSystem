package com.toll.pricing.utility;

import java.text.DecimalFormat;

public final class FormattingUtility {

    private FormattingUtility(){}

    //Rounds off to decimal points
    public static double roundOff(double value, int decimalPoints){
        if(decimalPoints >= 1){
            StringBuilder pattern = new StringBuilder("#.");
            while (decimalPoints!=0){
                pattern.append("#");
                decimalPoints--;
            }
            DecimalFormat df = new DecimalFormat(pattern.toString());
            return Double.parseDouble(df.format(value));
        }
        return value;
    }

    public static Double toDouble(Object value) {
        return ((Number) value).doubleValue();
    }

}
