package ru.evgenyhodz.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 06.05.2017
 */
public class Bank {
    /**
     * Storage of clients.
     */
    private LinkedList<Client> clients = new LinkedList<>();

    /**
     * Add client to storage.
     * <p>
     * Клиент, который не знает время работы банка не добавится.
     *
     * @param client client to add.
     */
    public void addClient(Client client) {
        if (client.getHourIn() >= 8 && client.getHourOut() < 20) {
            this.clients.addLast(client);
        }
    }

    /**
     * Здесь мы сравниваем интервалы. Если интервал i является частью интервала j, счетчик (amount)
     * инкрементируется. Интервал i не сравнивается сам с собой. У клиента есть congestion -
     * это число людей, которые были в банке одновременно с ним. Его мы изменяем.
     */
    public void determineWorkload() {
        for (int i = 0; i < clients.size(); i++) {
            int amount = 0;
            int x1 = clients.get(i).getHourIn();
            int y1 = clients.get(i).getMinuteIn();
            int x2 = clients.get(i).getHourOut();
            int y2 = clients.get(i).getMinuteOut();
            int z1 = clients.get(i).getSecondIn();
            int z2 = clients.get(i).getSecondOut();
            for (int j = 0; j < clients.size(); j++) {
                int a1 = clients.get(j).getHourIn();
                int b1 = clients.get(j).getMinuteIn();
                int a2 = clients.get(j).getHourOut();
                int b2 = clients.get(j).getMinuteOut();
                int c1 = clients.get(j).getSecondIn();
                int c2 = clients.get(j).getSecondOut();
                if (!clients.get(i).equals(clients.get(j))) {
                    if (x1 >= a1 && x2 <= a2 && y1 >= b1 && y2 <= b2 && z1 >= c1 && z2 <= c2) {
                        clients.get(i).setCongestion(amount++);
                    }
                }
            }
        }
    }

    /**
     * Вывод на экран самого загруженного периода.
     * Мы берем все congestion и помещаем в коллекцию, из нее берем самое большое.
     * Находим клиента с таким же congestion и выводим на экран его время посещения.
     */
    public void showPeriod() {
        ArrayList<Integer> nums = new ArrayList<>(clients.size());
        for (int i = 0; i < clients.size(); i++) {
            nums.add(clients.get(i).getCongestion());
        }
        Integer max = Collections.max(nums);
        int startH = 0, startM = 0, finH = 0, finM = 0, secIn = 0, secOut = 0;
        for (int j = 0; j < nums.size(); j++) {
            if (max == clients.get(j).getCongestion()) {
                startH = clients.get(j).getHourIn();
                startM = clients.get(j).getMinuteIn();
                finH = clients.get(j).getHourOut();
                finM = clients.get(j).getMinuteOut();
                secIn = clients.get(j).getSecondIn();
                secOut = clients.get(j).getSecondOut();
            }
        }
        System.out.println("Most busy time was from "
                + startH + ":" + startM + ":" + secIn + " to " + finH + ":" + finM + ":" + secOut + ".");
    }
}
