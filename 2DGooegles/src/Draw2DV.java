/*
 * Contributors: Noah Williams, Robert Adam Severance
 * 
 * Date Created 1/1/2017
 * 
 * Purpose: Graphs rays in particular patterns.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Draw2DV {
	//Decides if the ray collides with object or not.
	private static boolean collide = false;

	
	public static void testLight(Graphics2D g, double center_x, double center_y, double radius, int points)
	{	
		GeneralPath light = new GeneralPath(GeneralPath.WIND_EVEN_ODD, (int)radius *2);
		
		light.moveTo(center_x, center_y); //initial position of light.
		
		/*Let's recall the equation of a circle is:
		 * (x-h)^2 + (y-k)^2 = r^2
		 * 
		 * If we wanted to graph this circle we can solve it.
		 * 
		 * y =  +/- square-root(radius^2 - x^2)
		 * now we have the X/Y coordinates of the circumference.
		 * 
		 * Recall that X cannot be greater than R.
		 */
		
		/*
		 * let's go further ...  we know that the unit circle min/max X/Y values are:
		 * X: (-r, 0) (r, 0)  Y: (0, -r) (0, r) forms a cross --|--
		 * Additionally, we know that any point on the circumference distance from the center
		 * is the radius r.
		 * 
		 * So ... with the unit circle we know x = sqrt(2)/2, y = sqrt(2)/2 gives the mid
		 * between two min/max values, and with circles for every one point found, we get 4 points.
		 * 
		 * some more values:
		 *  x = sqrt(0.5)/2, y = sqrt(4)/2
		 *  x = sqrt(1)/2, y = sqrt(3)/2
		 *  x = sqrt(2)/2, y = sqrt(2)/2
		 *  x = sqrt(3)/2, y = sqrt(1)/2
		 *  x = sqrt(4)/2, y = sqrt(0.5)/2
		 * 	
		 * 	see the pattern? Let's make an algorithm.
		 * 
		 * n = user defined points.
		 * 
		 * sqr =  r^2
		 * 
		 * i = 2 //cuts in half
		 * 
		 * x = sqrt(sqr*2)/2
		 * 
		 */
		
		double y = 0; //The output of the graph. Y coordinate.
		double squared = Math.pow(radius, 2);
		double x = 0;
		
		//--------------------------------------
		//Graphs the circle. X is our x coordinate, input.
		for(double i = 0.00; i <= 4; i += (double)1/points)
		{	
			//This needs some serious clean up.
			//positive
			x = Math.sqrt(squared * i) / 2;
			y =  Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			if(collide == true)
				collideRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			else
				drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			
			//g.drawOval((int)x+  (int)center_x, (int)y +  (int)center_y, 10, 10);
		}
		
		//--------------------------------------
		//Graphs the circle. X is our x coordinate, input.
		for(double i = 4.00; i >= 0; i -= (double)1/points)
		{	
			//This needs some serious clean up.
			//positive
			x = -1 *Math.sqrt(squared * i) / 2;
			y =   Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			if(collide == true)
				collideRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			else
				drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			
			//g.drawOval((int)x+  (int)center_x, (int)y +  (int)center_y, 10, 10);
		}
		
		//--------------------------------------
		//Graphs the circle. X is our x coordinate, input.
		for(double i = 0.00; i <= 4; i += (double)1/points)
		{	
			//This needs some serious clean up.
			//positive
			x = -1 *Math.sqrt(squared * i) / 2;
			y =  -1* Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			if(collide == true)
				collideRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			else
				drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			
			//g.drawOval((int)x+  (int)center_x, (int)y +  (int)center_y, 10, 10);
		}
		
		//--------------------------------------
		//Graphs the circle. X is our x coordinate, input.
		for(double i = 4.00; i >= 0; i -= (double)1/points)
		{	
			//This needs some serious clean up.
			//positive
			x = Math.sqrt(squared * i) / 2;
			y =  -1* Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			if(collide == true)
				collideRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			else
				drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			
			//g.drawOval((int)x+  (int)center_x, (int)y +  (int)center_y, 10, 10);
		}
		
		light.closePath();
		g.draw(light);
		g.fill(light);
	}
	
	
	
	
	
	//------------------------------------------------------------------------------------------
	//The one to be tested.
	public static void roundLight(Graphics2D g, double center_x, double center_y, double radius)
	{	
		GeneralPath light = new GeneralPath(GeneralPath.WIND_EVEN_ODD, (int)radius*2);
		
		light.moveTo(center_x, center_y); //initial position of light.
		
		
		double y = 0; //The output of the graph. Y coordinate.
		
		
		//--------------------------------------
		//Graphs the circle. X is our x coordinate, input.
		for(double x = -radius; x <= radius; x++)
		{	
			
			//Gets the postive square roots.
			y =  Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			//Draws the ray.
			if(collide == true)
				collideRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			else
				drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			
			//Gets the negative square roots.
			y =  (-1 * Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2)) );
			
			//Draws the ray again to account for negative results.
			if(collide == true)
				collideRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			else
				drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);

		}
		light.closePath();
		g.draw(light);
	}
	
	
	
	//Shoots light within a direction.
	public static void directLight(Graphics2D g, double center_x, double center_y, double radius, double vector)
	{	
		GeneralPath light = new GeneralPath(GeneralPath.WIND_EVEN_ODD, (int)radius*2);
		
		light.moveTo(center_x, center_y); //initial position of light.
		
		double y = 0; //The output of the graph. Y coordinate.
		
		for(double x = -radius; x <= radius; x++)
		{	
			
			//Gets the postive square roots.
			y =  Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			//Draws the ray.
			drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
		}
		
		light.closePath();
		g.draw(light);
	}
	
	
	
	//Creates a spot light.
	public static void spotLight(Graphics2D g, double center_x, double center_y, double radius, 
			double start_x, double start_y)
	{	
		GeneralPath light = new GeneralPath(GeneralPath.WIND_EVEN_ODD, (int)radius*2);
		
		light.moveTo(start_x, start_y); //initial position of light.
		
		double y = 0; //The output of the graph. Y coordinate.
		
		
		//--------------------------------------
		//Graphs the circle. X is our x coordinate, input.
		for(double x = -radius; x <= radius; x++)
		{	
			
			//Gets the postive square roots.
			y =  Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
			
			//Draws the ray.
			drawRay(g, center_x, center_y, x, y, light);
			drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
			
			//Gets the negative square roots.
			y =  (-1 * Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2)) );
			
			//Draws the ray.
			drawRay(g, center_x, center_y, x, y, light);
			drawRay(g, center_x, center_y, center_x +x,   center_y+ y, light);
		}
		light.closePath();
		g.draw(light);
	}
	
	
	
	
	//Moves the ray to a coordinate.
	private static void drawRay(Graphics2D g, double x1, double y1, double x2, double y2, GeneralPath light)
	{	
		light.lineTo(x2, y2);
		
	}
	
	
	//Checks if the ray collides.
	public static boolean collideRay(Graphics2D g, double x1, double y1, double x2, double y2, GeneralPath light)
	{
		int px;
		int py;
		
		/*
		//----------------
		//Ray detects collision.
		for(int i = 15; i > 0; i--)
		{
			px = (int)(x1 + x2)/(i+1);
			py = (int)(y1 + y2)/(i+1);
			if( !(Game.collide.collide(px, py)) );
			else if(i < 15)
			{
				drawRay(g, x1, y1, px, py, light);
				return true;
			}
			else{
				return false;
			}
		}
		*/
		px = (int)(x2);
		py = (int)(y2);
		if(Game.collide.collide(px, py))
			;
		else{
			return false;
		}
		drawRay(g, x1, y1, x2, y2, light);
		return true;
	}
	
	
	//Sets collision.
	public static void setCollide(boolean bool)
	{
		collide = bool;
	}
}
