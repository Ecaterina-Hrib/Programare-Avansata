package org.example.compulsory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * <p>Am folosit interfata pentru metodele standard folosite</p>
 */
public interface FileMethod {
    public void add(Picture item);
    public void list();
    public void play(int index) ;
    public void save(FileOutputStream way);
    public void load(FileInputStream way) ;


}
