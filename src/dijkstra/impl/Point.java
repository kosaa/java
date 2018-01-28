package dijkstra.impl;

public class Point implements Vertex {

    private String name;

    public Point(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String getIdentifier() {
        return getName();
    }
}
