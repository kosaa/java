package algorithms.kdtree.impl;

public class KDTree {

	private KDNode root;

	private KDPoint best;

	private double best_dist = Integer.MAX_VALUE;

	private final int K;

	public static KDTree ofDimension(int k) {
		return new KDTree(k);
	}

	private KDTree(int k) {
		if (k < 1) {
			throw new RuntimeException("Dimension must be greater or equals to one.");
		}

		this.K = k;
	}

	public int getDimension() {
		return K;
	}

	public void clear() {
		root = null;
		best = null;
		best_dist = Integer.MAX_VALUE;
	}

	public void insert(KDPoint p) {
		validPoint(p);
		root = insert(root, p, 0);
	}

	private void validPoint(KDPoint p) {
		if (p.getDimension() != K) {
			throw new RuntimeException("Incorrect point dimension.");
		}
	}

	public KDPoint findNN(KDPoint p) {
		validPoint(p);
		best = null;
		best_dist = Integer.MAX_VALUE;

		findNN(p, root, 0);

		return best;
	}

	private KDNode insert(KDNode root, KDPoint p, int axis) {
		if (root == null) {
			return new KDNode(p);
		}

		axis = axis % K;

		if (p.getAxisValue(axis) < root.getLocation().getAxisValue(axis)) {
			root.setLeft(insert(root.getLeft(), p, axis + 1));
		} else {
			root.setRight(insert(root.getRight(), p, axis + 1));
		}

		return root;
	}

	private void findNN(KDPoint p, KDNode root, int axis) {
		if (root == null) {
			return;
		}

		axis = axis % K;
		double dist = getDist(p, root.getLocation());

		if (dist < best_dist) {
			best = root.getLocation();
			best_dist = dist;
		}

		if (p.getAxisValue(axis) < root.getLocation().getAxisValue(axis)) {
			findNN(p, root.getLeft(), axis + 1);
			if (getDist(p, getLineClosestPoint(p, root.getLocation(), axis + 1)) <= best_dist) {
				findNN(p, root.getRight(), axis + 1);
			}
		} else {
			findNN(p, root.getRight(), axis + 1);
			if (getDist(p, getLineClosestPoint(p, root.getLocation(), axis + 1)) <= best_dist) {
				findNN(p, root.getLeft(), axis + 1);
			}
		}
	}

	private KDPoint getLineClosestPoint(KDPoint p, KDPoint rootloc, int axis) {
		axis = axis % K;
		KDPoint newPoint = rootloc.clone();
		newPoint.setAxisValue(axis, p.getAxisValue(axis));
		return newPoint;
	}

	public double getDist(KDPoint p1, KDPoint p2) {
		validPoint(p1);
		validPoint(p2);
		double sum = 0;

		for (int i = 0; i < K; ++i) {
			sum += Math.pow(p1.getAxisValue(i) - p2.getAxisValue(i), 2);
		}

		return Math.sqrt(sum);
	}

	public double getBestDist() {
		return best_dist;
	}
}
