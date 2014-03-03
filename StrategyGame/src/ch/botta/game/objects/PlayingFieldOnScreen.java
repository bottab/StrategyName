/**
 * 
 */
package ch.botta.game.objects;

import java.util.List;
import java.util.Map;

import ch.botta.game.objects.model.GameObject.GameObjectType;

/**
 * @author bottab
 *
 */
public class PlayingFieldOnScreen {

	private FieldPosition[][] fieldPositionMatrix;
	
	private int nrOfRows;
	private int nrOfCols;
	
	public PlayingFieldOnScreen(Hexagon hexagon, int screenWidth, int screenHeight){
		super();
		this.nrOfRows = (screenWidth / (hexagon.getBounds().width * 3 / 4)) + 2;
		this.nrOfCols = (screenHeight / hexagon.getBounds().height) + 2;
		fieldPositionMatrix = new FieldPosition[nrOfRows][nrOfCols];
	}
	
	public void initializeFieldPositionMatrix(Map<FieldPosition, Hexagon> hexagonMap){
		for(int i=0; i<nrOfRows;i++){
			for(int j=0;j<nrOfCols;j++){
				FieldPosition fp = new FieldPosition(i, j, GameObjectType.hexagon.toString());
				fieldPositionMatrix[i][j] = hexagonMap.get(fp).getFieldPosition();
			}
		}
	}

	public FieldPosition[][] getFieldPositionMatrix() {
		return fieldPositionMatrix;
	}

	public void setFieldPositionMatrix(FieldPosition[][] fieldPositionMatrix) {
		this.fieldPositionMatrix = fieldPositionMatrix;
	}

	public int getNrOfRows() {
		return nrOfRows;
	}

	public void setNrOfRows(int nrOfRows) {
		this.nrOfRows = nrOfRows;
	}

	public int getNrOfCols() {
		return nrOfCols;
	}

	public void setNrOfCols(int nrOfCols) {
		this.nrOfCols = nrOfCols;
	}
	
	
}
