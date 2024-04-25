package com.example.LibrarySystem.ChessGameSystem.System3.ChessMoveController_GameView;

import com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person.Player;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;
import com.example.LibrarySystem.ChessGameSystem.System3.Move.Move;
import com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types.Piece;

public class ChessGameView {
    public void playMove(Chessboard board, Player player, Box start, Box end) {
        Piece piece = start.getPiece();
        Move move = new Move(start, end, piece, end.getPiece(), player);
        // Make the move
        boolean successfulMove = board.makeMove(move, player);
        if (successfulMove) {
            // Update the board view
            board.updateBoard();
            // Display message or perform any other necessary actions
        } else {
            // Display error message or perform any other necessary actions
        }
    }
}
