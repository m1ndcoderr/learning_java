package evgenyhodz;

/**
 * Class to calculate square of triangle.
 */
public class Square {
    /**
     * Points.
     */
    public int a, b, c;

    /**
     * Square can be found with 3 points.
     *
     * @param a - int value.
     * @param b - int value.
     * @param c - int value.
     */
    Square(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Some calculations...
     *
     * @param x value.
     * @return float.
     */
    public float calculate(int x) {
        return a * (x * x) + b * x + c;
    }

    /**
     * Demonstration how for cycle works.
     *
     * @param start  - initialization.
     * @param finish - condition.
     * @param step   - iteration.
     */
    public void show(int start, int finish, int step) {

        for (int i = start; i <= finish; i += step) {
            System.out.println(calculate(i));
        }
    }

}