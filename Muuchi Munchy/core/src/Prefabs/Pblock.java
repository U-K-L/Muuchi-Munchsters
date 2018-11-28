package Prefabs;
import Scripts.MovementTestComponent;
import VisionGoggles.*;
/**
 * Created by Noah on 11/27/2018.
 */

public class Pblock extends GameObject {

    public Pblock(){
        Components.add(new MovementTestComponent());
    }
}
