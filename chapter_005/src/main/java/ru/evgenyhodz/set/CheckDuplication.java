package ru.evgenyhodz.set;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.02.2017
 */
public interface CheckDuplication<R> {
    /**
     * Checking if element with such value is already exist in the array.
     *
     * @param value - value to compare with.
     * @return - true/false.
     */
    boolean isDuplicate(R value);
}
