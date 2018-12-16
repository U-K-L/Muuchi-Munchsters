package maps;

import Prefabs.background;
import VisionGoggles.GameObject;
import VisionGoggles.ParticleObject;
import VisionGoggles.Scene;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.StringBuilder;

import Prefabs.Pblock;
import Scripts.MovementTestComponent;
import VisionGoggles.*;

public class TutorialStage extends SceneController {
    public Scene scene;
    public static String name = "TutorialStage";
    public GameObject background;
    public GameObject Player;

    public int wait = 0;
    public ParticleObject particle;
    RenderMaps map;
    float[][] mapMatrix;

    public TutorialStage(){
        create();
    }

    public void create(){

        scene = new Scene(this);
        map = new RenderMaps(scene);
       Player = new Pblock();
       background = new background();
       scene.addObjects(Player, background);
        //{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
        mapMatrix = new float[][]{
                {1f, 1f, 1f, 1f, 1f, 1f, 1f, 0f, 0f},
                {1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {5f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {0f, 0f, 0f, 0f, 2f, 1f, 1f, 0f, 0f},
                {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
                {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
                {1f, 0f, 0f, 1f, 1f, 1f, 0f, 0f, 0f}
        };
        map.RenderMatrix(mapMatrix);
    }

    @Override
    public void update() {
        //background.setScale();
        background.update();
    }

    public void render(){
    }

    public void dispose()
    {
        scene.dispose();
    }
}
