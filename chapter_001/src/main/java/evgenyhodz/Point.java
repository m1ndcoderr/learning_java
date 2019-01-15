package evgenyhodz;

/**
 * Class describing a point in a Cartesian coordinate system.
 */
public class Point {
    /**
     * Point on the x-axis.
     */
    public double x;
    /**
     * Point on the x-axis.
     */
    public double y;

    /**
     * Constructor.
     *
     * @param x Point on the x-axis.
     * @param y Point on the y-axis.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculating distance between x and y.
     *
     * @param point - a point in a Cartesian coordinate system.
     * @return - double value.
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.y - this.y, 2) + Math.pow(point.x - this.x, 2));
    }
}