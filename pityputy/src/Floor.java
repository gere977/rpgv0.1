import java.awt.*;

public class Floor extends Tile{

public Floor() {
}
public void drawFloor(Graphics graphics) {
    PositionedImage image;
    for (int row = 0; row < matrix[0].length; row++) {
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[col][row] == 0) {
                image = new PositionedImage("stardewAssets/springFloorBasic.png",
                        row * 72, col* 72);
                image.draw(graphics);
            }
        }
    }
}
}

