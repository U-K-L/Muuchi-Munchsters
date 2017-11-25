package VisionGoggles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.StringBuilder;

/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Every object displayed on screen is a GameObject.
 * Including the map, actors.
 -----------------------------*/
public class GameObject {
	public double x; //X coordinate
	public double y; //Y coordinate

	public Texture texture; //The image used
	private String path; //Path to the image
	public int ID; //Particular ID.
	public String name; //The name of the object
	public boolean renderBool = true; //If it object is displayed
	public boolean player = false; //If the object is controlled by player.
	public double Z = 1; //Priority of display.

	public int direction = 0; //The direction, 0 up, 1 down, 2 right, 3 left.

	public double velocity = 4; //Determines how far an object will move.

	public StringBuilder script; //Events script. Object events.
	
	//Sets the x/y, and creates the texture for the object.
	public GameObject(int x, int y, String Path, String name){

		this.x = x;
		this.y = y;
		this.path = Path;
		this.name = name;
		this.texture = new Texture(this.path);

		
	}
	
	//Sets the new X position
	public double x(double new_x)
	{
		return new_x;
	}
	
	//Sets the new Y position.
	public double y(double new_y)
	{
		return new_y;
	}
	
	//This is if the gameObject is displayed or not.
	public boolean show()
	{
		return renderBool;
	}
	
	//Setter for show.
	public void setShow(boolean bool)
	{
		renderBool = bool;
	}
	//Checks if Object is a player.
	public boolean getPlayer()
	{
		return player;
	}
	
	//Set if an Object is a player.
	public void setPlayer(boolean bool)
	{
		player = bool;
	}
	
	public double getZ()
	{
		return Z;
	}
	/*
	public void setZ(double z, Scene scene)
	{
		if (scene != null)
		{
			Z = z;
			scene.binaryInsertion(this);
		}
	}
*/

	//Sets the script.
	public void setScript(StringBuilder string)
	{
		script = string;
	}

	//Gets the script.
	public StringBuilder getScript()
	{
		return script;
	}

}
