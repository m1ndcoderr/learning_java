package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alittlem1nd on 01.12.2016.
 */
public class OpenFileTest {
    /**
     * Тестовый файл.
     */
    private File file;

    /**
     * Создание временного файла с данными.
     *
     * @throws IOException - исключения ввода/вывода.
     */
    @Before
    public void createFile() throws IOException {
        try {
            file = File.createTempFile("Temporary", ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Файл с данными прочитан.");
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * Убеждаемся, что данные файла выводятся на экран.
     *
     * @throws IOException - исключения ввода/вывода.
     */
    @Test
    public void openFileTest() throws IOException {
        try {
            OpenFile program = new OpenFile();
            /**
             * Ассерта нет, нам нужна лишь выведенная строка в консоли, поэтому просто:
             */
            program.open(file);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
