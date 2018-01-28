package algorithms.dijkstra.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Dijkstra {

    private HashMap<Vertex, Double> dist = new HashMap<>();

    private HashMap<Vertex, Vertex> pred = new HashMap<>();

    private HashMap<Vertex, Boolean> visitedPoints = new HashMap<>();

    private DijkstraMap map = new DijkstraMap();

    private Vertex startPoint;

    public void add(Vertex a, Vertex b, int distance) {
        add(a, b, (double) distance);
    }

    public void add(Vertex a, Vertex b, double distance) {
        map.add(a, b, distance);
    }

    public void remove(Vertex a, Vertex b) {
        startPoint = null;
        map.remove(a, b);
    }

    public void clear() {
        startPoint = null;
        map.clear();
    }

    public DijkstraPath getShortestPath(Vertex a, Vertex b) {
        if (!map.pointExist(a)) {
            throw new RuntimeException("Point " + a + " doesn't exist.");
        }

        if (!map.pointExist(b)) {
            throw new RuntimeException("Point " + b + " doesn't exist.");
        }

        if (startPoint == null || !startPoint.getIdentifier().equals(a.getIdentifier())) {
            System.out.println("do calc");
            dist.clear();
            pred.clear();
            visitedPoints.clear();
            startPoint = a;

            init();
        }

        if (dist.containsKey(b)) {
            return new DijkstraPath(createPointList(b), dist.get(b));
        } else {
            return new DijkstraPath(new ArrayList<>(), -1);
        }
    }

    private ArrayList<Vertex> createPointList(Vertex point) {
        ArrayList<Vertex> path = new ArrayList<>();

        while (point != null) {
            path.add(0, point);
            point = pred.get(point);
        }

        return path;
    }

    private void init() {
        dist.put(startPoint, 0.0);
        pred.put(startPoint, null);
        Vertex current = startPoint;

        for (int i = 0; i < map.getPoints().size(); ++i) {
            setPointVisited(current);
            Set<Vertex> availablePoints = map.getAvailablePointsFor(current);

            for (Vertex point : availablePoints) {
                if (!isPointVisited(point) && (!dist.containsKey(point) || dist.get(current) + map.getDist(current, point) < dist.get(point))) {
                    dist.put(point, dist.get(current) + map.getDist(current, point));
                    pred.put(point, current);
                }
            }

            current = closestPoint();
        }
    }

    private Vertex closestPoint() {
        double min = Integer.MAX_VALUE;
        Vertex closest = null;

        for (Vertex point : map.getPoints()) {
            if (!isPointVisited(point) && dist.get(point) != null && dist.get(point) < min) {
                closest = point;
                min = dist.get(point);
            }
        }

        return closest;
    }

    private void setPointVisited(Vertex point) {
        visitedPoints.put(point, true);
    }

    private boolean isPointVisited(Vertex point) {
        return visitedPoints.containsKey(point);
    }

    public Set<Vertex> getUniquePoints() {
        return this.map.getPoints();
    }
}
