package com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types;

import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        int deltaX = Math.abs(startX - endX);
        int deltaY = Math.abs(startY - endY);

        // Knight moves in an L-shape: two squares in one direction and one square in a
        // perpendicular direction
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }

}
