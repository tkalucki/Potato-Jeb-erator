import java.util.Random;

import javax.swing.*;

public class PanelMain extends JApplet
{

 public void init()
  {
	Random rnd = new Random();
		//Keep
	//int amount = rnd.nextInt(20);
	int amount = 50;
	int h = 2000; int w = 2000; int r = 30; int minr=5;
	IslandCircle islands[] = new IslandCircle[amount];
	for(int i = 0; i<amount; i++){
		IslandCircle ic = new IslandCircle(h, w, r, minr);
		int j = i;
		if(i != 0)
		{
			for(;0<=j-1;j--) //iterate for amount of initialized islands
			{
				int x_0 = islands[j-1].getX();
				int y_0 = islands[j-1].getY();
				int x_1 = ic.getX();
				int y_1 = ic.getY();
				int r_combined = islands[j-1].getR() + ic.getR();
				int len = (int) Math.sqrt((x_0 - x_1)*(x_0 - x_1) + (y_0 - y_1)*(y_0 - y_1)); //Length between both origins
				if(len <= r_combined)
				{
					j = -1; //Break the for loop if there is overlap
				}
				//else the island does not have a collision yet
			}
		}
		if (j < 0)
			i--; //if there was collision dont increment i and regenerate a new island
		else
		{
		islands[i] = ic;
		System.out.println("\nCircle Island#" + i);
		ic.printInfo();
		}
		}
    WholePanel wholePanel = new WholePanel(islands);
    getContentPane().add(wholePanel);
    


    setSize (802, 852);
  }

}




