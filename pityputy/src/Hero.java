import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Hero extends Character{
    private int level;

    public Hero(String name) {
     super(10,10,name,10);
     level = 1;
     loadImage();
     pos = new Point(0, 0);
    }
    private void loadImage() {
        try {
            image1 = ImageIO.read(new File("imgDark/kiskacsaTestCharacter.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void tick() {
        // this gets called once every tick, before the repainting process happens.
        // so we can do anything needed in here to update the state of the player.
        // prevent the player from moving off the edge of the board sideways
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= 10) {
            pos.x = 10 - 1;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= 10) {
            pos.y = 10 - 1;
        }
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        Tile level1 = new Tile();
        if (key == KeyEvent.VK_UP && level1.getMatrix()[pos.y-1][pos.x] != 1 ) {
            pos.translate(0, -1);
        }
        if (key == KeyEvent.VK_RIGHT  && level1.getMatrix()[pos.y][pos.x+1] != 1) {
            pos.translate(1, 0);
        }
        if (key == KeyEvent.VK_DOWN && level1.getMatrix()[pos.y+1][pos.x] != 1) {
            pos.translate(0, 1);
        }
        if (key == KeyEvent.VK_LEFT && level1.getMatrix()[pos.y][pos.x-1] != 1) {
            pos.translate(-1, 0);
        }
    }
    public Point getPos() {
        return pos;
    }

}
