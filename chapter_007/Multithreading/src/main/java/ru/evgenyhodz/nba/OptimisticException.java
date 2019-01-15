package ru.evgenyhodz.nba;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.03.2017
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(String message) {
        super(message);
    }
}
