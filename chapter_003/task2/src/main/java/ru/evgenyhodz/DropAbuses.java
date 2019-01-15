package ru.evgenyhodz;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Class for droping wrong words.
 *
 * @author Evgeny Khodzitskiy
 * @version 1
 * @since 21.11.2016
 */
public class DropAbuses {
    /**
     * Method to drop abuse words.
     *
     * @param in    - our input.
     * @param out   - our output.
     * @param abuse - array that contains abuse examples.
     * @throws IOException - input/output exception.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        try (/**
              * Конвертация байтового в символьное.
              */
             InputStreamReader isr = new InputStreamReader(in);
             OutputStreamWriter osw = new OutputStreamWriter(out);
             Scanner scanner = new Scanner(isr)) {
            while (scanner.hasNext()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < abuse.length; i++) {
                    sb.append(abuse[i]);
                }
                osw.write(scanner.nextLine().replace(sb.toString(), ""));
            }
        } catch (IOException e) {
            System.out.print("Error!");
        }
    }
}





