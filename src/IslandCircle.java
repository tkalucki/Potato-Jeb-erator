import java.util.Random;

public class IslandCircle
{
	private int x;
	private int y;
	private int r;
	
	public IslandCircle(){}
	
	public IslandCircle(int h, int w, int ar)
	{
		RandomizerCircle(h, w, ar);
	}
	
	//getters
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getR(){
		return r;
	}
	
	//setter
	public void setX(int l){
		l=x;
	}
	public void setY(int l){
		l=y;
	}
	public void setR(int l){
		l=r;
	}

	public void RandomizerCircle(int height, int width, int radius){
		Random rnd = new Random();
		//randomize based on map width. make dynamic later
		x = rnd.nextInt(height);
		y = rnd.nextInt(width);
		r = rnd.nextInt(radius);
	}

	public void printInfo(){
		System.out.println(outInfo());
	}
	
	public String outInfo(){
		String ret = outLocation() + outSize();
		return ret;
	}
	
	public String outLocation(){
		String s = "X Coord is: " + (x-r) + "\n" +
				   "Y Coord is: " + (y-r) + "\n";
		return s;
	}
	
	public String outSize(){
		String s = "The size of the island is " + outArea();
		return s;
	}
	
	public double outArea(){
		return Math.PI*r*r;
	}
}
