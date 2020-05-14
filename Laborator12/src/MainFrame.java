import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public MainFrame() {
        super("Drawing");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawingPanel = new DrawingPanel(this);
        controlPanel = new ControlPanel(this, this.drawingPanel);

        this.add(drawingPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.NORTH);

        pack();
    }


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
