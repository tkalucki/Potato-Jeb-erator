import java.util.Random;

public class IslandRectangle {
	private int x;
	private int y;
	private int w;
	private int h;
	
	public IslandRectangle(){}
	
	public IslandRectangle(int h, int w, int wl, int minwl, int hl, int minhl)
	{
		RandomizerRectangle(h, w, wl, minwl, hl, minhl);
	}
	
	//getters
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	
	//setter
	public void setX(int l){
		l=x;
	}
	public void setY(int l){
		l=y;
	}
	public void setR(int l){
		l=w;
	}
	public void setH(int l){
		l=h;
	}
	
	public void RandomizerRectangle(int s1, int s2, int s3, int min3, int s4, int min4){
		Random rnd = new Random();
		//randomize based on map width. make dynamic later
		x = rnd.nextInt(s1);
		y = rnd.nextInt(s2);
		w = rnd.nextInt(s3-min3)+min3;
		h = rnd.nextInt(s4-min4)+min4;
	}
	
	public void printInfo(){
		System.out.println(outInfo());
	}
	
	public String outInfo(){
		String ret = outLocation() + outSize();
		return ret;
	}
	
	public String outLocation(){
		String s = "X Coord is: " + (x-(w/2)) + "\n" +
				   "Y Coord ais: " + (y-(h/2)) + "\n";
		return s;
	}
	
	public String outSize(){
		String s = "The size of the island is " + outArea();
		return s;
	}
	
	public double outArea(){
		return w*h;
	}
}
