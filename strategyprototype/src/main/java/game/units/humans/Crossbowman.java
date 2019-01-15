package game.units.humans;

import game.Logger;
import game.units.abstractions.Archer;
import game.units.abstractions.Unit;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Crossbowman extends Archer {
    public Crossbowman(double hp, boolean buffed, double damage, Logger logger, double rangedDamage) {
        super(hp, buffed, damage, logger, rangedDamage);
    }
}
