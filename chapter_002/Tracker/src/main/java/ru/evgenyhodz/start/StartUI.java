package ru.evgenyhodz.start;

/**
 * Class to start our program.
 *
 * @author Evgeny Khodzitskiy.
 */
public class StartUI {
    /**
     * Reference to user's input.
     */
    private final Input input;
    /**
     * Reference to object with all actions.
     */
    private final Tracker tracker;

    /**
     * Constructor to start the program.
     *
     * @param input   - user's input values.
     * @param tracker - all program actions.
     */
    public StartUI(final Input input, final Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method is creating menu for user.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker, new ValidateInput());
        menu.fillActions();
        tracker.loadProperties();
        tracker.connectToDatabase();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Choose action: "));
            menu.select(key);
        } while (!menu.isExit());
        tracker.disconnectFromDatabase();
    }

    /**
     * Start of program.
     *
     * @param args - in this case is empty.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}


//    public static void main(String[] args) {
//        System.out.println("Start...");
//        int num = 0;
//        Tracker tracker = new Tracker();
//        for (int i = 0; i < 100000; i++) {
//            try {
//                Input input = new StubInput(new String[]{"9", "y"});
//                new StartUI(input, tracker).init();
//                num++;
//            } catch (OutOfMemoryError error) {
//                break;
//            }
//        }
//        System.out.println("Last start was = " + num);
//        System.out.println("Finish.");
//    }
