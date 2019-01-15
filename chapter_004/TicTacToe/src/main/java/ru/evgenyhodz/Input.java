package ru.evgenyhodz;

import java.util.Scanner;

/**
 * User's input from keyboard.
 * Класс реализует пользовательский ввод цифр с клавиатуры.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.01.2017
 */
public class Input {
    /**
     * Minimal field size in the game.
     * Минимальный размер поля в игре.
     */
    private static final int MINIMAL = 3;
    /**
     * Special parameter to set field size.
     */
    private int fieldSize;

    /**
     * ENG:
     * Input of int values only (coordinates or choosing the game mode).
     * Input value is decremented by 1 for the user's convenience,
     * because massive's indexes starts with 0, and user may not be
     * aware of that.
     * In case of incorrect input, method asks user to enter data again.
     * RUS:
     * Метод предназначен для ввода цифр (координат, либо выбора режима игры).
     * Вводимое значение уменьшается на единицу для удобства пользователя,
     * поскольку индексы массивов начинаются с нуля, а пользователь об этом
     * может не знать.
     * В случае некорректного ввода, метод указывает на ошибку и просит
     * ввести данные еще раз.
     *
     * @param scanner - reader from anywhere.
     * @return - some int value.
     */
    int input(Scanner scanner) {
        int result = 0;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt() - 1;
        } else {
            System.out.println("Error. Type numbers! Try again:");
            input(scanner);
        }
        return result;
    }

    /**
     * ENG:
     * Input of int values only to set the size of the game field.
     * The field cannot be less than 3x3.
     * In case of incorrect input, method asks user to enter data again.
     * RUS:
     * Метод предназначен для ввода размера игрового поля.
     * Поле не может быть меньше, чем 3х3.
     * В случае некорректного ввода, метод попросит пользователя
     * повторно ввести данные.
     *
     * @param scanner - reader from anywhere.
     * @return - size of game field.
     */
    int inputFieldSize(Scanner scanner) {
        System.out.println("Set the size of game field: ");
        if (scanner.hasNextInt()) {
            fieldSize = scanner.nextInt();
            if (fieldSize < MINIMAL) {
                System.out.println("Game field can't be less than 3x3! Try again.");
                inputFieldSize(scanner);
            }
        }
        return fieldSize;
    }
}