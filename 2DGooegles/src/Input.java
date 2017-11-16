/*-----------------------------
 * Contributors: Noah Williams
 * Date Created: 9/23/2017
 * Last Updated 9/26/2017
 * 
 * Purpose: Handles the inputs.
 -----------------------------*/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Input implements KeyListener {
	
	//Creates DataInputs. Based off of GamePad Layouts 
	public DataInput up;
	public DataInput down;
	public DataInput left;
	public DataInput right;
	public DataInput A;
	public DataInput B;
	public DataInput X;
	public DataInput Y;
	public DataInput L;
	public DataInput R;
	public DataInput start;
	public DataInput select;
	
	ArrayList<DataInput> Inputs = new ArrayList<DataInput>();
	ArrayList<DataInput> ReferenceInputs = new ArrayList<DataInput>();
	
	//--------------------------------------------
	//Adds those inputs into ArrayList.
	public Input()
	{
		// DataInput Initalize default Vars
		up = new DataInput(KeyEvent.VK_UP);
		down = new DataInput(KeyEvent.VK_DOWN);
		left = new DataInput(KeyEvent.VK_LEFT );
		right = new DataInput(KeyEvent.VK_RIGHT );
		A = new DataInput(KeyEvent.VK_Z);
		B = new DataInput(KeyEvent.VK_X);
		X = new DataInput(KeyEvent.VK_A);
		Y = new DataInput(KeyEvent.VK_S);
		L = new DataInput(KeyEvent.VK_Q);
		R = new DataInput(KeyEvent.VK_W);
		start = new DataInput(KeyEvent.VK_ENTER);
		select = new DataInput(KeyEvent.VK_SHIFT);
		
		Inputs.add(down);
		Inputs.add(up);
		Inputs.add(right);
		Inputs.add(left);
		Inputs.add(A);
		Inputs.add(B);
		Inputs.add(X);
		Inputs.add(Y);
		Inputs.add(L);
		Inputs.add(R);
		Inputs.add(start);
		Inputs.add(select);
	}
	
	//Remaps the button. User can remap buttons at anytime.
	//Method to remap.
	public void remap(DataInput button, int keyEvent)
	{
		button.setInput(keyEvent);
	}
	
	
	// Method to add Key events
	// @param keyevent is the KeyEvent int that specifies a certain key
	public void addKeyEvent(int keyEvent) {
		Inputs.add(new DataInput(keyEvent));
	}
	
	//updates the inputs if needed.
	public void update()
	{
		
	}
	
	//Flushes the press input.
	public void flush()
	{
		if (ReferenceInputs.isEmpty());
		else
		{
			for (DataInput input : ReferenceInputs )
			{
				input.setPress(false);
			}
			ReferenceInputs.clear();
		}
	}

	//--------------------------------------
	//Standard Keyboard listener methods. Sets input to true or false.
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//System.out.println("Key pressed is: " + keyCode);
		for(DataInput input: Inputs ){
			if(keyCode == input.getInput())
			{
				input.setPressed(true);
				input.setPress(true);
				ReferenceInputs.add(input);
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		for(DataInput input: Inputs ){
			if(keyCode == input.getInput())
			{
				input.setPressed(false);
				input.setPress(false);
				//input.setSignal((byte)0x00);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// not using
		
	}

}
