package softeer2nd.chess;

import softeer2nd.chess.exception.*;
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

    public void move(String source, String target, boolean isWhiteTurn) {
        Position sourcePos = new Position(source);
        Position targetPos = new Position(target);

        verifyChessBoardBound(sourcePos);
        verifyChessBoardBound(targetPos);

        Piece sourcePiece = board.findPiece(sourcePos);
        Piece targetPiece = board.findPiece(targetPos);

        verifyPresentPosition(source, target);
        verifyPieceTurn(isWhiteTurn, sourcePiece);
        verifyEmptyPiece(sourcePiece);
        verifySameTeamOnTarget(sourcePiece, targetPiece);

        Direction direction = sourcePiece.verifyMovePosition(targetPiece);
        List<Position> movePath = sourcePiece.getMovePath(direction, targetPos);

        verifyOtherPieceOnPath(movePath);

        board.changePiece(sourcePiece, targetPiece);
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

    private void verifyPieceTurn(boolean isWhiteTurn, Piece source) {
        if (isWhiteTurn && source.isBlack()) {
            throw new IllegalTurnException("흰색 기물 이동 차례 입니다.");
        }

        if (!isWhiteTurn && source.isWhite()) {
            throw new IllegalTurnException("검은색 기물 이동 차례 입니다.");
        }
    }

    private static void verifyEmptyPiece(Piece sourcePiece) {
        if (sourcePiece.isType(NO_PIECE)) {
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
            Piece foundPiece = board.findPiece(p);
            if (!foundPiece.isType(NO_PIECE)) {
                throw new ExistSameColorPiece("이동 경로에 다른 기물이 존재합니다.");
            }
        }
    }

    public double calculatePoint(Color color) {
        double totalPoint = 0;

        for (int fileNum = 0; fileNum < BOARD_LENGTH; fileNum++) {
            totalPoint += getFilePoint(fileNum, color);
        }

        return totalPoint;
    }

    private double getFilePoint(int fileNum, Color color) {
        double totalPoint = 0;
        List<Piece> file = board.getPiecesByFile(fileNum);

        for (Piece p : file) {
            if (p.isColor(color)) {
                totalPoint += getPiecePoint(p, color, file.indexOf(p), fileNum);
            }
        }
        return totalPoint;
    }

    private double getPiecePoint(Piece piece, Color color, int rankNum, int fileNum) {
        double piecePoint = piece.getType().getDefaultPoint();

        if (piece.isType(PAWN) && existPawn(color, rankNum, fileNum)) {
            piecePoint = 0.5;
        }

        return piecePoint;
    }

    private boolean existPawn(Color color, int rankNum, int fileNum) {
        List<Piece> file = board.getPiecesByFile(fileNum);

        for (Piece p : file) {
            if (p.isType(PAWN) && p.isColor(color) && !p.isRank(rankNum)) {
                return true;
            }
        }

        return false;
    }

    public List<Piece> sortByPointAsc(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : board.getChessBoard()) {
            rank.getRank().stream()
                    .filter(p -> p.isColor(color))
                    .forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> piece.getType().getDefaultPoint()));

        return pieceList;
    }

    public List<Piece> sortByPointDesc(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : board.getChessBoard()) {

            rank.getRank().stream()
                    .filter(p -> p.isColor(color))
                    .forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> -1 * piece.getType().getDefaultPoint()));

        return pieceList;
    }
}
