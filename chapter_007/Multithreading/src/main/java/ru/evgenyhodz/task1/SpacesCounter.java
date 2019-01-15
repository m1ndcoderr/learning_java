package ru.evgenyhodz.task1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.03.2017
 */
public class SpacesCounter extends Thread {

    private ArrayList<String> strings;
    private int delay;

    public SpacesCounter(ArrayList<String> string, int delay) {
        this.strings = string;
        this.delay = delay;
    }

//    @Override
//    public void run() {
//        long startTime = System.nanoTime();
//        for (String s : strings) {
//            try {
//                int spaces = s == null ? 0 : s.length() - s.replace(" ", "").length();
//                System.out.println("Number of spaces in a string : " + spaces);
//                System.out.println("Number of spaces in a string : " + StringUtils.countMatches(s, " "));
//                Thread.sleep(delay);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        long endTime = System.nanoTime();
//        System.out.println("Method took :" + (endTime - startTime) + " nanoseconds.");
//    }

    @Override
    public void run() {
        int length = 0;
        while (!Thread.currentThread().isInterrupted() && length < strings.size()) {
            for (String s : strings) {
                int spaces = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isWhitespace(s.charAt(i))) {
                        spaces++;
                    }
                }
                System.out.println("Number of spaces in a string : " + spaces);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                length++;
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("SpaceCounter thread is interrupted.");
                }
            }
        }
    }
}

