package com.example.LibrarySystem.JigsawPuzzleSystem.System3;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Puzzle {
    private static Puzzle puzzle = null;
    private List<List<Piece>> board;
    private List<Piece> freePieces;

    private Puzzle() {
        board = new ArrayList<>();
        freePieces = new ArrayList<>();
    }

    public static Puzzle getInstance() {
        if (puzzle == null) {
            puzzle = new Puzzle();
        }
        return puzzle;
    }

    public void addPiece(Piece piece) {
        freePieces.add(piece);
    }

    public boolean insertPiece(Piece piece, int row, int column) {
        if (board.size() <= row) {
            for (int i = board.size(); i <= row; i++) {
                board.add(new ArrayList<>());
            }
        }

        List<Piece> rowList = board.get(row);
        if (rowList.size() <= column) {
            for (int i = rowList.size(); i <= column; i++) {
                rowList.add(null);
            }
        }

        if (rowList.get(column) != null) {
            return false; // Position already occupied
        }

        if (canPlace(piece, row, column)) {
            rowList.set(column, piece);
            freePieces.remove(piece);
            return true;
        }

        return false;
    }

    private boolean canPlace(Piece piece, int row, int column) {
        Piece top = (row > 0) ? board.get(row - 1).get(column) : null;
        Piece left = (column > 0) ? board.get(row).get(column - 1) : null;

        if (top != null && !top.fitsWith(piece, 2)) {
            return false;
        }

        if (left != null && !left.fitsWith(piece, 1)) {
            return false;
        }

        return true;
    }
}
