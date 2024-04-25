package com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types;

import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;

public class King extends Piece {
    private boolean castlingDone = false;

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        // Check if the move is within one square in any direction
        int xMovement = Math.abs(start.getX() - end.getX());
        int yMovement = Math.abs(start.getY() - end.getY());

        // King can move one square in any direction
        return xMovement <= 1 && yMovement <= 1;
    }
}
