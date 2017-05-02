import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CanvasPanel extends JPanel
   {
	  //Method to draw the shapes
      public void paintComponent(Graphics page)
       {
        super.paintComponent(page);
        setBackground(Color.CYAN);
        if(flag == 1)
        {
	        //pixel size for window scale ability
	        Dimension appletSize = this.getSize();
	        int appletHeight = appletSize.height;
	        int appletWidth = appletSize.width;
	        
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
   }