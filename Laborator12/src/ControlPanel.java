import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame mainFrame;
    DrawingPanel drawingPanel;
    String[] components = {"Button", "Label", "Frame", "JCheckBox", "JList", "JSlider", "JRadioButton", "JTextField", "JPasswordField"};
    JButton addBtn = new JButton("Add Button");
    JTextField givenTextField = new JTextField();
    JRadioButton button = new JRadioButton("Button");
    JRadioButton label = new JRadioButton("Label");
    JRadioButton checkBox = new JRadioButton("Check Box");
    JRadioButton slider = new JRadioButton("Slider");
    JRadioButton radioButton = new JRadioButton("Radio Button");
    JRadioButton textField = new JRadioButton("Text Field");
    JRadioButton passwordField = new JRadioButton("Password Field");
    ButtonGroup buttonGroup = new ButtonGroup();
    private int buttonY = 50;
    private int labelY = 50;
    private int checkBoxY = 50;
    private int sliderY = 50;
    private int radioButtonY = 50;
    private int textFieldY = 50;
    private int passwordFieldY = 50;



    public ControlPanel(MainFrame frame, DrawingPanel drawingPanel) {
        this.mainFrame = frame;
        this.drawingPanel = drawingPanel;
        init();
    }

    private void init() {
        addBtn.setBounds(0, 0, 100, 30);
        givenTextField.setBounds(120, 10, 1000, 30);
        givenTextField.setPreferredSize(new Dimension(100, 30));
        addBtn.addActionListener(this::actionPerformed);
        this.add(addBtn);
        this.add(givenTextField);

        this.add(addBtn);
        this.add(givenTextField);
        this.add(button);
        this.add(label);
        this.add(checkBox);
        this.add(slider);
        this.add(radioButton);
        this.add(textField);
        this.add(passwordField);

        buttonGroup.add(button);
        buttonGroup.add(label);
        buttonGroup.add(checkBox);
        buttonGroup.add(slider);
        buttonGroup.add(radioButton);
        buttonGroup.add(textField);
        buttonGroup.add(passwordField);

    }

    public void actionPerformed(ActionEvent e) {
        String text = this.givenTextField.getText();
        if (button.isSelected()) {
            JButton newJButton = new JButton(text);
            int buttonX = 10;
            newJButton.setBounds(buttonX, buttonY, 100, 30 );
            buttonY += 40;
            drawingPanel.add(newJButton);
            drawingPanel.revalidate();
            drawingPanel.updateUI();
        } else {
            if (label.isSelected()) {
                JLabel newJLabel = new JLabel(text);
                int labelX = 120;
                newJLabel.setBounds(labelX, labelY, 100, 30 );
                labelY += 40;
                drawingPanel.add(newJLabel);
                drawingPanel.revalidate();
                drawingPanel.updateUI();
            } else {
                if (checkBox.isSelected()) {
                    JCheckBox newCheckBox = new JCheckBox(text);
                    int checkBoxX = 220;
                    newCheckBox.setBounds(checkBoxX, checkBoxY, 100, 30);
                    checkBoxY += 40;
                    drawingPanel.add(newCheckBox);
                    drawingPanel.revalidate();
                    drawingPanel.updateUI();
                } else {
                    if (slider.isSelected()) {
                        JSlider newSlider = new JSlider();
                        int sliderX = 320;
                        newSlider.setBounds(sliderX, sliderY, 100, 30);
                        sliderY += 40;
                        drawingPanel.add(newSlider);
                        drawingPanel.revalidate();
                        drawingPanel.updateUI();
                    } else {
                        if (radioButton.isSelected()) {
                            JRadioButton newRadioButton = new JRadioButton(text);
                            int radioButtonX = 420;
                            newRadioButton.setBounds(radioButtonX, radioButtonY, 100, 30);
                            radioButtonY += 40;
                            drawingPanel.add(newRadioButton);
                            drawingPanel.revalidate();
                            drawingPanel.updateUI();
                        } else {
                            if (textField.isSelected()) {
                                JTextField newTextField = new JTextField(text);
                                int textFieldX = 520;
                                newTextField.setBounds(textFieldX, textFieldY, 100, 30);
                                textFieldY += 40;
                                drawingPanel.add(newTextField);
                                drawingPanel.revalidate();
                                drawingPanel.updateUI();
                            } else {
                                if (passwordField.isSelected()) {
                                    JPasswordField newPasswordField = new JPasswordField(text);
                                    int passwordFieldX = 620;
                                    newPasswordField.setBounds(passwordFieldX, passwordFieldY, 100, 30);
                                    passwordFieldY += 40;
                                    drawingPanel.add(newPasswordField);
                                    drawingPanel.revalidate();
                                    drawingPanel.updateUI();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}