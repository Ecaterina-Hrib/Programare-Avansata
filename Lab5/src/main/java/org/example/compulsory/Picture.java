package org.example.compulsory;

import java.io.File;
import java.nio.file.Path;

public class Picture extends  Item{
    public Picture() {
    }

    public Picture(String name, File file, Path path) {
        super(name, file, path);
    }

    @Override
    public String toString() {
        return "Picture{}";
    }
}
