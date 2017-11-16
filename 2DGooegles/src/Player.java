/*
 * Authors: Noah Williams.
 * 
 * Last Updated: 10/15/2017
 * Date Created: 10/15/2017
 * 
 * Purpose: Creates player object. Decides special conditions for
 * Player such as camera.
 */
public class Player extends AnimatedObject {
	
	private int abs_x; //Distance from camera's Y axis.
	private int abs_y; //Distance from camera's X axis.
	public boolean moveX = false; //Can the camera moveX?
	public boolean moveY = false; //Can the camera moveY?
	
	public Player(int x, int y, String Path, String name) {
		super(x, y, Path, name);
		
		
	}
	
	//--------------------------
	//Move method. 
	public void move(int x, int y)
	{
		
		//----------------------------------------------------------------
		//Gets the distance from X/Y axis.
		 abs_x = Math.abs(this.y - (Game.camera.x_center - Game.camera.y));
		 abs_y = Math.abs(this.x - (Game.camera.y_center - Game.camera.x));
		
		//Moves the target, check if allowed to move.
		boolean hasMoved = animate.move(x, y, this);
		
		//Did it move?
		if(hasMoved == true)
		{	 
			 //Distance formula. Decides if player is near the
			//X/Y axis. If player is, move!
			// The value X/Y assure grid movement works.
			 moveY = abs_x <= (Math.pow(6, 2))/2 ? true : false;
			 moveX = abs_y <= (Math.pow(6, 2))/2 ? true : false;
			 
			 //Updates the camera.
			 Game.camera.update(-x, -y, moveX, moveY);
		}
		 
		 
	}
	
	
	//Setters for more control, not needed.
	public void setMoveX(boolean moveX)
	{
		this.moveX = moveX;
	}
	
	public void setMoveY(boolean moveY)
	{
		this.moveY = moveY;
	}

}
