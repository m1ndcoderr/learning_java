package ru.evgenyhodz;

/**
 * Validation class.
 * Класс для проверки игрового поля.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.01.2017
 */
class TurnCheck {
    /**
     * Method to validate game field. If rows, columns or diagonal values are equal, return true.
     * Метод для проверки игрового поля, который объединяет в себе
     * все методы класса.
     *
     * @param field - game field.
     * @return true/false.
     */
    boolean validate(String[][] field) {
        boolean valid = false;
        if (checkHorizontal(field)
                || checkVertical(field)
                || checkDiagonal(field)
                || checkAnotherDiagonal(field)
                || !canMove(field)) {
            valid = true;
        }
        return valid;
    }

    /**
     * Method to check if we have an empty cells on the game field..
     * Метод проверяет, есть ли у нас пустые клетки на игровом поле.
     *
     * @param board - game field.
     * @return true/false.
     */
    boolean canMove(String[][] board) {
        boolean can = false;
        for (String[] aField : board) {
            for (String anAField : aField) {
                if (anAField.equals("[ ]")) {
                    can = true;
                }
            }
        }
        return can;
    }

    /**
     * Method to check the matches of diagonal elements.
     * Проверка элементов по диагонали.
     *
     * @param field - our game field.
     * @return - true/false.
     */
    boolean checkDiagonal(String[][] field) {
        boolean valid = true;
        for (int i = 0; i < field.length; i++) {
            if (!field[0][0].equals(field[i][i]) && !field[0][0].equals("[ ]")) {
                valid = false;
            } else if (field[0][0].equals("[ ]") || field[field.length - 1][field.length - 1].equals("[ ]")) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Method to check the matches of diagonal elements.
     * Проверка элементов по другой диагонали.
     *
     * @param field - our game field.
     * @return - true/false.
     */
    boolean checkAnotherDiagonal(String[][] field) {
        boolean valid = true;
        for (int i = 0, j = field.length - 1; i < field.length; i++, j--) {
            if (!field[0][field.length - 1].equals(field[i][j]) && !field[i][0].equals("[ ]")) {
                valid = false;
            } else if (field[0][field.length - 1].equals("[ ]") || field[field.length - 1][0].equals("[ ]")) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Method to check the matches of horizontal elements.
     * Метод проверяет совпадения в строках.
     *
     * @param field - our game field.
     * @return - true/false.
     */
    boolean checkHorizontal(String[][] field) {
        boolean valid = false;
        for (String[] aField : field) {
            if (aField[0].equals("[ ]")) {
                continue;
            }
            int j;
            for (j = 1; j < aField.length; j++) {
                if (!aField[j].equals(aField[0])) {
                    break;
                }
            }
            if (j == aField.length) {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * Method to check the matches of vertical elements.
     * Метод проверяет совпадения в колонках.
     *
     * @param field - our game field.
     * @return - true/false.
     */
    boolean checkVertical(String[][] field) {
        boolean valid = false;
        for (int i = 0; i < field.length; i++) {
            if (field[0][i].equals("[ ]")) {
                continue;
            }
            int j;
            for (j = 1; j < field[i].length; j++) {
                if (!field[j][i].equals(field[0][i])) {
                    break;
                }
            }
            if (j == field[i].length) {
                valid = true;
            }
        }
        return valid;
    }
}
