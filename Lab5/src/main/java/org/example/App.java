package org.example;

import org.example.classes.Catalog;
import org.example.classes.CatalogUtil;
import org.example.classes.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Shell+Interfaces-optional + compuslory
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException, CatalogUtil.InvalidCatalogException, CatalogUtil.InvalidNameException {
        App app = new App();
        String commandLine;
        app.testCreateSave();
        app.testLoadView();
        String command;
        BufferedReader console = new BufferedReader
                (new InputStreamReader(System.in));
        while(true)
        {  System.out.print("shell>");
            commandLine = console.readLine();
            if (commandLine.equals("save")){
                System.out.print("save: ");
                commandLine = console.readLine();
                Item item = new Item();
                item.setId(commandLine);
                commandLine = console.readLine();
                item.setName(commandLine);
                commandLine = console.readLine();
                item.setLocation(commandLine);

            }
          else if(commandLine.equals("load"))
            {
                System.out.print("load: ");
                commandLine = console.readLine();
                Item item = new Item();
                item.setId(commandLine);
                commandLine = console.readLine();
                item.setName(commandLine);
                commandLine = console.readLine();
                item.setLocation(commandLine);

            }
          else if(commandLine.equals("add"))
            {
                System.out.print("add: ");
                commandLine = console.readLine();
                Item item = new Item();
                item.setId(commandLine);
                commandLine = console.readLine();
                item.setName(commandLine);
                commandLine = console.readLine();
                item.setLocation(commandLine);
            }
            else if(commandLine.equals("list"))
            {
                System.out.print("list: ");
                commandLine = console.readLine();
                Item item = new Item();
                item.setId(commandLine);
                commandLine = console.readLine();
                item.setName(commandLine);
                commandLine = console.readLine();
                item.setLocation(commandLine);
            }
            else if(commandLine.equals("exit"))
            {
                System.out.print("exit");
                continue;

            }
        }



    }
    private void testCreateSave() throws IOException, CatalogUtil.InvalidNameException {
        Catalog catalog =
                new Catalog("Pictures", "D:\\_ user ecaaa\\Desktop\\catalog.ser");
        Item doc = new Item("Picture1", "Rota",
                "D:\\_ user ecaaa\\Desktop\\rota.png");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }
    private void testLoadView() throws CatalogUtil.InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("D:\\_ user ecaaa\\Desktop\\catalog.ser");
        assert catalog != null;
        Item doc = catalog.findById("Picture1");
        CatalogUtil.view(doc);
    }
}
