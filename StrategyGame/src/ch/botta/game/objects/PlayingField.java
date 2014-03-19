/**
 * 
 */
package ch.botta.game.objects;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import ch.botta.game.objects.model.GameObject.GameObjectType;
import ch.botta.game.options.PlayingFieldOptions;
import ch.botta.game.options.ScreenOptions;

/**
 * @author bottab
 *
 */
public class PlayingField {

	private PlayingFieldOptions playingFieldOptions;
	private Map<FieldPosition, Hexagon> playingFieldMap = new HashMap<FieldPosition, Hexagon>(); // the complete playing field
	private ScreenOptions screenOptions;
	private ScreenPoint[][] screenPoints;
	
	public enum PlayingFieldType{
		hexagonPlayingField, verticalHexagon, horizontalHexagon;
	}
	
	public PlayingField(PlayingFieldOptions playingFieldOptions, ScreenOptions screenOptions){
		this.playingFieldOptions = playingFieldOptions;
		this.screenOptions = screenOptions;
		this.screenPoints = new ScreenPoint[screenOptions.getNrOfHorizontalScreenPoints()][screenOptions.getNrOfVerticalScreenPoints()];
	}
	
	public void createPlayingField(){
		for(int vPos = 0; vPos<playingFieldOptions.getNrOfVerticalHexagons(); vPos++){
			for(int hPos = 0; hPos<playingFieldOptions.getNrOfHorizontalHexagons(); hPos++){
				FieldPosition fieldPosition = new FieldPosition(hPos, vPos, GameObjectType.hexagon.toString());
				Hexagon hexagon = new Hexagon(fieldPosition, "images/test1.png");
				playingFieldMap.put(fieldPosition, hexagon);
			}
		}
	}
	
	/**
	 * This initializes an array width the coordinates of the hexagon (its bounds) on the visible screen.
	 * This is initialized once the playing field has been created
	 */
	public void initScreenPoints(){
		int hexagonWidth = (int)playingFieldOptions.getHexagonDimension().getWidth();
		int hexagonHeight = (int)playingFieldOptions.getHexagonDimension().getHeight();
		int nrOfHorizontalScreenFields = screenOptions.getNrOfHorizontalScreenPoints();
		int nrOfVerticalScreenFields = screenOptions.getNrOfVerticalScreenPoints();
		
		Point initPoint = new Point(0,0);
		Point point = null;
		for(int colPos=0; colPos< nrOfVerticalScreenFields;colPos++){
			for(int rowPos=0; rowPos<nrOfHorizontalScreenFields; rowPos++){
				if(rowPos == 0 && colPos == 0){
					point = new Point(initPoint);
				}
				if(isOdd(rowPos)){
					point = new Point(point.x + 3 * hexagonWidth / 4, point.y + hexagonHeight / 2);
				}else{
					point = new Point(point.x + 3 * hexagonWidth / 4, point.y - hexagonHeight / 2);
				}
				FieldPosition fieldPosition = new FieldPosition(rowPos, colPos, GameObjectType.hexagon.toString());
				ScreenPoint screenPoint = new ScreenPoint(fieldPosition, point);
				this.screenPoints[rowPos][colPos] = screenPoint;
			}
			point = new Point(initPoint.x, initPoint.y + (colPos + 1) * hexagonHeight);
		}
	}
	
	/**
	 * This returns the new init FieldPosition for the reinitialization of the screen field position matrix (update)
	 * @param movementPoint
	 * @return FieldPosition
	 */
	public void updateScreenPoints(Point movementPoint){	
		int maxH = playingFieldOptions.getNrOfHorizontalHexagons();
		int maxV = playingFieldOptions.getNrOfVerticalHexagons();

		//FIXME: hier fehlt noch das abfangen, wenn Spielfeld überschritten wird
		for(int rowPos=0;rowPos<screenPoints.length;rowPos++){
			for(int colPos=0;colPos<screenPoints[rowPos].length;colPos++){
				FieldPosition fieldPosition = screenPoints[rowPos][colPos].getFieldPosition();
				FieldPosition newFieldPosition = new FieldPosition(fieldPosition.getPx() + movementPoint.x, fieldPosition.getPy() + movementPoint.y, GameObjectType.hexagon.toString());
				screenPoints[rowPos][colPos].setFieldPosition(newFieldPosition);
			}
		}
	}
	
	private boolean isOdd(int rowPos){
		if(rowPos % 2 == 1){
			return true;
		}
		return false;
	}

	/**
	 * @return the playingFieldMap
	 */
	public Map<FieldPosition, Hexagon> getPlayingFieldMap() {
		return playingFieldMap;
	}

	/**
	 * @param playingFieldMap the playingFieldMap to set
	 */
	public void setPlayingFieldMap(Map<FieldPosition, Hexagon> playingFieldMap) {
		this.playingFieldMap = playingFieldMap;
	}

	/**
	 * @return the screenPoints
	 */
	public ScreenPoint[][] getScreenPoints() {
		return screenPoints;
	}

	/**
	 * @param screenPoints the screenPoints to set
	 */
	public void setScreenPoints(ScreenPoint[][] screenPoints) {
		this.screenPoints = screenPoints;
	}
	
}
