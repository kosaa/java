package algorithms.kdtree.impl;

import java.util.Arrays;

public class KDPointImpl implements KDPoint {

	private int[] vector;

	public KDPointImpl(int... x) {
		if (x.length < 1) {
			throw new RuntimeException("KD Point must contain at least one coordinate.");
		}

		vector = new int[x.length];
		System.arraycopy(x, 0, vector, 0, x.length);
	}

	@Override
	public int getAxisValue(int axis) {
		return vector[axis];
	}

	@Override
	public void setAxisValue(int axis, int value) {
		vector[axis] = value;
	}

	@Override
	public int[] getAsVector() {
		return vector.clone();
	}

	@Override
	public int getDimension() {
		return vector.length;
	}

	@Override
	public KDPointImpl clone() {
		return new KDPointImpl(vector.clone());
	}

	@Override
	public String toString() {
		return Arrays.toString(vector);
	}
}
