package softeer2nd;

import softeer2nd.chess.Board;
import softeer2nd.chess.ChessView;
import softeer2nd.chess.ChessGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        ChessGame chessGame = new ChessGame(board);
        ChessView chessView = new ChessView(board);

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.nextLine();
            if (command.startsWith("start")) {
                startGame(chessView, board);
            } else if (command.startsWith("end")) {
                endGame();
                break;
            } else if (command.startsWith("move")) {
                String[] commands = command.split(" ");
                String source = commands[1];
                String target = commands[2];
                chessGame.move(source, target);
                System.out.println(chessView.showBoard());
            }
        }
    }

    public static void startGame(ChessView chessView, Board board) {
        System.out.println("Start Game!");
        board.initialize();
        System.out.println(chessView.showBoard());
    }

    public static void endGame() {
        System.out.println("End Game!");
    }
}