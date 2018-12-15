package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.StringBuilder;

import Prefabs.Pblock;
import Scripts.MovementTestComponent;
import VisionGoggles.*;

/**
 * Created by Noah on 11/21/2017.
 */

public class Stage1 extends SceneController {

    public Scene stage1;
    public static String name = "Stage1";
    public GameObject stage1Map;
    public GameObject IsoPlayer;

    public int wait = 0;
    public ParticleObject particle;

    public Stage1(){
        create();
    }


    public void create(){
        stage1 = new Scene(this);

        stage1Map= new AnimatedObject(0, 0, "data/island.png", "island", 0.5f);
        stage1Map.x = -stage1Map.getoriginX();
        stage1Map.y = -stage1Map.getoriginY();
        Pblock pblock = new Pblock();
        particle = new ParticleObject("data/flame.p");
        particle.setAllPosition(30, 350);
        particle.startEffect(0.001f);
        stage1.addObjects(stage1Map, pblock, particle);
    }

    @Override
    public void update() {

    }

    public void dispose()
    {
        stage1.dispose();
    }
}
