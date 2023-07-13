package softeer2nd.chess;

import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.ExistSameColorPiece;
import softeer2nd.chess.exception.InvalidTargetPosition;
import softeer2nd.chess.pieces.Blank;
import softeer2nd.chess.pieces.Color;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.Board.BOARD_LENGTH;
import static softeer2nd.chess.pieces.Type.NO_PIECE;
import static softeer2nd.chess.pieces.Type.PAWN;

public class ChessGame {

    private final Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public void move(String source, String target) {
        Position sourcePos = new Position(source);
        Position targetPos = new Position(target);

        verifyPresentPosition(source, target);

        Piece sourcePiece = board.findPiece(sourcePos);
        Piece targetPiece = board.findPiece(targetPos);

        verifyEmptyPiece(sourcePiece);
        verifySameTeamOnTarget(sourcePiece, targetPiece);

        verifyChessBoardBound(sourcePos);
        verifyChessBoardBound(targetPos);

        Direction direction = sourcePiece.verifyMovePosition(targetPiece);
        List<Position> movePath = sourcePiece.getMovePath(direction, targetPos);

        verifyOtherPieceOnPath(movePath);

        sourcePiece.setNewPosition(targetPos);
        board.getChessBoard().get(sourcePos.getY()).setPiece(sourcePos, Blank.createBlank(sourcePos));
        board.getChessBoard().get(targetPos.getY()).setPiece(targetPos, sourcePiece);
    }

    private void verifyPresentPosition(String source, String target) {
        if (source.equals(target)) {
            throw new InvalidTargetPosition("현재 위치와 같습니다.");
        }
    }

    private void verifySameTeamOnTarget(Piece source, Piece target) {
        if (target.getColor() == source.getColor()) {
            throw new ExistSameColorPiece("이동하려는 위치에 같은 편 기물이 존재합니다.");
        }
    }

    private static void verifyEmptyPiece(Piece sourcePiece) {
        if (sourcePiece.getType() == NO_PIECE) {
            throw new EmptyPieceException("source 위치에 기물이 없습니다.");
        }
    }

    private void verifyChessBoardBound(Position target) {
        if (target.getX() >= 0 && target.getX() < BOARD_LENGTH &&
                target.getY() >= 0 && target.getY() < BOARD_LENGTH) {
            return;
        }

        throw new BoardOutOfBounds("체스판 밖으로 이동할 수 없습니다.");
    }

    private void verifyOtherPieceOnPath(List<Position> movePath) {
        for (Position p : movePath) {
            if (board.findPiece(p).getType() != NO_PIECE) {
                throw new ExistSameColorPiece("이동 경로에 다른 기물이 존재합니다.");
            }
        }
    }

    public double calculatePoint(Color color) {
        double totalPoint = 0;

        for (int i = 0; i < BOARD_LENGTH; i++) {
            totalPoint += getTotalPoint(i, color);
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
        for (int i = 0; i < BOARD_LENGTH; i++) {
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
