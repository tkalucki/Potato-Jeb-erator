
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class GenMapPanel extends JPanel 
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

  public GenMapPanel() {
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
      label4.setText("Enter -1 to randomly generate the amount");
      BottomLeftPanel.add(label2);
      BottomLeftPanel.add(label3);
      area1 = new JTextField("10");
      area2 = new JTextField("0");
      BottomLeftPanel.add(area1);
      BottomLeftPanel.add(area2);
      BottomLeftPanel.add(label4);
      canvas = new CanvasPanel();
      BottomPanel.setLayout(new BorderLayout());
      BottomPanel.add(BottomLeftPanel, BorderLayout.WEST);
      BottomPanel.add(BottomRightPanel, BorderLayout.CENTER);
      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, canvas, BottomPanel);
      sp.setResizeWeight(1.0);
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(800,800));
      add(sp);

}

//CanvasPanel is the Map Drawing panel
  private class CanvasPanel extends JPanel
   {
	  //Method to draw the shapes
      public void paintComponent(Graphics page)
       {
        super.paintComponent(page);
        setBackground(Color.CYAN);
        if(flag == 1)
        {
	        //applet size measured
	        Dimension appletSize = this.getSize();
	        int appletHeight = appletSize.height;
	        int appletWidth = appletSize.width;
        
	        for(int i = 0; i<islands.length; i++) //Draws circle islands
	        {
	        	//scaled from 2000 to applet size
	        	page.setColor(Color.GREEN);
	        	int x = (int) (islands[i].getX()*(double)appletWidth/2000);
	        	int y = (int) (islands[i].getY()*(double)appletHeight/2000);
	        	int r1 = (int) (islands[i].getR()*(double)appletWidth/2000);
	        	int r2 = (int) (islands[i].getR()*(double)appletHeight/2000);
	        	page.fillOval(x, y, r1, r2); //draw green island
	        	page.setColor(Color.BLACK);
	        	page.drawOval(x, y, r1, r2); //draw black border
	
	        }
	        for(int i = 0; i<islands2.length; i++)
	        {
	        	//scaled from 2000 to applet size
	        	page.setColor(Color.GREEN);
	        	int X = (int) (islands2[i].getX()*(double)appletWidth/2000);
	        	int Y = (int) (islands2[i].getY()*(double)appletHeight/2000);
	        	int h = (int) (islands2[i].getW()*(double)appletHeight/2000);
	        	int w = (int) (islands2[i].getH()*(double)appletWidth/2000);
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
  	          	  //Makes Image that's 2000 x 2000 pixels
    	    	  ig2.setColor(Color.GREEN);
    	    	  int x = (int) (islands[i].getX());
    	    	  int y = (int) (islands[i].getY());
    	    	  int r = (int) (islands[i].getR());
    	    	  ig2.fillOval(x, y, r, r); //draw green island
    	    	  ig2.setColor(Color.BLACK);
    	    	  ig2.drawOval(x, y, r, r); //draw black border

    	      }
  	          for(int i = 0; i<islands2.length; i++)
  	          {
  	          	  //Makes Image that's 2000 x 2000 pixels
  	        	  ig2.setColor(Color.GREEN);
  	        	  int X = (int) (islands2[i].getX());
  	        	  int Y = (int) (islands2[i].getY());
  	        	  int w = (int) (islands2[i].getW());
  	        	  int h = (int) (islands2[i].getH());
  	        	  ig2.fillRect(X, Y, w, h);; //draw green island
  	        	  ig2.setColor(Color.BLACK);
  	        	  ig2.drawRect(X, Y, w, h);; //draw black border

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
    		  gen = new Generator();
			  Random rnd = new Random();
			  int amount = rnd.nextInt(20);
    		  if(cAmount < 0 || cAmount > 5000)
    			   	  cAmount = amount;
    		  else if(rAmount < 0 || rAmount > 5000)
    				  rAmount = amount;
    		  else
    		  { 
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

