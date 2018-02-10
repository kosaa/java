package algorithms.kdtree;

import algorithms.kdtree.impl.KDPoint;
import algorithms.kdtree.impl.KDPointImpl;
import algorithms.kdtree.impl.KDTree;
import java.util.Arrays;
import java.util.Random;

public class ExampleKDTree {

	public static final int K = 6;

	public static final int numberOfPoints = 10;

	public static void main(String[] args) throws CloneNotSupportedException {
		KDTree kdtree = KDTree.ofDimension(K);

		for (int i = 0; i < numberOfPoints; ++i) {
			kdtree.insert(generatePoint());
		}

		KDPoint nearest = kdtree.findNN(generatePoint());

		System.out.println("Nearest neighbor: " + Arrays.toString(nearest.getAsVector()));
		System.out.println("Distance: " + kdtree.getBestDist());
	}

	public static KDPointImpl generatePoint() {
		Random rand = new Random();
		int[] vector = new int[K];

		for (int i = 0; i < K; ++i) {
			vector[i] = rand.nextInt(50) + 1;
		}

		return new KDPointImpl(vector);
	}
}
