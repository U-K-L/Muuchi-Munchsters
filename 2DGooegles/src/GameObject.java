/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Create every GameObject displayed.
 -----------------------------*/
public class GameObject {
	public int x;
	public int y;
	
	public transient Texture texture;
	public String path;
	public int ID;
	public String name;
	public boolean renderBool = true;
	public boolean player = false;
	public double Z = 1;
	
	
	//Sets the x/y, and creates the texture for the object.
	public GameObject(){}
	public GameObject(int x, int y, String Path, String name){
		
		this.x = x;
		this.y = y;
		path = Path;
		this.name = name;
		this.texture = new Texture(this.path, this.name);
		
	}
	
	//Sets the new X position
	public int x(int new_x)
	{
		return new_x;
	}
	
	//Sets the new Y position.
	public int y(int new_y)
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
	
	public void setZ(double z, Scene scene)
	{
		if (scene != null)
		{
			Z = z;
			scene.binaryInsertion(this);
		}
	}


}
