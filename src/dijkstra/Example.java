package dijkstra;

import dijkstra.impl.Dijkstra;
import dijkstra.impl.DijkstraPath;
import dijkstra.impl.Point;

public class Example {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();

        Point A = new Point("A");
        Point B = new Point("B");
        Point C = new Point("C");
        Point D = new Point("D");
        Point E = new Point("E");

        dijkstra.add(A, B, 2);
        dijkstra.add(A, C, 10);
        dijkstra.add(B, D, 1);
        dijkstra.add(C, E, 3);
        dijkstra.add(D, E, 9);
        dijkstra.add(D, C, 1);

        DijkstraPath path = dijkstra.getShortestPath(A, E);

        System.out.println("Path: " + path.points());
        System.out.println("Size: " + path.size());
        System.out.println("Distance: " + path.distance());
    }
}
