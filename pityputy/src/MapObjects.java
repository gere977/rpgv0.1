import java.awt.*;

public class MapObjects extends Tile{

    public void drawStartDoor(Graphics graphics) {
        PositionedImage door = new PositionedImage("imgDark/doorv0START.png",0,0);
        door.draw(graphics);
    }
}
