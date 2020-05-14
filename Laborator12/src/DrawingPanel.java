import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1000, H = 600;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.setLayout(new FlowLayout());
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
    }

    @Override
    public void update(Graphics g) { }

}
