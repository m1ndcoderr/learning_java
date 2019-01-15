package ru.evgenyhodz.lite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.03.2017
 */
public class CollectionsSpeed {

    private long startTime;
    private long endTime;

    public long add(Collection<String> collection, String line, int amount) {
        startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(line);
        }
        endTime = System.nanoTime();
        return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
    }

    public long delete(Collection<String> collection, String line, int amount) {
        startTime = System.nanoTime();
        if (!(collection instanceof ArrayList)) {
            for (int i = 0; i < amount; i++) {
                collection.remove(line);
            }
        } else {
            for (int i = 0; i < amount; i++) {
                ((ArrayList) collection).remove(i);
            }
        }
        endTime = System.nanoTime();
        return TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
    }
}
