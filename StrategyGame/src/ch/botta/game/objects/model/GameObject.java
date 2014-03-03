/**
 * 
 */
package ch.botta.game.objects.model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
	
	public abstract Rectangle getBounds();
	public abstract void setBounds(Rectangle rectangle);
	public abstract int getVelocity();
}
