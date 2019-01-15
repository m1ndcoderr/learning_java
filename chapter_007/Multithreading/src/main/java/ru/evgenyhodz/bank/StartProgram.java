package ru.evgenyhodz.bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * В течении дня в банк заходят люди, у каждого человека есть время захода в банк и время выхода.
 * Всего за день у банка было N посетителей. Банк работает с 8:00 до 20:00.
 * Человек посещает банк только один раз за день.
 * Написать программу, которая определяет периоды времени,
 * когда в банке было максимальное количество посетителей.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 05.05.2017
 */
public class StartProgram {

    private static Bank bank = new Bank();

    public static void main(String[] args) {
        generateClients();
        bank.determineWorkload();
        bank.showPeriod();
    }

    /**
     * Заполняем банк людьми.
     */
    private static void generateClients() {
        for (int i = 0; i < 1000; i++) {
            int sH = ThreadLocalRandom.current().nextInt(0, 24);
            int sM = ThreadLocalRandom.current().nextInt(0, 60);
            int sS = ThreadLocalRandom.current().nextInt(0, 60);
            int fH = ThreadLocalRandom.current().nextInt(sH, 24);
            int fM = ThreadLocalRandom.current().nextInt(sM, 60);
            int fS = ThreadLocalRandom.current().nextInt(sS, 60);
            LocalDateTime in = LocalDateTime.of(LocalDate.now(), LocalTime.of(sH, sM, sS, 0));
            LocalDateTime out = LocalDateTime.of(LocalDate.now(), LocalTime.of(fH, fM, fS, 0));
            bank.addClient(new Client(in, out, 0));
        }
    }
}
