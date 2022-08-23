
import java.awt.*;
import java.awt.event.*; 

public class ButtonTest {
  public static void main(String[] args) {
    Frame f = new ButtonTestFrame("Button Test");
    f.setSize(150, 100);
    f.setVisible(true);

  }
}

class ButtonTestFrame extends Frame {
  public ButtonTestFrame(String title) {
    super(title);
    setLayout(new FlowLayout());
    Button b = new Button("Close window");
    add(b);
    b.addActionListener(new ButtonListener());

    addWindowListener(new WindowCloser());
  }
}

class ButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent evt) {
    System.exit(0);
  }
}

class WindowCloser extends WindowAdapter {
  public void windowClosing(WindowEvent evt) {
    System.exit(0);
  }
}
