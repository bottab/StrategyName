/**
 * 
 */
package ch.botta.game.objects;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import ch.botta.game.objects.model.GameObject.GameObjectType;

/**
 * @author bottab
 *
 */
public class PlayingField {

	private int horizontalHexagons;
	private int verticalHexagons;
	private Point initPosition;
	private FieldPosition initFieldPosition;
	private Map<FieldPosition, Hexagon> hexagonMap = new HashMap<FieldPosition, Hexagon>();
	private int velocity;
	
	public enum PlayingFieldType{
		hexagonPlayingField, verticalHexagon, horizontalHexagon;
	}
	
	public PlayingField(int horizontalHexagons,int verticalHexagons, Point initPosition, int velocity){
		this.horizontalHexagons = horizontalHexagons;
		this.verticalHexagons = verticalHexagons;
		this.initPosition = initPosition;
		this.velocity = velocity;
		createPlayingField();
	}
	
	private void createPlayingField(){
		Hexagon hexagon = null;
		int hPos = 0;
		for(int verticalPosition = 0; verticalPosition<verticalHexagons; verticalPosition++){
			for(int horizontalPosition = 0; horizontalPosition<horizontalHexagons; horizontalPosition++){
				hPos = horizontalPosition + 1;
				// initial hexagon
				if(verticalPosition == 0 && horizontalPosition == 0){
					FieldPosition fieldPosition = new FieldPosition(verticalPosition, horizontalPosition, GameObjectType.hexagon.toString());
					setInitFieldPosition(fieldPosition);
					hexagon = createHexagon(this.initPosition, fieldPosition);
				}	
				hexagonMap.put(hexagon.getFieldPosition(), hexagon);
				hexagon = getNextHexagon(hexagon, PlayingFieldType.horizontalHexagon.toString(), hPos, verticalPosition);
			}
			hexagon = getNextHexagon(hexagon, PlayingFieldType.verticalHexagon.toString(), hPos, verticalPosition + 1);
		}
	}

	private Hexagon getNextHexagon(Hexagon hexagon, String playingFieldType, int hPos, int vPos) {
		Hexagon resultingHexagon = hexagon.cloneHexagon();
		FieldPosition fieldPosition = new FieldPosition(hPos - 1, vPos, GameObjectType.hexagon.toString());
		resultingHexagon.setFieldPosition(fieldPosition);
		int width = hexagon.getBounds().width;
		int height = hexagon.getBounds().height;

		if(playingFieldType.equals(PlayingFieldType.horizontalHexagon.toString())){
			if(isOdd(hPos)){
				resultingHexagon.setBounds(new Rectangle(hexagon.getBounds().x + 3 * width / 4, hexagon.getBounds().y + height / 2, width, height));
			}else{
				resultingHexagon.setBounds(new Rectangle(hexagon.getBounds().x + 3 * width / 4, hexagon.getBounds().y - height / 2, width, height));
			}
		}
		else if(playingFieldType.equals(PlayingFieldType.verticalHexagon.toString())){
			resultingHexagon.setBounds(new Rectangle(initPosition.x, initPosition.y + vPos * height, width, height));
		}

		return resultingHexagon;
	}
	
	private boolean isOdd(int horizontalPosition){
		if(horizontalPosition % 2 == 1){
			return true;
		}
		return false;
	}

	private Hexagon createHexagon(Point position, FieldPosition fieldPosition) {
		Hexagon hexagon = new Hexagon(position, this.velocity, "images/test1.png");
		hexagon.setFieldPosition(fieldPosition);
		return hexagon;
	}

	public Map<FieldPosition, Hexagon> getHexagonMap() {
		return hexagonMap;
	}

	public void setHexagonMap(Map<FieldPosition, Hexagon> hexagonMap) {
		this.hexagonMap = hexagonMap;
	}

	/**
	 * @return the horizontalHexagons
	 */
	public int getHorizontalHexagons() {
		return horizontalHexagons;
	}

	/**
	 * @param horizontalHexagons the horizontalHexagons to set
	 */
	public void setHorizontalHexagons(int horizontalHexagons) {
		this.horizontalHexagons = horizontalHexagons;
	}

	/**
	 * @return the verticalHexagons
	 */
	public int getVerticalHexagons() {
		return verticalHexagons;
	}

	/**
	 * @param verticalHexagons the verticalHexagons to set
	 */
	public void setVerticalHexagons(int verticalHexagons) {
		this.verticalHexagons = verticalHexagons;
	}

	/**
	 * @return the initFieldPosition
	 */
	public FieldPosition getInitFieldPosition() {
		return initFieldPosition;
	}

	/**
	 * @param initFieldPosition the initFieldPosition to set
	 */
	public void setInitFieldPosition(FieldPosition initFieldPosition) {
		this.initFieldPosition = initFieldPosition;
	}

	/**
	 * @return the velocity
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	
}
