import java.util.Random;

public class IslandRectangle extends Island{
	private int x;
	private int y;
	private int w;
	private int h;
	
	public IslandRectangle(){}
	
	public IslandRectangle(int h, int w, int wl, int minwl, int hl, int minhl)
	{
		RandomizerRectangle(h, w, wl, minwl, hl, minhl);
	}
	//getter
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	//setter
	public void setX(int l){
		x=1;
	}
	public void setY(int l){
		y=1;
	}
	//getters
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	
	//setter
	public void setR(int l){
		w=l;
	}
	public void setH(int l){
		w=l;
	}
	
	public void RandomizerRectangle(int s1, int s2, int s3, int min3, int s4, int min4){
		Random rnd = new Random();
		//randomize based on map width. make dynamic later
		x = rnd.nextInt(s1);
		y = rnd.nextInt(s2);
		w = rnd.nextInt(s3-min3)+min3;
		h = rnd.nextInt(s4-min4)+min4;
	}
	
	
	public String outLocation(){
		String s = "X Coord is: " + (x-(w/2)) + "\n" +
				   "Y Coord ais: " + (y-(h/2)) + "\n";
		return s;
	}
	
	
	public double outArea(){
		return w*h;
	}
	
}
