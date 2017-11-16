
import java.io.FileWriter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

/**
 * Created by Noah Williams on 11/14/2017.
 * 
 * Purpose: Exports the scene to a json.
 */

public class ExportScene {

    public static void sceneToJson(Object obj, String name)
    {
        Json json = new Json();
        String jsonfile = json.toJson(obj);
		try {
			FileWriter fileWriter = new FileWriter("Jsons/" + name + ".json");
			fileWriter.write(jsonfile);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
