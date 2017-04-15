
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
   private JPanel BottomLeftPanel;
   private JPanel BottomRightPanel;
   private JButton save;
   private JButton generator;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   private JLabel label5;
   private JTextField area1;
   private JTextField area2;
   private IslandCircle[] islands;
   private IslandRectangle[] islands2;
   private Generator gen;
   private int r;
   private int minr;
   private int heightMax;
   private int heightMin;
   private int widthMax;
   private int widthMin;
   private int flag;
// private ArrayList pointList;
//   private Point pt;
//   private int count;


  public WholePanel() {
	  r = 30; minr = 5; widthMax = 30; widthMin = 5; heightMax = 30; heightMin = 5; flag = 0; //Initialize the Limits of the islands generated ***
      save = new JButton("Save");
      generator = new JButton("Gen Map");
      save.addActionListener(new ButtonListener());
      generator.addActionListener(new ButtonListener());
      label1 = new JLabel();
      label2 = new JLabel();
      label3 = new JLabel();
      label4 = new JLabel();
      label5 = new JLabel();
      BottomPanel = new JPanel();
      BottomLeftPanel = new JPanel();
      BottomRightPanel = new JPanel();
      BottomRightPanel.setLayout(new FlowLayout());
      save.setPreferredSize(new Dimension(80,30));
      BottomRightPanel.add(generator);
      BottomRightPanel.add(label5);
      BottomRightPanel.add(save);
      BottomRightPanel.add(label1);
      BottomLeftPanel.setLayout(new GridLayout(3,2));
      label2.setText("Number of Circle Islands");
      label3.setText("Number of Rectangle Islands");
      label4.setText("Default of 0 will have a random number");
      BottomLeftPanel.add(label2);
      BottomLeftPanel.add(label3);
      area1 = new JTextField("0");
      area2 = new JTextField("0");
      BottomLeftPanel.add(area1);
      BottomLeftPanel.add(area2);
      BottomLeftPanel.add(label4);
      canvas = new CanvasPanel();
      BottomPanel.setLayout(new BorderLayout());
      BottomPanel.add(BottomLeftPanel, BorderLayout.WEST);
      BottomPanel.add(BottomRightPanel, BorderLayout.CENTER);
      //canvas.addMouseListener(new PointListener());
      //JSplitPane bottomSp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, BottomLeftPanel, BottomRightPanel);
      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, canvas, BottomPanel);
      sp.setResizeWeight(1.0);
      setLayout(new BorderLayout());
      //add(bottomSp);
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
        if(flag == 1)
        {
	        for(int i = 0; i<islands.length; i++) //Draws circle islands to a scale of 800 x 800
	        {
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

	        for(int i = 0; i<islands2.length; i++)
	        {
	        	//scaled from 2000 to 800 by multiplying by 0.4
	        	page.setColor(Color.GREEN);
	        	int X = (int) (islands2[i].getX()*0.4);
	        	int Y = (int) (islands2[i].getY()*0.4);
	        	int w = (int) (islands2[i].getW()*0.4);
	        	int h = (int) (islands2[i].getH()*0.4);
	        	page.fillRect(X, Y, w, h);; //draw green island
	        	page.setColor(Color.BLACK);
	        	page.drawRect(X, Y, w, h);; //draw black border

	        }
        }
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
    	  else if(event.getSource() == generator)
    	  {
    		  int cAmount = Integer.parseInt(area1.getText());
    		  int rAmount = Integer.parseInt(area2.getText());
    		  if(cAmount < 0 || cAmount > 5000 || rAmount < 0 || rAmount > 5000)
    			  label5.setText("Invalid Input");
    		  else
    		  { 
    			  gen = new Generator();
    			  islands = new IslandCircle[cAmount];
    			  gen.circleGen(r, minr, cAmount, islands);
    			  islands2 = new IslandRectangle[rAmount];
    			  gen.rectangleGen(widthMax, widthMin, heightMax, heightMin, rAmount, islands2);
    			  flag = 1;
    			  label5.setText("Map Generated");
    			  repaint();
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