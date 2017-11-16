package com.muuchi.game;

/**
 * Created by Noah on 11/12/2017.
 */

public class SleepWait {
    public double FPS = 60.0; //FRAMES PER SECOND.
    public static int frames;
    private boolean running = false; //Decides if game is still running
    private Thread thread; //The thread for running the game.

    public SleepWait(){

        create();
    }
    public void create(){

        thread = new Thread((Runnable) this);
        thread.start();
    }
    //Part of Runnable. Will run as soon as game starts.
    public void run()
    {
        thread = new Thread((Runnable) this);
        //Math to get ticks updating at 60FPS.
        int CPS = 0;
        long lastTime = System.nanoTime();
        double nanosec = 1000000000 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();

        frames = 0;

        //Game loop:
        while(running)
        {
            long current = System.nanoTime();
            delta += (current - lastTime) / nanosec;
            lastTime = current;

            //updates every frame. at an indetermined rate, sometimes influenced
            //by computer.
            while(delta >= 1)
            {
                frames++;
                delta--;
            }

            //updates every CPS.
            if(running)
                CPS++;

            //Updates every full FPS cycle. At a fixed rate.
            if(System.currentTimeMillis() - timer > 1000)
            {
                //FOR TESTING CYCLES SPEED / FPS.
                System.out.println("CPS: " + CPS + " FPS: " + frames);
                frames = 0;
                CPS = 0;
                timer += 1000;
            }
        }
    }
}
