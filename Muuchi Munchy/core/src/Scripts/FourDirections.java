package Scripts;

import Scripts.Commands.Command;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import VisionGoggles.*;
import com.badlogic.gdx.math.Vector2;
import maps.TutorialStage;

/**
 * Created by Noah on 11/27/2018.
 */

public class FourDirections implements Behavior {
    private GameObject object;
    private boolean playerCanMove = false;

    private int Right = 0;


    private int Down = 0;
    private int Left = 0;

    private int Up = 0;
    private float stepSize = 94.4f;
    private Vector2 startPos;
    private Vector2 destination;
    public float speed = 80f;

    enum Angles{ UP, DOWN, LEFT, RIGHT }
    public Angles angles;
    private CommandLinkedList commandList;
    public FourDirections(GameObject obj, CommandLinkedList commands)
    {
        commandList = commands;
        object = obj;
        startPos = new Vector2(object.x, object.y);
        destination = new Vector2(object.x, object.y);

        commandList.head = commandList.CommandsList.poll();
    }

    public void start(){
    }
    public void noMove(){
        object.translate.velocity.setLength(0.001f);
        System.out.println("No move");
        Up = 0;
        Down = 0;
        Left = 0;
        Right = 0;
    }

    public void update(){

        //checkCommands();
        //decideCommand();
    }

    public int checkCommands(){
        if(commandList.head != null){
            switch(commandList.head.getName()){
                case "UP":
                    setUp(1);
                    commandList.head = null;
                    return TileNode.UP;
                    //break;
                case "DOWN":
                    setDown(1);
                    commandList.head = null;
                    return TileNode.DOWN;
                    //break;
                case "RIGHT":
                    setRight(1);
                    commandList.head = null;
                    return TileNode.RIGHT;
                    //break;
                case "LEFT":
                    setLeft(1);
                    commandList.head = null;
                    return TileNode.LEFT;
                    //break;
                case "NOMOVE":
                    noMove();
                    commandList.head = null;
                    return -2;
                    //break;
                default:
                    return -2;
                    //break;
            }

        }
        return -2;
    }

    public void decideCommand(){
        if(playerCanMove){
            playerInputMove();
        }
        else if(Down > 0){
            MoveDown();
        }
        else if(Up > 0){
            MoveUP();

        }
        else if(Right > 0){
            MoveRight();
        }
        else if(Left > 0){
            MoveLeft();
        }
        else
            object.translate.velocity.setLength(0.001f);
    }

    public void MoveDown(){
        object.translate.velocity.setLength(speed);
        object.translate.velocity.setAngle(getAngle(Angles.DOWN));
        startPos.x = object.x;
        startPos.y = object.y;

        if(reachDestination()) {
            Down--;
            if(Down > 0) {
                changeDestination(Angles.DOWN);
            }
            else {
                if(object.currentNode.getRightNode(SceneManager.mapMatrix) != null)
                    object.currentNode = object.currentNode.getRightNode(SceneManager.mapMatrix);
            }
        }


    }

    public void MoveUP(){
        object.translate.velocity.setLength(speed);
        object.translate.velocity.setAngle(getAngle(Angles.UP));
        startPos.x = object.x;
        startPos.y = object.y;

        if(reachDestination()) {
            Up--;
            if(Up > 0)
            {
                changeDestination(Angles.UP);
            }
            else {
                if(object.currentNode.getLEFTNode(SceneManager.mapMatrix) != null)
                    object.currentNode = object.currentNode.getLEFTNode(SceneManager.mapMatrix);
            }
        }
    }

    public void MoveRight(){
        object.translate.velocity.setLength(speed);
        object.translate.velocity.setAngle(getAngle(Angles.RIGHT));
        startPos.x = object.x;
        startPos.y = object.y;

        if(reachDestination()) {
            Right--;
            if(Right > 0)
                changeDestination(Angles.RIGHT);
        }
    }

    public void MoveLeft(){
        object.translate.velocity.setLength(speed);
        object.translate.velocity.setAngle(getAngle(Angles.LEFT));
        startPos.x = object.x;
        startPos.y = object.y;

        if(reachDestination()) {
            Left--;
            if(Left > 0)
                changeDestination(Angles.LEFT);
        }

    }

    public void setRight(int right) {
        changeDestination(Angles.RIGHT);
        Right = right;
    }

