package com.muuchi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


import java.util.HashMap;
import java.util.Map;

import VisionGoggles.ExportScene;
import VisionGoggles.GameObject;
import VisionGoggles.Scene;
import VisionGoggles.SceneController;
import VisionGoggles.SceneManager;
import maps.Stage1;
import maps.Test;
import maps.park;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;



public class Game extends ApplicationAdapter {

	//Displays batch of sprites.
	SpriteBatch batch;

	private FPSLogger fps; //track FPS.

	//Managers
	public SceneManager sceneManager;
	public SceneController sceneController;
	private TextureAtlas textureAtlas;
	private Sprite sprite;
	private int currentFrame = 1;
	private String currentAtlasKey = new String("0001");

	public static Map<String, SceneController> SceneControllers = new HashMap<String, SceneController>(); //List of Maps.


	public Scene testScene;
	@Override
	public void create () {

		fps = new FPSLogger();
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		//SceneControllers.put(Test.name, new Test());
		//SceneControllers.put(park.name, new park());


		sceneController = new SceneController();

		Stage1 t = new Stage1();
		sceneManager.currentScene = t.stage1;
		//ExportScene.sceneToJson(t, "Stage 1");
		textureAtlas = new TextureAtlas("mai.atlas");
		AtlasRegion region = textureAtlas.findRegion("0001");

		sprite = new Sprite(region);
		sprite.setPosition(0, 0);
		//sprite.scale(2.5f);

		Timer.schedule(new Task(){
						   @Override
						   public void run() {
							   currentFrame++;
							   if(currentFrame > 12)
								   currentFrame = 1;

							   // ATTENTION! String.format() doesnt work under GWT for god knows why...
							   currentAtlasKey = String.format("%04d", currentFrame);
							   sprite.setRegion(textureAtlas.findRegion(currentAtlasKey));
						   }
					   }
				,0,1/20.0f);
	}

	@Override
	public void render () {
		fps.log();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if(sceneManager != null && Gdx.gl != null);
			//sceneManager.render();

		if(SceneManager.currentScene != null);
			//SceneManager.currentScene.render();

		if(SceneManager.currentScene != null);
			//SceneManager.currentScene.controller.update();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			sprite.setX(sprite.getX() - 25);
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			sprite.setX(sprite.getX() + 25);
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			sprite.setY(sprite.getY() + 25);
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			sprite.setY(sprite.getY() - 25);

		sprite.draw(batch);

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		//img.dispose();
	}
}
