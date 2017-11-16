/*
 * Author: Noah Williams
 * 
 * Date Created 11/14/2017
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class DefaultScene extends SceneController {

    public static transient Scene DScene; //Scene to be used
    public static transient String name = "Maps"; //Name of the controller.
    public static transient FileHandle file; //File input.
    public static transient String filePath; //The path of the file.
    public static transient Map<String, GameObject> GlobalObjects; //Used for retriving gameobjects.
    public transient ArrayList<GameObject> GameObjects; //Used for sorting objects.

    
    //Default contructor.
    public DefaultScene(){create();}


    //Makes the controller. Used for memory complexity.
    public static void make()
    {
    	
        new DefaultScene();
    }

    //creates the scene.
    public void create (){
    	
    	DScene = new Scene(this, "default");
    }
    
    //Changes default scene objects per scene load.
    public void LoadJson()

    {
    	create();
    	//--------
    	//create objects hashmap, and filehandle.
        GlobalObjects = new HashMap<String, GameObject>();
        GameObjects = new ArrayList<GameObject>();
    	file = new FileHandle(filePath);
    	
    	//create Json reader and Jsonvalue.
    	JsonReader json = new JsonReader();
    	JsonValue base = json.parse(file);
    	
    	//iterate over each Json GameObject.
    	for (JsonValue val : base.iterator())
    	{
    	 
    		//creates the object.
    		GameObject obj = null;
    		
    		//Checks if it came from asset or is native.
    		try{
    			if(val.getString("path").indexOf("assets") == -1)
        				obj = new GameObject(val.getInt("x"), val.getInt("y"),
        				val.getString("path"), 
        				val.getString("name"));
    			else
        			obj = new GameObject(val.getInt("x"), val.getInt("y"),
            	    		val.getString("path"), val.getString("name"));

    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		
    	    
    	    //add to arraylist and hashMap.
    	    GameObjects.add(obj);
    	    GlobalObjects.put(obj.name, obj);
    	    
    	}
    	
    	//Add them to scene in priority.
    	for(GameObject obj : GameObjects)
    	{
    		DScene.addObjects(obj);
    	}
    	
    	Game.SceneManager.currentScene = DScene;
    	
    	
    }
    
    //-----------------------------
    // Updates the input.
	public void update(Input input)
	{
		try{
		if(input.left.pressed() == true)
		{
			
		}
		if(input.right.pressed() == true)
			GlobalObjects.get("kid").x -= 25;
		}catch(Exception e){}
	
	
	}
}

