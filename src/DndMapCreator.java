//Created by: Jackson Allen
//Class Description: Sizes the applet and adds the main panel

import javax.swing.*;

public class DndMapCreator extends JApplet
{
	//size determined to make the canvas areas roughly 800x800
	private final int WIDTH = 1650;
	private final int HEIGHT = 850;
	
	public void init()
	{
		ControlPanel controlPanel = new ControlPanel(WIDTH,HEIGHT);
		getContentPane().add(controlPanel);
		setSize(WIDTH,HEIGHT);
	}
}