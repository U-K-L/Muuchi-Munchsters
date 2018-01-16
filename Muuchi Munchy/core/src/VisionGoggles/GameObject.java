package VisionGoggles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
public class GameObject extends Sprite {
	//---------------------------------------------
		//Fields
	//---------------------------------------------
	//Coordinates.
	public float x; //X coordinate
	public float y; //Y coordinate
	private double Z = 1; //Priority of display.
	private int height; //height of object's texture.
	private int width; //width of object's texture.

	//Image manipulations.
	private float originX; //The X center of the texture.
	private float originY; //The Y center of the texture.
	private float degrees = 0.0f; //rotation of object.
	private float rectX = 0.0f; //X coordinate for Box portion of image.
	private float rectY = 0.0f; //Y coordinate for Box portion of image.
	private float rectWidth; //Width of box.
	private float rectHeight; //Height of box.
	public int direction = 0; //The direction, 0 up, 1 down, 2 right, 3 left.
	public double velocity = 1; //Determines how far an object will move.

	//Objects.
	public Texture texture; //The image used
	private String path; //Path to the image
	public int ID; //Particular ID.
	public String name; //The name of the object
	public boolean renderBool = true; //If it object is displayed
	public boolean player = false; //If the object is controlled by player.
	public StringBuilder script; //Events script. Object events.

	//---------------------------------------------------------------------------------
	//
		//Constructors
	//---------------------------------------------------------------------------------
	//Constructor for gameobject. Sets everything.
	public GameObject(float x, float y, String Path, String name){

		this.x = x;
		this.y = y;
		this.path = Path;
		this.name = name;
		this.texture = new Texture(this.path);
		this.width = this.texture.getWidth();
		this.height = this.texture.getHeight();
		this.originX = width * 0.5f;
		this.originY = height * 0.5f;
		this.rectHeight = height;
		this.rectWidth = width;


		
	}
//--------------------------------------------------------------------
	//Methods and feautures.
	//
//--------------------------------------------------------------------
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

//---------------------------------------------------------------------
	//Getters and Setters.
	//
//---------------------------------------------------------------------

	//Gets the priority of the Z axis.
	public double getZ()
	{
		return Z;
	}

	//Changes the Z value, and then re-sorts all objects.
	public void setZ(double z, Scene scene)
	{
		if (scene != null)
		{
			Z = z;
			scene.binaryInsertion(this);
		}
	}

	public void render(SpriteBatch batch)
	{

	}

	public void dispose()
	{
		this.texture.dispose();
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

	//set width
	public void setwidth(int wid){this.width = wid; }

	//get width
	public int getwidth(){return this.width;}

	//set height
	public void setheight(int hei){this.height = hei; }

	public int getheight(){return this.height;}

	public float getoriginX() {return originX;}

	public void setOriginX(float originX) {this.originX = originX;}

	public float getoriginY() {return originY;}

	public void setOriginY(float originY) {this.originY = originY;}

	public float getDegrees() {return degrees;}

	public void setDegrees(float degrees) {this.degrees = degrees;}

	public float getRectX() {return rectX;}

	public void setRectX(float rectX) {this.rectX = rectX;}

	public float getRectY() {return rectY;}

	public void setRectY(float rectY) {this.rectY = rectY;}

	public float getRectWidth() {return rectWidth;}

	public void setRectWidth(float rectWidth) {this.rectWidth = rectWidth;}

	public float getRectHeight() {return rectHeight;}

	public void setRectHeight(float rectHeight) {this.rectHeight = rectHeight;}




}
