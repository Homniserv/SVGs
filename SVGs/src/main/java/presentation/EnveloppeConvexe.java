package presentation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * limits of the ensemble Of what system ?
 */
public class EnveloppeConvexe extends FigureI {
	Point nordOuest, sudEst;

	public List<Point> enveloppeConvexe() {
		List<Point> envelop = new ArrayList<Point>();

		return envelop;
	}

	public Point getNordOuest() {
		return nordOuest;
	}

	public void setNordOuest(Point nordOuest) {
		this.nordOuest = nordOuest;
	}

	public Point getSudEst() {
		return sudEst;
	}

	public void setSudEst(Point sudEst) {
		this.sudEst = sudEst;
	}
}
