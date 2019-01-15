package game.units.abstractions;

import game.Logger;
import game.units.abilities.SecondaryAttack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public abstract class Mage extends Warrior implements SecondaryAttack {
    /**
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public Mage(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger, damage);
    }

    /**
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     */
    public Mage(double hp, boolean buffed, Logger logger) {
        super(hp, buffed, logger);
    }

    /**
     * Additional ability. // улучшение своего.
     *
     * @param allyGroup on which the ability will be applied on.
     */
    @Override
    public void secondaryAttack(List<Unit> allyGroup) {
        Unit ally = this.chooseRandomUnitFromArray(allyGroup);
        ally.setBuffed(true);
        String result = ally.getClass().getSimpleName() + " is buffed.";
        System.out.println(result);
        this.getLogger().addComment(result);
    }

    /**
     * Executes some action of the unit. Action is determined randomly. Common method for all units.
     * <p>
     * Extended method for some units.
     *
     * @param allies  group to use action on.
     * @param enemies group on which the ability will be applied on.
     */
    @Override
    public void action(List<Unit> allies, List<Unit> enemies) {
        int randomAction = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomAction == 0) {
            this.mainAttack(enemies);
        } else if (randomAction == 1) {
            this.secondaryAttack(allies); // здесь действие применяется на союзниках.
        }
    }
}
