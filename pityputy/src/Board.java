import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JComponent implements KeyListener {
    private final int DELAY = 25;
    private Timer timer;
     Hero kiskacsa;
     ArrayList chests;
     Monster orc;
     Random rnd = new Random();


    public Board() {
        setPreferredSize(new Dimension(1440, 864));
        setVisible(true);

        kiskacsa = new Hero("kiskacsa");
        orc = new Monster("orcZug");
        chests = populateChests();

        timer = new Timer(DELAY, this::actionPerformed);
        timer.start();
    }

   // @Override
    public void actionPerformed(ActionEvent e) {
        // this method is called by the timer every DELAY ms.
        // use this space to update the state of your game or animation
        // before the graphics are redrawn.

        // prevent the player from disappearing off the board
        kiskacsa.tick();
        collectChest();
        repaint();
    }
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawFloorLevelOne(graphics);
      //  Chest chest = new Chest(6,6);
          //  chest.draw(graphics, this);
        for (Object chest : chests) {
            ((Chest)chest).draw(graphics, this);
        }
        kiskacsa.drawChar(graphics,this);
      //  orc.drawChar(graphics,this);

        Toolkit.getDefaultToolkit().sync();
    }

    public void drawFloorLevelOne(Graphics graphics) {
        Floor floor = new Floor();
        Wall wall = new Wall();
        MapObjects objects = new MapObjects();
        floor.drawFloor(graphics);
        wall.drawWall(graphics);
        objects.drawStartDoor(graphics);

    }
    private ArrayList populateChests() {
        Tile level1 = new Tile();
        ArrayList chestList = new ArrayList<>();
        int numberOfChests = 15;

        for (int i = 0; i < numberOfChests; i++) {

                int chestX = rnd.nextInt(20);
                int chestY = rnd.nextInt(12);
            if (level1.getMatrix()[chestY][chestX] != 1){
                chestList.add(new Chest(chestX, chestY));
            }
        }

        return chestList;
    }
    private void collectChest() {
        ArrayList collectedChests = new ArrayList<>();
        for (Object chest: chests) {
            if (kiskacsa.getPos().equals(((Chest)chest).getPos())) {

                collectedChests.add(chest);
            }
        }

        chests.removeAll(collectedChests);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RPG Game");
        Board board = new Board();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        frame.addKeyListener(board);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        kiskacsa.keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        kiskacsa.keyReleased(e);
    }

}