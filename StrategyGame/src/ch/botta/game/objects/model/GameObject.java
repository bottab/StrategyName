/**
 * 
 */
package ch.botta.game.objects.model;

import ch.botta.game.objects.FieldPosition;

/**
 * @author bottab
 *
 */
public abstract class GameObject {

	public enum GameObjectType{
		background, hexagonPlayingField, hexagon;
	}
	
	public GameObject(){
		super();
	}
	
	public abstract void updateObject();
	public abstract FieldPosition getFieldPosition();
	public abstract void setFieldPosition(FieldPosition fieldPosition);
}
