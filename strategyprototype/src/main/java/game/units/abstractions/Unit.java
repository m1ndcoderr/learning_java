package game.units.abstractions;

import game.Logger;
import game.units.common.UnitAction;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public abstract class Unit implements UnitAction {
    /**
     * Unit's health.
     */
    private double hp;
    /**
     * Privilege which gives additional damage points.
     */
    private boolean buffed;
    /**
     * Logger which writes all actions of a unit to file.
     */
    private Logger logger;

    /**
     * Constructor.
     *
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     */
    public Unit(double hp, boolean buffed, Logger logger) {
        this.hp = hp;
        this.buffed = buffed;
        this.logger = logger;
    }

    /**
     * Chooses random unit from a list (to attack).
     *
     * @param list list of units.
     * @return randomly chosen unit.
     */
    protected Unit chooseRandomUnitFromArray(List<Unit> list) {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
    }

    /**
     * Gets hp.
     *
     * @return Value of hp.
     */
    public double getHp() {
        return hp;
    }

    /**
     * Sets new hp.
     *
     * @param hp New value of hp.
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * Gets buffed.
     *
     * @return Value of buffed.
     */
    public boolean isBuffed() {
        return buffed;
    }

    /**
     * Sets new buffed.
     *
     * @param buffed New value of buffed.
     */
    public void setBuffed(boolean buffed) {
        this.buffed = buffed;
    }

    /**
     * Sets new logger.
     *
     * @param logger New value of logger.
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Gets logger.
     *
     * @return Value of logger.
     */
    public Logger getLogger() {
        return logger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (Double.compare(unit.hp, hp) != 0) return false;
        if (buffed != unit.buffed) return false;
        return logger.equals(unit.logger);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(hp);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (buffed ? 1 : 0);
        result = 31 * result + logger.hashCode();
        return result;
    }
}
