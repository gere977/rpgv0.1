import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Board extends JComponent implements KeyListener {

    int testBoxX;
    int testBoxY;
    Graphics kiskacsaX;
    Graphics kiskacsaY;
    Random rnd = new Random();

    public Board() {
        testBoxX = 0;
        testBoxY = 0;

        // set the size of your draw board
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
       // floorDraw(graphics);
        drawFloorLevelOne(graphics);
      //  graphics.fillRect(testBoxX, testBoxY, 72, 72);
        try {
            BufferedImage img = ImageIO.read(new File("imgDark/kiskacsaTestCharacter.png"));
            BufferedImage bi = new
                    BufferedImage(72, 72, BufferedImage.TYPE_INT_ARGB);
           // graphics.drawImage(img,0,0,null);
            kiskacsaX = bi.getGraphics();
           // kiskacsaX.drawImage(img,0,0,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PositionedImage kiskacsa = new PositionedImage("imgDark/kiskacsaTestCharacter.png",testBoxX,testBoxY);
        kiskacsa.draw(graphics);


    }
    public void floorDraw(Graphics graphics) {
        int boardSize = 10;
        int squareSize = 72;
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                PositionedImage image = new PositionedImage("imgDark/floortilewithEDgeDarkv2.png",
                        row * squareSize, col* squareSize);
                image.draw(graphics);
            }
        }
        PositionedImage imageDoorStart = new PositionedImage("imgDark/doorv0START.png",0,0);
        imageDoorStart.draw(graphics);
        drawWallFirst(graphics);
    }
    public void drawWallFirst(Graphics graphics) {
        for (int i = 0; i < 6; i++) {
            int rand = rnd.nextInt(2);
            if (rand == 1) {
                PositionedImage wallFirst = new PositionedImage("imgDark/wallBricks.png",72,i * 72);
                wallFirst.draw(graphics);
            } else {
                PositionedImage wallFirst = new PositionedImage("imgDark/wallBrickSimple.png",72,i * 72);
                wallFirst.draw(graphics);
            }
        }
    }
    public void drawFloorLevelOne(Graphics graphics) {
        Floor floor = new Floor();
        Wall wall = new Wall();
        MapObjects objects = new MapObjects();
        floor.drawFloor(graphics);
        wall.drawWall(graphics);
        objects.drawStartDoor(graphics);

    }

    public static void main(String[] args) {
        // Here is how you set up a new window and adding our board to it
        JFrame frame = new JFrame("RPG Game");
        Board board = new Board();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        // Here is how you can add a key event listener
        // The board object will be notified when hitting any key
        // with the system calling one of the below 3 methods
        frame.addKeyListener(board);
        // Notice (at the top) that we can only do this
        // because this Board class (the type of the board object) is also a KeyListener
    }

    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Audio quack = new Audio();
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            testBoxY -= 72;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            testBoxY += 72;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            testBoxX -= 72;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            testBoxX += 72;
        }
        // and redraw to have a new picture with the new coordinates
        repaint();

    }

    // But actually we can use just this one for our goals here
    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            testBoxY -= 72;
//        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
//            testBoxY += 72;
//        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//            testBoxX -= 72;
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            testBoxX += 72;
//        }
//        // and redraw to have a new picture with the new coordinates
//        repaint();

    }

}