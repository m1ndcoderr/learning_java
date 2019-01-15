package ru.evgenyhodz;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by alittlem1nd on 23.11.2016.
 */
public class Palindrome {

    /**
     * Method checks if we have a palindrome.
     *
     * @param in - abstract stream.
     * @return - true or false.
     * @throws IOException - I/O exceptions.
     */
    public boolean checkWord(InputStream in) throws IOException {
        boolean is = true;
        try (InputStreamReader isr = new InputStreamReader(in);
             Scanner scanner = new Scanner(isr)) {
            if (scanner.hasNext()) {
                String clean = scanner.nextLine().replace(" ", "");
                char[] word = clean.toLowerCase().toCharArray();
                int a = 0;
                int b = word.length - 1;
                while (b > a) {
                    if (word[a] != word[b]) {
                        is = false;
                    }
                    ++a;
                    --b;
                }
            }
        } catch (IOException e) {
            System.out.print("Error!");
        }
        return is;
    }
}