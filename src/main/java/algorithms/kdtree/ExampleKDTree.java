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
		KDTree kd = new KDTree(K);

		for (int i = 0; i < numberOfPoints; ++i) {
			kd.insert(generatePoint());
		}

		KDPoint nearest = kd.findNN(generatePoint());

		System.out.println("Nearest neighbor: " + Arrays.toString(nearest.getAsVector()));
		System.out.println("Distance: " + kd.getBestDist());
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
