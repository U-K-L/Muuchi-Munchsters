/*
 * Author Noah Williams
 * 
 * Date Created 11/13/2015
 * 
 * Purpose: Creates the top menu bar as well as the items.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Header {
	
	private JMenuBar menuBar; //The entire menu bar.
	private JMenu Load; //Loads the Menu scenes.
	private JMenu Save; //Loads the Menu scenes.
	
	private JMenuItem Scene; //menu items
	private ButtonListener btn; //listener.
	
	public static JFileChooser Jfile; //File dialog
	
	//------------------------------
	//Constructor. Creates the various items needed.
	public Header()
	{
		//Build items. Start listener.
		btn = new ButtonListener();
		buildItems();
		buildHeader();
		buildListeners();
		
		
		//----------------------------------
		//Applies JSON filter.
		Jfile = new JFileChooser("C:/Muuchi Munchi/Infinite Pies/Muuchi Munchy");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", "json");
		Jfile.setFileFilter(filter);
		
		
		//-----------------------
		//Adds item and pack window.
		Load.add(Scene);
		Window.window.pack();
		
	}
	
	
	//Build the menu.
	private void buildItems()
	{
		Load = new JMenu("Load");
		Load.setMnemonic(KeyEvent.VK_F);
		
		Save = new JMenu("Save");
		Save.setMnemonic(KeyEvent.VK_S);
	}
	
	
	//Create header.
	private void buildHeader()
	{
		//Create menuBar
		menuBar = new JMenuBar();
		
		menuBar.add(Load);
		menuBar.add(Save);
		
		Window.window.setJMenuBar(menuBar);
		
		
	}
	
	//Builds listener objects.
	public void buildListeners()
	{
		Scene = new JMenuItem("Scenes");
		Scene.addActionListener(btn);
		
		Save.addMenuListener(new mListen());
	}

	
	//Creates listen class.
	private class ButtonListener implements ActionListener
	{

		//-----------------------------
		//Performs actions.
		@Override
		public void actionPerformed(ActionEvent act) { loadJson(); }
		
		
		//Load Json data.
		public void loadJson(){
			
			if(Jfile.showOpenDialog(menuBar) == 0)
			{
				Game.defaultScene.filePath = Jfile.getSelectedFile().getPath();
				Game.defaultScene.LoadJson();
			}
		}
		
	}//ends the ButtonListener.
	
	
	//Mouse listener for certain items.
	private class mListen implements MenuListener
	{


		@Override
		public void menuCanceled(MenuEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuDeselected(MenuEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuSelected(MenuEvent arg0) {
			
			if(DefaultScene.DScene != null)
			{
				try{
					ExportScene.sceneToJson(Game.defaultScene, Game.defaultScene.DScene.getName());
				}
				catch(Exception e){}
			}
		}
		
	}

}
