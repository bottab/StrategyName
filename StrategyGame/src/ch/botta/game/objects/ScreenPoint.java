/**
 * 
 */
package ch.botta.game.objects;

import java.awt.Point;

/**
 * @author bottab
 *
 */
public class ScreenPoint {

	private FieldPosition fieldPosition;
	private Point screenPoint;
	
	public ScreenPoint(FieldPosition fieldPosition, Point screenPoint){
		this.fieldPosition = fieldPosition;
		this.screenPoint = screenPoint;
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

	/**
	 * @return the screenPoint
	 */
	public Point getScreenPoint() {
		return screenPoint;
	}

	/**
	 * @param screenPoint the screenPoint to set
	 */
	public void setScreenPoint(Point screenPoint) {
		this.screenPoint = screenPoint;
	}
	
}
