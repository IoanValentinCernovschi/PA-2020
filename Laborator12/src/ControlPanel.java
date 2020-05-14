import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    final MainFrame mainFrame;
    DrawingPanel drawingPanel;
    String[] components = {"Button", "Label", "Frame", "JCheckBox", "JList", "JSlider", "JRadioButton", "JTextField", "JPasswordField"};
    JButton addBtn = new JButton("Add Button");
    JTextField givenTextField = new JTextField();
    JTextField componentName = new JTextField();
    public ControlPanel(MainFrame frame, DrawingPanel drawingPanel) {
        this.mainFrame = frame;
        this.drawingPanel = drawingPanel;
        init();
    }

    private void init() {
        addBtn.setBounds(0, 0, 100, 30);
        givenTextField.setBounds(120, 10, 100, 30);
        givenTextField.setPreferredSize(new Dimension(100, 30));
        componentName.setBounds(230, 10, 100, 30);
        componentName.setPreferredSize(new Dimension(100, 30));
        addBtn.addActionListener(this::actionPerformed);
        this.add(addBtn);
        this.add(givenTextField);
        this.add(componentName);

        this.add(addBtn);
        this.add(givenTextField);

    }
    private JComponent create() {
        String component = "javax.swing." + componentName.getText();
        try {
            Class clazz = Class.forName(component);
            JComponent jComponent = (JComponent) clazz.getConstructor().newInstance();
            componentText(clazz, jComponent);
            return jComponent;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void componentText(Class clazz, JComponent jComponent) {
        String text = givenTextField.getText();
        try {
            Method method = clazz.getMethod("setText", String.class);
            method.invoke(jComponent, text);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        drawingPanel.add(create());
        drawingPanel.revalidate();
        drawingPanel.updateUI();
    }

}