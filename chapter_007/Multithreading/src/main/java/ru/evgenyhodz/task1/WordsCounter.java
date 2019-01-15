package ru.evgenyhodz.task1;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.03.2017
 */
public class WordsCounter extends Thread {

    private ArrayList<String> strings;
    private int delay;

    public WordsCounter(ArrayList<String> string, int delay) {
        this.strings = string;
        this.delay = delay;
    }

    @Override
    public void run() {
        int length = 0;
        while (!Thread.currentThread().isInterrupted() && length < strings.size()) {
            for (String s : strings) {
                try {
                    int words = s.split("\\w+").length;
                    System.out.println("Number of words in a string : " + words);
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                length++;
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("SpaceCounter thread is interrupted.");
            }
        }
    }
}