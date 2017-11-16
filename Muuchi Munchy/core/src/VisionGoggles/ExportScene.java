package VisionGoggles;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

/**
 * Created by Noah on 11/14/2017.
 */

public class ExportScene {

    public static void sceneToJson(Object obj, String name)
    {
        Json json = new Json();
        System.out.println(json.prettyPrint(obj));
        String jsonfile = json.toJson(obj);
        FileHandle file = Gdx.files.local(name + ".json");
        file.writeString(jsonfile, false);
    }
}
