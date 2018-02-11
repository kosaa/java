package algorithms.kdtree;

import algorithms.kdtree.impl.KDPoint;
import algorithms.kdtree.impl.KDPointImpl;
import algorithms.kdtree.impl.KDTree;
import java.util.Arrays;

public class Example3DTree {

	public static void main(String[] args) throws CloneNotSupportedException {
		KDTree kd = new KDTree(3);

		kd.insert(new KDPointImpl(5, 4, 9));
		kd.insert(new KDPointImpl(9, 6, 1));
		kd.insert(new KDPointImpl(4, 7, 2));
		kd.insert(new KDPointImpl(9, 2, 0));
		kd.insert(new KDPointImpl(7, 2, 4));

		KDPoint nearest = kd.findNN(new KDPointImpl(10, 1, 0));

		System.out.println("Nearest neighbor: " + Arrays.toString(nearest.getAsVector()));
		System.out.println("Distance: " + kd.getBestDist());
	}
}
