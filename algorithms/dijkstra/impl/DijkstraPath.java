package algorithms.dijkstra.impl;

import java.util.ArrayList;

public class DijkstraPath {

    private final double distance;
    private ArrayList<Vertex> points;

    public DijkstraPath(ArrayList<Vertex> points, double distance) {
        this.points = points;
        this.distance = distance;
    }

    public ArrayList<Vertex> points() {
        return new ArrayList<>(points);
    }

    public int size() {
        return this.points.size();
    }

    public double distance() {
        return distance;
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
