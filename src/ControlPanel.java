
import java.awt.*;
import javax.swing.*;


public class ControlPanel extends JPanel 
{
	  private int width, height;
	  
	  public ControlPanel(int width, int height)
	   {
	       this.width = width;
	       this.height = height;

	       GenMapPanel genMapPanel = new GenMapPanel();
	       IslMapPanel islMapPanel = new IslMapPanel();
	       JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, genMapPanel, islMapPanel);
	       sp.setResizeWeight(0.5);
	       add(sp);
	       
      setPreferredSize(new Dimension(width,height));
	    }
}
  

