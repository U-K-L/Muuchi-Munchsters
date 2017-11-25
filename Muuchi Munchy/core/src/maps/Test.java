package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.*;

/**
 * Created by Noah on 11/12/2017.
 */

public class Test extends SceneController {

    public static Scene test;
    public static String name = "Test";
    public GameObject MegaManMap;
    public GameObject IsoCube;

    public Test(){create();}


    public static void make()
    {
        new Test();
    }

    public void create(){

        test = new Scene(this);

        MegaManMap = new GameObject(0, 0, "MegaMan.png", "map");
        IsoCube = new GameObject(50, 200, "iso.png", "kid");

        test.addObjects(MegaManMap, IsoCube);

    }

    public void render() {
        super.render();
    }

    public void update() {
        super.update();
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
            changeScene(park.Park);

    }

    public String getName()
    {
        return name;
    }

}
