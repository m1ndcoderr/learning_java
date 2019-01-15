package ru.evgenyhodz;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for sorting 3G file.
 * Created by Evgeny Khodziskiy on 22.11.2016.
 */
public class Sort3G {
    /**
     * Хранилище для сортировки.
     */
    private ArrayList<String> lines = new ArrayList<>();
    /**
     * Компаратор, сортирующий строки по длине.
     */
    private MyComparator comparator = new MyComparator();

    /**
     * Method sorts strings in a file.
     *
     * @param source   - input file.
     * @param distance - output file.
     * @throws IOException - I/O exceptions.
     */
    public void sortStrings(File source, File distance) throws IOException {
        try (RandomAccessFile rSource = new RandomAccessFile(source, "r");
             RandomAccessFile rDistance = new RandomAccessFile(distance, "rw");
        ) {
            while (rSource.read() != -1) {
                String currentLine = rSource.readLine();
                while (currentLine != null) {
                    lines.add(currentLine);
                }
            }
            Collections.sort(lines, comparator);
            for (String s : lines) {
                rDistance.writeUTF(s);
                rDistance.writeUTF("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Внутренний класс Comparator, измененный для сортировки строк по длине.
     */
    private class MyComparator implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return -1;
            }

            if (o2.length() > o1.length()) {
                return 1;
            }

            return 0;
        }
    }
}


