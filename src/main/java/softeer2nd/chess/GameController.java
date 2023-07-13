package softeer2nd.chess;

import softeer2nd.chess.exception.ChessGameException;
import softeer2nd.chess.pieces.Color;

import java.util.Scanner;

public class GameController {

    private final Board board = new Board();
    private final ChessGame chessGame = new ChessGame(board);
    private final ChessView chessView = new ChessView(board);

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            try {
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
            } catch (ChessGameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startGame(ChessView chessView, Board board) {
        System.out.println("Start Game!");
        board.initialize();
        System.out.println(chessView.showBoard());
    }

    public void endGame() {
        System.out.println("White Score: " + chessGame.calculatePoint(Color.WHITE));
        System.out.println("Black Score: " + chessGame.calculatePoint(Color.BLACK));
        System.out.println("End Game!");
    }
}
