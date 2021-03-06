//Created by: Jackson Allen
//Class Description: Modifies an array of type IslandCircle or IslandRectangle bassed on which method is called. The method called adds a
//number--determined by parameters-- of randomly generated, Island objects of either type IslandCircle or IslandRectangle. Depending on the
//type the variables are different however the information stored is used to satsify the "fillOval" or "fillRect"
public class Generator {
	
	private int h;
	private int w;

	public Generator()
	{
		h = 2000; w = 2000;	
	}
	public void circleGen(int r, int minr, int cAmount, IslandCircle[] islands)
	{
		for(int i = 0; i<cAmount; i++)
		{
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
					if(len <= r_combined || x_1 + ic.getR() > 2000 || x_1 - ic.getR() < 0 || y_1 + ic.getR() > 2000 || y_1 - ic.getR() < 0)
					{
						j = -1; //Break the for loop if there is overlap
					}
					//else the island does not have a collision yet
				}
			}
			if (j < 0)
				i--; //if there was collision don't increment i and regenerate a new island
			else
			{
				islands[i] = ic;
				System.out.println("\nCircle Island#" + i);
				ic.printInfo();
			}
		}
	}
	public void rectangleGen(int widthMax, int widthMin,int heightMax, int heightMin, int rAmount, IslandRectangle[] islands)
	{
		
		for(int i = 0; i<rAmount; i++)
		{
			IslandRectangle ir = new IslandRectangle(h, w, widthMax, widthMin, heightMax, heightMin);
			int j = i;
			if(i != 0)
			{
				for(;0<=j-1;j--) //iterate for amount of initialized islands
				{
					int x_0 = islands[j-1].getX();
					int y_0 = islands[j-1].getY();
					int x_1 = ir.getX();
					int y_1 = ir.getY();
					int r_0;
					int r_1;
					if(islands[j-1].getW() > islands[j-1].getH())	
						 r_0 = islands[j-1].getW();
					else
						 r_0 = islands[j-1].getH();
					if(ir.getW() > ir.getH())	
						 r_1 = islands[j-1].getW();
					else
						 r_1 = ir.getH();
					int r_combined = r_0 + r_1;
					int len = (int) Math.sqrt((x_0 - x_1)*(x_0 - x_1) + (y_0 - y_1)*(y_0 - y_1)); //Length between both origins
					if(len <= r_combined || x_1 + r_1 > 2000 || x_1 - r_1 < 0 || y_1 + r_1 > 2000 || y_1 - r_1 < 0)
					{
						j = -1; //Break the for loop if there is overlap
					}
					//else the island does not have a collision yet
				}
			}
			if (j < 0)
				i--; //if there was collision don't increment i and regenerate a new island
			else
			{
			islands[i] = ir;
			System.out.println("\nRectangle Island #" + i);
			ir.printInfo();
			}
		}
		
	}
}

