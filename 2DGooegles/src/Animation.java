/*
 * Authors: Noah Williams
 * Last Updated: 10/15/2017
 * Date Created: 10/15/2017
 * 
 * Purpose: Handles all Graphics animations.
 * Including rotations, scaling, resizing,
 * collisions, movement detectors.
 * Every LiveObject has its own animator.
 */
public class Animation {
	
	//Movement detector.
	//Checks if the target has moved.
	private boolean hasMoved;
	
	//---------------------
	//Constructor.
	public Animation()
	{
		
	}
	
	//------------------------------------------------
	//Returns current moving target. Moves the target, by
	//checking collision path.
	public boolean move(int x, int y, AnimatedObject object)
	{
			hasMoved = Game.collide.move(x, y, object);
			return hasMoved;
		
	}

}