    public void setLeft(int left) {
        changeDestination(Angles.LEFT);
        Left = left;
    }

    public void setUp(int up) {
       // if(nodeCollide()){
            changeDestination(Angles.UP);
            Up = up;
        //}

    }

    public void setDown(int down) {
        changeDestination(Angles.DOWN);
        Down = down;
    }


    public boolean nodeCollide(TileNode node, int direction, float[][] mapMatrix){
        switch(direction){
            case TileNode.DOWN:
                //if(node.getDOWNNode().getheight() > 0)
                return checkDownNode(node, mapMatrix);
                //break;
            case TileNode.UP:
                return checkUpNode(node, mapMatrix);
                //break;
            case TileNode.RIGHT:
                return checkRightNode(node, mapMatrix);
            case TileNode.LEFT:
                return checkLeftNode(node, mapMatrix);
        }
        return false;
    }

    private boolean checkUpNode(TileNode node, float[][] mapMatrix){
        if(node != null)
            if(node.getLEFTNode(mapMatrix) != null) {
                if (node.getLEFTNode(mapMatrix).STATE > 0) //LEFT IS UP WITHIN THE MATRIX
                    return true;
                else{
                    CONDITIONS.LOSE();
                    return false;
                }
            }
            else {
                return false;
            }
            return false;
    }

    private boolean checkDownNode(TileNode node, float[][] mapMatrix){
        if(node != null)
            if(node.getRightNode(mapMatrix) != null) {
                if (node.getRightNode(mapMatrix).STATE > 0) //LEFT IS UP WITHIN THE MATRIX
                    return true;
                else{
                    CONDITIONS.LOSE();
                    return false;
                }
            }
            else {
                return false;
            }
        return false;
    }

    private boolean checkRightNode(TileNode node, float[][] mapMatrix){
        if(node != null)
            if(node.getRightNode(mapMatrix) != null) {
                if (node.getRightNode(mapMatrix).STATE > 0) //LEFT IS UP WITHIN THE MATRIX
                    return true;
                else{
                    CONDITIONS.LOSE();
                    return false;
                }
            }
            else {
                return false;
            }
        return false;
    }

    private boolean checkLeftNode(TileNode node, float[][] mapMatrix){
        if(node != null)
            if(node.getRightNode(mapMatrix) != null) {
                if (node.getRightNode(mapMatrix).STATE > 0) //LEFT IS UP WITHIN THE MATRIX
                    return true;
                else{
                    CONDITIONS.LOSE();
                    return false;
                }
            }
            else {
                return false;
            }
        return false;
    }



    public void changeDestination(Angles angle){
        destination.x += stepSize*Math.cos(Math.toRadians(getAngle(angle)));
        destination.y += stepSize*Math.sin(Math.toRadians(getAngle(angle)));
    }

    private boolean reachDestination(){
        if(checkDistance() <= 70f){
            commandList.head = commandList.CommandsList.poll();
            System.out.println("hi");
            return true;
        }
        return false;
    }

    private float checkDistance(){
        float sum = 0;
        sum += (float)Math.pow( (double)(destination.x - startPos.x), 2.0);
        sum += (float)Math.pow( (double)(destination.y - startPos.y), 2.0);
        return (float)Math.sqrt(sum);

    }

    void playerInputMove(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            object.translate.velocity.setLength(speed);
            object.translate.velocity.setAngle(getAngle(Angles.RIGHT));
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            object.translate.velocity.setLength(speed);
            object.translate.velocity.setAngle(getAngle(Angles.UP));
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            object.translate.velocity.setLength(speed);
            object.translate.velocity.setAngle(getAngle(Angles.DOWN));
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            object.translate.velocity.setLength(speed);
            object.translate.velocity.setAngle(getAngle(Angles.LEFT));
        }
        else{
            object.translate.velocity.setLength(0.001f);
        }
    }

    private float getAngle(Angles angle){
        switch (angle){
            case UP:
                return 30;
            case DOWN:
                return 210;
            case LEFT:
                return 150;
            case RIGHT:
                return 330;
        }
        return 0;
    }


    public int getRight() {
        return Right;
    }

    public int getDown() {
        return Down;
    }

    public int getLeft() {
        return Left;
    }

    public int getUp() {
        return Up;
    }


    @Override
    public void action() {

    }

    public String getName(){
        return "FourDirections";
    }
}
