/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: A super class for all States.
 -----------------------------*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
	public static Map<String, Scene> SceneMap = new HashMap<String, Scene>();
	public static Scene currentScene;
	
	public SceneManager()
	{
		
	}
	
	public void initialize()
	{
		
	}
	
	public void dispose()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		if(currentScene != null)
			currentScene.render(g);
		
	}
	
	public void update()
	{
		
	}

}
