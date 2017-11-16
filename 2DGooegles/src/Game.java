/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: The main body of the game.
 -----------------------------*/

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
	//Starts the default scene.
	public static DefaultScene defaultScene;
	
	//Gets a serial number needed for runnable, a thread, running, and a list of scenes.
	private static final long serialVersionUID = 3250395314564311755L;
	
	private Thread thread; //The thread for running the game.
	public static Graphics2D g; //Graphic library.
	
	public static Camera camera; // Camera class
	
	private boolean running = false; //Decides if game is still running
	public static Window window; //JFRAME.
	
	public static int height; //Jframe height.
	public static int width; //Jframe width.
	
	public static SceneManager SceneManager; //Manages when each scene comes.
	public static Input input; //Input class.
	
	public static MusicPlayer musicPlayer; //Music player.
	public static CollisionMap collide; //Collision map detector.
	
	public double FPS = 60.0; //FRAMES PER SECOND.
	public static int frames;

	//Our game constructor. When a new game is created creates Jframe.
	//Initializes all variables/objects
	public Game(int width, int height, String name)
	{
		
		Game.height = height;
		Game.width = width;
		window = new Window(width, height, name, this);
		SceneManager = new SceneManager();
		
		

		musicPlayer = new MusicPlayer();
		input = new Input();
		addKeyListener(input);
		collide = new CollisionMap();
		camera = new Camera();
		Camera.ready = true;
		
		new Header();
		window.window.setVisible(true);
		//Starts game....
		
		defaultScene = new DefaultScene();
		defaultScene.make();
		Game.SceneManager.currentScene = DefaultScene.DScene;
		
		start();
	}
	
	//Breaks the initial synchronized method.
	public void Initialize()
	{
		
	}
	
	//synchronized guarantees all actions on that object happen in set orders.
	//Begin our thread and start it, create a boolean running.
	public synchronized void start()
	{
		Initialize();
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	//Destroys our thread. Running is false.
	public synchronized void stop()
	{
		try{
			//Kills the thread.
			thread.join();
			running = false;
			//Prints errors that kills the thread.
		}catch(Exception error){
			error.printStackTrace();
		}
		
	}
	
	//Part of Runnable. Will run as soon as game starts.
	public void run()
	{
		//Math to get ticks updating at 60FPS.
		int CPS = 0;
		long lastTime = System.nanoTime();
		double nanosec = 1000000000 / FPS;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		Game.frames = 0;
		
		//Game loop:
		while(running)
		{
			long current = System.nanoTime();
			delta += (current - lastTime) / nanosec;
			lastTime = current;
			
			//updates every frame. at an indetermined rate, sometimes influenced
			//by computer.
			while(delta >= 1)
			{
				frames++;
				render();
				update();
				delta--;
			}
			
			//updates every CPS.
			if(running)
				CPS++;
			
			//Updates every full FPS cycle. At a fixed rate.
			if(System.currentTimeMillis() - timer > 1000)
			{
				//FOR TESTING CYCLES SPEED / FPS.
				System.out.println("CPS: " + CPS + " FPS: " + frames);
				Game.frames = 0;
				CPS = 0;
				timer += 1000;
			}
		}
		stop();
	}
	
	//Update method to be used by sub classes. UPDATES EVERY FRAME.
	public void update()
	{
		if(SceneManager.currentScene != null)
			SceneManager.currentScene.controller.update(input);
		input.flush();
	}
	
	//Render method that UPDATES EVERY CYCLE. Good for sprites.
	public void render()
	{	
		
		//----------------------------------------
		// Create BuffereStrategy
		//----------------------------------------
		BufferStrategy buffer = getBufferStrategy();
		if(buffer == null){
			createBufferStrategy(3);
			return;
		}
		
		//Graphic is drawn.
		g = (Graphics2D) buffer.getDrawGraphics();
		
		//Scales the graphic to fit the window.
		g.scale((double)Window.window.getContentPane().getWidth() / Game.width,
				(double)Window.window.getContentPane().getHeight() / Game.height);
		
		//Sets background color.
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		
		//Translates the entire canvas X/Y coordinates to camera.
		//All children will be drawn.
		if(Camera.ready == true)
			g.translate(camera.x, camera.y);
		
		//All scenes will begin to render.
		if(SceneManager != null && g != null)
			SceneManager.render(g);
		
		if(SceneManager.currentScene != null)
			SceneManager.currentScene.controller.render(g, input);
		
		//Places those coordinates back to an abstract origin.
		//Stops translates from getting out-of-hand.
		if(Camera.ready == true)
			g.translate(-camera.x, -camera.y);
		
		//Dispose every update.
		g.dispose();
		//Shows next g
		buffer.show();
	}
	
	
	public double getFPS()
	{
		return FPS;
	}
	
	public void setFPS(double fps)
	{
		FPS = fps;
	}
	
	
	//Library constructor for testing...
	public static void main(String[] args) {
		
		new Game(1000, 1000, "game");
		
	}

}
