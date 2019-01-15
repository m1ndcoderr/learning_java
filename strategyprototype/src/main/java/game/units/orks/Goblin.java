package game.units.orks;

import game.Logger;
import game.units.abstractions.Warrior;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Goblin extends Warrior {
    /**
     * Constructor.
     *
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public Goblin(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger, damage);
    }
}
