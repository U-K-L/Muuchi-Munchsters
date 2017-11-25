package VisionGoggles;
/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Creates the scenes class. Handles GameObjects and back images.
 -----------------------------*/

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Collections;

public class Scene{

	//--------------------
	//Creates arraylist of gameobjects, players, bools, names.


	SpriteBatch batch;
	private String name;
	//public Player player;
	public String HashKey;
	public SceneController controller;
	//public GameMap map;
	public int camX;
	public int camY;
	public Gdx g;
	ArrayList<GameObject> GameObjects = new ArrayList<GameObject>();

	//Constructor method.
	public Scene(SceneController control)
	{

		super();
		batch = new SpriteBatch();
		controller = control;
		//name = Name;
		HashKey = name + SceneManager.SceneMap.size();
		SceneManager.SceneMap.put(HashKey, this);
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
	public void render()
	{

		batch.begin();
			for (GameObject object: GameObjects)
			{
				if(object.show() == true)
					batch.draw(object.texture, (int)object.x, (int)object.y);
			}
		batch.end();
	}
	/*
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
	*/
	public String getName()
	{
		return name;
	}
	
	//Sets if the scene is being used.
	public void setCurrentScene()
	{
		SceneManager.currentScene = SceneManager.SceneMap.get(HashKey);
	}
	/*
	//Sets the scene's map for collisions.
	public void setMap(GameMap map)
	{
		this.map = map;
	}
	*/
	
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
