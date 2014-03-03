/**
 * 
 */
package ch.botta.game.screen;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * @author bottab
 *
 */
public class GraphicsDeviceBuilderUtil {

	public static GraphicsDevice getDefaultGraphicsDevice(Frame frame, int bitDepth, int frequency){
		DisplayMode displayMode = new DisplayMode(frame.getWidth(), frame.getHeight(), bitDepth, frequency);
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
		graphicsDevice.setFullScreenWindow(frame);
		graphicsDevice.setDisplayMode(displayMode);
		return graphicsDevice;
	}

}
