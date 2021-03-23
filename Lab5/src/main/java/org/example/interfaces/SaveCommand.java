package org.example.interfaces;

import org.example.classes.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public interface SaveCommand {
    static void save(Catalog catalog)
            throws IOException{}
}
