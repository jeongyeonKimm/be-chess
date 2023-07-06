package softeer2nd;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.nextLine();
            if (command.startsWith("start")) {
                startGame(board);
            } else if (command.startsWith("end")) {
                endGame();
                break;
            } else if (command.startsWith("move")) {
                String[] commands = command.split(" ");
                String source = commands[1];
                String target = commands[2];
                board.move(source, target);
                System.out.println(board.showBoard());
            }
        }
    }

    public static void startGame(Board board) {
        System.out.println("Start Game!");
        board.initialize();
        // System.out.println(board.print());
        System.out.println(board.showBoard());
    }

    public static void endGame() {
        System.out.println("End Game!");
    }
}