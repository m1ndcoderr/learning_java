package ru.evgenyhodz;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 10.01.2017
 */
public class Run {
    /**
     * Constant to start standard 3x3 game.
     */
    private static final int STANDARD = 0;
    /**
     * Constant to start customized game.
     */
    private static final int CUSTOM = 1;
    /**
     * Minimal field size in the game.
     * Минимальный размер поля в игре.
     */
    private static final int MINIMAL = 3;
    /**
     * Number of maximum victories in custom game to win.
     * Число максимального количества побед, чтобы выйграть в кастомизированной игре.
     */
    private static final int MAXIMUM = 5;
    /**
     * Message to user.
     */
    private static final List<String> TEXT = Lists.newArrayList(
            "TIC-TAC-TOE",
            "Choose game mode:",
            "print \"0\" to standard 3x3 game;",
            "print \"1\" to customize your game.");
    /**
     * Ref to api class.
     */
    private TicTacToe ticTacToe;
    /**
     * Ref to validate class.
     */
    private TurnCheck turnCheck;
    /**
     * Ref to user's input.
     */
    private Input input;

    /**
     * Constructor.
     *
     * @param validation - checking the winner after every step.
     * @param game       - api.
     * @param data       - user's input.
     */
    private Run(TurnCheck validation, TicTacToe game, Input data) {
        this.turnCheck = validation;
        this.ticTacToe = game;
        this.input = data;
    }

    /**
     * Initialization of Computer-against-computer game.
     */
    private void demonstration() {
        System.out.println("Standard game 3x3 computer against computer: ");
        ticTacToe.createGameField(MINIMAL);
        do {
            ticTacToe.betweenComputers();
        } while (!turnCheck.validate(ticTacToe.getField()));
    }

    /**
     * Initialization of game with standard parameters.
     */
    private void initStandard() {
        System.out.println("Standard game 3x3 against computer begins...");
        ticTacToe.createGameField(MINIMAL);
        ticTacToe.randomActFirst();
        do {
            if (ticTacToe.getFirstMove() == 1) {
                ticTacToe.actHumanFirst();
            } else if (ticTacToe.getFirstMove() == 2) {
                ticTacToe.actComputerFirst();
            }
        } while (!turnCheck.validate(ticTacToe.getField()));
    }

    /**
     * ENG:
     * Initialization of game with custom parameters.
     * Method starts the program, shows a message about the
     * begin of the game and asks user to set the size of the
     * game field (can't be less than 3x3). Further, method
     * randomly determines, who makes the first move - you or
     * the computer. Then the game goes as usual, with validation
     * of the game field after each move. In case of victory,
     * you will get 1 point. In case of loss or draw, all points
     * will be zeroed. The game continues as long as the number of
     * points is not equal to 5.
     * RUS:
     * Инициализация игры с заданными параметрами.
     * Метод запускает программу, выводит сообщение о начале игры,
     * запрашивает у пользователя размер игрового поля (не может быть
     * меньше, чем 3х3). Далее случайным образом определяется, кто
     * делает первый ход - вы или компьютер. Далее игра идет в
     * обычном режиме, с проверкой игрового поля после каждого хода.
     * В случае выйгрыша, вы получаете 1 очко. В случае проигрыша или ничьи,
     * все очки снимаются. Игра продолжается до тех пор, пока кол-во
     * набранных очков не будет равно 5.
     */
    private void initCustom() {
        System.out.println("Custom game begins...");
        while (ticTacToe.getCountOfWins() != MAXIMUM) {
            ticTacToe.createGameField(input.inputFieldSize(new Scanner(System.in)));
            ticTacToe.randomActFirst();
            do {
                if (ticTacToe.getFirstMove() == 1) {
                    ticTacToe.actHumanFirst();
                } else if (ticTacToe.getFirstMove() == 2) {
                    ticTacToe.actComputerFirst();
                }
                ticTacToe.declareWinner(ticTacToe.getField());
            } while (!turnCheck.validate(ticTacToe.getField()));
        }
        if (ticTacToe.getCountOfWins() == MAXIMUM) {
            System.out.println("YOU ARE SUPER WINNER!");
        }
    }

    /**
     * Method to start program.
     */
    private void init() {
        System.out.print(Joiner.on("\n").join(TEXT));
        int result = input.input(new Scanner(System.in)) + 1;
        if (result == STANDARD) {
            initStandard();
        } else if (result == CUSTOM) {
            initCustom();
        } else {
            System.out.print("No choice, so demo game will be created.\n");
            demonstration();
        }

    }

    /**
     * Start of program.
     *
     * @param args - empty.
     */
    public static void main(String[] args) {
        Input input = new Input();
        new Run(new TurnCheck(), new TicTacToe(input, new TurnCheck()), input).init();
    }
}
