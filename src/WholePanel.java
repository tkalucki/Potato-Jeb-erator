
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;

public class WholePanel extends JPanel 
{

   private CanvasPanel canvas;
   private JPanel BottomPanel;
   private JButton save;
   private IslandCircle[] islands;
   private JLabel label1;
// private ArrayList pointList;
//   private Point pt;
//   private int count;


  public WholePanel(IslandCircle[] islands) {
	  this.islands = islands;
      save = new JButton ("Save");
      save.addActionListener(new ButtonListener());
      label1 = new JLabel();
      BottomPanel = new JPanel();
      BottomPanel.setLayout(new FlowLayout());
      save.setPreferredSize(new Dimension(80,30));
      BottomPanel.add(save);
      BottomPanel.add(label1);
      canvas = new CanvasPanel();
      //canvas.addMouseListener(new PointListener());

      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, canvas, BottomPanel);
      sp.setResizeWeight(1.0);
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
    } //end of CanvasPanel class


   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
    	  if(event.getSource() == save)
    	  {
    	      int width = 2000, height = 2000;

    	      // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
    	      // into integer pixels
    	      BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    	      Graphics2D ig2 = bi.createGraphics();
    	      ig2.setColor(Color.CYAN);
    	      ig2.fillRect(0, 0, 2000, 2000);
    	      for(int i = 0; i<islands.length; i++)
    	      {
    	    	  //unscaled
    	    	  ig2.setColor(Color.GREEN);
    	    	  int x = (int) (islands[i].getX());
    	    	  int y = (int) (islands[i].getY());
    	    	  int r = (int) (islands[i].getR());
    	    	  ig2.fillOval(x, y, r, r); //draw green island
    	    	  ig2.setColor(Color.BLACK);
    	    	  ig2.drawOval(x, y, r, r); //draw black border

    	      }
    	      JFileChooser chooser = new JFileChooser();
    	      String extension = new String(".png");
    	        int option = chooser.showSaveDialog(null);
    	        if (option == JFileChooser.APPROVE_OPTION) {
    	        	File selectedFile = chooser.getSelectedFile();

    	            try {
    	                String fileName = selectedFile.getCanonicalPath();
    	                if (!fileName.endsWith(extension)) {
    	                    selectedFile = new File(fileName + extension);
    	                }
    	                ImageIO.write(bi, "PNG", selectedFile);
    	            } catch (IOException e) {
    	                e.printStackTrace();
    	            }
    	          label1.setText("You saved " + ((chooser.getSelectedFile()!=null)?
    	                            chooser.getSelectedFile().getName():"nothing")+ ".png");
    	        }
    	        else {
    	          label1.setText("You canceled.");
    	        }
    	  }
      }
   } 
}   

/*
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