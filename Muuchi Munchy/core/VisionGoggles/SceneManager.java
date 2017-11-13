package VisionGoggles;
/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: A super class for all States.
 -----------------------------*/

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
	public static Map<String, Scene> SceneMap = new HashMap<String, Scene>();
	public static Scene currentScene;
	
	public static void initialize()
	{
		
	}
	
	public static void dispose()
	{
		
	}
	
	public static void render()
	{
		if(currentScene != null)
			currentScene.render();
		
	}
	
	public static void update()
	{
		
	}

}
