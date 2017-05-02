
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class IslMapPanel extends JPanel 
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
   private JTextField area3;
   private int x;
   private int y;
   private int mainr;
   private int r;
   private double modR;
   private double theta;
   private ArrayList<IslandCircle> genList1;
   private ArrayList<IslandCircle> genList2;
   private ArrayList<IslandCircle> outerList;
   private int appletHeight;
   private int appletWidth;


  public IslMapPanel() {
      genList1 = new ArrayList<IslandCircle>();
      genList2 = new ArrayList<IslandCircle>();
      outerList = new ArrayList<IslandCircle>();
      save = new JButton("Save");
      generator = new JButton("Gen Island");
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
      label2.setText("Initial Radius");
      label3.setText("Radius Multiplier");
      label4.setText("Theta(Degrees)");
      BottomLeftPanel.add(label2);
      BottomLeftPanel.add(label3);
      area1 = new JTextField("25");
      area2 = new JTextField("0.5");
      area3 = new JTextField("30");
      BottomLeftPanel.add(area1);
      BottomLeftPanel.add(area2);
      BottomLeftPanel.add(label4);
      BottomLeftPanel.add(area3);
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

//CanvasPanel is the panel where the island will be generated
  private class CanvasPanel extends JPanel
   {
      //this method draws all shapes
      public void paintComponent(Graphics page)
       {
        super.paintComponent(page);
        setBackground(Color.CYAN);
	    Dimension appletSize = this.getSize();
	    appletHeight = appletSize.height;
	    appletWidth = appletSize.width;
        if(!genList1.isEmpty()) 
        {
        	theta = Integer.parseInt(area3.getText())*Math.PI/180;
        	modR = Double.parseDouble(area2.getText());
	
	        page.setColor(Color.GREEN);
	        page.fillOval(x-mainr/2,y-mainr/2,mainr, mainr); //draw base green island
	      
	        IslandCircle base = new IslandCircle(x,y,mainr);
	        genList1.add(base);
	        genList2.add(base);
	        outerList.add(base);
    		Random rnd = new Random();	
	        int index = 0;
	        while (mainr > 1 && genList1.size() < 500000)
	        {
	        	outerList.clear();
	        	for (; index < genList1.size();index++)
	        	{
	        		int x1 = genList1.get(index).getX();
	        		int y1 = genList1.get(index).getY();
	        		int r1 = genList1.get(index).getR();
		        	for (double i = 0; i < 2*Math.PI;)
		        	{
		        		x = (int) (x1 + Math.cos(i)*r1/2);
		        		y = (int) (y1 + Math.sin(i)*r1/2);
		        		r = rnd.nextInt((int)(mainr))+1;
		    	        page.fillOval(x-r/2, y-r/2, r, r); //draw green island
		    	        IslandCircle store = new IslandCircle(x,y,r);
		    	        genList2.add(store); 
		        		i = i + theta;
		        	}
		        	System.out.println("Cirlce Count: " + index);
	        	}
	        	genList1.addAll(genList2);
	        	outerList.addAll(genList2); //stores the outer most circles
	        	genList2.clear();
	        	mainr = (int) (modR*mainr);
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
    	      ig2.setColor(Color.GREEN);
    	      for(int i = 0; i < genList1.size();i++)
    	      {
    	    	  x = (int) ((2000/(double)appletWidth)*genList1.get(i).getX());
    	    	  y = (int) ((2000/(double)appletHeight)*genList1.get(i).getY());
    	    	  int r1 = (int) ((2000/(double)appletWidth)*genList1.get(i).getR());
    	    	  int r2 = (int) ((2000/(double)appletHeight)*genList1.get(i).getR());
    	    	  ig2.fillOval(x-r1/2, y-r2/2, r1, r2); //draw green island
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
    		  genList1.clear();
	          x = appletWidth/2 - mainr/2;
	          y = appletHeight/2 - mainr/2;  
	          mainr = Integer.parseInt(area1.getText())*10; 
	          genList1.add(new IslandCircle(x,y,mainr));
    		  repaint();
    	  }
      }
   } 
}

