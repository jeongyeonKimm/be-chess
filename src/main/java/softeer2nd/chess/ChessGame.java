package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.PAWN;

public class ChessGame {

    private Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public Piece findPiece(String location) {
        Position position = new Position(location);

        return board.getChessBoard().get(position.getY()).getRank().get(position.getX());
    }

    public void move(String source, String target) {
        Position sourcePos = new Position(source);
        Position targetPos = new Position(target);

        Piece findPiece = findPiece(source);
        List<Piece> r = new ArrayList<>(board.getChessBoard().get(targetPos.getY()).getRank());
        r.set(targetPos.getX(), Piece.createPiece(findPiece.getColor(), findPiece.getType(), targetPos));
        board.getChessBoard().set(targetPos.getY(), new Rank(r));

        r = new ArrayList<>(board.getChessBoard().get(sourcePos.getY()).getRank());
        r.set(sourcePos.getX(), Piece.createBlank(sourcePos));
        board.getChessBoard().set(sourcePos.getY(), new Rank(r));
    }

    public double calculatePoint(Piece.Color color) {
        double totalPoint = 0;

        if (color.equals(WHITE)) {
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, WHITE);
            }
        } else if (color.equals(BLACK)){
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, BLACK);
            }
        }

        return totalPoint;
    }

    private double getTotalPoint(int row, Piece.Color color) {
        double totalPoint = 0;
        List<Piece> pieces = board.getChessBoard().get(row).getRank();

        for (Piece piece : pieces) {
            if (piece.getColor().equals(color)) {
                totalPoint += getPiecePoint(piece, row, pieces.indexOf(piece));
            }
        }
        return totalPoint;
    }

    private double getPiecePoint(Piece piece, int row, int col) {
        double piecePoint = piece.getType().getDefaultPoint();

        if (piece.getType().equals(PAWN) && existPawn(piece.getColor(), row, col)) {
            piecePoint = 0.5;
        }

        return piecePoint;
    }

    private boolean existPawn(Piece.Color color, int row, int col) {
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            Piece piece = board.getChessBoard().get(i).getRank().get(col);
            if (piece.getType().equals(PAWN) && piece.getColor().equals(color) && i != row) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Piece> sortAscByPoint(Piece.Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : board.getChessBoard()) {
            rank.getRank().stream().filter(p -> p.getColor().equals(color)).forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> piece.getType().getDefaultPoint()));

        return pieceList;
    }

    public List<Piece> sortDescByPoint(Piece.Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : board.getChessBoard()) {
            rank.getRank().stream().filter(p -> p.getColor().equals(color)).forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> -piece.getType().getDefaultPoint()));

        return pieceList;
    }
}
