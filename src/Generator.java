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
			islands[i] = ic;
			System.out.println("\nCircle Island#" + i);
			ic.printInfo();
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
