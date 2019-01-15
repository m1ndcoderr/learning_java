package evgenyhodz;

/**
 * Class for searching factorial of number.
 */
public class Factorial {
    /**
     * Method computes the factorial.
     *
     * @param num - any number.
     * @return - int value.
     */
    public int getFac(int num) {
        int result = 1;
        if (num < 0) {
            throw new IllegalArgumentException("The value of num cannot be negative");
        } else if (num == 0 || num == 1) {
            result = 1;
        }
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}