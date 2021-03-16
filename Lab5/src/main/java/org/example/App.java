package org.example;
import org.example.compulsory.Catalog;
import org.example.compulsory.Item;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;
/**
 * <p>Am formatat 2 ietmuri, le-am adaugat in catalog apoi am facut operatii de tip catalog pe ele</p>
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Item item = new Item();
        Item item2 = new Item();
        item2.setName("best.jpg");
        item.setName("rota.png");
        item.setPath(Paths.get("D:\\_ user ecaaa\\Desktop"));
        item2.setPath(Paths.get("D:\\_ user ecaaa\\Desktop"));
      Catalog first = new Catalog();
      first.add(item);
        first.add(item2);
        first.play(0);
        first.play(1);
        first.list();


        try {
            FileOutputStream  out = new FileOutputStream("catalog.txt");
            first.save(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream("catalog.txt");
            first.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }
}
