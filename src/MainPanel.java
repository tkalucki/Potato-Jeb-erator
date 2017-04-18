import javax.swing.JApplet;

public class MainPanel extends JApplet
{

 public void init()
  {
    GUI gui = new GUI();
    getContentPane().add(gui);
    setSize (802, 872);
  }
}