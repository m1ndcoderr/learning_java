package evgenyhodz;

/**
 * Class to find max side of triangle. Can be used to find max of three numbers.
 */
public class MaxSide {
    /**
     * Method for finding the maximum of the three values.
     *
     * @param first  value.
     * @param second value.
     * @param third  value.
     * @return - double value (number).
     */
    public double findMaxSide(double first, double second, double third) {
        return Math.max(first, Math.max(second, third));
    }

}