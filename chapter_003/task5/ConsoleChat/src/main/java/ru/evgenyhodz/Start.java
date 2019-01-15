package ru.evgenyhodz;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by alittlem1nd on 30.11.2016.
 */
public class Start {
    /**
     * Временный файл.
     */
    private File tmp;
    /**
     * Строка для сканера.
     */
    private String line;

    /**
     * Запуск нашего чата.
     *
     * @param args - :)
     * @throws IOException - исключения.
     */
    public static void main(String[] args) throws IOException {
        InputStream answers = ConsoleChat.class.getResourceAsStream("/RandomAnswers.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(answers));
        File file = new Start().readFileFromResources(reader);
        try {
            ConsoleChat consoleChat = new ConsoleChat();
            InputStream inputStream = new BufferedInputStream(System.in);
            consoleChat.run(file, inputStream);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * Читаем файл из ресурсов.
     *
     * @param in - наш файл из ресурсов, завернутый в поток.
     * @return - возвращает в виде файла.
     * @throws IOException - исключения.
     */
    protected File readFileFromResources(BufferedReader in) throws IOException {
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                this.line = scanner.nextLine();
            }
            this.tmp = File.createTempFile("tmp", "txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(tmp));
            bf.write(this.line);
            bf.close();
        } catch (IOException e) {
            System.out.print("Error!");
        }
        return tmp;
    }
}

