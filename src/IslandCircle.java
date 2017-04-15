import java.util.Random;

public class IslandCircle extends Island
{
	private int x;
	private int y;
	private int r;
	
	public IslandCircle(){}
	
	public IslandCircle(int h, int w, int ar, int armin)
	{
		RandomizerCircle(h, w, ar, armin);
	}
	
	//getters
	public int getR(){
		return r;
	}
	
	//setter
	public void setR(int l){
		l=r;
	}

	public void RandomizerCircle(int height, int width, int radius, int radiusMin){
		Random rnd = new Random();
		//randomize based on map width. make dynamic later
		x = rnd.nextInt(height);
		y = rnd.nextInt(width);
		r = rnd.nextInt(radius-radiusMin)+radiusMin;
		//makes it centered
		x = x+r;
		y = y+r;
	}

	
	public String outLocation(){
		String s = "X Coord is: " + (x) + "\n" +
				   "Y Coord is: " + (y) + "\n";
		return s;
	}
	
	
	public double outArea(){
		return Math.PI*r*r;
	}
}
