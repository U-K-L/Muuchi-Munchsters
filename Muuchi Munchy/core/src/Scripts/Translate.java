package Scripts;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import VisionGoggles.*;
/**
 * Created by Noah on 11/28/2018.
 */

public class Translate implements Behavior {
    public Vector2 velocity;
    private GameObject object;
    public Translate(GameObject obj){
        velocity = new Vector2(1,1);


        object = obj;
    }
    public void start(){

    }
    public void update(){
        if(velocity.len() > 0.01f){
            updateX();
            updateY();
            object.x += velocity.x * Gdx.graphics.getDeltaTime();
            object.y += velocity.y * Gdx.graphics.getDeltaTime();
        }



    }

    private void updateX(){
        velocity.x = (float) (Math.cos(Math.toRadians(velocity.angle())) * velocity.len());
    }

    private void updateY(){
        velocity.y = (float) (Math.sin((Math.toRadians(velocity.angle()))) * velocity.len());
    }

    public void setSpeed(float s){
        velocity.setLength(s);
    }

    public String getName(){
        return "Translate";
    }
}
