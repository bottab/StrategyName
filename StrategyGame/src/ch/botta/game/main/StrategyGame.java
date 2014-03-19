/**
 * 
 */
package ch.botta.game.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import ch.botta.game.objects.FieldPosition;
import ch.botta.game.objects.Hexagon;
import ch.botta.game.objects.PlayingField;
import ch.botta.game.objects.ScreenPoint;
import ch.botta.game.objects.model.GameObject.GameObjectType;
import ch.botta.game.options.PlayingFieldOptions;
import ch.botta.game.options.ScreenOptions;

/**
 * 
 */

/**
 * @author U80751081
 *
 */
public class StrategyGame extends BaseStrategyGame{
	
	boolean keyLeft, keyRight, keyUp, keyDown, initPlayingField = true;
	
	public StrategyGame(int desiredFrameRate, int screenWidth, int screenHeight){
		super(desiredFrameRate, screenWidth, screenHeight);
	}
	
	@Override
	void gameStartup() {
		// init playingfield (for 1600*900 and 84 width, height = 27,12, sonst Fehlermeldung)
		Hexagon initHexagon = new Hexagon(new FieldPosition(0, 0, GameObjectType.hexagon.toString()), "images/test1.png");
		PlayingFieldOptions playingFieldOptions = new PlayingFieldOptions(40, 30, initHexagon);
		ScreenOptions screenOptions = new ScreenOptions(1600, 900, playingFieldOptions.getHexagonDimension());
		playingField = new PlayingField(playingFieldOptions, screenOptions); 
		playingField.createPlayingField();
		playingField.initScreenPoints();
	}
	
	public void gameTimeUpdate() {
		checkInput();
	}
	
	public void checkInput() {
	
	}
	
	@Override
	public void gameRefreshScreen() {
			repaintPlayingField();
	}
	
	private void repaintPlayingField(){
			Graphics2D graphics2D = (Graphics2D) getBufferStrategy().getDrawGraphics();
			graphics2D.setPaint(Color.black);
			graphics2D.fillRect(0, 0, 1600, 900);
	
			Point movementPoint = getMovementPointForPlayingScreen();
			playingField.updateScreenPoints(movementPoint);
			
			ScreenPoint[][] screenPoints = playingField.getScreenPoints();
			for(int i=0;i<screenPoints.length;i++){
				for(int j=0; j< screenPoints[i].length; j++){
					Hexagon hexagon = playingField.getPlayingFieldMap().get(screenPoints[i][j].getFieldPosition());
					int px = screenPoints[i][j].getScreenPoint().x;
					int py = screenPoints[i][j].getScreenPoint().y;
					graphics2D.drawImage(hexagon.getBufferedImage(),px, py, null);
					graphics2D.drawString(screenPoints[i][j].getFieldPosition().toString(), px, py);
				}
			}
			
			graphics2D.dispose();
			getBufferStrategy().show();
			Toolkit.getDefaultToolkit().sync();
			initPlayingField = false;
	}
	
	private Point getMovementPointForPlayingScreen(){
		int verticalMovement = 0;
		int horizontalMovement = 0;
		horizontalMovement += horizontalMovement = keyLeft?-1:0;
		horizontalMovement += horizontalMovement = keyRight?1:0;
		verticalMovement += verticalMovement = keyDown?-1:0;
		verticalMovement += verticalMovement = keyUp?1:0;
		Point movementPoint = new Point(horizontalMovement, verticalMovement);
		return movementPoint;
	}
	
	public void gameKeyDown(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
			case KeyEvent.VK_ESCAPE: System.exit(0); break;
		}
	}
	
	public void gameKeyUp(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
		}
	}
	
	@Override
	void gameShutdown() {
		//oh well, let the garbage collector have at it..
	}

	
}

