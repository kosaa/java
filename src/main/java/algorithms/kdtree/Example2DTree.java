package algorithms.kdtree;

import algorithms.kdtree.impl.KDPoint;
import algorithms.kdtree.impl.KDPointImpl;
import algorithms.kdtree.impl.KDTree;
import java.util.Arrays;

public class Example2DTree {

	public static void main(String[] args) throws CloneNotSupportedException {
		KDTree kd = new KDTree(2);

		kd.insert(new KDPointImpl(2, 3));
		kd.insert(new KDPointImpl(3, 5));
		kd.insert(new KDPointImpl(1, 2));
		kd.insert(new KDPointImpl(5, 9));
		kd.insert(new KDPointImpl(4, 6));

		KDPoint nearest = kd.findNN(new KDPointImpl(10, 1));

		System.out.println("Nearest neighbor: " + Arrays.toString(nearest.getAsVector()));
		System.out.println("Distance: " + kd.getBestDist());
	}
}
