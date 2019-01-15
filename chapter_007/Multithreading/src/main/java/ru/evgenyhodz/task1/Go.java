package ru.evgenyhodz.task1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.03.2017
 */
public class Go {
    private ArrayList<String> test;

    private void createStrings() {
        test = new ArrayList<>();
        String a = "First testing string with spaces";
        String b = "Second string and here there are spaces too";
        String c = "Third string to test how many words and spaces we have";
        test.add(a);
        test.add(b);
        test.add(c);
    }

    public void start(int seconds) throws InterruptedException {
        System.out.println("Начало программы (3 sec delay)");
        delay(3000);
        createStrings();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new WordsCounter(test, 150));
        executorService.submit(new SpacesCounter(test, 0));
        executorService.shutdown();

//        final boolean done = executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
//        if (!done){
//            System.out.println("Все не подсчитано. Добавляю время...");
//            delay(seconds);
//        }
//        System.out.print("Завершение программы.");

        final boolean done = executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        if (!done){
            System.out.println("Не успел подсчитать все, удаляю потоки.");
            executorService.shutdownNow();
            delay(seconds);
        }
        System.out.print("Завершение программы.");
    }

    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Go().start(1);

    }
}
