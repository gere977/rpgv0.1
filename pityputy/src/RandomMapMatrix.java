import java.util.Random;

public class RandomMapMatrix {
    protected int[][] matrix = new int[12][19];


    public void generate() {
        Random random = new Random();

        for (int outerIndex = 0; outerIndex < matrix.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < matrix[outerIndex].length; innerIndex++) {
                if (random.nextDouble() < 0.5) {
                    matrix[outerIndex][innerIndex] = 1;
                } else {
                    matrix[outerIndex][innerIndex] = 0;
                }
            }
        }
    }

    public int[][] getMatrix() {
        generate();
        return matrix;
    }
}
