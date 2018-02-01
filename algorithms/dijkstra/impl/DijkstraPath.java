package algorithms.dijkstra.impl;

import java.util.ArrayList;

public class DijkstraPath {

	private final double distance;

	private ArrayList<Vertex> vertices;

	public DijkstraPath(ArrayList<Vertex> vertices, double distance) {
		this.vertices = vertices;
		this.distance = distance;
	}

	public ArrayList<Vertex> vertices() {
		return new ArrayList<>(vertices);
	}

	public int size() {
		return this.vertices.size();
	}

	public double distance() {
		return distance;
	}

	@Override
	public String toString() {
		return vertices.toString();
	}
}
