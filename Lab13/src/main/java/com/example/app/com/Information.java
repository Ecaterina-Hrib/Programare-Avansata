package com.example.app.com;
import com.example.app.resource.Command;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
public class Information extends Command {
    public void execute(String parametru){
        Locale newLocal;
        if(parametru.equals("default")){
            newLocal = Locale.getDefault();
        }
        else{
            newLocal = new Locale(parametru);
        }
        String country =  newLocal.getCountry();
        System.out.print("Country: " + country);
        System.out.println();

        String language =  newLocal.getLanguage();
        System.out.print("Language: " + language.toUpperCase());
        System.out.println();


        String currency = Currency.getInstance(newLocal).toString();
        System.out.print("Currency: " + currency);
        System.out.println();


        String[] zile = new DateFormatSymbols(newLocal).getWeekdays();
        System.out.print("Week days: ");
        for(String zi: zile){
            System.out.printf("%s ", zi);
        }
        System.out.println();


        String[] luni = new DateFormatSymbols(newLocal).getMonths();
        System.out.println("Months: ");
        for(String luna : luni){
            System.out.printf("%s ", luna);
        }
        System.out.println();

        System.out.print("Today: ");

        Date data = new Date();
        System.out.println(data);
    }
}
