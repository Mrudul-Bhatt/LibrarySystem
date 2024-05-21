package com.example.LibrarySystem.JigsawPuzzleSystem.System3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Puzzle puzzle = Puzzle.getInstance();

        // Example pieces
        Piece cornerPiece = new Piece(
                new Side(Edge.FLAT, ""),
                new Side(Edge.INDENTATION, "curvature1"),
                new Side(Edge.INDENTATION, "curvature2"),
                new Side(Edge.FLAT, "")
        );

        Piece edgePiece = new Piece(
                new Side(Edge.INDENTATION, "curvature1"),
                new Side(Edge.INDENTATION, "curvature3"),
                new Side(Edge.EXTRUSION, "curvature2"),
                new Side(Edge.FLAT, "")
        );

        Piece middlePiece = new Piece(
                new Side(Edge.INDENTATION, "curvature4"),
                new Side(Edge.INDENTATION, "curvature5"),
                new Side(Edge.EXTRUSION, "curvature6"),
                new Side(Edge.EXTRUSION, "curvature7")
        );

        puzzle.addPiece(cornerPiece);
        puzzle.addPiece(edgePiece);
        puzzle.addPiece(middlePiece);

        PuzzleSolver solver = new PuzzleSolver();
        solver.matchPieces(puzzle);

        // Output the board state
        for (List<Piece> row : puzzle.getBoard()) {
            for (Piece piece : row) {
                if (piece != null) {
                    System.out.print("P ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
