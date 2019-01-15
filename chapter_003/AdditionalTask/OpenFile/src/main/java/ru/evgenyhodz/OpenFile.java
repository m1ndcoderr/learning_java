package ru.evgenyhodz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для чтения файла и вывода результатов на экран.
 * Created by alittlem1nd on 01.12.2016.
 */
public class OpenFile {
    /**
     * Метод открывает файл и читает строки. Результат на экран.
     * @param file - файл, который нужно открыть.
     * @throws IOException - выброс исключения ввода/вывода.
     */
    public void open(File file) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path path = Paths.get(file.getAbsolutePath());
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}

