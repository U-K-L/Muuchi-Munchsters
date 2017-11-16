 
public class GameMap extends GameObject{
   
  public GameMap(int x, int y, String Path, String name) 
  { 
    super(x, y, Path, name); 
    //makes map always in the lowest layer.
    Z = -100;
  } 
   
} 