package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 *
 * @author Evgeny Khodzitskiy
 * @since 25/11/2016
 */
public class Sort3GTest {
    /**
     * Исходный файл.
     */
    private File source = null;
    /**
     * Измененный файл.
     */
    private File distance = null;
    /**
     * Файл-эталон для сравнения.
     */
    private File sorted = null;
    /**
     * Исходный текст для исходного файла.
     */
    private String srcText = "12345\n123456789\n123";
    /**
     * Текст для файла-эталона, с которым мы будем сравнивать.
     */
    private String sortedText = "123\n12345\n123456789";
    /**
     * Массив для строк файла distance.
     */
    private ArrayList<String> linesOfDis = new ArrayList<>();
    /**
     * Массив для строк файла sorted.
     */
    private ArrayList<String> linesOfSorted = new ArrayList<>();

    /**
     * Создание временных тестовых файлов и запись в них строк.
     *
     * @throws IOException - I/o exceptions.
     */
    @Before
    public void createTempFiles() throws IOException {
        try {
            source = File.createTempFile("Source", "txt");
            distance = File.createTempFile("Distance", "txt");
            sorted = File.createTempFile("Sorted", "txt");
            FileWriter fW1 = new FileWriter(source);
            FileWriter fW2 = new FileWriter(sorted);
            fW1.write(srcText);
            fW2.write(sortedText);
            source.deleteOnExit();
            distance.deleteOnExit();
            sorted.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Тест основного метода.
     *
     * @throws IOException - I/O exceptions.
     */
    @Test
    public void sort3gTest() throws IOException {
        Sort3G sort3G = new Sort3G();
        try (RandomAccessFile rafDis = new RandomAccessFile(distance, "r");
             RandomAccessFile rafSorted = new RandomAccessFile(sorted, "r")) {
            sort3G.sortStrings(source, distance);
            while (rafDis.read() != -1 && rafSorted.read() != -1) {
                String curLineDis = rafDis.readLine();
                String curLineSor = rafSorted.readLine();
                while (curLineDis != null && curLineSor != null) {
                    linesOfDis.add(curLineDis);
                    linesOfSorted.add(curLineSor);
                }
                StringBuilder sbDis = new StringBuilder();
                for (String string : linesOfDis) {
                    sbDis.append(string);
                    sbDis.append("\n");
                }
                StringBuilder sbSor = new StringBuilder();
                for (String str : linesOfSorted) {
                    sbSor.append(str);
                    sbSor.append("\n");
                }
                assertThat(sbDis.toString(), is(sbSor.toString()));
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}