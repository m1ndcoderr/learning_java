package ru.evgenyhodz.minitask;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.04.2017
 */
public class Runner {
    public static void main(String[] args) {
        Field field = new Field();
        field.fill();
        field.show(field.getObjects());
        new RLocker(field).start();
        new RLocker(field).start();
    }
}
