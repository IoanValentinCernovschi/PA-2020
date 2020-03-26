import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1000, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    Random rand;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }

    protected void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
        rand = new Random();
    }
    private void drawShape(int x, int y) {
        int radius = rand.nextInt(50);
        int size = (int)this.frame.configPanel.sizeField.getValue();
        Color color = Color.BLUE;
        graphics.setColor(color);
        graphics.fill(new Rectangle(x, y, size, size));
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
