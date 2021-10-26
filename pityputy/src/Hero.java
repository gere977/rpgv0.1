import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Hero extends Character{
    private int level;
    Tile matrix;

    public Hero(String name) {
     super(10,10,name,10);
     level = 1;
     loadImageStart();
     pos = new Point(0, 0);
    }
    private void loadImageStart() {
        try {
            image1 = ImageIO.read(new File("stardewAssets/dogFront.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    private void loadImageLeft() {
        try {
            image1 = ImageIO.read(new File("stardewAssets/dogLeft.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    private void loadImageRight() {
        try {
            image1 = ImageIO.read(new File("stardewAssets/dogRight.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    private void loadImageLeft2() {
        try {
            image1 = ImageIO.read(new File("stardewAssets/dogLeft2.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    private void loadImageRight2() {
        try {
            image1 = ImageIO.read(new File("stardewAssets/dogRight2.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    private void loadImageUp() {
        try {
            image1 = ImageIO.read(new File("stardewAssets/dogUp.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void tick() {
    matrix = new Tile();
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= matrix.getMatrix()[0].length) {
            pos.x = matrix.getMatrix()[0].length-1;
        }
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= matrix.getMatrix().length) {
            pos.y = matrix.getMatrix().length-1;
        }
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        Tile level1 = new Tile();
        if (key == KeyEvent.VK_UP && level1.getMatrix()[pos.y-1][pos.x] != 1) {
            pos.translate(0, -1);
            this.loadImageUp();
        }
        if (key == KeyEvent.VK_RIGHT  && level1.getMatrix()[pos.y][pos.x+1] != 1) {
            pos.translate(1, 0);
            this.loadImageRight();
        }
        if (key == KeyEvent.VK_DOWN && level1.getMatrix()[pos.y+1][pos.x] != 1) {
            pos.translate(0, 1);
            this.loadImageStart();
        }
        if (key == KeyEvent.VK_LEFT && level1.getMatrix()[pos.y][pos.x-1] != 1) {
            pos.translate(-1, 0);
            this.loadImageLeft();
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        Tile level1 = new Tile();
        if (key == KeyEvent.VK_RIGHT  && level1.getMatrix()[pos.y][pos.x+1] != 1) {
          //  pos.translate(1, 0);
            this.loadImageRight2();
        }
        if (key == KeyEvent.VK_LEFT && level1.getMatrix()[pos.y][pos.x-1] != 1) {
           // pos.translate(-1, 0);
            this.loadImageLeft2();
        }
    }
    public Point getPos() {
        return pos;
    }

}
