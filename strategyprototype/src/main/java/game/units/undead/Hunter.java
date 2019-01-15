package game.units.undead;

import game.Logger;
import game.units.abstractions.Archer;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Hunter extends Archer {
    /**
     * Constructor.
     *
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public Hunter(double hp, boolean buffed, double damage, Logger logger, double rangedDamage) {
        super(hp, buffed, damage, logger, rangedDamage);
    }
}
