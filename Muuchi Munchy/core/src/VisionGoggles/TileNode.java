package VisionGoggles;

import Prefabs.Tile;

import java.util.ArrayList;
import java.util.HashMap;
//UP = 2, DOWN = 3, LEFT = -1, RIGHT = 1, CENTER IS 0.

public class TileNode {

    public int STATE = 0;
    public Tile mainNode;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int CENTER = 0;
    private int centerIndex;

    public HashMap<Integer, Tile> adjacent;
    public TileNode(int index, Tile tile, int state){
        centerIndex = index;
        adjacent = new HashMap<Integer, Tile>();
        mainNode = tile;
        adjacent.put(CENTER, tile);
        STATE = state;
    }

    public void addRightNode(ArrayList<Tile> tiles){
        //checks right of node.
        if(centerIndex + 1 < tiles.size()){
            adjacent.put(RIGHT, tiles.get(centerIndex +1));
        }
    }

    public Tile getRightNode(){
        return adjacent.get(RIGHT);
    }


    public void addLEFTNode(ArrayList<Tile> tiles){
        //checks left of node.
        if(centerIndex - 1 >= 0){
            adjacent.put(LEFT, tiles.get(centerIndex -1));
        }
    }

    public Tile getLEFTNode(){
        return adjacent.get(LEFT);
    }


    public void addUPNode(ArrayList<Tile> tiles, float[][] mapMatrix){
        //check the above node!
        if( (centerIndex - mapMatrix[0].length) >= 0){
            adjacent.put(UP, tiles.get(centerIndex - mapMatrix[0].length));
        }
    }

    public Tile getUPNode(){
        return adjacent.get(UP);
    }

    public void addDOWNNode(ArrayList<Tile> tiles, float[][] mapMatrix){
        //check the above node!
        if( (centerIndex + mapMatrix[0].length) < tiles.size()){
            adjacent.put(DOWN, tiles.get(centerIndex + mapMatrix[0].length));
        }
    }

    public Tile getDOWNNode(){
        return adjacent.get(DOWN);
    }
}
