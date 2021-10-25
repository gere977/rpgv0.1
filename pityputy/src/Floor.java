import java.awt.*;

public class Floor extends Tile{

public Floor() {
}
public void drawFloor(Graphics graphics) {
    PositionedImage image;
    for (int row = 0; row < 10; row++) {
        for (int col = 0; col < 10; col++) {
            if (matrix[col][row] == 0) {
                image = new PositionedImage("imgDark/floortilewithEDgeDarkv2.png",
                        row * 72, col* 72);
                image.draw(graphics);
            }
        }
    }
}
}

