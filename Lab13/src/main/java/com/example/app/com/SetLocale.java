package com.example.app.com;
import com.example.app.resource.Command;

import java.util.Locale;
public class SetLocale extends Command {
    @Override
    public void execute() {
        Locale local = Locale.getDefault();
        Locale.setDefault(local);
    }


}
