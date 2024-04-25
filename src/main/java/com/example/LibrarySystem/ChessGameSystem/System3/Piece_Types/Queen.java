package com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types;

import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;

public class Queen extends Piece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // Queen can move horizontally, vertically, or diagonally
        if (startX == endX || startY == endY || Math.abs(startX - endX) == Math.abs(startY - endY)) {
            // Check if there are any pieces blocking its path
            if (startX == endX) {
                int direction = (endY - startY) > 0 ? 1 : -1;
                for (int y = startY + direction; y != endY; y += direction) {
                    if (board.getBox(startX, y).getPiece() != null) {
                        // Path is blocked
                        return false;
                    }
                }
            } else if (startY == endY) {
                int direction = (endX - startX) > 0 ? 1 : -1;
                for (int x = startX + direction; x != endX; x += direction) {
                    if (board.getBox(x, startY).getPiece() != null) {
                        // Path is blocked
                        return false;
                    }
                }
            } else {
                int xDirection = (endX - startX) > 0 ? 1 : -1;
                int yDirection = (endY - startY) > 0 ? 1 : -1;
                int currentX = startX + xDirection;
                int currentY = startY + yDirection;
                while (currentX != endX && currentY != endY) {
                    if (board.getBox(currentX, currentY).getPiece() != null) {
                        // Path is blocked
                        return false;
                    }
                    currentX += xDirection;
                    currentY += yDirection;
                }
            }
            return true;
        }

        return false;
    }
}
