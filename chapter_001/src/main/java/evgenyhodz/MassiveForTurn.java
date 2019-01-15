package evgenyhodz;

/**
 * Class contains API to turn two-dimensional array by 90 degrees to the left or to the right.
 */
public class MassiveForTurn {
    /**
     * Link to 2-dimensional array.
     */
    public int[][] values;

    /**
     * Constructor.
     *
     * @param values - 2-dimensional array.
     */
    public MassiveForTurn(int[][] values) {
        this.values = values;
    }

    /**
     * Method to do transpose operation with array.
     *
     * @param values - 2-dimensional array.
     */
    public void wowTransposition(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values[0].length; j++) {
                int temp = values[i][j];
                values[i][j] = values[j][i];
                values[j][i] = temp;
            }
        }
    }

    /**
     * Method to rotate transposed array to the left by 90 degrees.
     *
     * @param values - 2-dimensional array.
     */
    public void rotateByNinetyToLeft(int[][] values) {
        wowTransposition(values);
        for (int i = 0; i < values.length / 2; i++) {
            for (int j = 0; j < values[0].length; j++) {
                int x = values[i][j];
                values[i][j] = values[values.length - 1 - i][j];
                values[values.length - 1 - i][j] = x;

            }
        }
    }

    /**
     * Method to rotate transposed array to the right by 90 degrees.
     *
     * @param values - 2-dimensional array.
     */
    public void rotateByNinetyToRight(int[][] values) {
        wowTransposition(values);
        for (int j = 0; j < values[0].length / 2; j++) {
            for (int i = 0; i < values.length; i++) {
                int x = values[i][j];
                values[i][j] = values[i][values[0].length - 1 - j];
                values[i][values[0].length - 1 - j] = x;

            }
        }
    }
}