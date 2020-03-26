import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sizeLabel;
    JSpinner sizeField;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sizeLabel = new JLabel("Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sizeField.setValue(10);

        this.add(sizeLabel);
        this.add(sizeField);
    }
}