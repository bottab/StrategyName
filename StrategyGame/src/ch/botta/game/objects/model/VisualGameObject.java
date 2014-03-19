/**
 * 
 */
package ch.botta.game.objects.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ch.botta.game.objects.FieldPosition;


/**
 * @author bottab
 *
 */
public abstract class VisualGameObject extends GameObject{

	private BufferedImage bufferedImage;
	private String imageLocation;
	private FieldPosition fieldPosition;
	
	public VisualGameObject(FieldPosition fielPosition, String imageLocation){
		this.imageLocation = imageLocation;
		this.fieldPosition = fielPosition;
		if(imageLocation != null && imageLocation.length() > 0){
			setImage(imageLocation);
		}
	}

	public void setImage(String imageLocation) {
		try {
			this.bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void loadNewImage(String imageLocation){
		try {
			this.bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageLocation));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see ch.botta.game.objects.model.GameObject#getFieldPosition()
	 */
	@Override
	public FieldPosition getFieldPosition() {
		return fieldPosition;
	}

	/* (non-Javadoc)
	 * @see ch.botta.game.objects.model.GameObject#setFieldPosition(ch.botta.game.objects.FieldPosition)
	 */
	@Override
	public void setFieldPosition(FieldPosition fieldPosition) {
		this.fieldPosition = fieldPosition;
	}
	
}
