package Scripts;

import VisionGoggles.Behavior;
import VisionGoggles.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.*;

public class Dimensions implements Behavior {
    public float Height;
    public float Length;
    public float Width;
    private GameObject object;

    public  Dimensions(GameObject object){
        this.object = object;
    }
    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void action() {

    }


    @Override
    public String getName() {
        return "Dimensions";
    }

    public void drawTile(float posX, float posY, float x, float y){

        drawTop(posX, posY, x,y);
    }

    public void drawRight(){

    }

    public void drawTop(float posX, float posY, float x, float y){
        object.x = posX + ((x-y) * (object.getwidth()/8))-(object.getwidth()/2);
        object.y = (posY + ((x+y) * (object.getheight()/8)));



    }

    public void drawLeft(){

    }
}
