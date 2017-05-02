
import java.awt.*;
import javax.swing.*;


public class ControlPanel extends JPanel 
{
	  private int width, height;
	  private int panelNum;
	  
	  public ControlPanel(int width, int height)
	   {
	       this.width = width;
	       this.height = height;
	       panelNum = 2; //the number of panels is 2

	       GenMapPanel genMapPanel = new GenMapPanel();
	       IslMapPanel islMapPanel = new IslMapPanel();
	       JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, genMapPanel, right);
	       
      setPreferredSize(new Dimension(width,height));
	    }
}
  

