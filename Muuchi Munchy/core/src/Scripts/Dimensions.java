package Scripts;

import Prefabs.Tile;
import VisionGoggles.Behavior;
import VisionGoggles.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.*;

public class Dimensions implements Behavior {
    public float Height;
    public float Length;
    public float Width;
    private Tile object;

    public  Dimensions(Tile object){
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

    public void drawTile(float posX, float posY, float x, float y, float z){

        drawTop(posX, posY, x,y, z);
    }

    public void drawRight(float posX, float posY, float x, float y, float z){

        object.RightSide.x = posX + ((x-y) * (object.getwidth()/9));
        object.RightSide.y = (posY + ((x+y) * (object.getheight()/9))) -z * object.getheight();
        object.RightSide.y -= 89*6;
        //object.RightSide.setScale(1, 2f);

        //object.RightSide.x += 60*Math.cos(Math.toDegrees(30));
        //object.RightSide.y += 60*Math.sin(Math.toDegrees(30));
    }

    public void drawTop(float posX, float posY, float x, float y, float z){
        object.x = posX + ((x-y) * (object.getwidth()/9f))-(object.getwidth()/2);
        object.y = (posY + ((x+y) * (object.getheight()/9f)))-z * object.getheight();

        drawRight(posX, posY, x, y, z);
        drawLeft(posX, posY, x, y, z);


    }

    public void drawBlock(float posX, float posY, float x, float y, float z){
        posX -= object.getwidth()/2;
        posY -= object.getheight()/2;
        object.Block.x = posX;
        object.Block.y = posY;

        int index = 0;
        for(GameObject block : object.Blocks){
            block.x = posX;
            block.y = posY + (block.getheight()/2)*index;
            index++;
        }

    }

    public void drawLeft(float posX, float posY, float x, float y, float z){


        object.LeftSide.x = posX + ((x-y) * (object.getwidth()/9f))-(object.getwidth()/2);
        object.LeftSide.y = (posY + ((x+y) * (object.getheight()/9f)))-z * object.getheight();
        object.LeftSide.y -= 126*1;

    }
}
