package VisionGoggles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;

import com.muuchi.game.Game;

import java.awt.Graphics2D;

public class SceneController extends com.badlogic.gdx.Game{
	
	//Creates a polymorph to update a single scene.
	public void update()
	{
		
	}

	@Override
	public void create() {

	}

	public void render()
	{
		
	}

	//Changes the scene. Switches the collision maps.
	public static void changeScene(Scene scene_new)
	{
		//Updates the camera to the map.
		//Stores camera x/y
		//SceneManager.currentScene.camX = Game.camera.x;
		//SceneManager.currentScene.camY = Game.camera.y;
		
		//Game.camera.updateMap(scene_new);
		
		//new scene.
		SceneManager.currentScene.dispose();
		SceneManager.currentScene = null;
		Game.SceneControllers.get(scene_new.controller.getName()).make();
		SceneManager.currentScene = scene_new;
		
		//checks to see if music was provided.
		/*
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
		*/
	}

	public String getName()
	{
		return null;
	}

	public static void make()
	{

	}
}
