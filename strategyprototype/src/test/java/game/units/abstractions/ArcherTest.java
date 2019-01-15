package game.units.abstractions;

import game.Logger;
import game.units.elfs.ElfArcher;
import game.units.undead.Hunter;
import game.units.undead.Zombie;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.11.2017
 */
public class ArcherTest {
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
     * Unit's ranged damage.
     */
    private static final double RANGED = 8;
    /**
     * Default value of all units.
     */
    private static final boolean DEBUFFED = false;
    /**
     * Buffs a unit.
     */
    private static final boolean BUFFED = true;

    /**
     * Test of secondary attack (buffed unit).
     */
    @Test
    public void whenDebuffedUnitAttacksThenWeGetDamagedEnemy() {
        Archer first = new ElfArcher(HP, DEBUFFED, DAMAGE, LOGGER, RANGED);
        Archer second = new Hunter(HP, DEBUFFED, DAMAGE, LOGGER, RANGED);
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(second);

        first.secondaryAttack(testArray);
        Archer damagedUnit = (Hunter) testArray.get(0);

        assertThat(damagedUnit.getHp(), is(92D)); // 100 hp - 8 damage = 92.

        LOGGER.getComments().clear();
    }

    /**
     * Test of secondary attack (buffed unit).
     */
    @Test
    public void whenBuffedUnitAttacksItHaveIncreasedDamageAndAlsoThenWeGetDamagedEnemy() {
        Archer first = new ElfArcher(HP, BUFFED, DAMAGE, LOGGER, RANGED);
        Archer second = new Hunter(HP, DEBUFFED, DAMAGE, LOGGER, RANGED);
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(second);

        first.secondaryAttack(testArray);
        Archer damagedUnit = (Hunter) testArray.get(0);

        assertThat(damagedUnit.getHp(), is(88D)); // 100 hp - 12 damage = 88.

        LOGGER.getComments().clear();
    }

}