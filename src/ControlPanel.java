//Created by: Jackson Allen
//Class Description: Creates and add the two panels that make up the applet to the ControlPanel Panel

import java.awt.*;
import javax.swing.*;


public class ControlPanel extends JPanel 
{
	  private int width, height;
	  public ControlPanel(int width, int height)
	   {
	       this.width = width;
	       this.height = height;

	       GenMapPanel genMapPanel = new GenMapPanel(); //Left side panel
	       IslMapPanel islMapPanel = new IslMapPanel(); //Right side panel
	       JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, genMapPanel, islMapPanel);
	       sp.setResizeWeight(0.5); //Even distribution of space between the two panels
	       add(sp);
	       
      setPreferredSize(new Dimension(width,height));
	    }
}
  

