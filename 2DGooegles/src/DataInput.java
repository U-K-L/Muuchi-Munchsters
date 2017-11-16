/*--------------------------
 * Contributors: Noah Williams
 * Created: 9/23/2017
 * Last updated: 9/26/2017
 * 
 * Description: A data structure for inputs.
 * Int is the keyboard buffer.
 * Boolean bool is whether the input is pressed.
 ------------------------*/
public class DataInput {
	
	private boolean pressed;
	private int keyEvent;
	private boolean press;
	
	public DataInput(int keyEvent)
	{
		this.keyEvent = keyEvent;
	}
	
	public void setInput(int keyEvent)
	{
		this.keyEvent = keyEvent;
	}
	
	public int getInput()
	{
		return keyEvent;
	}
	
	public void setPressed(boolean pressed)
	{				
		this.pressed = pressed;
	}
	
	public boolean pressed()
	{
		return pressed;
	}
	
	public void setPress(boolean press)
	{
		this.press = press;
	}
	
	public boolean press()
	{
		return press;
	}

}
