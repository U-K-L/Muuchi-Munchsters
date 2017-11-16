/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Creates the scenes class. Handles GameObjects and back images.
 -----------------------------*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Collections;

public class Scene extends SceneManager{

	//--------------------
	//Creates arraylist of gameobjects, players, bools, names.
	private String name;
	public Player player;
	public String HashKey;
	public SceneController controller;
	public GameMap map;
	public int camX;
	public int camY;
	public Graphics2D g;
	public ArrayList<GameObject> GameObjects = new ArrayList<GameObject>();

	//Constructor method.
	public Scene(SceneController control, String Name) 
	{
		super();
		controller = control;
		name = Name;
		HashKey = name + SceneMap.size();
		SceneMap.put(HashKey, this);
	}
	
	
	//------------------------------------
	//-------------------------
	//Adds objects to the scene.
	public void addObjects(GameObject object, int x, int y, String path, String name)
	{
		if(object != null)
			GameObjects.add(object);
		else
		{
			object = new GameObject(x,y,path,name);

			GameObjects.add(object);
		}
		
		sortZ();
	}
	
	  //Method overloading. Add multiple objects to scene.  
	  public void addObjects(GameObject... object) 
	  { 
	    for(GameObject obj: object) 
	    { 
	      GameObjects.add(obj); 
	    }
	    
	    sortZ();
	  } 
	
	//Renders the scenes graphics.
	public void render(Graphics2D g2)
	{
		g = g2;
		if(g != null)
		{
			for (GameObject object: GameObjects)
			{
				if(object.show() == true)
					object.texture.render(g, object.x, object.y);
			}
			
		}
		
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public int getPlayerX()
	{
		return player.x;
	}
	
	public int getPlayerY()
	{
		return player.y;
	}
	
	public String getName()
	{
		return name;
	}
	
	//Sets if the scene is being used.
	public void setCurrentScene()
	{
		SceneManager.currentScene = SceneMap.get(HashKey);
	}
	
	//Sets the scene's map for collisions.
	public void setMap(GameMap map)
	{
		this.map = map;
	}
	
	
	//Sort gameObjects based on Zaxis.
	//Quickly checks elements to decide
	//what algorithm to use.
	public void sortZ()
	{
		insertionSort();
	}
	
	//Used for large random data.
	private void mergeSort()
	{
		
	}
	
	//Used for small sorted data.
	private void insertionSort()
	{
		for (int j = 0; j < GameObjects.size(); j++)
		{
			for (int i = j; i < GameObjects.size(); i++)
			{
				if (GameObjects.get(j).getZ() > GameObjects.get(i).getZ())
					Collections.swap(GameObjects, j, i);
			}
		}
	}
	
	//Used to add elements to a sorted list.
	public boolean binaryInsertion(GameObject obj)
	{
		int i = 0;
		for (i = 0; i < GameObjects.size(); i++)
		{
			if (GameObjects.get(i).getZ() > obj.getZ())
			{
				GameObjects.remove(obj);
				GameObjects.add(i, obj);
				return true;
			}
		}
		
		GameObjects.remove(obj);
		GameObjects.add(i-1, obj);
		return true;
	}
	
}
