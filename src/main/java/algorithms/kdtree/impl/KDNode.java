package algorithms.kdtree.impl;

public class KDNode {

	private KDPoint point;

	private KDNode left;

	private KDNode right;

	public KDNode(KDPoint p) {
		this.point = p;
	}

	public KDPoint getLocation() {
		return point;
	}

	public KDNode getLeft() {
		return left;
	}

	public void setLeft(KDNode kdnode) {
		this.left = kdnode;
	}

	public KDNode getRight() {
		return right;
	}

	public void setRight(KDNode kdnode) {
		this.right = kdnode;
	}
}
