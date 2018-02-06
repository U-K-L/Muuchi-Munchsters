package VisionGoggles;

import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.viewport.*;
/**
 * Created by Noah on 1/20/2018.
 *
 * Purpose: Resizes the screen to fit different types of screens.
 */

public class UklViewPorts {
    public static ArrayMap<String, Viewport> views;
    private float MAXWIDTH = 2560;
    private float MAXHEIGHT = 2560;
    private float MINWIDTH = 544;
    private float MINHEIGHT = 416;

    //Creates the list of viewports to use.
    public static void create(){
        views = new ArrayMap<String, Viewport>();
        views.put("Fit", new FitViewport(544.0f,416.0f, Scene.camera.cam)); //Fits to aspect ratio.
        views.put("Fill", new FillViewport(544.0f,416.0f, Scene.camera.cam)); //Fills entire screen. May chop off graphics.
        views.put("Screen", new ScreenViewport(Scene.camera.cam)); //Shows the graphics raw.
        views.put("Stretch", new StretchViewport(544.0f,416.0f, Scene.camera.cam)); //Will always stretch to fit.
        views.put("Extend", new ExtendViewport(544.0f,416.0f, Scene.camera.cam)); //Extends different parts depending.
    }

    //Sets what viewport to use, and resize based on decision.
    public static void resize(int width, int height, String view){
        views.get(view).update(width, height);
    }
}
