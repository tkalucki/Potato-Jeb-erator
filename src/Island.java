
public class Island {
	private int x;
	private int y;
	
	//getter
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	//setter
	public void setX(int l){
		x=l;
	}
	public void setY(int l){
		y=l;
	}
	
	public void printInfo(){
		System.out.println(outInfo());
	}
	
	public String outInfo(){
		String ret = outLocation() + outSize();
		return ret;
	}
	
	
	/**
	 * Needs to be overwritten
	 * @author Tyler
	 */
	public String outLocation(){
		return "";
	}
	public String outSize(){
		String s = "The size of the island is " + outArea();
		return s;
	}
	/**
	 * Needs to be overwritten
	 * @author Tyler
	 */
	public double outArea(){
		return 0.0;
	}
}
