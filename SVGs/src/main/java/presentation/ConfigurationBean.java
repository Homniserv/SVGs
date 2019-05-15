package presentation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * limits of the ensemble Of what system ?
 * 
 * @Bean
 */
public class ConfigurationBean {
	// float interPerson = 20;
	float interPerson;
	/** X position of all pools **/
	float poolX;
	/** Y position of 1st pool **/
	float poolY;
	/** bottom A to top B */
	float interPool;
	float widthPool;
	float widthSheet;
	float heightSheet;
	float lineLength;
	int fontSize;

	/** from association start to name Ouest */
	float marginNameX;

	public float getMarginNameX() {
		return marginNameX;
	}

	public void setMarginNameX(float marginNameX) {
		this.marginNameX = marginNameX;
	}

	public float getPoolX() {
		return poolX;
	}

	public void setPoolX(float poolX) {
		this.poolX = poolX;
	}

	public float getPoolY() {
		return poolY;
	}

	public void setPoolY(float poolY) {
		this.poolY = poolY;
	}

	public float getPersonRelativePoolX() {
		return personRelativePoolX;
	}

	public void setPersonRelativePoolX(float personRelativePoolX) {
		this.personRelativePoolX = personRelativePoolX;
	}

	float personRelativePoolX;

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public float getInterPerson() {
		return interPerson;
	}

	public void setInterPerson(float interPerson) {
		this.interPerson = interPerson;
	}

	public float getInterPool() {
		return interPool;
	}

	public void setInterPool(float interPool) {
		this.interPool = interPool;
	}

	public float getWidthPool() {
		return widthPool;
	}

	public void setWidthPool(float widthPool) {
		this.widthPool = widthPool;
	}

	public float getWidthSheet() {
		return widthSheet;
	}

	public void setWidthSheet(float widthSheet) {
		this.widthSheet = widthSheet;
	}

	public float getHeightSheet() {
		return heightSheet;
	}

	public void setHeightSheet(float heightSheet) {
		this.heightSheet = heightSheet;
	}

	public float getLineLength() {
		return lineLength;
	}

	public void setLineLength(float lineLength) {
		this.lineLength = lineLength;
	}

}
