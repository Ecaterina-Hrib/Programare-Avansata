package org.example.compulsory;



import java.io.File;
import java.nio.file.Path;
import java.util.Date;
/**
 * <p>Clasa Item ce contine un fisier de de tip diferit, cu calea, numele si tip de fisier</p>
 */
public class Item {
    private String name;
    private File file;
    private Path path;
    public Item(){

    }

    public Item(String name, File file, Path path) {
        this.name = name;
        this.file = file;
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}

