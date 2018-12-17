package VisionGoggles;

import Prefabs.Tile;

import java.util.ArrayList;
import java.util.HashMap;
//UP = 2, DOWN = 3, LEFT = -1, RIGHT = 1, CENTER IS 0.

public class TileNode {

    public int STATE = 0;
    public TileNode mainNode;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int CENTER = 0;
    public Tile tile;
    private int centerIndex;

    public HashMap<Integer, TileNode> adjacent;
    public TileNode(int index, int state, Tile tile){
        centerIndex = index;
        adjacent = new HashMap<Integer, TileNode>();
        mainNode = this;
        adjacent.put(CENTER, this);
        STATE = state;
        this.tile = tile;
    }

    public void addRightNode(ArrayList<TileNode> tiles, TileNode node){
        //checks right of node.
        if(centerIndex + 1 < tiles.size()){
            adjacent.put(RIGHT, tiles.get(centerIndex + 1));
        }
    }

    public TileNode getRightNode(float[][] mapMatrix){
        if(mapMatrix[0].length > (RIGHT + centerIndex))
            return adjacent.get(RIGHT);

        System.out.println("NULL");
        return null;
    }

    public void addLEFTNode(ArrayList<TileNode> tiles, TileNode node){
        //checks right of node.
        if(centerIndex - 1 >= 0){
            adjacent.put(LEFT, tiles.get(centerIndex + LEFT));
        }
    }

    public TileNode getLEFTNode(float[][] mapMatrix){
        if(0 <= (centerIndex + LEFT))
            return adjacent.get(LEFT);

        System.out.println("NULL");
        return null;
    }

    public void addUPNode(ArrayList<TileNode> tiles, TileNode node){
        //check the above node!
        if( (centerIndex - SceneManager.mapMatrix[0].length) >= 0){
            adjacent.put(UP, tiles.get(centerIndex - SceneManager.mapMatrix[0].length));
        }
    }

    public TileNode getUPNode(){
        return adjacent.get(UP);
    }

    public void addDOWNNode(ArrayList<TileNode> tiles, TileNode node){
        //check the above node!
        if( (centerIndex + SceneManager.mapMatrix[0].length) < tiles.size()){
            adjacent.put(DOWN, tiles.get(centerIndex + SceneManager.mapMatrix[0].length));
        }
    }

    public TileNode getDOWNNode(){
        return adjacent.get(DOWN);
    }


/*
    public void addLEFTNode(ArrayList<Tile> tiles){
        //checks left of node.
        if(centerIndex - 1 >= 0){
            adjacent.put(LEFT, tiles.get(centerIndex -1));
        }
    }

    public TileNode getLEFTNode(){
        return adjacent.get(LEFT);
    }
    */
}
