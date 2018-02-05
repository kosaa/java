package other.beziercurve;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import other.beziercurve.impl.BezierCurve;

public class Example {
	public static void main(String[] args) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(10,10));
		points.add(new Point(10,50));
		points.add(new Point(50,50));
		points.add(new Point(50,10));

		BezierCurve bc = new BezierCurve();
		System.out.println(bc.getCurvePoints(0.1, points));
	}
}
