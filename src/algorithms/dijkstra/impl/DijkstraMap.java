package algorithms.dijkstra.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DijkstraMap {

    private HashMap<Vertex, HashMap<Vertex, Double>> map = new HashMap<>();

    public void add(Vertex a, Vertex b, double distance) {
        validDistance(distance);
        HashMap<Vertex, Double> inner = this.map.computeIfAbsent(a, k -> new HashMap<>());

        inner.put(b, distance);
    }

    public void remove(Vertex a, Vertex b) {
        if (map.containsKey(a) && map.get(a).containsKey(b)) {
            map.get(a).remove(b);

            if (map.get(a).size() == 0) {
                map.remove(a);
            }
        }
    }

    public void clear() {
        this.map.clear();
    }

    private void validDistance(double value) {
        if (value <= 0) {
            throw new RuntimeException("Distance must be greater than zero.");
        }
    }

    public Set<Vertex> getPoints() {
        HashSet<Vertex> uniq = new HashSet<>();

        for (Vertex from : map.keySet()) {
            uniq.add(from);
            uniq.addAll(map.get(from).keySet());
        }

        return uniq;
    }

    public Set<Vertex> getAvailablePointsFor(Vertex point) {
        if (this.map.containsKey(point)) {
            return this.map.get(point).keySet();
        } else {
            return new HashSet<>();
        }
    }

    public Double getDist(Vertex a, Vertex b) {
        return this.map.get(a).get(b);
    }

    public boolean pointExist(Vertex v) {
        return getPoints().contains(v);
    }
}
