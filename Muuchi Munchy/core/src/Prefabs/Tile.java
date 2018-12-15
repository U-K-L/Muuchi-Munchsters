package Prefabs;

import Scripts.Dimensions;
import Scripts.FourDirections;
import VisionGoggles.GameObject;

public class Tile extends GameObject {
    public Dimensions dimension;
    public Tile(){
        super(0, 0, "images/TopFace.png", "tile");
        Z = 2;
        dimension = new Dimensions(this);
        AddComponent(dimension);

    }
}