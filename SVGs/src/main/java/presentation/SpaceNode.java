package presentation;

import java.awt.Point;

/** coordonnees autour du Match */
public class SpaceNode {
	Point from;
	Point to;

	public Point milieuGet() {
		Point mil = new Point(to.x - from.x, to.y - from.y);
		return mil;
	};
}
