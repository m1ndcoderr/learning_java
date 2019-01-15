package ru.evgenyhodz;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class for checking if even number is in stream.
 * @author Evgeny Khodzitskiy
 * @since 21.11.2016
 * @version 1
 */
public class CheckByteStream {

    /**
     * Method to check if even number is in InputStream.
     *
     * @param in - first param, it's our InputStream.
     * @return boolean - we shall get true or false.
     * @throws IOException - input/output exceptions.
     */
    public boolean isNumber(InputStream in) throws IOException {
        boolean evenNum = false;
        while (in.read() != -1) {
            if (in.read() % 2 == 0) {
                evenNum = true;
            }
        }
        return evenNum;
    }
}


