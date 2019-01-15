package ru.evgenyhodz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by alittlem1nd on 29.11.2016.
 */
public class ConsoleChat {
    /**
     * Ключевая фраза "стоп".
     */
    private String stop = "стоп";
    /**
     * Ключевая фраза "продолжить".
     */
    private String cont = "продолжить";
    /**
     * Ключевое слово "закончить" для завершения программы.
     */
    private String finish = "закончить";
    /**
     * Объект для выдачи случайных ответов пользователю.
     */
    private Random random = new Random();

    /**
     * Метод читает файл со строкой с ответами и преобразует их в массив строк.
     *
     * @param withAnswers - файл с ответами.
     * @return - возвращает массив строк.
     * @throws IOException - I/O Exceptions.
     */
    private String[] getRandomAnswers(File withAnswers) throws IOException {
        Path answersFilePath = Paths.get(withAnswers.getAbsolutePath());
        String words = Files.lines(answersFilePath, StandardCharsets.UTF_8).collect(Collectors.joining());
        return words.split(" ");
    }

    /**
     * Метод выдает случайную строку из массива.
     *
     * @param arr - принимаемый массив со строками.
     * @return - возврат строки.
     */
    private String randAnswer(String[] arr) {
        return arr[random.nextInt(arr.length)];
    }

    /**
     * Запуск консоли для пользователя.
     *
     * @param in          - входящий поток.
     * @param withAnswers - файл со случайными ответами.
     * @return - возврат виртуального лога.
     * @throws IOException - I/O exceptions.
     */
    public File run(File withAnswers, InputStream in) throws IOException {
        String pathToLog = String.format("%s%s%s", System.getProperty("user.dir"),
                File.separator, "\\chapter_003\\task5\\ConsoleChat\\src\\main\\resources\\log.txt");
        File log = new File(pathToLog);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             FileWriter fileWriter = new FileWriter(log)
        ) {
            boolean flag = true;
            String[] randomAnswers = getRandomAnswers(withAnswers);
            String userInput;
            do {
                userInput = reader.readLine();
                fileWriter.write(userInput);
                fileWriter.write("\n");
                if (stop.equalsIgnoreCase(userInput) || finish.equalsIgnoreCase(userInput)) {
                    flag = false;
                }
                if (flag) {
                    String str = randAnswer(randomAnswers);
                    System.out.print(str);
                    fileWriter.write(str);
                    fileWriter.write("\n");
                }
                if (cont.equalsIgnoreCase(userInput)) {
                    flag = true;
                }
            } while (!finish.equalsIgnoreCase(userInput));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }
}
