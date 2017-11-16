/*
 * Authors: Noah Williams
 * 
 * Last Updated: 10/15/2017
 * Date Created: 10/13/2017
 * 
 * Purpose: Detects if the loaded collision map encounters
 * a collision. Checks animator.
 */
public class CollisionMap {

	public int grid = 1; //Creates a grid. Makes game faster, but accuracy less.
	public static byte[][] MapDimension; //The map's pass values. Loaded from generated ser file
	private int mapWidth; //Allocates the needed memory.
	private int mapHeight;
	private int px; //The positions of the map array
	private int py;
	private int[][] boundary; //Matrix detector.
	
	public CollisionMap()
	{
		
	}
	
	//------------------------------
	//Updates the collision map, specifies grid.
	//Gets information about map's size.
	public void updateMap()
	{
		
		mapWidth = SceneManager.currentScene.map.texture.image.getWidth();
		mapHeight = SceneManager.currentScene.map.texture.image.getHeight();
		
		//TODO: Add a grid system.
		//int mapGridWidth = mapWidth / grid;
		//int mapGridHeight = mapHeight / grid;;
		
	}
	
	public boolean collide(int x, int y)
	{
		if(y >= mapHeight || x >= mapWidth || y < 0 || x < 0)
			return false;
		
		if(MapDimension[y][x] == 0x00)
			return true;
		
		return false;
	}
	
	
	//-------------------------------------------------
	//Called anytime animtor decides to move.
	public boolean move(int x, int y, AnimatedObject object)
	{	
		//Checks the position index. Checks ahead before allowing.
		px = (object.x + x) / grid;
		py = (object.y + y) / grid;
		
		boundary = object.boundary.matrix;
		
		//If going beyond the screen, or the map. Creates boundaries.
		if( object.x + x < 0 || object.x + x >= mapWidth || object.y + y < 0 || object.y + y > mapHeight )
			return false;
		
		try
		{
			//-------------------------------------
			//Goes through the matrix defined inside object.
			//rows/columns
			//r = Y, c = X
			for(int r = 0; r < boundary.length; r++)
			{
				//find the block specified.
				py += boundary[r][0];
				for(int c = 1; c < boundary[1].length; c++)
				{
					//Check that direction.
					px += boundary[1][c];
					
					if(py >= mapHeight || px >= mapWidth || py < 0 || px < 0)
						return false;
					
					//If any point is touching an invalid index.
					if(MapDimension[py][px] == 0x01)
						return false;
					
					//reset for next iteration.
					px -= boundary[1][c];
				}
				py -= boundary[r][0];
			}
			
			//If all goes well. Return that it has moved.
			if(MapDimension[py][px] == 0x00)
			{
				object.x += x;
				object.y += y;
				return true;
			}
			
		
		//If any error occurs. Mostly due to array indexes.
		}catch(Exception e){
				e.printStackTrace();
				return false;
		}
		
		//Base Case.
		return false;
	}
}
