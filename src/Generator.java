import java.util.Random;


public class Generator {
	public static void main(String args[]){
		Random rnd = new Random();
		//Keep
		int amount = rnd.nextInt(20);
		int h = 2000; int w = 2000; int r = 20; int minr=5;
		IslandCircle islands[] = new IslandCircle[amount];
		for(int i = 0; i<amount; i++){
			IslandCircle ic = new IslandCircle(h, w, r, minr);
			int j = i; 
			if (amount != 0) //if not the first iteration
			{	
				for(;0<=j;j--) //iterate for amount of initialized islands
				{
					int x_0 = islands[j].getX();
					int y_0 = islands[j].getY();
					int x_1 = ic.getX();
					int y_1 = ic.getY();
					int r_combined = islands[j].getR() + ic.getR();
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
		
		IslandRectangle islands2[] = new IslandRectangle[amount];
		for(int i = 0; i<amount; i++){
			//x, y, sizeL, minL, sizeW, minW
			IslandRectangle ir = new IslandRectangle(h, w, 20, 5, 15, 5);
			islands2[i] = ir;
			System.out.println("\nRectangle Island #" + i);
			ir.printInfo();
		}
		
		
	}
}
