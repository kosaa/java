package algorithms.dijkstra.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Dijkstra {

	private HashMap<Vertex, Double> dist = new HashMap<>();

	private HashMap<Vertex, Vertex> pred = new HashMap<>();

	private HashMap<Vertex, Boolean> visitedVertices = new HashMap<>();

	private DijkstraMap map = new DijkstraMap();

	private Vertex startVertex;

	public void add(Vertex a, Vertex b, int distance) {
		add(a, b, (double) distance);
	}

	public void add(Vertex a, Vertex b, double distance) {
		map.add(a, b, distance);
	}

	public void remove(Vertex a, Vertex b) {
		startVertex = null;
		map.remove(a, b);
	}

	public void clear() {
		startVertex = null;
		map.clear();
	}

	public DijkstraPath getShortestPath(Vertex a, Vertex b) {
		if (!map.vertexExists(a)) {
			throw new RuntimeException("Vertex " + a + " doesn't exist.");
		}

		if (!map.vertexExists(b)) {
			throw new RuntimeException("Vertex " + b + " doesn't exist.");
		}

		if (startVertex == null || !startVertex.getIdentifier().equals(a.getIdentifier())) {
			dist.clear();
			pred.clear();
			visitedVertices.clear();
			startVertex = a;

			init();
		}

		if (dist.containsKey(b)) {
			return new DijkstraPath(createListTo(b), dist.get(b));
		} else {
			return new DijkstraPath(new ArrayList<Vertex>(), -1);
		}
	}

	private ArrayList<Vertex> createListTo(Vertex v) {
		ArrayList<Vertex> path = new ArrayList<>();

		do {
			path.add(0, v);
		} while ((v = pred.get(v)) != null);

		return path;
	}

	private void init() {
		dist.put(startVertex, 0.0);
		pred.put(startVertex, null);
		Vertex current = startVertex;

		for (int i = 0; i < map.getUniqueVerticesList().size(); ++i) {
			setAsVisited(current);

			for (Vertex v : map.getAvailableVerticesFrom(current)) {
				if (isVisited(v)) {
					continue;
				}

				if (!dist.containsKey(v) || dist.get(current) + map.getDist(current, v) < dist.get(v)) {
					dist.put(v, dist.get(current) + map.getDist(current, v));
					pred.put(v, current);
				}
			}

			current = findClosestVertex();
		}
	}

	private void setAsVisited(Vertex v) {
		visitedVertices.put(v, true);
	}

	private boolean isVisited(Vertex v) {
		return visitedVertices.containsKey(v);
	}

	private Vertex findClosestVertex() {
		Vertex vertex = null;
		double distanceToVertex = Integer.MAX_VALUE;

		for (Vertex v : map.getUniqueVerticesList()) {
			if (!isVisited(v) && dist.get(v) != null && dist.get(v) < distanceToVertex) {
				vertex = v;
				distanceToVertex = dist.get(v);
			}
		}

		return vertex;
	}

	public Set<Vertex> getUniqueVerticesList() {
		return map.getUniqueVerticesList();
	}
}
