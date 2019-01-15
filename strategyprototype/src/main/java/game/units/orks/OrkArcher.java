package game.units.orks;

import game.Logger;
import game.units.abstractions.Archer;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class OrkArcher extends Archer {
    public OrkArcher(double hp, boolean buffed, double damage, Logger logger, double rangedDamage) {
        super(hp, buffed, damage, logger, rangedDamage);
    }
}
