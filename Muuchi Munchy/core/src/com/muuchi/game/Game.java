package com.muuchi.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Prefabs.*;
import VisionGoggles.ExportScene;
import VisionGoggles.GameObject;
import VisionGoggles.*;
import maps.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
	private AnimatedObject mai;
	private enum PicState{ PICTURE, TRANSITIONING}
	private static final int GALLERY_NUM_PICTURES = 4;
	private static final float GALLERY_PICTURE_TIME = 3.0f;
	private static final float GALLERY_TRANSITION_TIME = 2.0f;
	private TextureRegion[] gallery;
	private FrameBuffer currentFrameBuffer;
	private FrameBuffer nextFrameBuffer;
	private int currentPicture;
	private float time;
	private PicState state;

	public static Map<String, SceneController> SceneControllers = new HashMap<String, SceneController>(); //List of Maps.
	public TutorialStage testStage;
	TEST tester;
	@Override
	public void create () {
		fps = new FPSLogger();
		batch = new SpriteBatch();
		Camera cam = new Camera();
		Scene.setCamera(cam);
		sceneController = new SceneController();
		testStage = new TutorialStage();
		sceneManager.SwitchScene(testStage.scene);
		UklViewPorts.create();
		UklViewPorts.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), "Extend");
		//map = new RenderMaps(testStage.scene);
		//map.create();
	}

	@Override
	public void render () {
		fps.log();
		Gdx.gl.glClearColor(255, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if(sceneManager != null && Gdx.gl != null);
			sceneManager.render();

		if(SceneManager.currentScene != null);
			SceneManager.currentScene.render();

		if(SceneManager.currentScene != null);
			SceneManager.currentScene.controller.update();

			//map.RenderLines();
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
