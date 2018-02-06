package VisionGoggles;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Noah Williams on 12/27/2017.
 *
 * Purpose: The basic camera.
 */

public class Camera implements ApplicationListener {

    public OrthographicCamera cam;

    public Camera() {
        create();
    }

    @Override
    public void create() {
        cam = new OrthographicCamera();
        cam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        cam.setToOrtho(false);
        cam.zoom = 2.4f;
        cam.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
