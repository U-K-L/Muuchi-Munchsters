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
                {1f, 1f, 2f, 1f, 1f, 1f, 1f, 0f, 0f}, //0-8
                {1f, 1f, 0f, 3f, 0f, 0f, 1f, 0f, 0f}, //9-17
                {1f, 0f, 10f, 0f, 0f, 0f, 1f, 0f, 0f}, //18-26
                {1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {0f, 0f, 0f, 0f, 2f, 1f, 1f, 0f, 0f},
                {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
                {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
                {1f, 0f, 0f, 1f, 1f, 1f, 0f, 0f, 20f}
        };
        map.RenderMatrix(mapMatrix);
/*
        float[][]  mapMatrix2;
        mapMatrix2 = new float[][]{
                {1f, 1f, 2f, 1f, 1f, 1f, 1f, 0f, 0f}, //0-8
                {1f, 1f, 0f, 3f, 0f, 0f, 1f, 0f, 0f}, //9-17
                {1f, 0f, 1f, 0f, 0f, 0f, 1f, 0f, 0f}, //18-26
                {1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f, 0f},
                {0f, 0f, 0f, 0f, 1f, 1f, 1f, 0f, 0f},
                {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
                {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f},
                {1f, 0f, 0f, 1f, 1f, 1f, 0f, 0f, 2f}
        };
        for(int i = 0; i < mapMatrix2[0].length; i++){
            for (int j = 0; j < mapMatrix2[1].length; j++){
                float value = mapMatrix2[i][j];
                value += 2;
                mapMatrix2[i][j] = value;
            }

        }
        map.RenderMatrix(mapMatrix2);

        */
    }

    @Override
    public void update() {
        //background.setScale();
        background.update();

        if(map.graphMap != null){
            TileNode node = map.graphMap.get(11);
            System.out.println("RIGHT" + node.getRightNode().dimension.Height);
            System.out.println("LEFT" + node.getLEFTNode().dimension.Height);
            System.out.println("UP" + node.getUPNode().dimension.Height);
            System.out.println("DOWN" + node.getDOWNNode().dimension.Height);
        }
    }

    public void render(){
    }

    public void dispose()
    {
        scene.dispose();
    }
}
