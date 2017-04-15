import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Generator {
	static Random rnd = new Random();
	//Keep
	static int amount = rnd.nextInt(20);
	static int r = 20; 
	static int minr=5;
	static int h = 2000; 
	static int w = 2000; 
	
	public static void main(String args[]){
		Generator.init();
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
	}
	
	private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Potato Jeb-erator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
	
	private static void init() {
		IslandCircle islands[] = new IslandCircle[amount];
		for(int i = 0; i<amount; i++){
			IslandCircle ic = new IslandCircle(h, w, r, minr);
			islands[i] = ic;
			System.out.println("\nCircle Island#" + i);
			ic.printInfo();
		}
	}
}

class MyPanel extends JPanel {
	static int h = 2000; 
	static int w = 2000; 
	static Random rnd = new Random();
	static int amount = rnd.nextInt(20);
	IslandRectangle islands2[] = new IslandRectangle[amount];
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(h,w);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        
        // Draw Text
        g.drawString("The World",10,20);
        for(int i = 0; i<amount; i++){
			//x, y, sizeL, minL, sizeW, minW
			IslandRectangle ir = new IslandRectangle(h, w, 20, 5, 15, 5);
			islands2[i] = ir;
			System.out.println("\nRectangle Island #" + i);
			paintRect(g, ir.getX(), ir.getY(), ir.getW(), ir.getH());
			ir.printInfo();
		}
    } 
    
    protected void paintRect(Graphics g, int squareX, int squareY, int squareW, int squareH) {
        super.paintComponent(g);       
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
        repaint();
    }  
}
