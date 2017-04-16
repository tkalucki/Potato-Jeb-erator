import java.util.Random;

import javax.swing.*;

public class PanelMain extends JApplet
{

 public void init()
  {
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);
    setSize (802, 872);
  }
}