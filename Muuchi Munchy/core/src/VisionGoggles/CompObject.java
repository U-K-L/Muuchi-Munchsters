package VisionGoggles;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah on 11/27/2018.
 */

public class CompObject extends Sprite {
    public List<Behavior> Components;

    public CompObject(){
        Components = new ArrayList<Behavior>();
    }

    public void start(){
        for(Behavior obj : Components){
            obj.start();
        }
    }

    public void update(){
        for(Behavior obj : Components){
            obj.update();
        }
    }
}
