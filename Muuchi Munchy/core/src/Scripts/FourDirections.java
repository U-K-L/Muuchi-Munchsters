package Scripts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.*;

/**
 * Created by Noah on 11/27/2018.
 */

public class FourDirections implements Behavior {
    private GameObject object;
    public FourDirections(GameObject obj){
        object = obj;
    }
    public void start(){

    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            object.translate.velocity.setLength(100);
            object.translate.velocity.setAngle(330);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            object.translate.velocity.setLength(100);
            object.translate.velocity.setAngle(30);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            object.translate.velocity.setLength(100);
            object.translate.velocity.setAngle(210);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            object.translate.velocity.setLength(100);
            object.translate.velocity.setAngle(150);
        }
        else{
            object.translate.velocity.setLength(0.001f);
        }
    }

    @Override
    public void action() {

    }

    public String getName(){
        return "FourDirections";
    }
}
