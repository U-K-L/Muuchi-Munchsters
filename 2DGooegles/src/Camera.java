/*
 * Authors: Noah Williams
 * 
 * Last Updated: 10/15/2017
 * Date: 10/15/2017
 * 
 * Purpose: Positions the camera by translating Graphics g to X
 * Y coordinate
 */
public class Camera {
	
	public int x = 0; //Camera X position
	public int y = 0; //Camera Y position
	public int width; //Camera rect width.
	public int height; //Camera rect height.
	public int x_boundry; //The boundry of the map.
	public int y_boundry; //The boundry of the map.
	public int x_center; //Camera's Y intercept.
	public int y_center; //Camera's X intercept.
	public short mode = 0; //changes camera behaviour.
	public static boolean ready; //safety check.
	
	//-------------------------------
	//Camera constructor.
	public Camera()
	{
		
	}
	
	//----------------------------------------
	//updates every frame. Decides which type of
	//camera to use.
	public void update(int x, int y, boolean moveX, boolean moveY)
	{
		switch(mode){
		case 0:
			center(x,y, moveX, moveY);
			break;
		}
	}

	//----------------------------------------
	//Updates the scene whenever the map changes.
	public void updateMap(Scene scene)
	{
		//Stops the camera from moving the map and revealing underlayer.
		x_boundry = scene.map.texture.image.getWidth();
		y_boundry = scene.map.texture.image.getHeight();
		
		//Camera knows its width/height. 
		//Can find its relative positioning.
		height = Game.height;
		width = Game.width;
		
		//Gets the X/Y intercepts:  --|--
		x_center = height/2;
		y_center = width/2;
		
		if(scene.player != null)
			findPlayer(scene);
	}
	
	//Places camera back at origin.
	public void origin()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public void findPlayer(Scene scene)
	{
		this.x = scene.camX;
		this.y = scene.camY;
	}
	
	//updates if camera is set to centered.
	public void center(int x, int y, boolean moveX, boolean moveY)
	{
		
		if( (width - this.x) - x < x_boundry && (width - this.x) - x >= width && moveX == true)
			this.x += x;
	
		if( (height - this.y) - y < y_boundry && (height - this.y) - y >= height && moveY == true)
			this.y += y;
		
		//Checks to see if player cross the X/Y intercept.
		
		/*ALGORITHM EXPLANATION:
		* width/height = viewing area. this.x/y current movements camera has moved.
		* boundries: map's height/width. x/y = z
		* z is added velocity.
		*
		* 1: Checks for boundry. If the inverse of camera's x/y and width/height of view is greater than map
		* prevent it from showing underlayer.
		*
		* 2: Stops camera from going below origin value. If the viewing width/height subtracted
		* by the camera's x/y is greater than or equal to the viewing area continue.
		*
		* Formula: F(x) width + x >= 0 - v.
		 */
		
	}
	
	
	//Getters and setters.
	public void setMode(short mode)
	{
		this.mode = mode;
	}
	
	public short getMode()
	{
		return this.mode;
	}
}
