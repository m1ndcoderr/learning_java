package ru.evgenyhodz.bomberman;

import java.util.EnumMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to create coordinates for figures.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 08.04.2017
 */
public class StepMaker {
    /**
     * Map with Step enums as keys and Integer[] arrays as values.
     */
    private final EnumMap<Step, int[]> steps = new EnumMap<>(Step.class);

    /**
     * Fills map with pair values.
     */
    void fillEnumMap() {
        this.steps.put(Step.UP, new int[]{-1, 0});
        this.steps.put(Step.DOWN, new int[]{1, 0});
        this.steps.put(Step.LEFT, new int[]{0, -1});
        this.steps.put(Step.RIGHT, new int[]{0, 1});
    }

    /**
     * Random choice of next step except
     *
     * @return new step.
     */
    Step choose() {
        return Step.values()[ThreadLocalRandom.current().nextInt(Step.values().length)];
    }

    /**
     * Generate coordinate to make a step.
     * If step equals null there will be random choice where to move.
     *
     * @param x    - start position.
     * @param y    - start position.
     * @param step - enum Step. UP, DOWN, LEFT, RIGHT. Could be null.
     * @return array with coordinates.
     */
    int[] getDestination(int x, int y, Step step) {
        int[] way = this.steps.get(step);
        return new int[]{x + way[0], y + way[1]};
    }
}
