package VisionGoggles;

public class CONDITIONS {
    public static enum GAMESTATES{
        PLAY, PAUSE, MENU, VICTORY, GAMEOVER
    }

    public static GAMESTATES GameState = GAMESTATES.PLAY;
    public static void WIN(){

    }

    public static void LOSE(){
        GameState = GAMESTATES.GAMEOVER;
        System.out.println("you lose!");
    }
}
