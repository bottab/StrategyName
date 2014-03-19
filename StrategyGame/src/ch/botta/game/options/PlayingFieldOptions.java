/**
 * 
 */
package ch.botta.game.options;

import java.awt.Dimension;

import ch.botta.game.objects.Hexagon;

/**
 * @author bottab
 *
 */
public class PlayingFieldOptions {


	private int nrOfHorizontalHexagons;
	private int nrOfVerticalHexagons;
	private Hexagon initHexagon;
	private Dimension hexagonDimension;
	
	public PlayingFieldOptions(int nrOfHorizontalHexagons, int nrOfVerticalHexagons, Hexagon initHexagon){
		this.nrOfHorizontalHexagons = nrOfHorizontalHexagons;
		this.nrOfVerticalHexagons = nrOfVerticalHexagons;
		this.initHexagon = initHexagon;
		setHexagonDimension();
	}

	/**
	 * @return the nrOfHorizontalHexagons
	 */
	public int getNrOfHorizontalHexagons() {
		return nrOfHorizontalHexagons;
	}

	/**
	 * @param nrOfHorizontalHexagons the nrOfHorizontalHexagons to set
	 */
	public void setNrOfHorizontalHexagons(int nrOfHorizontalHexagons) {
		this.nrOfHorizontalHexagons = nrOfHorizontalHexagons;
	}

	/**
	 * @return the nrOfVerticalHexagons
	 */
	public int getNrOfVerticalHexagons() {
		return nrOfVerticalHexagons;
	}

	/**
	 * @param nrOfVerticalHexagons the nrOfVerticalHexagons to set
	 */
	public void setNrOfVerticalHexagons(int nrOfVerticalHexagons) {
		this.nrOfVerticalHexagons = nrOfVerticalHexagons;
	}

	/**
	 * @return the hexagonDimension
	 */
	public Dimension getHexagonDimension() {
		return hexagonDimension;
	}

	/**
	 * @param hexagonDimension the hexagonDimension to set
	 */
	private void setHexagonDimension() {
		int width = initHexagon.getBufferedImage().getWidth();
		int height = initHexagon.getBufferedImage().getHeight();
		this.hexagonDimension = new Dimension(width, height);
	}

	/**
	 * @return the initHexagon
	 */
	public Hexagon getInitHexagon() {
		return initHexagon;
	}

	/**
	 * @param initHexagon the initHexagon to set
	 */
	public void setInitHexagon(Hexagon initHexagon) {
		this.initHexagon = initHexagon;
	}
	
}
