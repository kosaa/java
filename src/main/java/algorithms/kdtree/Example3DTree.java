package algorithms.kdtree;

import algorithms.kdtree.impl.KDPoint;
import algorithms.kdtree.impl.KDPointImpl;
import algorithms.kdtree.impl.KDTree;
import java.util.Arrays;

public class Example3DTree {

	public static void main(String[] args) throws CloneNotSupportedException {
		KDTree kdtree = KDTree.ofDimension(3);

		kdtree.insert(new KDPointImpl(5, 4, 9));
		kdtree.insert(new KDPointImpl(9, 6, 1));
		kdtree.insert(new KDPointImpl(4, 7, 2));
		kdtree.insert(new KDPointImpl(9, 2, 0));
		kdtree.insert(new KDPointImpl(7, 2, 4));

		KDPoint nearest = kdtree.findNN(new KDPointImpl(10, 1, 0));

		System.out.println("Nearest neighbor: " + Arrays.toString(nearest.getAsVector()));
		System.out.println("Distance: " + kdtree.getBestDist());
	}
}
