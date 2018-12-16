package Prefabs;

import Scripts.Dimensions;
import Scripts.FourDirections;
import VisionGoggles.GameObject;
import VisionGoggles.Scene;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tile extends GameObject {
    public Dimensions dimension;
    public GameObject RightSide;
    public GameObject LeftSide;
    public GameObject Block;
    public ArrayList<GameObject> Blocks;
    public Tile(){
        super(0, 0,2, "images/IsoBlock.png", "tile");
        this.setShow(false);
        Z = 2;
        dimension = new Dimensions(this);
        AddComponent(dimension);

        Blocks = new ArrayList<GameObject>();
        Block = new GameObject(0, 0, 2, "images/IsoBlock.png", "tileBlock");
        RightSide = new GameObject(0, 0, 2, "images/RightFace.png", "tileRight");
        LeftSide = new GameObject(0, 0,2, "images/LeftFace.png", "tileLeft");
        RightSide.setShow(false);
        LeftSide.setShow(false);
        Block.setShow(false);
    }

    public void addSelf(Scene scene){

        scene.addObjects(RightSide, LeftSide, Block, this);

    }

    public void addBlock(GameObject obj, Scene scene){
        Blocks.add(obj);
        scene.addObjects(obj);
    }
}