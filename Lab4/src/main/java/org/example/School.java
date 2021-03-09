package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School implements Comparable<School>{
    private String name;
    private int capacity;

public School(String name)
{
    this.name=name;
}


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +

                '}';
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(School o) {
        return 0;
    }
}
