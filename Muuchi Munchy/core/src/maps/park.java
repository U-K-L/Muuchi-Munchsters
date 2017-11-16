package maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.GameObject;
import VisionGoggles.Scene;
import VisionGoggles.SceneController;

/**
 * Created by Noah on 11/12/2017.
 */

public class park extends SceneController {

    public static Scene Park;
    public static String name = "park";
    private static GameObject obj;

    public park(){create();}


    public static void make()
    {
        new park();
    }

    public void create (){

        Park = new Scene(this);

        obj = new GameObject(0, 0, "PokemonMap.png", "map");
        GameObject obj2 = new GameObject(400, 200, "black.png", "kid");

        Park.addObjects(obj, obj2);

    }


    public void render() {
        super.render();
    }

    public void update() {
        super.update();
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
                changeScene(Test.test);
    }

    public String getName()
    {
        return name;
    }
}
