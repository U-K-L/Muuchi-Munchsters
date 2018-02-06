package VisionGoggles;
/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Creates the scenes class. Handles GameObjects and back images.
 -----------------------------*/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.Collections;

public class Scene{

//--------------------
	//Creates arraylist of gameobjects, players, bools, names.


	public SpriteBatch batch;
	public static Camera camera;
	public Viewport viewport;
	private static final float WORLD_TO_SCREEN = 1.0f;
	private static final float SCENE_WIDTH = 12.80f;
	private static final float SCENE_HEIGHT = 7.20f;

	private String name;
	//public Player player;
	public String HashKey;
	public SceneController controller;
	//public GameMap map;
	public int camX;
	public int camY;
	public Gdx g;
	//private UklParticleEffects particle;
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

	public static void setCamera(Camera cam)
	{
		camera = cam;
	}
	
	
	//------------------------------------
	//-------------------------0, 0, 0
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
		camera.cam.update();
		batch.setProjectionMatrix(camera.cam.combined);

		batch.begin();
			for (GameObject object: GameObjects)
			{
				if(object.show() == true) {
					if(object.getClass() == ParticleObject.class)
					{
						renderParticle((ParticleObject)object);
					}
					else
					{
						renderGameObject(object);
					}
					object.render(batch); //Used for polymorphism such as animation.
				}

			}
		batch.end();
	}

	//Renders the gameObjects.
	private void renderGameObject(GameObject object)
	{
		batch.draw(object.texture, object.x, object.y, //X Y coordinate
				object.getOriginX(), object.getoriginY(), //Center of texture
				object.getwidth(), object.getheight(), //Width and height.
				WORLD_TO_SCREEN, WORLD_TO_SCREEN, //Scale X and Y.
				object.getDegrees(),            //Rotation.
				(int) object.getRectX(), (int) object.getRectY(), //X and Y of the box section.
				(int) object.getRectWidth(), (int) object.getRectHeight(),//Width of box
				false, false);
	}

	//Renders the particles.
	private void renderParticle(ParticleObject object)
	{

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
	
	//Used for small sorted data. Sorts all gameobjects based on Z axis.
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

	public void dispose()
	{
		for (GameObject obj : GameObjects)
		{
			obj.dispose();
		}
		batch.dispose();
	}


	public static float getWorldToScreen() {
		return WORLD_TO_SCREEN;
	}

	public static float getSceneWidth() {
		return SCENE_WIDTH;
	}

	public static float getSceneHeight() {
		return SCENE_HEIGHT;
	}
	
}
