package VisionGoggles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Noah on 1/21/2018.
 */

public class ParticleObject extends GameObject {
    public ParticleEffect[] particles;
    private ParticleEffectPool pool;
    public Array<ParticleEffectPool.PooledEffect> activeParticle;
    private int currentEffect = 0; //Which particle is currently rendering.
    private float speed = 0.2f;
    private boolean continous = false;
    private String[] path;

    public ParticleObject(String ... path){
        this.path = path;
        //Creates particle effects. Gets how many was sent.
        particles = new ParticleEffect[path.length];
        activeParticle = new Array<ParticleEffectPool.PooledEffect>();

        //The first is the particle text file, the second is WHERE to find the texture for the particle.
        for(int i = 0; i < path.length; i++ ) {
            particles[i] = new ParticleEffect();

           particles[i].load(Gdx.files.internal(path[i]), Gdx.files.internal("data"));
           pool = new ParticleEffectPool(particles[i], 10, 1000);
        }
        Z = 2; //Sets above normal objects.
    }

    public void render(SpriteBatch batch)
    {
        super.render(batch);
        particles[currentEffect].draw(batch, speed);

        if(particles[currentEffect].isComplete())
            if(continous == true)
                particles[currentEffect].reset();

    }

    //Starts the particle effect, to get ready to draw.
    public void startEffect()
    {
        particles[currentEffect].start();
    }

    //Starts the particle, but also sets speed.
    public void startEffect(float s)
    {
        setSpeed(s);
        particles[currentEffect].start();
    }

    public void resetEffect()
    {
        particles[currentEffect].reset();
    }

    public void setPosition(float x, float y)
    {
        particles[currentEffect].setPosition(x,y);
    }

    public void setAllPosition(float x, float y)
    {
        for (ParticleEffect part : particles)
            part.setPosition(x,y);
    }

    public void setCurrentEffect(int n)
    {
        currentEffect = n;
    }

    public void setSpeed(float s)
    {
        speed = s;
    }

    public void setContinous(boolean bool)
    {
        continous = bool;
    }

    public float getSpeed()
    {
        return speed;
    }

    public ParticleEffect getParticle()
    {
        return particles[currentEffect];
    }

    //Dispose method.
    public void dispose()
    {
        for (ParticleEffect part : particles)
            part.dispose();
    }
}
