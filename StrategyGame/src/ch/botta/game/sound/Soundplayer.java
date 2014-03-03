/**
 * 
 */
package ch.botta.game.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * @author bottab
 *
 */
public class Soundplayer {

	private Clip clip;
	private FloatControl volume;
	
	public Soundplayer(String path){
		AudioInputStream audioInputStream;
		
		try {
			audioInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(path));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void play(){
		clip.setMicrosecondPosition(0);
		clip.start();
	}
	
	public void loop(){
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}
	
	public void setVolume(float value){
		volume.setValue(value);
	}
	
}
