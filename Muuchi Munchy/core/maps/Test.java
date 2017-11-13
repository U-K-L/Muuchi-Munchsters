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
    private GameObject obj;

    public Test(){create();}


    public static void make()
    {
        System.out.println("here");
        new Test();
    }

    public void create(){

        test = new Scene(this);

        obj = new GameObject(0, 0, "MegaMan.png", "map");
        GameObject obj2 = new GameObject(400, 200, "iso.png", "kid");

        test.addObjects(obj, obj2);

    }

    public void render() {
        super.render();
    }

    public void update() {
        super.update();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
                changeScene(park.Park);

        System.out.println(obj.x);
    }

    public String getName()
    {
        return name;
    }
}
