import javax.swing.*;

public class DndMapCreator extends JApplet
{
	  private final int WIDTH = 1600;
	  private final int HEIGHT = 800;
 public void init()
  {
    ControlPanel controlPanel = new ControlPanel(WIDTH,HEIGHT);
    getContentPane().add(controlPanel);
    setSize(WIDTH,HEIGHT);
  }
}