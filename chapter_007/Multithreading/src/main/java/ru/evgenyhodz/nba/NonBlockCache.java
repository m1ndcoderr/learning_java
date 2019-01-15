package ru.evgenyhodz.nba;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.03.2017
 */
public class NonBlockCache<K, E extends Model> {

    private Map<K, E> base = new ConcurrentHashMap<>();

    public void add(K key, E e) {
        this.base.putIfAbsent(key, e);
    }

    public void delete(K key) {
        this.base.computeIfPresent(key, (k, v) -> null);
    }

    public E update(K key, E update) throws OptimisticException {
        return this.base.computeIfPresent(key, ((k, e) -> {
            if (this.base.get(key).getVersion() == update.getVersion()) {
                update.increaseVersion();
                return update;
            } else {
                throw new OptimisticException("Different versions.");
            }
        }));
    }
}

