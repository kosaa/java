package algorithms.kdtree.impl;

public interface KDPoint extends Cloneable {

	int getAxisValue(int axis);

	void setAxisValue(int axis, int value);

	KDPoint clone();

	int[] getAsVector();

	int getDimension();
}
