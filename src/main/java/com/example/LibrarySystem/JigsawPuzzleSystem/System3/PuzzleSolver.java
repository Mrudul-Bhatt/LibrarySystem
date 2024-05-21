package com.example.LibrarySystem.JigsawPuzzleSystem.System3;

public class PuzzleSolver {
    public Puzzle matchPieces(Puzzle puzzle) {
        for (Piece piece : puzzle.getFreePieces()) {
            for (int row = 0; row < puzzle.getBoard().size(); row++) {
                for (int column = 0; column < puzzle.getBoard().get(row).size(); column++) {
                    if (puzzle.insertPiece(piece, row, column)) {
                        break;
                    }
                }
            }
        }
        return puzzle;
    }

}
