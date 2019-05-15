package presentation;

import java.awt.Point;

public abstract class FigureI {
	Point nordOuest;

	Point sudEst;

	/** + = towards us */
	float layerZ;

	/** directed +/- */
	float width;

	/** directed +/- */
	float height;

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

	public float getLayerZ() {
		return layerZ;
	}

	public void setLayerZ(float layerZ) {
		this.layerZ = layerZ;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
