package presentation;

import java.awt.Point;

/** coordonnees autour du pseudo */
public class SpaceLine {
	Point from;
	Point to;
	String label;

	float longueur;
	float largeur;
	 TraitNature traitNature;
	public Point getFrom() {
		return from;
	}

	public void setFrom(Point from) {
		this.from = from;
	}

	public Point getTo() {
		return to;
	}

	public void setTo(Point to) {
		this.to = to;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Point milieuGet() {
		Point mil = new Point(to.x - from.x, to.y - from.y);
		return mil;
	};
}
