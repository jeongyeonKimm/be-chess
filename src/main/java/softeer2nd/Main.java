package softeer2nd;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("start")) {
                startGame(board);
            } else if (command.equals("end")) {
                endGame();
                break;
            }
        }
    }

    public static void startGame(Board board) {
        System.out.println("Start Game!");
        board.initialize();
        System.out.println(board.print());
    }

    public static void endGame() {
        System.out.println("End Game!");
    }
}