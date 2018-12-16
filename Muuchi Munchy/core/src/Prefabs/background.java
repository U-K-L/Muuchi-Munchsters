package Prefabs;
import Scripts.*;
import VisionGoggles.*;
/**
 * Created by Noah on 11/27/2018.
 */

public class background extends GameObject {

    public background(){
        super(0, 0, -1,"images/background1.png", "background");

    }

    public void changeBackground(String file){
        this.setTexture(file);
    }

    public void update(){
        this.x = -this.getoriginX() + 900;
        this.y = -this.getoriginY();
        this.setScale(.80f);
    }
}