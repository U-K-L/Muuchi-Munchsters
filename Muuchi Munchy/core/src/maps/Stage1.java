package maps;

import com.badlogic.gdx.utils.StringBuilder;

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

    public void create(){

        stage1 = new Scene(this);

        stage1Map= new GameObject(0, 0, "IsoMetricMap.png", "map");
        IsoPlayer = new GameObject(30, 350, "Player.png", "player");

        stage1.addObjects(stage1Map, IsoPlayer);

        StringBuilder str = new StringBuilder();
        str.append("mf");

        IsoPlayer.setScript(str);

    }

    @Override
    public void update() {

        if(wait >= 1)
        {
            VGInterpreter.ReadScript(IsoPlayer);
            wait = 0;
        }
        wait++;
    }
}
