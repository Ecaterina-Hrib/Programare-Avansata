package org.example.interfaces;

import org.example.classes.Catalog;
import org.example.classes.CatalogUtil;
import org.example.classes.CatalogUtil.InvalidCatalogException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public interface LoadCommand {
   static Catalog load(String path)
            throws InvalidCatalogException{}
}
