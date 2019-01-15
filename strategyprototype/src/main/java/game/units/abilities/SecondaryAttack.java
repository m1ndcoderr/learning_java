package game.units.abilities;

import game.units.abstractions.Unit;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public interface SecondaryAttack {
    /**
     * Additional ability.
     *
     * @param group on which the ability will be applied on.
     */
    void secondaryAttack(List<Unit> group);
}
