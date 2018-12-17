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
	public static float[][] mapMatrix = new float[][]{
			{1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f}, //0-8
			{1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f}, //9-17
			{1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f}, //18-26
			{1f, 0f, 0f, 2f, 2f, 2f, 0f, 0f, 1f},
			{1f, 0f, 0f, 2f, 2f, 2f, 0f, 0f, 1f},
			{1f, 0f, 0f, 2f, 2f, 2f, 0f, 0f, 1f},
			{1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f},
			{1f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f},
			{1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f}
	};
	
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

	public static void SwitchScene(Scene scene){
		currentScene = scene;
		scene.start();
	}

}
