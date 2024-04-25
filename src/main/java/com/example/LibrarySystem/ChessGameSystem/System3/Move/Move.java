package com.example.LibrarySystem.ChessGameSystem.System3.Move;

import com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person.Player;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types.Piece;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Box start;
    private Box end;
    private Piece pieceKilled;
    private Piece pieceMoved;
    private Player player;
    private boolean castlingMove = false;

    public Move(Box start, Box end, Piece pieceMoved, Piece pieceKilled, Player player) {
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.pieceKilled = pieceKilled;
        this.player = player;
    }
}
