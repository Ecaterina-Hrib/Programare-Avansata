package org.example.compulsory;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Clasa Catalog contine un array de itemuri ce indeplineste anumite commands: save, load,list,play,etc</p>
 */
public class Catalog implements FileMethod{

   private List<Item> list = new ArrayList<>();
   public Catalog(){

   }
    public Catalog(List<Item> list) {
        this.list = list;
    }

    @Override
    public void add(Item item) {
        list.add(item);
    }

    @Override
    public void list() {
      for(Item s: list){
          System.out.println(s.getName());
      }

    }

    @Override
    public void play(int index)  {
        File file = new File(list.get(index).getPath()+"\\"+list.get(index).getName());
       Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(FileOutputStream way)  {

                  for(Item s: list){
                      ObjectOutputStream out = null;
                      try {
                           out = new ObjectOutputStream(way);

                          out.writeObject(new Item());

                          out.writeObject(s);
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }
        try {
            way.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(FileInputStream way)  {

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(way);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Item date = (Item)in.readObject();
            String message = (String)in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        list.clear();
        while(true) {
            try {
                if (!list.add((Item)in.readObject())) break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ;
        }



    }

    @Override
    public String toString() {
        return "Catalog\n" +
                "list= " + list + "\n"
                ;
    }
}
