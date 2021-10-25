import java.awt.*;

public class Wall extends Tile{

    public Wall() {

    }
    public void drawWall(Graphics graphics) {
        PositionedImage image;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (matrix[col][row] == 1) {
                    image = new PositionedImage("imgDark/wallBrickSimple.png",
                            row * 72, col* 72);
                    image.draw(graphics);
                }
            }
        }
    }
}
