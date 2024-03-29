package org.example.classes;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Item implements Serializable {
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags = new HashMap<>();
    public Item()
    {

    }
    public Item(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
}
