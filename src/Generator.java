import java.util.Random;

public class Generator {
	public static void main(String args[]){
		Random rnd = new Random();
		//Keep
		int amount = rnd.nextInt(20);
		int h = 2000; int w = 2000; int r = 20;
		IslandCircle islands[] = new IslandCircle[amount];
		for(int i = 0; i<amount; i++){
			IslandCircle ic = new IslandCircle(h, w, r);
			islands[i] = ic;
			ic.printInfo();
		}
		
		
	}
}
