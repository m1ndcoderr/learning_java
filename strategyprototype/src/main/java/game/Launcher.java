package game;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.11.2017
 */
public class Launcher {

    public static void main(String[] args) {
        Logger logger = new Logger(new ArrayList<>());
        Manager manager = new Manager(logger);
        manager.start();
        manager.createLog(logger.getComments());
    }
}
