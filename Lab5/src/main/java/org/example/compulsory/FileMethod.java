package org.example.compulsory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
/**
 * <p>Am folosit interfata pentru metodele standard folosite</p>
 */
public interface FileMethod {
    public void add(Item item);
    public void list();
    public void play(int index) ;
    public void save(FileOutputStream way);
    public void load(FileInputStream way) ;


}
