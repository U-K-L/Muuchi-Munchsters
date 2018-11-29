package Prefabs;
import Scripts.*;
import VisionGoggles.*;
/**
 * Created by Noah on 11/27/2018.
 */

public class Pblock extends GameObject {

    public Pblock(){
        super(30, 350, "images/Player.png", "player");
        AddComponent(new FourDirections(this));

    }
}
