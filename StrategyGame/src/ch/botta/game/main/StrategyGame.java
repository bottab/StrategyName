/**
 * 
 */
package ch.botta.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Map;
import java.util.Map.Entry;

import ch.botta.game.objects.Hexagon;
import ch.botta.game.objects.PlayingField;
import ch.botta.game.objects.FieldPosition;
import ch.botta.game.objects.PlayingFieldOnScreen;
import ch.botta.game.objects.model.GameObject.GameObjectType;

/**
 * 
 */

/**
 * @author U80751081
 *
 */
public class StrategyGame extends BaseStrategyGame{
	
	boolean keyLeft, keyRight, keyUp, keyDown;
	private int translateX;
	private int translateY;
	PlayingField playingField = null;
	PlayingFieldOnScreen playingFieldOnScreen = null;
	
	public StrategyGame(int desiredFrameRate, int screenWidth, int screenHeight){
		super(desiredFrameRate, screenWidth, screenHeight);
		gameStartup();
	}
	
	@Override
	void gameStartup() {
		playingField = new PlayingField(50, 50, new Point(0,0), 100); 
		Map<FieldPosition, Hexagon> hexagonMap = playingField.getHexagonMap();
		playingFieldOnScreen = new PlayingFieldOnScreen(hexagonMap.get(new FieldPosition(0, 0, GameObjectType.hexagon.toString())), 1600, 900);
		playingFieldOnScreen.initializeFieldPositionMatrix(hexagonMap);
	}
	
	public void gameTimeUpdate() {
		checkInput();
	}
	
	public void checkInput() {
		if (keyLeft) {
			translateX = translateX - 10;
		}
		if (keyRight) {
			translateX = translateX + 10;
		}
		if (keyUp) {
			translateY = translateY - 10;
		}
		if (keyDown) {
			translateY = translateY + 10;
		}	
	}
	
	@Override
	public void gameRefreshScreen() {
			repaintPlayingField();
	}
	
	private void repaintPlayingField(){
		Graphics2D graphics2D = (Graphics2D) getBufferStrategy().getDrawGraphics();
		graphics2D.setPaint(Color.black);
		graphics2D.fillRect(0, 0, 1600, 900);
		
		FieldPosition[][] fieldPositionMatrix = playingFieldOnScreen.getFieldPositionMatrix();
		for(int i=0;i<playingFieldOnScreen.getNrOfRows();i++){
			for(int j=0; j< playingFieldOnScreen.getNrOfCols(); j++){
				Hexagon hexagon = playingField.getHexagonMap().get(fieldPositionMatrix[i][j]);
				AffineTransform affineTransform = new AffineTransform();
				affineTransform.translate(hexagon.getBounds().getX() + translateX, hexagon.getBounds().getY() + translateY);
				graphics2D.drawImage(hexagon.getBufferedImage(), affineTransform, null);
			}
		}
		
		graphics2D.dispose();
		getBufferStrategy().show();
		Toolkit.getDefaultToolkit().sync();
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

