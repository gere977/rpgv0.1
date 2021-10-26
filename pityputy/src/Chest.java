import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Chest {
    private BufferedImage image;
    private Point pos;

    public Chest(int x, int y) {
        loadImage();

        pos = new Point(x, y);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("imgDark/chestLocked.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                image,
                pos.x * 72,
                pos.y * 72,
                observer
        );
    }

    public Point getPos() {
        return pos;
    }
}
