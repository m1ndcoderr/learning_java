package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by alittlem1nd on 08.12.2016.
 */
public class ActionTest {
    /**
     * Link.
     */
    private File source;
    /**
     *
     */
    private String text = "This\nis\njust\ntest!";

    /**
     * @throws IOException - exception.
     */
    @Before
    public void createTempFiles() throws IOException {
        try {
            source = File.createTempFile("Source", "txt");
            FileWriter fW1 = new FileWriter(source);
            fW1.write(text);
            source.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws Exception -
     */
    @Test
    public void download() throws Exception {
        Action action = new Action();
        System.out.println(action.download(source.getName()));
    }

    /**
     * @throws Exception -
     */
    @Test
    public void upload() throws Exception {

    }

    /**
     * @throws Exception -
     */
    @Test
    public void showParentList() throws Exception {
        Action action = new Action();
        try {
            String way = "C:\\";
            System.out.print(action.showParentList(way));
        } catch (Exception xe) {
            xe.printStackTrace();
        }
    }

    /**
     * @throws Exception -
     */
    @Test
    public void openParent() throws Exception {

    }

    /**
     * @throws Exception -
     */
    @Test
    public void openDir() throws Exception {

    }

}