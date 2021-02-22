package org.example;

public class Source {
    private String name;
    private SourceType type;
    private Integer capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Source(String name, SourceType type, Integer capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
