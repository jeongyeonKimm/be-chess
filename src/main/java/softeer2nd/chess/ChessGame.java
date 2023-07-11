package softeer2nd.chess;

import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.exception.ExistSameColorPiece;
import softeer2nd.chess.exception.InvalidTargetPosition;
import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Color;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.PAWN;

public class ChessGame {

    private Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public void move(String source, String target) {
        if (source.equals(target)) {
            throw new InvalidTargetPosition("현재 위치와 같습니다.");
        }

        Position sourcePos = new Position(source);
        Position targetPos = new Position(target);

        Piece sourcePiece = board.findPiece(sourcePos);
        Piece targetPiece = board.findPiece(targetPos);

        verifyChessBoardBound(targetPiece);
        verifySameTeamOnPath(sourcePiece, targetPiece);

        sourcePiece.verifyMovePosition(targetPiece, this);

        List<Piece> sourcePieceList = new ArrayList<>(board.getChessBoard().get(sourcePos.getY()).getRank());
        sourcePieceList.set(sourcePos.getX(), Blank.createBlank(sourcePos));
        board.getChessBoard().set(sourcePos.getY(), new Rank(sourcePieceList));

        List<Piece> targetPieceList = new ArrayList<>(board.getChessBoard().get(targetPos.getY()).getRank());
        targetPieceList.set(targetPos.getX(), sourcePiece);
        board.getChessBoard().set(targetPos.getY(), new Rank(targetPieceList));
    }

    private void verifyChessBoardBound(Piece target) {
        if (target.getPosition().getX() >= 0 && target.getPosition().getX() < 8 &&
                target.getPosition().getY() >= 0 && target.getPosition().getY() < 8) {
            return;
        }

        throw new BoardOutOfBounds("체스판 밖으로 이동할 수 없습니다.");
    }

    private void verifySameTeamOnPath(Piece source, Piece target) {
        if (source.getColor() == target.getColor()) {
            throw new ExistSameColorPiece("이동하려는 위치에 같은 편의 기물이 있습니다.");
        }
    }

    public double calculatePoint(Color color) {
        double totalPoint = 0;

        if (color == WHITE) {
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, WHITE);
            }
        } else if (color == BLACK){
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, BLACK);
            }
        }

        return totalPoint;
    }

    private double getTotalPoint(int row, Color color) {
        double totalPoint = 0;
        List<Piece> pieces = board.getChessBoard().get(row).getRank();

        for (Piece piece : pieces) {
            if (piece.getColor() == color) {
                totalPoint += getPiecePoint(piece, row, pieces.indexOf(piece));
            }
        }
        return totalPoint;
    }

    private double getPiecePoint(Piece piece, int row, int col) {
        double piecePoint = piece.getType().getDefaultPoint();

        if (piece.getType() == PAWN && existPawn(piece.getColor(), row, col)) {
            piecePoint = 0.5;
        }

        return piecePoint;
    }

    private boolean existPawn(Color color, int row, int col) {
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            Piece piece = board.getChessBoard().get(i).getRank().get(col);
            if (piece.getType() == PAWN && piece.getColor() == color && i != row) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Piece> sortByPointAsc(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : board.getChessBoard()) {
            rank.getRank().stream()
                    .filter(p -> p.getColor() == color)
                    .forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> piece.getType().getDefaultPoint()));

        return pieceList;
    }

    public List<Piece> sortByPointDesc(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : board.getChessBoard()) {

            rank.getRank().stream()
                    .filter(p -> p.getColor() == color)
                    .forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> -1 * piece.getType().getDefaultPoint()));

        return pieceList;
    }
}
