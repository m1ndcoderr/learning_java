package game.units.elfs;

import game.Logger;
import game.units.abstractions.Mage;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class ElfMagician extends Mage {
    /**
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public ElfMagician(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger, damage);
    }
}
