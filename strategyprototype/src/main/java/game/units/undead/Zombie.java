package game.units.undead;

import game.Logger;
import game.units.abstractions.Warrior;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Zombie extends Warrior {
    public Zombie(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger, damage);
    }
}
