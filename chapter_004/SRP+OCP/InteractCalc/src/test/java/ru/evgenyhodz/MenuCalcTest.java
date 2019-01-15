package ru.evgenyhodz;

import evgenyhodz.Calculate;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.12.2016
 */
public class MenuCalcTest {
    @Test
    public void fill() throws Exception {

    }

    @Test
    public void info() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String expResult = out.toString();
        //assertThat(new MenuCalc(null, null, null, null).info(), is(expResult));
    }

    @Test
    public void select() throws Exception {

    }

}