package com.example.LibrarySystem.ChessGameSystem.System3;

import com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person.Player;
import com.example.LibrarySystem.ChessGameSystem.System3.ChessGame.ChessGame;

public class Main {
    public static void main(String[] args) {
        // Create players
        Player[] players = new Player[2];
        players[0] = new Player("Player 1", true);
        players[1] = new Player("Player 2", false);

        // Create chess game
        ChessGame chessGame = new ChessGame(players);

        // Simulate moves
        chessGame.playerMove(players[0], 1, 0, 3, 0); // Player 1 moves pawn
        chessGame.playerMove(players[1], 6, 0, 4, 0); // Player 2 moves pawn
        chessGame.playerMove(players[0], 0, 1, 2, 2); // Player 1 moves knight

        // Display current state of the chessboard
        chessGame.getBoard().printBoard();
    }
}
