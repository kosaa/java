package algorithms;

import algorithms.dijkstra.impl.Dijkstra;
import algorithms.dijkstra.impl.DijkstraPath;
import algorithms.dijkstra.impl.Point;
import org.junit.Assert;
import org.junit.Test;

public class DijkstraTest {

	private Point A = new Point("A");
	private Point B = new Point("B");
	private Point C = new Point("C");
	private Point D = new Point("D");
	private Point E = new Point("E");

	@Test
	public void dijkstraShortestPath1Test() {
		Dijkstra dijkstra = new Dijkstra();

		dijkstra.add(A, B, 5);
		dijkstra.add(B, C, 5);
		dijkstra.add(A, C, 3);

		DijkstraPath path = dijkstra.getShortestPath(A, C);

		Assert.assertEquals(path.size(), 2.0, 0);
		Assert.assertEquals(path.distance(), 3.0, 0);
	}

	@Test
	public void dijkstraShortestPath2Test() {
		Dijkstra dijkstra = new Dijkstra();

		dijkstra.add(A, B, 2);
		dijkstra.add(A, C, 10);
		dijkstra.add(B, D, 1);
		dijkstra.add(C, E, 3);
		dijkstra.add(D, E, 9);
		dijkstra.add(D, C, 1);

		DijkstraPath path = dijkstra.getShortestPath(A, E);

		Assert.assertEquals(path.size(), 5.0, 0);
		Assert.assertEquals(path.distance(), 7.0, 0);
	}
}
