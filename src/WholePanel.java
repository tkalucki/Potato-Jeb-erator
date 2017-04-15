
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel 
{
   private Color currentColor;
   private CanvasPanel canvas;
   private JPanel leftPanel;
   private JButton clear;
   private ArrayList pointList;
   private IslandCircle[] islands;
   private Point pt;
   private int count;


  public WholePanel(IslandCircle[] islands) {
	  this.islands = islands;
      currentColor = Color.BLACK;
      pointList = new ArrayList();
      count = 0;
//      clear = new JButton ("Clear");
//      leftPanel = new JPanel();
//      leftPanel.setLayout(new GridLayout(3,1));
//      leftPanel.add(clear);
      canvas = new CanvasPanel();
      //canvas.addMouseListener(new PointListener());

      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, canvas);
      setLayout(new BorderLayout());
      add(sp);
}

//CanvasPanel is the panel where shapes will be drawn
  private class CanvasPanel extends JPanel
   {
      //this method draws all shapes
      public void paintComponent(Graphics page)
       {
        super.paintComponent(page);
        setBackground(Color.CYAN);
        for(int i = 0; i<islands.length; i++)
        {
        	//unscaled, to use set bounds for random generation to 800 in PanelMain
        	//page.drawOval(islands[i].getX(), islands[i].getY(), islands[i].getR(), islands[i].getR());
        	
        	//scaled from 2000 to 800 by multiplying by 0.4
        	page.setColor(Color.GREEN);
        	int x = (int) (islands[i].getX()*0.4);
        	int y = (int) (islands[i].getY()*0.4);
        	int r = (int) (islands[i].getR()*0.4);
        	page.fillOval(x, y, r, r); //draw green island
        	page.setColor(Color.BLACK);
        	page.drawOval(x, y, r, r); //draw black border

        }
        //pixel size check
        Dimension appletSize = this.getSize();
        int appletHeight = appletSize.height;
        int appletWidth = appletSize.width;
        
        page.drawString("This applet is " + appletHeight + 
          " pixels high by " + appletWidth + " pixels wide.", 
          15, appletHeight/2);
        /*
        int gridWidth = (int)(this.getSize().getWidth()/(4.0));
        int gridHeight = (int)(this.getSize().getHeight()/(4.0)); 
        for (int i=1; i< 4; i++)
        {
        page.drawLine(0,gridHeight*i,(int)(getSize().getWidth()),gridHeight*i);
        page.drawLine(gridWidth*i,0,gridWidth*i,(int)(getSize().getHeight()));
        }
        */
        
  	    }
       }
    } //end of CanvasPanel class


/*   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
    	  if(event.getSource() == clear)
    	  {
    		  pointList.clear();
    		  pt = null;
    		  repaint();
    	  }
    	  if(event.getSource() == undo)
    	  {
    		  for (int i = 0; i < oldPList.size(); i++)
    		  {
    			  pointList.set(i, oldPList.get(i));
    		  }
    	  }
      }
   } 
   


   // listener class that listens to the mouse
   public class PointListener implements MouseListener
    {
	 //in case that a user presses using a mouse,
	 //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
    	 pt = event.getPoint();
		 repaint();
      }
     public void mouseReleased (MouseEvent event) {}
     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}
    }
}
*/