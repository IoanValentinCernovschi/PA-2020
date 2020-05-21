package com;

import java.text.DateFormatSymbols;
import java.util.*;

public class Info {
    public static void getLocaleInfo() {
        if (Locale.getDefault().getLanguage().equals("ro")) {
            String baseName = "res/Messages_ro";
            ResourceBundle infos = ResourceBundle.getBundle(baseName);

            System.out.println(infos.getString("name") + ": " + Locale.getDefault().getDisplayName());
            System.out.println(infos.getString("country") + ": " + Locale.getDefault().getDisplayCountry());
            System.out.println(infos.getString("language") + ": " + Locale.getDefault().getDisplayLanguage(Locale.getDefault()));
            System.out.println(infos.getString("currency") + ": " + Currency.getInstance(Locale.getDefault()).getSymbol());
            System.out.println(infos.getString("week_days") + ": " + Arrays.toString(DateFormatSymbols.getInstance(Locale.getDefault()).getWeekdays()));
            System.out.println(infos.getString("months") + ": " + Arrays.toString(DateFormatSymbols.getInstance(Locale.getDefault()).getMonths()));
            System.out.println(infos.getString("today") + ": " + Calendar.getInstance(Locale.getDefault()).getTime());
        }
        else {
            System.out.println("name: " + Locale.getDefault().getDisplayName());
            System.out.println("country: " + Locale.getDefault().getDisplayCountry());
            System.out.println("language: " + Locale.getDefault().getDisplayLanguage(Locale.getDefault()));
            System.out.println("currency: " + Currency.getInstance(Locale.getDefault()).getSymbol());
            System.out.println("week_days: " + Arrays.toString(DateFormatSymbols.getInstance(Locale.getDefault()).getWeekdays()));
            System.out.println("months: " + Arrays.toString(DateFormatSymbols.getInstance(Locale.getDefault()).getMonths()));
            System.out.println("today: " + Calendar.getInstance(Locale.getDefault()).getTime());
        }
    }
}
