/*
 * Authors: Noah Williams
 * 
 * Last Updated: 10/15/2017
 * Date Created: 10/13/2017
 * 
 * Purpose: Create HashMap file of passability for all maps.
 * Goes to folder and reads through files. 
 * Looks through image. Finds all RGBA values. Checks if above limit.
 * 
 * To use: Call it in game, delete afterwards. Only need to do once.
 * 
 * To use for Maps: Leave all objects that are not passable in the image.
 * Image must be map name with: $ at the beginning. MAP NAME NOT MAP'S
 * IMAGE NAME!!!
 */
import java.util.HashMap;

import java.util.Map;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.Color;

public class CollisionMapGen {
	
	//--------------
	//The hashMap of map passable data.
	public static Map<String, byte[][]> CollisionMaps = new HashMap<String, byte[][]>();
	private transient BufferedImage image; //The dummy buffered image.
	
	public transient byte[][] collisionMap; //the dummy collision map. 
	private transient int index_x = 0; //The index of the column. 
	private transient Color color; //The color class for checking values.
	private transient String HashKey; //Each hashkey for retriving data.

	
	//------------------------------------
	//Constructor.
	public CollisionMapGen()
	{
		
	}
	
	//-----------------------------------------------
	// Generator. Provide path to folder containing collision $maps.
	//-----------------------------------------------
	// Generates the files collision maps
	//-----------------------------------------------
	public void GenerateCollisionMaps(String path)
	{	
		//Path is a path to a folder not a file.
		File folder = new File(path);
		
		
		//------------------------------
		//Looks through folder getting every file.
		for(File file: folder.listFiles() )
		{
			
			//Tries to get an image, instead of another file.
			try {
				image = ImageIO.read(new File (file.getAbsolutePath()));
				HashKey = file.getName();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("FILE WAS NOT AN IMAGE.ONLY IMAGES WITH ALPHA VALUES");
				System.exit(1);
			}
			
			
			//Slices the map into an array.
			collisionMap = new byte[image.getHeight()][image.getWidth()];
			
			
			//Begins to generate maps. Index starts pixel location.
			index_x = 0;
			generate(collisionMap, index_x);
			
		}// end the for loop.
		
	}// end public constructor.
	
	
	//-------------------------------------------
	// Algorithm for constructing the files.
	// Generates collision maps.
	//-------------------------------------------
	public void generate(byte[][] map, int r)
	{
		//recursive loop. Matrix, r rows, c columns.
		for(int c = 0; c < map[0].length; c++ )
		{
			color = new Color(image.getRGB(c, r), true);
			
			//Magic number decides how much alpha is ignored.
			//Opacity must be greater than 50.
			if(color.getAlpha() > 50)
				map[r][c] = 0x01;
		}
		
		
		//map.length is ever so slightly more than the array.
		//Calls upon itself. If row is less than map's length.
		if(r < map.length - 1)
			generate(map, r+1);
		
		//store the end result.
		CollisionMaps.put(HashKey, map);
	}
	
	
	
	//----------------------------------------
	//Ouputs a serialized file.
	//PROVIDE WHERE THE OUTPUT SHOULD GO!!!
	//----------------------------------------
	public void output(String path)
	{
		
		//Attempts all of it...
		try{
			//create file, Names it ColideMap.ser.
			FileOutputStream FileOutput =  new FileOutputStream(path+"/ColideMap.ser");
			
			//Makes file an outputStream.
			ObjectOutputStream Output = new ObjectOutputStream(FileOutput);
			
			//Write the outputStream to the file.
			Output.writeObject(CollisionMaps);
			
			//Flush garbage.
			Output.flush();
			
			//Closes the files.
			Output.close();
			FileOutput.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//--------------------------------------
	// Gets file and reads the HashMap.
	// PATH SHOULD BE WHERE THE collideMap.ser
	// WENT TO!!!
	//--------------------------------------
	@SuppressWarnings("unchecked")
	public void input(String path)
	{
		//SUPRESSED ERROR: unchecked if input is BYTE. 
		//ALWAYS MAKE MAPS FILLED WITH BYTE.
		
		//Tries all below...
		try{
			
			//Create input file.
			FileInputStream FileInput = new FileInputStream(path);
			
			//Turns input file into an InputStream.
			ObjectInputStream Input = new ObjectInputStream(FileInput);
			
			//HashMap: CollisionMaps becomes the HasMap inside InputStream.
			CollisionMaps = (HashMap<String, byte[][]>)Input.readObject();
			
			//Closes the files
			Input.close();
			FileInput.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
