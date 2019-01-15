package game.units.humans;

import game.Logger;
import game.units.abstractions.Unit;
import game.units.abstractions.Warrior;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class HumanWarrior extends Warrior {
    /**
     * Constructor.
     *
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public HumanWarrior(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger, damage);
    }

}
