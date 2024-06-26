package com.example.LibrarySystem.ChessGameSystem.System3.ChessGame;

import com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person.Player;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;
import com.example.LibrarySystem.ChessGameSystem.System3.ChessMoveController_GameView.ChessMoveController;
import com.example.LibrarySystem.ChessGameSystem.System3.Enum.GameStatus;
import com.example.LibrarySystem.ChessGameSystem.System3.Move.Move;
import com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types.Piece;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ChessGame {
    private Player[] players;
    private Chessboard board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;
    private ChessMoveController chessMoveController;

    public ChessGame(Player[] players) {
        this.players = players;
        this.board = new Chessboard(8, 8); // Assuming standard 8x8 chessboard
        this.status = GameStatus.Active;
        this.movesPlayed = new ArrayList<>();
        this.currentTurn = players[0]; // Assuming player 1 starts the game
        this.chessMoveController = new ChessMoveController();
    }

    public boolean isOver() {
        return status != GameStatus.Active;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
        /*
         * 1. start box
         * 2. end box
         * 3. move
         * 4. call makeMove() method
         */

        Box start = board.getBox(startX, startY);
        Box end = board.getBox(endX, endY);
        Piece pieceMoved = start.getPiece();
        Piece pieceKilled = end.getPiece();

        // Check if it's the player's turn
        if (player != currentTurn) {
            return false;
        }

        // Create a move object
        Move move = new Move(start, end, pieceMoved, pieceKilled, player);

        // Validate and make the move
        boolean successfulMove = this.makeMove(move, player);
        if (successfulMove) {
            // Add the move to the list of played moves
            movesPlayed.add(move);
            // Switch to the next player's turn
            switchTurn();
        }

        return successfulMove;
    }

    private boolean makeMove(Move move, Player player) {
        /*
         * 1. Validation of source piece
         * 2. Check whether the color of the piece is white
         * 3. Check if it is a valid move or not
         * 4. Check whether it is a castling move or not
         * 5. Store the move
         */

        Box start = move.getStart();
        Box end = move.getEnd();
        Piece pieceMoved = move.getPieceMoved();
        Piece pieceKilled = move.getPieceKilled();

        // Validate the move
        if (!chessMoveController.validateMove(board, player, start, end)) {
            return false;
        }

        // Make the move
        end.setPiece(pieceMoved);
        start.setPiece(null);

        // Check if the move resulted in a capture
        if (pieceKilled != null) {
            pieceKilled.setKilled(true);
        }

        return true;
    }

    private void switchTurn() {
        currentTurn = (currentTurn == players[0]) ? players[1] : players[0];
    }
}
