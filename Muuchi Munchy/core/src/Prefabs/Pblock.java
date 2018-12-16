package Prefabs;
import Scripts.*;
import VisionGoggles.*;
/**
 * Created by Noah on 11/27/2018.
 */

public class Pblock extends GameObject {

    public Pblock(){
        super(30, 350, 10,"images/Player.png", "player");
        Z = 10;
        AddComponent(new FourDirections(this));

    }
}
