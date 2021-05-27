package com.example.app.com;

import com.example.app.resource.Command;

import java.util.Locale;

public class Display extends Command {
    @Override
    public void execute() {
        System.out.println("Default locale:");
        System.out.println(Locale.getDefault());
        System.out.println("Available locales:");
        Locale available[] = Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + "\t"
                    + locale.getDisplayLanguage(locale));

        }
    }
}
