/**
 * 
 */
package ch.botta.game.objects;


/**
 * @author bottab
 *
 */
public class FieldPosition {

	private int px;
	private int py;
	private String gameObjectType;
	
	public FieldPosition(FieldPosition fieldPosition){
		this.px = fieldPosition.px;
		this.py = fieldPosition.py;
		this.gameObjectType = fieldPosition.gameObjectType;
	}
	
	public FieldPosition(int px, int py, String gameObjectType){
		super();
		this.px = px;
		this.py = py;
		this.setGameObjectType(gameObjectType);
	}
	
	@Override
	public boolean equals(Object o){
		FieldPosition fieldPosition = (FieldPosition) o;
		if(fieldPosition.px == this.px && fieldPosition.py == this.py){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public String toString(){
		return this.gameObjectType + "(" + String.valueOf(this.px) + "," + String.valueOf(this.py) + ")";
	}
	
	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	/**
	 * @return the gameObjectType
	 */
	public String getGameObjectType() {
		return gameObjectType;
	}

	/**
	 * @param gameObjectType the gameObjectType to set
	 */
	public void setGameObjectType(String gameObjectType) {
		this.gameObjectType = gameObjectType;
	}
	
}
