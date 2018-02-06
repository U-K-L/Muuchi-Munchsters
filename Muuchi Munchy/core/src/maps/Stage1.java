package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.viewport.FitViewport;

import VisionGoggles.*;

/**
 * Created by Noah on 11/21/2017.
 */

public class Stage1 extends SceneController {

    public static Scene stage1;
    public static String name = "Stage1";
    public GameObject stage1Map;
    public GameObject IsoPlayer;

    public int wait = 0;

    public Stage1(){create();}
    public ParticleObject particle;

    public void create(){
        stage1 = new Scene(this);

        stage1Map= new AnimatedObject(0, 0, "data/island.png", "island", 0.5f);
        stage1Map.x = -stage1Map.getoriginX();
        stage1Map.y = -stage1Map.getoriginY();
        IsoPlayer = new GameObject(30, 350, "images/Player.png", "player");


        particle = new ParticleObject("data/flame.p");
        particle.setAllPosition(30, 350);
        particle.startEffect(0.001f);
        stage1.addObjects(stage1Map, IsoPlayer, particle);

        StringBuilder str = new StringBuilder();
        str.append("mf");
        IsoPlayer.setScript(str);

    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            stage1Map.setZ(4, stage1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            stage1Map.setZ(-1, stage1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            stage1Map.y -= 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            stage1Map.y += 4;
        }

       if (Gdx.input.isKeyPressed(Input.Keys.Q))
            Scene.camera.cam.zoom -= 1.2f;
        if(Gdx.input.isKeyJustPressed(Input.Keys.D))
            stage1.dispose();
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            Scene.camera.cam.zoom += 1.2f;

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            particle.setAllPosition(Gdx.input.getX(), Gdx.input.getY());
            particle.startEffect(0.05f);
            particle.setContinous(true);
        }

        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
        {
            particle.setAllPosition(Gdx.input.getX(), Gdx.input.getY());
            particle.startEffect(0.05f);
            particle.setContinous(false);
        }

        if(wait >= 1)
        {
            VGInterpreter.ReadScript(IsoPlayer);
            wait = 0;
        }
        wait++;
    }

    public void dispose()
    {
        stage1.dispose();
    }
}
