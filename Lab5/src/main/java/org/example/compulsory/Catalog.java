package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private String path;
    private List<Item> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    //…
    public void add(Item doc) {
        documents.add(doc);
    }

    public Item findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Item> documents) {
        this.documents = documents;
    }
}
