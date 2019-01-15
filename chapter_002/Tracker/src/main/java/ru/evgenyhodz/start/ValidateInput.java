package ru.evgenyhodz.start;

import java.util.ArrayList;

/**
 * Class to validate user's input parameters.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Boolean value.
     */
    private boolean error;

    /**
     * Method check if user's input is correct.
     *
     * @param question - question to user.
     * @param range    - array with keys.
     * @return - int value.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Error! Please, select key from menu.");
            } catch (ArrayIndexOutOfBoundsException aio) {
                System.out.println("Please, enter the correct key of action (0-9): ");
            }
        } while (invalid);
        return value;
    }

    /**
     * Check if id already exist in the storage.
     *
     * @param id      - id to check.
     * @param tracker - class with actions.
     * @return - true/false.
     */
    public boolean checkIdForException(String id, Tracker tracker) {
        ArrayList<String> arrayOfIDs = tracker.showAllIDs();
        for (String arrayOfID : arrayOfIDs) {
            this.error = id != null && !id.equals(arrayOfID);
        }
        return this.error;
    }

    /**
     * Check if entered date is correct.
     *
     * @param day   - string value.
     * @param month - string value.
     * @param year  - string value.
     * @return - true/false.
     */
    public boolean checkDate(String day, String month, String year) {
        int x = Integer.parseInt(day);
        int y = Integer.parseInt(month);
        int z = Integer.parseInt(year);
        error = !(1 <= x && x <= 31 && 1 <= y && y <= 12 && 1000 <= z && z <= 3000);
        return error;
    }

    /**
     * Checking if entered names are correct.
     *
     * @param tracker - class with actions.
     * @param name    - string value.
     * @return - true/false.
     */
    public boolean checkNames(String name, Tracker tracker) {
        ArrayList<String> arrayOfNames = tracker.showAllNames();
        for (String arrayOfName : arrayOfNames) {
            this.error = !(name != null && name.equals(arrayOfName));
        }
        return this.error;
    }
}
