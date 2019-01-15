package game.units.common;

import game.units.abstractions.Unit;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.11.2017
 */
public interface UnitAction {
//    /**
//     * Executes some action of the unit. Action is determined randomly. Common method for all units.
//     *
//     * @param group group to use action on.
//     */
//    public void action(List<Unit> group);

    /**
     * Executes some action of the unit. Action is determined randomly. Common method for all units.
     * <p>
     * Extended method for some units.
     *
     * @param allies  group to use action on.
     * @param enemies group on which the ability will be applied on.
     */
    public void action(List<Unit> allies, List<Unit> enemies);
}
