package game.units.abstractions;

import game.Logger;
import game.units.abilities.SecondaryAttack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public abstract class Archer extends Warrior implements SecondaryAttack {
    /**
     * Archer's ranged damage.
     */
    private double rangedDamage;

    /**
     * @param hp           - unit's health points.
     * @param buffed       buffed or not.
     * @param damage       damage points of attack.
     * @param logger       logger to write all action of unit to array.
     * @param rangedDamage damage points of ranged attack.
     */
    public Archer(double hp, boolean buffed, double damage, Logger logger, double rangedDamage) {
        super(hp, buffed, logger, damage);
        this.rangedDamage = rangedDamage;
    }

    /**
     * Additional ability.
     *
     * @param group on which the ability will be applied on.
     */
    @Override
    public void secondaryAttack(List<Unit> group) {
        double damage = this.getRangedDamage();
        String result;
        Unit unit = this.chooseRandomUnitFromArray(group);
        if (isBuffed()) {
            damage = damage + damage / 2;
            unit.setHp(unit.getHp() - damage);
            result = this.getClass().getSimpleName() + " deals extended "
                    + damage + " ranged damage to " + unit.getClass().getSimpleName() + ".";
            this.setBuffed(false);
        } else {
            unit.setHp(unit.getHp() - damage);
            result = this.getClass().getSimpleName() + " deals "
                    + damage + " ranged damage to " + unit.getClass().getSimpleName() + ".";
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
        int randomAction = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomAction == 0) {
            this.mainAttack(enemies);
        } else if (randomAction == 1) {
            this.secondaryAttack(enemies);
        }
    }

    /**
     * Sets new rangedDamage.
     *
     * @param rangedDamage New value of rangedDamage.
     */
    public void setRangedDamage(double rangedDamage) {
        this.rangedDamage = rangedDamage;
    }

    /**
     * Gets rangedDamage.
     *
     * @return Value of rangedDamage.
     */
    public double getRangedDamage() {
        return rangedDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Archer archer = (Archer) o;

        return Double.compare(archer.rangedDamage, rangedDamage) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(rangedDamage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
