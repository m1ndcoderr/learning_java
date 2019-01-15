package game.units.undead;

import game.Logger;
import game.units.abstractions.Unit;
import game.units.elfs.ElfWarrior;
import game.units.humans.HumanWarrior;
import game.units.orks.Shaman;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.11.2017
 */
public class NecromancerTest {
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
     * Test of Necromancer's secondary ability (successful attack).
     */
    @Test
    public void whenNecromancerReducedSomeUnitsDamageThenWeGetLowerDamageOfThatUnit() {

        Necromancer necromancer = new Necromancer(HP, DEBUFFED, LOGGER, DAMAGE);
        ElfWarrior warrior = new ElfWarrior(HP, DEBUFFED, LOGGER, DAMAGE);
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(warrior);

        necromancer.secondaryAttack(testArray);
        double reducedDamage = DAMAGE / 2;
        ElfWarrior damagedUnit = (ElfWarrior) testArray.get(0);

        assertThat(damagedUnit.getDamage(), is(reducedDamage)); // Damage of a unit = 10/2 now.

        LOGGER.getComments().clear();
    }

    /**
     * Test of Necromancer's secondary ability (unsuccessful attack).
     */
    @Test
    public void whenNecromancerReducedSomeUnitWithoutDamageThenWeGetAMessageAboutThatInLogger() {

        Necromancer necromancer = new Necromancer(HP, DEBUFFED, LOGGER, DAMAGE);
        Shaman shaman = new Shaman(HP, DEBUFFED, LOGGER); // Unit without damage parameter.
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(shaman);

        necromancer.secondaryAttack(testArray);

        assertNotNull(LOGGER.getComments());

        LOGGER.getComments().clear();
    }

    /**
     * Test of action method.
     */
    @Test
    public void whenNecromancerAttacksAGroupOfEnemiesThenWeGetAMessagesAboutThatInLogger() {
        Necromancer necromancer = new Necromancer(HP, DEBUFFED, LOGGER, DAMAGE);
        ElfWarrior elfWarrior = new ElfWarrior(HP, DEBUFFED, LOGGER, DAMAGE);
        HumanWarrior humanWarrior = new HumanWarrior(HP, DEBUFFED, LOGGER, DAMAGE);
        Shaman shaman = new Shaman(HP, DEBUFFED, LOGGER); // Unit without damage parameter.
        ArrayList<Unit> testArray = new ArrayList<>();
        testArray.add(elfWarrior);
        testArray.add(humanWarrior);
        testArray.add(shaman);

        for (int i = 0; i != testArray.size(); i++) {
            necromancer.action(null, testArray);
        }

        assertNotNull(LOGGER.getComments());

        LOGGER.getComments().clear();
    }

}