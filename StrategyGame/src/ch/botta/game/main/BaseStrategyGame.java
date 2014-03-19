package ch.botta.game.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import ch.botta.game.objects.PlayingField;
import ch.botta.game.screen.GraphicsDeviceBuilderUtil;

/**
 * 
 */

/**
 * @author U80751081
 *
 */
public abstract class BaseStrategyGame extends JFrame implements KeyListener, Runnable{

	
	private Thread gameLoop;
	private Graphics2D graphics2d;
	private int screenWidth;
	private int screenHeight;
	private Point2D mousePos;
	private boolean[] mouseButtons = new boolean[4];
	private int frameCount;
	private int frameRate;
	private int desiredFrameRate;
	private long startTime = System.nanoTime();
	private GraphicsDevice graphicsDevice; 
	PlayingField playingField = null;
	
	abstract void gameStartup();
	abstract void gameTimeUpdate();
	abstract void gameRefreshScreen();
	abstract void gameShutdown();
	abstract void gameKeyDown(int keyCode);
	abstract void gameKeyUp(int keyCode);
	
	public BaseStrategyGame(int desiredFrameRate, int screenWidth, int screenHeight){
		this.desiredFrameRate = desiredFrameRate;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		init();
	}
	
	private void init(){
		setDefaultCloseOperation(BaseStrategyGame.EXIT_ON_CLOSE);
		setSize(screenWidth, screenHeight);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		addKeyListener(this);
		gameStartup();
		setFullscreenMode();
	}
	
	/* RUNNABLE AREA */
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		
		while(currentThread == gameLoop){
			try {
				Thread.sleep(1000 / desiredFrameRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// FIXME
			//updatePlayingField();
			gameTimeUpdate();
			gameRefreshScreen();
		}	
	}
	
	public void start(){
		gameLoop = new Thread(this);
		gameLoop.start();
	}
	
	public void stop(){
		gameLoop = null;
		gameShutdown();
	}
	
	private void setFullscreenMode(){
		graphicsDevice = GraphicsDeviceBuilderUtil.getDefaultGraphicsDevice(this, 16, 60);
		createBufferStrategy(2);
	}
	
	public Graphics2D getGraphics2D(){
		return graphics2d;
	}
	
	public int getFrameRate() {
		return frameRate; 
	}
	
	public void paint(Graphics g){}
	
	protected double calcAngleMoveX(double angle) {
		return (double)(Math.cos(angle * Math.PI / 180));
	}
	
	protected double calcAngleMoveY(double angle) {
		return (double) (Math.sin(angle * Math.PI / 180));
	}

	/*KEYLISTENER AREA*/
	@Override
	public void keyPressed(KeyEvent k) {
		gameKeyDown(k.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent k) {
		gameKeyUp(k.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

}
