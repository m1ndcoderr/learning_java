package ru.evgenyhodz.start;

import ru.evgenyhodz.models.Application;

public class MenuTracker {
    /**
     * User's input.
     */
    private Input input;
    /**
     * Actions.
     */
    private Tracker tracker;
    /**
     * Check of user's input.
     */
    private ValidateInput validate;
    /**
     * Menu storage of actions.
     */
    private UserAction[] actions = new UserAction[10];
    /**
     * Boolean value to exit from program.
     */
    private boolean exit = false;

    /**
     * Constructor of menu.
     *  @param input   - user's input.
     * @param tracker - program actions.
     * @param validate
     */
    public MenuTracker(Input input, Tracker tracker, ValidateInput validate) {
        this.input = input;
        this.tracker = tracker;
        this.validate = validate;
    }

    /**
     * Filling storage with full user's actions.
     */
    public void fillActions() {
        this.actions[0] = new AddApplication();
        this.actions[1] = new EditApplication();
        this.actions[2] = new CommentApplication();
        this.actions[3] = new DeleteApplication();
        this.actions[4] = new ShowAllApps();
        this.actions[5] = new ShowAppByName();
        this.actions[6] = new DeleteByName("Delete Application By Name");
        this.actions[7] = new ShowByNameBasAct("Show Application By Name Throw BaseAction");
        this.actions[8] = new PrintAll("PRINT ALL DATA");
        this.actions[9] = new Exit("Exit.");
    }

    /**
     * Method selects action by key.
     *
     * @param key
     */
    public void select(int key) {
        try {
            this.actions[key].execute(this.input, this.tracker);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("There is no such action. Choose from 0-9.");
        }
    }

    /**
     * To exit from program.
     *
     * @return - true/false.
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * Method to show all user's actions.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Inner class that realize possibility to add application to Tracker.
     */
    private class AddApplication implements UserAction {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the name of application: ");
            tracker.addApp(new Application(name, null, null));
        }

        /**
         * Shows some sort of info about action.
         *
         * @return string value.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Application.");
        }
    }

    /**
     * Inner class to edit applications in storage.
     */
    private class EditApplication implements UserAction {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the id of application: ");
            if (validate.checkIdForException(id, tracker)) {
                System.out.println("ID NOT FOUND...Please, try another.");
            } else {
                String name = input.ask("Please, re-enter the name of application: ");
                String desc = input.ask("Please, edit the description of application: ");
                String year = input.ask("Setting the date. YEAR (1000 to 3000): ");
                String month = input.ask("Enter the MONTH (1 to 12): ");
                String day = input.ask("Enter the DAY (1 to 31): ");
                if (validate.checkDate(day, month, year)) {
                    System.out.println("Date is not correct! Try again.");
                } else {
                    String date = day + "/" + month + "/" + year;
                    Application fresh = new Application(id, name, desc, date, null);
                    tracker.editApp(fresh);
                    System.out.println("Edited successfully.");
                }
            }
        }

        /**
         * Shows some sort of info about action.
         *
         * @return string value.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "EDIT Application.");
        }
    }

    /**
     * Possibility to add comment to application.
     */
    private class CommentApplication implements UserAction {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the application's id: ");
            if (validate.checkIdForException(id, tracker)) {
                System.out.println("There is no such application's id,\nplease, enter the correct Id next time.");
            } else {
                String comment = input.ask("Please, enter the comment: ");
                tracker.showById(id).setComment(comment);
            }
        }

        /**
         * Shows some sort of info about action.
         *
         * @return string value.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Create A COMMENT for Application.");
        }
    }

    /**
     * Possibility to delete application from storage.
     */
    private class DeleteApplication implements UserAction {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String deleteId = input.ask("Please, enter the ID of application you would like to delete: ");
            if (validate.checkIdForException(deleteId, tracker)) {
                System.out.println("There is no such id, please, enter the correct Id next time.");
            } else {
                tracker.deleteApp(deleteId);
                System.out.println("Deleting was successful.");
            }
        }

        /**
         * Shows some sort of info about action.
         *
         * @return string value.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "DELETE the Application by ID.");
        }
    }

    /**
     * Inner class-action to show all applications in storage.
     */
    private class ShowAllApps implements UserAction {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.showApps();
            System.out.print("8 is better choice :D");
        }

        /**
         * Shows some sort of info about action.
         *
         * @return string value.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show ALL Applications.");
        }
    }

    /**
     * Inner class-action to show application by name.
     */
    private class ShowAppByName implements UserAction {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the application's name: ");
            if (validate.checkNames(name, tracker)) {
                System.out.print("There is no such name, enter the CORRECT name.");
            } else
                tracker.showById(name);
        }

        /**
         * Shows some sort of info about action.
         *
         * @return string value.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show Application by ID.");
        }
    }

    /**
     * Inner class-action to delete application by name.
     */
    private class DeleteByName extends BaseAction {
        /**
         * Name contains some sort of info about this action.
         *
         * @param name - string value.
         */
        public DeleteByName(String name) {
            super(name);
        }

        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the NAME of application you would like to delete: ");
            if (validate.checkNames(name, tracker)) {
                System.out.println("There is no such name, enter the CORRECT name.");
            } else
                tracker.deleteAppByName(name);
            System.out.println("Deleting was successful.");
        }
    }

    /**
     * Inner class-action to show application by name.
     */
    private class ShowByNameBasAct extends BaseAction {
        /**
         * Name contains some sort of info about this action.
         *
         * @param name - string value.
         */
        public ShowByNameBasAct(String name) {
            super(name);
        }

        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 7;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the NAME of application you would like to SHOW: ");
            if (validate.checkNames(name, tracker)) {
                try {
                    throw new Exception("There is no such name, enter the CORRECT name.");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else tracker.showByName(name);
        }
    }

    /**
     * Inner class-action to print all data of all applications.
     */
    private class PrintAll extends BaseAction {
        /**
         * Name contains some sort of info about this action.
         *
         * @param name - string value.
         */
        public PrintAll(String name) {
            super(name);
        }

        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 8;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.printOnScreen();
        }
    }

    /**
     * Possibility to exit from program.
     */
    private class Exit extends BaseAction {
        /**
         * Name contains some sort of info about this action.
         *
         * @param name - string value.
         */
        public Exit(String name) {
            super(name);
        }

        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 9;
        }

        /**
         * Execution of some user's action.
         *
         * @param input   - user's input.
         * @param tracker - class with actions to manage applications.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String questionForExit = input.ask("Exit? y/n");
            if (questionForExit.equals("y")) {
                exit = true;
            }
        }
    }
}

