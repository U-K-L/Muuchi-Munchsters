package com.muuchi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.FPSLogger;

import java.util.HashMap;
import java.util.Map;

import VisionGoggles.ExportScene;
import VisionGoggles.GameObject;
import VisionGoggles.Scene;
import VisionGoggles.SceneController;
import VisionGoggles.SceneManager;
import maps.Test;
import maps.park;


public class Game extends ApplicationAdapter {

	//Displays batch of sprites.
	SpriteBatch batch;

	private FPSLogger fps; //track FPS.

	//Managers
	public SceneManager sceneManager;
	public SceneController sceneController;

	public static Map<String, SceneController> SceneControllers = new HashMap<String, SceneController>(); //List of Maps.


	public Scene testScene;
	@Override
	public void create () {

		fps = new FPSLogger();
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		SceneControllers.put(Test.name, new Test());

		SceneControllers.put(park.name, new park());


		sceneController = new SceneController();

		sceneManager.currentScene = Test.test;
		Test t = new Test();
		ExportScene.sceneToJson(t, "bob");
	}

	@Override
	public void render () {
		fps.log();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if(sceneManager != null && Gdx.gl != null)
			sceneManager.render();

		if(SceneManager.currentScene != null)
			SceneManager.currentScene.render();

		if(SceneManager.currentScene != null)
			SceneManager.currentScene.controller.update();

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
