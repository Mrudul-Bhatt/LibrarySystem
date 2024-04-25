package com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types;

import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;

public class Pawn extends Piece {

    private boolean isFirstMove;

    public Pawn(boolean white) {
        super(white);
        isFirstMove = true;
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        int direction = isWhite() ? 1 : -1;

        // Pawn can move forward one square
        if (startY == endY && startX + direction == endX && end.getPiece() == null) {
            isFirstMove = false;
            return true;
        }

        // Pawn can move forward two squares on its first move
        if (startY == endY && startX + 2 * direction == endX && isFirstMove && end.getPiece() == null) {
            isFirstMove = false;
            return true;
        }

        // Pawn can capture diagonally
        if (Math.abs(startX - endX) == 1 && startY + direction == endY && end.getPiece() != null) {
            isFirstMove = false;
            return true;
        }

        // Pawn cannot move in any other way
        return false;
    }
}
