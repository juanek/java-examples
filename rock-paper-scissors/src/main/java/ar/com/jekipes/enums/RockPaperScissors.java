package ar.com.jekipes.enums;

import java.util.Scanner;

/**
 * mvn exec:java -Dexec.mainClass="ar.com.jekipes.enums.RockPaperScissors"
 * @author juan kipes
 */
public class RockPaperScissors {

    boolean gameOver = false;
    HandSign playerMove = null;
    HandSign computerMove;
    int numTrials = 0;
    int numComputerWon = 0;
    int numPlayerWon = 0;
    int numTie = 0;
    IGameMode gameMode;

    public RockPaperScissors(IGameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Vamos a comenzar...");
        while (!gameOver) {
            System.out.printf("%nPiedra-Papel-Tijera");
            System.out.println("\n");
            // jugador
            // uso de do-while loop para manejar entrada inválida
            boolean validInput;
            do {
                System.out.print("\n(Ingresa s para Tijera "
                        + ", p para Papel, t para Piedra, q para salir): ");
                char inChar = in.next().toLowerCase().charAt(0);
                validInput = true;
                switch (inChar) {
                    case 'q':
                        gameOver = true;
                        break;
                    case 's':
                        playerMove = HandSign.SCISSORS;
                        break;
                    case 'p':
                        playerMove = HandSign.PAPER;
                        break;
                    case 't':
                        playerMove = HandSign.ROCK;
                        break;
                    default:
                        System.out.println("Opción inválido, intente otra vez...");
                        validInput = false;
                        break;
                }
            } while (!validInput);
            System.out.println("Tu Turno: "+playerMove);
            if (!gameOver) {

                Game game = play(gameMode, playerMove,
                        new Params(numTie, numComputerWon, numPlayerWon, numTrials));
                System.out.println(game.toString());
                updateStatistics(game);
            }
        }
        System.out.println("-------------------------------------------------\n");
        System.out.printf("%nNúmero de juegos: " + numTrials);
        System.out.printf("\nYo gané  %d(%.2f%%).\n"
                + "Tu ganaste %d(%.2f%%).\n"
                + "Empatamos %d(%.2f%%).%n.",
                numComputerWon, 100.0 * numComputerWon / numTrials,
                numPlayerWon, 100.0 * numPlayerWon / numTrials,
                numTie, 100.0 * numTie / numTrials);
        System.out.println("-------------------------------------------------\n");
        System.out.println("Chauuu! ");
    }

    private void updateStatistics(Game game) {
        numTrials = game.getNumTrials();
        numPlayerWon = game.getNumPlayerWon();
        numTie = game.getNumTie();
        numComputerWon = game.getNumComputerWon();
    }

    private Game play(IGameMode igameMode,
            HandSign playerMove, Params params) {
        return igameMode.proccesGame(playerMove, params);
    }

    public static void main(String[] args) {
        RockPaperScissors paperScissors = new RockPaperScissors(GameMode.LEVEL_NOVICE);
        paperScissors.start();

    }

}
