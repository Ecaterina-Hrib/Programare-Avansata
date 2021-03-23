package org.example.classes;

import org.example.interfaces.AddCommand;
import org.example.interfaces.ListCommand;
import org.example.interfaces.LoadCommand;
import org.example.interfaces.SaveCommand;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil implements AddCommand, ListCommand, SaveCommand, LoadCommand {


    public static void view(Item doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(doc.getLocation());
        System.out.println("Displayed on the screen");

    }

   public static Catalog load(String path)
            throws InvalidCatalogException {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Catalog obj = (Catalog) objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
        System.out.println("The Object has been written to the file");
    }

    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }

    public static class InvalidNameException extends Exception {
        public InvalidNameException(Exception ex) {
            super("Invalid name exception.", ex);
        }
    }
}
