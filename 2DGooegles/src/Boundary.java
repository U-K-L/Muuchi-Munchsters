/*
 * Authors: Noah Williams
 * 
 * Last Updated: 10/17/2017
 * Date Created: 10/17/2017
 * 
 * Purpose: Boundary for collisions. Create graph points in which
 * are detected for collision map.
 */
public class Boundary {
	
	//This is the matrix. Stores the abstract list of points.
	public int[][] matrix;
	
	
	//--------------------------------------------
	//Constructor
	//--------------------------------------------
	//Defaults the boundary to a hexagon.
	//Example:  . . .
	//         .  .  .
	//          . . .
	public Boundary(AnimatedObject obj)
	{
		int width = obj.texture.image.getWidth();
		int height = obj.texture.image.getHeight();
		
		matrix = new int[][] 
		{ 
			//2D MATRIX. Y ROWS, X Columns.
			//For each element in Y cell, add X cell.
			
			{0,        				0 + (width/3), width/2, width - (width/3)}, 
			{height/2, 				0 + (width/7), width/2, width - (width/7)}, 
			{height - (height/7),   0 + (width/3), width/2, width - (width/3)},
		};
		
		
	}
	
	//List of X/Y points for the object.
	public void setBoundary(int[][] matry)
	{
		this.matrix = matry;
	}

}
