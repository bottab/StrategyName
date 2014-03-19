/**
 * 
 */
package ch.botta.game.options;

import java.awt.Dimension;

/**
 * @author bottab
 *
 */
public class ScreenOptions {

	private int hRes;
	private int vRes;
	private int nrOfHorizontalScreenPoints;
	private int nrOfVerticalScreenPoints;
	
	public ScreenOptions(int hRes, int vRes, Dimension hexagonDimension){
		this.hRes = hRes;
		this.vRes = vRes;
		this.nrOfHorizontalScreenPoints = hRes / (3 * (int)hexagonDimension.getWidth() / 4) + 2;
		this.nrOfVerticalScreenPoints = vRes / (int)hexagonDimension.getHeight() + 2;
	}

	/**
	 * @return the hRes
	 */
	public int gethRes() {
		return hRes;
	}

	/**
	 * @param hRes the hRes to set
	 */
	public void sethRes(int hRes) {
		this.hRes = hRes;
	}

	/**
	 * @return the vRes
	 */
	public int getvRes() {
		return vRes;
	}

	/**
	 * @param vRes the vRes to set
	 */
	public void setvRes(int vRes) {
		this.vRes = vRes;
	}

	/**
	 * @return the nrOfHorizontalScreenPoints
	 */
	public int getNrOfHorizontalScreenPoints() {
		return nrOfHorizontalScreenPoints;
	}

	/**
	 * @param nrOfHorizontalScreenPoints the nrOfHorizontalScreenPoints to set
	 */
	public void setNrOfHorizontalScreenPoints(int nrOfHorizontalScreenPoints) {
		this.nrOfHorizontalScreenPoints = nrOfHorizontalScreenPoints;
	}

	/**
	 * @return the nrOfVerticalScreenPoints
	 */
	public int getNrOfVerticalScreenPoints() {
		return nrOfVerticalScreenPoints;
	}

	/**
	 * @param nrOfVerticalScreenPoints the nrOfVerticalScreenPoints to set
	 */
	public void setNrOfVerticalScreenPoints(int nrOfVerticalScreenPoints) {
		this.nrOfVerticalScreenPoints = nrOfVerticalScreenPoints;
	}
	
}
