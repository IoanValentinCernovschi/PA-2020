import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
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

        saveBtn.setBounds(50, 800, 100, 20);
        loadBtn.setBounds(150, 800, 100, 20);
        resetBtn.setBounds(250, 800, 100, 20);
        exitBtn.setBounds(350, 800, 100, 20);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

        this.add(saveBtn);
        this.add(loadBtn);
        this.add(resetBtn);
        this.add(exitBtn);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("D:/Scoala/Facultate/Anul II/Programare Avansata/imagini.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            BufferedImage canvasImage = ImageIO.read(new FileInputStream("D:/Scoala/Facultate/Anul II/Programare Avansata/imagini.png"));
            frame.canvas.setImage(canvasImage);

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