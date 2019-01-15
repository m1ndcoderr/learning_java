package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 14.03.2017
 */
public class CacheTest {

    private File file = new File("src/main/resources");
    private String path = file.getAbsolutePath();
    private Cache cache;

    @Before
    public void create() {
        cache = new Cache(path);
        cache.cacheGet("numbers.txt");
    }

    // Файл есть, возвращаем строку файла
    @Test
    public void whenSetNameOfFileThenGetStringsFromThatFileTest() {
        Cache cache = new Cache(path);
        String result = cache.cacheGet("names.txt");
        assertThat(result, is("Petr Vladimir Ivan"));
    }

    // Файла нет, возвращаем пустую строку
    @Test
    public void whenSetNameOfFileThenGetEmptyStringTest() {
        Cache cache = new Cache(path);
        String result = cache.cacheGet("notExist.txt");
        assertThat(result, is(""));
    }

    // Получаем значение из карты
    @Test
    public void gettingValuesFromHashMapTest() {
        String result = cache.getData().get("numbers.txt").get();
        assertThat(result, is("1 2 3"));
    }
}