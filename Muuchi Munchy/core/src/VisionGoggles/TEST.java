package VisionGoggles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class TEST extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Sprite leftSprite;
    Sprite rightSprite;
    String vertexShader;
    String fragmentShader;
    ShaderProgram shaderProgram;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("images/badlogic.jpg");
        leftSprite = new Sprite(img);
        rightSprite = new Sprite(img);

        leftSprite.setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        leftSprite.setPosition(0,0);
        rightSprite.setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
        rightSprite.setPosition(Gdx.graphics.getWidth()/2,0);

        vertexShader = Gdx.files.internal("shaders/basic.glsl").readString();
        fragmentShader = Gdx.files.internal("shaders/basicFrag.glsl").readString();
        shaderProgram = new ShaderProgram(vertexShader,fragmentShader);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setShader(null);
        batch.begin();
        batch.draw(leftSprite, leftSprite.getX(), leftSprite.getY(), leftSprite.getWidth(), leftSprite.getHeight());
        batch.end();

        batch.setShader(shaderProgram);
        batch.begin();
        batch.draw(rightSprite, rightSprite.getX(), rightSprite.getY(), rightSprite.getWidth(), rightSprite.getHeight());
        batch.end();
    }
}