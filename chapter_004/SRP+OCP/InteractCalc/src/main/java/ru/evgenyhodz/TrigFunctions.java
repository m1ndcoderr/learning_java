package ru.evgenyhodz;

import evgenyhodz.Calculate;

/**
 * Extending class of Calculate, some trigonometric functions added.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.12.2016
 */
public class TrigFunctions extends Calculate {
    /**
     * Ref to get setter.
     */
    private Calculate calculate;

    /**
     * We write results to calculate class's field (double result).
     *
     * @param calculate - calculate ref.
     */
    public TrigFunctions(Calculate calculate) {
        this.calculate = calculate;
    }

    /**
     * Calculates tangent of angle.
     *
     * @param num - number for calculations.
     */
    public void sinus(double num) {
        calculate.setResult(Math.sin(num));
    }

    /**
     * Calculates tangent of angle.
     *
     * @param num - number for calculations.
     */
    public void cosine(double num) {
        calculate.setResult(Math.cos(num));
    }

    /**
     * Calculates tangent of angle.
     *
     * @param num - number for calculations.
     */
    public void tangent(double num) {
        calculate.setResult(Math.tan(num));
    }
}
