package com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types;

import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // Rook can move horizontally or vertically
        if (startX == endX || startY == endY) {
            // Check if there are any pieces blocking its path
            if (startX == endX) {
                int direction = (endY - startY) > 0 ? 1 : -1;
                for (int y = startY + direction; y != endY; y += direction) {
                    if (board.getBox(startX, y).getPiece() != null) {
                        // Path is blocked
                        return false;
                    }
                }
            } else {
                int direction = (endX - startX) > 0 ? 1 : -1;
                for (int x = startX + direction; x != endX; x += direction) {
                    if (board.getBox(x, startY).getPiece() != null) {
                        // Path is blocked
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

}
