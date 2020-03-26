import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Drawing");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        this.add(canvas, BorderLayout.CENTER);
        this.add(configPanel, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();
    }
}
