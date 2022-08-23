
import java.awt.*;
import java.awt.event.*;

public class PickColor {
  public static void main(String[] args) {
    Frame f = new PickColorFrame("Pick Color");
    f.setSize(150, 200);
    f.setVisible(true);
  }
}

class PickColorFrame extends Frame {
  private Label redLabel = 
    new Label("Red = 128", Label.CENTER);
  private Label greenLabel = 
    new Label("Green = 128", Label.CENTER);
  private Label blueLabel = 
    new Label("Blue = 128", Label.CENTER);
  private Scrollbar redBar = 
    new Scrollbar(Scrollbar.HORIZONTAL, 128, 1, 0, 256);
  private Scrollbar greenBar = 
    new Scrollbar(Scrollbar.HORIZONTAL, 128, 1, 0, 256);
  private Scrollbar blueBar = 
    new Scrollbar(Scrollbar.HORIZONTAL, 128, 1, 0, 256);

  public PickColorFrame(String title) {
    super(title);
    setBackground(new Color(128, 128, 128));
    setLayout(new GridLayout(6, 1));


    ScrollbarListener listener = new ScrollbarListener();

    add(redBar);
    redBar.addAdjustmentListener(listener);
    add(redLabel);

    add(greenBar);
    greenBar.addAdjustmentListener(listener);
    add(greenLabel);

    add(blueBar);
    blueBar.addAdjustmentListener(listener);
    add(blueLabel);

    addWindowListener(new WindowCloser());
  }

  class ScrollbarListener implements AdjustmentListener {
    public void adjustmentValueChanged(AdjustmentEvent evt) {
      int red = redBar.getValue();
      int green = greenBar.getValue();
      int blue = blueBar.getValue();

      redLabel.setText("Red = " + red);
      greenLabel.setText("Green = " + green);
      blueLabel.setText("Blue = " + blue);

      Color newColor = new Color(red, green, blue);
      redLabel.setBackground(newColor);
      greenLabel.setBackground(newColor);
      blueLabel.setBackground(newColor);
    }
  }
  class WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
      System.exit(0);
    }
  }
}

