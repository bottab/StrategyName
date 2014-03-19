/**
 * 
 */
package ch.botta.game.objects.model;

import ch.botta.game.objects.FieldPosition;
import ch.botta.game.sound.Soundplayer;

/**
 * @author bottab
 *
 */
public abstract class AudioVisualGameObject extends VisualGameObject {

	Soundplayer soundPlayer;
	
	public AudioVisualGameObject(FieldPosition fieldPosition, String imageLocation, String audioLocation) {
		super(fieldPosition, imageLocation);
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
