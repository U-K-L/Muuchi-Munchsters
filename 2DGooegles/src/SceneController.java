import java.awt.Graphics2D;

public class SceneController {
	
	//Creates a polymorph to update a single scene.
	public void update(Input input)
	{
		
	}
	
	public void render(Graphics2D g, Input input)
	{
		
	}
	
	//Changes the scene. Switches the collision maps.
	public void changeScene(Scene scene_new, String music)
	{
		
		//Updates the camera to the map.
		//Stores camera x/y
		SceneManager.currentScene.camX = Game.camera.x;
		SceneManager.currentScene.camY = Game.camera.y;
		
		Game.camera.updateMap(scene_new);
		
		//new scene.
		SceneManager.currentScene = scene_new;
		
		//checks to see if music was provided.
		try{
		if(music != null)
			Game.musicPlayer.stopMusic();
			Game.musicPlayer.playMusic(music);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Sets the collision map to Hashmap element.
		CollisionMap.MapDimension = CollisionMapGen.CollisionMaps.get
				("$"+ SceneManager.currentScene.map.texture.filename + ".png");
		
		//update collision map.
		Game.collide.updateMap();
		
	}

}
