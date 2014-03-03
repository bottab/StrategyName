/**
 * 
 */
package ch.botta.game.objects.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author bottab
 *
 */
public abstract class VisualGameObject extends GameObject{

	private BufferedImage bufferedImage;
	private int velocity;
	private String imageLocation;
	private Rectangle bounds;
	
	public VisualGameObject(Point position, int velocity, String imageLocation){
		this.velocity = velocity;
		this.imageLocation = imageLocation;
		if(imageLocation != null && imageLocation.length() > 0){
			setImage(imageLocation, position);
		}
	}

	public void setImage(String imageLocation, Point position) {
		try {
			this.bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageLocation));
			this.bounds = new Rectangle(position.x, position.y, this.bufferedImage.getWidth(), this.bufferedImage.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the velocity
	 */
	@Override
	public int getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the imageLocation
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * @param imageLocation the imageLocation to set
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	/**
	 * @return the bufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	/**
	 * @param bufferedImage the bufferedImage to set
	 */
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	/**
	 * @return the bounding
	 */
	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * @param bounding the bounding to set
	 */
	@Override
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public void loadNewImage(String imageLocation){
		try {
			this.bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageLocation));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
