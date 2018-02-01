package algorithms.dijkstra.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DijkstraMap {

	private HashMap<Vertex, HashMap<Vertex, Double>> map = new HashMap<>();

	public void add(Vertex a, Vertex b, double distance) {
		validDistance(distance);
		HashMap<Vertex, Double> inner = map.computeIfAbsent(a, k -> new HashMap<>());

		inner.put(b, distance);
	}

	private void validDistance(double value) {
		if (value <= 0) {
			throw new RuntimeException("Distance must be greater than zero.");
		}
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
		map.clear();
	}

	public boolean vertexExists(Vertex v) {
		return getUniqueVerticesList().contains(v);
	}

	public Set<Vertex> getUniqueVerticesList() {
		HashSet<Vertex> unique = new HashSet<>();

		for (Vertex from : map.keySet()) {
			unique.add(from);
			unique.addAll(map.get(from).keySet());
		}

		return unique;
	}

	public Set<Vertex> getAvailableVerticesFrom(Vertex v) {
		if (map.containsKey(v)) {
			return map.get(v).keySet();
		} else {
			return new HashSet<>();
		}
	}

	public Double getDist(Vertex a, Vertex b) {
		if (!map.containsKey(a)) {
			throw new RuntimeException("Vertex " + a + " doesn't exist.");
		}

		if (!map.get(a).containsKey(b)) {
			throw new RuntimeException("Vertex " + a  + " isn't connected with " + b + ".");
		}

		return map.get(a).get(b);
	}
}
