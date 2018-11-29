package Scripts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.*;

/**
 * Created by Noah on 11/27/2018.
 */

public class MovementTestComponent implements Behavior {
    private GameObject object;

    public MovementTestComponent(GameObject obj){
        object = obj;
    }
    public void start(){

    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            object.translate.velocity.setLength(100);
            object.translate.velocity.setAngle(0);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){

        }
        else{
            object.translate.velocity.setLength(0.001f);
        }
    }

    public String getName(){
        return "MoveMentTestComponent";
    }

}
