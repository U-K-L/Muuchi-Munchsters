package VisionGoggles;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Noah on 11/25/2017.
 */

public class AnimatedObject extends GameObject {

    private float frameDuration = .05f; //How long to animate next frame. Default value.
    private TextureAtlas atlasData;  //Atlas  file.
    private TextureRegion currentFrame; //The current frame.
    private Animation animation; //
    private float elapsed_time = 0f; //How much time has passed since last frame.

    // origins.
    private float origin_x, origin_y;

    //-------------------------------------------
    //Constructors.
    public AnimatedObject(int x, int y, String Path, String atlasRegion, float duration)
    {
        //Name is used for finding the texture.
        super(x,y,Path,atlasRegion);

        texture.dispose();
        frameDuration = duration;
        atlasData = new TextureAtlas("data/" + atlasRegion + ".atlas");

        Array<TextureAtlas.AtlasRegion> runningFrames = atlasData.findRegions(atlasRegion);
        animation = new Animation(frameDuration, runningFrames, Animation.PlayMode.LOOP);

        TextureRegion firstTexture = runningFrames.first();
        origin_x = (Gdx.graphics.getWidth()  - firstTexture.getRegionWidth())  / 2;
        origin_y = (Gdx.graphics.getHeight() - firstTexture.getRegionHeight()) /2;

    }

    //-------------------------------------------
    //Renders the texture at the given frame rate.
    public void render(SpriteBatch batch)
    {
        // Elapsed time
        elapsed_time += Gdx.graphics.getDeltaTime();

        // Getting the frame which must be rendered
        currentFrame = (TextureRegion) animation.getKeyFrame(elapsed_time);
        batch.draw(currentFrame, origin_x, origin_y);
    }

    //-------------------------------------------
    //Disposes the sprite and texture atlas.
    public void dispose()
    {
        super.dispose();
        atlasData.dispose();
    }
}
