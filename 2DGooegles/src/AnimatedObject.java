/*
 * Authors: Noah Williams
 * 
 * Last Updated: 10/15/2015
 * Date Created: 10/15/2015
 * 
 * Purpose: Subclass of an Object. Decides if Object is animated or not.
 */
public class AnimatedObject extends GameObject {
	
	//Value of how solid, what kind of form it has. -200 means gaseous, while 200 means perfectly solid.
	//If this is above 0, it will collide normally.
	public int Solidness = 100;
	public Animation animate;
	
	public Boundary boundary; //The matrix. Sets where to collide.

	//-------------------------------------------------------------
	//Calls parent class. AnimatedObjects each have an animator.
	public AnimatedObject(int x, int y, String Path, String name) {
		super(x, y, Path, name);
		
		animate = new Animation();
		boundary = new Boundary(this);
		
	}
	
	
	//Moves the object.
	public void move(int x, int y)
	{
		animate.move(x, y, this);
	}
	
	//Get the solidness
	public int getSolid()
	{
		return Solidness;
	}
	
	//Set how solid
	public void setSolid(int form)
	{
		this.Solidness = form;
	}
	

}
