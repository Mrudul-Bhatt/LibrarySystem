package com.example.LibrarySystem.ChessGameSystem.System3.ChessMoveController_GameView;

import com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person.Player;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;
import com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types.Piece;

public class ChessMoveController {

    public boolean validateMove(Chessboard board, Player player, Box start, Box end) {
        Piece piece = start.getPiece();

        // Check if the start box contains a piece and it belongs to the player
        if (piece == null || piece.isWhite() != player.isWhiteSide()) {
            return false;
        }

        // Check if the move is valid for the piece
        if (!piece.canMove(board, start, end)) {
            return false;
        }

        // Check if the end box is empty or contains a piece of the opponent
        Piece targetPiece = end.getPiece();
        if (targetPiece != null && targetPiece.isWhite() == player.isWhiteSide()) {
            return false;
        }

        return true;
    }

}
