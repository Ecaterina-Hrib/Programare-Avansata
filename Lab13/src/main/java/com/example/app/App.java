package com.example.app;

import com.example.app.com.Display;
import com.example.app.com.Information;
import com.example.app.com.SetLocale;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   SetLocale location = new SetLocale();
        location.execute();
        Display display = new Display();
        display.execute();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write something valid for translation:");
        String translation = scanner.nextLine();

        System.out.println("THE INFORMATION FOR:");
        Information information = new Information();
        information.execute("default");
    }
}
