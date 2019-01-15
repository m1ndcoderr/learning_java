package ru.evgenyhodz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 10.03.2017
 */
public class Cache {
    /**
     * Path to our package with files.
     */
    private String path;
    /**
     * Store map with files.
     */
    private HashMap<String, SoftReference<String>> data = new HashMap<>();

    /**
     * Constructor.
     *
     * @param path - path to package.
     */
    public Cache(String path) {
        this.path = path;
    }

    /**
     * Returns text after entering the file name.
     *
     * @param fname - name of the file.
     * @return string
     */
    public String cacheGet(String fname) {
        String string = null;
        String pathPlusName = String.format("%s/%s", path, fname);
        class Read {
            private String readFile(Charset encoding) {
                String result;
                try {
                    byte[] encoded = Files.readAllBytes(Paths.get(pathPlusName));
                    result = new String(encoded, encoding);
                } catch (IOException e) {
                    //Файл не найден, возвращаем пустую строку.
                    result = "";
                }
                return result;
            }
        }
        SoftReference<String> line = data.get(fname);
        if (line == null) {
            line = new SoftReference<>(new Read().readFile(StandardCharsets.UTF_8));
            data.put(fname, line);
        }
        if (line.get() != null) {
            string = line.get();
        }
        return string;
    }

    public HashMap<String, SoftReference<String>> getData() {
        return data;
    }
}
