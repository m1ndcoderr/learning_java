package game.units.abstractions;

import game.Logger;
import game.units.abilities.MainAttack;

import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public abstract class Warrior extends Unit implements MainAttack {
    /**
     * Warrior's damage.
     */
    private double damage;

    /**
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public Warrior(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger);
        this.damage = damage;
    }

    /**
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     */
    public Warrior(double hp, boolean buffed, Logger logger) {
        super(hp, buffed, logger);
    }

    /**
     * Main unit ability.
     *
     * @param group enemy units.
     */
    @Override
    public void mainAttack(List<Unit> group) {
        double damage = this.getDamage();
        Unit opponent = this.chooseRandomUnitFromArray(group);
        String result;
        if (isBuffed()) {
            damage = damage + damage / 2;
            opponent.setHp(opponent.getHp() - damage);
            result = this.getClass().getSimpleName() + " deals extended "
                    + damage + " damage to " + opponent.getClass().getSimpleName() + ".";
            this.setBuffed(false);
        } else {
            opponent.setHp(opponent.getHp() - damage);
            result = this.getClass().getSimpleName() + " deals " + damage
                    + " damage to " + opponent.getClass().getSimpleName() + ".";
        }
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
        this.mainAttack(enemies);
    }

    /**
     * Gets damage.
     *
     * @return Value of damage.
     */
    public double getDamage() {
        return damage;
    }

    /**
     * Sets new damage.
     *
     * @param damage New value of damage.
     */
    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Warrior warrior = (Warrior) o;

        return Double.compare(warrior.damage, damage) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(damage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
