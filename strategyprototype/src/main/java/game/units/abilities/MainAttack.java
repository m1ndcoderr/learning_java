package game.units.abilities;

import game.units.abstractions.Unit;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public interface MainAttack {
    /**
     * Main unit ability.
     *
     * @param enemies enemy units.
     */
    void mainAttack(List<Unit> enemies);

}
