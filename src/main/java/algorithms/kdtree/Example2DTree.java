package algorithms.kdtree;

import algorithms.kdtree.impl.KDPoint;
import algorithms.kdtree.impl.KDPointImpl;
import algorithms.kdtree.impl.KDTree;
import java.util.Arrays;

public class Example2DTree {

	public static void main(String[] args) throws CloneNotSupportedException {
		KDTree kdtree = KDTree.ofDimension(2);

		kdtree.insert(new KDPointImpl(2, 3));
		kdtree.insert(new KDPointImpl(3, 5));
		kdtree.insert(new KDPointImpl(1, 2));
		kdtree.insert(new KDPointImpl(5, 9));
		kdtree.insert(new KDPointImpl(4, 6));

		KDPoint nearest = kdtree.findNN(new KDPointImpl(10, 1));

		System.out.println("Nearest neighbor: " + Arrays.toString(nearest.getAsVector()));
		System.out.println("Distance: " + kdtree.getBestDist());
	}
}
