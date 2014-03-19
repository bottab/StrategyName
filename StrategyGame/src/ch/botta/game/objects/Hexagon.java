package ch.botta.game.objects;

import java.awt.Dimension;
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
		
	public Hexagon(FieldPosition fieldPosition, String imageLocation){
		super(fieldPosition, imageLocation);
	}
	
	public Polygon calculatePolygon(Point point, Dimension hexagonDimension) {
		int[] yPoints = new int[nPoints];
		int[] xPoints = new int[nPoints];
		xPoints[0] = point.x + (int)hexagonDimension.getWidth() / 4;
		xPoints[1] = point.x + 3 * (int)hexagonDimension.getWidth() / 4;
		xPoints[2] = point.x + (int)hexagonDimension.getWidth();
		xPoints[3] = point.x + 3 * (int)hexagonDimension.getWidth() / 4;
		xPoints[4] = point.x + (int)hexagonDimension.getWidth() / 4;
		xPoints[5] = point.x;
		yPoints[0] = point.y;
		yPoints[1] = point.x;
		yPoints[2] = point.x + (int)hexagonDimension.getHeight() / 2;
		yPoints[3] = point.x +  (int)hexagonDimension.getHeight();
		yPoints[4] = point.x +  (int)hexagonDimension.getHeight();
		yPoints[5] = point.x + (int)hexagonDimension.getHeight() / 2;
		Polygon polygon = new Polygon(xPoints, yPoints, nPoints);
		return polygon;
	}
	
	public Hexagon cloneHexagon(){
		Hexagon newHexagon = new Hexagon(new FieldPosition(fieldPosition), null);
		newHexagon.setPolygon(polygon);
		newHexagon.setBufferedImage(getBufferedImage());
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

}
