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
    public TileNode currentNode;

    //Hashmap of all components.
    public CompObject(){
        Components = new HashMap<String, Behavior>();
    }

    //All components will start.
    public void start(){
        for(String key : Components.keySet()){
            Components.get(key).start();
        }
    }

    //All components update every frame.
    public void update(){
        for(String key : Components.keySet()){
            Components.get(key).update();
        }
    }

    //Method to add a new component.
    public void AddComponent(Behavior comp){
        Components.put(comp.getName(), comp);
    }
}
