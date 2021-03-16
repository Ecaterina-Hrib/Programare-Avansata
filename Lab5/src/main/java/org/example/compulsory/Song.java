package org.example.compulsory;

import java.io.File;
import java.nio.file.Path;

public class Song extends Item{
    public Song() {
    }

    public Song(String name, File file, Path path) {
        super(name, file, path);
    }

    @Override
    public String toString() {
        return "Song{}";
    }
}
