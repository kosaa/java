package other.beziercurve.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BezierCurve {

	public List<Point> getCurvePoints(final double t, List<Point> controlPoints) {
		validT(t);
		validPoints(controlPoints);

		List<Point> pointList = createCurvePoints(t, controlPoints);

		return mergeEqualNeighbors(pointList);
	}

	private void validT(double t) {
		if (t <= 0 || t >= 1) {
			throw new RuntimeException("T must be in (0,1) range.");
		}
	}

	private void validPoints(List<Point> controlPoints) {
		if (controlPoints.size() < 3) {
			throw new RuntimeException("Polynominal must be at least a second degree.");
		}
	}

	private List<Point> createCurvePoints(final double t, List<Point> controlPoints) {
		List<Point> curvePoints = new ArrayList<>();
		curvePoints.add(controlPoints.get(0));

		for (double i = t; i < 1; i = i + t) {
			curvePoints.add(getPoint(i, controlPoints));
		}

		curvePoints.add(controlPoints.get(controlPoints.size() - 1));

		return curvePoints;
	}

	private Point getPoint(final double percent, List<Point> parr) {
		if (parr.size() == 2) {
			return getPercentagePoint(percent, parr.get(0), parr.get(1));
		}

		List<Point> pointsList = new ArrayList<>();
		for (int i = 1; i < parr.size(); ++i) {
			pointsList.add(getPercentagePoint(percent, parr.get(i - 1), parr.get(i)));
		}

		return getPoint(percent, pointsList);
	}

	private Point getPercentagePoint(final double percent, Point a, Point b) {
		int x = (int) ((1 - percent) * a.getX() + percent * b.getX());
		int y = (int) ((1 - percent) * a.getY() + percent * b.getY());

		return new Point(x, y);
	}

	private List<Point> mergeEqualNeighbors(List<Point> curvePoints) {
		List<Point> merged = new ArrayList<>();
		merged.add(curvePoints.get(0));

		for (int i = 1; i < curvePoints.size(); ++i) {
			if (!curvePoints.get(i).equals(curvePoints.get(i - 1))) {
				merged.add(curvePoints.get(i));
			}
		}

		return merged;
	}
}
