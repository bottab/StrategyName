/**
 * 
 */
package ch.botta.game.objects.model;

import java.awt.Point;

import ch.botta.game.sound.Soundplayer;

/**
 * @author bottab
 *
 */
public abstract class AudioVisualGameObject extends VisualGameObject {

	Soundplayer soundPlayer;
	
	public AudioVisualGameObject(Point position, int velocity, String imageLocation, String audioLocation) {
		super(position, velocity, imageLocation);
		if(audioLocation != null && audioLocation.length() > 0){
				setSound(audioLocation);
		}
	}
	
	public void setSound(String audioLocation) {
		if(audioLocation != null && audioLocation.length() > 0){
			setSoundPlayer(new Soundplayer(audioLocation));
		}
	}

	/**
	 * @return the soundPlayer
	 */
	public Soundplayer getSoundPlayer() {
		return soundPlayer;
	}

	/**
	 * @param soundPlayer the soundPlayer to set
	 */
	public void setSoundPlayer(Soundplayer soundPlayer) {
		this.soundPlayer = soundPlayer;
	}
		
}
