import java.awt.*;
import java.util.Random;

public class Wall extends Tile{
 Random rnd = new Random();
    public Wall() {

    }
    public void drawWall(Graphics graphics) {
        PositionedImage image;
       // int rand = rnd.nextInt(2);
        int berryOrNot = 0;
        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix.length; col++) {

                if (matrix[col][row] == 1 ) {
                    if(berryOrNot == 1) {
                        image = new PositionedImage("stardewAssets/bushSpring80px.png",
                                row * 72, col * 72);
                        image.draw(graphics);
                       // berryOrNot = 1;
                    }else if(berryOrNot == 0) {
                        image = new PositionedImage("stardewAssets/bushBerriesWithFloor.png",
                                row * 72, col * 72);
                        image.draw(graphics);
                       // berryOrNot = 0;
                    }else {
                        image = new PositionedImage("stardewAssets/bushSpring80px.png",
                                row * 72, col * 72);
                        image.draw(graphics);
                    }

                }
            }
        }
    }
}
