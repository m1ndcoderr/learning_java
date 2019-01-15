package evgenyhodz;

/**
 * Class contains methods with simple calculations.
 */
public class Calculate {
    /**
     * Result of calculate operation.
     */
    private double result;

    /**
     * Getter.
     *
     * @return result of calculation.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Setter.
     * @param result - double value.
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Operation of addition.
     *
     * @param first  - first value (number).
     * @param second - second value.
     */
    public void add(double first, double second) {
        this.result = first + second;

    }

    /**
     * Operation of subtraction.
     *
     * @param first  - first value (number).
     * @param second - second value.
     */
    public void sub(double first, double second) {
        this.result = first - second;

    }

    /**
     * Operation of multiplication.
     *
     * @param first  - first value (number).
     * @param second - second value.
     */
    public void mul(double first, double second) {
        this.result = first * second;


    }

    /**
     * Operation of division.
     *
     * @param first  - first value (number).
     * @param second - second value.
     */
    public void div(double first, double second) {
        if (second != 0) {
            this.result = first / second;
        } else {
            throw new ArithmeticException("Could not div by 0");
        }

    }
}
