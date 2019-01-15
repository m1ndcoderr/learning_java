package game.units.abstractions;

import game.Logger;
import game.units.elfs.ElfWarrior;
import game.units.undead.Zombie;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.11.2017
 */
public class WarriorTest {
    /**
     * Logger.
     */
    private static final Logger LOGGER = new Logger(new ArrayList<>());
    /**
     * Unit's health.
     */
    private static final double HP = 100;
    /**
     * Unit's damage.
     */
    private static final double DAMAGE = 10;
    /**
     * Default value of all units.
     */
    private static final boolean DEBUFFED = false;
    /**
     * Buffs a unit.
     */
    private static final boolean BUFFED = true;

    /**
     * Test of main attack (debuffed unit).
     */
    @Test
    public void whenDebuffedUnitAttacksThenWeGetDamagedEnemy() {
        Warrior first = new ElfWarrior(HP, DEBUFFED, LOGGER, DAMAGE);
        Warrior second = new Zombie(HP, DEBUFFED, LOGGER, DAMAGE);
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(second);

        first.mainAttack(testArray);
        Zombie damagedUnit = (Zombie) testArray.get(0);

        assertThat(damagedUnit.getHp(), is(90D)); // 100 hp - 10 damage = 90.

        LOGGER.getComments().clear();
    }

    /**
     * Test of main attack (buffed unit).
     */
    @Test
    public void whenBuffedUnitAttacksItHaveIncreasedDamageAndAlsoThenWeGetDamagedEnemy() {
        Warrior first = new ElfWarrior(HP, BUFFED, LOGGER, DAMAGE);
        Warrior second = new Zombie(HP, DEBUFFED, LOGGER, DAMAGE);
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(second);

        first.mainAttack(testArray);
        Zombie damagedUnit = (Zombie) testArray.get(0);

        assertThat(damagedUnit.getHp(), is(85D)); // 100 hp - (10*50%) damage = 85.

        LOGGER.getComments().clear();
    }
}