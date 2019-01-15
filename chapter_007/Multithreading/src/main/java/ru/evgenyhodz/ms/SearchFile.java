package ru.evgenyhodz.ms;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.03.2017
 */
public class SearchFile {
    /**
     * To stop searching.
     */
    private boolean stop = false;
    /**
     * Array with the list of matches.
     */
    private static ArrayList<File> matches = new ArrayList<>();

    /**
     * Возвращает поток поиска.
     *
     * @param root   -
     * @param toFind -
     * @param key    -
     * @return Thread
     */
    private Thread searchThread(String root, String toFind, String key) {
        return new Thread() {
            @Override
            public void run() {
                try {
                    searching(root, toFind, key);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /**
     * Поиск совпадений в файле/файлах.
     *
     * @param root   - путь где будем искать
     * @param toFind - строка что будем искать
     * @param key    - ключ для остановки (-stop) поиска после первого совпадения.
     * @throws IOException - exception.
     */
    private void searching(String root, String toFind, String key) throws IOException {
        File[] allFilesInRoot = new File(root).listFiles();
        synchronized (this) {
            if (allFilesInRoot != null && !stop) {
                for (File file : allFilesInRoot) {
                    if (FileUtils.readFileToString(file, StandardCharsets.UTF_8).contains(toFind)) {
                        if (!matches.contains(file)) {
                            matches.add(file);
                            if (key.equals("-stop")) {
                                this.stop = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Инициализация работы программы, создание двух потоков поиска, вывод сообщений.
     */
    private void init(String root, String toFind, String key) {
        System.out.println("Start searching. Creating threads...");
        Thread first = searchThread(root, toFind, key);
        Thread second = searchThread(root, toFind, key);
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException x) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Search is finished. Results: ");
    }

    /**
     * START OF PROGRAM.
     * Старт программы.
     * Если два аргумента - поиск до нахождения всех совпадений.
     * Если три аргумента - поиск до первого совпадения.
     *
     * @param args args
     */
    public static void main(String[] args) {
        SearchFile sf = new SearchFile();
        if (args.length == 2) {
            sf.init(args[0], args[1], "");
        } else {
            sf.init(args[0], args[1], args[2]);
        }
        for (File file : matches) {
            System.out.println(file.getName());
        }
    }
}
