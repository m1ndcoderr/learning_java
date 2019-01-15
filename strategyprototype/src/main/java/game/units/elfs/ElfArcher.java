package game.units.elfs;

import game.Logger;
import game.units.abstractions.Archer;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class ElfArcher extends Archer {
    /**
     * @param hp           - unit's health points.
     * @param buffed       buffed or not.
     * @param damage       damage points of attack.
     * @param logger       logger to write all action of unit to array.
     * @param rangedDamage damage points of ranged attack.
     */
    public ElfArcher(double hp, boolean buffed, double damage, Logger logger, double rangedDamage) {
        super(hp, buffed, damage, logger, rangedDamage);
    }
}
