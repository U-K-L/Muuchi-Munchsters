package VisionGoggles;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Noah on 11/27/2018.
 */
/*
/ A behavior class for all COMPONENTS. This is not for object types!
 */
public interface Behavior {
    void start();
    void update();
    String getName();
}
