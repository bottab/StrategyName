package ch.botta.game.objects;

import java.awt.Point;
import java.awt.Polygon;

/**
 * 
 */


import ch.botta.game.objects.model.VisualGameObject;

/**
 * @author bottab
 *
 */
/**
 * @author bottab
 *
 */
public class Hexagon extends VisualGameObject{

	private Polygon polygon;
	private FieldPosition fieldPosition;
	private final int nPoints = 6;
		
	public Hexagon(Point point, int velocity, String imageLocation){
		super(point, velocity, imageLocation);
	}
	
	public Polygon calculatePolygon() {
		int[] yPoints = new int[nPoints];
		int[] xPoints = new int[nPoints];
		xPoints[0] = getBounds().x + getBounds().width / 4;
		xPoints[1] = getBounds().x + 3 * getBounds().width / 4;
		xPoints[2] = getBounds().x + getBounds().width;
		xPoints[3] = getBounds().x + 3 * getBounds().width / 4;
		xPoints[4] = getBounds().x + getBounds().width / 4;
		xPoints[5] = getBounds().x;
		yPoints[0] = getBounds().y;
		yPoints[1] = getBounds().y;
		yPoints[2] = getBounds().y + getBounds().height / 2;
		yPoints[3] = getBounds().y +  getBounds().height;
		yPoints[4] = getBounds().y +  getBounds().height;
		yPoints[5] = getBounds().y + getBounds().height / 2;
		Polygon polygon = new Polygon(xPoints, yPoints, nPoints);
		return polygon;
	}
	
	public Hexagon cloneHexagon(){
		Hexagon newHexagon = new Hexagon(new Point(getBounds().x, getBounds().y), super.getVelocity(), null);
		newHexagon.setPolygon(polygon);
		newHexagon.setBufferedImage(getBufferedImage());
		newHexagon.setFieldPosition(this.fieldPosition);
		return newHexagon;
	}

	public void updateObject() {
//		Controler controler = (Controler) GameContext.getInstance().getGameObjectContextMap().get(GameContextObjectType.controler.toString());
//		if(controler instanceof KeyBoard){
//			KeyBoard keyBoard = (KeyBoard) controler;
//			keyBoard.updateHexagon(this);
//		}
	}

	/**
	 * @return the polygon
	 */
	public Polygon getPolygon() {
		return polygon;
	}

	/**
	 * @param polygon the polygon to set
	 */
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}

	/**
	 * @return the fieldPosition
	 */
	public FieldPosition getFieldPosition() {
		return fieldPosition;
	}

	/**
	 * @param fieldPosition the fieldPosition to set
	 */
	public void setFieldPosition(FieldPosition fieldPosition) {
		this.fieldPosition = fieldPosition;
	}



}
