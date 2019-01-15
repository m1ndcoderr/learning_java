package game.units.orks;

import game.Logger;
import game.units.abstractions.Mage;
import game.units.abstractions.Unit;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Shaman extends Mage {
    public Shaman(double hp, boolean buffed, Logger logger) {
        super(hp, buffed, logger);
    }

    /**
     * Main unit ability.
     *
     * @param group enemy units.
     */
    @Override
    public void mainAttack(ArrayList<Unit> group) {
        String result;
        Unit enemy = this.chooseRandomUnitFromArray(group);
        if (enemy.isBuffed()) {
            enemy.setBuffed(false);
            result = enemy.getClass().getSimpleName() + " is debuffed by " + this.getClass().getSimpleName() + ".";
            System.out.println(result);
            this.getLogger().addComment(result);
        }
    }
}
