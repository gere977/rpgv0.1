import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Monster extends Character{
    public Monster(String name) {
        super(3,3,name,3);
        loadImage();
        pos = new Point(5, 5);
    }
    private void loadImage() {
        try {
            // you can use just the filename if the image file is in your
            // project folder, otherwise you need to provide the file path.
            image1 = ImageIO.read(new File("imgDark/orc.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
}
