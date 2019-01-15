package ru.evgenyhodz;

import java.io.*;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alittlem1nd on 07.12.2016.
 * The class contains the actions that user can perform on the server.
 */
public class Action {
    /**
     *
     */
    File file;
    /**
     *
     */
    private ArrayList<String> lines = new ArrayList<>();

    /**
     * Get port from app.properties
     *
     * @return string value.
     */
    public String readSettings(String value) {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            settings.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return settings.getValue(value);
    }

    /**
     * Download file from server.
     *
     * @param name - name of the file.
     */
    public File download(String name) throws IOException {
        File tmp = File.createTempFile(name, "txt");
        File dir = new File("C:\\");
        File[] matches = dir.listFiles((dir1, name1) -> name1.startsWith(name1));
        if (matches != null) {
            for (int i = 0; i < matches.length; i++) {
                if (matches[i].getName().equals(name)) {
                    tmp = matches[i];
                }
            }
            String path = tmp.getAbsolutePath();
            try (RandomAccessFile raf = new RandomAccessFile(tmp, "rw");
                 BufferedReader reader = Files.newBufferedReader(Paths.get(path),
                         Charset.defaultCharset())) {
                for (String line; (line = reader.readLine()) != null; ) {
                    lines.add(line);
                }
                for (String s : lines) {
                    raf.writeUTF(s);
                    raf.writeUTF("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tmp;
    }

    /**
     * Upload file to server.
     *
     * @param path - path to the file on someone's computer.
     */
    public void upload(String path) {
        File forUpload = new File(path);
    }

    /**
     * Show all root directories.
     */
    String showParentList(String directory) {
        File file = new File(directory);
        String[] directories = file.list((dir, name) -> new File(dir, name).isDirectory());
        String result = Arrays.toString(directories);
        result = result.replaceAll("(?i), ", "\n");
        return result;
    }

    /**
     * @param folder - path.
     * @return - string.
     */
    public String openParent(String folder) {
        String result = null;
        try {
            File directory = new File(folder);
            File[] contents = directory.listFiles();
            for (File f : contents) {
                result = f.getAbsolutePath();
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return result;
    }

    /**
     * Open directory.
     */
    public void openDir() {

    }

}
