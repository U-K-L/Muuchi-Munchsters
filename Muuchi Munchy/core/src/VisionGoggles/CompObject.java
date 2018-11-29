package VisionGoggles;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Noah on 11/27/2018.
 */

public class CompObject extends Sprite {
    public HashMap<String, Behavior> Components;

    public CompObject(){
        Components = new HashMap<String, Behavior>();
    }

    public void start(){
        for(String key : Components.keySet()){
            Components.get(key).start();
        }
    }

    public void update(){
        for(String key : Components.keySet()){
            Components.get(key).update();
        }
    }

    public void AddComponent(Behavior comp){
        Components.put(comp.getName(), comp);
    }
}
