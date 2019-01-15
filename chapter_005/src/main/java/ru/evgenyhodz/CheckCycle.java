package ru.evgenyhodz;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 20.02.2017
 */
interface CheckCycle {
    /**
     * Checks the list have cyclic recurrence.
     *
     * @param first - element to start check.
     * @return - true/false.
     */
    boolean hasCycle(Node first);
}
