package game.units.undead;

import game.Logger;
import game.units.abstractions.Mage;
import game.units.abstractions.Unit;
import game.units.abstractions.Warrior;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Necromancer extends Mage {
    /**
     * @param hp     unit's health.
     * @param buffed buff.
     * @param logger logger.
     * @param damage damage points of the unit.
     */
    public Necromancer(double hp, boolean buffed, Logger logger, double damage) {
        super(hp, buffed, logger, damage);
    }

    /**
     * Additional ability.
     *
     * @param group on which the ability will be applied on.
     */
    @Override
    public void secondaryAttack(List<Unit> group) {
        String result;
        Unit unit = this.chooseRandomUnitFromArray(group);
        if (objectHasField(unit)) { // нужно выяснить, есть ли поле у юнита (да, может не быть!).
            Warrior warrior = (Warrior) unit;
            double damage = warrior.getDamage() / 2;
            warrior.setDamage(damage);
            result = this.getClass().getSimpleName()
                    + " reduce damage of " + unit.getClass().getSimpleName() + ".";
        } else {
            result = this.getClass().getSimpleName() + " cannot reduce damage of "
                    + unit.getClass().getSimpleName() + " (unit doesn't have a \"damage\" parameter).";
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
        // Маг нежити применяет свои способности только на врагах.
        int randomAction = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomAction == 0) {
            this.mainAttack(enemies);
        } else if (randomAction == 1) {
            this.secondaryAttack(enemies);
        }
    }

    /**
     * Finds number of fields of a subclass.
     *
     * @param unit  - some unit.
     * @return boolean.
     */
    private boolean objectHasField(Unit unit) {
        // Здесь мы берем количество параметров юнита. Если оно больше 3, то предположительно
        // 4-ый параметр всегда "damage" (пускай в этой игре будет так). Как выяснить, есть ли
        // поле у конкретного subclass я не знаю, названия полей теряются после компиляции.
        // Технически этот метод здесь и не нужен по ТЗ, т.к. орков атаковать мы не будем все равно
        // (только у орков есть юнит без damage), но теоретически такой юнит в игре может появиться.
        boolean result = false;
        Constructor[] constructors = unit.getClass().getConstructors();
        for (int i = 0; i != constructors.length; i++) {
            Constructor constructor = constructors[i];
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length > 3) {
                result = true;
            }
        }
        return result;
    }

}
