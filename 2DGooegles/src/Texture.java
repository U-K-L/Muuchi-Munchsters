/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Draws the images to the screen.
 -----------------------------*/
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Texture {
	
	
	//Creates string, filename, paths, a buffered image, and graphics.
	public final static Map<String, Texture> textureMap = new HashMap<String, Texture>();
	public BufferedImage image;
	public String filename;
	private String path;
	public Graphics2D graphic;
	
	
	//Loads the file image.
	public Texture(String Path, String fileName)
	{
		path = Path;
		filename = fileName;
		try {
			image = ImageIO.read(new File (path));
			textureMap.put(filename, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//Renders the file image.
	public void render(Graphics2D g, int x, int y)
	{
		if(image != null)
		{
			this.graphic = g;
			graphic.drawImage(image, x, y, null);
		}
		
	}
	
}
