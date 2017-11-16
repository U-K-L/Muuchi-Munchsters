/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Displays a Jframe.
 -----------------------------*/

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 2337474485031903566L;
	public static JFrame window;
	
	
	
	public Window(int width, int height, String title, Game game)
	{
		//Create initial values
		window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = new Dimension(width, height);
		window.setPreferredSize(d);
		window.pack();
		
		//Gets those values and returns the borders
		int moreWidth = window.getWidth() - window.getContentPane().getWidth();
		int moreHeight = window.getHeight() - window.getContentPane().getHeight();
		
		//Adjust the window to real size..
		d.width += moreWidth;
		d.height += moreHeight;
		
		window.setPreferredSize(d);
		window.getContentPane().setPreferredSize(d);
		
		window.add(game);
		window.pack();
	
	}
}
