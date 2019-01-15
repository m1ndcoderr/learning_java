package evgenyhodz;

/**
 * Class describing a triangle.
 */
public class Triangle {
    /**
     * Points in a Cartesian coordinate system.
     */
    public Point a, b, c;
    /**
     * Sides of triangle and semi-perimeter.
     */
    public double ab, ac, bc, s;

    /**
     * Constructor.
     *
     * @param a Point in a Cartesian coordinate system.
     * @param b Point in a Cartesian coordinate system.
     * @param c Point in a Cartesian coordinate system.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Method check if triangle exists (any 2 sides of triangle must be > third side).
     *
     * @return - true/false.
     */
    public boolean existence() {
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        return !(ab + ac <= bc || ab + bc <= ac || ac + bc <= ab || ab * ac * bc == 0);
    }

    /**
     * Calculating the area of ​​a triangle using Heron's formula.
     *
     * @return double value (number).
     */
    public double area() {
        ab = a.distanceTo(b);
        ac = a.distanceTo(c);
        bc = b.distanceTo(c);
        s = (ab + ac + bc) / 2;
        return Math.sqrt(s * (s - ab) * (s - ac) * (s - bc));
    }
}