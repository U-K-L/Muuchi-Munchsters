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
	private float[] debugFunction;
	public 	float angle = 0f;

	public ShapeRenderer shapeRenderer;
	public Scene testScene;
	public float tileHeight;
	public float tileWidth;
	public float tileSize = 128f;
	public float tileAxis = 120f;//126.89f;
	public int tileAmount = 8;
	@Override
	public void create () {
		float tileAngle = 180-tileAxis;
		tileWidth = tileSize;
		tileHeight = (float)(tileSize*Math.tan(Math.toRadians(tileAngle/2)));
		System.out.println(tileWidth);
		System.out.println(tileHeight);
		fps = new FPSLogger();
		batch = new SpriteBatch();
		Camera cam = new Camera();
		Scene.setCamera(cam);
		sceneController = new SceneController();

		//nullStage n = new nullStage();
		Stage1 t = new Stage1();
		sceneManager.SwitchScene(t.stage1);
		UklViewPorts.create();
		UklViewPorts.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), "Extend");
		 shapeRenderer = new ShapeRenderer();


		debugFunction = new float[40];
		for (int x = -10; x < 10; ++x) {
			int i = (x + 10) * 2;
			debugFunction[i] = x;
			debugFunction[i + 1] = x * x;
		}

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




		batch.end();
		angle += 0.1f;
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(Color.BLACK);
		//shapeRenderer.line(-Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2f);
		//shapeRenderer.line(0.0f, -Gdx.graphics.getHeight(), 0.0f, Gdx.graphics.getHeight());
		//shapeRenderer.polygon(drawTile(20*(float)Math.cos(angle),0));
		//shapeRenderer.polygon(drawTile(0,20*(float)Math.sin(angle)));
		//shapeRenderer.polygon(drawTile(20*(float)Math.cos(angle), 7*(float)Math.sin(angle)));
		//shapeRenderer.polygon(drawTile(20*(float)Math.sin(angle), 7*(float)Math.cos(angle)));
		for(int x = -tileAmount; x < tileAmount; x++){
			for(int y = -tileAmount; y < tileAmount; y++){
				shapeRenderer.polygon(drawTile((float)x,(float)y));
			}
		}
		//shapeRenderer.polyline(debugFunction);
		//shapeRenderer.rect(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 50.3f, 50.8f);
		shapeRenderer.end();
	}

	float[] drawTile(float x, float y){
		//Translational Matrix.
		float[] t = new float[]{
				1f,0f,0,
				0f,1f,0,
				(x-y) * (tileWidth/2), (y+x) * (tileHeight/2), 0f};
		Matrix3 T = new Matrix3(t);
		//Point Matrix, that represents origin to be translated.
		float[] p = new float[]{
				Gdx.graphics.getWidth()/2, 0f, 1f,
				0f,Gdx.graphics.getHeight()/2, 1f,
				0, 0, 0f};
		Matrix3 point = new Matrix3(p);

		T = T.mul(point);
		//Convert to a 2D vector. Take the x,y identity coordinates.
		Vector2 points = new Vector2(T.getValues()[0], T.getValues()[4]);
		float[] vertex = new float[]{
				0+ points.x , 0 + points.y, //Top center.
				(tileWidth/2) + points.x, (tileHeight/2) + points.y, //Far right corner.
				(0) + points.x, (tileHeight) + points.y, //Bottom.
				(-tileWidth/2) + points.x, (tileHeight/2) + points.y,//Left corner.
		};
		return vertex;

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
