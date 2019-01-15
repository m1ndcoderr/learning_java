package game;

import game.units.abstractions.Unit;

import game.units.elfs.ElfArcher;
import game.units.elfs.ElfMagician;
import game.units.elfs.ElfWarrior;
import game.units.humans.Crossbowman;
import game.units.humans.HumanWarrior;
import game.units.humans.Wizard;
import game.units.orks.Goblin;
import game.units.orks.OrkArcher;
import game.units.orks.Shaman;
import game.units.undead.Hunter;
import game.units.undead.Necromancer;
import game.units.undead.Zombie;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 14.11.2017
 */
public class Manager {
    /**
     * First group - elfs or humans.
     */
    private ArrayList<Unit> first;
    /**
     * Second group - orks or undeads.
     */
    private ArrayList<Unit> second;

    /**
     * Buffed units.
     */
    private ArrayList<Unit> privileged = new ArrayList<>();
    /**
     * Usual units without buff.
     */
    private ArrayList<Unit> notPrivileged = new ArrayList<>();

    /**
     * Logger.
     */
    private Logger logger;

    public Manager(Logger logger) {
        this.logger = logger;
    }

    public void start() {
        prepareBattle();
        elfsAttack();


    }

    /**
     * Creates log file with battle movements.
     *
     * @param list - list with strings.
     */
    public void createLog(List<String> list) {
        try {
            FileWriter log = new FileWriter("battle log.txt");
            for (String str : list) {
                log.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeMove() {

//        int firstGroupSize = first.size();
//        int secondGroupSize = second.size();
//
//        for (Unit unit : first) {
//            if (unit.getClass().getSimpleName().contains("ElfWarrior")) {
//                ElfWarrior elfWarrior = (ElfWarrior) unit;
//                logger.addComment(elfWarrior.mainAttack(second.get(makeChoice(secondGroupSize))));
//                for (String str : logger.getComments()) {
//                    System.out.println(str);
//                }
//            }
//        }


    }

    /**
     * TODO Атака эльфов:
     * 1. раскидываются привилигированные и не привилигированные на две группы.
     * 2. атакуют привилигированные
     * 3. атакуют непривилигированные.
     * 4. удаляем воинов с хп меньше 0
     */
    private void elfsAttack() {
        checkPrivileges(first);
        elfsMakeMove(privileged);
        elfsMakeMove(notPrivileged);
        removeDeadSoldiers(second);
    }

    /**
     * TODO Такой же метод для остальных рас ?
     *
     * @param group
     */
    private void elfsMakeMove(ArrayList<Unit> group) {
        if (!group.isEmpty()) {
            Iterator<Unit> it = group.iterator();
            while (it.hasNext()) {
                Unit unit = it.next();
                String child = unit.getClass().getSimpleName();
                if (child.equals("ElfWarrior")) {
                    ElfWarrior elfWarrior = (ElfWarrior) unit;
                    elfWarrior.mainAttack(second);
                    backToMainGroup(elfWarrior, first, group);
                }
                if (child.equals("ElfArcher")) {
                    ElfArcher elfArcher = (ElfArcher) unit;
                    int attackType = makeChoice();
                    if (attackType == 0) {
                        elfArcher.mainAttack(second);
                        backToMainGroup(elfArcher, first, group);
                    } else {
                        elfArcher.secondaryAttack(second);
                        backToMainGroup(elfArcher, first, group);
                    }
                }
                if (child.equals("ElfMagician")) {
                    ElfMagician elfMagician = (ElfMagician) unit;
                    int attackType = makeChoice();
                    if (attackType == 0) {
                        elfMagician.mainAttack(second);
                        backToMainGroup(elfMagician, first, group);
                    } else {
                        elfMagician.secondaryAttack(second);
                        backToMainGroup(elfMagician, first, group);
                    }
                }
            }
        }
    }

    /**
     * Returns units back to their basic group.
     *
     * @param unit      unit for return.
     * @param mainGroup group to return.
     * @param secondary group to delete unit from.
     */
    private void backToMainGroup(Unit unit, ArrayList<Unit> mainGroup, ArrayList<Unit> secondary) {
        mainGroup.add(unit);
        secondary.remove(unit);
    }

    /**
     * Checks all units in the list if they are buffed or not and sending them to privileged/not privileged group.
     *
     * @param group group to check.
     */
    private void checkPrivileges(ArrayList<Unit> group) {
        Iterator<Unit> it = group.iterator();
        while (it.hasNext()) {
            Unit unit = it.next();
            if (unit.isBuffed()) {
                privileged.add(unit);
                it.remove();
            } else {
                notPrivileged.add(unit);
                it.remove();
            }
        }
    }

    /**
     * Random choice from a range.
     *
     * @param size - size of something (array).
     * @return number.
     */
    private int makeChoice(int size) {
        return ThreadLocalRandom.current().nextInt(0, size);
    }

    /**
     * Makes random choice between one and another.
     *
     * @return 0 or 1.
     */
    private int makeChoice() {
        return ThreadLocalRandom.current().nextInt(0, 2);
    }

    /**
     * Removes all units with hp <= 0 from array.
     *
     * @param group group to check out.
     */
    private void removeDeadSoldiers(ArrayList<Unit> group) {
        for (Unit unit : group) {
            if (unit.getHp() <= 0) {
                group.remove(unit);
            }
        }
    }

    /**
     * Prepares two random teams for battle and sending message about it.
     */
    private void prepareBattle() {
        String result;
        int firstTeam = makeChoice();
        int secondTeam = makeChoice();
        if (firstTeam == 0) {
            createElfs(100, 10, 3, 7, 15);
            result = "Elfs vs ";
        } else {
            createHumans(100, 4, 3, 5, 18);
            result = "Humans vs ";
        }
        if (secondTeam == 0) {
            createOrks(100, 2, 3, 20);
            result = result + "Orks.";
        } else {
            createUndeads(100, 5, 2, 4, 18);
            result = result + "Undead.";
        }
        System.out.println(result);
        this.logger.addComment("Preparing battle...\n" + result);
    }



    /**
     * Creates team of elfs.
     *
     * @param hp              health of each unit.
     * @param mageDmg         mage's damage.
     * @param archerMainDmg   archer's damage.
     * @param archerRangedDmg - archer's ranged damage.
     * @param warriorDmg      - warrior's damage.
     */
    private void createElfs(double hp, double mageDmg, double archerMainDmg, double archerRangedDmg, double warriorDmg) {
        first = new ArrayList<>();
        first.add(new ElfMagician(hp, false, logger, mageDmg));
        first.add(new ElfArcher(hp, false, archerMainDmg, logger, archerRangedDmg));
        first.add(new ElfArcher(hp, false, archerMainDmg, logger, archerRangedDmg));
        first.add(new ElfArcher(hp, false, archerMainDmg, logger, archerRangedDmg));
        first.add(new ElfWarrior(hp, false, logger, warriorDmg));
        first.add(new ElfWarrior(hp, false, logger, warriorDmg));
        first.add(new ElfWarrior(hp, false, logger, warriorDmg));
        first.add(new ElfWarrior(hp, false, logger, warriorDmg));
    }

    /**
     * Creates team of humans.
     *
     * @param hp              health of each unit.
     * @param mageDmg         mage's damage.
     * @param archerMainDmg   archer's damage.
     * @param archerRangedDmg - archer's ranged damage.
     * @param warriorDmg      - warrior's damage.
     */
    private void createHumans(double hp, double mageDmg, double archerMainDmg, double archerRangedDmg, double warriorDmg) {
        first = new ArrayList<>();
        first.add(new Wizard(hp, false, logger, mageDmg));
        first.add(new Crossbowman(hp, false, archerMainDmg, logger, archerRangedDmg));
        first.add(new Crossbowman(hp, false, archerMainDmg, logger, archerRangedDmg));
        first.add(new Crossbowman(hp, false, archerMainDmg, logger, archerRangedDmg));
        first.add(new HumanWarrior(hp, false, logger, warriorDmg));
        first.add(new HumanWarrior(hp, false, logger, warriorDmg));
        first.add(new HumanWarrior(hp, false, logger, warriorDmg));
        first.add(new HumanWarrior(hp, false, logger, warriorDmg));
    }

    /**
     * Creates team of orks.
     *
     * @param hp              health of each unit.
     * @param archerMainDmg   archer's damage.
     * @param archerRangedDmg - archer's ranged damage.
     * @param warriorDmg      - warrior's damage.
     */
    private void createOrks(double hp, double archerMainDmg, double archerRangedDmg, double warriorDmg) {
        second = new ArrayList<>();
        second.add(new Shaman(hp, false, logger));
        second.add(new OrkArcher(hp, false, archerMainDmg, logger, archerRangedDmg));
        second.add(new OrkArcher(hp, false, archerMainDmg, logger, archerRangedDmg));
        second.add(new OrkArcher(hp, false, archerMainDmg, logger, archerRangedDmg));
        second.add(new Goblin(hp, false, logger, warriorDmg));
        second.add(new Goblin(hp, false, logger, warriorDmg));
        second.add(new Goblin(hp, false, logger, warriorDmg));
        second.add(new Goblin(hp, false, logger, warriorDmg));
    }

    /**
     * Creates team of undeads.
     *
     * @param hp              health of each unit.
     * @param mageDmg         mage's damage.
     * @param archerMainDmg   archer's damage.
     * @param archerRangedDmg - archer's ranged damage.
     * @param warriorDmg      - warrior's damage.
     */
    private void createUndeads(double hp, double mageDmg, double archerMainDmg, double archerRangedDmg, double warriorDmg) {
        second = new ArrayList<>();
        second.add(new Necromancer(hp, false, logger, mageDmg));
        second.add(new Hunter(hp, false, archerMainDmg, logger, archerRangedDmg));
        second.add(new Hunter(hp, false, archerMainDmg, logger, archerRangedDmg));
        second.add(new Hunter(hp, false, archerMainDmg, logger, archerRangedDmg));
        second.add(new Zombie(hp, false, logger, warriorDmg));
        second.add(new Zombie(hp, false, logger, warriorDmg));
        second.add(new Zombie(hp, false, logger, warriorDmg));
        second.add(new Zombie(hp, false, logger, warriorDmg));
    }


}
