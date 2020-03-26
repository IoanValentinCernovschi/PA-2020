import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        saveBtn.setBounds(50, 10, 100, 20);
        resetBtn.setBounds(150, 10, 100, 20);
        exitBtn.setBounds(250, 10, 100, 20);

        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

        this.frame.add(saveBtn);
        this.frame.add(resetBtn);
        this.frame.add(exitBtn);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("D:/Scoala/Facultate/Anul II/Programare Avansata/imagini.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            Image img;
            Graphics g = null;
            img = ImageIO.read(new FileInputStream("D:/Scoala/Facultate/Anul II/Programare Avansata/imagini.png"));
            g.drawImage(img, 0, 0, this);
            paintComponent(g);
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
        try {
            this.frame.canvas.createOffscreenImage();
        } catch (Exception exception) { System.err.println(exception);}
    }

    private void exit(ActionEvent e) {
        try {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } catch (Exception exception) { System.err.println(exception); }
    }

}