import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Character {
    protected int hp;
    protected int strength;
    protected String name;
    protected int armor;
    protected BufferedImage image1;
    protected int posX;
    protected int posY;
    protected Point pos;

    public Character() {
        hp = 10;
        strength = 5;
        name = "default orc";
        armor = 5;
        posX = 360;
        posY = 360;
        try {
            image1 = ImageIO.read(new File("imgDark/orc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Character(int hp, int strength,String name,int armor) {
        this.hp = hp;
        this.strength = strength;
        this.name = name;
        this.armor = armor;
    }
    public void drawChar(Graphics g, ImageObserver observer) {
        g.drawImage(
                image1,
                pos.x * 72,
                pos.y * 72,
                observer
        );
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
